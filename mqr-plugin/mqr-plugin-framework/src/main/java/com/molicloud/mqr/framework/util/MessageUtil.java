package com.molicloud.mqr.framework.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.molicloud.mqr.plugin.core.PluginResult;
import com.molicloud.mqr.plugin.core.message.MessageBuild;
import com.molicloud.mqr.plugin.core.message.make.Ats;
import com.molicloud.mqr.plugin.core.message.make.Expression;
import com.molicloud.mqr.plugin.core.message.make.Img;
import com.molicloud.mqr.plugin.core.message.make.Text;
import com.molicloud.mqr.plugin.core.message.single.Share;
import lombok.experimental.UtilityClass;
import net.mamoe.mirai.contact.ContactList;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.contact.Member;
import net.mamoe.mirai.message.data.*;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 消息构建工具类
 *
 * @author feitao yyimba@qq.com
 * @since 2020/11/12 2:44 下午
 */
@UtilityClass
public class MessageUtil {

    /**
     * 转换PluginResult的data字段为QQ消息<br/>
     *
     * 仅处理对话消息类型的data
     *
     * @see PluginResult#getMessage()
     *
     * @param pluginResultData
     * @return
     */
    public Message convertMessage(Object pluginResultData) {
        if (pluginResultData instanceof String) {
            return new PlainText(String.valueOf(pluginResultData));
        } else if (pluginResultData instanceof Text) {
            return new PlainText(((Text)pluginResultData).getContent());
        } else if (pluginResultData instanceof Share) {
            return MessageUtil.buildShareMessage((Share) pluginResultData);
        } else if (pluginResultData instanceof Expression) {
            return MessageUtil.buildFaceMessage((Expression) pluginResultData);
        }
        return null;
    }

    /**
     * 转换PluginResult的data字段为QQ消息<br/>
     *
     * 处理好友消息
     *
     * @param pluginResultData
     * @param friend
     * @return
     */
    public Message convertFriendMessage(Object pluginResultData, Friend friend) {
        Message message = convertMessage(pluginResultData);
        if (message == null) {
            if (pluginResultData instanceof Img) {
                return buildImageMessage(friend, ((Img) pluginResultData).getFileResource());
            } else if (pluginResultData instanceof MessageBuild) {
                return buildFriendSrcMessage((MessageBuild) pluginResultData, friend);
            }
        }
        return message;
    }

    /**
     * 转换PluginResult的data字段为QQ消息<br/>
     *
     * 处理群消息
     *
     * @see PluginResult#getMessage()
     *
     * @param pluginResultData
     * @return
     */
    public Message convertGroupMessage(Object pluginResultData, Group group) {
        Message message = convertMessage(pluginResultData);
        if (message == null) {
            if (pluginResultData instanceof Ats) {
                return buildGroupAtMessage(group, (Ats) pluginResultData);
            } else if (pluginResultData instanceof Img) {
                return buildImageMessage(group, ((Img) pluginResultData).getFileResource());
            } else if (pluginResultData instanceof MessageBuild) {
                return buildGroupSrcMessage((MessageBuild) pluginResultData, group);
            }
        }
        return message;
    }

    /**
     * 构建插件返回的群原生消息
     *
     * @param messageBuild
     * @param group
     * @return
     */
    private MessageChain buildGroupSrcMessage(MessageBuild messageBuild, Group group) {
        MessageChainBuilder messageChainBuilder = new MessageChainBuilder();
        messageBuild.getMakes().forEach(make -> {
            if (make instanceof Text) {
                messageChainBuilder.append(((Text) make).getContent());
            } else if (make instanceof Img) {
                messageChainBuilder.append(buildImageMessage(group, ((Img) make).getFileResource()));
            } else if (make instanceof Ats) {
                messageChainBuilder.append(buildGroupAtMessage(group, (Ats) make));
            } else if (make instanceof Expression) {
                messageChainBuilder.append(buildFaceMessage((Expression) make));
            }
        });
        return messageChainBuilder.build();
    }

    /**
     * 构建插件返回的好友原生消息
     *
     * @param messageBuild
     * @param friend
     * @return
     */
    private MessageChain buildFriendSrcMessage(MessageBuild messageBuild, Friend friend) {
        MessageChainBuilder messageChainBuilder = new MessageChainBuilder();
        messageBuild.getMakes().forEach(make -> {
            if (make instanceof Text) {
                messageChainBuilder.append(((Text) make).getContent());
            } else if (make instanceof Img) {
                messageChainBuilder.append(buildImageMessage(friend, ((Img) make).getFileResource()));
            } else if (make instanceof Expression) {
                messageChainBuilder.append(buildFaceMessage((Expression) make));
            }
        });
        return messageChainBuilder.build();
    }

    /**
     * 构建分享消息
     *
     * @param share
     * @return
     */
    private ServiceMessage buildShareMessage(Share share) {
        return ServiceMessage.Templates.share(share.getUrl(), share.getTitle(), share.getContent(), share.getCoverUrl());
    }

    /**
     * 构建群「@」消息
     *
     * @param group
     * @param ats
     * @return
     */
    private MessageChain buildGroupAtMessage(Group group, Ats ats) {
        List<String> mids = ats.getMids();
        if (CollUtil.isNotEmpty(mids)) {
            ContactList<Member> memberContactList = group.getMembers();
            List<Member> memberList = mids.stream().map(mid -> memberContactList.get(Long.parseLong(mid))).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(memberList)) {
                List<At> atList = memberList.stream().map(member -> new At(member)).collect(Collectors.toList());
                MessageChainBuilder messageChainBuilder = new MessageChainBuilder();
                atList.stream().forEach(at -> messageChainBuilder.append(at).append(" "));
                if (StrUtil.isNotBlank(ats.getContent())) {
                    messageChainBuilder.append(ats.getContent());
                }
                return messageChainBuilder.build();
            }
        }
        return null;
    }

    /**
     * 构建图片消息
     *
     * @param sender Group Or Friend 对象
     * @param image
     * @return
     */
    private Image buildImageMessage(Object sender, Object image) {
        if (image instanceof File) {
            return sender instanceof Group ?
                    ((Group) sender).uploadImage((File) image) :
                    ((Friend) sender).uploadImage((File) image);
        } else if (image instanceof URL) {
            return sender instanceof Group ?
                    ((Group) sender).uploadImage((URL) image) :
                    ((Friend) sender).uploadImage((URL) image);
        } else if (image instanceof InputStream) {
            return sender instanceof Group ?
                    ((Group) sender).uploadImage((InputStream) image) :
                    ((Friend) sender).uploadImage((InputStream) image);
        }
        return null;
    }

    /**
     * 构建表情消息
     *
     * @param expression
     * @return
     */
    private Face buildFaceMessage(Expression expression) {
        return new Face(expression.getFaceId());
    }
}
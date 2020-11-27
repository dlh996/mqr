package com.molicloud.mqr.plugin.core.define;

/**
 * 「原生表情」定义
 *
 * @author wisp-x wisp-x@qq.com
 * @since 2020/11/27 2:52 下午
 */
public interface FaceDef {

    int unknown = 0xff;
    int jingya = 0; // [惊讶]
    int piezui = 1; // [撇嘴]
    int se = 2; // [色]
    int fadai = 3; // [发呆]
    int deyi = 4; // [得意]
    int liulei = 5; // [流泪]
    int haixiu = 6; // [害羞]
    int bizui = 7; // [闭嘴]
    int shui = 8; // [睡]
    int daku = 9; // [大哭]
    int ganga = 10; // [尴尬]
    int fanu = 11; // [发怒]
    int tiaopi = 12; // [调皮]
    int ciya = 13; // [呲牙]
    int weixiao = 14; // [微笑]
    int nanguo = 15; // [难过]
    int ku = 16; // [酷]
    int zhuakuang = 18; // [抓狂]
    int tu = 19; // [吐]
    int touxiao = 20; // [偷笑]
    int keai = 21; // [可爱]
    int baiyan = 22; // [白眼]
    int aoman = 23; // [傲慢]
    int ji_e = 24; // [饥饿]
    int kun = 25; // [困]
    int jingkong = 26; // [惊恐]
    int liuhan = 27; // [流汗]
    int hanxiao = 28; // [憨笑]
    int dabing = 29; // [大病]
    int fendou = 30; // [奋斗]
    int zhouma = 31; // [咒骂]
    int yiwen = 32; // [疑问]
    int yun = 34; // [晕]
    int zhemo = 35; // [折磨]
    int shuai = 36; // [衰]
    int kulou = 37; // [骷髅]
    int qiaoda = 38; // [敲打]
    int zaijian = 39; // [再见]
    int fadou = 41; // [发抖]
    int aiqing = 42; // [爱情]
    int tiaotiao = 43; // [跳跳]
    int zhutou = 46; // [猪头]
    int yongbao = 49; // [拥抱]
    int dan_gao = 53; // [蛋糕]
    int shandian = 54; // [闪电]
    int zhadan = 55; // [炸弹]
    int dao = 56; // [刀]
    int zuqiu = 57; // [足球]
    int bianbian = 59; // [便便]
    int kafei = 60; // [咖啡]
    int fan = 61; // [饭]
    int meigui = 63; // [玫瑰]
    int diaoxie = 64; // [凋谢]
    int aixin = 66; // [爱心]
    int xinsui = 67; // [心碎]
    int liwu = 69; // [礼物]
    int taiyang = 74; // [太阳]
    int yueliang = 75; // [月亮]
    int qiang = 76; // [强]
    int ruo = 77; // [弱]
    int woshou = 78; // [握手]
    int shengli = 79; // [胜利]
    int feiwen = 85; // [飞吻]
    int naohuo = 86; // [恼火]
    int xigua = 89; // [西瓜]
    int lenghan = 96; // [冷汗]
    int cahan = 97; // [擦汗]
    int koubi = 98; // [抠鼻]
    int guzhang = 99; // [鼓掌]
    int qiudale = 100; // [糗大了]
    int huaixiao = 101; // [坏笑]
    int zuohengheng = 102; // [左哼哼]
    int youhengheng = 103; // [右哼哼]
    int haqian = 104; // [哈欠]
    int bishi = 105; // [鄙视]
    int weiqu = 106; // [委屈]
    int kuaikule = 107; // [快哭了]
    int yinxian = 108; // [阴险]
    int qinqin = 109; // [亲亲]
    int xia = 110; // [吓]
    int kelian = 111; // [可怜]
    int caidao = 112; // [菜刀]
    int pijiu = 113; // [啤酒]
    int lanqiu = 114; // [篮球]
    int pingpang = 115; // [乒乓]
    int shiai = 116; // [示爱]
    int piaochong = 117; // [瓢虫]
    int baoquan = 118; // [抱拳]
    int gouyin = 119; // [勾引]
    int quantou = 120; // [拳头]
    int chajin = 121; // [差劲]
    int aini = 122; // [爱你]
    int bu = 123; // [NO]
    int hao = 124; // [OK]
    int zhuanquan = 125; // [转圈]
    int ketou = 126; // [磕头]
    int huitou = 127; // [回头]
    int tiaosheng = 128; // [跳绳]
    int huishou = 129; // [挥手]
    int jidong = 130; // [激动]
    int jiewu = 131; // [街舞]
    int xianwen = 132; // [献吻]
    int zuotaiji = 133; // [左太极]
    int youtaiji = 134; // [右太极]
    int shuangxi = 136; // [双喜]
    int bianpao = 137; // [鞭炮]
    int denglong = 138; // [灯笼]
    int facai = 139; // [发财]
    int K_ge = 140; // [K歌]
    int gouwu = 141; // [购物]
    int youjian = 142; // [邮件]
    int shuai_qi = 143; // [帅气]
    int hecai = 144; // [喝彩]
    int qidao = 145; // [祈祷]
    int baojin = 146; // [爆筋]
    int bangbangtang = 147; // [棒棒糖]
    int he_nai = 148; // [喝奶]
    int xiamian = 149; // [下面]
    int xiangjiao = 150; // [香蕉]
    int feiji = 151; // [飞机]
    int kaiche = 152; // [开车]
    int gaotiezuochetou = 153; // [高铁左车头]
    int chexiang = 154; // [车厢]
    int gaotieyouchetou = 155; // [高铁右车头]
    int duoyun = 156; // [多云]
    int xiayu = 157; // [下雨]
    int chaopiao = 158; // [钞票]
    int xiongmao = 159; // [熊猫]
    int dengpao = 160; // [灯泡]
    int fengche = 161; // [风车]
    int naozhong = 162; // [闹钟]
    int dasan = 163; // [打伞]
    int caiqiu = 164; // [彩球]
    int zuanjie = 165; // [钻戒]
    int shafa = 166; // [沙发]
    int zhijin = 167; // [纸巾]
    int yao = 168; // [药]
    int shouqiang = 169; // [手枪]
    int qingwa = 170; // [青蛙]
    int hexie = 184; // [河蟹]
    int yangtuo = 185; // [羊驼]
    int youling = 187; // [幽灵]
    int dan = 188; // [蛋]
    int juhua = 190; // [菊花]
    int hongbao = 192; // [红包]
    int daxiao = 193; // [大笑]
    int bukaixin = 194; // [不开心]
    int lengmo = 197; // [冷漠]
    int e = 198; // [呃]
    int haobang = 199; // [好棒]
    int baituo = 200; // [拜托]
    int dianzan = 201; // [点赞]
    int wuliao = 202; // [无聊]
    int tuolian = 203; // [托脸]
    int chi = 204; // [吃]
    int songhua = 205; // [送花]
    int haipa = 206; // [害怕]
    int huachi = 207; // [花痴]
    int xiaoyanger = 208; // [小样儿]
    int biaolei = 210; // [飙泪]
    int wobukan = 211; // [我不看]
    int bobo = 214; // [啵啵]
    int hulian = 215; // [糊脸]
    int paitou = 216; // [拍头]
    int cheyiche = 217; // [扯一扯]
    int tianyitian = 218; // [舔一舔]
    int cengyiceng = 219; // [蹭一蹭]
    int zhuaizhatian = 220; // [拽炸天]
    int dingguagua = 221; // [顶呱呱]
    int baobao = 222; // [抱抱]
    int baoji = 223; // [暴击]
    int kaiqiang = 224; // [开枪]
    int liaoyiliao = 225; // [撩一撩]
    int paizhuo = 226; // [拍桌]
    int paishou = 227; // [拍手]
    int gongxi = 228; // [恭喜]
    int ganbei = 229; // [干杯]
    int chaofeng = 230; // [嘲讽]
    int heng = 231; // [哼]
    int foxi = 232; // [佛系]
    int qiaoyiqioa = 233; // [敲一敲]
    int jingdai = 234; // [惊呆]
    int chandou = 235; // [颤抖]
    int kentou = 236; // [啃头]
    int toukan = 237; // [偷看]
    int shanlian = 238; // [扇脸]
    int yuanliang = 239; // [原谅]
    int penlian = 240; // [喷脸]
    int shengrikuaile = 241; // [生日快乐]
    int touzhuangji = 242; // [头撞击]
    int shuaitou = 243; // [甩头]
    int rengou = 244; // [扔狗]
    int bishengjiayou = 245; // [必胜加油]
    int jiayoubaobao = 246; // [加油抱抱]
    int kouzhaohuti = 247; // [口罩护体]

}
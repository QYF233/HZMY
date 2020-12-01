/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : hzmy

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 01/12/2020 13:17:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id编号',
  `art_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `art_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `art_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文章内容',
  `art_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章封面图',
  `art_time` datetime(0) NULL DEFAULT NULL COMMENT '文章发表时间',
  `art_plate_id` int NULL DEFAULT NULL COMMENT '文章所属板块',
  `art_file_id` int NULL DEFAULT NULL COMMENT '附件id',
  `art_operator_id` int NULL DEFAULT NULL COMMENT '操作管理员id',
  `art_top` int NULL DEFAULT 0 COMMENT '是否置顶：0-不置顶，1-置顶',
  `art_del_state` int NULL DEFAULT 0 COMMENT '删除',
  `art_sight` int NULL DEFAULT 0 COMMENT '浏览次数',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  INDEX `type_id`(`art_plate_id`) USING BTREE,
  INDEX `art_operator_id`(`art_operator_id`) USING BTREE,
  INDEX `art_file_id`(`art_file_id`) USING BTREE,
  INDEX `index_name`(`id`) USING BTREE,
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`art_plate_id`) REFERENCES `plate` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`art_operator_id`) REFERENCES `sys_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `article_ibfk_3` FOREIGN KEY (`art_file_id`) REFERENCES `file` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '我校学生陈龙获浙江省高职高专院校国家奖学金特别评审奖推荐资格', '杨晓光', '10月29日下午，2020年浙江省高职高专院校国家奖学金特别评选大会在浙江旅游职业学院隆重举行。本次评选大会由浙江省教育厅、财政厅主办，浙江省教育发展中心、浙江旅游职业学院承办。全省各高职院校共15名候选人入围此次评选，来自全省高校的200多名师生代表现场观摩，数十万人通过网络直播在线观看。本次大会的评委由专家评委和大众评委组成，实行差额评选，按最后得分高低推选出10名学生获得国家奖学金省级特别推荐资格。我校信息工程学院软件1811班陈龙同学通过推荐视频、个人展示，在全省高职院校推荐的众多候选人中脱颖而出，荣获浙江省高职高专院校国家奖学金特别评选推荐资格，全省高职院校仅有10位学生获此殊荣。据了解，浙江省在全国范围内率先探索组织国家奖学金特别评选活动，并在去年首创高职高专院校国家奖学金特别评选大会，目的是为了进一步提升职业教育吸引力，激励职业院校学生勤奋学习、勇于实践、提升技能水平，树立一批奋发向上的优秀学生典型，进一步打造我省高校资助文化品牌。本次评选，我校学子能在众多选手中脱颖而出，也进一步彰显了我校在育人方面所取得的成效。', '1.jpg,2.jpg', '2020-10-12 00:00:00', 1, NULL, 1, 0, 0, 2);
INSERT INTO `article` VALUES (2, '学校召开国家社科基金申报专题培训会', '作者', '为推动我校国家社科基金项目申报工作的新局面，指导教师掌握高水平项目申报要领与技巧，11月20日下午,学校邀请省社科联党组成员、副主席，浙江工商大学范钧教授，来校进行国家社科基金项目申报专题培训会。会议由校长徐时清主持，各二级学院、部门负责人及有意愿申报国家社科基金的老师共三十余人参加。\r\n\r\n培训会上，校长徐时清简要介绍了我校国家社科基金申报的有关情况，他指出学校高度重视国家社科基金申报工作，希望与会教师认真学习申报技巧，尽早实现国家社科基金申报的突破。范钧教授结合自身申报国家社科基金的实例，从组织层面、论文选题、研究创新等方面系统介绍了国家社科基金申报的要点，同时还结合实例对申报书的格式、内容等细节进行了具体指导。与会教师也就自身在申报过程中遇到的具体问题与范钧教授进行了交流。\r\n\r\n本次培训会的召开，是学校高度重视高等级项目申报的具体体现，今后学校还将通过各种形式对老师们在各级各类项目申报中遇到的问题进行具体指导。', '2.jpg', '2020-10-01 00:00:00', 3, NULL, 1, 0, 0, 5);
INSERT INTO `article` VALUES (3, '我校学生陈龙获浙江省高职高专院校国家奖学金特别评审奖推荐资格', '曾巧灵/', '2020年11月23', '2.jpg', '2020-10-02 00:00:00', 1, NULL, 1, 0, 0, 4);
INSERT INTO `article` VALUES (4, '上个周末，杭职院这群师生收获耕耘两手抓', '作者', '10月29日下午，2020年浙江省高职高专院校国家奖学金特别评选大会在浙江旅游职业学院隆重举行。本次评选大会由浙江省教育厅、财政厅主办，浙江省教育发展中心、浙江旅游职业学院承办。全省各高职院校共15名候选人入围此次评选，来自全省高校的200多名师生代表现场观摩，数十万人通过网络直播在线观看。本次大会的评委由专家评委和大众评委组成，实行差额评选，按最后得分高低推选出10名学生获得国家奖学金省级特别推荐资格。我校信息工程学院软件1811班陈龙同学通过推荐视频、个人展示，在全省高职院校推荐的众多候选人中脱颖而出，荣获浙江省高职高专院校国家奖学金特别评选推荐资格，全省高职院校仅有10位学生获此殊荣。据了解，浙江省在全国范围内率先探索组织国家奖学金特别评选活动，并在去年首创高职高专院校国家奖学金特别评选大会，目的是为了进一步提升职业教育吸引力，激励职业院校学生勤奋学习、勇于实践、提升技能水平，树立一批奋发向上的优秀学生典型，进一步打造我省高校资助文化品牌。本次评选，我校学子能在众多选手中脱颖而出，也进一步彰显了我校在育人方面所取得的成效。', '2.jpg', '2020-10-03 00:00:00', 3, NULL, 1, 0, 0, 3);
INSERT INTO `article` VALUES (5, '信工院迈新社开展办公室软件应用培训', '章航浦 ', '11月20日，浙江省高等教育学会高校校园传媒分会在浙江广厦职业技术大学举行2020年年会。会上表彰了2019年度浙江省高校校报好新闻奖。经浙江省新闻工作者协会、浙江省高等教育学会高校校园传媒分会评审，2019年度浙江省高校好新闻作品共评出消息类、通讯类、言论类、新闻图片类、版面类、微信微博类一、二、三等奖作品240篇（件），其中高职高专院校共69篇（件）作品获奖。我校4项校报作品获2019年度浙江省高校校报好新闻奖。', '2.jpg', '2020-10-04 00:00:00', 4, NULL, 1, 0, 0, 3);
INSERT INTO `article` VALUES (6, '商贸旅游学院举办“清廉文化建设”辩论赛决赛', '作者', '雄辩滔滔，舌战群儒。11月23日晚，商贸在图书馆报告厅举办了“清廉文化建设”辩论赛决赛。由团总支副书记李志强、商贸院辩论队成员刘炀、陈研、盛晨、寿沁怡、方莹、周棪担任本次决赛的评委。\r\n\r\n经过紧张刺激的初赛、复赛、四进二半决赛，会计2041和电商2011成功杀出重围，晋级决赛。正方为会计2041，反方为电商2011，他们的论题分别是“清廉文化建设重在扬善”、“清廉文化建设重在惩恶”。本次大赛分为开篇立论、针对性驳论、陈述观点、自由辩论、总结陈词等八个环节，主持人介绍完流程后，比赛正式拉开帷幕。首先，双方一辩就自己的辩题进行立论陈词。比赛现场可谓精彩纷呈，双方辩手以唇为枪，以舌舞剑，用自己精辟的语言，赢得了在场观众的阵阵掌声。在盘问和自由辩论环节，双方辩手提问犀利，层层深入，据理力争，互不相让，将比赛现场推入了一个又一个的高潮。辩手们以广博的见识、沉稳的姿态，张扬了自己的个性。比赛渐渐进入了尾声，现场观众对双方辩手进行提问，评委上台进行点评并宣布获胜方是正方，最佳辩手是反方三辩。随后，李志强老师分别给本届辩论赛的冠军、亚军、八强和四强班级以及最佳辩手颁发证书以及奖品。\r\n\r\n第八届新生辩论赛在大家的掌声中圆满结束。此次比赛在开拓了学生的思维的同时，更锻炼了辩手的口才与默契，加强了廉洁自律意识。商贸后续还会展开一系列活动，期待大家更精彩的表现。', '2.jpg', '2020-10-05 00:00:00', 5, NULL, 1, 0, 0, 14);
INSERT INTO `article` VALUES (7, '第一讲：习近平新时代中国特色社会主义思想是党和国家必须长期坚持的指导思想', '作者', '习近平新时代中国特色社会主义思想是党和国家必须长期坚持的指导思想', '2.jpg', '2020-10-06 00:00:00', 6, NULL, 1, 0, 0, 3);
INSERT INTO `article` VALUES (8, '达利女装学院举行首届“青春无悔，不负韶华”新生大合唱比赛', '作者', '11月23日晚，达利女装学院在图书馆报告厅举行了“青春无悔，不负韶华”新生大合唱比赛决赛。达利女装学院党总支书记郑小飞出席本次决赛。全体学工办老师及七百余名学生共同观看了比赛。\r\n\r\n   本次比赛邀请了校团委艺术指导老师陈志虹进行打分。\r\n\r\n   经过前期初赛，共选出7支来自各专业的优胜队伍进入决赛环节。比赛历时2个小时，现场高潮迭起，精彩纷呈，广大同学用嘹亮的歌声唱响新时代的最强音，在新时代奏响矢志不渝的青春赞歌。\r\n\r\n   本次比赛在艺设2021班带来的歌曲《稻香》中徐徐展开。艺设2022激情四射的《奔跑》、艺设2023的《倔强》、服装2011的《夜空中最亮的星》……每个班级都通过自己的独特方式展现了班级特色和新时代青年的青春活力。视觉2011班班主任柳霆钧表示，过程比结果更重要。在准备合唱比赛期间，可以感受到班级同学间越来越默契，班级的凝聚力也在不断增强，这是比赛带给班级最好的奖励。\r\n\r\n   郑小飞书记及全体学工办老师与全体新生班班助一起献上大合唱《梦想天堂》将比赛推向了高潮。\r\n\r\n   最终，经过激烈角逐，服设2011以积极向上的风貌和嘹亮激昂的歌声获本次比赛一等奖，服装2011和时装2021获二等奖，艺设2021、艺设2022和艺设2023获得了三等奖。', '2.jpg', '2020-10-07 00:00:00', 7, NULL, 1, 0, 0, 1);
INSERT INTO `article` VALUES (9, '友嘉智能制造学院“匠心启航”蔚蓝精英干部培养计划第三课开讲', '作者', '为增强友嘉智能制造学院学生干部与干事的校园新闻写作与摄影技巧，提高校园新闻写作与摄影能力水平，11月23日晚友嘉智能制造学院“匠心启航”蔚蓝精英干部培养计划第三课在图书馆第六会议室开讲。友嘉智能制造学院特邀校宣传部周曦老师开展了新闻写作与新闻摄影培训讲座，学生会全体干部、团总支宣传部干事、心协、同舟室、公寓自管会宣传部全体同学参加了此次培训。  \r\n\r\n周曦主要介绍了新闻的五要素、撰写过程所要注意的小细节及新闻的价值结构。“纸上得来终觉浅，绝知此事要躬行。”为了让干部与干事们可以对新闻写作方法有更加深入地了解，周曦结合学院官网的具体通讯稿存在的问题进行了详细分析和改正，同时还将新闻周刊的一些优秀新闻稿进行展示并给予一些小建议。例如“倒金字塔”结构、“增加描写、挖掘细节、使用对话”等一些小技巧。她强调：“新闻的基本特点之一是时效性，校园新闻也是如此，所以应多注意写作细节，并及时交稿。”  \r\n\r\n在新闻摄影部分，周曦对会议照片、校园新闻照片的拍摄进行了主要讲解，并对构图方法进行了分析。她强调了确定拍摄任务的重要性，要求在充分了解议程基础上，精选布局照片的主体、陪体、环境、细节、构图等。  \r\n\r\n此次培训不仅使同学们了解了基本的写作与摄影知识，同时也拓展了同学们的视野，让理论和实践充分结合，提高工作效率，对今后宣传工作的开展具有重要意义。', '2.jpg', '2020-10-08 00:00:00', 8, NULL, 1, 0, 0, 1);
INSERT INTO `article` VALUES (10, '吉利汽车学院党总支组织党员参观新四军纪念馆', '作者', ' 11月22日，吉利汽车学院党总支组织教师党员参观了临安新四军历史纪念馆。\r\n\r\n临安新四军历史纪念馆，在板桥新四军伤员急救站旧址的基础上改建而成，为纪念那段火红岁月，临安市决定将急救站遗址改建成新四军历史纪念馆。教师党员通过一幅幅照片，重温了那段艰苦奋战的历史，满怀对革命先烈的敬意，表达了对现在幸福生活的珍惜。\r\n\r\n参观后，教师党员集体学习习近平总书记在纪念中国人民志愿军抗美援朝出国作战70周年大会上的重要讲话精神和十九届五中全会精神。教师党员纷纷表示今后会继续深入学习党的十九届五中全会精神，不忘初心，牢记使命，不忘党领导人民为民族解放、人民幸福不屈不挠、浴血奋战的光辉历史，增强自身道路自信、制度自信，牢牢坚持为党育人、为国育才的理想信念。', '2.jpg', '2020-10-09 00:00:00', 1, NULL, 1, 0, 0, 1);
INSERT INTO `article` VALUES (11, '吉利汽车学院召开中心组会议学习十九届五中全会会议精神', '作者', '11月23日上午，吉利汽车学院党总支召开理论学习中心组会议，深入学习党的十九届五中全会精神。党总支书记邵立东同志主持会议并讲话。\r\n\r\n会议认为，党的十九届五中全会是在我国将进入新发展阶段、实现中华民族伟大复兴正处在关键时期召开的一次具有全局性、历史性意义的重要会议。会议审议通过的《中共中央关于制定国民经济和社会发展第十四个五年规划和二〇三五年远景目标的建议》，是夺取全面建设社会主义现代化国家新胜利的纲领性文件。\r\n\r\n邵立东同志通过总结会议的十四个关键词，对会议精神进行了深入地解读，他指出十九届五中全会为我们基本实现2035年远景目标明确了时间表、路线图，展现了实现中华民族伟大复兴中国梦的光明前景。并表示：一个人立什么样的志，决定今后能成为什么样的人。教师党员应当志存高远，树立共产主义远大理想，要立志做大事。要把个人理想与本职工作结合起来，与学院的发展结合起来，与学生的需求结合起来，甘于做党和人民事业的“铺路石”，向着伟大的事业忘我工作，砥砺前行。\r\n\r\n最后，与会人员纷纷发言，表示会继续深入学习十九届五中全会会议精神，提高自身政治觉悟，发挥党员先锋模范作用，全心全意为人民服务。', '2.jpg', '2020-10-10 00:00:00', 1, NULL, 1, 0, 0, 1);
INSERT INTO `article` VALUES (12, '会计学子喜获省证券投资大赛一等奖', '作者', '近日，由浙江省教育厅、浙江省大学生科技竞赛委员会主办，浙江财经大学承办的第六届浙江省大学生证券投资竞赛落下帷幕。今年比赛只设团体奖项不设个人奖项；总成绩由投资实测、投资报告和现场答辩三个部分组成；共74所开设财经类专业的高校参加。我校会计专业葛革等6名学生组成的二支团队，在段勇、施卓晨老师的指导下，精心准备，认真参赛；经过初赛、复赛和决赛三轮的激烈竞争，最终获得一等奖1项，二等奖1项。\r\n\r\n值得一提的是，该项赛事至今已举办六届，我校会计专业学生每年均获一等奖。', '2.jpg', '2020-10-11 00:00:00', 1, NULL, 1, 0, 0, 1);
INSERT INTO `article` VALUES (13, '我校受邀参加湖南职成教学会高职电子商务类专业委员会年会并交流发言', '作者', '11月20至21日，以“德技并重育人才，产教融合共发展”为主题的湖南省职业教育与成人教育学会高职电子商务类专业委员会2020年年会在长沙召开。湖南省职业教育与成人教育学会高职电子商务类专业委员会主任、湖南科技职业学院党委书记李三福主持开幕式并介绍专委会工作情况。全国电子商务职业教育教学指导委员会副主任陆春阳远程参加本次会议，并就新商科人才培养和与会代表进行了交流。湖南省教育厅职业教育与成人教育处主任科员刘彦奇、英国湖南商会会长陈谦等领导出席会议并讲话。来自湖南省职业教育与成人教育学会高职电子商务类专业委员会各委员，省内开设有电子商务等专业的高、中职学校的教师及各院校校企合作单位代表200余人参加了会议。\r\n\r\n会议邀请了来自省内外高职院校、企业的专家进行了主题报告和专题研讨。我校商贸旅游学院院长张赵根应邀出席会议，并作了题为“跨境电商校企双主体育人的‘杭职模式’”的主旨报告，介绍了我校跨境电商专业建设情况，分享了跨境电商专业引企入校、深化基于企业真实电商项目融入的实岗育人模式改革的实践与成效，受到与会领导和代表的高度肯定。会后，张赵根与参会的高职院校同行进行了交流探讨，并实地考察了大汉师创电子商务实训基地。', '2.jpg', '2020-10-12 00:00:00', 1, NULL, 1, 0, 0, 0);
INSERT INTO `article` VALUES (14, '商贸旅游学院成立“课堂文明”督导队伍', '作者', '课堂是学习知识技能、培育优良学风、文明立德修身的重要场所，为进一步深化商贸“课堂文明”建设，11月23日中午，商贸旅游学院在8202教室举行“课堂文明”督导队伍成立动员会，分院学工办王晓磊、组织员白秀珍及督导队成员参加会议。\r\n\r\n会上，王晓磊首先对督导队成立的意义和背景进行了说明，他希望全体督导成员提高“课堂文明”建设的总体认识，明确职责和入党积极分子的身份要求，真实检查，扎实执行，不走形式。白秀珍围绕“课堂文明”督导队的工作进行了布置，对时间、地点、任务做了明确。最后，两位老师给督导队同学发放工作牌。这一张张工作牌授予队员是一份荣誉和信任，更是一份责任和坚持。两位老师号召全体同学从己做起、严于律己，履行职责、做好落实，带动他人、践行文明。\r\n\r\n“课堂文明”督导队伍的建设检查工作是分院“课堂文明、你我共育”主题教育活动六项重要内容之一。本次督导队伍发挥入党积极分子先锋作用，通过开展“教室吃早餐”“迟到旷课”“上课玩手机”“课后关灯”“不留垃圾在教室”等检查，向不文明的课堂行为说“不”。通过督促纠正课堂行为，让文明常驻课堂。', '2.jpg', '2020-10-13 00:00:00', 1, NULL, 1, 0, 0, 3);
INSERT INTO `article` VALUES (15, '我校校园招聘会暨首届就业文化节开幕', '作者', '11月21日下午，我校2021届毕业生校园综合招聘会在校田径运动场举行。本次招聘会联合浙江省职业介绍服务指导中心、杭州市人才管理财务中心（杭州市人事考试院）、杭州市就业管理服务中心、浙江高校产学研联盟钱塘中心及杭州江东芯谷管理办公室等多家单位共同举办。吸引了杭州、宁波、金华等地区500多家企业踊跃报名，展位供不应求。经各二级分院筛选达利（中国）有限公司、杭州友佳精密机械有限公司、杭州杭港地铁有限公司等309家优质企业现场招聘，提供需求岗位超6000个，其中上市公司超100家。\r\n\r\n本次校园招聘会暨我校首届就业文化节开幕。就业文化节还包括导师面对面、玩转就业角、职场体验行等活动。切实有效地帮助同学们增强对职业生涯的认识，帮助同学们轻松面对个人未来生涯发展问题，提升综合素质与求职竞争力，助力学生体面就业。\r\n\r\n现场邀请到6位不同领域专业导师为同学们提供简历门诊、面试指导、政策咨询、职业生涯规划、升学考公等全方位就业指导咨询服务。导师们为100余位同学答疑解惑，特别是在书写简历、职业规划等方面，导师们就同学们的疑惑一一进行了解答。通过咨询，同学们更明确了未来职业规划方向，清晰了未来奋斗的目标，坚定了学习的决心。同时杭州就业管理服务局专家现场为同学们介绍杭州市大学生见习期就业创业政策。 \r\n\r\n尽管现场小雨飘零，但挡不住现场火热气氛，志愿者热情服务，毕业生有序进场，企业积极“抢人行动”，发礼品、加微信、扫二维码各显神通，会场异常火爆，专业组老师、辅导员和班主任到现场助力毕业生应聘。 \r\n\r\n经会后统计，毕业生现场投递出超2830份简历 ，869名毕业生与用人单位达成了初步的就业意向，现场签约人数54名。首届就业文化节刚刚才开始，后续将会有更多的活动等待大家的参与，“职为你来”，梦想从这里启航。', '2.jpg', '2020-10-13 00:00:00', 1, NULL, 1, 0, 0, 2);
INSERT INTO `article` VALUES (16, '第二讲：坚持和发展中国特色社会主义是当代中国发展进步的根本方向', '习近平', '坚持和发展中国特色社会主义是当代中国发展进步的根本方向', '2.jpg', '2020-11-24 17:04:15', 6, NULL, 1, 0, 0, 5);
INSERT INTO `article` VALUES (17, '第三讲：实现中华民族伟大复兴是近代以来中华民族最伟大的梦想', '习近平', '实现中华民族伟大复兴是近代以来中华民族最伟大的梦想', '2.jpg', '2020-11-24 17:04:15', 6, NULL, 1, 0, 0, 5);
INSERT INTO `article` VALUES (18, '第四讲：党和国家事业历史性、根本性的变革和成就', '习近平', '党和国家事业历史性、根本性的变革和成就', '2.jpg', '2020-11-24 17:04:15', 6, NULL, 1, 0, 0, 5);
INSERT INTO `article` VALUES (19, '第五讲：中国特色社会主义新时代标示我国发展新的历史方位', '习近平', '中国特色社会主义新时代标示我国发展新的历史方位', '2.jpg', '2020-11-24 17:04:15', 6, NULL, 1, 0, 0, 5);
INSERT INTO `article` VALUES (20, '第六讲：我国社会主要矛盾的变化是关系全局的历史性变化', '习近平', '我国社会主要矛盾的变化是关系全局的历史性变化', '2.jpg', '2020-11-24 17:04:15', 6, NULL, 1, 0, 0, 2);
INSERT INTO `article` VALUES (21, '第七讲：坚持党对一切工作的领导', '习近平', '坚持党对一切工作的领导', '2.jpg', '2020-11-24 17:04:15', 6, NULL, 1, 0, 0, 1);
INSERT INTO `article` VALUES (22, '创新创业大讲堂第41期精彩开讲', '作者', '11月20日，创新创业大讲堂第41期在行政楼二楼报告厅如期开讲。本期大讲堂主讲嘉宾是上海福宇龙汽车科技有限公司（上海小巨人企业）核心创始人吴成华先生，主题为“我和我身边的创业故事。校团委副书记、创业学院副院长楼黎瑾，创新创业办公室主任孙菲以及来自创业学院、吉利汽车学院、信息工程学院的老师和同学们到场聆听。\r\n\r\n大讲堂开场前楼黎瑾代表学校向吴成华先生颁发了创新创业导师证书，聘任吴成华为我校创新创业导师。\r\n\r\n吴成华是上海嘉定区汽车零部件领军人才、宁波慈溪市创新博士。同时担任三花控股旗下宁波福尔达智能科技有限公司（浙江高新技术企业500强）产品总监、信息与标准化总监、首席产品架构师，曾组织国家火炬计划项目-全自动汽车空调控制器，奥迪全球汽车空调出风口同步设计等创新项目。他从“时势造英雄,还是英雄造时势”的关系讲起，分别从“朝九晚五”“世界那么大，我想去看看”“ 学会打“‘群架’” 和“企业内第二春”四个部分，向大家讲述了他和他身边真实的创业故事及经历。吴成华强调，不鼓励大家盲目进行创业，但鼓励大家结合自身的专业和今后的工作岗位，进行结合时代的创新工作。\r\n\r\n吴成华的精彩分享让现场聆听的师生们受益匪浅，更让同学们对不同时代背景下的创新创业有了深刻的认识。讲座结束后同学们就新能源汽车的发展、汽车行业的创新方向等问题进行了积极提问。\r\n\r\n创业学院接下来将继续联合各二级学院开展创新创业大讲堂、沙龙等活动，激发同学们创新创业的热情，为学校创新创业工作注入新的活力。', '2.jpg', '2020-10-12 00:00:00', 3, NULL, 1, 0, 0, 1);
INSERT INTO `article` VALUES (23, '测试测试测试测试测试测试测试测试', '作者', '10月29日下午，2020年浙江省高职高专院校国家奖学金特别评选大会在浙江旅游职业学院隆重举行。本次评选大会由浙江省教育厅、财政厅主办，浙江省教育发展中心、浙江旅游职业学院承办。全省各高职院校共15名候选人入围此次评选，来自全省高校的200多名师生代表现场观摩，数十万人通过网络直播在线观看。本次大会的评委由专家评委和大众评委组成，实行差额评选，按最后得分高低推选出10名学生获得国家奖学金省级特别推荐资格。我校信息工程学院软件1811班陈龙同学通过推荐视频、个人展示，在全省高职院校推荐的众多候选人中脱颖而出，荣获浙江省高职高专院校国家奖学金特别评选推荐资格，全省高职院校仅有10位学生获此殊荣。据了解，浙江省在全国范围内率先探索组织国家奖学金特别评选活动，并在去年首创高职高专院校国家奖学金特别评选大会，目的是为了进一步提升职业教育吸引力，激励职业院校学生勤奋学习、勇于实践、提升技能水平，树立一批奋发向上的优秀学生典型，进一步打造我省高校资助文化品牌。本次评选，我校学子能在众多选手中脱颖而出，也进一步彰显了我校在育人方面所取得的成效。', '2.jpg', '2020-10-12 00:00:00', 3, NULL, 1, 0, 0, 2);
INSERT INTO `article` VALUES (24, '测试测试测试测试测试测试测试测试', '作者', '10月29日下午，2020年浙江省高职高专院校国家奖学金特别评选大会在浙江旅游职业学院隆重举行。本次评选大会由浙江省教育厅、财政厅主办，浙江省教育发展中心、浙江旅游职业学院承办。全省各高职院校共15名候选人入围此次评选，来自全省高校的200多名师生代表现场观摩，数十万人通过网络直播在线观看。本次大会的评委由专家评委和大众评委组成，实行差额评选，按最后得分高低推选出10名学生获得国家奖学金省级特别推荐资格。我校信息工程学院软件1811班陈龙同学通过推荐视频、个人展示，在全省高职院校推荐的众多候选人中脱颖而出，荣获浙江省高职高专院校国家奖学金特别评选推荐资格，全省高职院校仅有10位学生获此殊荣。据了解，浙江省在全国范围内率先探索组织国家奖学金特别评选活动，并在去年首创高职高专院校国家奖学金特别评选大会，目的是为了进一步提升职业教育吸引力，激励职业院校学生勤奋学习、勇于实践、提升技能水平，树立一批奋发向上的优秀学生典型，进一步打造我省高校资助文化品牌。本次评选，我校学子能在众多选手中脱颖而出，也进一步彰显了我校在育人方面所取得的成效。', '2.jpg', '2020-10-12 00:00:00', 3, NULL, 1, 0, 0, 1);
INSERT INTO `article` VALUES (25, '测试测试测试测试测试测试测试测试', '作者', '10月29日下午，2020年浙江省高职高专院校国家奖学金特别评选大会在浙江旅游职业学院隆重举行。本次评选大会由浙江省教育厅、财政厅主办，浙江省教育发展中心、浙江旅游职业学院承办。全省各高职院校共15名候选人入围此次评选，来自全省高校的200多名师生代表现场观摩，数十万人通过网络直播在线观看。本次大会的评委由专家评委和大众评委组成，实行差额评选，按最后得分高低推选出10名学生获得国家奖学金省级特别推荐资格。我校信息工程学院软件1811班陈龙同学通过推荐视频、个人展示，在全省高职院校推荐的众多候选人中脱颖而出，荣获浙江省高职高专院校国家奖学金特别评选推荐资格，全省高职院校仅有10位学生获此殊荣。据了解，浙江省在全国范围内率先探索组织国家奖学金特别评选活动，并在去年首创高职高专院校国家奖学金特别评选大会，目的是为了进一步提升职业教育吸引力，激励职业院校学生勤奋学习、勇于实践、提升技能水平，树立一批奋发向上的优秀学生典型，进一步打造我省高校资助文化品牌。本次评选，我校学子能在众多选手中脱颖而出，也进一步彰显了我校在育人方面所取得的成效。', '2.jpg', '2020-10-12 00:00:00', 4, NULL, 1, 0, 0, 7);
INSERT INTO `article` VALUES (26, '测试测试测试测试测试测试测试测试', '作者', '10月29日下午，2020年浙江省高职高专院校国家奖学金特别评选大会在浙江旅游职业学院隆重举行。本次评选大会由浙江省教育厅、财政厅主办，浙江省教育发展中心、浙江旅游职业学院承办。全省各高职院校共15名候选人入围此次评选，来自全省高校的200多名师生代表现场观摩，数十万人通过网络直播在线观看。本次大会的评委由专家评委和大众评委组成，实行差额评选，按最后得分高低推选出10名学生获得国家奖学金省级特别推荐资格。我校信息工程学院软件1811班陈龙同学通过推荐视频、个人展示，在全省高职院校推荐的众多候选人中脱颖而出，荣获浙江省高职高专院校国家奖学金特别评选推荐资格，全省高职院校仅有10位学生获此殊荣。据了解，浙江省在全国范围内率先探索组织国家奖学金特别评选活动，并在去年首创高职高专院校国家奖学金特别评选大会，目的是为了进一步提升职业教育吸引力，激励职业院校学生勤奋学习、勇于实践、提升技能水平，树立一批奋发向上的优秀学生典型，进一步打造我省高校资助文化品牌。本次评选，我校学子能在众多选手中脱颖而出，也进一步彰显了我校在育人方面所取得的成效。', '2.jpg', '2020-10-12 00:00:00', 4, NULL, 1, 0, 0, 1);
INSERT INTO `article` VALUES (27, '测试测试测试测试测试测试测试测试', '作者', '10月29日下午，2020年浙江省高职高专院校国家奖学金特别评选大会在浙江旅游职业学院隆重举行。本次评选大会由浙江省教育厅、财政厅主办，浙江省教育发展中心、浙江旅游职业学院承办。全省各高职院校共15名候选人入围此次评选，来自全省高校的200多名师生代表现场观摩，数十万人通过网络直播在线观看。本次大会的评委由专家评委和大众评委组成，实行差额评选，按最后得分高低推选出10名学生获得国家奖学金省级特别推荐资格。我校信息工程学院软件1811班陈龙同学通过推荐视频、个人展示，在全省高职院校推荐的众多候选人中脱颖而出，荣获浙江省高职高专院校国家奖学金特别评选推荐资格，全省高职院校仅有10位学生获此殊荣。据了解，浙江省在全国范围内率先探索组织国家奖学金特别评选活动，并在去年首创高职高专院校国家奖学金特别评选大会，目的是为了进一步提升职业教育吸引力，激励职业院校学生勤奋学习、勇于实践、提升技能水平，树立一批奋发向上的优秀学生典型，进一步打造我省高校资助文化品牌。本次评选，我校学子能在众多选手中脱颖而出，也进一步彰显了我校在育人方面所取得的成效。', '2.jpg', '2020-10-12 00:00:00', 4, NULL, 1, 0, 0, 0);

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `file_time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  `file_down` int NULL DEFAULT NULL COMMENT '下载次数',
  `file_type` int NULL DEFAULT NULL COMMENT '文件类型：0-pdf，1-doc，2-txt，3-zip',
  `file_del_state` int NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------

-- ----------------------------
-- Table structure for link
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `link_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '友情链接名称',
  `link_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接地址',
  `link_sort` int NULL DEFAULT NULL COMMENT '排序',
  `link_del_state` int NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of link
-- ----------------------------
INSERT INTO `link` VALUES (1, '杭州职业技术学院', 'www.hzvtc.edu.cn', 1, 0);
INSERT INTO `link` VALUES (2, '中华人民共和国教育部', 'www.moe.gov.cn', 2, 0);
INSERT INTO `link` VALUES (3, '中国高职高专教育网', 'www.tech.net.cn', 3, 0);
INSERT INTO `link` VALUES (4, '浙江省教育厅', 'jyt.zj.gov.cn', 4, 0);
INSERT INTO `link` VALUES (5, '人民网', NULL, 5, 0);
INSERT INTO `link` VALUES (6, '新华网', NULL, 6, 0);
INSERT INTO `link` VALUES (7, '光明网', NULL, 7, 0);

-- ----------------------------
-- Table structure for plate
-- ----------------------------
DROP TABLE IF EXISTS `plate`;
CREATE TABLE `plate`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '板块id',
  `pla_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '板块名称',
  `pla_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接',
  `pla_sort` int NULL DEFAULT NULL COMMENT '板块顺序',
  `pla_parent_id` int NULL DEFAULT NULL COMMENT '父板块id',
  `pla_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '板块图片',
  `pla_type` int NULL DEFAULT NULL COMMENT '板块类型：1-导航，2-板块，3-导航板块结合，4-专栏\r\n',
  `pla_del_state` int NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sec_parent_id`(`pla_parent_id`) USING BTREE,
  CONSTRAINT `plate_ibfk_1` FOREIGN KEY (`pla_parent_id`) REFERENCES `plate` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plate
-- ----------------------------
INSERT INTO `plate` VALUES (1, '学院新闻', 'news', 1, NULL, NULL, 2, 0);
INSERT INTO `plate` VALUES (3, '党建与思想政治工作', 'party', 3, NULL, NULL, 2, 0);
INSERT INTO `plate` VALUES (4, '理论学习', 'study', 3, NULL, NULL, 2, 0);
INSERT INTO `plate` VALUES (5, '学院公告', 'notice', 4, NULL, NULL, 2, 0);
INSERT INTO `plate` VALUES (6, '习近平中国特色社会主义十三讲', 'thought', 5, NULL, NULL, 2, 0);
INSERT INTO `plate` VALUES (7, '慧智睿思学堂', 'special', 6, NULL, 'special.jpg', 4, 0);
INSERT INTO `plate` VALUES (8, '学校链接1', 'schoolLink', 1, NULL, NULL, 1, 0);
INSERT INTO `plate` VALUES (9, '学院简介2', 'introduction', 2, NULL, NULL, 1, 0);
INSERT INTO `plate` VALUES (10, '教学科研3', 'research', 2, NULL, NULL, 1, 0);
INSERT INTO `plate` VALUES (11, '党建思政4', 'work', 4, NULL, NULL, 1, 0);
INSERT INTO `plate` VALUES (12, '文化建设5', 'culture', 5, NULL, NULL, 1, 0);
INSERT INTO `plate` VALUES (13, '文件制度6', 'file', 6, NULL, NULL, 1, 0);
INSERT INTO `plate` VALUES (14, '科研结果1', 'result', 2, 10, NULL, 5, 0);
INSERT INTO `plate` VALUES (15, '成果展示2', 'show', 2, 10, NULL, 5, 0);
INSERT INTO `plate` VALUES (16, '马克思主义建设1', 'mks', 1, 10, NULL, 5, 0);
INSERT INTO `plate` VALUES (17, '测试测试2', '1', 4, 10, NULL, 5, 0);
INSERT INTO `plate` VALUES (18, '学生宿舍3', '2', 4, 11, '', 5, 0);
INSERT INTO `plate` VALUES (22, '测试', 'test', 6, NULL, NULL, 1, 1);
INSERT INTO `plate` VALUES (23, '测试', 'test', 1, NULL, NULL, 5, 1);
INSERT INTO `plate` VALUES (24, '测试', 'test', 1, NULL, NULL, 5, 1);
INSERT INTO `plate` VALUES (25, '测试', 'test', 6, NULL, NULL, 1, 1);
INSERT INTO `plate` VALUES (26, '测试', 'test', 7, NULL, NULL, 1, 1);
INSERT INTO `plate` VALUES (27, '测试', 'test', 7, NULL, NULL, 1, 1);
INSERT INTO `plate` VALUES (28, '测试', 'test', 6, NULL, NULL, 2, 1);
INSERT INTO `plate` VALUES (29, '测试', 'test', 7, NULL, NULL, 4, 1);

-- ----------------------------
-- Table structure for swiper
-- ----------------------------
DROP TABLE IF EXISTS `swiper`;
CREATE TABLE `swiper`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `swi_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '轮播图名称',
  `swi_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片描述',
  `swi_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片名称',
  `swi_art_id` int NULL DEFAULT NULL COMMENT '图片关联的文章id',
  `swi_sort` int NULL DEFAULT NULL COMMENT '排序',
  `swi_del_state` int NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `swi_art_id`(`swi_art_id`) USING BTREE,
  CONSTRAINT `swiper_ibfk_1` FOREIGN KEY (`swi_art_id`) REFERENCES `article` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of swiper
-- ----------------------------
INSERT INTO `swiper` VALUES (1, '学校校园', '杭职善湖', 'a.jpg', 1, 1, 0);
INSERT INTO `swiper` VALUES (2, '图书馆', '图书管远景', 'b.jpg', 1, 2, 0);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `phone` int NULL DEFAULT NULL COMMENT '管理员手机号',
  `user_del_state` int NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'test', '123456', 123456, 0);
INSERT INTO `sys_user` VALUES (2, 'admin', 'admin', 12313, 0);

SET FOREIGN_KEY_CHECKS = 1;

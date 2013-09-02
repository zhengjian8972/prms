/*
MySQL Data Transfer
Source Host: localhost
Source Database: prms
Target Host: localhost
Target Database: prms
Date: 2013/9/2 22:44:30
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for table_group
-- ----------------------------
CREATE TABLE `table_group` (
  `GROUP_ID` int(10) NOT NULL,
  `GROUP_LEVEL` tinyint(1) NOT NULL,
  `GROUP_NAME` varchar(255) NOT NULL,
  `GROUP_DESCRIPTION` varchar(255) DEFAULT NULL,
  `PROJECT_ID` int(10) NOT NULL,
  PRIMARY KEY (`GROUP_ID`),
  KEY `FK_PROJECT_ID` (`PROJECT_ID`),
  CONSTRAINT `FK_PROJECT_ID` FOREIGN KEY (`PROJECT_ID`) REFERENCES `table_project` (`PROJECT_ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for table_member
-- ----------------------------
CREATE TABLE `table_member` (
  `MEMBER_ID` int(10) NOT NULL,
  `MEMBER_NAME` varchar(10) NOT NULL,
  `PASSWORD` varchar(30) NOT NULL DEFAULT '888888',
  `EMAIL` varchar(30) NOT NULL,
  PRIMARY KEY (`MEMBER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for table_member_group
-- ----------------------------
CREATE TABLE `table_member_group` (
  `MEMBER_GROUP_ID` int(10) NOT NULL,
  `MEMBER_ID` int(10) NOT NULL,
  `GROUP_ID` int(10) NOT NULL,
  `AUTHORITY` int(1) NOT NULL,
  PRIMARY KEY (`MEMBER_GROUP_ID`),
  KEY `MEMBERID` (`MEMBER_ID`),
  KEY `GROUPID` (`GROUP_ID`),
  CONSTRAINT `GROUPID` FOREIGN KEY (`GROUP_ID`) REFERENCES `table_group` (`GROUP_ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `MEMBERID` FOREIGN KEY (`MEMBER_ID`) REFERENCES `table_member` (`MEMBER_ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for table_project
-- ----------------------------
CREATE TABLE `table_project` (
  `PROJECT_ID` int(10) NOT NULL,
  `PROJECT_NAME` varchar(30) NOT NULL,
  `PROJECT_DESCRIPTION` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`PROJECT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for table_report
-- ----------------------------
CREATE TABLE `table_report` (
  `REPORT_ID` bigint(15) NOT NULL,
  `MEMBER_ID` int(10) NOT NULL,
  `BUILD_DATE` date NOT NULL,
  `CONTENT` text NOT NULL,
  `REPORT_TYPE` tinyint(1) NOT NULL DEFAULT '0',
  `PROJECT_ID` int(10) NOT NULL,
  PRIMARY KEY (`REPORT_ID`),
  KEY `A` (`MEMBER_ID`),
  KEY `PROJECT_ID` (`PROJECT_ID`),
  CONSTRAINT `A` FOREIGN KEY (`MEMBER_ID`) REFERENCES `table_member` (`MEMBER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `table_report_ibfk_1` FOREIGN KEY (`PROJECT_ID`) REFERENCES `table_project` (`PROJECT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `table_group` VALUES ('1', '1', '普通组', '搞文本挖掘的', '1');
INSERT INTO `table_group` VALUES ('2', '1', 'hadoop性能优化组', '研究hadoop性能的', '1');
INSERT INTO `table_group` VALUES ('3', '0', '管理组', '整周报的', '1');
INSERT INTO `table_group` VALUES ('192883', '0', '普通组', '普通成员', '1');
INSERT INTO `table_group` VALUES ('365930', '0', '普通组', '普通成员', '1');
INSERT INTO `table_group` VALUES ('375672', '0', '普通组', '普通成员', '1');
INSERT INTO `table_group` VALUES ('557175', '0', 'admin', '管理员', '672310');
INSERT INTO `table_group` VALUES ('674380', '0', '普通组', '普通成员', '1');
INSERT INTO `table_member` VALUES ('2011110669', '哥', '888888', '756110664@qq.com');
INSERT INTO `table_member` VALUES ('2011110681', '王鹏', '888888', 'wangpeng@qq.com');
INSERT INTO `table_member` VALUES ('2011110740', '陈震', '888888', 'chenzhen@qq.com');
INSERT INTO `table_member` VALUES ('2011110746', '张仁波', '888888', 'zhangrenbo@qq.com');
INSERT INTO `table_member` VALUES ('2011110765', '于兴隆', '555555', 'yuxinglong@qq.com');
INSERT INTO `table_member` VALUES ('2011110776', '郑健', '888888', 'zhengjian8972@qq.com');
INSERT INTO `table_member_group` VALUES ('314798', '2011110746', '3', '0');
INSERT INTO `table_member_group` VALUES ('322626', '2011110776', '557175', '0');
INSERT INTO `table_member_group` VALUES ('411513', '2011110776', '3', '1');
INSERT INTO `table_member_group` VALUES ('609479', '2011110765', '1', '0');
INSERT INTO `table_member_group` VALUES ('648968', '2011110740', '1', '0');
INSERT INTO `table_member_group` VALUES ('685564', '2011110681', '674380', '0');
INSERT INTO `table_member_group` VALUES ('882529', '2011110669', '375672', '0');
INSERT INTO `table_project` VALUES ('1', 'PDM并行数据挖掘系统', 'PDM是基于hadoop框架的并行数据挖掘系统，实现数据交换、ETL、数据探索、数据挖掘、文本挖掘、社交网络分析等功能。');
INSERT INTO `table_project` VALUES ('672310', '测试项目', 'abc');
INSERT INTO `table_report` VALUES ('1336563195825', '2011110776', '2012-05-06', '{\'content\':\'\',\'project\':\'1 (PDM并行数据挖掘系统)\',\'reportdate\':\'2012/05/06\',\'workcontent\':\'sdf \',\'reportdatecontent1\':\'周一工作内容\',\'reportdatetime1\':\'H\',\'reportdatecontent2\':\'周二工作内容\',\'reportdatetime2\':\'H\',\'reportdateContent3\':\'周三工作内容\',\'reportdatetime3\':\'H\',\'reportdatecontent4\':\'周四工作内容\',\'reportdatetime4\':\'H\',\'reportdatecontent5\':\'周五工作内容\',\'reportdatetime5\':\'H\',\'reportdateContent6\':\'其他工作内容\',\'reportdatetime6\':\'H\',\'workresult\':\'本周工作成果\',\'workplan\':\'下周工作计划\',\'workresource\':\'需要资源情况\',\'rate_score\':\'0\',\'codeline\':\'代码量\',\'\':\'提　交\',\'add_report_reset\':\'重　置\'}', '0', '1');
INSERT INTO `table_report` VALUES ('1337073121910', '2011110776', '2012-05-06', '{\'content\':\'\',\'project\':\'1 (PDM并行数据挖掘系统)\',\'reportdate\':\'2012/05/06\',\'workcontent\':\'本周工作背景\',\'reportdatecontent1\':\'周一工作内容\',\'reportdatetime1\':\'H\',\'reportdatecontent2\':\'周二工作内容\',\'reportdatetime2\':\'H\',\'reportdateContent3\':\'周三工作内容\',\'reportdatetime3\':\'H\',\'reportdatecontent4\':\'周四工作内容\',\'reportdatetime4\':\'H\',\'reportdatecontent5\':\'周五工作内容\',\'reportdatetime5\':\'H\',\'reportdateContent6\':\'其他工作内容\',\'reportdatetime6\':\'H\',\'workresult\':\'本周工作成果\',\'workplan\':\'下周工作计划\',\'workresource\':\'需要资源情况\',\'rate_score\':\'0\',\'codeline\':\'代码量\',\'\':\'提　交\',\'add_report_reset\':\'重　置\'}', '0', '1');
INSERT INTO `table_report` VALUES ('1337922215312', '2011110776', '2012-05-02', '{\'content\':\'\',\'project\':\'1 (PDM并行数据挖掘系统)\',\'reportdate\':\'2012/05/02\',\'workcontent\':\'本周工作背景\',\'reportdatecontent1\':\'周一工作内容\',\'reportdatetime1\':\'H\',\'reportdatecontent2\':\'周二工作内容\',\'reportdatetime2\':\'H\',\'reportdateContent3\':\'周三工作内容\',\'reportdatetime3\':\'H\',\'reportdatecontent4\':\'周四工作内容\',\'reportdatetime4\':\'H\',\'reportdatecontent5\':\'周五工作内容\',\'reportdatetime5\':\'H\',\'reportdateContent6\':\'其他工作内容\',\'reportdatetime6\':\'H\',\'workresult\':\'本周工作成果\',\'workplan\':\'下周工作计划\',\'workresource\':\'需要资源情况\',\'rate_score\':\'4\',\'codeline\':\'代码量\',\'\':\'提　交\',\'add_report_reset\':\'重　置\'}', '0', '1');
INSERT INTO `table_report` VALUES ('1347009238679', '2011110776', '2012-09-08', '{\'content\':\'\',\'project\':\'1 (PDM并行数据挖掘系统)\',\'reportdate\':\'2012/09/08\',\'workcontent\':\'adf\',\'reportdatecontent1\':\'asdf\',\'reportdatetime1\':\'9\',\'reportdatecontent2\':\'asdf\',\'reportdatetime2\':\'9\',\'reportdateContent3\':\'周三工作内容\',\'reportdatetime3\':\'H\',\'reportdatecontent4\':\'周四工作内容\',\'reportdatetime4\':\'H\',\'reportdatecontent5\':\'周五工作内容\',\'reportdatetime5\':\'H\',\'reportdateContent6\':\'其他工作内容\',\'reportdatetime6\':\'H\',\'workresult\':\'sdf\',\'workplan\':\'下周工作计划\',\'workresource\':\'需要资源情况\',\'rate_score\':\'0\',\'codeline\':\'代码量\',\'\':\'提　交\',\'add_report_reset\':\'重　置\'}', '0', '1');
INSERT INTO `table_report` VALUES ('1347009299676', '2011110776', '2012-09-08', '{\'content\':\'{\'content\':\'\',\'project\':\'项目名\',\'reportdate\':\'报告时间\',\'workcontent\':\'本周工作背景\',\'reportdatecontent1\':\'sdf \',\'reportdatetime1\':\'H\',\'reportdatecontent2\':\'周二工作内容\',\'reportdatetime2\':\'H\',\'reportdateContent3\':\'周三工作内容\',\'reportdatetime3\':\'H\',\'reportdatecontent4\':\'周四工作内容\',\'reportdatetime4\':\'H\',\'reportdatecontent5\':\'周五工作内容\',\'reportdatetime5\':\'H\',\'reportdateContent6\':\'其他工作内容\',\'reportdatetime6\':\'H\',\'workresult\':\'本周工作成果\',\'workplan\':\'下周工作计划\',\'workresource\':\'需要资源情况\',\'rate_score\':\'0\',\'codeline\':\'代码量\',\'\':\'提　交\',\'add_report_reset\':\'重　置\'}\',\'project\':\'672310 (测试项目)\',\'reportdate\':\'2012/09/08\',\'workcontent\':\'fsdasd\',\'reportdatecontent1\':\'sdf \',\'reportdatetime1\':\'H\',\'reportdatecontent2\':\'周二工作内容\',\'reportdatetime2\':\'H\',\'reportdateContent3\':\'周三工作内容\',\'reportdatetime3\':\'H\',\'reportdatecontent4\':\'周四工作内容\',\'reportdatetime4\':\'H\',\'reportdatecontent5\':\'周五工作内容\',\'reportdatetime5\':\'H\',\'reportdateContent6\':\'其他工作内容\',\'reportdatetime6\':\'H\',\'workresult\':\'dfsdsfasdf\',\'workplan\':\'下周工作计划\',\'workresource\':\'需要资源情况\',\'rate_score\':\'4\',\'codeline\':\'1000\',\'\':\'提　交\',\'add_report_reset\':\'重　置\'}', '0', '672310');
INSERT INTO `table_report` VALUES ('1378127962691', '2011110776', '2013-09-01', '{\'content\':\'\',\'project\':\'1 (PDM并行数据挖掘系统)\',\'reportdate\':\'2013/09/01\',\'workcontent\':\'要找工作了，还要写中期报告，尼玛亚历山大啊！\',\'reportdatecontent1\':\'今天干了点活，主要是把github更新了，改了改简历，打算投机家\',\'reportdatetime1\':\'8\',\'reportdatecontent2\':\'投了百度\',\'reportdatetime2\':\'9\',\'reportdateContent3\':\'准备把linux相关内容看完\',\'reportdatetime3\':\'8\',\'reportdatecontent4\':\'打算看看大数据相关的，然后刷刷提\',\'reportdatetime4\':\'9\',\'reportdatecontent5\':\'没事\',\'reportdatetime5\':\'9\',\'reportdateContent6\':\'没有\',\'reportdatetime6\':\'0\',\'workresult\':\'很充实，收获很多\',\'workplan\':\'希望早日收获offer\',\'workresource\':\'offer啊！！\',\'rate_score\':\'5\',\'codeline\':\'1000\',\'\':\'提　交\',\'add_report_reset\':\'重　置\'}', '0', '1');

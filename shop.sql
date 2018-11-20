/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-11-20 15:05:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for we_accesstoken
-- ----------------------------
DROP TABLE IF EXISTS `we_accesstoken`;
CREATE TABLE `we_accesstoken` (
  `id` varchar(64) NOT NULL,
  `access_token` varchar(200) NOT NULL,
  `expires_in` int(4) NOT NULL,
  `expires_after` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of we_accesstoken
-- ----------------------------
INSERT INTO `we_accesstoken` VALUES ('92394ca7b8c24fd4bfab32d72c4dc89d', '15_n4egDNK5Nytb9zDlthmLEqIgNm5DnGV5e4GHBDFOIjux74Aw1oJFpGV3BsagyiWDLCAaos6Qi796cBpz_OXVWEv3Bu3X8uDoJoDP-_eaT18vZ8R7i_6MO6wYYCa-jwivLCExBEBWYXtLoSn0EAOeAEANJX', '7200', '1542703269664');

-- ----------------------------
-- Table structure for we_msg
-- ----------------------------
DROP TABLE IF EXISTS `we_msg`;
CREATE TABLE `we_msg` (
  `id` varchar(64) NOT NULL,
  `ToUserName` varchar(64) NOT NULL,
  `FromUserName` varchar(64) NOT NULL,
  `MsgType` varchar(10) NOT NULL,
  `Content` varchar(500) DEFAULT NULL,
  `MediaId` varchar(64) DEFAULT NULL COMMENT '语音消息媒体id',
  `Format` varchar(10) DEFAULT NULL COMMENT '语音格式',
  `Recognition` varchar(500) DEFAULT NULL COMMENT '语音识别结果',
  `MsgId` varchar(64) NOT NULL,
  `CreateTime` bigint(20) NOT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of we_msg
-- ----------------------------
INSERT INTO `we_msg` VALUES ('033255bfc3c144a38723860aa59903d4', 'gh_8bfaec57204c', 'oMvvQ0g7CM4KepI-YDVVdvHOCGp0', 'text', '小贝是我的', null, null, null, '6625835044402662476', '1542697438', '0');
INSERT INTO `we_msg` VALUES ('2771bc0bff04426a8f5b9efef230a7a8', 'gh_8bfaec57204c', 'oMvvQ0g7CM4KepI-YDVVdvHOCGp0', 'voice', null, '2LpbYZ46NroC8SBC2TARyobrZWDWwIgN1ezsB-arvDlkkMte31II3s8B0xb4kE8Y', 'amr', '买了佛伦。', '6625834485487239168', '1542697309274', '0');
INSERT INTO `we_msg` VALUES ('36fc2437b4e140a6832212fe8ec714e8', 'gh_8bfaec57204c', 'oMvvQ0u5JHnxODTq_adWeoYbhZQk', 'voice', null, 'LznLtsPKsWs8JtQ3TNrfjdvKW1YNwzUwk7ZYO7IHBGHDQ0iHRJAT6UEsWmm0a9-q', 'amr', '刘禅是个二傻子。', '6625830229174648832', '1542696318786', '0');
INSERT INTO `we_msg` VALUES ('476e8f1a70904479989df6803cb95da0', 'gh_8bfaec57204c', 'oMvvQ0g7CM4KepI-YDVVdvHOCGp0', 'text', '你好', null, null, null, '6625834378682731590', '1542697283', '0');
INSERT INTO `we_msg` VALUES ('49f636d46bf149eaaad801590db5e448', 'gh_8bfaec57204c', 'oMvvQ0g7CM4KepI-YDVVdvHOCGp0', 'text', '小贝是我的', null, null, null, '6625835061582531662', '1542697442', '0');
INSERT INTO `we_msg` VALUES ('592fbebeb5454105a723dec457b94247', 'gh_8bfaec57204c', 'oMvvQ0g7CM4KepI-YDVVdvHOCGp0', 'text', '获取用户列表', null, null, null, '6624381752023747554', '1542359067', '0');
INSERT INTO `we_msg` VALUES ('6d0747d951dd427db6359d50479f5829', 'gh_8bfaec57204c', 'oMvvQ0g7CM4KepI-YDVVdvHOCGp0', 'text', '获取用户列表', null, null, null, '6624380141411011548', '1542358692', '0');
INSERT INTO `we_msg` VALUES ('8cc597be774841898d693429fbaa4bf7', 'gh_8bfaec57204c', 'oMvvQ0g7CM4KepI-YDVVdvHOCGp0', 'text', '获取用户列表', null, null, null, '6624380828605778910', '1542358852', '0');
INSERT INTO `we_msg` VALUES ('8f941f6cac29444d97492977cd0724a8', 'gh_8bfaec57204c', 'oMvvQ0g7CM4KepI-YDVVdvHOCGp0', 'text', '获取用户列表', null, null, null, '6624381301052181472', '1542358962', '0');
INSERT INTO `we_msg` VALUES ('a6908ab838504203a118a8307f7eb46c', 'gh_8bfaec57204c', 'oMvvQ0g7CM4KepI-YDVVdvHOCGp0', 'text', '获取用户列表', null, null, null, '6624379394086702042', '1542358518', '0');
INSERT INTO `we_msg` VALUES ('da9b7595a0d048e092f6852d8fec2ce0', 'gh_8bfaec57204c', 'oMvvQ0g7CM4KepI-YDVVdvHOCGp0', 'text', '我爱小贝', null, null, null, '6625831492464708676', '1542696611', '0');
INSERT INTO `we_msg` VALUES ('fed80b28c97247bab73c662decf29a74', 'gh_8bfaec57204c', 'oMvvQ0g7CM4KepI-YDVVdvHOCGp0', 'text', '小贝是我的', null, null, null, '6625835027222793290', '1542697434', '0');

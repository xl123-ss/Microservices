/*
 Navicat Premium Data Transfer

 Source Server         : t01-mysql-本地
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : coupon_db

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 09/09/2023 10:05:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `template_id` int NOT NULL DEFAULT 0 COMMENT '主键',
  `user_id` bigint NOT NULL DEFAULT 0 COMMENT '拥有这张券的用户ID',
  `created_time` datetime NOT NULL DEFAULT '2021-12-13 00:00:00' COMMENT '领券时间',
  `status` int NOT NULL DEFAULT 0 COMMENT '优惠券的状态，比如未用，已用',
  `shop_id` bigint NULL DEFAULT NULL COMMENT '冗余字段，方便查找',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
  INDEX `idx_template_id`(`template_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '领到手的优惠券' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon
-- ----------------------------
INSERT INTO `coupon` VALUES (10, 2, 1, '2023-09-09 09:54:56', 1, NULL);
INSERT INTO `coupon` VALUES (11, 1, 1, '2023-09-09 09:55:30', 2, NULL);
INSERT INTO `coupon` VALUES (12, 3, 1, '2023-09-09 09:55:35', 1, NULL);
INSERT INTO `coupon` VALUES (13, 4, 1, '2023-09-09 09:55:38', 1, NULL);
INSERT INTO `coupon` VALUES (14, 5, 1, '2023-09-09 09:55:41', 1, NULL);

-- ----------------------------
-- Table structure for coupon_template
-- ----------------------------
DROP TABLE IF EXISTS `coupon_template`;
CREATE TABLE `coupon_template`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `available` tinyint(1) NOT NULL DEFAULT 0 COMMENT '优惠券可用状态',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '优惠券名称',
  `description` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '优惠券详细信息',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '优惠券类型，比如满减、随机立减、晚间双倍等等',
  `shop_id` bigint NULL DEFAULT NULL COMMENT '优惠券适用的门店，如果是空则代表全场适用',
  `created_time` datetime NOT NULL DEFAULT '2021-12-13 00:00:00' COMMENT '创建时间',
  `rule` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '详细的使用规则',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_shop_id`(`shop_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券模板' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon_template
-- ----------------------------
INSERT INTO `coupon_template` VALUES (1, 1, '全场满10减1元', '满减券描述，每人限制最多10张', '1', NULL, '2023-09-09 09:53:08', '{\"discount\":{\"quota\":10,\"threshold\":1000},\"limitation\":10}');
INSERT INTO `coupon_template` VALUES (2, 1, '晚间双倍立减券', '满50随机立减最多5元，晚间减10元', '4', NULL, '2023-09-09 09:53:12', '{\"discount\":{\"quota\":500,\"threshold\":5000},\"limitation\":10}');
INSERT INTO `coupon_template` VALUES (3, 1, '随机立减券', '满50随机立减最多5元', '3', NULL, '2023-09-09 09:53:15', '{\"discount\":{\"quota\":500,\"threshold\":5000},\"limitation\":10}');
INSERT INTO `coupon_template` VALUES (4, 1, '打折券满10元打9折', '每人限制最多10张', '2', NULL, '2023-09-09 09:53:18', '{\"discount\":{\"quota\":90,\"threshold\":1000},\"limitation\":10}');
INSERT INTO `coupon_template` VALUES (5, 1, '全场满10减1元', '满减券描述，每人限制最多10张', '1', NULL, '2023-09-09 09:53:32', '{\"discount\":{\"quota\":10,\"threshold\":1000},\"limitation\":10}');

SET FOREIGN_KEY_CHECKS = 1;

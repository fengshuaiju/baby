
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `level` int(11) DEFAULT NULL,
  `name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `is_use` tinyint(1) DEFAULT NULL,
  `icon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `indexs` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for coupons
-- ----------------------------
DROP TABLE IF EXISTS `coupons`;
CREATE TABLE `coupons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `coupon_id` varchar(64) COLLATE utf8_bin NOT NULL,
  `pic_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `link_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `coupon_name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(64) COLLATE utf8_bin NOT NULL,
  `amount_of_money` double DEFAULT NULL,
  `requirement_consumption` double DEFAULT NULL,
  `period_of_validity_to_at` datetime NOT NULL,
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `available` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `coupon_id` (`coupon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for coupons_users
-- ----------------------------
DROP TABLE IF EXISTS `coupons_users`;
CREATE TABLE `coupons_users` (
  `user_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `coupon_id` varchar(64) COLLATE utf8_bin NOT NULL,
  `used` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`user_name`,`coupon_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for event_publishing_tracker
-- ----------------------------
DROP TABLE IF EXISTS `event_publishing_tracker`;
CREATE TABLE `event_publishing_tracker` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `most_recent_published_event_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_event_publishing_tracker_most_recent_published_event_id` (`most_recent_published_event_id`),
  CONSTRAINT `FK_event_publishing_tracker_most_recent_published_event_id` FOREIGN KEY (`most_recent_published_event_id`) REFERENCES `event_to_publish` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for event_to_publish
-- ----------------------------
DROP TABLE IF EXISTS `event_to_publish`;
CREATE TABLE `event_to_publish` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8_bin NOT NULL,
  `content` varchar(150) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(200) COLLATE utf8_bin NOT NULL,
  `type` varchar(20) COLLATE utf8_bin NOT NULL,
  `script` varchar(1000) COLLATE utf8_bin NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) COLLATE utf8_bin NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for function_menus
-- ----------------------------
DROP TABLE IF EXISTS `function_menus`;
CREATE TABLE `function_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `link_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pic_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `title` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goods_id` varchar(64) COLLATE utf8_bin NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `characteristic` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `main_pic` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `original_price` double DEFAULT NULL,
  `min_price` double DEFAULT NULL,
  `pingtuan_price` double DEFAULT NULL,
  `number_orders` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `pingtuan` tinyint(1) DEFAULT NULL,
  `content` text COLLATE utf8_bin,
  `views` int(11) DEFAULT NULL,
  `number_fav` int(11) DEFAULT NULL,
  `number_reputation` int(11) DEFAULT NULL,
  `stores` int(11) DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `goods_id` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for goods_category
-- ----------------------------
DROP TABLE IF EXISTS `goods_category`;
CREATE TABLE `goods_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `is_use` tinyint(1) DEFAULT NULL,
  `name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_goods` (`category_id`),
  CONSTRAINT `fk_category_goods` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for goods_fav
-- ----------------------------
DROP TABLE IF EXISTS `goods_fav`;
CREATE TABLE `goods_fav` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goods_id` varchar(64) COLLATE utf8_bin NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_goods_fav_goods` (`goods_id`),
  KEY `fk_goods_fav_user` (`username`),
  CONSTRAINT `fk_goods_fav_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `fk_goods_fav_user` FOREIGN KEY (`username`) REFERENCES `user_info` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for goods_media
-- ----------------------------
DROP TABLE IF EXISTS `goods_media`;
CREATE TABLE `goods_media` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` varchar(64) COLLATE utf8_bin NOT NULL,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_good_media_good` (`goods_id`),
  CONSTRAINT `fk_good_media_good` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for pintuan
-- ----------------------------
DROP TABLE IF EXISTS `pintuan`;
CREATE TABLE `pintuan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `munbers` int(11) DEFAULT NULL,
  `users` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `pingtuan_price` double DEFAULT NULL,
  `able_to_join` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ----------------------------
-- Table structure for goods_pintuan
-- ----------------------------
DROP TABLE IF EXISTS `goods_pintuan`;
CREATE TABLE `goods_pintuan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goods_id` varchar(64) COLLATE utf8_bin NOT NULL,
  `pintuan_id` varchar(64) COLLATE utf8_bin NOT NULL,
  `number_require` int(11) DEFAULT NULL,
  `number_succcess` int(11) DEFAULT NULL,
  `timeout_hours` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_goods_pintuan_goods` (`goods_id`),
  KEY `pintuan_id` (`pintuan_id`),
  CONSTRAINT `fk_goods_pintuan_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ----------------------------
-- Table structure for pintuan_user
-- ----------------------------
DROP TABLE IF EXISTS `pintuan_user`;
CREATE TABLE `pintuan_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goods_id` varchar(64) COLLATE utf8_bin NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `number_require` int(11) DEFAULT NULL,
  `number_left` int(11) DEFAULT NULL,
  `finished` tinyint(1) DEFAULT NULL,
  `nick` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `avatar_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pintuan_user_goods` (`goods_id`),
  KEY `fk_pintuan_user_user` (`username`),
  CONSTRAINT `fk_pintuan_user_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `fk_pintuan_user_user` FOREIGN KEY (`username`) REFERENCES `user_info` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for properties
-- ----------------------------
DROP TABLE IF EXISTS `properties`;
CREATE TABLE `properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goods_id` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `indexs` int(11) DEFAULT NULL,
  `name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_good_properties_good` (`goods_id`),
  CONSTRAINT `fk_good_properties_good` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for properties_detail
-- ----------------------------
DROP TABLE IF EXISTS `properties_detail`;
CREATE TABLE `properties_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `properties_id` int(11) DEFAULT NULL,
  `indexs` int(11) DEFAULT NULL,
  `name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_properties_detail_properties` (`properties_id`),
  CONSTRAINT `FK_properties_detail_properties` FOREIGN KEY (`properties_id`) REFERENCES `properties` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for slide_container
-- ----------------------------
DROP TABLE IF EXISTS `slide_container`;
CREATE TABLE `slide_container` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goods_id` bigint(11) DEFAULT NULL,
  `pic_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `cellphone` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `wechat_open_id` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `province` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `avatar_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nick_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for verification_code
-- ----------------------------
DROP TABLE IF EXISTS `verification_code`;
CREATE TABLE `verification_code` (
  `id` varchar(150) COLLATE utf8_bin NOT NULL,
  `captcha` varchar(150) COLLATE utf8_bin NOT NULL,
  `expire_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ----------------------------
-- Table structure for goods_recommend
-- ----------------------------
DROP TABLE IF EXISTS `goods_recommend`;
CREATE TABLE `goods_recommend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  KEY `fk_goods_recommend_goods` (`goods_id`),
  CONSTRAINT `fk_goods_recommend_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



SET FOREIGN_KEY_CHECKS = 1;
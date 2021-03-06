SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
SET GLOBAL TIME_ZONE = '+8:00';

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` VARCHAR(64) COLLATE utf8_bin NOT NULL UNIQUE,
  `created_at`  TIMESTAMP                    NOT NULL            DEFAULT CURRENT_TIMESTAMP,
  `level`       INT(11)                                          DEFAULT NULL,
  `name`        VARCHAR(64) COLLATE utf8_bin                     DEFAULT NULL,
  `pid`         VARCHAR(64) COLLATE utf8_bin                     DEFAULT NULL,
  `is_used`     BOOLEAN                                          DEFAULT NULL,
  `icon`        VARCHAR(255) COLLATE utf8_bin                    DEFAULT NULL,
  `indexs`      INT(11)                                          DEFAULT NULL,
  PRIMARY KEY (`category_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for coupons
-- ----------------------------
DROP TABLE IF EXISTS `coupons`;
CREATE TABLE `coupons` (
  `id`                      INT(11)                      NOT NULL AUTO_INCREMENT,
  `created_at`              TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `coupon_id`               VARCHAR(64) COLLATE utf8_bin NOT NULL UNIQUE,
  `pic_url`                 VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `link_url`                VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `coupon_name`             VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  `type`                    VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `amount_of_money`         DOUBLE                                DEFAULT NULL,
  `requirement_consumption` DOUBLE                                DEFAULT NULL,
  `expiry_time_at`          TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `validity_day`            INT(11)                               DEFAULT NULL,
  `remarks`                 VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `is_available`            BOOLEAN                               DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for coupons_users
-- ----------------------------
DROP TABLE IF EXISTS `coupons_users`;
CREATE TABLE `coupons_users` (
  `user_name`               VARCHAR(255) COLLATE utf8_bin NOT NULL,
  `coupon_id`               VARCHAR(64) COLLATE utf8_bin  NOT NULL,
  `orders_id`               VARCHAR(64) COLLATE utf8_bin           DEFAULT NULL,
  `is_used`                 BOOLEAN                                DEFAULT NULL,
  `coupon_name`             VARCHAR(64) COLLATE utf8_bin           DEFAULT NULL,
  `pic_url`                 VARCHAR(255) COLLATE utf8_bin          DEFAULT NULL,
  `expiry_time_at`          TIMESTAMP                     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `remarks`                 VARCHAR(255) COLLATE utf8_bin          DEFAULT NULL,
  `amount_of_money`         DOUBLE                                 DEFAULT NULL,
  `requirement_consumption` DOUBLE                                 DEFAULT NULL,
  PRIMARY KEY (`user_name`, `coupon_id`),
  KEY `fk_coupons_users_orders` (`orders_id`),
  CONSTRAINT `fk_coupons_users_orders` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`orders_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for event_publishing_tracker
-- ----------------------------
DROP TABLE IF EXISTS `event_publishing_tracker`;
CREATE TABLE `event_publishing_tracker` (
  `id`                             BIGINT(11) NOT NULL AUTO_INCREMENT,
  `most_recent_published_event_id` BIGINT(11)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_event_publishing_tracker_most_recent_published_event_id` (`most_recent_published_event_id`),
  CONSTRAINT `FK_event_publishing_tracker_most_recent_published_event_id` FOREIGN KEY (`most_recent_published_event_id`) REFERENCES `event_to_publish` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for event_to_publish
-- ----------------------------
DROP TABLE IF EXISTS `event_to_publish`;
CREATE TABLE `event_to_publish` (
  `id`      BIGINT(11)                    NOT NULL AUTO_INCREMENT,
  `name`    VARCHAR(150) COLLATE utf8_bin NOT NULL,
  `content` VARCHAR(150) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` INT(11)                        NOT NULL,
  `version`        VARCHAR(50) COLLATE utf8_bin            DEFAULT NULL,
  `description`    VARCHAR(200) COLLATE utf8_bin  NOT NULL,
  `type`           VARCHAR(20) COLLATE utf8_bin   NOT NULL,
  `script`         VARCHAR(1000) COLLATE utf8_bin NOT NULL,
  `checksum`       INT(11)                                 DEFAULT NULL,
  `installed_by`   VARCHAR(100) COLLATE utf8_bin  NOT NULL,
  `installed_on`   TIMESTAMP                      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` INT(11)                        NOT NULL,
  `success`        TINYINT(1)                     NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for function_menus
-- ----------------------------
DROP TABLE IF EXISTS `function_menus`;
CREATE TABLE `function_menus` (
  `id`         INT(11)   NOT NULL            AUTO_INCREMENT,
  `created_at` TIMESTAMP NOT NULL            DEFAULT CURRENT_TIMESTAMP,
  `link_url`   VARCHAR(255) COLLATE utf8_bin DEFAULT NULL,
  `pic_url`    VARCHAR(255) COLLATE utf8_bin DEFAULT NULL,
  `orders`     INT(11)                       DEFAULT NULL,
  `title`      VARCHAR(16) COLLATE utf8_bin  DEFAULT NULL,
  `is_remove`  BOOLEAN                       DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id`                INT(11)                      NOT NULL AUTO_INCREMENT,
  `created_at`        TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goods_id`          VARCHAR(64) COLLATE utf8_bin NOT NULL UNIQUE,
  `category_id`       VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `name`              VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `characteristic`    VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `main_pic`          VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `number_orders`     INT(11)                               DEFAULT NULL,
  `is_sales`          BOOLEAN                               DEFAULT FALSE,
  `is_support_group`  BOOLEAN                               DEFAULT NULL,
  `content`           TEXT COLLATE utf8_bin,
  `views`             INT(11)                               DEFAULT NULL,
  `number_fav`        INT(11)                               DEFAULT NULL,
  `number_reputation` INT(11)                               DEFAULT NULL,
  `stores`            INT(11)                               DEFAULT NULL,
  `remark`            VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

# 感觉此表有点多余。、。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
-- ----------------------------
-- Table structure for goods_category
-- ----------------------------
DROP TABLE IF EXISTS `goods_category`;
CREATE TABLE `goods_category` (
  `id`          INT(11) NOT NULL              AUTO_INCREMENT,
  `icon`        VARCHAR(255) COLLATE utf8_bin DEFAULT NULL,
  `is_used`     BOOLEAN                       DEFAULT NULL,
  `name`        VARCHAR(64) COLLATE utf8_bin  DEFAULT NULL,
  `category_id` VARCHAR(64) COLLATE utf8_bin  DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_goods` (`category_id`),
  CONSTRAINT `fk_category_goods` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for goods_fav
-- ----------------------------
DROP TABLE IF EXISTS `goods_fav`;
CREATE TABLE `goods_fav` (
  `id`         INT(11)                      NOT NULL AUTO_INCREMENT,
  `created_at` TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goods_id`   VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `username`   VARCHAR(64) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_goods_fav_goods` (`goods_id`),
  KEY `fk_goods_fav_user` (`username`),
  CONSTRAINT `fk_goods_fav_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `fk_goods_fav_user` FOREIGN KEY (`username`) REFERENCES `user_info` (`user_name`),
  UNIQUE KEY `username_goods_id` (goods_id, username)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for goods_media
-- ----------------------------
DROP TABLE IF EXISTS `goods_media`;
CREATE TABLE `goods_media` (
  `id`       INT(11)                      NOT NULL AUTO_INCREMENT,
  `goods_id` VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `url`      VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `type`     VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_good_media_good` (`goods_id`),
  CONSTRAINT `fk_good_media_good` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for group_booking_properties
-- ----------------------------
DROP TABLE IF EXISTS `group_booking_properties`;
CREATE TABLE `group_booking_properties` (
  `id`             INT(11)                      NOT NULL            AUTO_INCREMENT,
  `created_at`     TIMESTAMP                    NOT NULL            DEFAULT CURRENT_TIMESTAMP,
  `goods_id`       VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `number_require` INT(11)                                          DEFAULT NULL,
  `timeout_hours`  INT(11)                                          DEFAULT NULL,
  `is_remove`      BOOLEAN                                          DEFAULT NULL,
  # 已经拼成的单数
  `number_success` INT(11)                                          DEFAULT NULL,

  KEY `fk_group_booking_properties_goods` (`goods_id`),
  CONSTRAINT `fk_group_booking_properties_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for group_booking
-- ----------------------------
DROP TABLE IF EXISTS `group_booking`;
CREATE TABLE `group_booking` (
  `id`               INT(11)                      NOT NULL              AUTO_INCREMENT,
  `created_at`       TIMESTAMP                    NOT NULL              DEFAULT CURRENT_TIMESTAMP,
  `expiry_time_at`   TIMESTAMP                    NOT NULL              DEFAULT CURRENT_TIMESTAMP,
  `goods_id`         VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `group_booking_id` VARCHAR(64) COLLATE utf8_bin NOT NULL UNIQUE,
  `number_require`   INT(11)                                            DEFAULT NULL,
  `number_left`      INT(11)                                            DEFAULT NULL,
  `opener`           VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `status`           VARCHAR(64) COLLATE utf8_bin NOT NULL,

  PRIMARY KEY (`id`),

  KEY `fk_group_booking_goods` (`goods_id`),
  KEY `fk_group_booking_user` (`opener`),

  CONSTRAINT `fk_group_booking_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `fk_group_booking_user` FOREIGN KEY (`opener`) REFERENCES `user_info` (`user_name`)

)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for group_booking_joiner
-- ----------------------------
DROP TABLE IF EXISTS `group_booking_joiner`;
CREATE TABLE `group_booking_joiner` (
  `id`               INT(11)                      NOT NULL AUTO_INCREMENT,
  `created_at`       TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goods_id`         VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `username`         VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `group_booking_id` VARCHAR(64) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_group_booking_joiner_goods` (`goods_id`),
  KEY `fk_group_booking_joiner_user` (`username`),
  KEY `fk_group_booking_id_group_booking` (`group_booking_id`),

  CONSTRAINT `fk_group_booking_joiner_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `fk_group_booking_joiner_user` FOREIGN KEY (`username`) REFERENCES `user_info` (`user_name`),
  CONSTRAINT `fk_group_booking_id_group_booking` FOREIGN KEY (`group_booking_id`) REFERENCES `group_booking` (`group_booking_id`)

)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for properties
-- ----------------------------
DROP TABLE IF EXISTS `properties`;
CREATE TABLE `properties` (
  `id`            INT(11)                      NOT NULL           AUTO_INCREMENT,
  `created_at`    TIMESTAMP                    NOT NULL           DEFAULT CURRENT_TIMESTAMP,
  `properties_id` VARCHAR(64) COLLATE utf8_bin NOT NULL UNIQUE,
  `goods_id`      VARCHAR(64) COLLATE utf8_bin                    DEFAULT NULL,
  `indexs`        INT(11)                                         DEFAULT NULL,
  `name`          VARCHAR(64) COLLATE utf8_bin                    DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_good_properties_good` (`goods_id`),
  CONSTRAINT `fk_good_properties_good` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for properties_detail
-- ----------------------------
DROP TABLE IF EXISTS `properties_detail`;
CREATE TABLE `properties_detail` (
  `id`            INT(11)                      NOT NULL            AUTO_INCREMENT,
  `created_at`    TIMESTAMP                    NOT NULL            DEFAULT CURRENT_TIMESTAMP,
  `detail_id`     VARCHAR(64) COLLATE utf8_bin NOT NULL UNIQUE,
  `properties_id` VARCHAR(64) COLLATE utf8_bin                     DEFAULT NULL,
  `indexs`        INT(11)                                          DEFAULT NULL,
  `name`          VARCHAR(128) COLLATE utf8_bin                    DEFAULT NULL,
  `remark`        VARCHAR(128) COLLATE utf8_bin                    DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_properties_detail_properties` (`properties_id`),
  CONSTRAINT `FK_properties_detail_properties` FOREIGN KEY (`properties_id`) REFERENCES `properties` (`properties_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for goods_price
-- ----------------------------
DROP TABLE IF EXISTS `goods_price`;
CREATE TABLE `goods_price` (
  `id`               INT(11)   NOT NULL            AUTO_INCREMENT,
  `created_at`       TIMESTAMP NOT NULL            DEFAULT CURRENT_TIMESTAMP,
  `goods_id`         VARCHAR(64) COLLATE utf8_bin  DEFAULT NULL,
  `properties_joint` VARCHAR(128) COLLATE utf8_bin DEFAULT NULL,
  # 颜色+尺寸
  `goods_label`      VARCHAR(128) COLLATE utf8_bin DEFAULT NULL,
  `price`            DOUBLE                        DEFAULT NULL,
  # 价格类型、拼团、直接购买
  `type`             VARCHAR(64) COLLATE utf8_bin  DEFAULT NULL,
  `remark`           VARCHAR(128) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_goods_price_good` (`goods_id`),
  CONSTRAINT `fk_goods_price_good` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for slide_container
-- ----------------------------
DROP TABLE IF EXISTS `slide_container`;
CREATE TABLE `slide_container` (
  `id`         INT(11)   NOT NULL            AUTO_INCREMENT,
  `created_at` TIMESTAMP NOT NULL            DEFAULT CURRENT_TIMESTAMP,
  `goods_id`   VARCHAR(64) COLLATE utf8_bin  DEFAULT NULL,
  `pic_url`    VARCHAR(255) COLLATE utf8_bin DEFAULT NULL,
  `is_remove`  BOOLEAN                       DEFAULT NULL,
  `indexs`     INT(11)                       DEFAULT NULL,
  `type`       VARCHAR(32)                   DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id`             INT(11)                      NOT NULL AUTO_INCREMENT,
  `created_at`     TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_name`      VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `cellphone`      VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  `wechat_open_id` VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  `country`        VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  `province`       VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  `city`           VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  `gender`         INT(11)                               DEFAULT NULL,
  `avatar_url`     VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `nick_name`      VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_name` (`user_name`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for verification_code
-- ----------------------------
DROP TABLE IF EXISTS `verification_code`;
CREATE TABLE `verification_code` (
  `id`        VARCHAR(150) COLLATE utf8_bin NOT NULL,
  `captcha`   VARCHAR(150) COLLATE utf8_bin NOT NULL,
  `expire_at` TIMESTAMP                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for goods_recommend
-- ----------------------------
DROP TABLE IF EXISTS `goods_recommend`;
CREATE TABLE `goods_recommend` (
  `id`       INT(11) NOT NULL             AUTO_INCREMENT,
  `goods_id` VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,
  KEY `fk_goods_recommend_goods` (`goods_id`),
  CONSTRAINT `fk_goods_recommend_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for goods_cut_down_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_cut_down_info`;
CREATE TABLE `goods_cut_down_info` (
  `id`                 INT(11) NOT NULL             AUTO_INCREMENT,
  `goods_id`           VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,

  # 每砍一刀最高金额
  `max_amount_per_cut` DOUBLE                       DEFAULT NULL,
  #  每砍一刀最低金额
  `min_amount_per_cut` DOUBLE                       DEFAULT NULL,
  # 有效时间，按小时计算
  `effective_time`     INT                          DEFAULT NULL,
  # 该商品最高可砍金额
  `max_cut_down`       DOUBLE                       DEFAULT NULL,

  #   最高多少人帮忙砍
  `max_helper`         INT(11)                      DEFAULT NULL,
  # 砍价信息是否设置，INIT 未设置， FINISH 设置过
  `status`             VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,

  KEY `fk_goods_cut_down_info_goods` (`goods_id`),
  CONSTRAINT `fk_goods_cut_down_info_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for goods_cut_down_list
-- ----------------------------
DROP TABLE IF EXISTS `goods_cut_downs`;
CREATE TABLE `goods_cut_downs` (
  `id`               INT(11)                             NOT NULL              AUTO_INCREMENT,

  `cut_down_id`      VARCHAR(64) COLLATE utf8_bin UNIQUE NOT NULL,

  `created_at`       TIMESTAMP                           NOT NULL              DEFAULT CURRENT_TIMESTAMP,
  `expiry_time_at`   TIMESTAMP                           NOT NULL              DEFAULT CURRENT_TIMESTAMP,
  #   发起人
  `initiator`        VARCHAR(255) COLLATE utf8_bin                             DEFAULT NULL,
  #   当前价格
  `current_price`    DOUBLE                                                    DEFAULT NULL,
  #   已经砍掉的价格
  `cut_total_amount` DOUBLE                                                    DEFAULT NULL,
  #   帮忙砍价的人数
  `helper_number`    INT(11)                                                   DEFAULT NULL,
  #   原价
  `original_price`   DOUBLE                                                    DEFAULT NULL,
  # 底价
  `base_price`       DOUBLE                                                    DEFAULT NULL,
  # 商品图片
  `goods_pic`        VARCHAR(255) COLLATE utf8_bin                             DEFAULT NULL,
  # 商品名称
  `goods_name`       VARCHAR(255) COLLATE utf8_bin                             DEFAULT NULL,
  # 购买的数量
  `buy_number`       INT(11)                                                   DEFAULT NULL,

  `goods_id`         VARCHAR(64) COLLATE utf8_bin                              DEFAULT NULL,
  `properties_joint` VARCHAR(128) COLLATE utf8_bin                             DEFAULT NULL,
  # 颜色+尺寸
  `goods_label`      VARCHAR(128) COLLATE utf8_bin                             DEFAULT NULL,

  `status`           VARCHAR(64) COLLATE utf8_bin                              DEFAULT NULL,

  KEY `fk_goods_cut_downs_goods` (`goods_id`),
  CONSTRAINT `fk_goods_cut_downs_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  PRIMARY KEY (`id`),
  UNIQUE KEY `cut_downs_goods` (`initiator`, `goods_id`)

)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for goods_cut_down_helper_list
-- ----------------------------
DROP TABLE IF EXISTS `goods_cut_down_helper`;
CREATE TABLE `goods_cut_down_helper` (
  `id`             INT(11)   NOT NULL              AUTO_INCREMENT,

  `cut_down_id`    VARCHAR(64) COLLATE utf8_bin    DEFAULT NULL,

  `created_at`     TIMESTAMP NOT NULL              DEFAULT CURRENT_TIMESTAMP,
  #   参与者
  `participant`    VARCHAR(255) COLLATE utf8_bin   DEFAULT NULL,
  #  砍掉的金额
  `cut_down_price` DOUBLE                          DEFAULT NULL,


  KEY `fk_goods_cut_down_helper_cur_down` (`cut_down_id`),
  CONSTRAINT `fk_goods_cut_down_helper_cur_down` FOREIGN KEY (`cut_down_id`) REFERENCES `goods_cut_downs` (`cut_down_id`),

  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for goods_cut_down_helper_list
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `id`              INT(11)                      NOT NULL              AUTO_INCREMENT,
  `created_at`      TIMESTAMP                    NOT NULL              DEFAULT CURRENT_TIMESTAMP,
  `user_address_id` VARCHAR(64) COLLATE utf8_bin NOT NULL UNIQUE,
  `username`        VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `province_code`   VARCHAR(8) COLLATE utf8_bin                        DEFAULT NULL,
  `province`        VARCHAR(32) COLLATE utf8_bin                       DEFAULT NULL,
  `city_code`       VARCHAR(8) COLLATE utf8_bin                        DEFAULT NULL,
  `city`            VARCHAR(32) COLLATE utf8_bin                       DEFAULT NULL,
  `area_code`       VARCHAR(8) COLLATE utf8_bin                        DEFAULT NULL,
  `area`            VARCHAR(32) COLLATE utf8_bin                       DEFAULT NULL,
  `address`         VARCHAR(255) COLLATE utf8_bin                      DEFAULT NULL,
  #邮政编码
  `postal_code`     VARCHAR(8) COLLATE utf8_bin                        DEFAULT NULL,
  `is_default`      BOOLEAN                                            DEFAULT NULL,
  `link_man`        VARCHAR(32) COLLATE utf8_bin NOT NULL,
  `mobile`          VARCHAR(32) COLLATE utf8_bin NOT NULL,
  `is_remove`       BOOLEAN                                            DEFAULT NULL,

  KEY `fk_user_address_user` (`username`),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_address_user` FOREIGN KEY (`username`) REFERENCES `user_info` (`user_name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for goods_recommend
-- ----------------------------
DROP TABLE IF EXISTS `cms`;
CREATE TABLE `cms` (
  `id`             INT(11)                      NOT NULL AUTO_INCREMENT,
  `created_at`     TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,

  `cms_id`         VARCHAR(64) COLLATE utf8_bin NOT NULL UNIQUE,
  `indexs`         INT(11)                               DEFAULT NULL,
  `author`         VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  `pic`            VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `title`          VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `descript`       VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `content`        TEXT COLLATE utf8_bin,
  `is_recommend`   BOOLEAN                               DEFAULT NULL,
  `comment_number` INT(11)                      NOT NULL,
  `category_id`    VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  `min_price`      DOUBLE                                DEFAULT NULL,
  `views`          INT(11)                               DEFAULT NULL,

  PRIMARY KEY (`id`),
  KEY `fk_category_cms` (`category_id`),
  CONSTRAINT `fk_category_cms` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id`             INT(11)                      NOT NULL AUTO_INCREMENT,
  `created_at`     TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,

  `orders_id`      VARCHAR(64) COLLATE utf8_bin NOT NULL UNIQUE,
  `username`       VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `status`         VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  `original_price` DOUBLE                                DEFAULT NULL,
  `discount`       DOUBLE                                DEFAULT NULL,
  `actual_price`   DOUBLE                                DEFAULT NULL,
  `remark`         VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  `order_type`     VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,

  PRIMARY KEY (`id`),
  KEY `fk_orders_user` (`username`),
  CONSTRAINT `fk_orders_user` FOREIGN KEY (`username`) REFERENCES `user_info` (`user_name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id`          INT(11)                      NOT NULL AUTO_INCREMENT,
  `created_at`  TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,

  `detail_id`   VARCHAR(64) COLLATE utf8_bin NOT NULL UNIQUE,

  `orders_id`   VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `goods_name`  VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  `goods_label` VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  `buy_number`  INT(11)                               DEFAULT NULL,
  `unit_price`  DOUBLE                                DEFAULT NULL,
  `amount`      DOUBLE                                DEFAULT NULL,
  `goods_id`    VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `goods_pic`   VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,

  PRIMARY KEY (`id`),
  KEY `fk_order_detail_orders` (`orders_id`),
  CONSTRAINT `fk_order_detail_orders` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`orders_id`)

)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for order_transport
-- ----------------------------
DROP TABLE IF EXISTS `order_transport`;
CREATE TABLE `order_transport` (
  `id`           INT(11)                      NOT NULL AUTO_INCREMENT,
  `created_at`   TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,

  `transport_id` VARCHAR(64) COLLATE utf8_bin NOT NULL UNIQUE,

  `orders_id`    VARCHAR(64) COLLATE utf8_bin NOT NULL,

  `address`      VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `link_man`     VARCHAR(32) COLLATE utf8_bin          DEFAULT NULL,
  `mobile`       VARCHAR(32) COLLATE utf8_bin          DEFAULT NULL,

  PRIMARY KEY (`id`),
  KEY `fk_order_transport_orders` (`orders_id`),
  CONSTRAINT `fk_order_transport_orders` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`orders_id`)

)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `shopping_cart_id` VARCHAR(64) COLLATE utf8_bin UNIQUE NOT NULL,
  `created_at`       TIMESTAMP                           NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goods_id`         VARCHAR(64) COLLATE utf8_bin        NOT NULL,
  `username`         VARCHAR(64) COLLATE utf8_bin        NOT NULL,
  `properties_joint` VARCHAR(128) COLLATE utf8_bin       NOT NULL,
  `buy_number`       INT(11)                                      DEFAULT NULL,
  PRIMARY KEY (`shopping_cart_id`),
  KEY `fk_shopping_cart_goods` (`goods_id`),
  KEY `fk_shopping_cart_user` (`username`),
  CONSTRAINT `fk_shopping_cart_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `fk_shopping_cart_user` FOREIGN KEY (`username`) REFERENCES `user_info` (`user_name`),
  UNIQUE KEY `username_shopping_cart` (goods_id, username, properties_joint)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `created_at` TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `score`      INT(11)                               DEFAULT NULL,
  `account`    DOUBLE                                DEFAULT NULL,
  `username`   VARCHAR(64) COLLATE utf8_bin NOT NULL UNIQUE,

  KEY `fk_user_account_user` (`username`),
  CONSTRAINT `fk_user_account_user` FOREIGN KEY (`username`) REFERENCES `user_info` (`user_name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for user_score_record
-- ----------------------------
DROP TABLE IF EXISTS `user_score_record`;
CREATE TABLE `user_score_record` (
  `user_score_record_id` VARCHAR(64) COLLATE utf8_bin UNIQUE NOT NULL,
  `created_at`           TIMESTAMP                           NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_sign_day`        VARCHAR(64) COLLATE utf8_bin                 DEFAULT NULL,
  `continued_days`       INT(11)                                      DEFAULT 0,
  `username`             VARCHAR(64) COLLATE utf8_bin        NOT NULL,

  `score_to_day`         INT(11)                                      DEFAULT NULL,
  `source_after`         INT(11)                                      DEFAULT NULL,

  `source`               VARCHAR(64) COLLATE utf8_bin                 DEFAULT NULL,

  PRIMARY KEY (`user_score_record_id`),
  KEY `fk_user_score_record_user` (`username`),
  CONSTRAINT `fk_user_score_record_user` FOREIGN KEY (`username`) REFERENCES `user_info` (`user_name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `evaluate_id`    VARCHAR(64) COLLATE utf8_bin UNIQUE  NOT NULL,
  `created_at`     TIMESTAMP                            NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `evaluate_score` VARCHAR(255) COLLATE utf8_bin                 DEFAULT NULL,
  `pics`           TEXT COLLATE utf8_bin,
  `object_id`      VARCHAR(64) COLLATE utf8_bin         NOT NULL,
  `object_type`    VARCHAR(16) COLLATE utf8_bin         NOT NULL,
  `label`          VARCHAR(64) COLLATE utf8_bin                  DEFAULT NULL,
  `content`        VARCHAR(255) COLLATE utf8_bin                 DEFAULT NULL,
  `username`       VARCHAR(64) COLLATE utf8_bin         NOT NULL,
  `is_reply`       BOOLEAN                                       DEFAULT FALSE,

  PRIMARY KEY (`evaluate_id`),
  KEY `fk_evaluate_user` (`username`),
  CONSTRAINT `fk_evaluate_user` FOREIGN KEY (`username`) REFERENCES `user_info` (`user_name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;


SET FOREIGN_KEY_CHECKS = 1;
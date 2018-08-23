SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
SET GLOBAL TIME_ZONE = '+8:00';

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id`         INT(11)   NOT NULL            AUTO_INCREMENT,
  `created_at` TIMESTAMP NOT NULL            DEFAULT CURRENT_TIMESTAMP,
  `level`      INT(11)                       DEFAULT NULL,
  `name`       VARCHAR(64) COLLATE utf8_bin  DEFAULT NULL,
  `pid`        INT(11)                       DEFAULT NULL,
  `is_use`     TINYINT(1)                    DEFAULT NULL,
  `icon`       VARCHAR(255) COLLATE utf8_bin DEFAULT NULL,
  `indexs`     INT(11)                       DEFAULT NULL,
  PRIMARY KEY (`id`)
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
  `id`                       INT(11)                      NOT NULL AUTO_INCREMENT,
  `created_at`               TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `coupon_id`                VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `pic_url`                  VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `link_url`                 VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `coupon_name`              VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  `type`                     VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `amount_of_money`          DOUBLE                                DEFAULT NULL,
  `requirement_consumption`  DOUBLE                                DEFAULT NULL,
  `period_of_validity_to_at` DATETIME                     NOT NULL,
  `remarks`                  VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `available`                TINYINT(1)                            DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `coupon_id` (`coupon_id`)
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
  `user_name` VARCHAR(255) COLLATE utf8_bin NOT NULL,
  `coupon_id` VARCHAR(64) COLLATE utf8_bin  NOT NULL,
  `used`      TINYINT(1) DEFAULT NULL,
  PRIMARY KEY (`user_name`, `coupon_id`),
  UNIQUE KEY `user_name` (`user_name`)
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
  `status`     TINYINT(1)                    DEFAULT NULL,
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
  `id`                 INT(11)                      NOT NULL AUTO_INCREMENT,
  `created_at`         TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goods_id`           VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `category_id`        INT(11)                               DEFAULT NULL,
  `name`               VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `characteristic`     VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `main_pic`           VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  `original_price`     DOUBLE                                DEFAULT NULL,
  `min_price`          DOUBLE                                DEFAULT NULL,
  `pingtuan_price`     DOUBLE                                DEFAULT NULL,
  `concessional_price` DOUBLE                                DEFAULT NULL,
  `number_orders`      INT(11)                               DEFAULT NULL,
  `status`             TINYINT(1)                            DEFAULT NULL,
  `pingtuan`           TINYINT(1)                            DEFAULT NULL,
  `content`            TEXT COLLATE utf8_bin,
  `views`              INT(11)                               DEFAULT NULL,
  `number_fav`         INT(11)                               DEFAULT NULL,
  `number_reputation`  INT(11)                               DEFAULT NULL,
  `stores`             INT(11)                               DEFAULT NULL,
  `remark`             VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `goods_id` (`goods_id`)
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
  `is_use`      TINYINT(1)                    DEFAULT NULL,
  `name`        VARCHAR(64) COLLATE utf8_bin  DEFAULT NULL,
  `category_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_goods` (`category_id`),
  CONSTRAINT `fk_category_goods` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
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
  CONSTRAINT `fk_goods_fav_user` FOREIGN KEY (`username`) REFERENCES `user_info` (`user_name`)
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
-- Table structure for pintuan
-- ----------------------------
DROP TABLE IF EXISTS `pintuan`;
CREATE TABLE `pintuan` (
  `id`             INT(11)   NOT NULL            AUTO_INCREMENT,
  `created_at`     TIMESTAMP NOT NULL            DEFAULT CURRENT_TIMESTAMP,
  `munbers`        INT(11)                       DEFAULT NULL,
  `users`          VARCHAR(255) COLLATE utf8_bin DEFAULT NULL,
  `goods_id`       INT(11)                       DEFAULT NULL,
  `pingtuan_price` DOUBLE                        DEFAULT NULL,
  `able_to_join`   INT(11)                       DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for goods_pintuan
-- ----------------------------
DROP TABLE IF EXISTS `goods_pintuan`;
CREATE TABLE `goods_pintuan` (
  `id`              INT(11)                      NOT NULL AUTO_INCREMENT,
  `created_at`      TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goods_id`        VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `pintuan_id`      VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `number_require`  INT(11)                               DEFAULT NULL,
  `number_succcess` INT(11)                               DEFAULT NULL,
  `timeout_hours`   INT(11)                               DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_goods_pintuan_goods` (`goods_id`),
  KEY `pintuan_id` (`pintuan_id`),
  CONSTRAINT `fk_goods_pintuan_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------
-- Table structure for pintuan_user
-- ----------------------------
DROP TABLE IF EXISTS `pintuan_user`;
CREATE TABLE `pintuan_user` (
  `id`             INT(11)                      NOT NULL AUTO_INCREMENT,
  `created_at`     TIMESTAMP                    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goods_id`       VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `username`       VARCHAR(64) COLLATE utf8_bin NOT NULL,
  `number_require` INT(11)                               DEFAULT NULL,
  `number_left`    INT(11)                               DEFAULT NULL,
  `finished`       TINYINT(1)                            DEFAULT NULL,
  `nick`           VARCHAR(64) COLLATE utf8_bin          DEFAULT NULL,
  `avatar_url`     VARCHAR(255) COLLATE utf8_bin         DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pintuan_user_goods` (`goods_id`),
  KEY `fk_pintuan_user_user` (`username`),
  CONSTRAINT `fk_pintuan_user_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `fk_pintuan_user_user` FOREIGN KEY (`username`) REFERENCES `user_info` (`user_name`)
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
  `id`         INT(11)   NOT NULL           AUTO_INCREMENT,
  `created_at` TIMESTAMP NOT NULL           DEFAULT CURRENT_TIMESTAMP,
  `goods_id`   VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,
  `indexs`     INT(11)                      DEFAULT NULL,
  `name`       VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,
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
  `id`            INT(11)   NOT NULL            AUTO_INCREMENT,
  `created_at`    TIMESTAMP NOT NULL            DEFAULT CURRENT_TIMESTAMP,
  `properties_id` INT(11)                       DEFAULT NULL,
  `indexs`        INT(11)                       DEFAULT NULL,
  `name`          VARCHAR(128) COLLATE utf8_bin DEFAULT NULL,
  `remark`        VARCHAR(128) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_properties_detail_properties` (`properties_id`),
  CONSTRAINT `FK_properties_detail_properties` FOREIGN KEY (`properties_id`) REFERENCES `properties` (`id`)
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
  `goods_id`   BIGINT(11)                    DEFAULT NULL,
  `pic_url`    VARCHAR(255) COLLATE utf8_bin DEFAULT NULL,
  `status`     TINYINT(1)                    DEFAULT NULL,
  `orders`     INT(11)                       DEFAULT NULL,
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

  `goods_id`         VARCHAR(64) COLLATE utf8_bin                              DEFAULT NULL,

  `finished`         BOOLEAN                                                   DEFAULT FALSE,

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
  `is_recommend`   TINYINT(1)                            DEFAULT NULL,
  `comment_number` INT(11)                      NOT NULL,
  `category_id`    INT(11)                      NOT NULL,
  `min_price`      DOUBLE                                DEFAULT NULL,
  `views`          INT(11)                               DEFAULT NULL,

  PRIMARY KEY (`id`),
  KEY `fk_category_cms` (`category_id`),
  CONSTRAINT `fk_category_cms` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
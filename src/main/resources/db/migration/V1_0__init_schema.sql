# --------------- Mysql ---------------

CREATE TABLE IF NOT EXISTS event_to_publish (
  id      BIGINT(11) AUTO_INCREMENT PRIMARY KEY,
  name    VARCHAR(150) NOT NULL,
  content VARCHAR(150) NOT NULL
);

CREATE TABLE IF NOT EXISTS event_publishing_tracker (
  id                             BIGINT(11) AUTO_INCREMENT PRIMARY KEY,
  most_recent_published_event_id BIGINT(11),

  CONSTRAINT FK_event_publishing_tracker_most_recent_published_event_id FOREIGN KEY (most_recent_published_event_id) REFERENCES event_to_publish (id)
);

CREATE TABLE IF NOT EXISTS verification_code (
  id        VARCHAR(150) NOT NULL PRIMARY KEY,
  captcha   VARCHAR(150) NOT NULL,
  expire_at TIMESTAMP    NOT NULL
);

############################################

CREATE TABLE slide_container (
  id         INT PRIMARY KEY AUTO_INCREMENT,
  created_at TIMESTAMP DEFAULT current_timestamp NOT NULL,

  goods_id   BIGINT(11),
  pic_url    VARCHAR(255),
  status     BOOLEAN,
  orders     INT
);

CREATE TABLE function_menus (
  id         INT PRIMARY KEY AUTO_INCREMENT,
  created_at TIMESTAMP DEFAULT current_timestamp NOT NULL,

  link_url   VARCHAR(255),
  pic_url    VARCHAR(255),
  orders     INT,
  title      VARCHAR(16),
  status     BOOLEAN
);


CREATE TABLE user_info (
  id             INT PRIMARY KEY AUTO_INCREMENT,
  created_at     TIMESTAMP DEFAULT current_timestamp NOT NULL,

  user_name      VARCHAR(255) UNICODE                NOT NULL,
  cellphone      VARCHAR(64),
  wechat_open_id VARCHAR(64) UNICODE,
  country        VARCHAR(64),
  province       VARCHAR(64),
  city           VARCHAR(64),
  gender         INT,
  avatarUrl      VARCHAR(255),
  nickName       VARCHAR(255)
);


CREATE TABLE coupons (
  id                       INT PRIMARY KEY AUTO_INCREMENT,
  created_at               TIMESTAMP DEFAULT current_timestamp NOT NULL,

  coupon_id                VARCHAR(64) UNIQUE                  NOT NULL,
  pic_url                  VARCHAR(255),
  link_url                 VARCHAR(255),
  coupon_name              VARCHAR(64),
  type                     VARCHAR(64)                         NOT NULL,
  amount_of_money          DOUBLE,
  requirement_consumption  DOUBLE,
  period_of_validity_to_at DATETIME                            NOT NULL,
  remarks                  VARCHAR(255),
  available                BOOLEAN
);


CREATE TABLE coupons_users (
  user_name VARCHAR(255) UNIQUE NOT NULL,
  coupon_id VARCHAR(64)
);
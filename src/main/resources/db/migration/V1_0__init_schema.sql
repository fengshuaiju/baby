--------------- Postgres ---------------

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
  id        VARCHAR(150)        NOT NULL PRIMARY KEY,
  captcha   VARCHAR(150)        NOT NULL,
  expire_at TIMESTAMP NOT NULL
);


CREATE TABLE goods (
  id INT PRIMARY KEY,
  created_at TIMESTAMP DEFAULT current_timestamp NOT NULL,

  name VARCHAR(150) NOT NULL,
  size VARCHAR(150) NOT NULL
);



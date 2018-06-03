--------------- Postgres ---------------

DROP TABLE IF EXISTS tenant;
CREATE TABLE tenant (
  id INT PRIMARY KEY,
  created_at TIMESTAMP DEFAULT current_timestamp NOT NULL,
  version INT NOT NULL ,

  tenant_id VARCHAR NOT NULL UNIQUE,
  chinese_name VARCHAR NOT NULL,
  code VARCHAR NOT NULL UNIQUE,
  type VARCHAR NOT NULL
);


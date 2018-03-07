# init multi scene databases
CREATE DATABASE saledb;
CREATE DATABASE producedb;

CREATE TABLE tb_order(
  id VARCHAR(64) PRIMARY KEY ,
  seller_id VARCHAR(64) NOT NULL ,
  purchaser_id VARCHAR(64) NOT NULL ,
  good_id VARCHAR(64) NOT NULL ,
  issue_at DATE NOT NULL ,
  expire_at DATE NOT NULL ,
  arrive_at LONGTEXT NOT NULL
);

CREATE TABLE tb_good(
  id VARCHAR(64) PRIMARY KEY ,
  name VARCHAR(64) NOT NULL ,
  price DOUBLE NOT NULL
);

# init master scene databases
CREATE DATABASE masterdb;
CREATE DATABASE slavedb;

CREATE TABLE tb_seller(
  id VARCHAR(64) PRIMARY KEY ,
  name VARCHAR(64) NOT NULL
);

CREATE TABLE tb_purchaser(
  id VARCHAR(64) PRIMARY KEY ,
  name VARCHAR(64) NOT NULL
);

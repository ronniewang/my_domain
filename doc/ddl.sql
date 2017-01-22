CREATE DATABASE IF NOT EXISTS my_domain;

CREATE TABLE IF NOT EXISTS article (
  id           BIGINT    NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  title        TEXT      NOT NULL,
  sub_title    TEXT      NOT NULL,
  content      TEXT      NOT NULL,
  created_time DATETIME  NOT NULL,
  author       CHAR(255) NOT NULL
);
DROP DATABASE IF EXISTS familink;
CREATE DATABASE IF NOT EXISTS familink;
USE familink;
DROP TABLE IF EXISTS `profil`;
CREATE TABLE IF NOT EXISTS `profil` (
  `id_profil` INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `type`      VARCHAR(25) NOT NULL,
  `color`     VARCHAR(7)
);
DROP TABLE IF EXISTS `contact`;
CREATE TABLE IF NOT EXISTS `contact` (
  `id_contact` INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `firstname`  VARCHAR(50) NOT NULL,
  `lastname`   VARCHAR(50) NOT NULL,
  `phone`      VARCHAR(12) NOT NULL,
  `profil_id`  INTEGER     NOT NULL,
  `address`    VARCHAR(50),
  `zipcode`    VARCHAR(5),
  `city`       VARCHAR(50),
  `gravatar`   VARCHAR(255),
  CONSTRAINT fk_contact_profil_id
  FOREIGN KEY (profil_id) REFERENCES
    profil (id_profil)
);
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user`    INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `mail`       VARCHAR(100) NOT NULL,
  `password`   VARCHAR(255) NOT NULL,
  `contact_id` INTEGER      NOT NULL,
  CONSTRAINT ui1_user_mail UNIQUE (mail),
  CONSTRAINT fk_user_contact_id
  FOREIGN KEY (contact_id) REFERENCES
    contact (id_contact)
);
DROP TABLE IF EXISTS `group`;
CREATE TABLE IF NOT EXISTS `group` (
  `id_group`    INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `owner`       INTEGER      NOT NULL,
  `name`        VARCHAR(100) NOT NULL,
  `create_date` TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT ui1_group_name UNIQUE (name),
  CONSTRAINT u12_group_owner UNIQUE (owner)
);
DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `id_message`  INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `sender`      INTEGER      NOT NULL,
  `receiver`    INTEGER      NOT NULL,
  `text`        VARCHAR(140) NOT NULL,
  `create_date` TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `group_id`    INTEGER      NOT NULL,
  `isRead`      BOOLEAN      NOT NULL             DEFAULT FALSE,
  CONSTRAINT fk_message_sender FOREIGN KEY (sender) REFERENCES contact (id_contact),
  CONSTRAINT fk_message_receiver FOREIGN KEY (receiver) REFERENCES contact (id_contact),
  CONSTRAINT fk_message_group_id FOREIGN KEY (group_id) REFERENCES `group` (id_group)
);
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE IF NOT EXISTS `favorite` (
  `user_id`    INTEGER NOT NULL,
  `contact_id` INTEGER NOT NULL,
  `group_id`   INTEGER NOT NULL,
  CONSTRAINT fk_favorite_user_id FOREIGN KEY (user_id) REFERENCES user (id_user),
  CONSTRAINT fk_favorite_contact_id FOREIGN KEY (contact_id) REFERENCES contact (id_contact),
  CONSTRAINT fk_favorite_group_id FOREIGN KEY (group_id) REFERENCES `group` (id_group),
  CONSTRAINT ui1_favorite_user_contact_group UNIQUE (user_id, contact_id, group_id)
);
DROP TABLE IF EXISTS `res_pwd_token`;
CREATE TABLE IF NOT EXISTS `res_pwd_token` (
  `id_token` INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `token`    VARCHAR(255) NOT NULL,
  `is_used`  BOOLEAN      NOT NULL             DEFAULT FALSE
);
DROP TABLE IF EXISTS `group_contact`;
CREATE TABLE IF NOT EXISTS `group_contact` (
  `id_group_contact` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `group_id`         INTEGER NOT NULL,
  `contact_id`       INTEGER NOT NULL,
  CONSTRAINT fk_group_contact_group_id FOREIGN KEY (group_id) REFERENCES `group` (id_group),
  CONSTRAINT fk_group_contact_contact_id FOREIGN KEY (contact_id) REFERENCES contact (id_contact),
  CONSTRAINT ui1_group_contact_contact_group UNIQUE (contact_id, group_id)
);

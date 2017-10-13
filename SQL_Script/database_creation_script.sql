DROP DATABASE IF EXISTS `familink`;
CREATE DATABASE IF NOT EXISTS `familink`;
USE `familink`;
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
  `gravatar`   VARCHAR(255)
);
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user`    INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `mail`       VARCHAR(100) NOT NULL,
  `password`   VARCHAR(255) NOT NULL,
  `contact_id` INTEGER      NOT NULL
);
DROP TABLE IF EXISTS `group`;
CREATE TABLE IF NOT EXISTS `group` (
  `id_group`    INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `owner`       INTEGER      NOT NULL,
  `name`        VARCHAR(100) NOT NULL,
  `create_date` TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP
);
DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `id_message`  INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `sender`      INTEGER      NOT NULL,
  `receiver`    INTEGER      NOT NULL,
  `text`        VARCHAR(140) NOT NULL,
  `create_date` TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `group_id`    INTEGER      NOT NULL,
  `isRead`      BOOLEAN      NOT NULL             DEFAULT FALSE
);
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE IF NOT EXISTS `favorite` (
  `user_id`    INTEGER NOT NULL,
  `contact_id` INTEGER NOT NULL,
  `group_id`   INTEGER NOT NULL
);
DROP TABLE IF EXISTS `res_pwd_token`;
CREATE TABLE IF NOT EXISTS `res_pwd_token` (
  `id_token` INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `token`    VARCHAR(255) NOT NULL,
  `is_used`  BOOLEAN      NOT NULL             DEFAULT FALSE
);
DROP TABLE IF EXISTS `group_contact`;
CREATE TABLE IF NOT EXISTS `group_contact` (
  `group_id`         INTEGER NOT NULL,
  `contact_id`       INTEGER NOT NULL
);
ALTER TABLE `profil`
    ADD CONSTRAINT ui1_profil_type UNIQUE (type);
ALTER TABLE `contact`
  ADD CONSTRAINT `fk_contact_profil_id` FOREIGN KEY (profil_id) REFERENCES profil (id_profil);
ALTER TABLE `user`
  ADD CONSTRAINT ui1_user_mail UNIQUE (mail),
  ADD CONSTRAINT ui2_user_contact_id UNIQUE (contact_id),
  ADD CONSTRAINT fk_user_contact_id FOREIGN KEY (contact_id) REFERENCES contact (id_contact);
ALTER TABLE `group`
  ADD CONSTRAINT ui1_group_name UNIQUE (name),
  ADD CONSTRAINT ui2_group_owner UNIQUE (owner),
  ADD CONSTRAINT fk_group_owner FOREIGN KEY (owner) REFERENCES user (id_user);
ALTER TABLE `message`
  ADD CONSTRAINT fk_message_sender FOREIGN KEY (sender) REFERENCES contact (id_contact),
  ADD CONSTRAINT fk_message_receiver FOREIGN KEY (receiver) REFERENCES contact (id_contact),
  ADD CONSTRAINT fk_message_group_id FOREIGN KEY (group_id) REFERENCES `group` (id_group);
ALTER TABLE `favorite`
  ADD CONSTRAINT fk_favorite_user_id FOREIGN KEY (user_id) REFERENCES user (id_user),
  ADD CONSTRAINT fk_favorite_contact_id FOREIGN KEY (contact_id) REFERENCES contact (id_contact),
  ADD CONSTRAINT fk_favorite_group_id FOREIGN KEY (group_id) REFERENCES `group` (id_group),
  ADD CONSTRAINT ui1_fav_contact_per_group_per_user UNIQUE (user_id, contact_id, group_id);
ALTER TABLE `group_contact`
  ADD CONSTRAINT fk_group_contact_group_id FOREIGN KEY (group_id) REFERENCES `group` (id_group),
  ADD CONSTRAINT fk_group_contact_contact_id FOREIGN KEY (contact_id) REFERENCES contact (id_contact),
  ADD CONSTRAINT ui1_contact_per_group UNIQUE (contact_id, group_id);
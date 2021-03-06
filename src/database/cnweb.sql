-- MySQL Script generated by MySQL Workbench
-- Thứ ba, 11 Tháng 5 Năm 2021 13:21:53 +07
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cn-web-db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cn-web-db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cn-web-db` DEFAULT CHARACTER SET utf8 ;
USE `cn-web-db` ;

-- -----------------------------------------------------
-- Table `cn-web-db`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cn-web-db`.`image` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `post_id` INT UNSIGNED NOT NULL,
  `url` VARCHAR(255) NOT NULL,
  `alt` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_image_post_idx` (`post_id` ASC) VISIBLE,
  CONSTRAINT `fk_image_post`
    FOREIGN KEY (`post_id`)
    REFERENCES `cn-web-db`.`post` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cn-web-db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cn-web-db`.`user` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(50) NOT NULL,
  `lastname` VARCHAR(50) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `birthday` DATE NOT NULL,
  `avatar` INT UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_avatar_idx` (`avatar` ASC) VISIBLE,
  CONSTRAINT `fk_user_avatar`
    FOREIGN KEY (`avatar`)
    REFERENCES `cn-web-db`.`image` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cn-web-db`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cn-web-db`.`post` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `created_time` TIMESTAMP NOT NULL,
  `content` VARCHAR(255) NULL DEFAULT NULL,
  `scope` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_post_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_post_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `cn-web-db`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cn-web-db`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cn-web-db`.`comment` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `post_id` INT UNSIGNED NOT NULL,
  `user_id` INT UNSIGNED NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  `created_time` TIMESTAMP NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_post_idx` (`post_id` ASC) VISIBLE,
  INDEX `fk_comment_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_post`
    FOREIGN KEY (`post_id`)
    REFERENCES `cn-web-db`.`post` (`id`),
  CONSTRAINT `fk_comment_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `cn-web-db`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cn-web-db`.`conversation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cn-web-db`.`conversation` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NULL DEFAULT NULL,
  `created_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cn-web-db`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cn-web-db`.`message` (
  `id` INT UNSIGNED NOT NULL,
  `conversation_id` INT UNSIGNED NOT NULL,
  `user_id` INT UNSIGNED NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  `created_time` TIMESTAMP NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_message_user_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_message_conversation_idx` (`conversation_id` ASC) VISIBLE,
  CONSTRAINT `fk_message_conversation`
    FOREIGN KEY (`conversation_id`)
    REFERENCES `cn-web-db`.`conversation` (`id`),
  CONSTRAINT `fk_message_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `cn-web-db`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cn-web-db`.`notification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cn-web-db`.`notification` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  `url` VARCHAR(255) NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_notification_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_notification_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `cn-web-db`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cn-web-db`.`participant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cn-web-db`.`participant` (
  `id` INT UNSIGNED NOT NULL,
  `conversation_id` INT UNSIGNED NOT NULL,
  `user_id` INT UNSIGNED NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`conversation_id`, `user_id`),
  INDEX `fk_participant_conversation_idx` (`conversation_id` ASC) VISIBLE,
  INDEX `fk_participant_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_participant_conversation`
    FOREIGN KEY (`conversation_id`)
    REFERENCES `cn-web-db`.`conversation` (`id`),
  CONSTRAINT `fk_participant_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `cn-web-db`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cn-web-db`.`react`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cn-web-db`.`react` (
  `post_id` INT UNSIGNED NOT NULL,
  `user_id` INT UNSIGNED NOT NULL,
  `created_time` TIMESTAMP NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`post_id`, `user_id`),
  INDEX `fk_like_post_idx` (`post_id` ASC) VISIBLE,
  INDEX `fk_like_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_like_post`
    FOREIGN KEY (`post_id`)
    REFERENCES `cn-web-db`.`post` (`id`),
  CONSTRAINT `fk_like_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `cn-web-db`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cn-web-db`.`relationship`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cn-web-db`.`relationship` (
  `user_one_id` INT UNSIGNED NOT NULL,
  `user_two_id` INT UNSIGNED NOT NULL,
  `status` BIT(1) NOT NULL,
  `action_user_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`user_one_id`, `user_two_id`),
  INDEX `fk_friendship_user_2_idx` (`user_two_id` ASC) VISIBLE,
  INDEX `fk_realtionship_action_user_idx` (`action_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_relationship_action_user`
    FOREIGN KEY (`action_user_id`)
    REFERENCES `cn-web-db`.`user` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_relationship_user_one`
    FOREIGN KEY (`user_one_id`)
    REFERENCES `cn-web-db`.`user` (`id`),
  CONSTRAINT `fk_relationship_user_two`
    FOREIGN KEY (`user_two_id`)
    REFERENCES `cn-web-db`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

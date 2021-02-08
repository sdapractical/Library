
DROP SCHEMA IF EXISTS library;
CREATE SCHEMA `library`;
USE `library`;

CREATE DATABASE IF NOT EXISTS library;


CREATE TABLE IF NOT EXISTS `readers` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(100) NOT NULL DEFAULT 'Unknown',
    `lastName` VARCHAR(100) NOT NULL DEFAULT 'Unknown',
    `mobilePhone` INT NOT NULL,
    `address` VARCHAR(255) NOT NULL DEFAULT 'Unknown',
    PRIMARY KEY (`id`))
    AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `books` (
    `id`      BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `title`   VARCHAR(255) NOT NULL DEFAULT 'Unknown',
    `authors` VARCHAR(200) NULL     DEFAULT NULL,
    `genre`   VARCHAR(50)  NULL     DEFAULT NULL,
    `publishingYear` DATE  NULL     DEFAULT NULL,
    `borrowed` BOOLEAN     DEFAULT FALSE,
    `reader`   BOOLEAN     DEFAULT FALSE,
    `readers_id` BIGINT(20) NULL,
    `dueDate` DATE,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_readers`
    FOREIGN KEY (`readers_id`) REFERENCES readers (`id`) ON DELETE SET NULL)
    AUTO_INCREMENT = 1;
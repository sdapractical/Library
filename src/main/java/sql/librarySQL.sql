
DROP SCHEMA IF EXISTS library;
CREATE SCHEMA `library`;
USE `library`;

CREATE DATABASE IF NOT EXISTS library;


CREATE TABLE IF NOT EXISTS `reader` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(100) NOT NULL DEFAULT 'Unknown',
    `lastName` VARCHAR(100) NOT NULL DEFAULT 'Unknown',
    `mobilePhone` INT NOT NULL,
    `address` VARCHAR(255) NOT NULL DEFAULT 'Unknown',
    PRIMARY KEY (`id`))
    AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `book` (
    `id`      BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `title`   VARCHAR(255) NOT NULL DEFAULT 'Unknown',
    `authors` VARCHAR(200) NULL     DEFAULT NULL,
    `genre`   VARCHAR(50)  NULL     DEFAULT NULL,
    `publishingYear` VARCHAR (20) NULL     DEFAULT NULL,
    `borrowed` BOOLEAN     DEFAULT FALSE,
    `reader` BIGINT(20) NULL,
    `dueDate` DATE,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_reader`
    FOREIGN KEY (`reader_id`) REFERENCES reader (`id`) ON DELETE SET NULL)
    AUTO_INCREMENT = 1;
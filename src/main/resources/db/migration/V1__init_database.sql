-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
-- 
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 20, 2023 at 02:10 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


-- 
-- Database: `sylvainjanet_dev`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table `hibernate_sequence`
-- 

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE = MyISAM DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci;

-- --------------------------------------------------------

-- 
-- Table structure for table `messages_localized_string`
-- 

DROP TABLE IF EXISTS `messages_localized_string`;
CREATE TABLE IF NOT EXISTS `messages_localized_string` (
    `id` bigint NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = MyISAM DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci;

-- --------------------------------------------------------

-- 
-- Table structure for table `messages_selectors`
-- 

DROP TABLE IF EXISTS `messages_selectors`;
CREATE TABLE IF NOT EXISTS `messages_selectors` (
    `messages_localized_string_id` bigint NOT NULL,
    `selector` varchar(50) COLLATE utf8mb4_unicode_520_ci NOT NULL,
    UNIQUE KEY `UK_selector` (`selector`),
    KEY `FK_messages_localized_string_id` (`messages_localized_string_id`)
) ENGINE = MyISAM DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci;

-- --------------------------------------------------------

-- 
-- Table structure for table `messages_text_map`
-- 

DROP TABLE IF EXISTS `messages_text_map`;
CREATE TABLE IF NOT EXISTS `messages_text_map` (
    `messages_localized_string_id` bigint NOT NULL,
    `text_content` varchar(10000) COLLATE utf8mb4_unicode_520_ci NOT NULL,
    `language_name` varchar(50) COLLATE utf8mb4_unicode_520_ci NOT NULL,
    PRIMARY KEY (`messages_localized_string_id`, `language_name`)
) ENGINE = MyISAM DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci;
COMMIT;

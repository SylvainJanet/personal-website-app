-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
-- 
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 20, 2023 at 11:04 AM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";



-- 
-- Database: `sylvainjanet_dev`
-- 

-- 
-- Dumping data for table `hibernate_sequence`
-- 

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(27);

-- 
-- Dumping data for table `messages_localized_string`
-- 

INSERT INTO `messages_localized_string` (`id`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19),
(20),
(21),
(22),
(23),
(24),
(25),
(26);

-- 
-- Dumping data for table `messages_selectors`
-- 

INSERT INTO `messages_selectors` (
    `messages_localized_string_id`, `selector`
) VALUES
(1, "sylvain-janet"),
(2, "french-language-name"),
(3, "english-language-name"),
(4, "main-title"),
(5, "occupation-trainer"),
(6, "occupation-mathematician"),
(7, "occupation-musician"),
(8, "occupation-fullstack-dev"),
(9, "about-name-field"),
(10, "about-profile-field"),
(11, "about-email-field"),
(12, "about-phone-field"),
(13, "skills-title"),
(14, "java-language"),
(15, "csharp-language"),
(16, "python-language"),
(17, "js-ts-language"),
(18, "sql-language"),
(19, "html-language"),
(20, "latex-language"),
(21, "about-me-title"),
(22, "about-me-content"),
(23, "website"),
(24, "cv-file-name"),
(25, "back-to-top-alt"),
(26, "cv-img-alt");

-- 
-- Dumping data for table `messages_text_map`
-- 

INSERT INTO `messages_text_map` (
    `messages_localized_string_id`, `text_content`, `language_name`
) VALUES
(1, "Sylvain Janet", "FRENCH"),
(1, "Sylvain Janet", "ENGLISH"),
(2, "Français", "FRENCH"),
(2, "French", "ENGLISH"),
(3, "Anglais", "FRENCH"),
(3, "English", "ENGLISH"),
(4, "Je suis Sylvain Janet", "FRENCH"),
(4, "I am Sylvain Janet", "ENGLISH"),
(5, "Formateur", "FRENCH"),
(5, "Trainer", "ENGLISH"),
(6, "Mathématicien", "FRENCH"),
(6, "Mathematician", "ENGLISH"),
(7, "Musicien", "FRENCH"),
(7, "Musician", "ENGLISH"),
(8, "Développeur fullstack", "FRENCH"),
(8, "FullStack Developer", "ENGLISH"),
(9, "Nom", "FRENCH"),
(9, "Name", "ENGLISH"),
(10, "Profil", "FRENCH"),
(10, "Profile", "ENGLISH"),
(11, "Email", "FRENCH"),
(11, "Email", "ENGLISH"),
(12, "Téléphone", "FRENCH"),
(12, "Phone", "ENGLISH"),
(13, "Compétences", "FRENCH"),
(13, "Skills", "ENGLISH"),
(14, "Java", "FRENCH"),
(14, "Java", "ENGLISH"),
(15, "C#", "FRENCH"),
(15, "C#", "ENGLISH"),
(16, "Python", "FRENCH"),
(16, "Python", "ENGLISH"),
(17, "Javascript / Typescript", "FRENCH"),
(17, "Javascript / Typescript", "ENGLISH"),
(18, "SQL", "FRENCH"),
(18, "SQL", "ENGLISH"),
(19, "HTML", "FRENCH"),
(19, "HTML", "ENGLISH"),
(20, "LATEX", "FRENCH"),
(20, "LATEX", "ENGLISH"),
(21, "A propos", "FRENCH"),
(21, "About me", "ENGLISH"),
(
    22,
    "Développeur FullStack et Formateur.[[]]Mon parcours professionnel a commencé par des études en mathématiques : je suis normalien, agrégé de mathématiques, et j'ai un master en logique et en informatique théorique.[[]]J'ai entamé ma carrière dans le développement informatique avec un titre professionnel Concepteur développeur d'applications Java.[[]]J'ai participé au développement de plusieurs projets. J'ai des compétences dans des frameworks back-end comme [[1,Spring boot]] ou [[2,Entity Framework]], et dans des frameworks front-end comme [[3,Angular]]. J'ai également donné des formations en [[4,Python]], [[5,Java]], [[6,C#]], [[7,Javascript]], [[8,SQL]] ou encore en [[9,Algorithmique]].[[]]Enfin, j'ai plusieurs projets individuels, dont la portée est plus large et reflète mes intérêts personnels. De l'expression artistique avec la musique, ma curiosité pour les langues, ma passion pour les jeux.[[]]Pour plus d'informations, voir [[a_asset,mon cv]].", -- noqa: LT05
    "FRENCH"
),
(
    22,
    "FullStack developer and Trainer.[[]]My professional journey began with studies in mathematics: I am a graduate of the École Normale Supérieure, an associate professor of mathematics, and I hold a master's degree in logic and theoretical computer science.[[]]I started my career in software development with a professional title as a Java application developer.[[]]I have been involved in the development of several projects. I have skills in back-end frameworks like [[1,Spring Boot]] and [[2,Entity Framework]], as well as front-end frameworks like [[3,Angular]]. I have also provided training in [[4,Python]], [[5,Java]], [[6,C#]], [[7,JavaScript]], [[8,SQL]], and [[9,Algorithmics]].[[]]Furthermore, I have several individual projects that have a broader scope and reflect my personal interests, such as artistic expression through music, my curiosity for languages, and my passion for games.[[]]For more information, please refer to [[a_asset,my CV]].", -- noqa: LT05
    "ENGLISH"
),
(23, "sylvainjanet.fr", "FRENCH"),
(23, "sylvainjanet.com", "ENGLISH"),
(24, "JanetSylvain_CV_FR.pdf", "FRENCH"),
(24, "JanetSylvain_CV_EN.pdf", "ENGLISH"),
(25, "Icône de retour en haut de page", "FRENCH"),
(25, "Back to top icon", "ENGLISH"),
(26, "Photo de CV de Sylvain Janet", "FRENCH"),
(26, "CV photo of Sylvain Janet", "ENGLISH");
COMMIT;

-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 10 Eki 2021, 17:52:56
-- Sunucu sürümü: 10.4.18-MariaDB
-- PHP Sürümü: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `libraryautomation`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `author`
--

CREATE TABLE `author` (
  `authorID` int(11) NOT NULL,
  `authorName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `author`
--

INSERT INTO `author` (`authorID`, `authorName`) VALUES
(1, 'fahri'),
(5, 'Fahri'),
(7, 'Viktor hugo'),
(8, 'kahraman tazeoğlu'),
(9, 'Oktay tiryakioğlu');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `bookaddress`
--

CREATE TABLE `bookaddress` (
  `bookAddressID` int(11) NOT NULL,
  `columnNumber` varchar(3) NOT NULL,
  `shelfNumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `bookaddress`
--

INSERT INTO `bookaddress` (`bookAddressID`, `columnNumber`, `shelfNumber`) VALUES
(1, 'A', 1),
(2, 'B', 2),
(3, 'C', 3),
(4, 'D', 4),
(5, 'E', 5),
(6, 'F', 6),
(7, 'G', 7),
(8, 'H', 8),
(9, 'I', 9),
(10, 'J', 10),
(11, 'K', 11),
(12, 'L', 12),
(13, 'M', 13),
(14, 'N', 14),
(15, 'O', 15),
(16, 'P', 16),
(17, 'Q', 17),
(18, 'R', 18),
(19, 'S', 19),
(20, 'T', 20),
(21, 'U', 21),
(22, 'V', 22),
(23, 'W', 23),
(24, 'X', 24),
(25, 'Y', 25),
(26, 'Z', 26);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `bookdeliverysettings`
--

CREATE TABLE `bookdeliverysettings` (
  `ID` tinyint(4) NOT NULL,
  `bookDeliveryTime` tinyint(4) NOT NULL,
  `lateDeliveryPenalty` tinyint(4) NOT NULL,
  `takeBookLimit` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `bookdeliverysettings`
--

INSERT INTO `bookdeliverysettings` (`ID`, `bookDeliveryTime`, `lateDeliveryPenalty`, `takeBookLimit`) VALUES
(1, 6, 5, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `bookgenre`
--

CREATE TABLE `bookgenre` (
  `bookGenreID` int(11) NOT NULL,
  `bookGenre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `bookgenre`
--

INSERT INTO `bookgenre` (`bookGenreID`, `bookGenre`) VALUES
(1, 'Macera'),
(2, 'Tarih'),
(5, 'Biyografi'),
(6, 'Bilm-Kurgu');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `books`
--

CREATE TABLE `books` (
  `bookID` int(11) NOT NULL,
  `bookName` varchar(50) NOT NULL,
  `bookGenreID` int(11) NOT NULL,
  `authorID` int(11) NOT NULL,
  `ISBN_No` int(11) NOT NULL,
  `bookStatus` varchar(50) NOT NULL,
  `PublisherID` int(11) NOT NULL,
  `columnNumber` varchar(3) NOT NULL,
  `shelfNumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `books`
--

INSERT INTO `books` (`bookID`, `bookName`, `bookGenreID`, `authorID`, `ISBN_No`, `bookStatus`, `PublisherID`, `columnNumber`, `shelfNumber`) VALUES
(1, 'sinbad', 1, 5, 51321315, 'OKULDA', 3, '3', 2),
(2, 'sefiller', 2, 7, 3544131, 'OKULDA', 1, '2', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `booktransaction`
--

CREATE TABLE `booktransaction` (
  `bookTransactionID` int(11) NOT NULL,
  `studentID` int(11) NOT NULL,
  `bookTakeDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `department`
--

CREATE TABLE `department` (
  `departmentID` int(11) NOT NULL,
  `facultyID` int(11) NOT NULL,
  `departmentName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `department`
--

INSERT INTO `department` (`departmentID`, `facultyID`, `departmentName`) VALUES
(1, 1, 'Bilgisayar Programcılığı'),
(2, 2, 'Hemşirelik'),
(4, 3, 'Makine Mühendisliği'),
(6, 2, 'Bilgisayar Mühendisliği');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `faculty`
--

CREATE TABLE `faculty` (
  `facultyID` int(11) NOT NULL,
  `facultyName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `faculty`
--

INSERT INTO `faculty` (`facultyID`, `facultyName`) VALUES
(1, 'Teknoloji'),
(2, 'Mühendislik'),
(3, 'Hemşirelik');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `officer`
--

CREATE TABLE `officer` (
  `officerID` int(11) NOT NULL,
  `officerName` varchar(50) NOT NULL,
  `officerUserName` varchar(50) NOT NULL,
  `officerPassword` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `officer`
--

INSERT INTO `officer` (`officerID`, `officerName`, `officerUserName`, `officerPassword`) VALUES
(2, 'Fahri', 'CestnyTR', '2'),
(3, 'fahri', 'aydın', '2');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `publisher`
--

CREATE TABLE `publisher` (
  `publisherID` int(11) NOT NULL,
  `publisher` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `publisher`
--

INSERT INTO `publisher` (`publisherID`, `publisher`) VALUES
(1, 'Fahri AYDIN YAYINICLIK'),
(2, 'Fahri YAYINICLIK'),
(3, 'AYDIN YAYINICLIK'),
(4, 'VakıfBank Yayıncılık');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `students`
--

CREATE TABLE `students` (
  `studentID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `studentNumber` int(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `facultyID` int(11) NOT NULL,
  `departmentID` int(11) NOT NULL,
  `studentE_Mail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `students`
--

INSERT INTO `students` (`studentID`, `name`, `studentNumber`, `password`, `facultyID`, `departmentID`, `studentE_Mail`) VALUES
(1, 'Fahri', 2015010013, '2', 1, 1, 'fahriaydin47@gmail.com'),
(2, 'fahri', 3, '4', 3, 2, 'faydin@gmail.com'),
(3, 'fahri', 3562, '5696', 1, 1, 'faydin@gmail.com'),
(4, 'aydın', 20150113, '123', 2, 4, 'Fajri@gmail.com');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `studentsbook`
--

CREATE TABLE `studentsbook` (
  `studentsBookID` int(11) NOT NULL,
  `studentID` int(11) NOT NULL,
  `bookID` int(11) NOT NULL,
  `bookName` varchar(50) NOT NULL,
  `bookGenreID` int(11) NOT NULL,
  `authorID` int(11) NOT NULL,
  `ISBN_No` int(11) NOT NULL,
  `bookStatus` varchar(11) NOT NULL,
  `publisherID` int(11) NOT NULL,
  `dateOfTookBook` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`authorID`);

--
-- Tablo için indeksler `bookaddress`
--
ALTER TABLE `bookaddress`
  ADD PRIMARY KEY (`bookAddressID`);

--
-- Tablo için indeksler `bookdeliverysettings`
--
ALTER TABLE `bookdeliverysettings`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `bookgenre`
--
ALTER TABLE `bookgenre`
  ADD PRIMARY KEY (`bookGenreID`);

--
-- Tablo için indeksler `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`bookID`);

--
-- Tablo için indeksler `booktransaction`
--
ALTER TABLE `booktransaction`
  ADD PRIMARY KEY (`bookTransactionID`);

--
-- Tablo için indeksler `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`departmentID`);

--
-- Tablo için indeksler `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`facultyID`);

--
-- Tablo için indeksler `officer`
--
ALTER TABLE `officer`
  ADD PRIMARY KEY (`officerID`);

--
-- Tablo için indeksler `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`publisherID`);

--
-- Tablo için indeksler `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`studentID`);

--
-- Tablo için indeksler `studentsbook`
--
ALTER TABLE `studentsbook`
  ADD PRIMARY KEY (`studentsBookID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `author`
--
ALTER TABLE `author`
  MODIFY `authorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Tablo için AUTO_INCREMENT değeri `bookaddress`
--
ALTER TABLE `bookaddress`
  MODIFY `bookAddressID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Tablo için AUTO_INCREMENT değeri `bookdeliverysettings`
--
ALTER TABLE `bookdeliverysettings`
  MODIFY `ID` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `bookgenre`
--
ALTER TABLE `bookgenre`
  MODIFY `bookGenreID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `books`
--
ALTER TABLE `books`
  MODIFY `bookID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `booktransaction`
--
ALTER TABLE `booktransaction`
  MODIFY `bookTransactionID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `department`
--
ALTER TABLE `department`
  MODIFY `departmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `faculty`
--
ALTER TABLE `faculty`
  MODIFY `facultyID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `officer`
--
ALTER TABLE `officer`
  MODIFY `officerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `publisher`
--
ALTER TABLE `publisher`
  MODIFY `publisherID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `students`
--
ALTER TABLE `students`
  MODIFY `studentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `studentsbook`
--
ALTER TABLE `studentsbook`
  MODIFY `studentsBookID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";
-- Database: `dong_ho`
--

-- --------------------------------------------------------

--
-- Table structure for table `orderlines`
--

CREATE TABLE IF NOT EXISTS `orderlines` (
  `Id` int(11) NOT NULL,
  `OrderId` int(11) NOT NULL,
  `WatchesId` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CreateTime` datetime NOT NULL,
  `CloseTime` datetime NOT NULL,
  `Status` int(11) NOT NULL,
  `UserId` int(11) DEFAULT NULL,
  `Name` varchar(255) NOT NULL,
  `Address` text NOT NULL,
  `Phone` varchar(12) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Request` text,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `types`
--

CREATE TABLE IF NOT EXISTS `types` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CodeName` varchar(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `types`
--

INSERT INTO `types` (`Id`, `CodeName`, `Name`) VALUES
(1, 'casio', 'Casio'),
(2, 'orient', 'Orient'),
(3, 'g-shock', 'G-Shock'),
(4, 'skmei', 'SKMEI'),
(5, 'citizens', 'Citizens'),
(6, 'mvw', 'MVW');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Password` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `CreateTime` datetime NOT NULL,
  `Admin` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Sex` int(11) NOT NULL,
  `DoB` date NOT NULL,
  `IdCard` varchar(10) NOT NULL,
  `Address` text NOT NULL,
  `Phone` varchar(12) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Username` (`Email`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Password`, `Email`, `CreateTime`, `Admin`, `Name`, `Sex`, `DoB`, `IdCard`, `Address`, `Phone`) VALUES
(123123, 'tai@gmail.com', '2002-04-05 00:00:00', 1, 'Pham Huu Tai', 0, '2002-05-04', '123123442354', 'Can Tho', '1234567890' );
-- --------------------------------------------------------

--
-- Table structure for table `watches`
--

CREATE TABLE IF NOT EXISTS `watches` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CodeName` varchar(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Origin` varchar(255) DEFAULT NULL,
  `Year` int(11) DEFAULT NULL,
  `Details` text,
  `Price` bigint(20) DEFAULT NULL,
  `CreateTime` datetime NOT NULL,
  `Picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `watches`
--

INSERT INTO `watches` (`Id`, `CodeName`, `Name`, `Type`, `Origin`, `Year`, `Details`, `Price`, `Picture`) VALUES
(1, 'A168WER-2ADF', 'Đồng hồ Casio 38.6 x 36.3 mm Unisex A168WER-2ADF', 'Casio', 'Nhật bản', 2023, 'Hãng sản xuất: Đồng hồ Casio\r\n\r\nKiểu dáng: Đồng hồ nam\r\n\r\nMáy: Pin\r\n\r\nChất liệu vỏ: Thép không gỉ (All Stainless Steel)\r\n\r\nChất liệu dây: Thép không gỉ\r\n\r\nBảo hành: 1 năm\r\n\r\nXuất xứ: Nhật Bản\r\n\r\nMặt kính: Mineral Crystal', 1306000, '1.jpg'),
(2, 'MTS-100L-1AVDF', 'Đồng hồ CASIO 41.3 mm Nam MTS-100L-1AVDF', 'Casio', 'Nhật bản', 2022, 'Hãng sản xuất: Đồng hồ Casio\r\n\r\nKiểu dáng: Đồng hồ nam\r\n\r\nMáy: Pin\r\n\r\nChất liệu vỏ: Thép không gỉ (All Stainless Steel)\r\n\r\nChất liệu dây: dây da\r\n\r\nBảo hành: 1 năm\r\n\r\nXuất xứ: Nhật Bản\r\n\r\nMặt kính: Mineral Crystal', 2094000, '2.jpg'),
(3, 'RA-AK0801S10B', 'Đồng hồ Orient Bambino 41.5 mm Nam RA-AK0801S10B', 'Orient', 'Nhật bản', 2021, 'Hãng sản xuất: Đồng hồ Orient\r\n\r\nKiểu dáng: Đồng hồ nam\r\n\r\nMáy: Pin\r\n\r\nChất liệu vỏ: Thép không gỉ (All Stainless Steel)\r\n\r\nChất liệu dây: dây da\r\n\r\nBảo hành: 1 năm\r\n\r\nXuất xứ: Nhật Bản\r\n\r\nMặt kính: Mineral Crystal', 11130.000, '3.jpg'),
(4, 'RA-AA0818L19B', 'Đồng hồ Orient Mako 41.8 mm Nam RA-AA0818L19B', 'Orient', 'Nhật bản', 2020, 'Hãng sản xuất: Đồng hồ Orient\r\n\r\nKiểu dáng: Đồng hồ nam\r\n\r\nMáy: Pin\r\n\r\nChất liệu vỏ: Thép không gỉ (All Stainless Steel)\r\n\r\nChất liệu dây: Thép không gỉ\r\n\r\nBảo hành: 1 năm\r\n\r\nXuất xứ: Nhật Bản\r\n\r\nMặt kính: Mineral Crystal', 8976000, '4.jpg'),
(5, 'GM-5600G-9DR', 'Đồng hồ G-SHOCK 43.2 mm Nam GM-5600G-9DR', 'G-Shock', 'Nhật bản', 2019, 'Hãng sản xuất: Đồng hồ G-Shock\r\n\r\nKiểu dáng: Đồng hồ thể thao\r\n\r\nMáy: Pin\r\n\r\nChất liệu vỏ: Thép không gỉ (All Stainless Steel)\r\n\r\nChất liệu dây: Cao su\r\n\r\nBảo hành: 1 năm\r\n\r\nXuất xứ: Nhật Bản\r\n\r\nMặt kính: Mineral Crystal', 5606000, '5.jpg'),
(6, 'GM-5600G-1DR', 'Đồng hồ G-SHOCK 43.2 mm Nam GM-5600G-1DR', 'G-Shock', 'Nhật bản', 2019, 'Hãng sản xuất: Đồng hồ G-Shock\r\n\r\nKiểu dáng: Đồng hồ thể thao\r\n\r\nMáy: Pin\r\n\r\nChất liệu vỏ: Thép không gỉ (All Stainless Steel)\r\n\r\nChất liệu dây: Cao su\r\n\r\nBảo hành: 1 năm\r\n\r\nXuất xứ: Nhật Bản\r\n\r\nMặt kính: Mineral Crystal', 4352000, '6.jpg'),
(7, 'SK101-02', 'Đồng hồ SKMEI 49 mm Trẻ em SK101-02', 'SKMEI', 'Trung Quốc', 2018, 'Hãng sản xuất: Đồng hồ SKMEI\r\n\r\nKiểu dáng: Đồng hồ trẻ em\r\n\r\nMáy: Pin\r\n\r\nChất liệu vỏ: Thép không gỉ (All Stainless Steel)\r\n\r\nChất liệu dây: Cao su\r\n\r\nBảo hành: 1 năm\r\n\r\nXuất xứ: Trung Quốc\r\n\r\nMặt kính: Mineral Crystal', 290000, '7.jpg'),
(8, 'SK100-02', 'Đồng hồ SKMEI 45 mm Trẻ em SK100-02', 'SKMEI', 'Trung Quốc', 2019, 'Hãng sản xuất: Đồng hồ SKMEI\r\n\r\nKiểu dáng: Đồng hồ trẻ em\r\n\r\nMáy: Pin\r\n\r\nChất liệu vỏ: Thép không gỉ (All Stainless Steel)\r\n\r\nChất liệu dây: Cao su\r\n\r\nBảo hành: 1 năm\r\n\r\nXuất xứ: Trung Quốc\r\n\r\nMặt kính: Mineral Crystal', 290000, '8.jpg'),
(9, 'BE9170-05L', 'Đồng hồ CITIZEN 39 mm Nam BE9170-05L', 'Citizens', 'Nhật bản', 2010, 'Hãng sản xuất: Đồng hồ Citizens\r\n\r\nKiểu dáng: Đồng hồ nam\r\n\r\nMáy: Pin\r\n\r\nChất liệu vỏ: Thép không gỉ (All Stainless Steel)\r\n\r\nChất liệu dây: Da\r\n\r\nBảo hành: 1 năm\r\n\r\nXuất xứ: Nhật Bản\r\n\r\nMặt kính: Mineral Crystal', 3.112000, '9.jpg'),
(10, 'AN3610-55L', 'Đồng hồ CITIZEN 41 mm Nam AN3610-55L', 'Citizens', 'Nhật bản', 2007, 'Hãng sản xuất: Đồng hồ Citizens\r\n\r\nKiểu dáng: Đồng hồ nam\r\n\r\nMáy: Pin\r\n\r\nChất liệu vỏ: Thép không gỉ (All Stainless Steel)\r\n\r\nChất liệu dây: Thép không gỉ\r\n\r\nBảo hành: 1 năm\r\n\r\nXuất xứ: Nhật Bản\r\n\r\nMặt kính: Mineral Crystal', 4468000, '10.jpg'),
(11, 'MSA089-01-S1', 'Đồng hồ MVW Galaxy 41 mm Nam MSA089-01-S1', 'MVW', 'Việt Nam', 2019, 'Hãng sản xuất: Đồng hồ MVW, Kiểu dáng: Đồng hồ nam, Máy: Pin, Chất liệu vỏ: Thép không gỉ (All Stainless Steel), Chất liệu dây: Thép không gỉ, Bảo hành: 1 năm, Xuất xứ: Việt Nam, Mặt kính: Mineral Crystal', 1990000, '11.jpg'),
(12, 'MLA084-02-S1', 'Đồng hồ MVW Galaxy 41 mm Nam MLA084-02-S1', 'MVW', 'Việt Nam', 2019, 'Hãng sản xuất: Đồng hồ MVW, Kiểu dáng: Đồng hồ nam, Máy: Pin, Chất liệu vỏ: Thép không gỉ (All Stainless Steel), Chất liệu dây: Da, Bảo hành: 1 năm, Xuất xứ: Việt Nam, Mặt kính: Mineral Crystal', 1990000, '12.jpg');
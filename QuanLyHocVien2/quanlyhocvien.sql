-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 08, 2022 at 07:36 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlyhocvien`
--

-- --------------------------------------------------------

--
-- Table structure for table `hoc_vien`
--

CREATE TABLE `hoc_vien` (
  `ma_hoc_vien` int(11) NOT NULL,
  `ho_ten` varchar(255) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `gioi_tinh` bit(1) NOT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `tinh_trang` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hoc_vien`
--

INSERT INTO `hoc_vien` (`ma_hoc_vien`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `so_dien_thoai`, `dia_chi`, `tinh_trang`) VALUES
(61131562, 'Phan Lờ Mao', '2001-01-20', b'1', '0392592879', 'Vạn Ninh, Khánh Hòa', b'1'),
(61131569, 'Nguyễn Thị Thanh Ni', '2001-04-03', b'0', NULL, 'Hà Già', b'1'),
(61131570, 'Đặng Hải Lựu', '1969-09-06', b'1', '0393920500', 'Nha Trang', b'1'),
(61131571, 'Trương Khàng Đinh', '2002-11-11', b'1', '039269963', 'Nha Trang', b'1'),
(61131596, 'Nguyễn Anh Phương', '2001-06-09', b'1', '0342069960', 'Ninh Hòa', b'1'),
(61169420, 'Mai Đoàn Ánh Như', '2002-11-25', b'0', '0976400502', 'Vạn Ninh, Khánh Hòa', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `khoa_hoc`
--

CREATE TABLE `khoa_hoc` (
  `ma_khoa_hoc` int(11) NOT NULL,
  `ten_khoa_hoc` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_ket_thuc` date DEFAULT NULL,
  `tinh_trang` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khoa_hoc`
--

INSERT INTO `khoa_hoc` (`ma_khoa_hoc`, `ten_khoa_hoc`, `mo_ta`, `ngay_bat_dau`, `ngay_ket_thuc`, `tinh_trang`) VALUES
(379, 'Lập trình thiết bị di động', 'Lập trình thiết bị di động - GV. Huỳnh Tuấn Anh', '2019-04-20', '2020-04-04', b'1'),
(33161, 'Lập trình Java', 'Lập trình Java - 61.CNTT-CLC - GV. Mai Cường Thọ', '2021-01-01', '2021-12-12', b'1'),
(33361, 'Tư tưởng Hồ Chí Minh', 'Tư tưởng Hồ Chí Minh - GV. Trần Trọng Đạo', '2021-09-06', '2022-06-09', b'1'),
(35261, 'Quản lý dự án phần mềm', 'Quản lý dự án phần mềm - GV. Bùi Chí Thành', '2020-06-06', '2022-09-09', b'1'),
(37861, 'Phát triển ứng dụng Web', 'Phát triển ứng dụng Web 1 - GV. Bùi Chí Thành', '2021-01-01', '2021-12-12', b'1'),
(38061, 'Kiến trúc và thiết kế phần mềm', '61.CNTT-CLC - GV. Huỳnh Tuấn Anh', '2019-11-11', '2020-02-02', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `lop_hoc`
--

CREATE TABLE `lop_hoc` (
  `ma_lop_hoc` int(11) NOT NULL,
  `ma_khoa_hoc` int(11) DEFAULT NULL,
  `ma_hoc_vien` int(11) DEFAULT NULL,
  `ngay_dang_ky` date DEFAULT NULL,
  `tinh_trang` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lop_hoc`
--

INSERT INTO `lop_hoc` (`ma_lop_hoc`, `ma_khoa_hoc`, `ma_hoc_vien`, `ngay_dang_ky`, `tinh_trang`) VALUES
(58, 38061, 61169420, '2019-01-20', b'1'),
(59, 35261, 61131571, '2020-11-11', b'1'),
(60, 379, 61131596, '2020-11-11', b'1'),
(61, 33161, 61131562, '2019-01-20', b'1'),
(62, 33361, 61131570, '2021-04-20', b'1'),
(63, 37861, 61131569, '2019-01-20', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `tai_khoan`
--

CREATE TABLE `tai_khoan` (
  `ma_tai_khoan` int(11) NOT NULL,
  `ten_dang_nhap` varchar(255) DEFAULT NULL,
  `mat_khau` varchar(255) DEFAULT NULL,
  `tinh_trang` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tai_khoan`
--

INSERT INTO `tai_khoan` (`ma_tai_khoan`, `ten_dang_nhap`, `mat_khau`, `tinh_trang`) VALUES
(1, 'dinhvu69', '6969', b'1'),
(2, 'dinhvu', '7610db9e380ba9775b3c215346184a87', b'0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hoc_vien`
--
ALTER TABLE `hoc_vien`
  ADD PRIMARY KEY (`ma_hoc_vien`);

--
-- Indexes for table `khoa_hoc`
--
ALTER TABLE `khoa_hoc`
  ADD PRIMARY KEY (`ma_khoa_hoc`);

--
-- Indexes for table `lop_hoc`
--
ALTER TABLE `lop_hoc`
  ADD PRIMARY KEY (`ma_lop_hoc`),
  ADD KEY `FK_nsk96k2rdocji4oakgsv51nuq` (`ma_hoc_vien`),
  ADD KEY `FK_pvhxvf4oy1n5bp8tvn8a6tcnu` (`ma_khoa_hoc`);

--
-- Indexes for table `tai_khoan`
--
ALTER TABLE `tai_khoan`
  ADD PRIMARY KEY (`ma_tai_khoan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hoc_vien`
--
ALTER TABLE `hoc_vien`
  MODIFY `ma_hoc_vien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61169424;

--
-- AUTO_INCREMENT for table `khoa_hoc`
--
ALTER TABLE `khoa_hoc`
  MODIFY `ma_khoa_hoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38062;

--
-- AUTO_INCREMENT for table `lop_hoc`
--
ALTER TABLE `lop_hoc`
  MODIFY `ma_lop_hoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `tai_khoan`
--
ALTER TABLE `tai_khoan`
  MODIFY `ma_tai_khoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `lop_hoc`
--
ALTER TABLE `lop_hoc`
  ADD CONSTRAINT `FK_nsk96k2rdocji4oakgsv51nuq` FOREIGN KEY (`ma_hoc_vien`) REFERENCES `hoc_vien` (`ma_hoc_vien`),
  ADD CONSTRAINT `FK_pvhxvf4oy1n5bp8tvn8a6tcnu` FOREIGN KEY (`ma_khoa_hoc`) REFERENCES `khoa_hoc` (`ma_khoa_hoc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

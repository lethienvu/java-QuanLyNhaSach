-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 25, 2022 at 07:19 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlcuahangsach`
--

-- --------------------------------------------------------

--
-- Table structure for table `ChiTietHoaDon`
--

CREATE TABLE `ChiTietHoaDon` (
  `MaHD` varchar(8) NOT NULL,
  `MaSP` varchar(8) NOT NULL,
  `DonGia` int(10) NOT NULL,
  `SoLuong` tinyint(3) NOT NULL,
  `ThanhTien` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ChiTietHoaDon`
--

INSERT INTO `ChiTietHoaDon` (`MaHD`, `MaSP`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES
('HD000001', 'SP000003', 25000, 1, 25000),
('HD000002', 'SP000003', 25000, 1, 25000),
('HD000002', 'SP000004', 23000, 1, 23000),
('HD000003', 'SP000001', 4000, 1, 4000),
('HD000003', 'SP000003', 25000, 1, 25000),
('HD000005', 'SP000001', 4000, 1, 4000),
('HD000005', 'SP000002', 3500, 2, 7000),
('HD000006', 'SP000004', 23000, 1, 23000),
('HD000006', 'SP000003', 25000, 2, 50000),
('HD000007', 'SP000001', 4000, 2, 8000),
('HD000007', 'SP000002', 3500, 1, 3500);

-- --------------------------------------------------------

--
-- Table structure for table `ChiTietPhieuNhap`
--

CREATE TABLE `ChiTietPhieuNhap` (
  `MaPN` varchar(8) NOT NULL,
  `MaSP` varchar(8) NOT NULL,
  `DonGia` int(10) NOT NULL,
  `SoLuong` tinyint(3) NOT NULL,
  `ThanhTien` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ChiTietPhieuNhap`
--

INSERT INTO `ChiTietPhieuNhap` (`MaPN`, `MaSP`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES
('PN000001', 'SP000003', 24000, 100, 2400000),
('PN000002', 'SP000004', 22000, 100, 2200000),
('PN000003', 'SP000003', 24500, 100, 2450000),
('PN000003', 'SP000001', 3500, 100, 350000),
('PN000004', 'SP000001', 3000, 100, 300000),
('PN000004', 'SP000003', 24000, 100, 2400000),
('PN000005', 'SP000001', 3000, 100, 300000),
('PN000005', 'SP000003', 24000, 100, 2400000),
('PN000005', 'SP000004', 22000, 100, 2200000),
('PN000006', 'SP000001', 3500, 50, 175000);

-- --------------------------------------------------------

--
-- Table structure for table `HoaDon`
--

CREATE TABLE `HoaDon` (
  `MaHD` varchar(8) NOT NULL,
  `MaKH` varchar(8) DEFAULT NULL,
  `MaNV` varchar(8) NOT NULL,
  `NgayLap` varchar(10) NOT NULL,
  `TongTien` int(10) NOT NULL,
  `TinhTrang` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `HoaDon`
--

INSERT INTO `HoaDon` (`MaHD`, `MaKH`, `MaNV`, `NgayLap`, `TongTien`, `TinhTrang`) VALUES
('HD000001', 'KH000001', 'NV000001', '07/05/2022', 25000, 1),
('HD000002', 'KH000002', 'NV000001', '07/05/2022', 48000, 1),
('HD000003', 'KH000003', 'NV000001', '07/05/2022', 29000, 1),
('HD000005', 'KH000001', 'NV000001', '10/5/2022', 11000, 1),
('HD000006', 'KH000001', 'NV000001', '10/5/2022', 73000, 1),
('HD000007', 'KH000001', 'NV000001', '20/5/2022', 11500, 1);

-- --------------------------------------------------------

--
-- Table structure for table `KhachHang`
--

CREATE TABLE `KhachHang` (
  `MaKH` varchar(8) NOT NULL,
  `HoDem` varchar(256) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `DiaChi` varchar(500) NOT NULL,
  `NgaySinh` varchar(10) NOT NULL,
  `GioiTinh` varchar(3) NOT NULL,
  `Email` varchar(256) NOT NULL,
  `DienThoai` varchar(10) NOT NULL,
  `TinhTrang` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `KhachHang`
--

INSERT INTO `KhachHang` (`MaKH`, `HoDem`, `Ten`, `DiaChi`, `NgaySinh`, `GioiTinh`, `Email`, `DienThoai`, `TinhTrang`) VALUES
('KH000001', 'Lê Văn', 'T', 'Quận 6, TPHCM', '02/10/1998', 'Nam', 'levanT@gmail.com', '0123456789', 1),
('KH000002', 'Phạm Thị', 'C', 'Quận 5, TPHCM', '01/01/1995', 'Nữ', 'phamthic@gmail.com', '0945752145', 1),
('KH000003', 'Phan Hoàng', 'A', 'Quận 4, TPHCM', '25/05/2000', 'Nam', 'phanhoanga@gmail.com', '0978123456', 1),
('KH000004', 'Nguyễn Như', 'Y', 'Quận 1, TPHCM', '14/04/2001', 'Nữ', 'nguyennhuy', '0124578963', 1);

-- --------------------------------------------------------

--
-- Table structure for table `LoaiSP`
--

CREATE TABLE `LoaiSP` (
  `MaLoai` varchar(8) NOT NULL,
  `TenLoai` varchar(256) NOT NULL,
  `TInhTrang` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `LoaiSP`
--

INSERT INTO `LoaiSP` (`MaLoai`, `TenLoai`, `TInhTrang`) VALUES
('LP000001', 'Tập 4 ô ly', 1),
('LP000002', 'Bút bi', 1),
('LP000003', 'Sách giáo khoa cấp tiểu học', 1),
('LP000004', 'Sách thiếu nhi', 1);

-- --------------------------------------------------------

--
-- Table structure for table `NhaCungCap`
--

CREATE TABLE `NhaCungCap` (
  `MaNCC` varchar(8) NOT NULL,
  `TenNCC` varchar(50) NOT NULL,
  `DiaChi` varchar(500) NOT NULL,
  `DienThoai` varchar(10) NOT NULL,
  `TinhTrang` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `NhaCungCap`
--

INSERT INTO `NhaCungCap` (`MaNCC`, `TenNCC`, `DiaChi`, `DienThoai`, `TinhTrang`) VALUES
('NC000001', 'Thiên Long', 'Quận 5, TPHCM', '0125467893', 1),
('NC000002', 'Khang Việt', 'Quận Tân Phú, TPHCM', '0978412563', 1),
('NC000003', 'NXBGD', 'Quận 5, TPHCM', '0117895225', 1);

-- --------------------------------------------------------

--
-- Table structure for table `NhanVien`
--

CREATE TABLE `NhanVien` (
  `MaNV` varchar(8) NOT NULL,
  `MaTK` varchar(8) DEFAULT NULL,
  `HoDem` varchar(256) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `DiaChi` varchar(500) NOT NULL,
  `NgaySinh` varchar(10) NOT NULL,
  `GioiTinh` tinyint(1) NOT NULL,
  `Email` varchar(256) NOT NULL,
  `DienThoai` varchar(10) NOT NULL,
  `TinhTrang` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `NhanVien`
--

INSERT INTO `NhanVien` (`MaNV`, `MaTK`, `HoDem`, `Ten`, `DiaChi`, `NgaySinh`, `GioiTinh`, `Email`, `DienThoai`, `TinhTrang`) VALUES
('NV000001', 'TK000001', 'Trần Thị', 'N', 'Quận 8, TPHCM', '12/12/1995', 2, 'tranthin@gmail.com', '0945789123', 1),
('NV000002', 'TK000002', 'Trần Văn', 'N', 'Quận 6, TPHCM', '09/5/1995', 1, 'tranvann@gmail.com', '0159786419', 1),
('NV000003', 'TK000003', 'Lê Văn', 'B', 'Quận 5, TPHCM', '12/5/1992', 1, 'levanb@gmail.com', '0124785963', 1);

-- --------------------------------------------------------

--
-- Table structure for table `PhieuNhap`
--

CREATE TABLE `PhieuNhap` (
  `MaPN` varchar(8) NOT NULL,
  `MaNCC` varchar(8) NOT NULL,
  `MaNV` varchar(8) NOT NULL,
  `NgayNhap` varchar(10) NOT NULL,
  `TongTien` int(10) NOT NULL,
  `TinhTrang` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `PhieuNhap`
--

INSERT INTO `PhieuNhap` (`MaPN`, `MaNCC`, `MaNV`, `NgayNhap`, `TongTien`, `TinhTrang`) VALUES
('PN000001', 'NC000001', 'NV000001', '12/5/2022', 2400000, 1),
('PN000002', 'NC000001', 'NV000001', '12/5/2022', 2200000, 1),
('PN000003', 'NC000002', 'NV000001', '12/5/2022', 2800000, 1),
('PN000004', 'NC000001', 'NV000001', '12/5/2022', 2700000, 1),
('PN000005', 'NC000001', 'NV000001', '12/5/2022', 4900000, 1),
('PN000006', 'NC000001', 'NV000001', '21/5/2022', 175000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `SanPham`
--

CREATE TABLE `SanPham` (
  `MaSP` varchar(8) NOT NULL,
  `TenSP` varchar(256) NOT NULL,
  `MaLoai` varchar(8) NOT NULL,
  `NhaCC` varchar(8) NOT NULL,
  `GiaBan` int(10) NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `TinhTrang` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `SanPham`
--

INSERT INTO `SanPham` (`MaSP`, `TenSP`, `MaLoai`, `NhaCC`, `GiaBan`, `SoLuong`, `TinhTrang`) VALUES
('SP000001', 'Tập 4 ô li Tuổi trẻ', 'LP000001', 'NC000001', 400, 500, 1),
('SP000002', 'Bút bi xanh Thiên Long', 'LP000002', 'NC000002', 3500, 400, 1),
('SP000003', 'SGK Tiếng Việt 1', 'LP000003', 'NC000003', 25000, 200, 1),
('SP000004', 'SGK Toán 1', 'LP000003', 'NC000003', 23000, 100, 1),
('SP000005', 'Truyện rùa và thỏ', 'LP000004', 'NC000003', 20000, 50, 1),
('SP000006', 'SGK Toán lớp 2', 'LP000001', 'NC000001', 25000, 100, 1);

-- --------------------------------------------------------

--
-- Table structure for table `TaiKhoan`
--

CREATE TABLE `TaiKhoan` (
  `MaTK` varchar(8) NOT NULL,
  `Username` varchar(32) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `TinhTrang` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `TaiKhoan`
--

INSERT INTO `TaiKhoan` (`MaTK`, `Username`, `Password`, `TinhTrang`) VALUES
('TK000001', 'admin', '123', 1),
('TK000002', 'admin2', '123', 1),
('TK000003', 'admin3', '123', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ChiTietHoaDon`
--
ALTER TABLE `ChiTietHoaDon`
  ADD KEY `MaHD` (`MaHD`),
  ADD KEY `MaSP` (`MaSP`);

--
-- Indexes for table `ChiTietPhieuNhap`
--
ALTER TABLE `ChiTietPhieuNhap`
  ADD KEY `MaPN` (`MaPN`),
  ADD KEY `MaSP` (`MaSP`);

--
-- Indexes for table `HoaDon`
--
ALTER TABLE `HoaDon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `MaKH` (`MaKH`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Indexes for table `KhachHang`
--
ALTER TABLE `KhachHang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Indexes for table `LoaiSP`
--
ALTER TABLE `LoaiSP`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Indexes for table `NhaCungCap`
--
ALTER TABLE `NhaCungCap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Indexes for table `NhanVien`
--
ALTER TABLE `NhanVien`
  ADD PRIMARY KEY (`MaNV`),
  ADD KEY `MaTK` (`MaTK`);

--
-- Indexes for table `PhieuNhap`
--
ALTER TABLE `PhieuNhap`
  ADD PRIMARY KEY (`MaPN`),
  ADD KEY `MaNCC` (`MaNCC`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Indexes for table `SanPham`
--
ALTER TABLE `SanPham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `MaLoai` (`MaLoai`),
  ADD KEY `NhaCC` (`NhaCC`);

--
-- Indexes for table `TaiKhoan`
--
ALTER TABLE `TaiKhoan`
  ADD PRIMARY KEY (`MaTK`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ChiTietHoaDon`
--
ALTER TABLE `ChiTietHoaDon`
  ADD CONSTRAINT `ChiTietHoaDon_ibfk_1` FOREIGN KEY (`MaHD`) REFERENCES `HoaDon` (`MaHD`),
  ADD CONSTRAINT `ChiTietHoaDon_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `SanPham` (`MaSP`);

--
-- Constraints for table `ChiTietPhieuNhap`
--
ALTER TABLE `ChiTietPhieuNhap`
  ADD CONSTRAINT `ChiTietPhieuNhap_ibfk_1` FOREIGN KEY (`MaPN`) REFERENCES `PhieuNhap` (`MaPN`),
  ADD CONSTRAINT `ChiTietPhieuNhap_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `SanPham` (`MaSP`);

--
-- Constraints for table `HoaDon`
--
ALTER TABLE `HoaDon`
  ADD CONSTRAINT `HoaDon_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `KhachHang` (`MaKH`),
  ADD CONSTRAINT `HoaDon_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `NhanVien` (`MaNV`);

--
-- Constraints for table `NhanVien`
--
ALTER TABLE `NhanVien`
  ADD CONSTRAINT `NhanVien_ibfk_1` FOREIGN KEY (`MaTK`) REFERENCES `TaiKhoan` (`MaTK`);

--
-- Constraints for table `PhieuNhap`
--
ALTER TABLE `PhieuNhap`
  ADD CONSTRAINT `PhieuNhap_ibfk_1` FOREIGN KEY (`MaNCC`) REFERENCES `NhaCungCap` (`MaNCC`),
  ADD CONSTRAINT `PhieuNhap_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `NhanVien` (`MaNV`);

--
-- Constraints for table `SanPham`
--
ALTER TABLE `SanPham`
  ADD CONSTRAINT `SanPham_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `LoaiSP` (`MaLoai`),
  ADD CONSTRAINT `SanPham_ibfk_2` FOREIGN KEY (`NhaCC`) REFERENCES `NhaCungCap` (`MaNCC`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

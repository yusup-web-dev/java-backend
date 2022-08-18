-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 18 Agu 2022 pada 08.04
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dblatihan_xiirpl2`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `biodata`
--

CREATE TABLE `biodata` (
  `nis` int(9) NOT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `no_telpon` varchar(13) DEFAULT NULL,
  `jenis_kelamin` varchar(6) DEFAULT NULL,
  `kd_jurusan` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `biodata`
--

INSERT INTO `biodata` (`nis`, `nama`, `alamat`, `no_telpon`, `jenis_kelamin`, `kd_jurusan`) VALUES
(110011, 'Juned', 'Jl Buntu Gg Rusak', '08781182', 'Pria', 'J001'),
(110012, 'siti', 'Bubuay', '01741182', 'Wanita', 'J002'),
(110013, 'Burhan', 'Cibalong', '081741182', 'Pria', 'J003');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jurusan`
--

CREATE TABLE `jurusan` (
  `kd_jurusan` varchar(30) DEFAULT NULL,
  `nama_jurusan` varchar(30) DEFAULT NULL,
  `kutua_jurusan` varchar(30) DEFAULT NULL,
  `jml_kelas` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `jurusan`
--

INSERT INTO `jurusan` (`kd_jurusan`, `nama_jurusan`, `kutua_jurusan`, `jml_kelas`) VALUES
('J001', 'TKJ', 'Yogi Pratama,s.kom', 12),
('J002', 'RPL', 'Drs. H. Mahmur Kumara,s.kom', 9),
('J003', 'Farmasi', 'Sridana,M.Farm', 9),
('J004', 'TBSM', 'Alga Saripudin,', 9);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `table_relasi`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `table_relasi` (
`nis` int(9)
,`nama` varchar(30)
,`alamat` varchar(50)
,`no_telpon` varchar(13)
,`kd_jurusan` varchar(30)
,`nama_jurusan` varchar(30)
);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `kd_user` varchar(10) NOT NULL,
  `Nama_lengkap` varchar(30) DEFAULT NULL,
  `no_telfon` varchar(13) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur untuk view `table_relasi`
--
DROP TABLE IF EXISTS `table_relasi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `table_relasi`  AS SELECT `biodata`.`nis` AS `nis`, `biodata`.`nama` AS `nama`, `biodata`.`alamat` AS `alamat`, `biodata`.`no_telpon` AS `no_telpon`, `jurusan`.`kd_jurusan` AS `kd_jurusan`, `jurusan`.`nama_jurusan` AS `nama_jurusan` FROM (`biodata` join `jurusan`) WHERE `jurusan`.`kd_jurusan` = `biodata`.`kd_jurusan` ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `biodata`
--
ALTER TABLE `biodata`
  ADD PRIMARY KEY (`nis`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`kd_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `biodata`
--
ALTER TABLE `biodata`
  MODIFY `nis` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110014;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

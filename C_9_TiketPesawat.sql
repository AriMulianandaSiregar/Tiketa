-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2023 at 06:31 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database-tiketa`
--

-- --------------------------------------------------------

--
-- Table structure for table `detailperjalanan`
--

CREATE TABLE `detailperjalanan` (
  `detailPerjalananID` int(11) NOT NULL,
  `nomorKeberangkatan` varchar(50) NOT NULL,
  `kotaKeberangkatan` varchar(50) NOT NULL,
  `kotaKedatangan` varchar(50) NOT NULL,
  `tanggalKeberangkatan` date NOT NULL,
  `tanggalKedatangan` date NOT NULL,
  `kendaraanID` int(11) NOT NULL,
  `waktuKeberangkatan` time NOT NULL,
  `waktuKedatangan` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detailperjalanan`
--

INSERT INTO `detailperjalanan` (`detailPerjalananID`, `nomorKeberangkatan`, `kotaKeberangkatan`, `kotaKedatangan`, `tanggalKeberangkatan`, `tanggalKedatangan`, `kendaraanID`, `waktuKeberangkatan`, `waktuKedatangan`) VALUES
(401, '101', 'Bali', 'Yogyakarta', '2023-05-20', '2023-05-20', 705, '18:00:00', '20:00:00'),
(402, '102', 'Yogyakarta', 'Bali', '2020-06-07', '2020-06-08', 704, '23:00:00', '01:16:00'),
(403, '103', 'Bali', 'Yogyakarta', '2020-07-06', '2020-07-06', 702, '16:30:00', '16:46:00'),
(404, '104', 'Yogyakarta', 'Bali', '2021-05-17', '2021-05-17', 705, '00:30:00', '02:46:00'),
(405, '105', 'Bali', 'Yogyakarta', '2020-12-16', '2020-12-16', 703, '23:00:00', '23:16:00'),
(406, '106', 'Jakarta', 'Medan', '2023-06-01', '2023-06-01', 701, '15:00:00', '17:15:00'),
(407, '107', 'Medan', 'Jakarta', '2023-06-01', '2023-06-01', 701, '19:00:00', '21:16:00'),
(415, '108', 'Cirebon', 'Jogja', '2023-06-14', '2023-06-14', 701, '13:00:00', '14:00:00'),
(416, '109', 'Jakarta', 'Jayapura', '2023-01-01', '2023-01-01', 701, '13:00:00', '18:20:00'),
(417, '110', 'Jakarta', 'Jayapura', '2023-01-01', '2023-01-01', 702, '10:00:00', '15:20:00'),
(418, '111', 'Jakarta', 'Jayapura', '2023-01-01', '2023-01-01', 703, '18:00:00', '23:20:00'),
(419, '112', 'Jayapura', 'Jakarta', '2023-01-02', '2023-01-02', 701, '13:00:00', '18:20:00'),
(420, '113', 'Jayapura', 'Jakarta', '2023-01-02', '2023-01-02', 702, '14:00:00', '19:20:00'),
(421, '114', 'Jayapura', 'Jakarta', '2023-01-02', '2023-01-02', 703, '15:00:00', '20:20:00'),
(422, '115', 'Jakarta', 'Labuan Bajo', '2023-01-03', '2023-01-03', 704, '13:00:00', '15:25:00'),
(423, '116', 'Jakarta', 'Labuan Bajo', '2023-01-03', '2023-01-03', 705, '15:00:00', '17:25:00'),
(424, '117', 'Jakarta', 'Labuan Bajo', '2023-01-03', '2023-01-03', 711, '19:00:00', '21:25:00'),
(425, '118', 'Labuan Bajo', 'Jakarta', '2023-01-04', '2023-01-04', 704, '06:00:00', '08:25:00'),
(426, '119', 'Labuan Bajo', 'Jakarta', '2023-01-04', '2023-01-04', 705, '10:00:00', '12:25:00'),
(427, '120', 'Labuan Bajo', 'Jakarta', '2023-01-04', '2023-01-04', 711, '19:00:00', '21:25:00'),
(428, '121', 'Pontianak', 'Bali', '2023-01-05', '2023-01-05', 701, '01:00:00', '04:35:00'),
(429, '122', 'Pontianak', 'Bali', '2023-01-05', '2023-01-05', 702, '05:00:00', '08:35:00'),
(430, '123', 'Pontianak', 'Bali', '2023-01-05', '2023-01-05', 703, '19:00:00', '22:35:00'),
(431, '124', 'Bali', 'Pontianak', '2023-01-06', '2023-01-06', 701, '10:00:00', '13:35:00'),
(432, '125', 'Bali', 'Pontianak', '2023-01-06', '2023-01-06', 702, '11:00:00', '14:35:00'),
(433, '126', 'Bali', 'Pontianak', '2023-01-06', '2023-01-06', 703, '16:00:00', '19:35:00'),
(434, '127', 'Banda Aceh', 'Yogyakarta', '2023-01-07', '2023-01-07', 704, '01:00:00', '06:40:00'),
(435, '128', 'Banda Aceh', 'Yogyakarta', '2023-01-07', '2023-01-07', 705, '05:00:00', '10:40:00'),
(436, '129', 'Banda Aceh', 'Yogyakarta', '2023-01-07', '2023-01-07', 711, '18:00:00', '23:40:00'),
(437, '130', 'Yogyakarta', 'Banda Aceh', '2023-01-08', '2023-01-08', 704, '00:00:00', '05:40:00'),
(438, '131', 'Yogyakarta', 'Banda Aceh', '2023-01-08', '2023-01-08', 705, '08:00:00', '13:40:00'),
(439, '132', 'Yogyakarta', 'Banda Aceh', '2023-01-08', '2023-01-08', 711, '10:00:00', '15:40:00');

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `kelasID` int(11) NOT NULL,
  `jenisKelas` varchar(50) NOT NULL,
  `fasilitas` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`kelasID`, `jenisKelas`, `fasilitas`) VALUES
(1, 'BISNIS', 'Fasilitas Bisnis'),
(2, 'EKONOMI', 'Fasilitas Ekonomi');

-- --------------------------------------------------------

--
-- Table structure for table `kendaraan`
--

CREATE TABLE `kendaraan` (
  `kendaraanID` int(11) NOT NULL,
  `namaKendaraan` varchar(50) NOT NULL,
  `jumlahSeat` int(11) NOT NULL,
  `jenisKendaraan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kendaraan`
--

INSERT INTO `kendaraan` (`kendaraanID`, `namaKendaraan`, `jumlahSeat`, `jenisKendaraan`) VALUES
(701, 'Wings Air', 17, 'Pesawat'),
(702, 'Garuda Indonesia', 18, 'Pesawat'),
(703, 'Sriwijaya Air', 10, 'Pesawat'),
(704, 'Batik Air', 16, 'Pesawat'),
(705, 'Citilink', 15, 'Pesawat'),
(711, 'Lion Air', 15, 'Pesawat');

-- --------------------------------------------------------

--
-- Table structure for table `pemesanan`
--

CREATE TABLE `pemesanan` (
  `pemesananID` int(11) NOT NULL,
  `statusPemesanan` varchar(50) NOT NULL,
  `jumlahPesanan` int(11) NOT NULL,
  `totalTagihan` double NOT NULL,
  `userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pemesanan`
--

INSERT INTO `pemesanan` (`pemesananID`, `statusPemesanan`, `jumlahPesanan`, `totalTagihan`, `userID`) VALUES
(312, 'Proses Input', 0, 0, 1),
(313, 'Proses Input', 0, 0, 1),
(314, 'Proses Input', 0, 0, 1),
(315, 'Proses Input', 0, 0, 1),
(316, 'Proses Input', 0, 0, 1),
(317, 'Proses Input', 0, 0, 1),
(318, 'Proses Input', 0, 0, 1),
(319, 'Proses Input', 0, 0, 1),
(320, 'Proses Input', 0, 0, 1),
(321, 'Proses Input', 0, 0, 1),
(322, 'Proses Input', 0, 0, 1),
(323, 'Sudah Bayar', 1, 600000, 1),
(324, 'Sudah Bayar', 1, 600000, 1),
(325, 'Sudah Bayar', 1, 600000, 1),
(326, 'Belum Bayar', 1, 600000, 1),
(327, 'Belum Bayar', 1, 600000, 1),
(328, 'Sudah Bayar', 1, 600000, 2),
(329, 'Sudah Bayar', 1, 600000, 2),
(330, 'Belum Bayar', 1, 3000000, 2),
(331, 'Belum Bayar', 1, 3000000, 2),
(332, 'Belum Bayar', 1, 600000, 2),
(333, 'Sudah Bayar', 1, 600000, 3),
(334, 'Sudah Bayar', 1, 600000, 3),
(335, 'Sudah Bayar', 1, 600000, 3),
(336, 'Sudah Bayar', 1, 600000, 3),
(337, 'Belum Bayar', 1, 600000, 3),
(338, 'Proses Input', 0, 0, 3),
(339, 'Belum Bayar', 1, 300000, 4),
(340, 'Sudah Bayar', 2, 600000, 4),
(341, 'Sudah Bayar', 1, 600000, 4),
(342, 'Sudah Bayar', 1, 600000, 4),
(343, 'Belum Bayar', 3, 1800000, 4),
(344, 'Sudah Bayar', 1, 600000, 5),
(345, 'Sudah Bayar', 1, 600000, 5),
(346, 'Sudah Bayar', 1, 600000, 5),
(347, 'Belum Bayar', 1, 600000, 5),
(348, 'Belum Bayar', 1, 600000, 5);

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `seatID` int(11) NOT NULL,
  `noSeat` varchar(50) NOT NULL,
  `harga` double NOT NULL,
  `statusSeat` tinyint(4) NOT NULL,
  `detailPerjalananId` int(11) NOT NULL,
  `kelasID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `seat`
--

INSERT INTO `seat` (`seatID`, `noSeat`, `harga`, `statusSeat`, `detailPerjalananId`, `kelasID`) VALUES
(642, 'A1', 600000, 0, 401, 1),
(643, 'A2', 600000, 0, 401, 1),
(644, 'A3', 600000, 0, 401, 1),
(645, 'A4', 600000, 0, 401, 1),
(646, 'A5', 600000, 0, 401, 1),
(647, 'A6', 600000, 0, 401, 1),
(648, 'A7', 600000, 0, 401, 1),
(649, 'A8', 600000, 0, 401, 1),
(650, 'A9', 600000, 0, 401, 1),
(651, 'A10', 600000, 0, 401, 1),
(652, 'A11', 300000, 0, 401, 2),
(653, 'A12', 300000, 0, 401, 2),
(654, 'A13', 300000, 0, 401, 2),
(655, 'A14', 300000, 0, 401, 2),
(656, 'A15', 300000, 0, 401, 2),
(657, 'A1', 600000, 0, 402, 2),
(658, 'A2', 600000, 0, 402, 2),
(659, 'A3', 600000, 0, 402, 2),
(660, 'A4', 600000, 0, 402, 2),
(661, 'A5', 600000, 0, 402, 2),
(662, 'A6', 600000, 0, 402, 2),
(663, 'A7', 600000, 0, 402, 2),
(664, 'A8', 600000, 0, 402, 2),
(665, 'A9', 600000, 0, 402, 2),
(666, 'A10', 600000, 0, 402, 2),
(667, 'A11', 1200000, 0, 402, 1),
(668, 'A12', 1200000, 0, 402, 1),
(669, 'A13', 1200000, 0, 402, 1),
(670, 'A14', 1200000, 0, 402, 1),
(671, 'A15', 1200000, 0, 402, 1),
(672, 'A16', 1200000, 0, 402, 1),
(673, 'A1', 1000000, 0, 403, 2),
(674, 'A2', 1000000, 0, 403, 2),
(675, 'A3', 1000000, 0, 403, 2),
(676, 'A4', 1000000, 0, 403, 2),
(677, 'A5', 1000000, 0, 403, 2),
(678, 'A6', 1000000, 0, 403, 2),
(679, 'A7', 1000000, 0, 403, 2),
(680, 'A8', 1000000, 0, 403, 2),
(681, 'A9', 1000000, 0, 403, 2),
(682, 'A10', 1000000, 0, 403, 2),
(683, 'A11', 1000000, 0, 403, 2),
(684, 'A12', 1000000, 0, 403, 2),
(685, 'A13', 3000000, 0, 403, 1),
(686, 'A14', 3000000, 0, 403, 1),
(687, 'A15', 3000000, 0, 403, 1),
(688, 'A16', 3000000, 0, 403, 1),
(689, 'A17', 3000000, 0, 403, 1),
(690, 'A18', 3000000, 0, 403, 1),
(691, 'A1', 600000, 0, 404, 2),
(692, 'A2', 600000, 0, 404, 2),
(693, 'A3', 600000, 0, 404, 2),
(694, 'A4', 600000, 0, 404, 2),
(695, 'A5', 600000, 0, 404, 2),
(696, 'A6', 600000, 0, 404, 2),
(697, 'A7', 600000, 0, 404, 2),
(698, 'A8', 600000, 0, 404, 2),
(699, 'A9', 600000, 0, 404, 2),
(700, 'A10', 600000, 0, 404, 2),
(701, 'A11', 1000000, 0, 404, 1),
(702, 'A12', 1000000, 0, 404, 1),
(703, 'A13', 1000000, 0, 404, 1),
(704, 'A14', 1000000, 0, 404, 1),
(705, 'A15', 1000000, 0, 404, 1),
(706, 'A1', 1500000, 0, 405, 2),
(707, 'A2', 1500000, 0, 405, 2),
(708, 'A3', 1500000, 0, 405, 2),
(709, 'A4', 1500000, 0, 405, 2),
(710, 'A5', 1500000, 0, 405, 2),
(711, 'A6', 1500000, 0, 405, 2),
(712, 'A7', 1500000, 0, 405, 2),
(713, 'A8', 1500000, 0, 405, 2),
(714, 'A9', 3000000, 0, 405, 1),
(715, 'A10', 3000000, 0, 405, 1),
(716, 'A1', 600000, 0, 406, 2),
(717, 'A1', 600000, 0, 407, 2),
(718, 'A2', 600000, 0, 406, 2),
(719, 'A2', 600000, 0, 407, 2),
(720, 'A3', 600000, 0, 406, 2),
(721, 'A3', 600000, 0, 407, 2),
(722, 'A4', 600000, 0, 406, 2),
(723, 'A4', 600000, 0, 407, 2),
(724, 'A5', 600000, 0, 406, 2),
(725, 'A5', 600000, 0, 407, 2),
(726, 'A6', 600000, 0, 406, 2),
(727, 'A6', 600000, 0, 407, 2),
(728, 'A7', 600000, 0, 406, 2),
(729, 'A7', 600000, 0, 407, 2),
(730, 'A8', 600000, 0, 406, 2),
(731, 'A8', 600000, 0, 407, 2),
(732, 'A9', 600000, 0, 406, 2),
(733, 'A9', 600000, 0, 407, 2),
(734, 'A10', 600000, 0, 406, 2),
(735, 'A10', 600000, 0, 407, 2),
(736, 'A11', 600000, 0, 406, 2),
(737, 'A11', 600000, 0, 407, 2),
(738, 'A12', 1500000, 0, 406, 2),
(739, 'A12', 1500000, 0, 407, 2),
(740, 'A13', 1500000, 0, 406, 2),
(741, 'A13', 1500000, 0, 407, 2),
(742, 'A14', 1500000, 0, 406, 2),
(743, 'A14', 1500000, 0, 407, 2),
(744, 'A15', 1500000, 0, 406, 2),
(745, 'A15', 1500000, 0, 407, 2),
(746, 'A16', 1500000, 0, 406, 2),
(747, 'A16', 1500000, 0, 407, 2),
(748, 'A17', 1500000, 0, 406, 2),
(749, 'A17', 1500000, 0, 407, 2),
(750, 'A1', 700000, 0, 415, 2),
(751, 'A2', 700000, 0, 415, 2),
(752, 'A3', 700000, 0, 415, 2),
(753, 'A4', 700000, 0, 415, 2),
(754, 'A5', 700000, 0, 415, 2),
(755, 'A6', 700000, 0, 415, 2),
(756, 'A7', 700000, 0, 415, 2),
(757, 'A8', 700000, 0, 415, 2),
(758, 'A9', 999000, 0, 415, 1),
(759, 'A10', 999000, 0, 415, 1),
(760, 'A11', 999000, 0, 415, 1),
(761, 'A12', 999000, 0, 415, 1),
(762, 'A13', 999000, 0, 415, 1),
(763, 'A14', 999000, 0, 415, 1),
(764, 'A15', 999000, 0, 415, 1),
(765, 'A16', 999000, 0, 415, 1),
(766, 'A17', 999000, 0, 415, 1),
(767, 'A1', 3000000, 0, 416, 2),
(768, 'A2', 3000000, 0, 416, 2),
(769, 'A3', 3000000, 0, 416, 2),
(770, 'A4', 3000000, 0, 416, 2),
(771, 'A5', 3000000, 0, 416, 2),
(772, 'A6', 3000000, 0, 416, 2),
(773, 'A7', 3000000, 0, 416, 2),
(774, 'A8', 3000000, 0, 416, 2),
(775, 'A9', 4250000, 0, 416, 1),
(776, 'A10', 4250000, 0, 416, 1),
(777, 'A11', 4250000, 0, 416, 1),
(778, 'A12', 4250000, 0, 416, 1),
(779, 'A13', 4250000, 0, 416, 1),
(780, 'A14', 4250000, 0, 416, 1),
(781, 'A15', 4250000, 0, 416, 1),
(782, 'A16', 4250000, 0, 416, 1),
(783, 'A17', 4250000, 0, 416, 1),
(784, 'A1', 2500000, 0, 417, 2),
(785, 'A2', 2500000, 0, 417, 2),
(786, 'A3', 2500000, 0, 417, 2),
(787, 'A4', 2500000, 0, 417, 2),
(788, 'A5', 2500000, 0, 417, 2),
(789, 'A6', 2500000, 0, 417, 2),
(790, 'A7', 2500000, 0, 417, 2),
(791, 'A8', 2500000, 0, 417, 2),
(792, 'A9', 2500000, 0, 417, 2),
(793, 'A10', 4300000, 0, 417, 1),
(794, 'A11', 4300000, 0, 417, 1),
(795, 'A12', 4300000, 0, 417, 1),
(796, 'A13', 4300000, 0, 417, 1),
(797, 'A14', 4300000, 0, 417, 1),
(798, 'A15', 4300000, 0, 417, 1),
(799, 'A16', 4300000, 0, 417, 1),
(800, 'A17', 4300000, 0, 417, 1),
(801, 'A18', 4300000, 0, 417, 1),
(802, 'A1', 2000000, 0, 418, 2),
(803, 'A2', 2000000, 0, 418, 2),
(804, 'A3', 2000000, 0, 418, 2),
(805, 'A4', 2000000, 0, 418, 2),
(806, 'A5', 2000000, 0, 418, 2),
(807, 'A6', 3300000, 0, 418, 1),
(808, 'A7', 3300000, 0, 418, 1),
(809, 'A8', 3300000, 0, 418, 1),
(810, 'A9', 3300000, 0, 418, 1),
(811, 'A10', 3300000, 0, 418, 1),
(812, 'A1', 2800000, 0, 419, 2),
(813, 'A2', 2800000, 0, 419, 2),
(814, 'A3', 2800000, 0, 419, 2),
(815, 'A4', 2800000, 0, 419, 2),
(816, 'A5', 2800000, 0, 419, 2),
(817, 'A6', 2800000, 0, 419, 2),
(818, 'A7', 2800000, 0, 419, 2),
(819, 'A8', 2800000, 0, 419, 2),
(820, 'A9', 4100000, 0, 419, 1),
(821, 'A10', 4100000, 0, 419, 1),
(822, 'A11', 4100000, 0, 419, 1),
(823, 'A12', 4100000, 0, 419, 1),
(824, 'A13', 4100000, 0, 419, 1),
(825, 'A14', 4100000, 0, 419, 1),
(826, 'A15', 4100000, 0, 419, 1),
(827, 'A16', 4100000, 0, 419, 1),
(828, 'A17', 4100000, 0, 419, 1),
(829, 'A1', 2500000, 0, 420, 2),
(830, 'A2', 2500000, 0, 420, 2),
(831, 'A3', 2500000, 0, 420, 2),
(832, 'A4', 2500000, 0, 420, 2),
(833, 'A5', 2500000, 0, 420, 2),
(834, 'A6', 2500000, 0, 420, 2),
(835, 'A7', 2500000, 0, 420, 2),
(836, 'A8', 2500000, 0, 420, 2),
(837, 'A9', 2500000, 0, 420, 2),
(838, 'A10', 3700000, 0, 420, 1),
(839, 'A11', 3700000, 0, 420, 1),
(840, 'A12', 3700000, 0, 420, 1),
(841, 'A13', 3700000, 0, 420, 1),
(842, 'A14', 3700000, 0, 420, 1),
(843, 'A15', 3700000, 0, 420, 1),
(844, 'A16', 3700000, 0, 420, 1),
(845, 'A17', 3700000, 0, 420, 1),
(846, 'A18', 3700000, 0, 420, 1),
(847, 'A1', 2200000, 0, 421, 2),
(848, 'A2', 2200000, 0, 421, 2),
(849, 'A3', 2200000, 0, 421, 2),
(850, 'A4', 2200000, 0, 421, 2),
(851, 'A5', 2200000, 0, 421, 2),
(852, 'A6', 3200000, 0, 421, 1),
(853, 'A7', 3200000, 0, 421, 1),
(854, 'A8', 3200000, 0, 421, 1),
(855, 'A9', 3200000, 0, 421, 1),
(856, 'A10', 3200000, 0, 421, 1),
(857, 'A1', 1500000, 0, 422, 2),
(858, 'A2', 1500000, 0, 422, 2),
(859, 'A3', 1500000, 0, 422, 2),
(860, 'A4', 1500000, 0, 422, 2),
(861, 'A5', 1500000, 0, 422, 2),
(862, 'A6', 1500000, 0, 422, 2),
(863, 'A7', 1500000, 0, 422, 2),
(864, 'A8', 1500000, 0, 422, 2),
(865, 'A9', 2600000, 0, 422, 1),
(866, 'A10', 2600000, 0, 422, 1),
(867, 'A11', 2600000, 0, 422, 1),
(868, 'A12', 2600000, 0, 422, 1),
(869, 'A13', 2600000, 0, 422, 1),
(870, 'A14', 2600000, 0, 422, 1),
(871, 'A15', 2600000, 0, 422, 1),
(872, 'A16', 2600000, 0, 422, 1),
(873, 'A1', 1200000, 0, 423, 2),
(874, 'A2', 1200000, 0, 423, 2),
(875, 'A3', 1200000, 0, 423, 2),
(876, 'A4', 1200000, 0, 423, 2),
(877, 'A5', 1200000, 0, 423, 2),
(878, 'A6', 1200000, 0, 423, 2),
(879, 'A7', 1200000, 0, 423, 2),
(880, 'A8', 2000000, 0, 423, 1),
(881, 'A9', 2000000, 0, 423, 1),
(882, 'A10', 2000000, 0, 423, 1),
(883, 'A11', 2000000, 0, 423, 1),
(884, 'A12', 2000000, 0, 423, 1),
(885, 'A13', 2000000, 0, 423, 1),
(886, 'A14', 2000000, 0, 423, 1),
(887, 'A15', 2000000, 0, 423, 1),
(888, 'A1', 2035000, 0, 424, 2),
(889, 'A2', 2035000, 0, 424, 2),
(890, 'A3', 2035000, 0, 424, 2),
(891, 'A4', 2035000, 0, 424, 2),
(892, 'A5', 2035000, 0, 424, 2),
(893, 'A6', 2035000, 0, 424, 2),
(894, 'A7', 2035000, 0, 424, 2),
(895, 'A8', 2830000, 0, 424, 1),
(896, 'A9', 2830000, 0, 424, 1),
(897, 'A10', 2830000, 0, 424, 1),
(898, 'A11', 2830000, 0, 424, 1),
(899, 'A12', 2830000, 0, 424, 1),
(900, 'A13', 2830000, 0, 424, 1),
(901, 'A14', 2830000, 0, 424, 1),
(902, 'A15', 2830000, 0, 424, 1),
(903, 'A1', 1600000, 0, 425, 2),
(904, 'A2', 1600000, 0, 425, 2),
(905, 'A3', 1600000, 0, 425, 2),
(906, 'A4', 1600000, 0, 425, 2),
(907, 'A5', 1600000, 0, 425, 2),
(908, 'A6', 1600000, 0, 425, 2),
(909, 'A7', 1600000, 0, 425, 2),
(910, 'A8', 1600000, 0, 425, 2),
(911, 'A9', 2600000, 0, 425, 1),
(912, 'A10', 2600000, 0, 425, 1),
(913, 'A11', 2600000, 0, 425, 1),
(914, 'A12', 2600000, 0, 425, 1),
(915, 'A13', 2600000, 0, 425, 1),
(916, 'A14', 2600000, 0, 425, 1),
(917, 'A15', 2600000, 0, 425, 1),
(918, 'A16', 2600000, 0, 425, 1),
(919, 'A1', 1900000, 0, 426, 2),
(920, 'A2', 1900000, 0, 426, 2),
(921, 'A3', 1900000, 0, 426, 2),
(922, 'A4', 1900000, 0, 426, 2),
(923, 'A5', 1900000, 0, 426, 2),
(924, 'A6', 1900000, 0, 426, 2),
(925, 'A7', 1900000, 0, 426, 2),
(926, 'A8', 2900000, 0, 426, 1),
(927, 'A9', 2900000, 0, 426, 1),
(928, 'A10', 2900000, 0, 426, 1),
(929, 'A11', 2900000, 0, 426, 1),
(930, 'A12', 2900000, 0, 426, 1),
(931, 'A13', 2900000, 0, 426, 1),
(932, 'A14', 2900000, 0, 426, 1),
(933, 'A15', 2900000, 0, 426, 1),
(934, 'A1', 1800000, 0, 427, 2),
(935, 'A2', 1800000, 0, 427, 2),
(936, 'A3', 1800000, 0, 427, 2),
(937, 'A4', 1800000, 0, 427, 2),
(938, 'A5', 1800000, 0, 427, 2),
(939, 'A6', 1800000, 0, 427, 2),
(940, 'A7', 1800000, 0, 427, 2),
(941, 'A8', 3100000, 0, 427, 1),
(942, 'A9', 3100000, 0, 427, 1),
(943, 'A10', 3100000, 0, 427, 1),
(944, 'A11', 3100000, 0, 427, 1),
(945, 'A12', 3100000, 0, 427, 1),
(946, 'A13', 3100000, 0, 427, 1),
(947, 'A14', 3100000, 0, 427, 1),
(948, 'A15', 3100000, 0, 427, 1),
(949, 'A1', 1650000, 0, 428, 2),
(950, 'A2', 1650000, 0, 428, 2),
(951, 'A3', 1650000, 0, 428, 2),
(952, 'A4', 1650000, 0, 428, 2),
(953, 'A5', 1650000, 0, 428, 2),
(954, 'A6', 1650000, 0, 428, 2),
(955, 'A7', 1650000, 0, 428, 2),
(956, 'A8', 1650000, 0, 428, 2),
(957, 'A9', 2999000, 0, 428, 1),
(958, 'A10', 2999000, 0, 428, 1),
(959, 'A11', 2999000, 0, 428, 1),
(960, 'A12', 2999000, 0, 428, 1),
(961, 'A13', 2999000, 0, 428, 1),
(962, 'A14', 2999000, 0, 428, 1),
(963, 'A15', 2999000, 0, 428, 1),
(964, 'A16', 2999000, 0, 428, 1),
(965, 'A17', 2999000, 0, 428, 1),
(966, 'A1', 1500000, 0, 429, 2),
(967, 'A2', 1500000, 0, 429, 2),
(968, 'A3', 1500000, 0, 429, 2),
(969, 'A4', 1500000, 0, 429, 2),
(970, 'A5', 1500000, 0, 429, 2),
(971, 'A6', 1500000, 0, 429, 2),
(972, 'A7', 1500000, 0, 429, 2),
(973, 'A8', 1500000, 0, 429, 2),
(974, 'A9', 1500000, 0, 429, 2),
(975, 'A10', 2630000, 0, 429, 1),
(976, 'A11', 2630000, 0, 429, 1),
(977, 'A12', 2630000, 0, 429, 1),
(978, 'A13', 2630000, 0, 429, 1),
(979, 'A14', 2630000, 0, 429, 1),
(980, 'A15', 2630000, 0, 429, 1),
(981, 'A16', 2630000, 0, 429, 1),
(982, 'A17', 2630000, 0, 429, 1),
(983, 'A18', 2630000, 0, 429, 1),
(984, 'A1', 1400000, 0, 430, 2),
(985, 'A2', 1400000, 0, 430, 2),
(986, 'A3', 1400000, 0, 430, 2),
(987, 'A4', 1400000, 0, 430, 2),
(988, 'A5', 1400000, 0, 430, 2),
(989, 'A6', 2700000, 0, 430, 1),
(990, 'A7', 2700000, 0, 430, 1),
(991, 'A8', 2700000, 0, 430, 1),
(992, 'A9', 2700000, 0, 430, 1),
(993, 'A10', 2700000, 0, 430, 1),
(994, 'A1', 1299000, 0, 431, 2),
(995, 'A2', 1299000, 0, 431, 2),
(996, 'A3', 1299000, 0, 431, 2),
(997, 'A4', 1299000, 0, 431, 2),
(998, 'A5', 1299000, 0, 431, 2),
(999, 'A6', 1299000, 0, 431, 2),
(1000, 'A7', 1299000, 0, 431, 2),
(1001, 'A8', 1299000, 0, 431, 2),
(1002, 'A9', 1945000, 0, 431, 1),
(1003, 'A10', 1945000, 0, 431, 1),
(1004, 'A11', 1945000, 0, 431, 1),
(1005, 'A12', 1945000, 0, 431, 1),
(1006, 'A13', 1945000, 0, 431, 1),
(1007, 'A14', 1945000, 0, 431, 1),
(1008, 'A15', 1945000, 0, 431, 1),
(1009, 'A16', 1945000, 0, 431, 1),
(1010, 'A17', 1945000, 0, 431, 1),
(1011, 'A1', 1537000, 0, 432, 2),
(1012, 'A2', 1537000, 0, 432, 2),
(1013, 'A3', 1537000, 0, 432, 2),
(1014, 'A4', 1537000, 0, 432, 2),
(1015, 'A5', 1537000, 0, 432, 2),
(1016, 'A6', 1537000, 0, 432, 2),
(1017, 'A7', 1537000, 0, 432, 2),
(1018, 'A8', 1537000, 0, 432, 2),
(1019, 'A9', 1537000, 0, 432, 2),
(1020, 'A10', 2477000, 0, 432, 1),
(1021, 'A11', 2477000, 0, 432, 1),
(1022, 'A12', 2477000, 0, 432, 1),
(1023, 'A13', 2477000, 0, 432, 1),
(1024, 'A14', 2477000, 0, 432, 1),
(1025, 'A15', 2477000, 0, 432, 1),
(1026, 'A16', 2477000, 0, 432, 1),
(1027, 'A17', 2477000, 0, 432, 1),
(1028, 'A18', 2477000, 0, 432, 1),
(1029, 'A1', 1857000, 0, 433, 2),
(1030, 'A2', 1857000, 0, 433, 2),
(1031, 'A3', 1857000, 0, 433, 2),
(1032, 'A4', 1857000, 0, 433, 2),
(1033, 'A5', 1857000, 0, 433, 2),
(1034, 'A6', 2757000, 0, 433, 1),
(1035, 'A7', 2757000, 0, 433, 1),
(1036, 'A8', 2757000, 0, 433, 1),
(1037, 'A9', 2757000, 0, 433, 1),
(1038, 'A10', 2757000, 0, 433, 1),
(1039, 'A1', 1750000, 0, 434, 2),
(1040, 'A2', 1750000, 0, 434, 2),
(1041, 'A3', 1750000, 0, 434, 2),
(1042, 'A4', 1750000, 0, 434, 2),
(1043, 'A5', 1750000, 0, 434, 2),
(1044, 'A6', 1750000, 0, 434, 2),
(1045, 'A7', 1750000, 0, 434, 2),
(1046, 'A8', 1750000, 0, 434, 2),
(1047, 'A9', 2940000, 0, 434, 1),
(1048, 'A10', 2940000, 0, 434, 1),
(1049, 'A11', 2940000, 0, 434, 1),
(1050, 'A12', 2940000, 0, 434, 1),
(1051, 'A13', 2940000, 0, 434, 1),
(1052, 'A14', 2940000, 0, 434, 1),
(1053, 'A15', 2940000, 0, 434, 1),
(1054, 'A16', 2940000, 0, 434, 1),
(1055, 'A1', 1860000, 0, 435, 2),
(1056, 'A2', 1860000, 0, 435, 2),
(1057, 'A3', 1860000, 0, 435, 2),
(1058, 'A4', 1860000, 0, 435, 2),
(1059, 'A5', 1860000, 0, 435, 2),
(1060, 'A6', 1860000, 0, 435, 2),
(1061, 'A7', 1860000, 0, 435, 2),
(1062, 'A8', 2900000, 0, 435, 1),
(1063, 'A9', 2900000, 0, 435, 1),
(1064, 'A10', 2900000, 0, 435, 1),
(1065, 'A11', 2900000, 0, 435, 1),
(1066, 'A12', 2900000, 0, 435, 1),
(1067, 'A13', 2900000, 0, 435, 1),
(1068, 'A14', 2900000, 0, 435, 1),
(1069, 'A15', 2900000, 0, 435, 1),
(1070, 'A1', 1960000, 0, 436, 2),
(1071, 'A2', 1960000, 0, 436, 2),
(1072, 'A3', 1960000, 0, 436, 2),
(1073, 'A4', 1960000, 0, 436, 2),
(1074, 'A5', 1960000, 0, 436, 2),
(1075, 'A6', 1960000, 0, 436, 2),
(1076, 'A7', 1960000, 0, 436, 2),
(1077, 'A8', 2860000, 0, 436, 1),
(1078, 'A9', 2860000, 0, 436, 1),
(1079, 'A10', 2860000, 0, 436, 1),
(1080, 'A11', 2860000, 0, 436, 1),
(1081, 'A12', 2860000, 0, 436, 1),
(1082, 'A13', 2860000, 0, 436, 1),
(1083, 'A14', 2860000, 0, 436, 1),
(1084, 'A15', 2860000, 0, 436, 1),
(1085, 'A1', 1630000, 0, 437, 2),
(1086, 'A2', 1630000, 0, 437, 2),
(1087, 'A3', 1630000, 0, 437, 2),
(1088, 'A4', 1630000, 0, 437, 2),
(1089, 'A5', 1630000, 0, 437, 2),
(1090, 'A6', 1630000, 0, 437, 2),
(1091, 'A7', 1630000, 0, 437, 2),
(1092, 'A8', 1630000, 0, 437, 2),
(1093, 'A9', 2430000, 0, 437, 1),
(1094, 'A10', 2430000, 0, 437, 1),
(1095, 'A11', 2430000, 0, 437, 1),
(1096, 'A12', 2430000, 0, 437, 1),
(1097, 'A13', 2430000, 0, 437, 1),
(1098, 'A14', 2430000, 0, 437, 1),
(1099, 'A15', 2430000, 0, 437, 1),
(1100, 'A16', 2430000, 0, 437, 1),
(1101, 'A1', 1430000, 0, 438, 2),
(1102, 'A2', 1430000, 0, 438, 2),
(1103, 'A3', 1430000, 0, 438, 2),
(1104, 'A4', 1430000, 0, 438, 2),
(1105, 'A5', 1430000, 0, 438, 2),
(1106, 'A6', 1430000, 0, 438, 2),
(1107, 'A7', 1430000, 0, 438, 2),
(1108, 'A8', 2530000, 0, 438, 1),
(1109, 'A9', 2530000, 0, 438, 1),
(1110, 'A10', 2530000, 0, 438, 1),
(1111, 'A11', 2530000, 0, 438, 1),
(1112, 'A12', 2530000, 0, 438, 1),
(1113, 'A13', 2530000, 0, 438, 1),
(1114, 'A14', 2530000, 0, 438, 1),
(1115, 'A15', 2530000, 0, 438, 1),
(1116, 'A1', 1830000, 0, 439, 2),
(1117, 'A2', 1830000, 0, 439, 2),
(1118, 'A3', 1830000, 0, 439, 2),
(1119, 'A4', 1830000, 0, 439, 2),
(1120, 'A5', 1830000, 0, 439, 2),
(1121, 'A6', 1830000, 0, 439, 2),
(1122, 'A7', 1830000, 0, 439, 2),
(1123, 'A8', 2730000, 0, 439, 1),
(1124, 'A9', 2730000, 0, 439, 1),
(1125, 'A10', 2730000, 0, 439, 1),
(1126, 'A11', 2730000, 0, 439, 1),
(1127, 'A12', 2730000, 0, 439, 1),
(1128, 'A13', 2730000, 0, 439, 1),
(1129, 'A14', 2730000, 0, 439, 1),
(1130, 'A15', 2730000, 0, 439, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE `tiket` (
  `tiketID` int(11) NOT NULL,
  `namaPemesan` varchar(50) NOT NULL,
  `idCard` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `statusTiket` varchar(50) NOT NULL,
  `kewarganegaraan` varchar(50) NOT NULL,
  `nomorSeat` varchar(50) NOT NULL,
  `pemesananID` int(11) NOT NULL,
  `detailPerjalananID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tiket`
--

INSERT INTO `tiket` (`tiketID`, `namaPemesan`, `idCard`, `email`, `statusTiket`, `kewarganegaraan`, `nomorSeat`, `pemesananID`, `detailPerjalananID`) VALUES
(512, 'I Komang Agus Tinar Virgo Tryana Putra', '1', 'tinar123@gmail.com', 'Belum Bayar', 'Indonesia', 'A12', 323, 416),
(513, 'I Komang Agus Tinar Virgo Tryana Putra', '1', 'tinar123@gmail.com', 'Belum Bayar', 'Indonesia', 'A9', 324, 419),
(514, 'I Komang Agus Tinar Virgo Tryana Putra', '1', 'tinar123@gmail.com', 'Belum Bayar', 'Indonesia', 'A1', 325, 401),
(515, 'I Komang Agus Tinar Virgo Tryana Putra', '1', 'tinar123', 'Belum Bayar', 'Indonesia', 'A9', 326, 415),
(516, 'I Komang Agus Tinar Virgo Tryana Putra', '1', 'tinar123', 'Belum Bayar', 'Indonesia', 'A9', 327, 431),
(517, 'Jeff Michael Anderson Budiono', '2', 'jeff123', 'Belum Bayar', 'Indonesia', 'A9', 328, 422),
(518, 'Jeff Michael Anderson Budiono', '2', 'jeff123@gmail.com', 'Belum Bayar', 'Indonesia', 'A9', 329, 425),
(519, 'Jeff Michael Anderson Budiono', '2', 'jeff123', 'Belum Bayar', 'Indonesia', 'A13', 330, 403),
(520, 'Jeff Michael Anderson Budiono', '2', 'jeff123', 'Belum Bayar', 'Indonesia', 'A9', 331, 405),
(521, 'Jeff Michael Anderson Budiono', '2', 'jeff123', 'Belum Bayar', 'Indonesia', 'A10', 332, 431),
(522, 'Made Yosa Bagas Brawijaya', '3', 'yosa123@gmail.com', 'Belum Bayar', 'Indonesia', 'A9', 333, 428),
(523, 'Made Yosa Bagas Brawijaya', '3', 'yosa123@gmail.com', 'Belum Bayar', 'Indonesia', 'A11', 334, 431),
(524, 'Made Yosa Bagas Brawijaya', '3', 'yosa123@gmail.com', 'Belum Bayar', 'Indonesia', 'A8', 335, 423),
(525, 'Made Yosa Bagas Brawijaya', '3', 'yosa123@gmail.com', 'Belum Bayar', 'Indonesia', 'A8', 336, 427),
(526, 'Made Yosa Bagas Brawijaya', '3', 'yosa123@gmail.com', 'Belum Bayar', 'Indonesia', 'A10', 337, 429),
(527, 'Agus Ferbiyanto', '5976890129875829', 'agusFebriyanto@gmail.com', 'Belum Bayar', 'Indonesia', 'A3', 339, 416),
(528, 'Caca Suminyah', '692686298732719', 'cacacaca777@gmail.com', 'Belum Bayar', 'Indonesia', 'A1', 340, 418),
(529, 'Sarah Ananda Kamaliya', '72097859309827', 'saraAnandaAa629@gmail.com', 'Belum Bayar', 'Indonesia', 'A2', 340, 418),
(530, 'Dandy Dalah', '12768712987521', 'DandydadaY2399@gmail.com', 'Belum Bayar', 'Indonesia', 'A13', 341, 416),
(531, 'Krisna Juniarta', '510407030620010', 'krisnakrisnaSapiBali@gmail.com', 'Belum Bayar', 'Indonesia', 'A10', 342, 417),
(532, 'Gede Bolo Putra', '51028825879152', 'bolobolo100@gmail.com', 'Belum Bayar', 'Indonesia', 'A1', 343, 406),
(533, 'Raihan Dwi Febrian', '69028698721987', 'HansGanteng2038@gmail.com', 'Belum Bayar', 'Indonesia', 'A2', 343, 406),
(534, 'Nugroho Dwi Putro', '51298789036298', 'YadaraNDalem@gmail.com', 'Belum Bayar', 'Indonesia', 'A3', 343, 406),
(535, 'Gede Pandu Prayaksa', '5', 'pandu123@gmail.com', 'Belum Bayar', 'Indonesia', 'A10', 344, 428),
(536, 'Gede Pandu Prayaksa', '5', 'pandu123@gmail.com', 'Belum Bayar', 'Indonesia', 'A10', 345, 432),
(537, 'Gede Pandu Prayaksa', '5', 'pandu123@gmail.com', 'Belum Bayar', 'Indonesia', 'A2', 346, 401),
(538, 'Gede Pandu Prayaksa', '5', 'pandu123@gmail.com', 'Belum Bayar', 'Indonesia', 'A4', 347, 406),
(539, 'Gede Pandu Prayaksa', '5', 'pandu123@gmail.com', 'Belum Bayar', 'Indonesia', 'A9', 348, 423);

-- --------------------------------------------------------

--
-- Table structure for table `twallet`
--

CREATE TABLE `twallet` (
  `twalletID` int(11) NOT NULL,
  `saldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `twallet`
--

INSERT INTO `twallet` (`twalletID`, `saldo`) VALUES
(1, 8017500),
(2, 8677500),
(3, 2352500),
(4, 8010000),
(5, 8015000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userID` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `noHP` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `twalletID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `username`, `password`, `nama`, `email`, `noHP`, `gender`, `twalletID`) VALUES
(1, 'tinar123', 'tinar123', 'I Komang Agus Tinar Virgo Tryana Putra', 'tinar123@gmail.com', '081345678901', 'Male', 1),
(2, 'jeff123', 'jeff123', 'Jeff Michael Anderson Budiono', 'jeff123@gmail.com', '085712345678', 'Male', 2),
(3, 'yosa123', 'yosa123', 'Made Yosa Bagas Brawijaya', 'yosa123@gmail.com', '081298765432', 'Male', 3),
(4, 'ari123', 'ari123', 'Ari Muliananda Siregar', 'ari123@gmail.com', '081924681357', 'Male', 4),
(5, 'pandu123', 'pandu123', 'Gede Pandu Prayaksa', 'pandu123@gmail.com', '081875319024', 'Male', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detailperjalanan`
--
ALTER TABLE `detailperjalanan`
  ADD PRIMARY KEY (`detailPerjalananID`),
  ADD KEY `KENDARAAN2` (`kendaraanID`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`kelasID`);

--
-- Indexes for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`kendaraanID`);

--
-- Indexes for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`pemesananID`),
  ADD KEY `USERID` (`userID`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`seatID`),
  ADD KEY `KELAS1` (`kelasID`),
  ADD KEY `SEAT` (`detailPerjalananId`) USING BTREE;

--
-- Indexes for table `tiket`
--
ALTER TABLE `tiket`
  ADD PRIMARY KEY (`tiketID`),
  ADD KEY `PEMESANAN1` (`pemesananID`),
  ADD KEY `DETAILPERJALANAN1` (`detailPerjalananID`);

--
-- Indexes for table `twallet`
--
ALTER TABLE `twallet`
  ADD PRIMARY KEY (`twalletID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`),
  ADD KEY `TWALLET` (`twalletID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detailperjalanan`
--
ALTER TABLE `detailperjalanan`
  MODIFY `detailPerjalananID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=440;

--
-- AUTO_INCREMENT for table `kendaraan`
--
ALTER TABLE `kendaraan`
  MODIFY `kendaraanID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=712;

--
-- AUTO_INCREMENT for table `pemesanan`
--
ALTER TABLE `pemesanan`
  MODIFY `pemesananID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=349;

--
-- AUTO_INCREMENT for table `seat`
--
ALTER TABLE `seat`
  MODIFY `seatID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1131;

--
-- AUTO_INCREMENT for table `tiket`
--
ALTER TABLE `tiket`
  MODIFY `tiketID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=540;

--
-- AUTO_INCREMENT for table `twallet`
--
ALTER TABLE `twallet`
  MODIFY `twalletID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detailperjalanan`
--
ALTER TABLE `detailperjalanan`
  ADD CONSTRAINT `KENDARAAN2` FOREIGN KEY (`kendaraanID`) REFERENCES `kendaraan` (`kendaraanID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD CONSTRAINT `USERID` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `seat`
--
ALTER TABLE `seat`
  ADD CONSTRAINT `DETAIL1` FOREIGN KEY (`detailPerjalananId`) REFERENCES `detailperjalanan` (`detailPerjalananID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `KELAS1` FOREIGN KEY (`kelasID`) REFERENCES `kelas` (`kelasID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tiket`
--
ALTER TABLE `tiket`
  ADD CONSTRAINT `DETAILPERJALANAN1` FOREIGN KEY (`detailPerjalananID`) REFERENCES `detailperjalanan` (`detailPerjalananID`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `TWALLET` FOREIGN KEY (`twalletID`) REFERENCES `twallet` (`twalletID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

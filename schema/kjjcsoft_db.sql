-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2016 at 01:55 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `kjjcsoft_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_collector`
--

CREATE TABLE IF NOT EXISTS `tbl_collector` (
  `collector_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `collector_status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`collector_id`),
  KEY `employee_id` (`employee_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tbl_collector`
--

INSERT INTO `tbl_collector` (`collector_id`, `employee_id`, `collector_status`) VALUES
(1, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_customer`
--

CREATE TABLE IF NOT EXISTS `tbl_customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) NOT NULL,
  `customer_age` int(11) NOT NULL,
  `customer_gender` enum('Male','Female') NOT NULL,
  `customer_dob` date NOT NULL,
  `customer_nationality` varchar(100) NOT NULL,
  `customer_citizenshipno` varchar(200) NOT NULL,
  `customer_perm_district` varchar(500) NOT NULL,
  `customer_perm_vdc_municipality` varchar(1000) NOT NULL,
  `customer_perm_extrainfo` varchar(1000) DEFAULT NULL,
  `customer_temp_district` varchar(500) NOT NULL,
  `customer_temp_vdc_municipality` varchar(1000) NOT NULL,
  `customer_temp_extrainfo` varchar(1000) DEFAULT NULL,
  `customer_cell_number_first` varchar(50) DEFAULT NULL,
  `customer_cell_number_second` varchar(50) DEFAULT NULL,
  `customer_landline` varchar(50) DEFAULT NULL,
  `customer_email` varchar(200) DEFAULT NULL,
  `customer_marital_status` enum('Married','Single') NOT NULL,
  `customer_spouse_name` varchar(100) DEFAULT NULL,
  `customer_occupation` varchar(500) NOT NULL,
  `customer_father_name` varchar(100) NOT NULL,
  `customer_grandfather_name` varchar(100) DEFAULT NULL,
  `customer_father_in_law_name` varchar(100) DEFAULT NULL,
  `nominee_name` varchar(200) NOT NULL,
  `nominee_relation` varchar(100) NOT NULL,
  `nominee_perm_district` varchar(100) NOT NULL,
  `nominee_perm_vdc_municipality` varchar(200) NOT NULL,
  `nominee_perm_extrainfo` varchar(200) DEFAULT NULL,
  `nominee_temp_district` varchar(200) NOT NULL,
  `nominee_temp_vdc_municipality` varchar(200) NOT NULL,
  `nominee_temp_extrainfo` varchar(200) DEFAULT NULL,
  `nominee_cell_number_first` varchar(50) DEFAULT NULL,
  `nominee_cell_number_second` varchar(50) DEFAULT NULL,
  `nominee_landline` varchar(50) DEFAULT NULL,
  `nominee_email` varchar(100) DEFAULT NULL,
  `guardian_name` varchar(200) NOT NULL,
  `guardian_relation` varchar(1000) DEFAULT NULL,
  `guardian_perm_district` varchar(200) NOT NULL,
  `guardian_perm_vdc_municipality` varchar(200) NOT NULL,
  `guardian_perm_extrainfo` varchar(200) DEFAULT NULL,
  `guardian_temp_district` varchar(200) NOT NULL,
  `guardian_temp_vdc_municipality` varchar(200) NOT NULL,
  `guardian_temp_extrainfo` varchar(200) DEFAULT NULL,
  `guardian_cell_number_one` varchar(50) DEFAULT NULL,
  `guardian_cell_number_second` varchar(50) DEFAULT NULL,
  `guardian_landline` varchar(50) DEFAULT NULL,
  `guardian_email` varchar(100) DEFAULT NULL,
  `customer_photo` varchar(2000) DEFAULT NULL,
  `customer_thumb_print` varchar(2000) DEFAULT NULL,
  `customer_joined_date` date NOT NULL,
  `customer_refferedby` varchar(100) DEFAULT NULL,
  `customer_approved_by` varchar(100) NOT NULL,
  `entry_by` int(11) NOT NULL,
  `customer_status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`customer_id`),
  KEY `user_id` (`entry_by`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `tbl_customer`
--

INSERT INTO `tbl_customer` (`customer_id`, `customer_name`, `customer_age`, `customer_gender`, `customer_dob`, `customer_nationality`, `customer_citizenshipno`, `customer_perm_district`, `customer_perm_vdc_municipality`, `customer_perm_extrainfo`, `customer_temp_district`, `customer_temp_vdc_municipality`, `customer_temp_extrainfo`, `customer_cell_number_first`, `customer_cell_number_second`, `customer_landline`, `customer_email`, `customer_marital_status`, `customer_spouse_name`, `customer_occupation`, `customer_father_name`, `customer_grandfather_name`, `customer_father_in_law_name`, `nominee_name`, `nominee_relation`, `nominee_perm_district`, `nominee_perm_vdc_municipality`, `nominee_perm_extrainfo`, `nominee_temp_district`, `nominee_temp_vdc_municipality`, `nominee_temp_extrainfo`, `nominee_cell_number_first`, `nominee_cell_number_second`, `nominee_landline`, `nominee_email`, `guardian_name`, `guardian_relation`, `guardian_perm_district`, `guardian_perm_vdc_municipality`, `guardian_perm_extrainfo`, `guardian_temp_district`, `guardian_temp_vdc_municipality`, `guardian_temp_extrainfo`, `guardian_cell_number_one`, `guardian_cell_number_second`, `guardian_landline`, `guardian_email`, `customer_photo`, `customer_thumb_print`, `customer_joined_date`, `customer_refferedby`, `customer_approved_by`, `entry_by`, `customer_status`) VALUES
(1, 'Adfasdf Shrestha', 22, 'Male', '1990-10-10', 'Asdfasdfsdaf', '', 'Asdfasdf', 'Asddfasdf', '', '', '', '', '9874563210', '', '', '', 'Single', '', 'Assdffsad', 'Asfasdf', 'Asddfasdf', '', 'Asddfasdf', 'Asdfasdf', 'Asdfasdf', 'Asdfsadf', '', '', '', '', '9845632102', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/love.jpg', 'customer_finger_prints/rc.JPG', '2015-11-18', '', 'Asdfsadfsa', 1, 1),
(2, 'Adfasdf', 22, 'Male', '1990-10-10', 'Asdfasdfsdaf', '', 'Asdfasdf', 'Asddfasdf', '', '', '', '', '9874563210', '', '', '', 'Single', '', 'Assdffsad', 'Asfasdf', 'Asddfasdf', '', 'Asddfasdf', 'Asdfasdf', 'Asdfasdf', 'Asdfsadf', '', '', '', '', '9845632102', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/342fc.JPG', 'customer_finger_prints/love.jpg', '2015-11-18', '', 'Asdfsadfsa', 1, 1),
(3, 'Adfasdf', 22, 'Male', '1990-10-10', 'Asdfasdfsdaf', '', 'Asdfasdf', 'Asddfasdf', '', '', '', '', '9874563210', '', '', '', 'Single', '', 'Assdffsad', 'Asfasdf', 'Asddfasdf', '', 'Asddfasdf', 'Asdfasdf', 'Asdfasdf', 'Asdfsadf', '', '', '', '', '9845632102', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', NULL, NULL, '2015-11-18', '', 'Asdfsadfsa', 1, 1),
(4, 'Adfasdf', 22, 'Male', '1990-10-10', 'Asdfasdfsdaf', '', 'Asdfasdf', 'Asddfasdf', '', '', '', '', '9874563210', '', '', '', 'Single', '', 'Assdffsad', 'Asfasdf', 'Asddfasdf', '', 'Asddfasdf', 'Asdfasdf', 'Asdfasdf', 'Asdfsadf', '', '', '', '', '9845632102', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', NULL, NULL, '2015-11-18', '', 'Asdfsadfsa', 1, 1),
(5, 'Adfasdf', 22, 'Male', '1990-10-10', 'Asdfasdfsdaf', '', 'Asdfasdf', 'Asddfasdf', '', '', '', '', '9874563210', '', '', '', 'Single', '', 'Assdffsad', 'Asfasdf', 'Asddfasdf', '', 'Asddfasdf', 'Asdfasdf', 'Asdfasdf', 'Asdfsadf', '', '', '', '', '9845632102', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', NULL, NULL, '2015-11-18', '', 'Asdfsadfsa', 1, 1),
(6, 'Adfasdf', 22, 'Male', '1990-10-10', 'Asdfasdfsdaf', '', 'Asdfasdf', 'Asddfasdf', '', '', '', '', '9874563210', '', '', '', 'Single', '', 'Assdffsad', 'Asfasdf', 'Asddfasdf', '', 'Asddfasdf', 'Asdfasdf', 'Asdfasdf', 'Asdfsadf', '', '', '', '', '9845632102', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/1.jpg', 'customer_finger_prints/2.jpg', '2015-11-18', '', 'Asdfsadfsa', 1, 1),
(7, 'Adfasdf', 22, 'Male', '1990-10-10', 'Asdfasdfsdaf', '', 'Asdfasdf', 'Asddfasdf', '', '', '', '', '9874563210', '', '', '', 'Single', '', 'Assdffsad', 'Asfasdf', 'Asddfasdf', '', 'Asddfasdf', 'Asdfasdf', 'Asdfasdf', 'Asdfsadf', '', '', '', '', '9845632102', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/11.jpg', 'customer_finger_prints/avatar.jpg', '2015-11-18', '', 'Asdfsadfsa', 1, 1),
(8, 'Wqerwerwqer', 17, 'Male', '1990-10-10', 'Asdfasdfsdaf', '', 'Asdfasdf', 'Asddfasdf', '', '', '', '', '9874563210', '', '', '', 'Single', '', 'Assdffsad', 'Asfasdf', 'Asddfasdf', '', 'Asddfasdf', 'Asdfasdf', 'Asdfasdf', 'Asdfsadf', '', '', '', '', '9845632102', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/1.jpg', 'customer_finger_prints/DSC_0089.jpg', '2015-11-21', '', 'Asdfsadfsa', 1, 1),
(9, 'Rajesh Lam', 20, 'Male', '1990-10-10', 'Nepali', '489756', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9841257896', '', '', 'rajesh@gmail.com', 'Single', '', 'Student', 'Mahesh Lama', 'Ganesh Lama', '', 'Mahesh Lama', 'Father', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9874562356', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/1.jpg', 'customer_finger_prints/2.jpg', '2015-11-22', 'Hari Kumar Basnet', 'Sabin Kaji Shrestha', 1, 1),
(10, 'Rajesh Lam', 22, 'Male', '1990-10-10', 'Asdfasdfsdaf', '', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9874563210', '', '', '', 'Single', '', 'Assdffsad', 'Mahesh Lama', 'Ganesh Lama', '', 'Mahesh Lama', 'Asdfasdf', 'Asdfasdf', 'Jorpati - 4', '', '', '', '', '9874562356', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/1.jpg', 'customer_finger_prints/2.jpg', '2015-11-22', 'Hari Kumar Basnet', 'Sabin Kaji Shrestha', 1, 1),
(11, 'Adfasdf Shrestha', 19, 'Female', '1990-10-14', 'Nepali', '124875', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9874561235', '', '', '', 'Single', '', 'Student', 'Adfsdf', 'Adfsdaf', '', 'Ssdfsdf', 'Adfdsf', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '3214569871', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/11.jpg', 'customer_finger_prints/DSC_0089.jpg', '2015-11-29', '', 'Sabin Kaji Shrestha', 1, 1),
(12, 'Adfasdf Shrestha', 19, 'Male', '1990-10-14', 'Nepali', '124875', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9874561235', '', '', '', 'Single', '', 'Student', 'Adfsdf', 'Adfsdaf', '', 'Ssdfsdf', 'Adfdsf', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '3214569871', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/1.jpg', 'customer_photos/dummy-person.jpg', '2015-11-29', '', 'Sabin Kaji Shrestha', 1, 1),
(13, 'Adfasdf Shrestha', 19, 'Male', '1990-10-14', 'Nepali', '124875', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9874561235', '', '', '', 'Single', '', 'Student', 'Adfsdf', 'Adfsdaf', '', 'Ssdfsdf', 'Adfdsf', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '3214569871', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/1.jpg', 'customer_photos/dummy-person.jpg', '2015-11-29', '', 'Sabin Kaji Shrestha', 1, 1),
(14, 'Adfasdf Shrestha', 19, 'Male', '1990-10-14', 'Nepali', '124875', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9874561235', '', '', '', 'Single', '', 'Student', 'Adfsdf', 'Adfsdaf', '', 'Ssdfsdf', 'Adfdsf', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '3214569871', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/1.jpg', 'customer_photos/dummy-person.jpg', '2015-11-29', '', 'Sabin Kaji Shrestha', 1, 1),
(15, 'Adfasdf Shrestha', 19, 'Male', '1990-10-14', 'Nepali', '124875', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9874561235', '', '', '', 'Single', '', 'Student', 'Adfsdf', 'Adfsdaf', '', 'Ssdfsdf', 'Adfdsf', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '3214569871', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/1.jpg', 'customer_finger_prints/dummy-person.jpg', '2015-11-29', '', 'Sabin Kaji Shrestha', 1, 1),
(16, 'Adfasdf Shrestha', 19, 'Male', '1990-10-14', 'Nepali', '124875', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9874561235', '', '', '', 'Single', '', 'Student', 'Adfsdf', 'Adfsdaf', '', 'Ssdfsdf', 'Adfdsf', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '3214569871', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/1.jpg', 'customer_finger_prints/dummy-person.jpg', '2015-11-29', '', 'Sabin Kaji Shrestha', 1, 1),
(17, 'Adfasdf Shrestha', 19, 'Male', '1990-10-14', 'Nepali', '124875', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9874561235', '', '', '', 'Single', '', 'Student', 'Adfsdf', 'Adfsdaf', '', 'Ssdfsdf', 'Adfdsf', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '3214569871', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/4411.jpg', 'customer_finger_prints/dummy-person.jpg', '2015-11-29', '', 'Sabin Kaji Shrestha', 1, 1),
(18, 'Aman Shrestha', 19, 'Male', '1990-10-14', 'Nepali', '124875', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9874561235', '', '', '', 'Single', '', 'Student', 'Adfsdf', 'Adfsdaf', '', 'Ssdfsdf', 'Adfdsf', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '3214569871', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/9391.jpg', 'customer_finger_prints/276dummy-person.jpg', '2015-11-29', '', 'Sabin Kaji Shrestha', 1, 1),
(19, 'Adfasdf Shrestha', 19, 'Male', '1990-10-14', 'Nepali', '124875', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9874561235', '', '', '', 'Single', '', 'Student', 'Adfsdf', 'Adfsdaf', '', 'Ssdfsdf', 'Adfdsf', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '3214569871', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/47511.jpg', 'customer_finger_prints/116DSC_0089.jpg', '2015-12-03', 'Bam Kaji Shrestha', 'Sabin Kaji Shrestha', 1, 1),
(20, 'Aman Shrestha', 19, 'Male', '1990-10-14', 'Nepali', '124875', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9874561235', '', '', '', 'Single', '', 'Student', 'Adfsdf', 'Adfsdaf', '', 'Ssdfsdf', 'Adfdsf', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '3214569871', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/39311.jpg', 'customer_finger_prints/729DSC_0089.jpg', '2015-12-03', 'Bam Kaji Shrestha', 'Sabin Kaji Shrestha', 1, 1),
(21, 'Aman Shrestha', 19, 'Male', '1990-10-14', 'Nepali', '124875', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9874561235', '', '', '', 'Single', '', 'Student', 'Adfsdf', 'Adfsdaf', '', 'Ssdfsdf', 'Adfdsf', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '3214569871', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/7981.jpg', 'customer_finger_prints/11.jpg', '2015-12-03', 'Bam Kaji Shrestha', 'Sabin Kaji Shrestha', 1, 1),
(22, 'Aman Shrestha', 19, 'Male', '1990-10-14', 'Nepali', '124875', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '9874561235', '', '', '', 'Single', '', 'Student', 'Adfsdf', 'Adfsdaf', '', 'Ssdfsdf', 'Adfdsf', 'Kathmandu', 'Jorpati - 4', '', '', '', '', '3214569871', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'customer_photos/1661.jpg', 'customer_finger_prints/90711.jpg', '2015-12-03', 'Bam Kaji Shrestha', 'Sabin Kaji Shrestha', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_c_fixed_deposit`
--

CREATE TABLE IF NOT EXISTS `tbl_c_fixed_deposit` (
  `cfd_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `interest_rate` float NOT NULL,
  `maturity_date` date NOT NULL,
  `creation_date` date NOT NULL,
  `approved_by` varchar(500) NOT NULL,
  `entry_by` int(11) NOT NULL,
  `ac_status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`cfd_id`),
  KEY `customer_id` (`customer_id`),
  KEY `entry_by` (`entry_by`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `tbl_c_fixed_deposit`
--

INSERT INTO `tbl_c_fixed_deposit` (`cfd_id`, `customer_id`, `interest_rate`, `maturity_date`, `creation_date`, `approved_by`, `entry_by`, `ac_status`) VALUES
(1, 8, 10.5, '2018-12-04', '2015-12-01', 'Sabin Kaji Shrestha', 1, 1),
(2, 1, 10.5, '2018-12-02', '2015-12-02', 'sabin kaji shrestha', 1, 1),
(3, 16, 10.5, '2019-12-03', '2015-12-03', 'Sabin Kaji Shrestha', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_daily_savings`
--

CREATE TABLE IF NOT EXISTS `tbl_daily_savings` (
  `ds_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `interest_rate` float NOT NULL,
  `creation_date` date NOT NULL,
  `approved_by` varchar(500) NOT NULL,
  `entry_by` int(11) NOT NULL,
  `ac_status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ds_id`),
  KEY `customer_id` (`customer_id`),
  KEY `entry_by` (`entry_by`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `tbl_daily_savings`
--

INSERT INTO `tbl_daily_savings` (`ds_id`, `customer_id`, `interest_rate`, `creation_date`, `approved_by`, `entry_by`, `ac_status`) VALUES
(1, 2, 15, '2015-12-01', 'Sabin Kaji Shrestha', 1, 1),
(2, 1, 15, '2015-12-02', 'sabin kaji shrestha', 1, 1),
(3, 18, 18, '2015-12-02', 'Sabin Kaji Shrestha', 1, 1),
(4, 1, 10.5, '2015-12-03', 'Sabin Kaji Shrestha', 1, 1),
(5, 21, 11, '2015-12-03', 'Sabin Kaji Shrestha', 1, 1),
(6, 22, 10.5, '2015-12-03', 'Sabin Kaji Shrestha', 1, 1),
(7, 16, 10, '2015-12-05', 'Sabin Kaji Shrestha', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_employee`
--

CREATE TABLE IF NOT EXISTS `tbl_employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(100) NOT NULL,
  `employee_age` int(11) NOT NULL,
  `employee_gender` enum('Male','Female') NOT NULL,
  `employee_dob` date NOT NULL,
  `employee_marital_status` enum('Married','Single') NOT NULL,
  `employee_perm_district` varchar(100) NOT NULL,
  `employee_perm_vdc_municipality` varchar(200) NOT NULL,
  `employee_perm_extrainfo` varchar(200) DEFAULT NULL,
  `employee_temp_district` varchar(100) NOT NULL,
  `employee_temp_vdc_municipality` varchar(200) NOT NULL,
  `employee_temp_extrainfo` varchar(200) DEFAULT NULL,
  `employee_cell_number_first` varchar(50) DEFAULT NULL,
  `employee_cell_number_second` varchar(50) DEFAULT NULL,
  `employee_landline` varchar(50) DEFAULT NULL,
  `employee_joined_date` date NOT NULL,
  `employee_retired_date` date DEFAULT NULL,
  `employee_email` varchar(200) DEFAULT NULL,
  `employee_fathers_name` varchar(100) NOT NULL,
  `employee_designation` enum('CEO','Manager','Collector','Data Entry operator') NOT NULL,
  `employee_access_level` enum('admin','user') DEFAULT NULL,
  `employee_photo` varchar(2000) NOT NULL,
  `entry_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `entry_by` (`entry_by`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `tbl_employee`
--

INSERT INTO `tbl_employee` (`employee_id`, `employee_name`, `employee_age`, `employee_gender`, `employee_dob`, `employee_marital_status`, `employee_perm_district`, `employee_perm_vdc_municipality`, `employee_perm_extrainfo`, `employee_temp_district`, `employee_temp_vdc_municipality`, `employee_temp_extrainfo`, `employee_cell_number_first`, `employee_cell_number_second`, `employee_landline`, `employee_joined_date`, `employee_retired_date`, `employee_email`, `employee_fathers_name`, `employee_designation`, `employee_access_level`, `employee_photo`, `entry_by`) VALUES
(1, 'John Doe', 30, 'Male', '2015-10-01', 'Single', 'somewhere', '', '', 'somewhere', '', NULL, '', '', '', '2015-10-14', '2015-10-15', 'example@example.com', 'John D', 'CEO', 'admin', 'employee/dummy-person.jpg', NULL),
(2, 'jane doe', 25, 'Female', '2014-12-01', 'Married', 'somewhere', '', '', 'somewhere', '', NULL, '', '', '', '2015-09-07', NULL, 'someone@example.com', 'john doe', 'Data Entry operator', 'user', 'employee/dummy-person.jpg', NULL),
(3, 'Ram Bahadur Thapa', 22, 'Male', '1988-10-11', 'Single', 'Kathmandu', 'Sano Gaun 04', NULL, 'Kathmandu', 'Sano Gaun 04', NULL, '9845125632', NULL, NULL, '2015-10-04', NULL, NULL, 'Shree Ram Thapa', 'Collector', NULL, 'customer_photos/1661.jpg', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_fixed_deposit`
--

CREATE TABLE IF NOT EXISTS `tbl_fixed_deposit` (
  `fds_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `interest_rate` float NOT NULL,
  `fd_amount` double NOT NULL,
  `maturity_date` date NOT NULL,
  `creation_date` date NOT NULL,
  `approved_by` varchar(500) NOT NULL,
  `entry_by` int(11) NOT NULL,
  `ac_status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`fds_id`),
  KEY `customer_id` (`customer_id`),
  KEY `entry_by` (`entry_by`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `tbl_fixed_deposit`
--

INSERT INTO `tbl_fixed_deposit` (`fds_id`, `customer_id`, `interest_rate`, `fd_amount`, `maturity_date`, `creation_date`, `approved_by`, `entry_by`, `ac_status`) VALUES
(1, 2, 10, 500000, '2021-12-04', '2015-12-01', 'Sabin Kaji Shrestha', 1, 1),
(2, 6, 10.5, 40000, '2020-12-02', '2015-12-02', 'sabin kaji shrestha', 1, 1),
(3, 11, 10.5, 450000, '2018-12-02', '2015-12-02', 'sabin kaji shrestha', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_monthly_savings`
--

CREATE TABLE IF NOT EXISTS `tbl_monthly_savings` (
  `ms_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `interest_rate` float NOT NULL,
  `creation_date` date NOT NULL,
  `approved_by` varchar(500) NOT NULL,
  `entry_by` int(11) NOT NULL,
  `ac_status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ms_id`),
  KEY `customer_id` (`customer_id`),
  KEY `entry_by` (`entry_by`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `tbl_monthly_savings`
--

INSERT INTO `tbl_monthly_savings` (`ms_id`, `customer_id`, `interest_rate`, `creation_date`, `approved_by`, `entry_by`, `ac_status`) VALUES
(1, 18, 50, '2015-12-01', 'Sabin Kaji Shrestha', 1, 1),
(2, 4, 11, '2015-12-01', 'sabin kaji shrestha', 1, 1),
(3, 17, 15, '2015-12-03', 'Sabin Kaji Shrestha', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_saving_transactions`
--

CREATE TABLE IF NOT EXISTS `tbl_saving_transactions` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `customer_id` int(11) NOT NULL,
  `account_type` enum('ds','ms','fds','cfd') NOT NULL,
  `account_number` int(11) NOT NULL,
  `deposit_amount` double NOT NULL,
  `withdrawal_amount` double NOT NULL,
  `reference` varchar(500) NOT NULL,
  `principal_amount` double NOT NULL,
  `interest_for_next` double NOT NULL,
  `total_interest` double NOT NULL,
  `total_amount` double NOT NULL,
  `collector_id` int(11) NOT NULL DEFAULT '0',
  `entry_by` int(11) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `entry_by` (`entry_by`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tbl_saving_transactions`
--

INSERT INTO `tbl_saving_transactions` (`transaction_id`, `date`, `customer_id`, `account_type`, `account_number`, `deposit_amount`, `withdrawal_amount`, `reference`, `principal_amount`, `interest_for_next`, `total_interest`, `total_amount`, `collector_id`, `entry_by`) VALUES
(1, '2016-01-14', 1, 'ds', 2, 100, 0, '', 100, 0.0410958904109589, 0, 100, 1, 1),
(2, '2016-01-14', 1, 'ds', 2, 300, 0, '', 400, 0.1643835616438356, 0, 400, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE IF NOT EXISTS `tbl_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(1000) NOT NULL,
  `role` enum('Administrator','User') NOT NULL,
  `employee_id` int(11) NOT NULL,
  `user_enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `Username` (`username`),
  KEY `employee_id` (`employee_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`user_id`, `username`, `password`, `role`, `employee_id`, `user_enabled`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Administrator', 1, 1),
(2, 'dummy', '275876e34cf609db118f3d84b799a790', 'User', 2, 1),
(3, 'nothing', '827ccb0eea8a706c4c34a16891f84e7b', 'User', 2, 0),
(4, 'hariram', '62ee25ba9eba3ed2b071b06a7a4fc1e9', 'User', 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user_log`
--

CREATE TABLE IF NOT EXISTS `tbl_user_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `last_login` datetime NOT NULL,
  `last_logout` datetime DEFAULT NULL,
  PRIMARY KEY (`log_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=323 ;

--
-- Dumping data for table `tbl_user_log`
--

INSERT INTO `tbl_user_log` (`log_id`, `user_id`, `last_login`, `last_logout`) VALUES
(1, 1, '2015-11-18 02:36:21', '2015-11-18 02:37:13'),
(2, 1, '2015-11-18 03:03:09', '2015-11-18 03:05:30'),
(3, 1, '2015-11-18 03:05:55', '2015-11-18 03:09:09'),
(4, 1, '2015-11-18 03:09:33', '2015-11-18 03:11:14'),
(5, 1, '2015-11-18 03:12:34', NULL),
(6, 1, '2015-11-18 03:17:32', '2015-11-18 03:19:19'),
(7, 1, '2015-11-18 03:31:46', '2015-11-18 03:32:43'),
(8, 1, '2015-11-18 03:33:46', '2015-11-18 03:40:09'),
(9, 1, '2015-11-18 03:43:54', '2015-11-18 03:53:32'),
(10, 1, '2015-11-18 10:22:11', '2015-11-18 10:22:44'),
(11, 1, '2015-11-18 10:25:13', '2015-11-18 10:26:53'),
(12, 1, '2015-11-18 11:23:29', '2015-11-18 11:23:41'),
(13, 1, '2015-11-18 11:24:33', '2015-11-18 11:25:20'),
(14, 1, '2015-11-18 11:26:21', '2015-11-18 11:32:27'),
(15, 1, '2015-11-18 11:34:09', '2015-11-18 11:35:01'),
(16, 1, '2015-11-18 12:01:58', '2015-11-18 12:02:16'),
(17, 1, '2015-11-18 12:06:12', NULL),
(18, 1, '2015-11-18 12:10:37', '2015-11-18 12:15:08'),
(19, 1, '2015-11-18 12:20:30', '2015-11-18 12:21:05'),
(20, 1, '2015-11-18 12:23:43', '2015-11-18 12:26:18'),
(21, 1, '2015-11-18 12:41:01', '2015-11-18 12:41:32'),
(22, 1, '2015-11-18 12:42:26', '2015-11-18 12:43:29'),
(23, 1, '2015-11-18 13:15:34', '2015-11-18 13:15:47'),
(24, 1, '2015-11-21 07:03:01', '2015-11-21 07:03:57'),
(25, 1, '2015-11-21 07:04:28', '2015-11-21 07:04:51'),
(26, 1, '2015-11-21 07:06:26', '2015-11-21 07:07:18'),
(27, 1, '2015-11-21 07:08:13', '2015-11-21 07:08:39'),
(28, 1, '2015-11-21 07:21:59', '2015-11-21 07:22:13'),
(29, 1, '2015-11-21 07:52:17', '2015-11-21 07:52:38'),
(30, 1, '2015-11-21 08:05:21', '2015-11-21 08:07:26'),
(31, 1, '2015-11-21 11:53:16', NULL),
(32, 1, '2015-11-21 11:59:00', '2015-11-21 12:17:05'),
(33, 1, '2015-11-21 12:38:25', NULL),
(34, 1, '2015-11-22 12:50:56', '2015-11-22 12:55:57'),
(35, 1, '2015-11-22 12:56:28', '2015-11-22 12:58:11'),
(36, 1, '2015-11-22 13:01:12', '2015-11-22 13:28:18'),
(37, 1, '2015-11-25 01:08:56', '2015-11-25 01:17:32'),
(38, 1, '2015-11-25 01:24:57', '2015-11-25 01:26:11'),
(39, 1, '2015-11-25 01:26:28', '2015-11-25 01:26:34'),
(40, 1, '2015-11-25 01:27:42', '2015-11-25 01:35:44'),
(41, 1, '2015-11-25 01:39:55', '2015-11-25 01:42:29'),
(42, 1, '2015-11-25 01:43:10', '2015-11-25 01:43:28'),
(43, 1, '2015-11-25 01:44:17', '2015-11-25 01:44:31'),
(44, 1, '2015-11-25 01:46:01', '2015-11-25 01:46:29'),
(45, 1, '2015-11-25 01:48:08', '2015-11-25 01:57:42'),
(46, 1, '2015-11-25 03:00:25', '2015-11-25 03:04:52'),
(47, 1, '2015-11-25 03:08:18', '2015-11-25 03:09:46'),
(48, 1, '2015-11-25 03:22:54', '2015-11-25 03:35:49'),
(49, 1, '2015-11-25 03:43:14', '2015-11-25 03:43:22'),
(50, 1, '2015-11-25 03:49:32', '2015-11-25 03:49:36'),
(51, 1, '2015-11-25 03:51:05', '2015-11-25 04:23:39'),
(52, 1, '2015-11-25 04:32:37', '2015-11-25 04:36:31'),
(53, 1, '2015-11-25 06:21:31', '2015-11-25 06:53:50'),
(54, 1, '2015-11-25 06:58:32', '2015-11-25 07:00:42'),
(55, 1, '2015-11-25 07:03:03', '2015-11-25 07:05:18'),
(56, 1, '2015-11-25 07:14:26', '2015-11-25 07:19:17'),
(57, 1, '2015-11-25 07:23:02', '2015-11-25 07:27:28'),
(58, 1, '2015-11-25 07:27:53', '2015-11-25 07:40:02'),
(59, 1, '2015-11-25 09:20:42', NULL),
(60, 1, '2015-11-25 11:33:48', '2015-11-25 11:57:31'),
(61, 1, '2015-11-25 12:03:59', NULL),
(62, 1, '2015-11-25 12:15:12', '2015-11-25 12:15:21'),
(63, 1, '2015-11-25 13:38:48', '2015-11-25 13:40:42'),
(64, 1, '2015-11-25 13:40:56', '2015-11-25 13:43:16'),
(65, 1, '2015-11-25 13:43:33', '2015-11-25 13:44:00'),
(66, 1, '2015-11-25 13:45:39', '2015-11-25 13:46:35'),
(67, 1, '2015-11-26 06:38:51', '2015-11-26 06:39:53'),
(68, 1, '2015-11-26 06:40:00', NULL),
(69, 1, '2015-11-26 06:59:01', '2015-11-26 06:59:57'),
(70, 1, '2015-11-26 07:01:16', '2015-11-26 07:03:59'),
(71, 1, '2015-11-26 07:12:01', '2015-11-26 07:12:34'),
(72, 1, '2015-11-26 07:13:06', '2015-11-26 07:27:05'),
(73, 1, '2015-11-26 07:38:35', NULL),
(74, 1, '2015-11-26 08:07:07', '2015-11-26 08:08:46'),
(75, 1, '2015-11-26 08:17:32', '2015-11-26 08:19:04'),
(76, 1, '2015-11-26 08:20:47', '2015-11-26 08:21:23'),
(77, 1, '2015-11-26 08:26:51', '2015-11-26 08:27:38'),
(78, 1, '2015-11-26 08:30:20', '2015-11-26 08:30:52'),
(79, 1, '2015-11-26 08:33:35', '2015-11-26 08:36:18'),
(80, 1, '2015-11-26 08:40:29', '2015-11-26 08:41:43'),
(81, 1, '2015-11-26 08:42:08', '2015-11-26 08:44:29'),
(82, 1, '2015-11-26 08:45:25', '2015-11-26 08:46:27'),
(83, 1, '2015-11-26 09:00:44', '2015-11-26 09:02:33'),
(84, 1, '2015-11-26 12:01:02', '2015-11-26 12:02:00'),
(85, 1, '2015-11-26 12:02:14', '2015-11-26 12:03:31'),
(86, 1, '2015-11-28 00:27:39', '2015-11-28 00:31:15'),
(87, 1, '2015-11-28 00:32:05', '2015-11-28 00:37:12'),
(88, 1, '2015-11-28 00:59:00', '2015-11-28 01:02:22'),
(89, 1, '2015-11-28 01:04:53', '2015-11-28 01:07:24'),
(90, 1, '2015-11-28 05:55:15', '2015-11-28 05:55:54'),
(91, 1, '2015-11-28 05:56:51', NULL),
(92, 1, '2015-11-28 06:01:49', NULL),
(93, 1, '2015-11-28 06:47:45', '2015-11-28 06:53:27'),
(94, 1, '2015-11-28 06:53:58', '2015-11-28 06:58:09'),
(95, 1, '2015-11-28 07:50:22', '2015-11-28 07:58:11'),
(96, 1, '2015-11-28 08:04:55', NULL),
(97, 1, '2015-11-28 08:06:41', '2015-11-28 08:07:16'),
(98, 1, '2015-11-28 08:08:19', '2015-11-28 08:17:02'),
(99, 1, '2015-11-28 08:17:20', NULL),
(100, 1, '2015-11-28 08:19:09', '2015-11-28 08:19:32'),
(101, 1, '2015-11-28 09:01:31', '2015-11-28 09:02:16'),
(102, 1, '2015-11-28 09:05:18', '2015-11-28 09:05:55'),
(103, 1, '2015-11-28 09:06:08', '2015-11-28 09:08:23'),
(104, 1, '2015-11-28 09:08:38', '2015-11-28 09:11:35'),
(105, 1, '2015-11-28 09:12:58', '2015-11-28 09:13:15'),
(106, 1, '2015-11-28 09:16:42', NULL),
(107, 1, '2015-11-28 09:25:49', '2015-11-28 09:30:37'),
(108, 1, '2015-11-29 10:28:10', '2015-11-29 10:47:20'),
(109, 1, '2015-11-29 10:49:03', '2015-11-29 10:50:57'),
(110, 1, '2015-11-29 10:51:27', NULL),
(111, 1, '2015-11-29 10:54:44', '2015-11-29 10:55:58'),
(112, 1, '2015-11-29 14:25:47', '2015-11-29 14:26:49'),
(113, 1, '2015-11-29 14:27:23', '2015-11-29 14:29:00'),
(114, 1, '2015-11-29 14:29:14', '2015-11-29 14:30:47'),
(115, 1, '2015-11-29 14:30:59', '2015-11-29 14:38:01'),
(116, 1, '2015-11-29 14:56:39', '2015-11-29 14:59:20'),
(117, 1, '2015-11-29 15:18:30', '2015-11-29 15:22:28'),
(118, 1, '2015-11-29 15:23:02', '2015-11-29 15:23:42'),
(119, 1, '2015-11-29 16:00:41', NULL),
(120, 1, '2015-11-29 16:01:26', '2015-11-29 16:04:14'),
(121, 1, '2015-11-29 16:30:45', NULL),
(122, 1, '2015-11-29 16:34:23', '2015-11-29 16:42:17'),
(123, 1, '2015-11-29 16:42:42', NULL),
(124, 1, '2015-11-29 16:47:42', '2015-11-29 16:51:42'),
(125, 1, '2015-11-29 16:53:02', '2015-11-29 17:03:10'),
(126, 1, '2015-11-29 17:37:26', '2015-11-29 17:40:11'),
(127, 1, '2015-11-29 17:40:26', '2015-11-29 17:42:41'),
(128, 1, '2015-11-29 18:55:45', '2015-11-29 19:08:50'),
(129, 1, '2015-11-29 19:11:35', '2015-11-29 19:14:39'),
(130, 1, '2015-11-30 11:13:36', '2015-11-30 11:14:36'),
(131, 1, '2015-11-30 11:14:53', '2015-11-30 11:15:16'),
(132, 1, '2015-11-30 11:15:48', '2015-11-30 11:19:28'),
(133, 1, '2015-11-30 11:20:04', '2015-11-30 11:22:12'),
(134, 1, '2015-11-30 11:23:24', '2015-11-30 11:25:17'),
(135, 1, '2015-12-01 02:22:08', '2015-12-01 02:22:18'),
(136, 1, '2015-12-01 02:23:19', '2015-12-01 02:24:31'),
(137, 1, '2015-12-01 03:58:12', '2015-12-01 03:58:19'),
(138, 1, '2015-12-01 03:59:39', '2015-12-01 04:00:04'),
(139, 1, '2015-12-01 04:14:24', '2015-12-01 04:14:46'),
(140, 1, '2015-12-01 05:52:07', '2015-12-01 05:52:24'),
(141, 1, '2015-12-01 05:56:19', '2015-12-01 05:56:48'),
(142, 1, '2015-12-01 05:58:12', '2015-12-01 05:58:36'),
(143, 1, '2015-12-01 05:59:22', '2015-12-01 05:59:54'),
(144, 1, '2015-12-01 06:00:05', '2015-12-01 06:00:31'),
(145, 1, '2015-12-01 06:49:36', '2015-12-01 06:50:04'),
(146, 1, '2015-12-01 06:50:57', '2015-12-01 06:53:46'),
(147, 1, '2015-12-01 07:22:35', '2015-12-01 07:22:57'),
(148, 1, '2015-12-01 07:24:30', '2015-12-01 07:25:08'),
(149, 1, '2015-12-01 07:28:11', '2015-12-01 07:28:54'),
(150, 1, '2015-12-01 07:31:18', '2015-12-01 07:33:32'),
(151, 1, '2015-12-01 08:33:51', '2015-12-01 08:34:05'),
(152, 1, '2015-12-01 08:36:43', '2015-12-01 08:37:03'),
(153, 1, '2015-12-01 08:38:46', '2015-12-01 08:39:14'),
(154, 1, '2015-12-01 08:42:18', '2015-12-01 08:42:40'),
(155, 1, '2015-12-01 09:08:13', '2015-12-01 09:14:26'),
(156, 1, '2015-12-01 09:20:22', '2015-12-01 09:20:31'),
(157, 1, '2015-12-01 09:21:35', '2015-12-01 09:21:50'),
(158, 1, '2015-12-01 09:23:24', '2015-12-01 09:24:21'),
(159, 1, '2015-12-01 10:22:36', '2015-12-01 10:23:38'),
(160, 1, '2015-12-01 10:25:45', '2015-12-01 10:26:04'),
(161, 1, '2015-12-01 10:27:24', NULL),
(162, 1, '2015-12-01 10:29:07', '2015-12-01 10:30:48'),
(163, 1, '2015-12-01 10:31:19', NULL),
(164, 1, '2015-12-01 11:00:42', NULL),
(165, 1, '2015-12-02 09:29:06', '2015-12-02 09:29:31'),
(166, 1, '2015-12-02 12:36:46', '2015-12-02 12:38:49'),
(167, 1, '2015-12-02 12:44:08', '2015-12-02 12:48:20'),
(168, 1, '2015-12-02 12:56:13', '2015-12-02 12:58:05'),
(169, 1, '2015-12-02 12:58:45', '2015-12-02 13:04:43'),
(170, 1, '2015-12-02 15:28:11', '2015-12-02 15:28:42'),
(171, 1, '2015-12-02 15:30:21', '2015-12-02 15:30:46'),
(172, 1, '2015-12-02 16:08:51', '2015-12-02 16:09:25'),
(173, 1, '2015-12-02 16:41:24', '2015-12-02 16:43:24'),
(174, 1, '2015-12-02 16:43:44', '2015-12-02 16:44:51'),
(175, 1, '2015-12-02 16:45:48', '2015-12-02 16:48:30'),
(176, 1, '2015-12-03 13:49:51', '2015-12-03 13:52:21'),
(177, 1, '2015-12-03 14:06:44', '2015-12-03 14:07:54'),
(178, 1, '2015-12-03 14:10:51', '2015-12-03 14:17:36'),
(179, 1, '2015-12-03 14:55:33', '2015-12-03 14:58:44'),
(180, 1, '2015-12-03 15:00:34', '2015-12-03 15:09:50'),
(181, 1, '2015-12-03 17:38:58', '2015-12-03 17:39:21'),
(182, 1, '2015-12-03 17:40:15', '2015-12-03 17:41:12'),
(183, 1, '2015-12-03 17:41:29', NULL),
(184, 1, '2015-12-03 17:43:38', '2015-12-03 17:44:21'),
(185, 1, '2015-12-04 09:00:09', '2015-12-04 09:01:06'),
(186, 1, '2015-12-04 09:44:59', '2015-12-04 09:46:47'),
(187, 1, '2015-12-04 09:47:07', '2015-12-04 09:47:34'),
(188, 1, '2015-12-04 09:50:34', '2015-12-04 09:50:56'),
(189, 1, '2015-12-04 11:50:46', '2015-12-04 11:51:23'),
(190, 1, '2015-12-04 11:52:08', '2015-12-04 11:53:37'),
(191, 1, '2015-12-04 11:54:05', '2015-12-04 11:56:27'),
(192, 1, '2015-12-04 11:57:23', '2015-12-04 11:58:43'),
(193, 1, '2015-12-04 11:59:42', '2015-12-04 12:01:07'),
(194, 1, '2015-12-04 12:01:22', '2015-12-04 12:02:51'),
(195, 1, '2015-12-04 12:03:05', '2015-12-04 12:03:45'),
(196, 1, '2015-12-04 12:03:51', '2015-12-04 12:06:34'),
(197, 1, '2015-12-04 12:08:02', '2015-12-04 12:10:22'),
(198, 1, '2015-12-04 12:10:40', '2015-12-04 12:12:02'),
(199, 1, '2015-12-04 12:13:10', NULL),
(200, 1, '2015-12-04 12:16:08', '2015-12-04 12:16:42'),
(201, 1, '2015-12-04 13:20:06', '2015-12-04 13:21:29'),
(202, 1, '2015-12-04 13:21:42', '2015-12-04 13:22:07'),
(203, 1, '2015-12-04 13:23:40', NULL),
(204, 1, '2015-12-04 13:25:29', '2015-12-04 13:25:52'),
(205, 1, '2015-12-04 13:27:14', NULL),
(206, 1, '2015-12-04 13:28:34', '2015-12-04 13:29:16'),
(207, 1, '2015-12-04 13:32:16', '2015-12-04 13:35:28'),
(208, 1, '2015-12-04 13:36:08', '2015-12-04 13:37:57'),
(209, 1, '2015-12-04 13:47:09', '2015-12-04 13:48:06'),
(210, 1, '2015-12-04 13:48:21', '2015-12-04 13:49:23'),
(211, 1, '2015-12-04 13:55:41', '2015-12-04 13:56:44'),
(212, 1, '2015-12-04 13:56:59', '2015-12-04 13:57:13'),
(213, 1, '2015-12-04 13:58:58', NULL),
(214, 1, '2015-12-04 14:05:27', '2015-12-04 14:05:56'),
(215, 1, '2015-12-04 15:35:10', '2015-12-04 15:36:31'),
(216, 1, '2015-12-04 15:36:49', '2015-12-04 15:37:22'),
(217, 1, '2015-12-04 15:38:29', '2015-12-04 15:38:53'),
(218, 1, '2015-12-04 15:44:23', NULL),
(219, 1, '2015-12-04 15:46:10', NULL),
(220, 1, '2015-12-04 15:48:13', '2015-12-04 15:59:15'),
(221, 1, '2015-12-04 16:00:17', '2015-12-04 16:01:52'),
(222, 1, '2015-12-04 16:02:47', NULL),
(223, 1, '2015-12-04 16:04:30', NULL),
(224, 1, '2015-12-04 16:05:46', NULL),
(225, 1, '2015-12-04 16:09:05', NULL),
(226, 1, '2015-12-04 16:12:59', '2015-12-04 16:13:26'),
(227, 1, '2015-12-04 16:13:42', '2015-12-04 16:16:18'),
(228, 1, '2015-12-04 16:16:43', '2015-12-04 16:17:25'),
(229, 1, '2015-12-04 16:19:49', '2015-12-04 16:20:12'),
(230, 1, '2015-12-04 16:24:56', '2015-12-04 16:25:31'),
(231, 1, '2015-12-05 09:12:46', '2015-12-05 09:13:17'),
(232, 1, '2015-12-05 10:18:01', '2015-12-05 10:19:37'),
(233, 1, '2015-12-05 13:41:09', '2015-12-05 13:50:41'),
(234, 1, '2015-12-05 13:50:52', '2015-12-05 14:12:55'),
(235, 1, '2015-12-05 14:13:11', '2015-12-05 15:06:29'),
(236, 1, '2015-12-05 15:06:46', '2015-12-05 15:06:58'),
(237, 1, '2015-12-05 15:07:05', '2015-12-05 15:10:21'),
(238, 1, '2015-12-07 01:02:27', '2015-12-07 01:03:32'),
(239, 1, '2015-12-07 01:07:46', '2015-12-07 01:08:07'),
(240, 1, '2015-12-07 01:56:54', '2015-12-07 01:57:13'),
(241, 1, '2015-12-07 01:58:25', '2015-12-07 01:58:48'),
(242, 1, '2015-12-07 01:58:55', '2015-12-07 02:03:16'),
(243, 1, '2015-12-07 02:05:24', '2015-12-07 02:06:07'),
(244, 1, '2015-12-07 02:13:57', '2015-12-07 02:26:58'),
(245, 1, '2015-12-07 02:32:21', '2015-12-07 03:05:59'),
(246, 1, '2015-12-07 03:07:25', '2015-12-07 03:11:59'),
(247, 1, '2015-12-07 03:14:53', '2015-12-07 03:16:02'),
(248, 1, '2015-12-07 03:16:09', '2015-12-07 03:16:16'),
(249, 1, '2015-12-07 03:17:47', '2015-12-07 03:19:02'),
(250, 1, '2015-12-07 03:19:13', '2015-12-07 03:19:16'),
(251, 1, '2015-12-07 03:21:46', '2015-12-07 03:30:11'),
(252, 1, '2015-12-07 03:33:55', '2015-12-07 03:37:35'),
(253, 1, '2015-12-07 03:38:02', '2015-12-07 03:38:21'),
(254, 1, '2015-12-07 07:11:29', '2015-12-07 07:11:43'),
(255, 1, '2015-12-07 08:57:25', '2015-12-07 09:05:55'),
(256, 1, '2015-12-07 09:30:03', '2015-12-07 09:32:20'),
(257, 1, '2015-12-07 11:23:54', NULL),
(258, 1, '2015-12-07 11:26:23', NULL),
(259, 1, '2015-12-07 11:27:49', '2015-12-07 11:28:36'),
(260, 1, '2015-12-07 11:29:12', '2015-12-07 11:29:23'),
(261, 1, '2015-12-07 11:30:00', '2015-12-07 11:30:12'),
(262, 1, '2015-12-07 11:30:49', '2015-12-07 11:31:12'),
(263, 1, '2015-12-07 11:35:17', '2015-12-07 11:35:32'),
(264, 1, '2015-12-07 11:36:25', '2015-12-07 11:36:49'),
(265, 1, '2015-12-07 11:37:28', '2015-12-07 11:38:32'),
(266, 1, '2015-12-07 11:38:46', '2015-12-07 11:40:03'),
(267, 1, '2015-12-07 11:40:19', '2015-12-07 11:40:42'),
(268, 1, '2015-12-07 11:41:28', '2015-12-07 11:42:42'),
(269, 1, '2015-12-07 11:43:05', '2015-12-07 11:43:59'),
(270, 1, '2015-12-07 11:45:58', '2015-12-07 11:47:42'),
(271, 1, '2015-12-07 11:48:18', NULL),
(272, 1, '2015-12-07 11:50:18', NULL),
(273, 1, '2015-12-07 11:51:47', '2015-12-07 11:52:13'),
(274, 1, '2015-12-07 11:56:38', '2015-12-07 11:56:56'),
(275, 1, '2015-12-07 11:57:37', '2015-12-07 11:59:45'),
(276, 1, '2015-12-07 15:48:02', '2015-12-07 15:49:08'),
(277, 1, '2015-12-09 12:08:44', '2015-12-09 12:09:43'),
(278, 1, '2015-12-09 12:15:07', '2015-12-09 12:20:00'),
(279, 1, '2015-12-09 12:24:02', '2015-12-09 12:24:30'),
(280, 1, '2015-12-09 12:25:45', '2015-12-09 12:27:31'),
(281, 1, '2015-12-09 12:31:31', '2015-12-09 12:34:38'),
(282, 1, '2015-12-09 12:35:05', '2015-12-09 12:36:32'),
(283, 1, '2015-12-09 12:36:56', '2015-12-09 12:38:12'),
(284, 1, '2015-12-09 12:39:02', '2015-12-09 12:40:34'),
(285, 1, '2015-12-09 12:40:52', NULL),
(286, 1, '2015-12-10 12:42:38', '2015-12-09 12:44:29'),
(287, 1, '2015-12-09 12:46:35', NULL),
(288, 1, '2015-12-10 12:47:34', '2015-12-10 12:48:11'),
(289, 1, '2015-12-13 12:48:44', '2015-12-13 12:52:05'),
(290, 1, '2015-12-16 12:52:57', NULL),
(291, 1, '2015-12-16 12:54:28', '2015-12-09 12:56:04'),
(292, 1, '2015-12-09 12:57:21', '2015-12-09 12:57:46'),
(293, 1, '2015-12-10 12:58:08', '2015-12-10 12:59:06'),
(294, 1, '2015-12-11 12:59:28', '2015-12-11 13:00:32'),
(295, 1, '2015-12-09 13:03:56', NULL),
(296, 1, '2015-12-10 13:04:33', '2015-12-10 13:04:53'),
(297, 1, '2015-12-11 13:05:15', '2015-12-11 13:10:16'),
(298, 1, '2015-12-13 13:10:43', '2015-12-13 13:13:35'),
(299, 1, '2015-12-09 13:16:44', '2015-12-09 13:17:03'),
(300, 1, '2015-12-10 13:17:26', '2015-12-10 13:18:05'),
(301, 1, '2015-12-13 13:21:04', '2015-12-13 13:22:14'),
(302, 1, '2015-12-09 13:26:00', '2015-12-09 13:29:54'),
(303, 1, '2015-12-09 13:29:58', '2015-12-09 13:33:03'),
(304, 1, '2015-12-09 13:34:57', '2015-12-09 13:36:22'),
(305, 1, '2015-12-09 13:37:34', '2015-12-09 13:37:45'),
(306, 1, '2015-12-09 13:38:44', '2015-12-09 13:39:49'),
(307, 1, '2015-12-09 13:41:01', '2015-12-09 13:42:59'),
(308, 1, '2015-12-09 13:54:54', '2015-12-09 13:56:32'),
(309, 1, '2016-01-13 23:11:56', '2016-01-13 23:13:06'),
(310, 1, '2016-01-14 02:38:38', '2016-01-14 02:38:53'),
(311, 1, '2016-01-14 02:41:15', '2016-01-14 02:41:26'),
(312, 1, '2016-01-14 05:48:36', '2016-01-14 05:49:35'),
(313, 1, '2016-01-14 05:49:55', '2016-01-14 05:50:35'),
(314, 1, '2016-01-14 05:50:55', '2016-01-14 05:52:29'),
(315, 1, '2016-01-14 05:54:34', '2016-01-14 05:58:19'),
(316, 1, '2016-01-14 06:06:40', NULL),
(317, 1, '2016-01-14 06:07:47', NULL),
(318, 1, '2016-01-14 06:10:10', '2016-01-14 06:10:30'),
(319, 1, '2016-01-14 06:21:30', '2016-01-14 06:23:16'),
(320, 1, '2016-01-14 06:24:30', '2016-01-14 06:25:36'),
(321, 1, '2016-01-14 06:28:32', '2016-01-14 06:28:54'),
(322, 1, '2016-01-14 06:37:46', NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_collector`
--
ALTER TABLE `tbl_collector`
  ADD CONSTRAINT `tbl_collector_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `tbl_employee` (`employee_id`);

--
-- Constraints for table `tbl_c_fixed_deposit`
--
ALTER TABLE `tbl_c_fixed_deposit`
  ADD CONSTRAINT `tbl_c_fixed_deposit_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_c_fixed_deposit_ibfk_2` FOREIGN KEY (`entry_by`) REFERENCES `tbl_user` (`user_id`);

--
-- Constraints for table `tbl_daily_savings`
--
ALTER TABLE `tbl_daily_savings`
  ADD CONSTRAINT `tbl_daily_savings_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_daily_savings_ibfk_2` FOREIGN KEY (`entry_by`) REFERENCES `tbl_user` (`user_id`);

--
-- Constraints for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
  ADD CONSTRAINT `tbl_employee_ibfk_1` FOREIGN KEY (`entry_by`) REFERENCES `tbl_user` (`user_id`);

--
-- Constraints for table `tbl_fixed_deposit`
--
ALTER TABLE `tbl_fixed_deposit`
  ADD CONSTRAINT `tbl_fixed_deposit_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_fixed_deposit_ibfk_2` FOREIGN KEY (`entry_by`) REFERENCES `tbl_user` (`user_id`);

--
-- Constraints for table `tbl_monthly_savings`
--
ALTER TABLE `tbl_monthly_savings`
  ADD CONSTRAINT `tbl_monthly_savings_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_monthly_savings_ibfk_2` FOREIGN KEY (`entry_by`) REFERENCES `tbl_user` (`user_id`);

--
-- Constraints for table `tbl_saving_transactions`
--
ALTER TABLE `tbl_saving_transactions`
  ADD CONSTRAINT `tbl_saving_transactions_ibfk_1` FOREIGN KEY (`entry_by`) REFERENCES `tbl_user` (`user_id`),
  ADD CONSTRAINT `tbl_saving_transactions_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer` (`customer_id`);

--
-- Constraints for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD CONSTRAINT `FOREIGN_KEY` FOREIGN KEY (`employee_id`) REFERENCES `tbl_employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_user_log`
--
ALTER TABLE `tbl_user_log`
  ADD CONSTRAINT `tbl_user_log_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

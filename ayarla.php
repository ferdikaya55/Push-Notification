<?php


	$serverName = " ";
	$userName = " ";
	$sifre = " ";
	$dbName = " ";

$baglan = mysqli_connect($serverName,$userName,$sifre,$dbName);
mysqli_set_charset($baglan,"UTF-8");
mysqli_query($baglan,"SET NAMES UTF8");

?>
<?php
require "init.php";

extract($_POST);
	
$user1=$_POST["user1"];
$pass1=$_POST["pass1"];


$sql= "select * from user_info where name =$user1 and user_pass = $pass1";

$res = mysqli_query($con,$sql);

$check = mysqli_fetch_array($res);

if(isset($check))
{
	echo "Success";
}
else
{
	echo "Failure";
}
mysqli_close($con);
?>
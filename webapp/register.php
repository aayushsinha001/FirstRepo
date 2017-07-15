<?php
require "init.php";

extract($_POST);
	
$name=$_POST["name"];
$usn=$_POST["usn"];
$user_pass=$_POST["user_pass"];

echo $name;
echo $usn;
echo $user_pass;

//$sql_query=

if(mysqli_query($con,"insert into user_info(name,usn,user_pass) VALUES('$name','$usn','$user_pass')"))
{
	echo "Hello";
}
else
{
	echo "Data insertion error ..".mysqli_error($con);
}
mysqli_close($con);
?>
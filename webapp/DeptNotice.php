<?php
require "init.php";

extract($_POST);
	
$message=$_POST["message"];

//$sql_query=

if(mysqli_query($con,"insert into dept_notice(msg) VALUES('$message')"))
{
	echo "Hello";
}
else
{
	echo "Data insertion error ..".mysqli_error($con);
}
mysqli_close($con);
?>
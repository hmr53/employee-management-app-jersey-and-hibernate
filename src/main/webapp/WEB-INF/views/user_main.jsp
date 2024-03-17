<%@ page import="org.hasith.ems.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: CODE53215
  Date: 9/5/2023
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="assets/bootstrap.min.css" rel="stylesheet">
    <title>User Panel</title>
</head>
<body>
<div class="container mt-5">
    <div class="row d-flex justify-content-center">
        <div class="col-10">
            <h1 class="text-center">This is user panel</h1>
            <h2 class="text-center">Hello , ${sessionScope.user_availability.username}</h2>
        </div>
        <div class="col-10">
            <div class="row mt-5">
                <div class="col-6 text-center"><button class="btn btn-primary" onclick="goto_add_employee()">Go to Add Employee</button></div>
                <div class="col-6 text-center"><button class="btn btn-primary" onclick="goto_view_employee()">Go to View Employee</button></div>
            </div>
        </div>

    </div>
</div>



<div class="container">

</div>


<script src="assets\bootstrap.bundle.js"></script>
<script>
    function goto_add_employee(){
        window.location.href= "employee-add";
    }
    function goto_view_employee(){
        window.location.href= "employee-view";
    }
</script>
</body>
</html>

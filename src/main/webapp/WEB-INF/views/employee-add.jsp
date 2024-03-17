<%--
  Created by IntelliJ IDEA.
  User: CODE53215
  Date: 9/16/2023
  Time: 6:44 PM
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
    <title>Add Employee</title>
</head>
<body>
<div class="container mt-5">
    <div class="row d-flex justify-content-center">
        <div class="col-6">
            <h1 class="text-center text-uppercase">Add Employees </h1>

            <div class="mt-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" id="name" class="form-control">
            </div>
            <div class="mt-3">
                <label for="position" class="form-label">Position</label>
                <input type="text" id="position" class="form-control">
            </div>
            <div class="mt-3">
                <label for="department" class="form-label">Department</label>
                <input type="text" id="department" class="form-control">
            </div>
            <div class="mt-3">
                <label for="hire-date" class="form-label">Hire Date</label>
                <input type="date" id="hire-date" class="form-control">
            </div>
            <div class="mt-3">
                <label for="salary" class="form-label">Salary</label>
                <input type="number" id="salary" class="form-control">
            </div>

            <div class="row mt-5 d-flex justify-content-center">
                    <button class="btn btn-primary text-center col-4" onclick="insert_employee()">Add Employee</button>
            </div>

            <div class="row mt-5 d-flex justify-content-center">
                <button class="btn btn-success text-center col-4" >
                    <a href="employee-view.jsp" class="text-decoration-none text-light"> View Employees</a>
                </button>
            </div>

        </div>
    </div>
</div>

<script src="assets\bootstrap.bundle.js"></script>
<script src="assets/main.js"></script>
</body>
</html>
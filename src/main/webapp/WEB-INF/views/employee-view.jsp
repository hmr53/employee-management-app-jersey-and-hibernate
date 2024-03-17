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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
    <link href="assets/bootstrap.min.css" rel="stylesheet">
    <title>View Employees</title>
</head>
<body onload="search_all_employees();">

<div class="container mt-5">
    <div class="row d-flex justify-content-center">
        <h1 class="text-center text-uppercase">Manage Employees - search/update/delete</h1>
        <div class="col-10">
            <div class="row">
                <div class="col-12">
                    <div class="row">
                        <div class="col-6 mt-3">
                            <label for="hire-date" class="form-label">Employee name</label>
                            <input type="text" id="hire-date" class="form-control" aria-describedby="passwordHelpBlock">
                        </div>
                        <div class="col-4 mt-3">
                            <label for="" class="form-label">Select Option</label>
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Open this select menu</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                        <button class="btn btn-outline-dark col-2 font-monospace"
                                style="height: 45px; margin-top: 45px"> Search
                        </button>
                    </div>
                </div>
                <div class="col-12">
                    <table class="table" id="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">name</th>
                            <th scope="col">position</th>
                            <th scope="col">department</th>
                            <th scope="col">hire-date</th>
                            <th scope="col">salary</th>
                            <th scope="col">update</th>
                            <th scope="col">delete</th>
                        </tr>
                        </thead>

                        <tbody>
                        <%--                        <tr>--%>
                        <%--                            <th scope="row">1</th>--%>
                        <%--                            <td>Hasith Malshan</td>--%>
                        <%--                            <td>Senior SE</td>--%>
                        <%--                            <td>IT Department</td>--%>
                        <%--                            <td>2022-02-05</td>--%>
                        <%--                            <td>200,000 LKR</td>--%>
                        <%--                            <td>--%>
                        <%--                                <button class="btn text-success" type="button" data-bs-toggle="modal"--%>
                        <%--                                        data-bs-target="#exampleModal">update <i class="bi bi-pencil-fill"></i></button>--%>
                        <%--                            </td>--%>
                        <%--                            <td>--%>
                        <%--                                <button class="btn text-danger" type="button" data-bs-toggle="modal"--%>
                        <%--                                        data-bs-target="#deleteModel">delete <i class="bi bi-trash3-fill"></i></button>--%>
                        <%--                            </td>--%>
                        <%--                        </tr>--%>
                        </tbody>

                    </table>

                </div>
                <div class="col-12">
                    <div class="row mt-5 d-flex justify-content-center">
                        <a href="employee-add.jsp" class="text-center">
                            <button class="btn btn-primary text-center col-4"> Go to Add-Employee</button>
                        </a>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>


<!-- Update Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Update Employee - 00111</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <h3 class="text-center text-uppercase">Update Employee </h3>

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
                    <label for="hiredate" class="form-label">Hire Date</label>
                    <input type="date" id="hiredate" class="form-control">
                </div>
                <div class="mt-3">
                    <label for="salary" class="form-label">Salary</label>
                    <input type="number" id="salary" class="form-control">
                </div>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="update-model-save">Save changes</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="deleteModel" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModel-title">Delete User</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" id="deleteModel-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="deleteModel-close">Close
                </button>
                <button type="button" class="btn btn-primary" id="deleteModel-save">Save changes</button>
            </div>
        </div>
    </div>
</div>

<script src="assets\bootstrap.bundle.js"></script>
<script src="assets/main.js"></script>
</body>
</html>
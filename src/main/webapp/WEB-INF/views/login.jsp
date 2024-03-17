<%--
  Created by IntelliJ IDEA.
  User: CODE53215
  Date: 9/7/2023
  Time: 10:16 PM
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
    <title>User Login</title>
</head>
<body>

<div class="container mt-5">
    <div class="row d-flex justify-content-center">
        <div class="col-6">
            <h1 class="text-uppercase text-center mb-5">This is user login page</h1>
            <span class="">Enter username</span>
            <input type="text" name="username" id="username" class="form-control"><br/>
            <span>Enter password</span>
            <input type="text" name="password" id="password" class="form-control"><br/>

            <div class="row d-flex justify-content-center">
                    <button class="btn btn-primary sign-in text-center col-4">Login</button>
            </div>

        </div>
    </div>
</div>

<script src="assets\bootstrap.bundle.js"></script>
<script type="text/javascript">

    document.getElementsByClassName('sign-in').item(0).addEventListener('click', function () {
        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;


        let form = {
            username: username,
            password: password,
        }

        fetch('demo-auth',
            {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "POST",
                body: JSON.stringify(form)
            }
        ).then(async response => {
            const text = await response.text();

            if (response.status === 400 || response.status === 200){
                window.location.assign("user-home");
            }
        }).catch(function (res) {
            console.log(res)
        })
    })

</script>
</body>
</html>
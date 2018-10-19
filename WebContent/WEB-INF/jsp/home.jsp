<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover {
            background-color: #111;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #f2a5a5;
        }

        .button {
            background-color: #008CBA; /* Green */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>

</head>
<body>
<h1>${Hello}</h1>
<h1>Employee Registration Form</h1>

<h2>${msg}</h2>

<form action="register" method="post">
    <table style="width: 50%">
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstName" placeholder="First Name" pattern="[A-Za-z]+" title="Characters only"
                       required/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName" placeholder="Last Name" pattern="[A-Za-z]+" title="Characters only"
                       required/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" placeholder="Address" pattern="[A-Za-z0-9]+" title="Alphanumeric only"
                       required/></td>
        </tr>
        <tr>
            <td>Contact No</td>
            <td><input type="number" name="mobileNumber" placeholder="Contact" pattern="^\d{10}$" title="10 digits must"
                       required/></td>
        </tr>
        <tr>
            <td>Designation</td>
            <td><input type="text" name="designation" placeholder="Designation" pattern="[A-Za-z]+"
                       title="Characters only" required/></td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><input type="number" name="salary" placeholder="Salary" pattern="[0-9]+" title="Digits only" required/>
            </td>
        </tr>
    </table>

    <button class="button" type="submit" value="Save">Save</button>
    <button class="button" value="cancel"><a href="index.jsp">Cancel</a></button>
    <button class="button" value="home"><a href="index.jsp">Home</a></button>
</form>
</body>
</html>

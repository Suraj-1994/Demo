<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .button {
            background-color: #008CBA; /* Green */
            border: none;
            color: white;
            padding: 6px 12px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 2px 0px;
            cursor: pointer;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

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
    </style>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>Delete Employee Information</h2>
<h3>${msg}</h3>
<form action="/updateProcess" method="post">
    <table style="width: 50%">
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" value="${employee.id}" readonly/></td>
        </tr>
        <tr>
            <td>Employee First Name</td>
            <td><input type="text" name="firstName" value="${employee.firstName}"/></td>
        </tr>
        <tr>
            <td>Employee Last Name</td>
            <td><input type="text" name="lastName" value="${employee.lastName}"/></td>
        </tr>
        <tr>
            <td>Employee Address</td>
            <td><input type="text" name="address" value="${employee.address}"/></td>
        </tr>
        <tr>
            <td>Employee Contact No</td>
            <td><input type="text" name="mobileNumber" value="${employee.mobileNumber}"/></td>
        </tr>
        <tr>
            <td>Employee Designation</td>
            <td><input type="text" name="designation" value="${employee.designation}"/></td>
        </tr>
        <tr>
            <td>Employee Salary</td>
            <td><input type="text" name="salary" value="${employee.salary}"/></td>
            <input type="hidden" name="status" value="${employee.status}"/>
        </tr>

    </table>

    <tr>
        <td>
            <button class="button" type="submit" value="delete">Delete</button>
        </td>
        <td>
            <button class="button" value="cancel"><a href="index.jsp">Cancel</a></button>
        </td>
        <td>
            <button class="button" value="home"><a href="index.jsp">Home</a></button>
        </td>
    </tr>
</form>
</body>
</html>
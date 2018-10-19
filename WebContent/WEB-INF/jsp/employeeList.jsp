<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <title>Insert title here</title>

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
            background-color: #008CBA; /* Blue */
            border: none;
            color: white;
            padding: 8px 25px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 3px 1px;
            cursor: pointer;
        }

        .button2 {
            background-color: #f44336;
        }


    </style>

</head>
<body>

<table width="100%">
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Address</th>
        <th>Contact</th>
        <th>Designation</th>
        <th>Salary</th>

    </tr>
    <%--<h2>${msg}</h2>--%>
    <c:forEach var='data' items="${employeeList}">
        <tr>
            <td>${data.id}</td>
            <td>${data.firstName}</td>
            <td>${data.lastName}</td>
            <td>${data.address}</td>
            <td>${data.mobileNumber}</td>
            <td>${data.designation}</td>
            <td>${data.salary}</td>

        </tr>
    </c:forEach>
</table>
<button class="button"><a href="index.jsp">Home</a></button>
</body>
</html>
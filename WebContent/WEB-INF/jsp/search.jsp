<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${msg}</h3>
<td> Search Employee by Id:
    <form action="/searchById">
        <input type="number" name="id" placeholder="Enter Id" maxlength="4" pattern="\d{4}" required/>
        <input type="submit" value="Search"/>
    </form>
</td>
<td> Search Employee by Contact:
    <form action="/searchByContact">
        <input type="number" name="mobileNumber" placeholder="Enter Contact" pattern="/(6|7|8|9)\d{9}" required/>
        <input type="submit" value="Search"/>
    </form>
</td>
</body>
</html>

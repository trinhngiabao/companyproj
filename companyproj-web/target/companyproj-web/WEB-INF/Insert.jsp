<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/6/2023
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert</title>
</head>
<body>
    <h2>Insert employee</h2>
<form action="employee" method="POST">
    <p>
        <input name="empId" type="text" placeholder="EmployeeId">
    </p>
    <p>
        <input name="empName" type="text" placeholder="EmployeeName">
    </p>

    <fieldSet>
        <p>
    <legend>Company exits in DB</legend>
    <input name="comId" type="text" placeholder="Company Id">
        </p>
    </fieldSet>
    <fieldSet>
        <p>
            <legend>Company exits in DB</legend>
            <input name="comIdNew" type="text" placeholder="Company Id">
            <input name="comName" type="text" placeholder="Company Name">
        </p>
    </fieldSet>
    <p>
        <input type="submit" value="ADD" name="action">
    </p>


</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User CRUD</title>
<style>
    <head>
<meta charset="UTF-8">
<title>User CRUD</title>
<style>
    /* Reset các kiểu dáng mặc định */
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }
    
    body {
        background-color: #f4f7fa;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        padding: 20px;
        color: #333;
    }

    /* Container styling */
    .container {
        background-color: #fff;
        border: 1px solid #ccc;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        padding: 20px;
        max-width: 600px;
        width: 100%;
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 15px;
    }

    /* Form styling */
    form {
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 10px;
        margin-bottom: 20px;
    }

    form label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
        color: #333;
    }

    form input[type="text"],
    form input[type="password"] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ffa500;
        border-radius: 4px;
    }

    .form-group {
        grid-column: span 1;
    }

    .form-group.full {
        grid-column: span 2;
    }

    .gender-group {
        display: flex;
        align-items: center;
        gap: 10px;
    }

    form input[type="radio"] {
        margin-right: 5px;
    }

    form button {
        padding: 10px 15px;
        border: none;
        border-radius: 4px;
        color: #fff;
        cursor: pointer;
        margin: 5px 0;
    }
    
    button[formaction*="create"] {
        background-color: #4CAF50; /* Green */
    }
    
    button[formaction*="update"] {
        background-color: #2196F3; /* Blue */
    }
    
    button[formaction*="delete"] {
        background-color: #f44336; /* Red */
    }
    
    button[formaction*="reset"] {
        background-color: #ff9800; /* Orange */
    }

    /* Table styling */
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        border: 1px solid #ccc;
    }

    table th, table td {
        padding: 10px;
        text-align: left;
        border: 1px solid #ddd;
    }

    table th {
        background-color: #3f51b5;
        color: #fff;
    }

    table tbody tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    table tbody tr td a {
        color: #2196F3;
        text-decoration: none;
        font-weight: bold;
    }

    table tbody tr td a:hover {
        text-decoration: underline;
    }
</style>
</head>

</style>
</head>
<body>
    <i>${message}</i>
    <c:url var="url" value="/user/crud" scope="request"/>
    <form method="post">
        <label>Id:</label>
        <input name="id" value="${user.id}"><br>
        <label>Password:</label>
        <input name="password" type="password" value="${user.password}"><br>
        <label>Fullname:</label>
        <input name="fullname" value="${user.fullname}"><br>
        <label>Email Address:</label>
        <input name="email" value="${user.email}"><br>
        <label>Role:</label>
        <input name="gender" type="radio" value="true" ${user.admin?'checked':''}> Admin
        <input name="gender" type="radio" value="false" ${user.admin?'':'checked'}> User
        <hr>
        <button formaction="${url}/create">Create</button>
        <button formaction="${url}/update">Update</button>
        <button formaction="${url}/delete">Delete</button>
        <button formaction="${url}/reset">Reset</button>
    </form>

    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Fullname</th>
                <th>Email</th>
                <th>Role</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="u" items="${users}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.password}</td>
                    <td>${u.fullname}</td>
                    <td>${u.email}</td>
                    <td>${u.admin ? 'Admin' : 'User'}</td>
                    <td><a href="${url}/edit/${u.id}">Edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

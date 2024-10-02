<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h2>Product List</h2>
<a href="/products/new">Add New Product</a>


<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                <a href="/products/edit/${product.id}">Edit</a>
                <a href="/products/delete/${product.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

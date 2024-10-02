<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h2>Edit Product</h2>
<form action="/products/edit/${product.id}" method="post">
    <input type="hidden" name="id" value="${product.id}"/>
    <label>Name:</label><br>
    <input type="text" name="name" value="${product.name}"/><br>
    <label>Price:</label><br>
    <input type="text" name="price" value="${product.price}"/><br>
    <button type="submit">Update</button>
</form>
</body>
</html>

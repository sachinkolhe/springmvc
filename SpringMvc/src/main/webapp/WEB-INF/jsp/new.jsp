<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Product</title>
</head>
<body>
<h2>Add New Product</h2>
<form action="/products" method="post">
	
    <label>Name:</label><br>
    <input type="text" name="name"/><br>
    <label>Price:</label><br>
    <input type="text" name="price"/><br>
	
    <button type="submit">Save</button>

	</form>

</body>
</html>

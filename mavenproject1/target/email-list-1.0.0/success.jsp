<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Thanks</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
  <div class="container">
    <h1>Thanks for joining!</h1>
    <p>Welcome, <strong><%= request.getAttribute("firstName") %></strong>. Your email has been added.</p>
    <p><a href="index.jsp">Back</a></p>
  </div>
</body>
</html>

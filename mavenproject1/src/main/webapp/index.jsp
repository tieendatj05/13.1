<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Join our email list</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
  <div class="container">
    <h1>Join our email list</h1>
    <p>To join our email list, enter your name and email address below.</p>

    <%
      String message = (String) request.getAttribute("message");
      if (message != null && !message.isBlank()) {
    %>
      <div class="alert"><%= message %></div>
    <% } %>

    <form action="subscribe" method="post" class="form">
      <label>Email:</label>
      <input type="email" name="email"
             value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : "" %>">

      <label>First Name:</label>
      <input type="text" name="firstName"
             value="<%= request.getAttribute("firstName") != null ? request.getAttribute("firstName") : "" %>">

      <label>Last Name:</label>
      <input type="text" name="lastName"
             value="<%= request.getAttribute("lastName") != null ? request.getAttribute("lastName") : "" %>">

      <button type="submit" class="btn">Join Now</button>
    </form>
  </div>
</body>
</html>

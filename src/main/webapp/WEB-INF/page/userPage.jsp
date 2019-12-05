<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>User</title>
</head>
<body>
<span>${user.name}</span>
</body>
</html>

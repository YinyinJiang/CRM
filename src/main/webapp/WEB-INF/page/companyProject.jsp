<%--
  Created by IntelliJ IDEA.
  User: Yinyin
  Date: 2019/12/5
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        function get_score() {
            $.ajax({
                url: "http://localhost:8080/crm/company/getCompanySubScoreList/1",
                success: function (result) {
                    alert(result['a']);
                },
                failure: function (result) {
                    alert(result)
                }
            });
        }
    </script>
</head>
<body>
<c:forEach items="$(companyProjectList)" var="project">
    <p>${companyProjectList.get(0).name}</p>
</c:forEach>

<button id="get_score_button" onclick="get_score()">get sub score</button>

</body>
</html>

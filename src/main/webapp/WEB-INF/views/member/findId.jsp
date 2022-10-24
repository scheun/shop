<%--
  Created by IntelliJ IDEA.
  User: sche1
  Date: 2022-09-28
  Time: 오후 8:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <meta charset="utf-8">
    <title>findId</title>
    <script>
    </script>
</head>
<body>
    <form action="/member/findIdResult" method="post">
        이메일 : <input id="email" name="email" type="email"/><br>
        <button id='findIdBtn' type="submit">아이디찾기</button>
    </form>
</body>
</html>
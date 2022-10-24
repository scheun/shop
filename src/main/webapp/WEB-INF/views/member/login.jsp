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
    <title>login</title>
    <script>
    </script>
</head>
<body>
    <form method="post">
        ID : <input id="id" name="id" value=${id}><br>
        비밀번호 : <input id="pw" name="pw" type="password"/><br>
        <input id="rememberId" name="rememberId" type="checkbox"/> 아이디 저장
        <button id="loginBtn" type="submit">로그인</button>
    </form>
</body>
</html>
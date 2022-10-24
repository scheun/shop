<%--
  Created by IntelliJ IDEA.
  User: sche1
  Date: 2022-08-29
  Time: 오후 2:28
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <meta charset="utf-8">
<title>join</title>
<script>
    $(document).ready(function(){
        $("#joinBtn").click(function(){

            var members = {
                id: $('#id').val(),
                pw: $('#pw').val(),
                email: $('#email').val()
            }

            $.ajax({
                type : "POST",
                url : "/join",
                dataType : "json",
                data: members,
                success : function(data){
                    result : data,
                    alert("회원가입 성공");
                },
                error:	function(data){
                    result : data,
                    alert("회원가입 실패");
                },
            });
        });
    });

</script>
</head>
<body>
    ID : <input id="id" name="id" type="text"/><br>
    비밀번호 : <input id="pw" name="pw" type="password"/><br>
    이메일 : <input id="email" name="email" type="email"/><br>
    <button id='joinBtn' type="button">회원가입</button>
</body>
</html>
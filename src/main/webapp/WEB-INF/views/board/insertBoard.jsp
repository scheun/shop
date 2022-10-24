<%--
  Created by IntelliJ IDEA.
  User: sche1
  Date: 2022-10-05
  Time: 오전 10:07
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <meta charset="utf-8">
    <title>insertBoard</title>
    <script>
        $(document).ready(function(){
            $("#insertBtn").click(function(){

                var boards = {
                    title: $('#title').val(),
                    content: $('#content').val()
                }

                $.ajax({
                    type : "POST",
                    url : "/insertBoard",
                    dataType : "json",
                    data: boards,
                    success : function(data){
                        result : data,
                            location.href="/"
                    },
                    error:	function(data){
                        result : data,
                            alert("글 작성 실패");
                    },
                });
            });
        });

    </script>
</head>
<style>
    .container {
        width: 1500px;
        margin: 0 auto;
    }
</style>
<body>
    <div style="text-align: center">
        <h3>글&nbsp;작성</h3>
    </div>
    <div class="container" >
        <div class='row'>
            <div class='col'>
                    <input type='text' placeholder='제목을 입력하세요.'
                           style='border:none;' minlength='3' id='title'/><hr>
                    <textarea placeholder='내용을 입력하세요.'  style='width:100%' rows='15' id='content'></textarea>
                <div style='float:right; margin-top:10px;'>
                    <button id='insertBtn'>등록</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
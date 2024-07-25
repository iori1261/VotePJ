<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>投票画面</title>
</head>
<body>
    <h1>パソコンの所有率に関するアンケートです。</h1>
    <form action="${pageContext.request.contextPath}/VoteMainServlet" method="post">
        <input type="radio" name="event" value="両方もっている">両方もっている<br>
        <input type="radio" name="event" value="ノートPCだけ">ノートPCだけ<br>
        <input type="radio" name="event" value="デスクトップPCだけ">デスクトップPCだけ<br>
        <input type="radio" name="event" value="どちらも持っていない">どちらも持っていない<br>
        <input type="radio" name="event" value="持っていない">持っていない<br>
        <input type="submit" value="投票">
    </form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  request.setAttribute("age", 22);
%>
<h3>안녕하세요. 이창호입니다!!</h3>
  <hr />
  <a href='MemberAddServlet'>서블릿페이지로 이동</a><br>
  <a href='MemberListServlet'>회원목록 서블릿으로 이동</a>
  <p>1.서블릿 생성.</p>
  <p>2.매퍼호출</p>
  <p>3.response.getWriter()를 활용해서 목록그리기</p>
  <script src="index.js"></script>
</body>
</html>
<%@page import="com.yedam.service.MemberService"%>
<%@ page import="com.yedam.service.MemberServiceImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!-- MVC 디자인: View(JSP페이지) , Model(DB처리) , 컨트롤 -->
  <!-- Expression Language : EL -->
  <!-- jsp action tag -->
  <!-- JSP Standard Tag Library : JSTL -->
  <jsp:forward page="pmain.do"></jsp:forward>

  
</body>
</html>
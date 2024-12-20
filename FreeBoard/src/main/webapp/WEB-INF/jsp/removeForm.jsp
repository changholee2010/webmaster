<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>삭제화면(removeForm.jsp)</h3>

<%
  String msg = (String) request.getAttribute("msg");
  BoardVO board = (BoardVO) request.getAttribute("boardvo");
%>

<%if (msg != null) { %>
<p style="color: red;"><%=msg %></p>
<%} %>

<form action="removeBoard.do" method="post">
  <input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
  <table class="table">
    <tr>
      <th>글번호</th><td><%=board.getBoardNo() %></td>
      <th>조회</th><td><%=board.getViewCnt() %></td>
    </tr>
    <tr>
      <th>제목</th>
      <td colspan="3"><%=board.getTitle() %></td>
    </tr>
    <tr>
      <th>내용</th>
      <td colspan="3">
        <textarea readonly class="form-control" name="content" rows="3" cols="30"><%=board.getContent() %></textarea>
      </td>
    </tr>
    <tr>
      <th>작성자</th><td colspan="3"><%=board.getWriter() %></td>
    </tr>
    <tr>
      <td colspan="4" align="center">
        <input type="submit" value="삭제" class="btn btn-danger">
        <input type="reset" value="취소" class="btn btn-warning">
      </td>
    </tr>
  </table>
</form>

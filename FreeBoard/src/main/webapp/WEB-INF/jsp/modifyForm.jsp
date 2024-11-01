<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>수정화면(modifyForm.jsp)</h3>

<%
  String msg = (String) request.getAttribute("msg");
  String pg = (String) request.getAttribute("page");
  String sc = (String) request.getAttribute("searchCondition");
  String kw = (String) request.getAttribute("keyword");
  BoardVO board = (BoardVO) request.getAttribute("boardvo");
  // 세션정보.
  String logId = (String) session.getAttribute("logId");
%>

<%if (msg != null) { %>
<p style="color: red;"><%=msg %></p>
<%} %>

<form action="modifyBoard.do" method="post">
  <input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
  <input type="hidden" name="page" value="<%=pg %>">
  <input type="hidden" name="searchCondition" value="<%=sc %>">
  <input type="hidden" name="keyword" value="<%=kw %>">
  <table class="table">
    <tr>
      <th>글번호</th><td><%=board.getBoardNo() %></td>
      <th>조회</th><td><%=board.getViewCnt() %></td>
    </tr>
    <tr>
      <th>제목</th>
      <td colspan="3">
        <input class="form-control" type="text" name="title" value="<%=board.getTitle() %>">
      </td>
    </tr>
    <tr>
      <th>내용</th>
      <td colspan="3">
        <textarea class="form-control" name="content" rows="3" cols="30"><%=board.getContent() %></textarea>
      </td>
    </tr>
    <tr>
      <th>작성자</th><td colspan="3"><%=board.getWriter() %></td>
    </tr>
    <tr>
      <td colspan="4" align="center">
        <input type="submit" value="저장" <%=logId != null && logId.equals(board.getWriter()) ? "" : "disabled" %> class="btn btn-success">
        <input type="reset" value="취소" class="btn btn-warning">
      </td>
    </tr>
  </table>
</form>

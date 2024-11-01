<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>로그인화면(loginForm.jsp)</h3>
<form action="loginForm.do" method="post">
  <table class="table">
    <tr>
      <th class="col-sm-4">아이디</th>
      <td><input type="text" name="logId" class="form-control col-sm-4">
      </td>
    <tr>
      <th class="col-sm-4">비밀번호</th>
      <td><input type="password" name="logPw" class="form-control col-sm-4">
      </td>
    <tr>
      <td align="center" colspan="2">
        <button type="submit" class="btn btn-primary">로그인</button>
      </td>
    </tr>
  </table>
</form>

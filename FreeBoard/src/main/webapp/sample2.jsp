<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>add demo</title>
  <style>
  div {
    width: 60px;
    height: 60px;
    margin: 10px;
    float: left;
  }
  p {
    clear: left;
    font-weight: bold;
    font-size: 16px;
    color: blue;
    margin: 0 10px;
    padding: 2px;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
 
<div></div>
<div></div>
<div></div>
<div></div>
<div></div>
<div></div>
 
<p>Added this... (notice no border)</p>
 
<script>
$( "div" ).css( "border", "2px solid red" )
  .add( "p" )
  .css( "background", "yellow" );
</script>
 
</body>
</html>
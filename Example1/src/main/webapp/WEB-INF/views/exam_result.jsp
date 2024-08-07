<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>결과 페이지</title>
  
  <style>
  .title{
  		text-docoration : underline;
  		font-family			: "돋움";
  		color						: green;
  }
		
		#input1{color:yellow;}		
		#input2{color:green;}		
		#input2{color:blue;}		
		  
  </style>
</head>
<body>

	<h1 class="title">결과 페이지, 한페이지의 끝이 될 수 있게</h1>
	
	<h1>
	입력값 1 : 
		<span id="input1"> <%= request.getParameter("input1") %> </span>
	</h1>
	
	<h1>
	입력값 2 : 
		<span id="input2"> <%= request.getParameter("input2") %> </span>
	</h1>
	
	<h1>
	입력값 3 : 
		<span id="input3"> <%= request.getParameter("input3") %> </span>
	</h1>
	

	
  
</body>
</html>
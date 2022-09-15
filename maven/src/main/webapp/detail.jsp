<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 세부사항</title>
</head>
<body>

<%
request.setCharacterEncoding("UTF-8");
//HttpSession session = request.getSession();
int j = 1; %>
	<p>재료<%= %> 및 시간<%= %> 인분<%= %> 등 표시는 여기에</p>
	<%for(int i = 0; i < 6; i++){ %>
	<p><%=j%>번째 : <%= %></p>
	<%j++; %>
	<%} %>
</body>
</html>
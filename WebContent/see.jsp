<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.message.*" %>
<jsp:useBean id="data" class="model.message.MessageVO" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>

<table border="1">
	<tr>
		<td><%=data.getTitle()%></td>
	</tr>
	<tr>
		<td><%=data.getContent()%></td>
	</tr>
	<tr>
		<td><%=data.getWdate()%></td>
	</tr>
</table>
<button><a href="control_message.jsp?action=main">목록</a></button>


</body>
</html>
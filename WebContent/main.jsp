<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.message.*"%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>M Y P A G E</title>
</head>
<body>

<button><a href="write.jsp">글쓰기</a></button>

<table border="1">
	<tr>
		<td>번호</td><td>제목</td><td>작성자</td><td>작성일</td>
	</tr>
	
<%
	for(MessageVO vo:(ArrayList<MessageVO>)datas){
%>		<tr>
		<td><%=vo.getNum()%></td>
		<td><a href="control_message.jsp?action=see&num=<%=vo.getNum()%>"><%=vo.getTitle()%></a></td>
		<td><%=vo.getId()%></td>
		<td><%=vo.getWdate()%></td>
		</tr>
<%		
	}
%>

</body>
</html>
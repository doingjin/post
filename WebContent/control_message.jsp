<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.message.*" errorPage="error.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="msgdao" class="model.message.MessageDAO" />
<jsp:useBean id="msgvo" class="model.message.MessageVO"/>
<jsp:setProperty property="*" name="msgvo"/>

<% 
	String action=request.getParameter("action");
	
	if (action.equals("main")){
		ArrayList<MessageVO> datas=msgdao.getMSGlist();
		request.setAttribute("datas", datas);
		pageContext.forward("main.jsp");
	}
	else if(action.equals("see")){
		MessageVO data=msgdao.getMSG(msgvo);
		request.setAttribute("data", data);
		pageContext.forward("see.jsp");
	}
	else if(action.equals("write")){
		if(msgdao.newMSG(msgvo)){
			// out.println("<script>alert('등록되었습니다!');history.go(-1)</script>");
			response.sendRedirect("control_message.jsp?action=main");
		} else {
			throw new Exception("글 등록 오류!");
		}
	}
	else if(action.equals("delete")){
		
	}
	else if(action.equals("edit")){
		
	}
%>
    
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Controller</title>
</head>
<body>

</body>
</html>
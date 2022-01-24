<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, org.james.seventh.lecture.vo.Member" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>간단한 회원 관리 Application</title>
</head>
<%
	ArrayList<Member> members = (ArrayList<Member>) request.getAttribute ("members");
%>
<body>
	<jsp:include page="../Header.jsp"/>
	
	<h1>회원 목록</h1>
	<p>
		<a href='add.do'>회원 추가</a>
	</p>
	<table border='1' cellspacing='0' cellpadding='5'>
		<tr>
			<td>No</td>
			<td>이름</td>
			<td>E-Mail</td>
			<td>가입일자</td>
			<td>관리</td>
		</tr>
		<%
		if (members != null) {
			for (Member member : members) {
		%>
			<tr>
				<td><%=member.getNo()%></td>
				<td><%=member.getName()%></td>
				<td><%=member.getEmail()%></td> 
				<td><%=member.getCreatedDate()%></td> 
				<td>	
					<a href='update.do?no=<%=member.getNo()%>'>수정</a>&nbsp;
					<a href='delete.do?no=<%=member.getNo()%>'>삭제</a>
				</td>
			</tr>
			
		<%	
			}
		} else {
		%>
			<tr>
				<td colspan='5'> Empty Data </td>
		<%} %>
	</table>
	<jsp:include page="../Footer.jsp"/>
</body>
</html>
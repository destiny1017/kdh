<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인창</title>
</head>
<body>

	<%	// 1.로그인 폼에 사용자가 입력한 아이디/비밀번호
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 2.회원이면 Session을 만들고, 메인으로 이동하기
		if(id.equals("admin") && pw.equals("1234")) {
		String admin ="관리자";
		session.setAttribute("admin", admin);
		response.sendRedirect("http://localhost:8888/Shop5/about.jsp");
		}else {
		try {
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = dao.select(id);
			
			if(dto != null) {
				if(dto.getPw().equals(pw)) { //회원로그인 확인되었을경우
					if(id !=null) { //세션등록
						ArrayList<MemberDTO> list = new ArrayList<>();
						list = dao.selectinfo(id);
						for (int i = 0; i < list.size(); i++) {
							dto = list.get(i);
						}
						session.setAttribute("id", id);
						session.setAttribute("name", dto.getName());
					}else {
						
					}
					//메인으로이동
					response.sendRedirect("http://localhost:8888/Shop5/about.jsp");
					
				}else {
					
				out.println("<script> alert(\"비밀번호가 맞지않습니다\"); history.back(); </script>");
				}
			}else { //회원아이디가 맞지않는경우				
				out.println("<script> alert(\"회원 정보가 없습니다\"); history.back(); </script>");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			
		}
		
	%>
		
</body>
</html>
<%@page import="product.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="dto" class="product.ProductDTO">
		<jsp:setProperty name="dto" property="*"/>
	</jsp:useBean>
	
<%
	ProductDAO dao = new ProductDAO();
	int result = dao.insert(dto);
	
	//메서드 실행 결과로 성공실패여부 출력
	if(result == 1){
%>
		<script>
			alert("상품 등록에 성공하였습니다.")
			location.href = "index.html"
		</script>
<%
	}else{
%>
		<script>
			alert("상품 등록에 실패하였습니다.")
			location.href = "index.html"
		</script>
<%
	} 
%>


</body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="bean.ProductDAO"%>
<%@page import="bean.ProductDTO"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
<head>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.oreilly.servlet.MultipartRequest,com.oreilly.servlet.multipart.DefaultFileRenamePolicy,java.util.*,java.io.*" %>
<%@ page import="java.sql.*" %>

<%
	 request.setCharacterEncoding("UTF-8");
	 String realFolder = "";
	 String filename1 = "";
	 int maxSize = 1024*1024*5;
	 String encType = "UTF-8";
	 String savefile = "images\\clothes";
	 ServletContext scontext = getServletContext();
	 realFolder = scontext.getRealPath(savefile);
	 String[] filename = new String[3];
	 
	 String category = "";
	 String pId = "";
	 String name = "";
	 String explanation = "";
	 String price = "";
	 String sizeS = "";
	 String sizeM = "";
	 String sizeL = "";
	 String sizeXL = "";
	 
	 String path = "C:\\Users\\user\\git\\shopping\\Shop5\\WebContent\\images\\clothes\\";
	 
	 ProductDAO dao = new ProductDAO();
	 ProductDTO dto = null;
	 
	 try{
	  MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
	
	  Enumeration<?> files = multi.getFileNames();
	  
	  category = multi.getParameter("category");
	  pId = multi.getParameter("pId");
	  name = multi.getParameter("name");
	  explanation = multi.getParameter("explanation");
	  price = multi.getParameter("price");
	  sizeS = multi.getParameter("sizeS");
	  sizeM = multi.getParameter("sizeM");
	  sizeL = multi.getParameter("sizeL");
	  sizeXL = multi.getParameter("sizeXL");
	  
	  dto = new ProductDTO(pId, name, explanation, price, sizeS, sizeM, sizeL, sizeXL, category);
	  dao.addProduct(dto);
	  
	  for(int i = 0; i < 3; i++){
		  String file1 = (String)files.nextElement();
		  filename[i] = multi.getFilesystemName(file1);
		  
	  }
	  
	  
	 } catch(Exception e) {
	  e.printStackTrace();
	 }
	 
	 for(int i = 0; i < 3; i++){
		 
		  File file = new File(path + filename[i]);
		  File fileN = new File(path + pId + "_" + (i+1) + ".jpg");
			
		  if(file.exists()) {
			file.renameTo(fileN);
		  }
	 }
	 
%>
<script>
	alert("상품 등록에 성공하였습니다.")
	location.href = "admin-product.jsp"
</script>

	
<title>Insert title here</title>
</head>
<body>



</body>
</html>

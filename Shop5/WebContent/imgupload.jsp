<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
	 String savefile = "img";
	 ServletContext scontext = getServletContext();
	 realFolder = scontext.getRealPath(savefile);
	 
	 try{
	  MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
	
	  Enumeration<?> files = multi.getFileNames();
	  String file1 = (String)files.nextElement();
	  filename1 = multi.getFilesystemName(file1);
	  
	 } catch(Exception e) {
	  e.printStackTrace();
	 }
	 
	 String fullpath = realFolder + "\\" + filename1;
%>
<title>Insert title here</title>
</head>
<body>

<form action="#">
	<Table>
		<tr>
			<td id="td1">
				<div class="block2">
					<div
						class="block2-img wrap-pic-w of-hidden pos-relative block2-labelnew">
						<img src="images/product1.JPG" alt="IMG-PRODUCT" />

						<div class="block2-overlay trans-0-4">
							<a href="#" class="block2-btn-addwishlist hov-pointer trans-0-4">
								<i class="icon-wishlist icon_heart_alt" aria-hidden="true"></i>
								<i class="icon-wishlist icon_heart dis-none" aria-hidden="true"></i>
							</a>

							<div class="block2-btn-addcart w-size1 trans-0-4">
								<!-- Button -->
								<button
									class="flex-c-m size1 bg4 bo-rad-23 hov1 s-text1 trans-0-4">
									Upload Image</button>
							</div>
						</div>
					</div>
				</div>

			</td>
			<td id="td2">
				<div class="block2">
					<div
						class="block2-img wrap-pic-w of-hidden pos-relative block2-labelnew">
						<img src="images/product1.JPG" alt="IMG-PRODUCT" />

						<div class="block2-overlay trans-0-4">
							<a href="#" class="block2-btn-addwishlist hov-pointer trans-0-4">
								<i class="icon-wishlist icon_heart_alt" aria-hidden="true"></i>
								<i class="icon-wishlist icon_heart dis-none" aria-hidden="true"></i>
							</a>

							<div class="block2-btn-addcart w-size1 trans-0-4">
								<!-- Button -->
								<button type="button" onclick="addImg(2)"
									class="flex-c-m size1 bg4 bo-rad-23 hov1 s-text1 trans-0-4">
									Upload Image</button>
							</div>
						</div>
					</div>
				</div>
			</td>
			<td id="td3">
				<div class="block2">
					<div
						class="block2-img wrap-pic-w of-hidden pos-relative block2-labelnew">
						<img src="images/product1.JPG" alt="IMG-PRODUCT" />

						<div class="block2-overlay trans-0-4">
							<a href="#" class="block2-btn-addwishlist hov-pointer trans-0-4">
								<i class="icon-wishlist icon_heart_alt" aria-hidden="true"></i>
								<i class="icon-wishlist icon_heart dis-none" aria-hidden="true"></i>
							</a>

							<div class="block2-btn-addcart w-size1 trans-0-4">
								<!-- Button -->
								<button type="button" onclick="addImg(3)"
									class="flex-c-m size1 bg4 bo-rad-23 hov1 s-text1 trans-0-4">
									Upload Image</button>
							</div>
						</div>
					</div>
				</div>
			</td>
		</tr>
	</Table>
</form>

</body>
</html>
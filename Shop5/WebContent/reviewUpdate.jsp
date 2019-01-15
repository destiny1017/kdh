<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%
	ReviewDTO dto = new ReviewDTO();
	String pId=request.getParameter("pId");
	ReviewDAO dao = new ReviewDAO();
	dto = dao.select(pId);
	
	%>
						
		<!-- 리뷰수정 -->
		<div class="modal fade" style="position: absolute; top: 200;" id="myModal" role="dialog">
    	<div class="modal-dialog modal-lg">
    					
      	<!-- Modal content-->
      	<div class="modal-content">
	       
        
        <div class="modal-body">
          			
			<div class="panel-group">
			<div class="panel panel-success" style="margin-top: 10px;">
				<div class="panel-heading">리뷰수정</div>
				<div class="panel-body">
					<%-- form --%>
					<form action="_reviewUpdate.jsp" ">
						<div class="form-group">
							<label class="control-label col-sm-2">pId:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="pId"
									name="pId" placeholder="번호" value="<%=pId %>">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="pwd">제목:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="review_title"
									name="review_title" placeholder="Title" value="<%=dto.getTitle() %>">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="pwd">상품명:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="review_name"
									name="review_name" placeholder="상품명" value="<%=dto.getName() %>">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="pwd">내용:</label>
							<div class="col-sm-10">
								<textarea class="form-control" rows="5"	placeholder="review_content" name="review_content" id="review_content"><%=dto.getContent() %></textarea>
							</div>
						</div>
										
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="radio">
													
									<label class="radio-inline"> <input type="radio" name="review_star" id="review_star" value="1" checked="checked">★☆☆☆☆</label>
									<label class="radio-inline"> <input type="radio" name="review_star" id="review_star" value="2">★★☆☆☆</label>
									<label class="radio-inline"> <input type="radio" name="review_star" id="review_star" value="3">★★★☆☆</label>
									<label class="radio-inline"> <input type="radio" name="review_star" id="review_star" value="4">★★★★☆</label>
									<label class="radio-inline"> <input type="radio" name="review_star" id="review_star" value="5">★★★★★</label>
									
								</div>
								</div>
								</div>
								<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-success" >수 정</button>
									<button type="reset" class="btn btn-danger">초기화</button>
								</div>
							</div>
						</form>


					</div>

				</div>
			</div>
        	</div>
        	<div class="modal-footer">
          	<button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
        	</div>
     	 	</div>
      
    		</div>
  			</div>	
	
</body>
</html>
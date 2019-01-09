<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<body>
  <script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
  <script type="text/javascript">
 
    function ajaxTest(){
    	
    	var text = document.getElementById("text").value
      $.ajax({
        type : "GET",
        url : "test.jsp?t=" + text,
        dataType : "text",
        error : function() {
          alert('통신실패!!');
        },
        success : function(data) {
          $('#Context').html(data);          
        }
      });
    }
  </script>
  
  테스트용입니다.<br>
  <input type="text" id="text">
 <button type="button" onclick='ajaxTest()'>버튼</button>이 버튼을 누르면 test.jsp의 내용을 아래쪽에 불러옵니다.
 <hr color="green">
  <div id="Context">
    test
  </div>
 <hr color="green">
  
</body>
 
</html>

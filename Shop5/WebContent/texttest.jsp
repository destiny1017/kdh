<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	function print(){
		var text = document.getElementById("text").value
		document.getElementById("btn").innerHTML = text
	}
</script>

<input type="text" id="text"><button type="button" onclick="print()" id="btn">출력</button>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>아이디/비밀번호 찾기</title>
<link href="../css/can.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url();
}

 a.white12bold:link { font-size : 12px;  color : #ffffff;  text-decoration : none; font-weight: bold;  }
 a.white12bold:visited { font-size : 12px;  color : #ffffff;  text-decoration : none; font-weight: bold;  }
 a.white12bold:active { font-size : 12px;  color : #ffffff;  text-decoration : none; font-weight: bold; }
 a.white12bold:hover { font-size :12px;  color : #ffffff;  text-decoration : none; font-weight: bold;  }
 a.grey12:link { font-size : 12px;  color : #666666;  text-decoration : none;   }
 a.grey12:visited { font-size : 12px;  color : #666666;  text-decoration : none;   }
 a.grey12:active { font-size : 12px;  color : #666666;  text-decoration : none;  }
 a.grey12:hover { font-size :12px;  color : #666666;  text-decoration : none;   }
 
 
.white12bold {
	font-size: 12px;
	font-weight: bold;
	color: #ffffff;
	line-height: 17px;
}
.grey12 {
	font-size: 12px;
	color: #666666;
	line-height: 18px;
	font-weight:normal;
}
.stitle{height:15px; color:#666666; font-size:11px; font-family:Tahoma, Verdana, MalgunGothic,"돋움", "굴림"; font-weight:bold; border-bottom:2px solid #cccccc}
.regtable {border-top:1px solid #eaeaea; margin:0 0 20px 0}
.regtable td{border-bottom:1px solid #eaeaea; padding:0 10px; font-family:Tahoma, Verdana, MalgunGothic,"돋움", "굴림"; font-size:11px;}

.bts a{display:block; background:url('/images/bts.gif') left 0; float:left; font-size:11px; font-family:Tahoma, Verdana, MalgunGothic,"돋움", "굴림"; color:#777; padding-left:6px; text-decoration:none; height:21px; cursor:pointer; margin-right:3px; overflow:hidden; margin:0 0 0 3px; text-align:center}
.bts a:hover{background:url('/images/bts.gif') left -21px; text-align:center}
.bts a span{display:block; float:left; background:url('/images/bts.gif') right 0; line-height:180%; padding-right:6px; height:21px; overflow:hidden; text-align:center}
.bts a:hover span{background:url('/images/bts.gif') right -21px; color:#000; text-align:center}
-->
</style>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td bgcolor="#999999"  style="padding:5px 10px;" class="white12bold">아이디/비밀번호 찾기</td>
	</tr>
</table>
<table width="450" border="0" cellspacing="0" cellpadding="0" class="grey12">
	<tr>
		<td style="padding:20px 0 0 0">
			<table width="420" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td style="padding:15px; border-top:2px #cccccc solid; border-right:2px #cccccc solid; border-bottom:2px #cccccc solid; border-left:2px #cccccc solid;">
						<form action="search_id.jsp">
						  <table width="380" border="0" cellspacing="0" cellpadding="0">
  							<tr>
  								<td class="stitle">아이디 찾기</td>
  							</tr>
  					  </table>
  						<table width="350" border="0" cellspacing="1" class="regtable">
  							<tr>
  								<td width="100" height="25" bgcolor="#f4f4f4">이름</td>
  								<td width="130">
  									<input type="text" name="name" id="name" tabindex="1"/>
  								</td>
  								<td rowspan="2" align="center"><div class="bts" ><input type="submit" value="아이디찾기" class="btn btn-primary btn-large btn-block">
						  </input></div></td>
  							</tr>
  							
						  </table>
						  
					  </form>
						
						

						<form action="search_pw.jsp">
  						<table width="380" border="0" cellspacing="0" cellpadding="0">
  						  <tr>
  								<td class="stitle">비밀번호 찾기</td>
  							</tr>
  						</table>
  						<table width="380" border="0" cellspacing="1" class="regtable">
  							<tr>
  								<td width="100" height="25" bgcolor="#f4f4f4">ID</td>
  								<td width="130">
  									<input type="text" name="id" id="id" tabindex="5"/>
  								</td>
  								<td rowspan="2" align="center"><div class="bts"></div></td>
  							</tr>
  							<tr>
  								<td height="25" bgcolor="#f4f4f4">tel</td>
  								<td>
  									<input type="text" name="tel" id="tel" tabindex="6"/> (숫자만입력하세요!)
  								</td>
  								<td rowspan="2" align="center"><div class="bts" ><input type="submit" value="비밀번호찾기" class="btn btn-primary btn-large btn-block"></input></div>
  								</td>
  							</tr>
  							
  						</table>
  					
            		</form>
            
            
            
					</td>
				</tr>
			</table>
			<table border="0" align="right" cellpadding="0" cellspacing="0">
				<tr>
					<td height="40" style="padding:0 13px 0 0">
						<div class="bts"><a href="login.jsp"><span style="width:50px">뒤로가기</span></a></div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>

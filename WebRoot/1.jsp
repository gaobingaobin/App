<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
  <style type="text/css">
  .file-box{ position:relative;width:340px} 
.txt{ height:22px; border:1px solid #cdcdcd; width:180px;} 
.btn{ background-color:#FFF; border:1px solid #CDCDCD;height:24px; width:70px;} 
.file{ position:absolute; top:0; right:80px; height:24px; filter:alpha(opacity:0);opacity: 0;width:260px } 
  
  
  </style>
  </head>
  
  <body>
 <div class="file-box"> 
<form action="upload.action" method="post" enctype="multipart/form-data"> 
<input type='text' name='textfield' id='textfield' class='txt' /> 
<input type='button' class='btn' value='浏览...' /> 
<input type="file" name="upload" class="file" id="fileField" size="28" onchange="document.getElementById('textfield').value=this.value" /> 
<input type="submit" name="submit" class="btn" value="上传" />${result}
 
</form> 
</div> 
  </body>
</html>

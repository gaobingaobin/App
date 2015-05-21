<%@page import="entity.Items"%>
<%@page import="dao.ItemsDAO"%>
<%@page import="dao.UserCartDAO"%>
<%@page import="entity.UserCart"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
   <link rel="stylesheet" type="text/css" href="css/usercart.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
  </head>
  <body>
 
	<h2>管理员界面</h2>
    <center>
   
    <table>
    <tr>
				<td>商品图片</td>
				<td>商品名称</td>
				<td>生产城市</td>
				<td>商品编号</td>
				<td>库存</td>
				<td>商品价格</td>
				<td>操作</td>

	</tr>
     <%
      
       ItemsDAO itemdao = new ItemsDAO();
       ArrayList<Items> list = itemdao.getAllItems();
       if(list!=null&&list.size()>0){
         for(int i=0; i<list.size(); i++){
           Items item = list.get(i);
      %>
      <form action="<%=path %>/servlet/DeleteItems?pid=<%=item.getPid() %>" method="post">
     <tr>
     <td ><a href="details.jsp?pid=<%=item.getPid()%>"><img src="images/<%=item.getPicture()%>" width="150" height="150" border="1"/></a></td>
     <td> <%=item.getName() %></td>
     <td><%=item.getCity() %></td>
     <td><%=item.getPid() %></td>
     <td><%=item.getNumber()%></td>
     <td><%=item.getPrice() %></td>
     <td><button type="submit" >删除</button></td>
     </tr>
     </form>
    <%
        }
    }
    
     %>
    
    </table>  
    </center>
  </body>
</html>

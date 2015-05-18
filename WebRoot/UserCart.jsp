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

  </head>
  
  <body>
    <center>
    <table>
    <tr>
				<td>商品图片</td>
				<td>商品名称</td>
				<td>生产城市</td>
				<td>商品编号</td>
				<td>选购数量</td>
				<td>商品总价</td>

	</tr>
     <%
       HttpSession session1 = request.getSession();
       String username = (String)session1.getAttribute("username"); 
       
       UserCartDAO usercart = new UserCartDAO();
       ArrayList<UserCart> list = usercart.getUserCartByUserName(username);
       if(list!=null&&list.size()>0){
         for(int i=0; i<list.size(); i++){
           UserCart cart = list.get(i);
      %>
     <tr>
     <td ><a href="details.jsp?pid=<%=cart.getPid()%>"><img src="images/<%=cart.getPicture()%>" width="150" height="150" border="1"/></a></td>
     <td> <%=cart.getName() %></td>
     <td><%=cart.getCity() %></td>
     <td><%=cart.getPid() %></td>
     <td><%=cart.getCount() %></td>
     <td><%=cart.getGross() %></td>
     </tr>
    <%
        }
    }
    
     %>
    
    </table>  
    </center>
  </body>
</html>

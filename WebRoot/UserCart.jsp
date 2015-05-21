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
  <%
    HttpSession session2 = request.getSession();
   %>
   <div id="current">
		<div class="navbar navbar-default" role="navigation" id="menu">
			<div class="navbar-header">
				<a href="##" class="navbar-brand">交大理工二手网</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="<%=request.getContextPath()%>/index.jsp">网站首页</a></li>

				<li><a href="##">关于我们</a></li>
			</ul>
			<form action="##" class="navbar-form navbar-left" rol="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="请输入关键词" />
					<button type="button" class="btn btn-default">搜索</button>
				</div>
			</form>
			<!-- 显示购物车和 用户名称 -->
			
      <!--  -->
		</div>
		<br><br>	
	<h2>购物车商品</h2>
    <center>
   
    <table>
    <tr>
				<td>商品图片</td>
				<td>商品名称</td>
				<td>生产城市</td>
				<td>商品编号</td>
				<td>选购数量</td>
				<td>商品总价</td>
				<td>操作</td>

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
      <form action="<%=path %>/servlet/DeleteUserGoods?pid=<%=cart.getPid() %>" method="post">
     <tr>
     <td ><a href="details.jsp?pid=<%=cart.getPid()%>"><img src="images/<%=cart.getPicture()%>" width="150" height="150" border="1"/></a></td>
     <td> <%=cart.getName() %></td>
     <td><%=cart.getCity() %></td>
     <td><%=cart.getPid() %></td>
     <td><%=cart.getCount() %></td>
     <td><%=cart.getGross() %></td>
     <td><button type="submit">删除</button></a></td>
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

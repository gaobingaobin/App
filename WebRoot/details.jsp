<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDAO"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'details.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="bootstrap/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/details.css">

</head>

<body>
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
			<form action="<%=path %>/servlet/SearchServlet"  class="navbar-form navbar-left" rol="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="请输入关键词"  name="search"/>
					<button type="submit" class="btn btn-default">搜索</button>
				</div>
			</form>
			 <% 
          HttpSession session2 = request.getSession();
     
          if(session2.getAttribute("username")==null){
          
        %>
        <ul class="nav navbar-nav">
       <li><button type="button" class="btn btn-info " id="denglu">登录</button></li>
        <li><button type="button" class="btn btn-success" id="zhuce">注册</button></li>
       </ul>
      <% 
      }
      else {
      %>
       <ul class="nav navbar-nav navbar-right" id="nav">
       <li class="dropdown" >
      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> 购物车</a>
      <ul class="dropdown-menu" role="menu">
            <li><a href="<%=request.getContextPath()%>/UserCart.jsp">查看我的购物车</a></li>       
      </ul> 
      </li> 
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><%=session2.getAttribute("username") %> <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="<%=request.getContextPath() %>/servlet/LoginOutServlet">退出</a></li> 
          </ul>
        </li>
      </ul>
      <%
      }
       %>
     </div>
		   <!--登录的弹出框 -->     
   <div class="modal" id="mymodal" tabindex="-1">
    <div class="modal-dialog">
    	<div class="modal-content">
    	<form action="<%=request.getContextPath()%>/servlet/LoginServlet" method="post">
  <div class="form-group">
    <label for="username">&nbsp;&nbsp;&nbsp;昵称</label>
    <input type="text" class="form-control" id="username" placeholder="请输入昵称" name="username">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">&nbsp;&nbsp;&nbsp;密码</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码" name="password">
  </div>
  <button type="submit" class="btn btn-default">登录</button>
</form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- 注册的弹出框 -->
    <div class="modal" id="mymodal1" tabindex="-1">
    <div class="modal-dialog">
    	<div class="modal-content">
    	<form action="<%=request.getContextPath()%>/servlet/RegisterServlet" method="post">
    	 <div class="form-group">
    <label for="username">&nbsp;&nbsp;&nbsp;昵称</label>
    <input type="text" class="form-control" id="username" placeholder="请输入您的昵称" name="username">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">&nbsp;&nbsp;&nbsp;邮箱</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="请输入邮箱地址" name="email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">&nbsp;&nbsp;&nbsp;密码</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码" name="password">
  </div>
  <div class="form-group">
    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="请再次输入密码" name="password1">
  </div>
  <button type="submit" class="btn btn-default">注册</button>
</form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- 注册的弹出框 -->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
<script src="js/common.js"> </script>

		<table>
			<tr>
				<!-- 商品详情 -->
				<%
					ItemsDAO itemDao = new ItemsDAO();
					Items item = itemDao.getItemsById(Integer.parseInt(request
							.getParameter("pid")));
					if (item != null) {
				%>
				<td width="70%" valign="top">
					<form
						action="<%=path%>/servlet/CartServlet?pid=<%=request.getParameter("pid")%>"
						method="post">
						<table>
							<tr>
								<td rowspan="4"><img src="images/<%=item.getPicture()%>"
									width="300" height="300" /></td>
							</tr>
							<tr>
								<td class="td_name"><B><%=item.getName()%></B></td>
							</tr>
							<tr>
								<td class="td_city">产地：<%=item.getCity()%></td>
							</tr>
							<tr>
								<td class="td_price">价格：<%=item.getPrice()%>￥</td>
							</tr>
							<tr>
								<td>
									<div class="input-group input-group-lg">
										<span class="input-group-addon" id="sizing-addon1">数量</span> <input
											type="text" class="form-control" placeholder="购买数量"
											aria-describedby="sizing-addon1" name="count">
									</div></td>
							</tr>
							<tr>
								<td>
									<button class="btn btn-danger btn-lg" type="submit"
										id="cartbtn">加入购物车</button></td>
							</tr>
						</table>
					</form>
				</td>
				<%
					}
				%>
				<%
					String list = "";
					//从客户端获得Cookies集合
					Cookie[] cookies = request.getCookies();
					//遍历这个Cookies集合
					if (cookies != null && cookies.length > 0) {
						for (Cookie c : cookies) {
							if (c.getName().equals("ListViewCookie")) {
								list = c.getValue();
							}
						}
					}

					list += request.getParameter("pid") + ",";
					//如果浏览记录超过1000条，清零.
					String[] arr = list.split(",");
					if (arr != null && arr.length > 0) {
						if (arr.length >= 1000) {
							list = "";
						}
					}
					Cookie cookie = new Cookie("ListViewCookie", list);
					response.addCookie(cookie);
				%>
				
				<!-- 浏览过的商品 -->
				<div class="record" >
				<td width="30%" bgcolor="#EEE" align="center" ><br> <b>您浏览过的商品</b><br>
					<!-- 循环开始 --> <%
 	ArrayList<Items> itemlist = itemDao.getViewList(list);
 	if (itemlist != null && itemlist.size() > 0) {
 		System.out.println("itemlist.size=" + itemlist.size());
 		for (Items i : itemlist) {
 %>
					<div>
						<dl>
							<dt>
								<a href="details.jsp?pid=<%=i.getPid()%>"><img
									src="images/<%=i.getPicture()%>" width="150" height="100"
									border="1" /> </a>
							</dt>
							<dd class="dd_name"><%=i.getName()%></dd>
							<dd class="dd_city">
								产地:<%=i.getCity()%>&nbsp;&nbsp;价格:<%=i.getPrice()%>
								￥
							</dd>
						</dl>
					</div>
					</div> <%
 	}
 	}
 %> <!-- 循环结束 -->
				</td>
			</tr>

		</table>

	</div>
	
</body>
</html>

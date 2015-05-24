<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>华东交大理工二手交易网站</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
	
  </head>
  
  <body>
  <div id="current">
   <div class="navbar navbar-default" role="navigation" id="menu">
  　<div class="navbar-header">
  　    <a href="##" class="navbar-brand" >交大理工二手网</a>
  　</div>
    <ul class="nav navbar-nav">
       <li class="active"><a href="<%=request.getContextPath()%>/index.jsp">网站首页</a></li> 
      <li><a href="##">关于我们</a></li>
	 </ul>
     <form action="<%=path %>/servlet/SearchServlet" class="navbar-form navbar-left" >
   	    <div class="form-group">
   		<input type="text" class="form-control" placeholder="请输入关键词" name="search" />
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
            <li><a href="#">查看我的信息</a></li> 
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
  

    <hr>
  
    <center>
    <table>
      <tr>
        <td>
          
          <!-- 商品循环开始 -->
           <% 
               ItemsDAO itemsDao = new ItemsDAO(); 
               ArrayList<Items> list = itemsDao.getAllItems();
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	                  Items item = list.get(i);
           %>   
          <div id="p1">
             <dl>
               <dt>
                 <a href="details.jsp?pid=<%=item.getPid()%>"><img src="images/<%=item.getPicture()%>" width="230" height="230" border="1"/></a>
               </dt>
               <dd class="dd_price">价格:￥ <%=item.getPrice() %></dd>
               <dd class="dd_name"><%=item.getName() %></dd> 
               <dd class="dd_city">产地:<%=item.getCity() %></dd> 
             </dl>
          </div>
          <!-- 商品循环结束 -->
        
          <%
                   }
              } 
          %>
        </td>
      </tr>
    </table>
    </center>
    </div>
  </body>
</html>
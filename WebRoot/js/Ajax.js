  var xmlHttp;
      function createXMLHttpRequest(){
          try{
              xmlHttp=new XMLHttpRequest();//非IE
          }catch(e){
              try{
                  xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");//ie6
              }catch(e){
                  try{
                      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");//IE5
                  }catch(e){
                      alert("您的浏览器版本太低，不支持ajax");
                  }
              }                  
          }
      }    
      var uname;
      var upwd;
      function login(){
          uname=document.getElementById("username").value;
          upwd=document.getElementById("password").value;
          if(uname.length==0||upwd.length==0){
              alert("用户名或密码不允许为空！");
          }else{
              doAjax();
          }
      }
      
      function doAjax(){
          createXMLHttpRequest();
          xmlHttp.open("POST","/servlet/LoginServlet",true);//是否为异步
          xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");//若用post的话需要这样配置
          xmlHttp.onreadystatechange=callBack;
          xmlHttp.send(null);
      }
    function callBack(){
        if(xmlHttp.readyState==4){
            if(xmlHttp.status==200){
                var r=xmlHttp.responseText;
                if(r==uname){
                   alter("登录成功");
                }else{
                	 alter("登录失败");
                }
            }
        }
    }
  var xmlHttp;
      function createXMLHttpRequest(){
          try{
              xmlHttp=new XMLHttpRequest();//��IE
          }catch(e){
              try{
                  xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");//ie6
              }catch(e){
                  try{
                      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");//IE5
                  }catch(e){
                      alert("����������汾̫�ͣ���֧��ajax");
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
              alert("�û��������벻����Ϊ�գ�");
          }else{
              doAjax();
          }
      }
      
      function doAjax(){
          createXMLHttpRequest();
          xmlHttp.open("POST","/servlet/LoginServlet",true);//�Ƿ�Ϊ�첽
          xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");//����post�Ļ���Ҫ��������
          xmlHttp.onreadystatechange=callBack;
          xmlHttp.send(null);
      }
    function callBack(){
        if(xmlHttp.readyState==4){
            if(xmlHttp.status==200){
                var r=xmlHttp.responseText;
                if(r==uname){
                   alter("��¼�ɹ�");
                }else{
                	 alter("��¼ʧ��");
                }
            }
        }
    }
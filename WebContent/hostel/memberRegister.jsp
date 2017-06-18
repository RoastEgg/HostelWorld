<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>


<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>memberRegister</title>

    <!-- Bootstrap -->
    <link href="hostel/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body >
    <div  style="width:100%; height:100%;" >
    <form style="align-content: center" method='POST' action="<%= response.encodeURL(request.getContextPath()+"/MemberRegisterServlet") %>">
        银行卡号：<input type="text" name="bankID">
        <br>
        输入密码：<input type="password" name="passWord">
        <br>
        确认密码：<input type="password" name="passWord2">
        <br>
      <button type="submit" class="btn btn-default">提交</button>
      <button type="reset" class="btn btn-default">取消</button>
    </form>

    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="hostel/js/bootstrap.min.js"></script>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>HostelWorld</title>

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
<%String register = response.encodeURL(request.getContextPath()+"/ShowDetailsServlet");%>
<div  style="width:100%; height:100%;" >
        <a class="btn btn-default" href="http://localhost:9080/HostelWorld/MemberRegisterServlet">会员注册</a>
        <a class="btn btn-default" href="http://localhost:9080/HostelWorld/MemberLoginServlet">会员登录</a>
        <a class="btn btn-default" href="http://localhost:9080/HostelWorld/HostelRegisterServlet">客栈注册</a>
        <a class="btn btn-default" href="http://localhost:9080/HostelWorld/HostelLoginServlet">客栈登录</a>
        <a class="btn btn-default" href="http://localhost:9080/HostelWorld/CEOLoginServlet">总经理登录</a>
        
       
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="hostel/js/bootstrap.min.js"></script>
</body>
</html>

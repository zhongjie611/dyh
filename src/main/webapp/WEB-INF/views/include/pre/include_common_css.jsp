<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript">
   var contextPath = "${ctx}";
</script>
<!--common css-->
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${ctx}/resources/soon/images/splash-icon.png">
<link rel="apple-touch-startup-image" href="${ctx}/resources/soon/images/splash-screen.png"
      media="screen and (max-device-width: 320px)"/>
<link rel="apple-touch-startup-image" href="${ctx}/resources/soon/images/splash-screen@2x.png"
      media="(max-device-width: 480px) and (-webkit-min-device-pixel-ratio: 2)"/>
<link rel="apple-touch-startup-image" sizes="640x1096" href="${ctx}/resources/soon/images/splash-screen@3x.png"/>
<link rel="apple-touch-startup-image" sizes="1024x748"
      href="${ctx}/resources/soon/images/splash/splash-screen-ipad-landscape"
      media="screen and (min-device-width : 481px) and (max-device-width : 1024px) and (orientation : landscape)"/>
<link rel="apple-touch-startup-image" sizes="768x1004"
      href="${ctx}/resources/soon/images/splash-screen-ipad-portrait.png"
      media="screen and (min-device-width : 481px) and (max-device-width : 1024px) and (orientation : portrait)"/>
<link rel="apple-touch-startup-image" sizes="1536x2008"
      href="${ctx}/resources/soon/images/splash-screen-ipad-portrait-retina.png"
      media="(device-width: 768px)	and (orientation: portrait)	and (-webkit-device-pixel-ratio: 2)"/>
<link rel="apple-touch-startup-image" sizes="1496x2048"
      href="${ctx}/resources/soon/images/splash-screen-ipad-landscape-retina.png"
      media="(device-width: 768px)	and (orientation: landscape)	and (-webkit-device-pixel-ratio: 2)"/>
<title>猿圈社区</title>
<link href="${ctx}/resources/soon/css/style.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/soon/css/framework.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/soon/css/owl.carousel.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/soon/css/owl.theme.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/soon/css/swipebox.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/soon/css/font-awesome.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/soon/css/animate.css" rel="stylesheet" type="text/css"/>




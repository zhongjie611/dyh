<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0 minimal-ui"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <%@ include file="../include/pre/include_common_css.jsp" %>
    <%@ include file="../include/pre/include_common_js.jsp" %>
</head>
<body>
<%@ include file="../include/pre/include_common_top.jsp" %>
<div class="content" id="image_list">
    <div class="decoration"></div>
    <div class="portfolio-item-full-width">
         <div style="color: #000000;">${bdqnArticle.contentHtml}</div>
        <div class="decoration"></div>
    </div>
</div>
</body>
</html>


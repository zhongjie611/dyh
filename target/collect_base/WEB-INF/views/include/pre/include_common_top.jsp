<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div>ssss<input value="${ctx}"/></div>
<div id="preloader">
      <div id="status">
            <p class="center-text">
                  正在加载...
                  <em>快慢看您的网速额,和小猿无关哦！</em>
            </p>
      </div>
</div>
<div class="navigation-header">
      <a class="deploy-navigation" href="#"><i class="fa fa-navicon"></i></a>
      <a class="close-navigation" href="#"><i class="fa fa-times"></i></a>
      <em>猿圈</em>
      <a href="contact.html"><i class="fa fa-envelope"></i></a>
</div>
<div class="navigation-header-clear"></div>
<div class="page-navigation">
      <div class="nav-logo">
            <a href="#">
                  <img src="${ctx}/resources/soon/images/logo-dark.png" alt="img">
            </a>
      </div>
      <div class="nav-clear"></div>
      <div class="nav-item">
            <a href="${ctx}/wx/bdqnArticle/index">
                  <i class="fa fa-star"></i>
                  主页
                  <i class="fa fa-angle-right"></i>
            </a>
      </div>
      <div class="nav-item">
            <a href="${ctx}/wx/bdqnArticle/toQueryBdqnArticleList?type=wangyi">
                  <i class="fa fa-home"></i>
                  挨踢新闻
                  <i class="fa fa-angle-right"></i>
            </a>
      </div>
      <div class="nav-item">
            <a href="${ctx}/wx/bdqnArticle/toQueryBdqnArticleList?type=pengfu">
                  <i class="fa fa-home"></i>
                  笑话
                  <i class="fa fa-angle-right"></i>
            </a>
      </div>
      <div class="nav-item">
            <a href="${ctx}/wx/bdqnArticle/toQueryBdqnArticleList?type=qutu">
                  <i class="fa fa-home"></i>
                  趣图
                  <i class="fa fa-angle-right"></i>
            </a>
      </div>
      <div class="nav-item">
            <a href="${ctx}/wx/bdqnArticle/toQueryBdqnArticleList?type=csdn">
                  <i class="fa fa-home"></i>
                  技术咖
                  <i class="fa fa-angle-right"></i>
            </a>
      </div>
</div>




<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0 minimal-ui"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${ctx}/resources/soon/images/splash-icon.png">
    <link rel="apple-touch-startup-image" href="${ctx}/resources/soon/images/splash-screen.png" 			media="screen and (max-device-width: 320px)" />
    <link rel="apple-touch-startup-image" href="${ctx}/resources/soon/images/splash-screen@2x.png" 		media="(max-device-width: 480px) and (-webkit-min-device-pixel-ratio: 2)" />
    <link rel="apple-touch-startup-image" sizes="640x1096" href="${ctx}/resources/soon/images/splash-screen@3x.png" />
    <link rel="apple-touch-startup-image" sizes="1024x748" href="${ctx}/resources/soon/images/splash/splash-screen-ipad-landscape" media="screen and (min-device-width : 481px) and (max-device-width : 1024px) and (orientation : landscape)" />
    <link rel="apple-touch-startup-image" sizes="768x1004" href="${ctx}/resources/soon/images/splash-screen-ipad-portrait.png" media="screen and (min-device-width : 481px) and (max-device-width : 1024px) and (orientation : portrait)" />
    <link rel="apple-touch-startup-image" sizes="1536x2008" href="${ctx}/resources/soon/images/splash-screen-ipad-portrait-retina.png"   media="(device-width: 768px)	and (orientation: portrait)	and (-webkit-device-pixel-ratio: 2)"/>
    <link rel="apple-touch-startup-image" sizes="1496x2048" href="${ctx}/resources/soon/images/splash-screen-ipad-landscape-retina.png"   media="(device-width: 768px)	and (orientation: landscape)	and (-webkit-device-pixel-ratio: 2)"/>
    <title>猿圈社区</title>
    <link href="${ctx}/resources/soon/css/style.css"     		 rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/soon/css/framework.css" 		 rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/soon/css/owl.carousel.css" 	 rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/soon/css/owl.theme.css" 		 rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/soon/css/swipebox.css"		 rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/soon/css/font-awesome.css"	 rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/soon/css/animate.css"			 rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${ctx}/resources/soon/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/resources/soon/js/jqueryui.js"></script>
    <script type="text/javascript" src="${ctx}/resources/soon/js/framework.plugins.js"></script>
    <script type="text/javascript" src="${ctx}/resources/soon/js/custom.js"></script>
</head>
<body>
<div id="preloader">
    <div id="status">
        <p class="center-text">
            Loading the content...
            <em>Loading depends on your connection speed!</em>
        </p>
    </div>
</div>
<div class="homepage-elements">
    <div class="homepage-one" data-scroll-index="0">
        <a href="#" class="homepage-logo">
            <img src="${ctx}/resources/soon/images/logo.png" alt="img">
        </a>
        <div class="homepage-decoration"></div>
        <p class="homepage-headline">
            我叫陈钟杰，来自很多中国首富的潮汕地区，比如：李嘉诚，黄光裕，马化腾。但是我跟他们比较大的区别就是他们有钱，我....。老婆说不能老说穷，所以我只能有用....替代，反正大家都懂，我是个资深码农，编程生涯涉及三大语言c，c++，java，都是全世界编程语言前几名的语言，没办法咋就是逼格高。08年毕业加班加到现在，10年咯。前途渺茫但是我依旧在努力进步。我出生揭阳，毕业前几年在惠州，这段时间在广州学习，毕竟广州java技术这块更高端点，希望能把脑子塞满满满的知识。
        </p>
        <div class="homepage-decoration"></div>
        <a href="#" class="next-homepage" data-scroll-nav="1">
            <i class="fa fa-angle-down"></i>
        </a>
    </div>

    <div class="homepage-two" data-scroll-index="1">
        <div class="homepage-navigation">
            <a href="${ctx}/wx/bdqnArticle/toQueryBdqnArticleList?type=csdn"><i class="fa fa-home"></i>修炼秘籍</a>
            <a href="${ctx}/wx/bdqnArticle/toQueryBdqnArticleList?type=wangyi"><i class="fa fa-pencil"></i>挨踢新闻</a>

            <a href="${ctx}/wx/bdqnArticle/toQueryBdqnArticleList?type=pengfu"><i class="fa fa-camera"></i>笑话</a>
            <a href="${ctx}/wx/bdqnArticle/toQueryBdqnArticleList?type=qutu"><i class="fa fa-picture-o"></i>趣图</a>
            <a href="${ctx}/wx/bdqnArticle/toQueryBdqnArticleList?type=wangyi"><i class="fa fa-video-camera"></i>企业文化</a>

            <a href="${ctx}/wx/bdqnArticle/toQueryBdqnArticleList?type=wangyi"><i class="fa fa-cogs"></i>猿圈指南</a>
        </div>
        <div class="homepage-socials">
            <a href="#"></a>
            <a href="#" data-scroll-nav="0"><i class="fa fa-angle-up"></i></a>
            <a href="#"></a>
        </div>
    </div>

</div>
<div class="homepage-overlay"></div>
<div class="homepage-background"></div>
</body>
</html>

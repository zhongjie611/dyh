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
</div>
</body>
<script type="text/javascript">
    //返回顶部
    var pageNo = 1;
    var total = 1;
    jQuery(document).ready(function () {
        queryBdqnArticlePage();
        jQuery(window).scroll(function () {
            var totalheight = parseFloat(jQuery(window).height()) + parseFloat(jQuery(window).scrollTop());     //浏览器的高度加上滚动条的高度
            if (jQuery(document).height() <= totalheight) {
                pageNo++;
                queryBdqnArticlePage();
            }
        });
    });
    function queryBdqnArticlePage() {
        jQuery.ajax({
            url: "${ctx}/wx/bdqnArticle/queryBdqnArticleList",
            data: {pageNo: pageNo,type:'${type}'},
            success: function (data) {
                total = data.pageCount;
                for (var i = 0; i < data.rows.length; i++) {
                    var bdqnArticle = data.rows[i];
                    if(bdqnArticle.type=="wangyi" || bdqnArticle.type=="csdn"){
                        var image_top = jQuery("<div class='portfolio-item-full-width'></div>");
                        var image_title = ("<h4>" + bdqnArticle.title + "</h4>");
                        var image_content =jQuery("<a href='${ctx}/wx/bdqnArticle/queryBdqnArticleDetail?bdqnArticleId="+bdqnArticle.id+"'><h4>"+bdqnArticle.title + "</h4></a>");
                        var hr=jQuery("<div class='decoration'></div>");
//                      image_top.append(image_title);
                        image_top.append(image_content);
                        image_top.append(hr);
                        jQuery("#image_list").append(image_top);
                    }else{
                        if(bdqnArticle.contentHtml!="" && bdqnArticle.contentHtml!=null){
                            var image_top = jQuery("<div class='portfolio-item-full-width'></div>");
                            var image_title = ("<h4>" + bdqnArticle.title + "</h4>");
                            var image_content =null;
                            if(bdqnArticle.type=="pengfu" || bdqnArticle.type=="qutu" ){
                                image_content=jQuery("<div>" + bdqnArticle.contentHtml + "</div>");
                            }else{
                                image_content=jQuery("<a><img class=\"responsive-image\" src=http://www.zbjuran.com/" + bdqnArticle.contentHtml + " alt=\"img\"></a>");
                            }
                            var hr=jQuery("<div class='decoration'></div>");
                            image_top.append(image_title);
                            image_top.append(image_content);
                            image_top.append(hr);
                            jQuery("#image_list").append(image_top);
                        }
                    }
                }
            }
        });
    }
</script>
</html>


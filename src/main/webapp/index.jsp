<html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${ctx}/resources/soon/js/jquery.js"></script>
<style>
    #Form2{
        background: cadetblue;
        padding: 10px;
    }

</style>
<body>
<h2>Hello World!</h2>
<div id="serverResponse"></div>
<%--<form  id="Form1" action="/dyh/uploadFile" method= "POST" enctype="multipart/form-data">--%>
<%--    <input type="file" id="myfile"   name="myfile" >--%>
<%--    &lt;%&ndash;<input type="submit"   value="upload" >&ndash;%&gt;--%>
<%--    <input type="button" onclick="onBtn()" value="upload" >--%>
<%--</form>--%>
<form  id="Form2" action="/dyh/exloadFile" method= "POST" enctype="multipart/form-data">
    <input type="file" id="exfile"   name="exfile" >
    <%--<input type="submit"   value="upload" >--%>
    <input type="button" onclick="onBtnEx()" value="上传" >
</form>

<input type="button" onclick="deletBtn()" value="删除所有" >
</body>
<script type="text/javascript">
    function onBtn() {
        var myFormData = new FormData();
        myFormData.append("myfile", $('#myfile').get(0).files[0]);

        $.ajax({
            url : "${ctx}/uploadFile",
            type : "POST",
            data : myFormData,  //对form表单进行序列化，从而将form表单中的所有参数传递到服务端。
            processData : false, // 使数据不做处理
            contentType : false, // 不要设置Content-Type请求头
            success : function(data) {
                $( '#serverResponse').html("上传成功");
                if(''!=data){
                    window.location.href = "http://www.chenzhongjie.top/"+ data;
                }
            },

            error : function(data) {
                $( '#serverResponse').html("失败");
            }
        });
    }
    function deletBtn(){
        $.ajax({
            url : "${ctx}/express/all/delete",
            processData : false, // 使数据不做处理
            contentType : false, // 不要设置Content-Type请求头
            success : function(data) {

            },

            error : function(data) {

            }
        });
    }
    function onBtnEx() {
        var myFormData1 = new FormData();
        myFormData1.append("exfile", $('#exfile').get(0).files[0]);
        $( '#serverResponse').html("正在上传...");
        $.ajax({
            url : "${ctx}/exFile",
            type : "POST",
            data : myFormData1,  //对form表单进行序列化，从而将form表单中的所有参数传递到服务端。
            processData : false, // 使数据不做处理
            contentType : false, // 不要设置Content-Type请求头
            success : function(data) {

                $( '#serverResponse').html("上传成功");
                if(''!=data){
                    window.location.href = "http://www.chenzhongjie.top/"+ data;
                }
            },

            error : function(data) {
                $( '#serverResponse').html("失败");
            }
        });
    }
</script>
</html>

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
<div id="content"></div>
<%--<form  id="Form1" action="/dyh/uploadFile" method= "POST" enctype="multipart/form-data">--%>
<%--    <input type="file" id="myfile"   name="myfile" >--%>
<%--    &lt;%&ndash;<input type="submit"   value="upload" >&ndash;%&gt;--%>
<%--    <input type="button" onclick="onBtn()" value="upload" >--%>
<%--</form>--%>

<form  id="Form3" style =" background: cadetblue;padding: 10px;"   method= "POST" enctype="multipart/form-data">
    <label>通用： </label><input type="file" id="comexfile"   name="comexfile" >
    <%--<input type="submit"   value="upload" >--%>
    <input type="button" onclick="onBtnComEx()" value="上传通用" ><br>
    <img src="${ctx}/resources/miniprogram/imgs/comm.png">
</form>
<form  id="Form2"  method= "POST" enctype="multipart/form-data">
    <label>圆通：</label><input type="file" id="exfile"   name="exfile" >
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
                    //window.location.href = "http://www.chenzhongjie.top/"+ data;


                    $( '#content').html(data);

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
                    //window.location.href = "http://www.chenzhongjie.top/"+ data;
                    var names = new Array();
                    data.forEach(item=>{names.push(item.userName)})
                    $( '#content').html(names.join(","));
                }
            },

            error : function(data) {
                $( '#serverResponse').html("失败");
            }
        });
    }
    function onBtnComEx() {
        var myFormData1 = new FormData();
        myFormData1.append("comexfile", $('#comexfile').get(0).files[0]);
        $( '#serverResponse').html("正在上传...");
        $.ajax({
            url : "${ctx}/comExFile",
            type : "POST",
            data : myFormData1,  //对form表单进行序列化，从而将form表单中的所有参数传递到服务端。
            processData : false, // 使数据不做处理
            contentType : false, // 不要设置Content-Type请求头
            success : function(data) {

                $( '#serverResponse').html("上传成功");
                if(''!=data){
                    // window.location.href = "http://www.chenzhongjie.top/"+ data;
                    var names = new Array();
                    data.forEach(item=>{names.push(item.userName)})
                    $( '#content').html(names.join(","));
                }
            },

            error : function(data) {
                $( '#serverResponse').html("失败");
            }
        });
    }

</script>
</html>

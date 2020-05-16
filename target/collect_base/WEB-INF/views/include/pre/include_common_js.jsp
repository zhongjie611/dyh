<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<input type="hidden" name="context" value="${ctx}"/>
<script>
    String.prototype.trim = function() {
        return this.replace(/^\s+/g,"").replace(/\s+$/g,"");
    }
    function ifEmptyRender(obj){
        if(obj==null || obj==""){
            return "";
        }else{
            return obj;
        }
    }
</script>
<script type="text/javascript" src="${ctx}/resources/soon/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/soon/js/jqueryui.js"></script>
<script type="text/javascript" src="${ctx}/resources/soon/js/framework.plugins.js"></script>
<script type="text/javascript" src="${ctx}/resources/soon/js/custom.js"></script>

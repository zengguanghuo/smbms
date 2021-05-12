<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 供应商添加页面</span>
        </div>
        <div class="providerAdd">
           <form id="providerForm" name="providerForm" method="post" action="proadd.do">
			<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="proCode">供应商编码：</label>
                    <input type="text" name="proCode" id="proCode" value=""> 
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label for="proName">供应商名称：</label>
                   <input type="text" name="proName" id="proName" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="proContact">联系人：</label>
                    <input type="text" name="proContact" id="proContact" value=""> 
					<font color="red"></font>

                </div>
                <div>
                    <label for="proPhone">联系电话：</label>
                    <input type="text" name="proPhone" id="proPhone" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="proAddress">联系地址：</label>
                    <input type="text" name="proAddress" id="proAddress" value=""> 
                </div>
                <div>
                    <label for="proFax">传真：</label>
                    <input type="text" name="proFax" id="proFax" value=""> 
                </div>
                <div>
                    <label for="proDesc">描述：</label>
                    <input type="text" name="proDesc" id="proDesc" value=""> 
                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存">
					<input type="button" onclick="location.href='${pageContext.request.contextPath}/provider.do'" id="back" name="back" value="返回">
                </div>
            </form>
     </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript">
    $(document).ready(function (){
        $("[name=proCode]").blur(function (){
            var procode=$("#proCode").val();
            if(procode==""){
                $(this).next().html("供应商编码不能为空！！");
            }else{
                $(this).next().html("");
            }
        })
        $("[name=proName]").blur(function (){
            var proName=$("#proName").val();
            if(proName==""){
                $(this).next().html("供应商名称不能为空！！");
            }else{
                $(this).next().html("");
            }
        })

        $("[name=proContact]").blur(function (){
            var proContact=$("#proContact").val();
            if(proContact==""){
                $(this).next().html("供应商联系人不能为空！！");
            }else{
                $(this).next().html("");
            }
        })
        $("[name=proPhone]").blur(function (){
            var proPhone=$("#proPhone").val();
            if(proPhone==""){
                $(this).next().html("供应商电话不能为空！！");
            }else{
                $(this).next().html("");
            }
        })

        $("#providerForm").submit(function () {
            $("[name=proCode]").blur();
            $("[name=proName]").blur();
            $("[name=proContact]").blur();
            $("[name=proPhone]").blur();

            var falg=true;
            $("#providerForm font").each(function (index,item){
                if($(item).html()!=""){
                    falg=false;
                }
            })
            return falg;
        })
      <%--$("#add").click(function () {--%>
      <%--    var serialize=$("#providerForm").serialize();--%>
      <%--    $("#providerForm font").each(function (index,item){--%>
      <%--        if($(item).html()==""){--%>

      <%--        }else {--%>
      <%--            $.ajax({--%>
      <%--                "url":"proadd.do",--%>
      <%--                "type":"post",--%>
      <%--                "data":serialize,--%>
      <%--                "dataType":"text",--%>
      <%--                "success":function (result) {--%>
      <%--                    console.log(result);--%>
      <%--                    if(result=="true"){--%>
      <%--                        alert("添加成功");--%>
      <%--                        location.href="${pageContext.request.contextPath}/provider.do";--%>
      <%--                    }--%>
      <%--                },--%>
      <%--                "error":function () {--%>
      <%--                    alert("添加失败");--%>

      <%--                }--%>
      <%--            })--%>
      <%--        }--%>
      <%--    })--%>

      <%--})--%>

    })
</script>

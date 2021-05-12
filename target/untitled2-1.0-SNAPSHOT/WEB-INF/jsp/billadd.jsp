<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="right">
     <div class="location">
         <strong>你现在所在的位置是:</strong>
         <span>订单管理页面 >> 订单添加页面</span>
     </div>
     <div class="providerAdd">
         <form id="billForm" name="billForm" method="post" action="">
             <!--div的class 为error是验证错误，ok是验证成功-->
             <input type="hidden" name="method" value="add">
             <div class="">
                 <label for="billCode">订单编码：</label>
                 <input type="text" name="billCode" class="text" id="billCode" value=""> 
				 <!-- 放置提示信息 -->
				 <font color="red"></font>
             </div>
             <div>
                 <label for="productName">商品名称：</label>
                 <input type="text" name="productName" id="productName" value=""> 
				 <font color="red"></font>
             </div>
             <div>
                 <label for="productUnit">商品单位：</label>
                 <input type="text" name="productUnit" id="productUnit" value=""> 
				 <font color="red"></font>
             </div>
             <div>
                 <label for="productCount">商品数量：</label>
                 <input type="text" name="productCount" id="productCount" value=""> 
				 <font color="red"></font>
             </div>
             <div>
                 <label for="totalPrice">总金额：</label>
                 <input type="text" name="totalPrice" id="totalPrice" value=""> 
				 <font color="red"></font>
             </div>
             <div>
                 <label >供应商：</label>
                 <select name="providerId" id="providerId">
                     <c:forEach items="${providerList}" var="provider">
                         <option value="${provider.id}">${provider.proName}</option>
                     </c:forEach>
		         </select>
				 <font color="red"></font>
             </div>
             <div>
                 <label >是否付款：</label>
                 <input type="radio" name="isPayment" value="1" checked="checked">未付款
				 <input type="radio" name="isPayment" value="2" >已付款
             </div>
             <div class="providerAddBtn">
                  <input type="submit" name="add" id="add" value="保存">
				  <input type="button" id="back" name="back" value="返回" >
             </div>
         </form>
     </div>
 </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script>
    $(document).ready(function () {
        $("#billCode").blur(function () {
            var billCode= $("#billCode").val();
            if(billCode==""){
                $(this).next().html("订单编码不能为空！！");
            }else{
                $.ajax({
                    "url":"setcode.do",
                    "type":"post",
                    "data":"billCode="+billCode,
                    "dataType":"text",
                    "success":function (result) {
                        console.log(result)
                        if(result=="false"){
                            $("#billCode").next().html("订单编码已被使用！！");
                        }else{
                            $("#billCode").next().html("");
                        }
                    }
                })
            }
        })
        $("#productName").blur(function () {
            var productName= $("#productName").val();
            if(productName==""){
                $(this).next().html("商品名称不能为空！！");
            }else{
                $(this).next().html("");
            }
        })
        $("#productUnit").blur(function () {
            var productUnit= $("#productUnit").val();
            if(productUnit==""){
                $(this).next().html("商品单位不能为空！！");
            }else{
                $(this).next().html("");
            }
        })
        $("#productCount").blur(function () {
            var productCount= $("#productCount").val();
            if(productCount==""){
                $(this).next().html("商品数量不能为空！！");
            }else{
                $(this).next().html("");
            }
        })
        $("#totalPrice").blur(function () {
            var totalPrice= $("#totalPrice").val();
            if(totalPrice==""){
                $(this).next().html("总金额不能为空！！");
            }else{
                $(this).next().html("");
            }
        })

        $("#billForm").submit(function () {
            $("#billCode").blur();
            $("#productName").blur();
            $("#productUnit").blur();
            $("#productCount").blur();
            $("#totalPrice").blur();
            var falg=true;
            $("#billForm font").each(function (index,item){
                if($(item).html()!=""){
                    falg=false;
                }
            })

            return falg;
        })
        $("#add").click(function () {
            var serialize = $("#billForm").serialize();
            var billCode= $("#billCode").val();
            if(billCode!=""){

                    console.log(serialize);
                    $.ajax({
                        "url":"billtj.do",
                        "type":"post",
                        "data":serialize,
                        "dataType":"text",
                        "success":function (result) {
                            console.log(result);
                            if(result=="true"){
                                alert("添加成功");
                                location.href="${pageContext.request.contextPath}/billse.do";
                            }
                        },
                        "error":function () {
                            alert("添加失败");
                        }
                    })
                }
            })


    })
</script>
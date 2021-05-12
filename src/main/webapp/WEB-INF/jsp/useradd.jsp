<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #userimg{
        position: absolute;
        bottom: 250px;
        left: 774px;
    }
</style>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form id="userForm" name="userForm" method="post" enctype="multipart/form-data" action="useraddt.do">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userCode">用户编码：</label>
                    <input type="text" name="userCode" id="userCode" value=""> 
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="userPassword">用户密码：</label>
                    <input type="password" name="userPassword" id="userPassword" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="ruserPassword">确认密码：</label>
                    <input type="password" name="ruserPassword" id="ruserPassword" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label >用户性别：</label>
					<select name="gender" id="gender">
					    <option value="1" selected="selected">男</option>
					    <option value="2">女</option>
					 </select>
                </div>
                <div>
                    <label for="birthday">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" 
					readonly="readonly" onclick="WdatePicker();">
					<font color="red"></font>
                </div>
                <div>
                    <label for="phone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="address">用户地址：</label>
                   <input name="address" id="address"  value="">
                </div>
                <div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
					<select name="userRole" id="userRole">
                        <c:forEach  items="${roles}" var="list">
                            <option value="${list.id}">${list.roleName}</option>
                        </c:forEach>

                    </select>
	        		<font color="red"></font>
                </div>
                <div>
                    <label>上传头像:</label>
                    <input type="file" name="idPicPath_1" id="idPicPath_1">
                    <img src="" id="userimg">
                    <font color="red"></font>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form>
        </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript">
    $(document).ready(function (){
        $("#idPicPath_1").change(function () {
            //获取file文件对象
            var file = $(this)[0].files[0];
            //等价于document.getElementById("pic").files[0];
            //获取一个指向该元素的地址
            var path = window.URL.createObjectURL(file);
            console.log(path);
            $("#userimg").attr('src', path);
        })


        $("#userCode").blur(function () {
            var usercode=$("#userCode").val();
            if(usercode==""){
                $(this).next().html("用户编码不能为空！！");
            }else {
               $.ajax({
                   "url":"usercode.do",
                   "type":"post",
                   "data":"userCode="+usercode,
                   "dataType":"text",
                   "success":function (result) {
                       if(result=="false"){
                           $("#userCode").next().html("用户编码已被使用！！");
                       }else{
                           $("#userCode").next().html("");
                       }
                   }
               })
            }
        })
        $("#userName").blur(function () {
            var userName=$("#userName").val();
            if(userName==""){
                $(this).next().html("用户名称不能为空！！");
            }else {
                $(this).next().html("");
            }
        })
        $("#userPassword").blur(function () {
            var userPassword=$("#userPassword").val();
            if(userPassword==""){
                $(this).next().html("用户密码不能为空！！");
            }else {
                $(this).next().html("");
            }
        })
        $("#ruserPassword").blur(function () {
            var ruserPassword=$("#ruserPassword").val();
            var userPassword=$("#userPassword").val();
            if(ruserPassword!=userPassword){
                $(this).next().html("两次密码输入不一致！！");
            }else {
                $(this).next().html("");
            }
        })
        $("#phone").blur(function () {
            var phone=$("#phone").val();
            if(phone==""){
                $(this).next().html("用户电话不能为空！！");
            }else {
                $(this).next().html("");
            }
        })
      $("#userForm").submit(function () {
          $("#userCode").blur();
          $("#userName").blur();
          $("#userPassword").blur();
          $("#ruserPassword").blur();
          $("#phone").blur();
          var falg=true;
          $("#userForm font").each(function (index,item) {
              if($(item).html()!=""){
                  falg=false;
              }
          })
          return falg;
      })

    })
</script>

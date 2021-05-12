<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>密码修改页面</span>
            </div>
            <div class="providerAdd">
                <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath}/updatepwd.do">
                    <input type="hidden" name="method" value="savepwd">
                    <!--div的class 为error是验证错误，ok是验证成功-->
                    <div class="info">${message}</div>
                    <div class="">
                        <label for="oldPassword">旧密码：</label>
                        <input type="password" name="oldpassword" id="oldpassword" value=""> 
						<font color="red"></font>
                    </div>
                    <div>
                        <label for="newPassword">新密码：</label>
                        <input type="password" name="newpassword" id="newpassword" value=""> 
						<font color="red"></font>
                    </div>
                    <div>
                        <label for="reNewPassword">确认新密码：</label>
                        <input type="password" name="rnewpassword" id="rnewpassword" value=""> 
						<font color="red"></font>
                    </div>
                    <div class="providerAddBtn">
                        <!--<a href="#">保存</a>-->
                        <input type="submit" name="save" id="save" value="保存" class="input-button">
                    </div>
                </form>
            </div>
        </div>
    </section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>

<script type="text/javascript">

        $("[name=oldpassword]").blur(function (){
            var oldpassword=$("#oldpassword").val();
            if(oldpassword==""){
                $(this).next().html("原始密码不能为空！！");
            }else{
                $.ajax({
                    "url":"checkPwd.do",
                    "type":"post",
                    "data":"oldpassword="+oldpassword,
                    "async":true,
                    "dataType":"text",
                    "success":function (result) {
                        console.log(result)
                        if(result=="false"){
                            $("[name=oldpassword]").next().html("原始密码输入有误！！");
                        }else{
                            $("[name=oldpassword]").next().html("√");
                        }
                    },
                    "error":function () {
                        alert("服务器繁忙请稍后再试")
                    }
                })
            }
        })

        $("[name=newpassword]").blur(function (){
            var newpassword=$("#newpassword").val();
            if(newpassword==""){
                $(this).next().html("新密码不能为空！！");
            }else{
                $(this).next().html("");
            }
        })
        $("[name=rnewpassword]").blur(function (){
            var newpassword=$("#newpassword").val();
            var rnewpassword=$("#rnewpassword").val();
            if(rnewpassword==""){
                $(this).next().html("请输入二次密码！！");
            }else{
                if(newpassword!=rnewpassword){
                    $(this).next().html("两次密码输入不一致！！");
                }else{
                    $(this).next().html("");
                }
            }
        })

        // $("#userForm").submit(function () {
        //     $("[name=oldpassword]").blur();
        //     $("[name=newpassword]").blur();
        //     $("[name=rnewpassword]").blur();
        //     var falg=true;
        //     $("#userForm font").each(function (index,item) {
        //         if($(item).html()!="") {
        //             falg = false;
        //         }
        //     })
        //     return falg;
        // })

</script>
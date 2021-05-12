$(document).ready(function (){
    $("[name=oldpassword]").blur(function (){
        var oldpassword=$("#oldpassword").val();
        if(oldpassword==""){
            $(this).next().html("原始密码不能为空！！");
        }else{
            $(this).next().html("");
        }
    })
    $.ajax({
        "url":"checkPwd",
        "method":"POST",
        "data":"password="+password,
        "async":false,
        "dataType":"text",
        "success":function (result){
            if(result!="true"){
                $("[name=oldpassword]").next().html("原始密码不能为空！！");
            }else {
                $("[name=oldpassword]").next().html("");
            }
        },
        "error":function () {
            alert("服务器繁忙，请稍后重试！")
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

    $("#save").submit(function () {
        $("[name=oldpassword]").blur();
        $("[name=newpassword]").blur();
        $("[name=rnewpassword]").blur();
        var falg=true;
        $("#save font").each(function (index,item) {
            if($(item).html()!=""){
                falg=false;
            }
        })
        return falg;
    })
})
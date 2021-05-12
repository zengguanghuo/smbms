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


})
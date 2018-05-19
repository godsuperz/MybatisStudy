
// 调用后台查询方法
function searchList(){
	var basePath = $("#mainForm").attr("action");
	$("#mainForm").attr("action", basePath + "list");
	$("#mainForm").submit();
}

// 调用后台单个删除方法
$(document).ready(function(){
	$("tr a").last().click(function(){
		var basePath = $("#mainForm").attr("action");
		if(confirm("确定要删除吗？")){
			$("#id").val($(this).prev().val());
			$("#mainForm").attr("action",basePath + "deleteMessage");
			$("#mainForm").submit();
		}
	});
});

// 调用后台批量删除方法
function deleteMessages(){
	if(confirm("确定要删除吗？")){
		var basePath = $("#mainForm").attr("action");
		$("#mainForm").attr("action",basePath + "deleteMessages");
		$("#mainForm").submit();
	}
}

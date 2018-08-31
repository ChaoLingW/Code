$(function() {

	/**
	 * 添加功能
	 */
	$("#btnAdd").click(function() {

		var userName = $("#UserName").val();
		var userAge = $("#UserAge").val();
		var positionNum = $("#position").val();

		if(positionNum == 0) {
			position = "程序员";
		} else if(positionNum == 1) {
			position = "设计师";
		} else {
			position = "项目经理";
		}

		//提示 姓名不能为空
		if(userName == "") {
			alert("姓名不能为空");
			return;
		}
		//提示年龄不能为空
		if(userAge == "") {
			alert("年龄不能为空");
			return;
		}

		$("tbody").append("<tr>" +
			"<td><input type='checkbox' name='check' onclick='checkAll()' /></td>" +
			"<td>" + userName + "</td>" +
			"<td>" + userAge + "</td>" +
			"<td>" + position + "</td>" +
			"<td><input type='button' class='delOne' value='删除' onclick='delOne(this)' /></td>" +
			"</tr>");
		$("#ckAll").prop("checked", false);
	});

	/**
	 * 重置功能
	 */
	$("#btnReset").click(function() {
		$("#UserName").val("");
		$("#UserAge").val("");
		$("#position").val(0);
	});

	/**
	 * 全选/全不选
	 */
	$("#ckAll").click(function() {
		$("input[name = 'check']").prop("checked", $(this).prop("checked"));
	});

	/**
	 * 删除选中的行
	 */

	$("#btnDelete").click(function() {
		var i = 0;
		$("input[name = 'check']").each(function() {
			if($(this).prop("checked")) {
				$(this).parent().parent().remove();
				i++;
			}
		});
		if(i == 0){
			alert("至少选中一行");
		}
		$("#ckAll").prop("checked", false);
	});

});

/**
 * 对某行数据删除
 */
function delOne(obj) {
	$(obj).parent().parent().remove();
}

/**
 * 如果有一个未选中，则全选按钮取消，如果全选中，全选按钮自动点上
 */
function checkAll() {
	var i = 0;
	$("input[name='check']").each(function() {
		if($(this).prop("checked")) {
			i++;
		}
	})
	if(i == $("input[name='check']").length) {
		$("#ckAll").prop("checked", true);
	} else {
		$("#ckAll").prop("checked", false);
	}
}
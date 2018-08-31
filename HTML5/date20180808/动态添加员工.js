//获取信息并将其添加到表格中
function addEmp() {

	//获取信息：姓名，年龄，职位
	var userName = document.getElementById("UserName").value;
	var userAge = document.getElementById("UserAge").value;
	var positionInfo = document.getElementById("position").value;

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

	//获取父节点
	var tbody = document.getElementsByTagName("tbody");
	//创建tr,即表格中的一行
	var tr = document.createElement("tr");

	//创建复选框
	var check = document.createElement("th");
	var checkInput = document.createElement("input");
	checkInput.setAttribute("type", "checkbox");
	//添加class便于以后的操作
	checkInput.setAttribute("name", "item");
	checkInput.checked = false;
	//添加检查事件
	checkInput.setAttribute("onclick", "checkAll()");
	//将复选框添加到tr中
	check.appendChild(checkInput);
	tr.appendChild(check);

	//添加姓名
	var name = document.createElement("th");
	var nameText = document.createTextNode(userName);
	name.appendChild(nameText);
	tr.appendChild(name);

	//添加年龄
	var age = document.createElement("th");
	var ageText = document.createTextNode(userAge);
	age.appendChild(ageText);
	tr.appendChild(age);

	//添加职位
	var position = document.createElement("th");
	//获取提交的值并对其进行转换 0=程序员 1=设计师 2=项目经理
	if(positionInfo == "0") {
		var info = "程序员";
	} else if(positionInfo == "1") {
		var info = "设计师";
	} else {
		var info = "项目经理";
	}
	var positionText = document.createTextNode(info);
	position.appendChild(positionText);
	tr.appendChild(position);

	//添加删除按钮
	var operation = document.createElement("th");
	var deleteInput = document.createElement("input");
	deleteInput.setAttribute("type", "button");
	deleteInput.setAttribute("value", "删除");
	//添加点击事件，便于删除操作
	deleteInput.setAttribute("onclick", "deleteOne(this)");
	operation.appendChild(deleteInput);
	tr.appendChild(operation);

	//将这个th（行）添加进去
	tbody[0].appendChild(tr);
	//将文本框清空
	reset();
}

//重置功能
function reset() {
	document.getElementById("UserName").value = "";
	document.getElementById("UserAge").value = "";
	document.getElementById("position").value = "0";
}

//对某一行删除
function deleteOne(obj) {
	//获取行对应的父节点
	var parent = obj.parentNode.parentNode.parentNode;
	if(confirm("确认删除吗？")) {
		//删除行
		parent.removeChild(obj.parentNode.parentNode);
	}

}

//全选/全不选
function selectAll() {
	//获取全选按钮的checked的值
	var check = document.getElementById("ckAll");
	//获取所有的复选框
	var checks = document.getElementsByName("item");
	//遍历赋值
	for(var i in checks) {
		checks[i].checked = check.checked;
	}
}

//删除选中的行
function deleteMore() {
	//获取所有的复选框
	var checks = document.getElementsByName("item");
	/*//遍历 正向删
	for(var i = 0; i < checks.length; i++){
		if(checks[i].checked == true) {
			//找到待删除行的父节点
			var parent = checks[i].parentNode.parentNode.parentNode;
			//删除行
			parent.removeChild(checks[i].parentNode.parentNode);
		}
		i--;
	}*/

	/*//反向遍历，删除更好理解
	for(var i = checks.length-1;i>=0;i--){
		if(checks[i].checked == true) {
			//找到待删除行的父节点
			var parent = checks[i].parentNode.parentNode.parentNode;
			//删除行
			parent.removeChild(checks[i].parentNode.parentNode);
		}
	}*/
	/*for(var i in checks) {
		if(checks[i].checked == true) {
			//找到待删除行的父节点
			var parent = checks[i].parentNode.parentNode.parentNode;
			//删除行
			parent.removeChild(checks[i].parentNode.parentNode);

		}
	}*/

	//不可使用for-in，for-in遍历的数组里面还存有其它的东西
	var arr = new Array(0);
	for(var i = 0; i < checks.length; i++) {
		if(checks[i].checked == true) {
			arr.push(checks[i]);
		}
	}

	if(arr.length==0){
		alert("至少选中一项");
		return;
	}

	for(var i = 0; i < arr.length; i++) {
		//将全选取消
		document.getElementById("ckAll").checked = false;
		//找到父节点
		var parent = arr[i].parentNode.parentNode.parentNode;
		//删除行
		parent.removeChild(arr[i].parentNode.parentNode);
	}
	/*for(var i = 0; i < checks.length; i++) {
		if(checks[i].checked == true) {
			var parent = checks[i].parentNode.parentNode.parentNode;
			//删除行
			parent.removeChild(checks[i].parentNode.parentNode);
		}
	}*/
	
	
	

}

//如果有一个未选中，则全选按钮取消，如果全选中，全选按钮自动点上
function checkAll() {

	var checks = document.getElementsByName("item");

	for(var i = 0; i < checks.length; i++) {
		if(!checks[i].checked) {
			document.getElementById("ckAll").checked = false;
			return;
		}
	}
	document.getElementById("ckAll").checked = true;
}
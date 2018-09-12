/**
 * 保证可以获取category.html页面中的dom元素
 */
$(function() {
	debugger;
	// 获取项目的路径，给baseURL赋值；因为common中已经定义baseURL
	baseURL = $("#baseURL").val();
	tableInit();
})

/**
 * jqgird 加载方法
 */
function tableInit() {
	// 获取table元素，调用jqGrid Ui函数
	$("#jqGrid").jqGrid({
		url : baseURL + "/category/list",	// 请求的地址
		datatype : "json",					// 服务器返回的数据类型，可以在后台指定
		mtype : "POST",						// 请求方式
		postData : {},						// 请求数据
		colModel : [						// 展示的数据 数组
			// 需要指定一列为主列 一般是把数据库表的主键设为主列
			{
				label:"分类ID",				// 分类id
				name:'categoryId',			// 数据库表中的列名
				width:50,					
				key:true					// 主列
			},
			{
				label:"分类名称",			// 分类名称
				name:'categoryName',		
				width:100
			},
			{
				label:"分类级别",			// 分类级别
				name:'level',				
				width:100,
				formatter:function(value, opt, row) {
					if (value == 1) {
						return "一级分类";
					} else if (value == 2) {
						return "二级分类";
					}
				}
			},
			{
				label:'创建时间',			// 创建时间
				name:'createTime',
				width:100
			}
		],
		viewrecords:true,		// 定义是否要显示多少行
		height:386,				// 表格的高度
		rowNum:10,				// 表格显示的行数
		rowList:[10, 30, 50],	// 表格可以改变的记录数
		rownumbers:true,		// 表格左侧新增一列
		multiselect:true,		// 是否可以的多选
		pager:"#jqGridPager",	// 分页导航设置
		jsonReader:{			// 处理后台的数据
			root:"page.rows",		// 表格数据
			page:"page.page",		// 当前页
			total:"page.pages",		// 总页数
			records:"page.records"	// 总记录数	
		},
		prmNames:{				// 提交参数
			page: "pageNum",	// 当前页
			rows: "pageSize"	// 每页显示的记录数
		}
	});
	
}
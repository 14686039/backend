$(function(){
	
	/**
	 * ********************************************************************************
	 * 加载全局参数配置信息-S
	 * ********************************************************************************
	 */
	var url = window.location.href.split("//")[0]+"//"+window.location.host+"/" + "js/global.js";
	$("body").append('<script type="text/javascript" src=\"' + url + '"></script>');
	
	
	/**
	 * ********************************************************************************
	 * 头部连接点击事件-S
	 * ********************************************************************************
	 */
	$(document).delegate("li.head-link","click",function(){
		var param=$(this).find("a")[0].hash.replace("#","");
		$("li.head-link").removeClass("active");
		$(this).addClass("active");
		
		$("input#current-header-tab").val(param);
		$("input#current-slide-menu").val("silde-nav-menu-"+param);
		$("input#current-content").val(param);
		
		$("ul.silde-show-or-hide").hide();
		$("ul#"+$("input#current-slide-menu").val()).show();
		
		//获得侧栏的导航菜单
//		$.ajax({
//			type:"get",
//			url:"/navmenu",
//			dataType: "json", 
//			data:"p="+param,
//			success:function(data){
//				//console.log(data);
//			},
//			error: function (XMLHttpRequest, textStatus, errorThrown) { 
//                alert(errorThrown); 
//			}
//		});
		
		//初始化子菜单到全局集合
		
		
		//默认触发点击子菜单第一个
		$("ul#"+$("input#current-slide-menu").val()+">li")[0].click();
		
		
		
	});
	

	/**
	 * ********************************************************************************
	 * 左侧点击子菜单导航事件-S
	 * ********************************************************************************
	 */
	$(document).delegate("ul.silde-show-or-hide>li","click",function(){
		$("li.slide-nav-menu").removeClass("active");
		$(this).addClass("active");
		
		//面包屑
		var h="<li>"+$(".head-link.active>a").html()+"</li>";
		h+="<li>"+$("ul#"+$("input#current-slide-menu").val()+">li.active>a").html().replace("<i class=\"icon-chevron-right\"></i>","")+"</li>";
		$("ul#content-breadcrumbs").html(h);
		
		//内容区域title
		$("#content-title").text($(".head-link.active>a").text()+"管理模块");

		var currentItemId=$(this).attr("id");
		if(currentItemId=='welcome'){
			welcomeFun();
		}else{
			baseFun("","",eval(currentItemId),true);
		}
		
	});
	
	/**
	 * ********************************************************************************
	 * 表单头部搜索栏聚焦和失焦样式改变-Need to Modify
	 * ********************************************************************************
	 */
	$(document).delegate("input#tab-search-input","focus",function(){
		$(this).parent().parent().css("width","200px");
	}).delegate("input#tab-search-input","blur",function(){
		$(this).parent().parent().css("width","100px");
	});

	/**
	 * ********************************************************************************
	 * 表格栏上的搜索框点击进行查询
	 * ********************************************************************************
	 */
	$(document).delegate("#tab-search-submit","click",function(){
		var search=$("#tab-search-input").val();
		var currentItemId=$("ul.silde-show-or-hide>li.active").attr("id");
		baseFun(search,1,eval(currentItemId),false);
	});
	
	/**
	 * ********************************************************************************
	 * 点击分页进行查询
	 * ********************************************************************************
	 */
	$(document).delegate("#DataTables_Table_paginate a","click",function(){
		var v=$(this).text();
		var search=$("#tab-search-input").val();
		var currentItemId=$("ul.silde-show-or-hide>li.active").attr("id");
		baseFun(search,v,eval(currentItemId),false);
	});
	
	/**
	 * ********************************************************************************
	 * 欢迎首页，静态
	 * ********************************************************************************
	 */
	var  welcomeFun=function(){
		$("#content-right").loadTemplate("../temp/welcome.temp");
	}
	
	/**
	 * ********************************************************************************
	 * 根据不同的子菜单点击，展示主体内容，使用模版和AJAX数据
	 * data为全局变量，d为后台请求返回前端的JSON数据
	 * ********************************************************************************
	 */
	var baseFun=function(search,cp,data,first){
		$.ajax({
			url:data.ajax_url,
			data:{"search":search,"currentPage":cp},
			dataType:"json",
			success:function(d,i){
				//S-渲染
				if(first){
					afterLoadTableTemp(data,d);
				}else{
					afterLoadTableTempNotFirst(data,d);
				}
				//E-渲染
			}
		});
	};
	
	/**
	 * ********************************************************************************
	 * 第一次加载完成表格基本内容加载后需要渲染的部分
	 * ********************************************************************************
	 */
	var afterLoadTableTemp=function(data,d){
		$("#content-right").loadTemplate("../temp/baseTable.temp",null,{
			success:function(){
				//头部处理
				$("thead#table-header").html(renderHeader(data.header));
				//分页处理  currentPage,totalPage,totalCount,pageShow
				$("#table-footer-page").html(renderPage(d.nowPage,d.totalPage,d.totalCount,d.pageShow));
				//表格处理
				$("#table-detail").loadTemplate(data.tr_tmp,d.result,{
					success:function(){
						if(data.open_table_edit){
							tableEdit(data);
						}
						if(data.table_data_fun!=undefined&&data.table_data_fun!=''){
							eval(data.table_data_fun);
						}
							
					}
				});
				
			},
		});
	};
	

	/**
	 * ********************************************************************************
	 * 非第一次加载完成表格基本内容加载后需要渲染的部分，此时不加载模版和渲染头部
	 * ********************************************************************************
	 */
	var afterLoadTableTempNotFirst=function(data,d){
		//分页处理  currentPage,totalPage,totalCount,pageShow
		$("#table-footer-page").html(renderPage(d.nowPage,d.totalPage,d.totalCount,d.pageShow));
		
		//表格处理
		$("#table-detail").loadTemplate(data.tr_tmp,d.result,{
			success:function(){
				if(data.open_table_edit){
					tableEdit(data);
				}
				if(data.table_data_fun!=undefined&&data.table_data_fun!=''){
					eval(data.table_data_fun);
				}
			}
		});
	};
	
	//这是一个测试回调函数
	var hello=function(){
		$(document).delegate(".belongto","click",function(){
			console.log($(this).closest("tr").attr("id"));
		});
	}
	
	/**
	 * ********************************************************************************
	 * 表格编辑功能
	 * ********************************************************************************
	 */
	var tableEdit=function(data){
		$("#DataTables_Table").Tabledit(
				{	
					url: data.tab_edit_url,
					buttons: tableButtons,
					columns: data.columns,
				    onSuccess: function(data, textStatus, jqXHR) {
				    	console.log('表格编辑成功');
				        console.log(data);
				        console.log(textStatus);
				        console.log(jqXHR);
				    },
				    onDraw: function() {

				    },
				}
		);
		
	};
	
	/**
	 * ********************************************************************************
	 * 分页功能
	 * ********************************************************************************
	 */
	var renderPage=function(currentPage,totalPage,totalCount,pageShow){
		var html='<div class="dataTables_info" id="DataTables_Table_info">当前条目 '+(1+(currentPage-1)*pageShow)+' - '+(currentPage*10>totalCount?totalCount:currentPage*10)+'  / 总条目  '+totalCount+' </div>';
		html+='<input type="hidden" id="currentPage" value="'+currentPage+'">';
		html+='<input type="hidden" id="totalPage" value="'+totalPage+'">';
		html+='<div class="dataTables_paginate paging_full_numbers" id="DataTables_Table_paginate">';
		if(currentPage==1){
			html+='<a tabindex="0" class="first paginate_button paginate_button_disabled" id="DataTables_Table_first">First</a>';
			html+='<a tabindex="0" class="previous paginate_button paginate_button_disabled" id="DataTables_Table_previous">Previous</a>';
		}else{
			html+='<a tabindex="0" class="first paginate_button" id="DataTables_Table_first">First</a>';
			html+='<a tabindex="0" class="previous paginate_button" id="DataTables_Table_previous">Previous</a>';
		}
		html+='<span>';
		var start=1,end=totalPage;
		if(totalPage>10){
			start=currentPage-5<1?1:currentPage-5;
			end=currentPage+5>totalPage?totalPage:currentPage+5;
		}
		
		for(var i=start;i<=end;i++){
			if(i==currentPage){
				html+='<a tabindex="0" class="paginate_active">'+i+'</a>';
			}else{
				html+='<a tabindex="0" class="paginate_button">'+i+'</a>';
			}
		}
		html+='</span>';
		if(currentPage==totalPage){
			html+='<a tabindex="0" class="next paginate_button paginate_button_disabled" id="DataTables_Table_next">Next</a>';
			html+='<a tabindex="0" class="last paginate_button paginate_button_disabled" id="DataTables_Table_last">Last</a>';
		}else{
			html+='<a tabindex="0" class="next paginate_button" id="DataTables_Table_next">Next</a>';
			html+='<a tabindex="0" class="last paginate_button" id="DataTables_Table_last">Last</a>';
		}
		
		html+='</div>';
		return html;
	};
	
	/**
	 * ********************************************************************************
	 * 渲染头部功能
	 * ********************************************************************************
	 */
	var renderHeader=function(headerData){
		var html='<tr role="row" style="height:35px;line-height:35px">';
		for(var i=0;i<headerData.length;i++){
			html+='<th role="columnheader" tabindex="0" aria-controls="DataTables_Table" rowspan="1" colspan="1" ><div style="font-weight:bold">'+headerData[i]+'</div></th>';
		}
		html+='</tr>';
		return html;
	}
	
	
	
	/**
	 * ********************************************************************************
	 * 初始化，网站打开点击第一个导航
	 * ********************************************************************************
	 */
	$("li.head-link")[0].click();
	
});
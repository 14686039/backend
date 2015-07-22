$(function(){
	
	//头部连接点击事件
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
	
	//左侧点击子菜单导航事件
	$(document).delegate("ul.silde-show-or-hide>li","click",function(){
		$("li.slide-nav-menu").removeClass("active");
		$(this).addClass("active");
		
		//面包屑
		var h="<li>"+$(".head-link.active>a").html()+"</li>";
		h+="<li>"+$("ul#"+$("input#current-slide-menu").val()+">li.active>a").html().replace("<i class=\"icon-chevron-right\"></i>","")+"</li>";
		$("ul#content-breadcrumbs").html(h);
		
		//内容区域title
		$("#content-title").text($(".head-link.active>a").text()+"管理模块");
		
		
		
		//根据不同的子菜单点击，展示主体内容，使用模版和AJAX数据
		$("#content-right").loadTemplate("../temp/data.temp",null,{
			success:function(){
				$("#DataTables_Table_0").Tabledit(
						{	
							url: '/navmenu',
							
							buttons: {
						        edit: {
						            class: 'btn btn-sm btn-primary',
						            html: '<span class="glyphicon glyphicon-pencil"></span> 编辑',
						            action: 'edit'
						        },
						        save:{
						        	class: 'btn btn-sm btn-primary',
						            html: '<span class="glyphicon glyphicon-pencil"></span> 保存',
						            action: 'submit'
						        },
						        delete:{
						        	class: 'btn btn-sm btn-primary',
						            html: '<span class="glyphicon glyphicon-pencil"></span> 删除',
						            action: 'delete'
						        }
						    },
							columns: {
						        identifier: [0, 'id'],
						        editable: [[1, 'name'], [2, 'addr'], [3, 'op']]
						    },
						    onSuccess: function(data, textStatus, jqXHR) {
						        console.log('onSuccess(data, textStatus, jqXHR)');
						        console.log(data);
						        console.log(textStatus);
						        console.log(jqXHR);
						    },
						    onDraw: function() {
						        console.log('onDraw()');
						    },
						}
				);
			},
		});
		
		
	});
	
	
	
	
	
	//初始化
	$("li.head-link")[0].click();
	
});

var area={
		header:["编号","名称","地址","网站","备注","上级组织"],
		columns: {
	        identifier: [0, 'areaId'],
	        editable: [[1, 'areaName'], [2, 'address'], [3, 'website'],[4,'remark']]
	    },
	    ajax_url:'/area/page.json',
	    addFun:'areaAddFun()',//新增事件名称
	    tr_tmp:'../temp/areatr.temp',
	    tab_edit_url:'/area/edit',
	    open_table_edit:true,//是否开启表格编辑
	    table_data_fun:'areaCB()'//数据加载完毕后自定义函数,可以绑定行的点击事件,新增事件模态框
};

var alliance={
		header:["编号","编码","名称","备注","区域","学校","起始","结束"],
		columns: {
	        identifier: [0, 'alliance_business_id'],
	        editable: [[1, 'alliance_business_code'], [2, 'alliance_business_name'], [3, 'remark'],[4,'areaName'],[6,'startDt'],[7,'endDt']]
	    },
	    ajax_url:'/alliance/page.json',
	    addFun:'allianceAddFun()',//新增事件名称
	    tr_tmp:'../temp/alliancetr.temp',
	    tab_edit_url:'/alliance/edit',
	    open_table_edit:true,//是否开启表格编辑
	    table_data_fun:'allianceCB()'//数据加载完毕后自定义函数,可以绑定行的点击事件,新增事件模态框
}


//school_id,area_id,school_name,school_code,parent_id,website,school_desc,address,remark
var school={
		header:["编号","区域号","学校名称","学校编码","父级","网址","描述","地址",'备注'],
		columns: {
	        identifier: [0, 'school_id'],
	        editable: [[1, 'area_id'], [2, 'school_name'], [3, 'school_code'],[4,'parent_id'],[5,'website'],[6,'school_desc'],[7,'address'],[8,'remark']]
	    },
	    ajax_url:'/school/page.json',
	    addFun:'schoolAddFun()',//新增事件名称
	    tr_tmp:'../temp/schooltr.temp',
	    tab_edit_url:'/school/edit',
	    open_table_edit:true,//是否开启表格编辑
	    table_data_fun:'schoolCB()'//数据加载完毕后自定义函数,可以绑定行的点击事件,新增事件模态框
}


/**
 * ********************************************************************************
 * 全局基本配置-表格按钮样式参数配置信息
 * ********************************************************************************
 */
var tableButtons={
        edit: {
            class: 'btn btn-sm btn-green',
            html: '<span class="icon-edit"></span>',
            action: 'edit'
        },
        save:{
        	class: 'btn btn-sm btn-blue',
            html: '<span class=" icon-save"></span>',
            action: 'submit'
        },
        delete:{
        	class: 'btn btn-sm btn-danger',
            html: '<span class="icon-remove"></span>',
            action: 'delete'
        },
        restore: {
            class: 'btn btn-sm btn-warning',
            html: '<span class=" icon-undo"></span>',
            action: 'restore'
        },
        confirm: {
            class: 'btn btn-sm btn-danger',
            html: '<span class="icon-ok"></span> '
        }
    };


	$.extend($.gritter.options, { 
	    position: 'bottom-right', // defaults to 'top-right' but can be 'bottom-left', 'bottom-right', 'top-left', 'top-right' (added in 1.7.1)
		fade_in_speed: 'medium', // how fast notifications fade in (string or int)
		fade_out_speed: 2000, // how fast the notices fade out
		time: 3000 // hang on the screen for...
	});


var transDate=function(long_date,short){
	var date = new Date(long_date);
	Y = date.getFullYear() + '-';
	M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	D = date.getDate() ;
	h = date.getHours() + ':';
	m = date.getMinutes() + ':';
	s = date.getSeconds(); 
	if(short){
		return (Y+M+D);
	}else{
		return (Y+M+D+' '+h+m+s);
	}
	
}

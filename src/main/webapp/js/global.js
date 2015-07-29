
var area={
		header:["编号","名称","地址","网站","备注","上级组织"],
		columns: {
	        identifier: [0, 'areaId'],
	        editable: [[1, 'areaName'], [2, 'address'], [3, 'website'],[4,'remark']]
	    },
	    ajax_url:'/area/query.json',
	    tr_tmp:'../temp/areatr.temp',
	    tab_edit_url:'/area/edit',
	    open_table_edit:true,//是否开启表格编辑
	    table_data_fun:'hello()'//数据加载完毕后自定义函数,可以绑定行的点击事件
};


/**
 * ********************************************************************************
 * 全局基本配置-表格按钮样式参数配置信息
 * ********************************************************************************
 */
var tableButtons={
        edit: {
            class: 'btn btn-sm btn-primary',
            html: '<span class="icon-edit"></span>',
            action: 'edit'
        },
        save:{
        	class: 'btn btn-sm btn-green',
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
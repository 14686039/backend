
var area={
		header:["编号","名称","地址","网站","备注"],
		columns: {
	        identifier: [0, 'areaId'],
	        editable: [[1, 'areaName'], [2, 'address'], [3, 'website'],[4,'remark']]
	    },
	    ajax_url:'/area/query.json',
	    tr_tmp:'../temp/areatr.temp',
	    tab_edit_url:'/navmenu'
};

var tableButtons={
        edit: {
            class: 'btn btn-sm btn-primary',
            html: '<span class="glyphicon glyphicon-pencil"></span> 编',
            action: 'edit'
        },
        save:{
        	class: 'btn btn-sm btn-primary',
            html: '<span class="glyphicon glyphicon-pencil"></span> 存',
            action: 'submit'
        },
        delete:{
        	class: 'btn btn-sm btn-primary',
            html: '<span class="glyphicon glyphicon-pencil"></span> 删',
            action: 'delete'
        }
    };
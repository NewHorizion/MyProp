jQuery(document).ready(function ()
{
var colNames = ['id', 'firstName','lastName', 'city', 'state','phoneNumber'];
var colModels = [{
	name : 'id',
	index : 'id',
	width : 100
}, {
	name : 'firstName',
	index : 'firstName',
	width : 150,
	editable : true
}, {
	name : 'lastName',
	index : 'lastName',
	width : 150,
	editable : true
}, {
	name : 'city',
	index : 'city',
	width : 80,
	editable : true
}, {
	name : 'state',
	index : 'state',
	width : 100,
	editable : true
}, {
	name : 'phoneNumber',
	index : 'phoneNumber',
	width : 80,
	editable : true
}] ;
$("#user_property").jqGrid({
	url : 'http://localhost:8080/JQueryTest/GridServlet',
	datatype : 'json',
	mtype : 'POST',
	colNames : colNames,
	colModel : colModels,
	pager : '#user_property_pager',
	rowNum : 10,
	rowList : [ 10, 20, 30 ],
	width:730,
	sortname : 'invid',
	sortorder : 'desc',
	viewrecords : true,
	gridview : true,
	caption : 'Data Report',
	jsonReader : {
		repeatitems : false,
	},
	editurl : "http://localhost:8080/JQueryTest/GridServlet"
});
jQuery("#user_property").jqGrid('navGrid', '#user_property_pager', {
	edit : true,
	add : true,
	del : true,
	search : true
});
});
				
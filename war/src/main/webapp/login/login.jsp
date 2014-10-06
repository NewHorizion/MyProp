<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <title>jqGrid Example</title>
    <script type='text/javascript' src='http://code.jquery.com/jquery-1.6.2.js'></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.js"></script>
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="http://trirand.com/blog/jqgrid/themes/ui.jqgrid.css">
    <script type='text/javascript' src="http://trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js"></script>
    <script type='text/javascript' src="http://trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js"></script>
  <style type='text/css'>
  </style>
  <script type='text/javascript'>//<![CDATA[ 
   $(window).load(function(){
    var data = [[48803, "DSK1", "", "02200220", "OPEN1"], [48769, "APPR", "", "77733337", "ENTERED1"]];
     
    $("#grid").jqGrid({
        datatype: "local",
        height: 250,
        colNames: ['Inv No', 'Thingy', 'Blank', 'Number', 'Status'],
        colModel: [{
            name: 'id',
            index: 'id',
            width: 60,
            sorttype: "int"},
        {
            name: 'thingy',
            index: 'thingy',
            width: 90,
            sorttype: "date"},
        {
            name: 'blank',
            index: 'blank',
            width: 30},
        {
            name: 'number',
            index: 'number',
            width: 80,
            sorttype: "float"},
        {
            name: 'status',
            index: 'status',
            width: 80,
            sorttype: "float"}
        ],
        caption: "Static Data Example",
        pager : '#gridPager'
        // ondblClickRow: function(rowid,iRow,iCol,e){alert('double clicked');}
    });
     
    var names = ["id", "thingy", "blank", "number", "status"];
    var mydata = [];
     
    for (var i = 0; i < data.length; i++) {
        mydata[i] = {};
        for (var j = 0; j < data[i].length; j++) {
            mydata[i][names[j]] = data[i][j];
        }
    }
    
    for (var i = 0; i <= mydata.length; i++) {
        $("#grid").jqGrid('addRowData', i + 1, mydata[i]);
    }
    
    /*
    $("#grid").jqGrid('setGridParam', {onSelectRow: function(rowid,iRow,iCol,e){alert('row clicked');}});
    */
    $("#grid").jqGrid('setGridParam', {ondblClickRow: function(rowid,iRow,iCol,e){alert('double clicked');}});
     
   });//]]>
  </script>
   
   
  <script type='text/javascript'>
   jQuery(document).ready(function () {
  
             jQuery("#projectTable").jqGrid({
                 url: "LoadJsonDataServlet?type=BS21 7RH",
                 datatype: "json",
                 jsonReader: {repeatitems: false, id: "ref"},
                 colNames:['First Name','Last Name', 'Address'],
                 colModel:[
                     {name:'firstName',index:'firstName', width:100},
                     {name:'lastName',index:'lastName', width:100},
                     {name:'address',index:'address', width:500}
                 ],
                 rowNum:20,
                 rowList:[20,60,100],
                 height:460,
                 pager: "#pagingDiv",
                 viewrecords: true,
                 caption: "Json Example"
             });
              
             $("#pcSelect").change(function(){
                 var postcode = $("#pcSelect").val();
                 jQuery("#projectTable").jqGrid(
                         "setGridParam",{
                             url:"LoadJsonDataServlet?type="+ postcode,
                             page:1})
                         .trigger("reloadGrid");
             });
         });
   
   
   
   /**
    * Code for JQuery Grid.
    */
   $(document)
           .ready(
                   function() {
                       $("#list")
                               .jqGrid(
                                       {
                                           url : 'http://localhost:8080/JQueryTest/GridServlet',
                                           datatype : 'json',
                                           mtype : 'POST',
                                           colNames : [ 'id', 'firstName',
                                                   'lastName', 'city', 'state',
                                                   'phoneNumber' ],
                                           colModel : [ {
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
                                           } ],
                                           pager : '#pager',
                                           rowNum : 10,
                                           rowList : [ 10, 20, 30 ],
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
                       jQuery("#list").jqGrid('navGrid', '#pager', {
                           edit : true,
                           add : true,
                           del : true,
                           search : true
                       });
                   });
  </script>
 </head>
 <body>
  <table id="grid"></table>
  <div id="gridPager"></div>
    <hr>
    <div>
  	<table id="list">
  	</table>
  	<div id="pager"></div>
  </div>
  <hr>
  <div>
         <div class="borderBottom" style="height:5em;">
             <div class="floatLeftDiv borderRight">
                 <div class="padding">
                     <label>Postcode:</label>
                     <select id="pcSelect">
                         <option>BS21 7RH</option>
                         <option>BS1 8QT</option>
                     </select>
                 </div>
             </div>
         </div>
         <div>
          <div style="float: left;">
              <table id="projectTable"></table>
              <div id="pagingDiv"></div>
          </div>
         </div>
  </div>
  <br/>
  <hr/>
  
 </body>
</html>
$(function() {
	function addColumnToTable(name){
		$(".added-column .table thead tr").append("<th>"+name+"</th>");
	}
	
	
	function addTableData(tableName,dataObj,tr){
		$.ajax({
			url:"/block-server/addTableData",
			type:"POST",
			data:JSON.stringify({
				tableName:tableName,
				obj:dataObj
			}),
			dataType:"json",
			contentType:"application/json",
			cache:false,
			success:function(data){
				if(data.result!=0){
					return;
				}
				dataObj.id=data.returnId;
				addDataRow(tableName,dataObj);
				tr.remove();
			},
			
			error:function(){
				alert("网络错误，请稍后再试");
			}
		});
	}
	
	function saveOrUpdateTable(object){
		$.ajax({
			url:"/block-server/addNewTable",
			type:"POST",
			data:JSON.stringify(object),
			dataType:"json",
			contentType:"application/json",
			cache:false,
			success:function(data){
				if(data.result!=0){
					return;
				}
				
				init();
			
			},
			
			error:function(){
				alert("网络错误，请稍后再试");
			}
		});
	}
	
	function showDataPanel(name){
		var tabs=$(".dataDiv ul li a");
		for(var i=0;i<tabs.length;i++){
			if(tabs[i].innerText==name){
				$(tabs[i]).tab('show')
				return true;
			}
		}
		
		return false;
	}
	
	function addNewDataPanel(name,columns,datas){
		var tab='<li role="presentation" class=""><a href="#'+name+'" aria-controls="'+name+'" role="tab" data-toggle="tab" aria-expanded="false">'+name+'</a></li>';
		$(".dataDiv ul").append(tab);
		
		
		var tabHtml=$(".newtabpanel")[0].innerHTML;
		$(".dataDiv .tab-content").append(tabHtml.replace("{name}",name));;
		$(".dataDiv ul li a[aria-controls='"+name+"']").tab('show');
		
		
		for(var i=0;i<columns.length;i++){
			$("#"+name+" table thead tr").append("<th>"+columns[i]+"</th>");
		}
		
		
		
		for(var i=0;i<datas.length;i++){
			addDataRow(name,datas[i]);
		}
		
	}
	
	var getParamValue=function(value) {
		var ptype = '';
		var url = window.location.search;
		if (url.indexOf("?") != -1) {
			var str = url.substr(1)
				strs = str.split("&");
			for (i = 0; i < strs.length; i++) {
				if ([strs[i].split("=")[0]] == value) {
					ptype = unescape(strs[i].split("=")[1]);
				}
			}
		}
		return ptype;
	}

	
	function addDataRow(name,row){
		
		var columns=$("#"+name+" th");
		var str="<tr>"
		
		for(var j=0;j<columns.length;j++){
			str+="<td>";
			if(row[columns[j].innerHTML]!=undefined){
				str+=row[columns[j].innerHTML];
			}
			str+="</td>";
		}
		
		str+="</tr>";
		
		$("#"+name+" table tbody").append(str);
		
	}
	
	function showSubPanel(panel,belong){
		$("."+panel).show();	
		if(belong){
			$("."+panel).attr("belong-id",belong);
		}
	}

	function init(){
		$.ajax({
			url:"/block-server/getAvailableDataTable",
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(data){
				if(data.result!=0){
					return;
				}
				$(".articles").empty();
				for(var i=0;i<data.list.length;i++){
					var item='<li class="chapter" data-level="1.2.'+(i+1)+'" role-id="'+data.list[i].id+'" data-path="preface/background.html"><a href="#">'+data.list[i].name+'</a></li>';
					$(".articles").append(item);
				}
				
				var tableName=getParamValue("tableName");
				if(tableName){
					loadData(tableName);
				}

			},
			error:function(){
				alert("网络错误，请稍后再试");
			}
		});
	}

	
	function loadData(name,page,pageSize,query){ 
		if(showDataPanel(name)){
			
		}else{
			$.ajax({
				url:"/block-server/loadData",
				type:"POST",
				dataType:"json",
				cache:false,
				data:JSON.stringify({
					tableName:name,
					page:1,
					pageSize:500,
					query:{}
				}),
				success:function(data){
					if(data.result!=0){
						return;
					}
					
					addNewDataPanel(name,data.columns,data.datas);
				},
				error:function(){
					alert("网络错误，请稍后再试");
				}
			});
		}
	
	}
	
	function sendExcelLoad(tableName,groupName,path){
		
		$.ajax({
			url: '/block-server/loadDataFromExcel',
			type: 'POST',
			cache: false,
			data: JSON.stringify({
					excelPath:path,
					groupName:groupName,
					tableName:tableName
				}),
			processData: false,
			contentType: false,
			success:function(data){
				if(data.result==0){
					var records=data.addDataCount;
					$(".upload-info").show();
					$(".upload-info-records").text("新增数据"+data.addDataCount+"条，修改数据"+data.modifyDataCount+"条，删除数据"+data.deleteDataCount+"条");
					$(".upload-info-columns").text("修改数据列："+data.newColumns.length+"列");
					$(".upload-info-sequence").attr("sequence",data.sequenceId);
				}else{
					console.log(data);
				}
			}
		})
	}
	
	function executeExcel(sequenceId){
		$.ajax({
			url: '/block-server/executeLoadExcelData',
			type: 'POST',
			cache: false,
			data: JSON.stringify({
					sequenceId:sequenceId
				}),
			processData: false,
			contentType: false,
			success:function(data){
				if(data.result==0){
					alert("修改完毕")
				}else{
					console.log(data);
				}
			}
		})
	}
	
	
	$(document).on("click","li.chapter",function(){
		var tableId=$(this).attr("role-id");
		if(!tableId){
			return;
		}
		
		var tableName=this.innerText;
		loadData(tableName);
	})
	
	$(document).on("click",".addrow",function(){
		var tableId=$(this).parents(".tab-pane").attr("id");
		var length=$("#"+tableId+" th").length;
		var str="<tr><td><button type=\"button\" class=\"btn btn-default add-row\">+</button></td>";
		for(var i=1;i<length;i++){
			str+="<td><input class=\"form-control\" type=\"text\"></td>"
		}
		str+="</tr>";
		$("#"+tableId+" tbody").append(str);
	})
	
	$(document).on("click",".add-row",function(){
		var tableName=$(this).parents(".tab-pane").attr("id");
		var inputs=$(this).parents("tr").find("input");
		var columnName=$(this).parents(".tab-pane").find("th");
		var obj={};
		for(var i=0;i<inputs.length;i++){
			obj[columnName[i+1].innerHTML]=inputs[i].value;
		}
		
		addTableData(tableName,obj,$(this).parents("tr"));
	})
	
	$(document).on("click",".importExcel",function(){
		var tableName=$(this).parents(".tab-pane").attr("id");
		showSubPanel("importExcelPanel",tableName);
	})
	
	

	
	$(".uploadfile").on("click",function(){
		var tableName=$(".importExcelPanel").attr("belong-id");
		
		var formData = new FormData();
		formData.append('file', $('#exampleInputFile')[0].files[0]);
		$.ajax({
			//url: 'http://localhost:8088/fileupload',
			url: 'http://www.b-bricks.cn:8088/fileupload',
			type: 'POST',
			cache: false,
			dataType:"json",
			data: formData,
			processData: false,
			contentType: false,
			success:function(data){
				//showProgress();
				sendExcelLoad(tableName,data.groupName,data.path);
			}
		})
	})
	
	
	
	$(" div.closeable-panel  div.panel  div button.closesub").on("click",function(){
		$(this).parents(".closeable-panel").hide();
	})
	
	$(document).on("click",".exportModelExcel",function(){
		var tableName=$(this).parents(".tab-pane").attr("id");
		var param={};
		$.ajax({
			url: '/block-server/getModelExcel',
			type: 'POST',
			cache: false,
			dataType:"json",
			data: JSON.stringify({
					param:param,
					tableName:tableName
				}),
			processData: false,
			contentType: false,
			success:function(data){
				//showProgress();
				window.open(data.httpPath+data.groupName+"/"+data.path);
			}
		})
		
	})
	
	$(document).on("click",".importExcelPanel .submitsub",function(){
		executeExcel($(".upload-info-sequence").attr("sequence"));
	})
	
		
	
	$(document).on("click",".exportExcel",function(){
		var tableName=$(this).parents(".tab-pane").attr("id");
		var param={};
		$.ajax({
			url: '/block-server/getDataExcel',
			type: 'POST',
			cache: false,
			dataType:"json",
			data: JSON.stringify({
					param:param,
					tableName:tableName
				}),
			processData: false,
			contentType: false,
			success:function(data){
				//showProgress();
				window.open(data.httpPath+data.groupName+"/"+data.path);
			}
		})
		
	})
	
	
		
	
	init();
	
	
})
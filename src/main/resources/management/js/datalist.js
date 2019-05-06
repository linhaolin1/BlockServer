$(function() {
	function addColumnToTable(name){
		$(".added-column .table thead tr").append("<th>"+name+"</th>");
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
				
				$(".rightbody .tablediv table tbody").empty();
				for(var i=0;i<data.list.length;i++){
					var item='<tr role-id="'+data.list[i].id+'"><td scope="row">'+data.list[i].name+'</td><td><a role-name="'+data.list[i].name+'" class="btn btn-default edit-tableColumn" role="button" href="#">编辑结构</a></td><td><a role-name="'+data.list[i].name+'" class="btn btn-default edit-table" role="button" href="#">编辑数据</a></td></tr>';
					$(".rightbody .tablediv table tbody").append(item);
				}
			
			},
			error:function(){
				alert("网络错误，请稍后再试");
			}
		});
	}

	
	function showMoreTable(name){ 
		$.ajax({
			url:"/block-server/findColumns",
			type:"POST",
			dataType:"json",
			cache:false,
			data:JSON.stringify({
				name:name
			}),
			success:function(data){
				if(data.result!=0){
					return;
				}
				
				$(".new-datatable").show();
				$("div.subpanel.new-datatable.closeable-panel > div.panel.panel-primary > div.panel-body > div.input-group > input").val(name);
				for(var i=0;i<data.columns.length;i++){
					$(".added-column .table thead tr").append("<th>"+data.columns[i]+"</th>");
				}
			
			},
			error:function(){
				alert("网络错误，请稍后再试");
			}
		});
	
	}
	
	$(".more-datatable").on("click",function(){
		$(".new-datatable").show()
	})
	
	$(" div.closeable-panel  div.panel  div button.closesub").on("click",function(){
		$(this).parents(".closeable-panel").removeAttr("belong-id");
		$(this).parents(".closeable-panel").hide();
	})
	
	$(".more-column").on("click",function(){
		$(".more-column-div").show();
	})
	
	$(".more-column-div .btn-primary").on("click",function(){
		var name=$(".column-name").val();
		if(name&&name!=''){
			addColumnToTable(name);
			var name=$(".column-name").val("");
			$(".more-column-div").hide();
		}else{
			showlog("请填写数据列名称");
		}
	})
	
	$(".more-column-div .btn-warning").on("click",function(){
		var name=$(".column-name").val("");
		$(".more-column-div").hide();
	})
	
	$(".new-datatable button.submitsub").on("click",function(){
		var argsName=$("div.subpanel.new-datatable.closeable-panel > div.panel.panel-primary > div.panel-body > div.input-group > input").val();
		argsName=filterXSS(argsName);
		
		if(!argsName||argsName==''){
			showlog("请填写数据表名称");
			return;
		}
		var tableId=$("div.subpanel.new-datatable").attr("belong-id");
		var ths=$(".added-column .table thead tr th");
		var object={};
		object.tableName=argsName;
		object.columns=[];
		object.id=tableId;
		
		for(var i=0;i<ths.length;i++){
			object.columns.push(ths[i].innerText);
		}
		
		
		saveOrUpdateTable(object);
		$(".new-datatable").hide();
		$(".added-column .table thead tr").empty();
		$("div.subpanel.new-datatable.closeable-panel > div.panel.panel-primary > div.panel-body > div.input-group > input").val("");
	})
	
	$(".new-datatable button.closesub").on("click",function(){
		$(".added-column .table thead tr").empty();
		$("div.subpanel.new-datatable.closeable-panel > div.panel.panel-primary > div.panel-body > div.input-group > input").val("");
	})
	
	$(document).on("click",".edit-table",function(){
		var name=$(this).attr("role-name")
		window.location.href="datamanager.html?tableName="+name;
	})
	
	$(document).on("click",".edit-tableColumn",function(){
		var name=$(this).attr("role-name")
		var id=$(this).parent().parent().attr("role-id");
		$(".new-datatable").attr("belong-id",id);
		showMoreTable(name);
	})
	
	
	init();
	
	
})
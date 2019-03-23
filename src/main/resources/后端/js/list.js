$(function(){
	
	$.ajax({
		url:"/block-server/getProcessList",
		type:"POST",
		dataType:"json",
		cache:false,
		success:function(data){
			if(data.result!=0){
				return;
			}
			
			for(var i=0;i<data.processes.length;i++){
				var item='<tr role-id="'+data.processes[i].id+'"><td>'+data.processes[i].id+'</td><td scope="row">'+data.processes[i].name+'</td><td>'+data.processes[i].intro+'</td><td></td><td></td><td><a class="btn btn-default" role="button" href="flowchart.html?processId='+data.processes[i].id+'">编辑</a></td></tr>';
				$(".rightbody .tablediv table tbody").append(item);
			}
		
		},
		error:function(){
			alert("网络错误，请稍后再试");
		}
	});
	 
	function saveProcess(name){
		$.ajax({
			url:"/block-server/saveProcess",
			type:"GET",
			dataType:"json",
			cache:false,
			data:{
				name:name
			},
			success:function(data){
				if(data.result!=0){
					return;
				}
				
				window.location.href="flowchart.html?processId="+data.process.id;
			
			},
			error:function(){
				alert("网络错误，请稍后再试");
			}
		});
	
	}
	
	$(".more-process").on("click",function(){
		$(".new-process").show();
		
	})
	
	$(" div.closeable-panel  div.panel  div button.closesub").on("click",function(){
		$(this).parents(".closeable-panel").hide();
	})
	
	$(".new-process button.submitsub").on("click",function(){
		var argsName=$("div.subpanel.new-process.closeable-panel > div.panel.panel-primary > div.panel-body > div.input-group > input").val();
		argsName=filterXSS(argsName);
		
		if(!argsName||argsName==''){
			showlog("请填写流程名称");
			return;
		}
		
		saveProcess(argsName);
		$(".new-process").hide();
		$("div.subpanel.new-process.closeable-panel > div.panel.panel-primary > div.panel-body > div.input-group > input").val("");
	})
	
})
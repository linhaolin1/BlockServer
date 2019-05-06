

var showlog=function(args){
	
}

var showProgress=function(data){
	
	
}

var hideProgress=function(){
	
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

var getParsedBlockId=function(idString){
	return idString.substring("flowchartWindow".length);
}

jsPlumb.ready(function () {
	
	var startBlock;
	var endBlock;
	
	//检查是否所有block可到达
	var checkAllBlockAvailable=function(){
		$.ajax({
			url:"/block-server/checkAllBlockAvailable",
			type:"get",
			beforeSend:function(){
				 showProgress();
			},
			data:{
				'processId':id
			},
			success:function(data){
				if(data.result!=0)
					return;
				 
				return data.params;
			},
			complete:function(){
				hideProgress(); 
			}
		})
		
	}
	
	
	var checkAllLineAvailable=function(){
		//后台处理
		//是否都从start起 到end结束
		//是否存在不可到达的 next
		//是否存在没有被处理的next情况
		$.ajax({
			url:"/block-server/checkAllLineAvailable",
			type:"get",
			beforeSend:function(){
				 showProgress();
			},
			data:{
				'processId':id
			},
			success:function(data){
				if(data.result!=0)
					return;
				 
				return data.params;
			},
			complete:function(){
				hideProgress(); 
			}
		})
	}
	
	var checkAllParamAvailable=function(){
		//后台处理
		
		//是否存在没定义的param
		$.ajax({
			url:"/block-server/checkAllParamAvailable",
			type:"get",
			beforeSend:function(){
				 showProgress();
			},
			data:{
				'processId':id
			},
			success:function(data){
				if(data.result!=0)
					return;
				 
				return data.params;
			},
			complete:function(){
				hideProgress(); 
			}
		})
	}

	var updateBlockPosition=function(block,pos){
		
		$.ajax({
			url:"/block-server/updateBlockPosition",
			type:"get",
			beforeSend:function(){
				 showProgress();
			},
			data:{
				'positionX':pos[0],
				'positionY':pos[1],
				'block':getParsedBlockId($(block).attr("id"))
			},
			success:function(data){
				if(data.result!=0)
					return;
				 
				// addRectDiv();
				//addThreeEndPoint();
				//addOneSourcePoint();
				
			},
			complete:function(){
				hideProgress(); 
			}
		})
		
	}
	
	var saveProcessArgs=function(argsObj){
		$.ajax({
			url:"/block-server/saveProcessArgs",
			type:"post",
			contentType:"application/json",
			beforeSend:function(){
				 showProgress();
			},
			data:JSON.stringify(argsObj),
			success:function(data){
				if(data.result!=0)
					return;
				 
				var newArgs="<button role-id=\""+data.id+"\"  name=\""+argsObj.name+"\" role=\""+argsObj.isNecessary+"\" complex=\""+argsObj.complex+"\" mutitype=\""+argsObj.mutitype+"\" class=\"btn btn-primary\" type=\"button\">"+argsObj.name+" <span class=\"badge\">&times;</span></button>";
				$(argsObj.belong+" > div > button:last").before(newArgs);
				if(data.complex){
					for(var i=0;i<data.complex.length;i++){
						argsComplex.push(data.complex[i]);
					}
				}
		
				// addRectDiv();
				//addThreeEndPoint();
				//addOneSourcePoint();
				
			},
			complete:function(){
				hideProgress(); 
			}
		})
	}
	
	var deleteProcessArgs=function(id){
		$.ajax({
			url:"/block-server/deleteProcessArgs",
			type:"post",
			contentType:"application/json",
			beforeSend:function(){
				 showProgress();
			},
			data:JSON.stringify({
				id:id
			}),
			success:function(data){
				if(data.result!=0)
					return;
				 
				// addRectDiv();
				//addThreeEndPoint();
				//addOneSourcePoint();
				
			},
			complete:function(){
				hideProgress(); 
			}
		})
	}
		
	var findAvailableLine=function(sourceBlock,targetBlock,line,mainLine){
		

		var nexts=getNextByBlock(sourceBlock);
		for(var i in nexts){
			var newLine=line.slice(0);
			if(nexts[i].targetId=="flowchartWindow"+endBlock){
				return;
			}
			
			if(nexts[i].targetId=="flowchartWindow"+targetBlock){
				mainLine.push(newLine);
				return ;
			}
			newLine.push[nexts[i].targetId];
			findAvailableLine(nexts[i].targetId,targetBlock,newLine,mainLine)
		}
		
		
	}
	
	var getNextByBlock=function(block){
		var cons=instance.getConnections("*");
		var array=[];
		for(var i=0;i<cons.length;i++){
			var con=cons[i];
			if(con.sourceId=="flowchartWindow"+block){
				array.push(con);
			}
		}
		return array; 	
	}
	
	var getAvailableParam=function(blockId,executeId,dom){
		if(!blockId)
			return;
		
		
		var lines=[];
		//findAvailableLine(startBlock,blockId,[startBlock],lines);
		var params=[];

		
		$.ajax({
			url:"/block-server/getParamByBlocks",
			type:"post",
			beforeSend:function(){
				 showProgress();
			},
			data:JSON.stringify({
				blocks:lines,
				processId:getParamValue("processId")
			}),
			success:function(data){
				if(data.result!=0)
					return;
				
				//addParamToChoosePro?
				
				var position=$(dom).position();
				var newchoose=$(".choose-properties").clone();
				$(dom).after(newchoose);
				newchoose.css("top",$(dom).height()+15);
				newchoose.css("left",position.left);
				newchoose.show();
				
			},
			complete:function(){
				hideProgress(); 
			}
		})
	}	
	
	var addBlock=function(i,name,left,top){
	   // addRectDiv();
		//addThreeEndPoint();
		//addOneSourcePoint();
		$("#canvas").append('<div class=\"window jtk-node dropdown\" id=\"flowchartWindow'+ i +'\" block-id="'+i+'">  <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">'+name+' <span class=\"caret\"></span></a>  <ul class=\"dropdown-menu\" aria-labelledby=\"dropdownMenu1\"><li role=\"separator\" class=\"divider\"></li><li class=\"more-plugin\"><a href=\"javascript:(0)\" class=\"label\">+</a></li>  </ul> </div>')
		if(left&&top){
			$("#flowchartWindow"+i).css("left",left).css("top",top);
		}
		addEndPoint(i);
		instance.draggable($(".flowchart-demo .window"), { 
			grid: [20, 20],
			drag:function(){
				//console.log(233);
			},
			stop:function(e){
				updateBlockPosition(e.el,e.finalPos);
			}
		});
	}
	
	var saveOrUpdateBlock=function(name,blockId){
		
		$.ajax({
			url:"/block-server/saveOrUpdateBlock",
			type:"get",
			beforeSend:function(){
				 showProgress();
			},
			data:{
				'process':getParamValue("processId"),
				'name':name,
				'block':blockId
			},
			success:function(data){
				if(data.result!=0)
					return;
				 
				// addRectDiv();
				//addThreeEndPoint();
				//addOneSourcePoint();
				if(!blockId){
					addBlock(data.block.id,name);
				}else{
					$("#flowchartWindow"+blockId).children("a").text(name);
				}
			},
			complete:function(){
				hideProgress(); 
			}
		})
	}
	
	
	var saveExecute=function(blockId,methodId,executeName){
		$.ajax({
			url:"/block-server/saveExecute",
			type:"get",
			beforeSend:function(){
				 showProgress();
			},
			data:{
				'blockId':blockId,
				'executeName':executeName,
				'methodId':methodId
			},
			success:function(data){
				if(data.result!=0)
					return;
				 
				var executeString="<li method-id=\""+methodId+"\" execute-id=\""+data.executeId+"\" ><a href=\"javascript:(0)\">"+executeName+"<button type=\"button\" class=\"close close-execute\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">×</span></button></a></li>"
				$("#flowchartWindow"+blockId+" ul li.more-plugin").before(executeString);
			},
			complete:function(){
				hideProgress(); 
			}
		});
	}
	
	var saveExecuteParam=function(){
		var blockId=$(".right .rightmain").attr("block-id");
		var executeId=$(".right .rightmain").attr("execute-id");
		var methodId=$(".right .rightmain").attr("method-id");
		var paramsInput=$(".right .rightmain .param-group input");
		var param={};
		var param2=[];
		for(var i in paramsInput){
			if(!paramsInput[i].value)
				continue;
			
			var obj={};
			obj.name=paramsInput[i].name;
			obj.value=encodeURIComponent(paramsInput[i].value);
			obj.fieldName=$(paramsInput[i]).attr("fieldName");
			obj.type=$(paramsInput[i]).attr("args-type");
			param2.push(obj);
		}
		
		param.executeId=executeId;
		param.params=param2;
		
		$.ajax({
			url:"/block-server/saveExecuteParam",
			type:"post",
			contentType:"application/json",
			beforeSend:function(){
				 showProgress();	
			},
			data:JSON.stringify(param),
			success:function(data){
				if(data.result!=0)
					return;
				else{
					getPluginParams(blockId,executeId,methodId);
					
				}
			},
			complete:function(){
				hideProgress(); 
			}
		});
	}
		

	var getPluginList=function(type){
		$.ajax({
			url:"/block-server/getAvailablePlugins",
			type:"post",
			data:{
				'type':type
			},
			beforeSend:function(){
				 showProgress();
			},
			success:function(data){
				if(data.result!=0)
					return;
				$(".singleplugin").remove();
				
				 var list=data.list;
				 for(var i in list){
					var pluginString="<div class=\"singleplugin\" plugin-id=\""+list[i].id+"\"><label for=\"input\" class=\"col-sm-2 control-label\">"+list[i].name+"</label><div class=\"plugin-method\">";
					
					for(var m in list[i].methods){
						 pluginString+="<div class='btn-group' role='group'  aria-label=''><button type='button' method-id='"+list[i].methods[m].id+"' class='btn btn-primary'>"+list[i].methods[m].name+"</button></div>"
					}
					
					pluginString+="</div></div>";
					$(".plugin-panel .panel-body > .panelContent .paneltype"+list[i].type+" .plugins").append(pluginString);
				 }
			},
			complete:function(){
				hideProgress(); 
			}
		});
	}
	
	/**
	var getPluginMethodList=function(){
		$.ajax({
			url:"/block-server/getPluginMethod",
			type:"post",
			data:{
				//'pluginId':pluginId
			},
			beforeSend:function(){
				 showProgress();
			},
			success:function(data){
				if(data.result!=0)
					return;
				 var list=data.list;
				 for(var i in list){
					 var pluginString="<div class=\"singleplugin\" plugin-id=\""+list[i].id+"\"><a href=\"javcascript:(0)\">"+list[i].name+"</a><div class=\"pluginintro hide\"></div></div>";
					 $(".plugin-panel .panel-body > .panelContent .paneltype"+list[i].type+" .plugins").append(pluginString);
				 }
			},
			complete:function(){
				hideProgress(); 
			}
		});
	}
	*/
	var availableParam={};
	
	
	
	var getPluginParams=function(blockId,executeId,methodId){
		$.ajax({
			url:"/block-server/getExecuteParams",
			method:"get",
			data:{
				'executeId':executeId,
				'methodId':methodId
			},
			beforeSend:function(){
				 showProgress();
			 },
			success:function(data){
				if(data.result!=0)
					return;
				
				$(".right .rightmain").attr("block-id",blockId);
				$(".right .rightmain").attr("execute-id",executeId);
				$(".right .rightmain").attr("method-id",methodId);
				$(".right .rightmain .input-group").remove();
				
				$(".rightmain h3").text(data.method.name);
				$(".rightmain > span").text(data.plugin.name);
				$(".rightmain h5").text(data.methodIntroduce);
				
				if(data.params){
					var list=data.params.input;
					for(var i in list){
						var single=list[i];
						if(single.optional&&single.optional.length>0){
							availableParam[executeId]={};
							availableParam[executeId][single.name]=single.optional;
							
						}
						
						var paramsString="<div class=\"input-group default-param param-group\"><span class=\"input-group-addon\" >"+list[i].displayName+"</span><input type=\"text\" class=\"form-control show-choose-pro\" placeholder=\""+list[i].displayName+"\" fieldName=\""+list[i].fieldName+"\" aria-describedby=\"basic-addon1\" args-type=\"0\" name=\""+list[i].name+"\" ></div>";
						$(".right .rightmain .output-intro").before(paramsString)
					}
					
					list=data.params.output;
					for(var i in list){
						var single=list[i];
						if(single.optional&&single.optional.length>0){
							availableParam[executeId]={};
							availableParam[executeId][single.name]=single.optional;
							
						}
						
						var paramsString="<div class=\"input-group default-param param-group\"><span class=\"input-group-addon\" >"+list[i].displayName+"</span><input type=\"text\" class=\"form-control show-choose-pro\" placeholder=\""+list[i].displayName+"\" fieldName=\""+list[i].fieldName+"\" aria-describedby=\"basic-addon1\" args-type=\"1\" name=\""+list[i].name+"\" ></div>";
						$(".right .rightmain .saveargs").before(paramsString)
					}
				}
				
		
				for(var i in data.executeParams){
					$(".right .rightmain .param-group input[name='"+data.executeParams[i].pluginMethodParam+"']").val(data.executeParams[i].param);
				}
				
				var paramsInput=$(".default-param input");
				var param={};
				for(var i=0;i<paramsInput.length;i++){
					if(!paramsInput[i].value)
						continue;
					
					param[paramsInput[i].name]=paramsInput[i].value;
					
					//eval("param."+paramsInput[i].name+"=\""+paramsInput[i].value+"\"");
				}
				
				getExecuteVariableParams(executeId,param);
				
				
				
			},
			complete:function(){
				hideProgress();
			}
		})
	}
	
	var getExecuteParam=function(executeId){
	
	
	}
	
	
	var getExecuteVariableParams=function(executeId,params){
		var json={};
		json.executeId=executeId;
		json.params=params;
		
		$.ajax({
			url:"/block-server/getExecuteVariableParams",
			method:"post",
			data:JSON.stringify(json),
			beforeSend:function(){
				 showProgress();
			},
			success:function(data){
				if(data.result!=0)
					return;
				
				$(".right .rightmain .variable-param").remove();
				var list=data.inArgs;
				for(var i in list){
					var paramsString="<div class=\"input-group variable-param param-group\"><span class=\"input-group-addon\" >"+list[i].displayName+"</span><input type=\"text\" class=\"form-control show-choose-pro\" placeholder=\""+list[i].displayName+"\" fieldName=\""+list[i].fieldName+"\" aria-describedby=\"basic-addon1\" args-type=\"0\" name=\""+list[i].displayName+"\" ></div>";
					$(".right .rightmain .output-intro").before(paramsString)
				}
				
				list=data.outArgs;
				for(var i in list){
					var paramsString="<div class=\"input-group variable-param param-group\"><span class=\"input-group-addon\" >"+list[i].displayName+"</span><input type=\"text\" class=\"form-control show-choose-pro\" placeholder=\""+list[i].displayName+"\" fieldName=\""+list[i].fieldName+"\" aria-describedby=\"basic-addon1\" args-type=\"1\" name=\""+list[i].displayName+"\" ></div>";
					$(".right .rightmain .saveargs").before(paramsString)
				}
				var executeParams=data.executeParams;
				for(var i in executeParams){
					$(".right .rightmain .param-group").not(".default-param").find("input[fieldName='"+executeParams[i].fieldName+"'][name='"+executeParams[i].pluginMethodParam+"']").val(executeParams[i].param);
				}
				
				if($(".rightmain").height()>700){
					$(".jtk-demo-canvas").height($(".rightmain").height());
				}else{
					$(".jtk-demo-canvas").height(700);
				}
				
				
			},
			 complete:function(){
				 hideProgress();
			 }	
		})
	}
	
	var deleteExecute=function(executeId){
		$.ajax({
			url:"/block-server/deleteExecute",
			method:"post",
			contentType:"application/json",
			data:JSON.stringify({
				executeId:executeId
			}),
			dataType:"json",
			beforeSend:function(){
				 showProgress();
			},
			success:function(data){
				if(data.result==0){
					$("li[execute-id='"+executeId+"']").remove();
					
					//window.location.href='list.html'
				}
			}
		});
	}
	
	var updateProcess=function(){
		var json={};
		json.name=$(".propertiesmain input").val();
		json.intro=$("textarea.process-intro").val();
		json.processId=getParamValue("processId");
		
		/**
		json.inArgs=[];
		json.outArgs=[];
		var inArgs=$(".process-in-args button:not(.moreArgs)");
		var outArgs=$(".process-out-args button:not(.moreArgs)");
		for(var i=0;i<inArgs.length;i++){
			var item={};
			item.id=$(inArgs[i]).attr("role-id");
			item.name=$(inArgs[i]).attr("name");
			item.type=0;
			item.process=json.processId;
			item.necessary=$(inArgs[i]).attr("role");
			json.inArgs.push(item);
		}
		
		for(var i=0;i<outArgs.length;i++){
			var item={};
			item.id=$(outArgs[i]).attr("role-id");
			item.name=$(outArgs[i]).attr("name");
			item.type=1;
			item.process=json.processId;
			item.necessary=$(outArgs[i]).attr("role");
			json.outArgs.push(item);
		}
		*/
		
		
		$.ajax({
			url:"/block-server/updateProcess",
			method:"post",
			contentType:"application/json",
			data:JSON.stringify(json),
			dataType:"json",
			beforeSend:function(){
				 showProgress();
			},
			success:function(data){
				if(data.result==0){
					console.log("saved")
					//window.location.href='list.html'
				}
			}
		});
	
	}
	
	var argsComplex=[];
	
	var getProcess=function(){
		$.ajax({
			url:"/block-server/getProcess",
			method:"get",
			data:{ 
				'id':getParamValue("processId")
			},
			async:'false',
			beforeSend:function(){
				 showProgress();
			},
			success:function(data){
				if(data.result!=0)
					return;
				
				startBlock=data.process.startBlock;
				endBlock=data.process.endBlock;
				
				$(".propertiesmain input").val(data.process.name);
				$("textarea.process-intro").val(data.process.intro);
				for(var i=0;i<data.blocks.length;i++){
					addBlock(data.blocks[i].id,data.blocks[i].name,data.blocks[i].positionX,data.blocks[i].positionY);
				}
				
				for(var i=0;i<data.next.length;i++){
					var tempConnection=instance.connect({uuids: ["Window"+data.next[i].block+"BottomCenter", "Window"+data.next[i].value+"TopCenter"],editable: true});
					tempConnection.getOverlay("label").setLabel(""+data.next[i].name+"");
					tempConnection.next=data.next[i].id;
					tempConnection.condition=data.next[i].condition;
				}
				
				for(var i=0;i<data.execute.length;i++){
					var executeString="<li method-id=\""+data.execute[i].method+"\" execute-id=\""+data.execute[i].id+"\" ><a href=\"javascript:(0)\">"+data.execute[i].executeName+"<button type=\"button\" class=\"close close-execute\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">×</span></button></a></li>"
					$("#flowchartWindow"+data.execute[i].block+" ul li.more-plugin").before(executeString);
				}
					
				for(var i=0;i<data.args.length;i++){
					if(data.args[i].type==0){
						var newArgs="<button role-id=\""+data.args[i].id+"\" name=\""+data.args[i].name+"\" role=\""+data.args[i].necessary+"\" complex=\""+data.args[i].complex+"\" mutitype=\""+data.args[i].mutitype+"\" class=\"btn btn-primary\" type=\"button\">"+data.args[i].name+" <span class=\"badge\">&times;</span></button>";
						$(".process-in-args > div > button:last").before(newArgs);
					}else{
						var newArgs="<button role-id=\""+data.args[i].id+"\" name=\""+data.args[i].name+"\" role=\""+data.args[i].necessary+"\" complex=\""+data.args[i].complex+"\" mutitype=\""+data.args[i].mutitype+"\" class=\"btn btn-primary\" type=\"button\">"+data.args[i].name+" <span class=\"badge\">&times;</span></button>";
						$(".process-out-args > div > button:last").before(newArgs);
					}
				}
				
				argsComplex=data.complex;
		

			},
			complete:function(){
				addConnectionEvent();
				hideProgress();
				getPluginList();
			}	
		})
		
	}
	
	var showNewArgs=function(dom){
		$("div.subpanel.new-args").attr("args-id",$(dom).attr("role-id"));
		$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > input").val($(dom).attr("name"));
		$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > .args-necessary.input-group-btn > button").attr("role",$(dom).attr("role"))
		$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > .args-complex.input-group-btn > button").attr("role",$(dom).attr("complex"))
		$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > .args-mutitype.input-group-btn > button").attr("role",$(dom).attr("mutitype"))
		
		if($(dom).attr("role")==0){
			$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > .args-necessary.input-group-btn > button").text("必填");
		}else{
			$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > .args-necessary.input-group-btn > button").text("非必填");
		}
		
		if($(dom).attr("complex")==0){
			$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > .args-complex.input-group-btn > button").text("普通");
		}else{
			$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > .args-complex.input-group-btn > button").text("复杂");
		}
		
		if($(dom).attr("mutitype")==0){
			$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > .args-mutitype.input-group-btn > button").text("单个");
		}else{
			$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > .args-mutitype.input-group-btn > button").text("多个");
		}
		
		
		if($(dom).attr("complex")==1){
			$(".added-column").show();
			for(var i=0;i<argsComplex.length;i++){
				if(argsComplex[i].argument==$(dom).attr("role-id")){
					addColumnToTable(argsComplex[i].name);
				}
			}	
		}
	}
	
	$(document).on("click",".close-execute",function(event){
		var executeId=$(this).parent().parent().attr("execute-id");
		deleteExecute(executeId);
		event.stopPropagation();
	})
	
	$(document).on("click",".process-in-args button:not(.moreArgs) ",function(){
		showSubPanel("new-args",".process-in-args");
		showNewArgs(this);
	}) 
	
	$(document).on("click",".process-out-args button:not(.moreArgs) ",function(){
		showSubPanel("new-args",".process-out-args");
		showNewArgs(this);
	}) 
	
	
	$(document).on("mouseover",".window.jtk-node.dropdown",function(){
		$(this).css("opacity",1);
		$(this).css("z-index",23);
	})
	
	
	$(document).on("mouseout",".window.jtk-node.dropdown",function(){
		$(this).css("opacity","");
		$(this).css("z-index","");
	})
	
	$(document).on("blur",".window.jtk-node.dropdown",function(){
		$(this).css("opacity","");
		$(this).css("z-index","");
	})
	
	var redirectNext=function(nextId,from,to){
		var data={};
		data.from=from;
		data.to=to;
		if(nextId){
			data.nextId=nextId;
		}
		$.ajax({
			url:"/block-server/redirectNext",
			method:"post",
			data:JSON.stringify(data),
			async:'false',
			beforeSend:function(){
				 showProgress();
			},
			success:function(data){ 
				if(data.result!=0)
					return;
				
			},
			complete:function(){
				addConnectionEvent();
				hideProgress();
			}	
		})
		
	}
	
	var saveNext=function(conId,nextId,name,condition,from,to){
		var data={};
		data.name=name;
		data.condition=condition;
		data.from=from;
		data.to=to;
		if(nextId){
			data.nextId=nextId;
		}
		$.ajax({
			url:"/block-server/saveNext",
			method:"post",
			data:JSON.stringify(data),
			async:'false',
			beforeSend:function(){
				 showProgress();
			},
			success:function(data){ 
				if(data.result!=0)
					return;
				
			},
			complete:function(){
				addConnectionEvent();
				hideProgress();
			}	
		})
	}
	
	var deleteNext=function(nextId){
		$.ajax({
			url:"/block-server/deleteNext",
			method:"get",
			data:{
				nextId:nextId
			},
			async:'false',
			beforeSend:function(){
				 showProgress();
			},
			success:function(data){ 
				if(data.result!=0)
					return;
				
			},
			complete:function(){
				addConnectionEvent();
				hideProgress();
			}	
		})
	}
	
	
	var showSubPanel=function(panel,belong){
		$("."+panel).show();	
		if(belong){
			$("."+panel).attr("belong-id",belong);
		}
	}
	
	var addColumnToTable=function(name){
		$(".added-column .table thead tr").append("<th>"+name+"</th>");
	}
	
	var condition=2;
	var i=7;
	$(document).on("click",".more-block",function(){
		$(".new-block").show();
	})
	
	$(document).on("dblclick",".flowchart-demo .window",function(){
		showSubPanel("new-block",getParsedBlockId($(this).attr("id")));
		$("div.subpanel.new-block > div.panel > div.panel-body > div.input-group > input").val($(this).children("a").text());
	})
	
	$(".save-process").on("click",function(){
		updateProcess();
	})
	
	var addMoreCondition=function(i){
		var newCondition="<div class=\"row condition-row\"><div class=\"col-lg-12\"><div class=\"input-group\"><span class=\"input-group-addon\">条件"+i+"</span><input type=\"text\" class=\"form-control show-choose-pro\" aria-label=\"...\"><div class=\"input-group-btn\"><button type=\"button\" class=\"btn btn-default dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\" compare=\"=\">=<span class=\"caret\"></span></button><ul class=\"dropdown-menu dropdown-menu-right\"><li><a href=\"javascript:(0)\" compare=\"=\">=</a></li><li><a href=\"javascript:(0)\" compare=\">\">></a></li><li><a href=\"javascript:(0)\" compare=\"<\"><</a></li><li><a href=\"javascript:(0)\" compare=\">=\">>=</a></li><li><a href=\"javascript:(0)\" compare=\"<=\"><=</a></li><li><a href=\"javascript:(0)\" compare=\"<>\">不等于</a></li><li><a href=\"javascript:(0)\" compare=\"like\">包含</a></li><li><a href=\"javascript:(0)\" compare=\"not like\">不包含</a></li><li><a href=\"javascript:(0)\" compare=\"pattern\">匹配正则表达式</a></li></ul></div><!-- /btn-group --><input type=\"text\" class=\"form-control show-choose-pro\" aria-label=\"...\"></div><!-- /input-group --></div><!-- /input-group --></div>";
				
		$("body > div.subpanel.new-next > div.panel.panel-info > div.panel-body .condition-row").last().after(newCondition);
	}
	
	$(document).on("click","#canvas ul > li:not(.more-plugin)",function(){
		getPluginParams($(this).parents("div.window.jtk-node.dropdown").attr("block-id"),$(this).attr("execute-id"),$(this).attr("method-id"));
	}) 
	
	$(".saveargs").on("click",function(){
		saveExecuteParam();
	})
	
	
	$(document).on("blur",".default-param",function(){
		//if plugin type==variable
		var blockId=$(".right .rightmain").attr("block-id");
		var executeId=$(".right .rightmain").attr("execute-id");
		var paramsInput=$(".default-param input");
		var param={};
		for(var i=0;i<paramsInput.length;i++){
			if(!paramsInput[i].value)
				continue;
			
			param[paramsInput[i].name]=paramsInput[i].value;
		}
		
		getExecuteVariableParams(executeId,param);
	})
	
	
	$(".more-column").on("click",function(){
		$(".more-column-div").show();
	})
	
	$(".args-complex li").on("click",function(){
		if($(this).attr("role")=='0'){
			$(".added-column").hide();
		}else{
			$(".added-column").show();
		}
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
	
	
	
	
	$(document).on("click",".singleplugin",function(){
		var blockId=$(".plugin-panel").attr("belong-id");
		
	})
	
	$(".more-condition").on("click",function(){
		addMoreCondition(condition++);
	})
	
	$(".process-in-args .moreArgs").on("click",function(){
		showSubPanel("new-args",".process-in-args");
		
	})
	
	$(".process-out-args .moreArgs").on("click",function(){
		showSubPanel("new-args",".process-out-args");
	})
	
	$(document).on("click",".process-in-args button:not(.moreArgs) > span",function(event){
		$(this).parent().remove();
		var id=$(this).parent().attr("role-id");
		deleteProcessArgs(id);
		event.stopPropagation();
	}) 
	
	$(document).on("click",".process-out-args button:not(.moreArgs) > span",function(event){
		$(this).parent().remove();
		var id=$(this).parent().attr("role-id");
		deleteProcessArgs(id);
		event.stopPropagation();
	}) 
	
	$(" div.closeable-panel  div.panel  div button.closesub").on("click",function(){
		$(this).parents(".closeable-panel").hide();
	})
	
	$(document).on("click","#canvas ul > li.more-plugin",function(){
		showSubPanel("plugin-panel",$(this).parents("div.window.jtk-node.dropdown").attr("block-id"));
	})
	
	$(document).on("click","div.subpanel.new-next div.row.condition-row ul > li",function(){
		$(this).parents(".input-group-btn").find("button").text($(this).find("a").text());
		$(this).parents(".input-group-btn").find("button").attr("compare",$(this).find("a").attr("compare"));
		event.stopPropagation();
	})
	
	
	$(document).on("focus",".show-choose-pro",function(){
		var executeId=$(".right .rightmain").attr("execute-id");
		var blockId=$(".right .rightmain").attr("block-id");
		//getAvailableParam(blockId,executeId,this);
		
		
	})
		
	$(document).on("blur",".show-choose-pro",function(){
		$(this).parent().children(".choose-properties").remove();
	})

	
	$("div.subpanel.new-args > div.panel.panel-primary > div.panel-body > div.input-group > div > ul > li").on("click",function(){
		$(this).parents(".input-group-btn").children("button").text($(this).children("a").text());
		$(this).parents(".input-group-btn").children("button").attr("role",$(this).attr("role"));
	})
	
	var onNewArgsHide=function(){
		$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > input").val("");
		$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > .input-group-btn > button").attr("role","0")
		$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > .args-necessary.input-group-btn > button").text("必填");
		$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > .args-complex.input-group-btn > button").text("普通");
		$("div.subpanel.new-args > div.panel > div.panel-body > div.input-group > .args-mutitype.input-group-btn > button").text("单个");
		$(".added-column").hide();
		$(".added-column .table thead tr").empty()
	}
	
	$(".new-args button.submitsub").on("click",function(){
		var argsName=$("div.subpanel.new-args > div.panel.panel-primary > div.panel-body > div.input-group > input").val();
		argsName=filterXSS(argsName);

		var isNecessary=$("div.subpanel.new-args > div.panel.panel-primary > div.panel-body > div.input-group > .args-necessary.input-group-btn > button").attr("role");
		var isComplex=$("div.subpanel.new-args > div.panel.panel-primary > div.panel-body > div.input-group > .args-complex.input-group-btn > button").attr("role");
		var isMutitype=$("div.subpanel.new-args > div.panel.panel-primary > div.panel-body > div.input-group > .args-mutitype.input-group-btn > button").attr("role");
		var type=$("div.subpanel.new-args").attr("belong-id");
		if(!isNecessary){
			showlog("请选择参数是否为必填参数");
			return;
		}
		
		if(!argsName||argsName==''){
			showlog("请填写参数名称");
			return;
		}
		
		var argsObj={};
		argsObj.name=argsName;
		argsObj.isNecessary=isNecessary;
		argsObj.isComplex=isComplex;
		argsObj.isMutitype=isMutitype;
		argsObj.belong=type;
		argsObj.process=getParamValue("processId");
		
		if(argsObj.isComplex==1){
			argsObj.columns=[];
			var ths=$(".added-column .table thead tr th");
			for(var i=0;i<ths.length;i++){
				argsObj.columns.push(ths[i].innerText);
			}
		}
		
		saveProcessArgs(argsObj);

		$(".new-args").hide();
		onNewArgsHide();
	})
	
	$(" div.closeable-panel.new-args div.panel  div button.closesub").on("click",function(){
		onNewArgsHide();
	})
	
	
	
	$(".new-block button.submitsub").on("click",function(){
		var argsName=$("div.subpanel.new-block > div.panel > div.panel-body > div.input-group > input").val();
		argsName=filterXSS(argsName);
		
		if(!argsName||argsName==''){
			showlog("请填写参数名称");
			return;
		}
		var blockId=$("div.subpanel.new-block").attr("belong-id");
		saveOrUpdateBlock(argsName,blockId);
		$(".new-block").hide();
		$("div.subpanel.new-block > div.panel > div.panel-body > div.input-group > input").val("");
		$("div.subpanel.new-block").removeAttr("belong-id");
	})
	
	$(".plugin-panel button.submitsub").on("click",function(){
		var argsName=$("div.subpanel.plugin-panel > div.panel > div.panel-body > div.input-group > input").val();
		argsName=filterXSS(argsName);
		
		if(!argsName||argsName==''){
			showlog("请填写参数名称");
			return;
		}
		
		var blockId=$(".plugin-panel").attr("belong-id");
		var methodId=$(".plugin-panel .plugin-method button.btn-success").attr("method-id");
		if(!methodId||methodId==''){
			showlog("请选择执行内容");
			return;
		}
		
		saveExecute(blockId,methodId,argsName)
		
		$(".plugin-panel").hide();
		$("div.subpanel.plugin-panel > div.panel > div.panel-body > div.input-group > input").val("");
	})
	
	$(document).on("click",".plugin-panel .plugin-method button",function(){
		$(".plugin-panel .plugin-method button.btn-success").addClass("btn-primary").removeClass("btn-success");
		$(this).removeClass("btn-primary").addClass("btn-success");
	})
	
	
	$(".new-next button.submitsub").on("click",function(){
		var argsName=$("div.subpanel.new-next > div.panel > div.panel-body > div.input-group > input").val();
		argsName=filterXSS(argsName);
		
		if(!argsName||argsName==''){
			showlog("请填写条件名称");
			return;
		}
		
		var con=getConnectionById($("div.subpanel.new-next").attr("belong-id"));
		
		con.getOverlay("label").setLabel(argsName);
		var conditions=$("body > div.subpanel.new-next > div.panel.panel-info > div.panel-body > div.row");
		var jsonArray=[];
		for(var i=0;i<conditions.length;i++){
			var subCon=conditions[i];
			var inputs=$(subCon).find("input");
			var subCon1=inputs[0].value;
			var subCon2=inputs[1].value;
			var subCompare=$(subCon).find("button").attr("compare");

			var json={}; 
			json.param1=subCon1;
			json.param2=subCon2;
			json.method=subCompare;
			jsonArray.push(json);
		}
		con.condition=jsonArray;
		
		saveNext($("div.subpanel.new-next").attr("belong-id"),con.next,argsName,jsonArray,getParsedBlockId(con.sourceId),getParsedBlockId(con.targetId));
		
		$("body > div.subpanel.new-next > div.panel.panel-info > div.panel-body > div.row").remove();
		condition=1;
		addMoreCondition(condition++);
		$(".new-next").hide();
		$("div.subpanel.new-next > div.panel > div.panel-body > div.input-group > input").val("");
	})
	
	$(".new-block div button.closesub").on("click",function(){
		$(".new-block input").val("");
	})
	
	$(".new-next div button.closesub").on("click",function(){
		$("body > div.subpanel.new-next > div.panel.panel-info > div.panel-body > div.row").remove();
		condition=1;
		addMoreCondition(condition++);
		$("div.subpanel.new-next > div.panel > div.panel-body > div.input-group > input").val("");
		
		var con=getConnectionById($(this).parents(".subpanel").attr("belong-id"));
		if(!con)
			return;
		
		if(!con.next){
			instance.detach(con);
		}
	})	
	
	var getConnectionById=function(id){
		var cons=instance.getConnections("*");
		for(var i=0;i<cons.length;i++){
			var con=cons[i];
			if(con.id==id){
				return con;
			}
		}
		return;	
	}
	
	var delBlock=function(i){
		//removeBlock();
		instance.remove("flowchartWindow"+i);
	}
	
	var detach =function(id){
		var connections1=instance.getConnections({"target":"flowchartWindow"+id});
		var connections2=instance.getConnections({"source":"flowchartWindow"+id});
		for(var i=0;i<connections1.length;i++){
			instance.detach(connections1[i]);
		}
		for(var i=0;i<connections2.length;i++){
			instance.detach(connections2[i]);
		}
	}
	
	var removePoints=function(id){
		instance.removeAllEndpoints("#flowchart"+id);
	}


	var addEndPoint=function(i){
		_addEndpoints("Window"+i, ["LeftMiddle", "RightMiddle", "BottomCenter"], ["TopCenter"]);
	} 
	
    var instance = window.jsp = jsPlumb.getInstance({
        // default drag options
        DragOptions: { cursor: 'pointer', zIndex: 2000 },
        // the overlays to decorate each connection with.  note that the label overlay uses a function to generate the label text; in this
        // case it returns the 'labelText' member that we set on each connection in the 'init' method below.
        ConnectionOverlays: [
            [ "Arrow", {
                location: 1,
                visible:true,
                width:11,
                length:11,
                id:"ARROW",
                events:{
                    click:function() { alert("you clicked on the arrow overlay")}
                }
            } ],
            [ "Label", {
                location: 0.5,
                id: "label",
                cssClass: "aLabel",
                events:{
                    tap:function(e) {
						showSubPanel("new-next",e.component.id);
						$("div.subpanel.new-next > div.panel > div.panel-body > div.input-group > input").val(e.label);
						for(var i=0;i<e.component.condition.length;i++){
							var subCon=$("body > div.subpanel.new-next > div.panel.panel-info > div.panel-body > div.row:last");
							var inputs=$(subCon).find("input");
							
							$(inputs[0]).val(e.component.condition[i].param1);
							$(inputs[1]).val(e.component.condition[i].param2);
							$(subCon).find("button").attr("compare",e.component.condition[i].method);
							$(subCon).find("button").text(e.component.condition[i].method);
							
							if(i!=e.component.condition.length-1){
								addMoreCondition(condition++);
							}
						}
					}
                }
            }]
        ],
        Container: "canvas"
    });

    var basicType = {
        connector: "StateMachine",
        paintStyle: { stroke: "red", strokeWidth: 4 },
        hoverPaintStyle: { stroke: "blue" },
        overlays: [
            "Arrow"
        ]
    };
    instance.registerConnectionType("basic", basicType);
	instance.importDefaults({
		MaxConnections:-1
	})
	
    // this is the paint style for the connecting lines..
    var connectorPaintStyle = {
            strokeWidth: 2,
            stroke: "#61B7CF",
            joinstyle: "round",
            outlineStroke: "white",
            outlineWidth: 2
        },
    // .. and this is the hover style.
        connectorHoverStyle = {
            strokeWidth: 3,
            stroke: "#216477",
            outlineWidth: 5,
            outlineStroke: "white"
        },
        endpointHoverStyle = {
            fill: "#216477",
            stroke: "#216477"
        },
    // the definition of source endpoints (the small blue ones)
        sourceEndpoint = {
            endpoint: "Dot",
            paintStyle: {
                stroke: "#7AB02C",
                fill: "transparent",
                radius: 7,
                strokeWidth: 1
            },
            isSource: true,
            connector: [ "Flowchart", { stub: [40, 60], gap: 10, cornerRadius: 5, alwaysRespectStubs: true } ],
            connectorStyle: connectorPaintStyle,
            hoverPaintStyle: endpointHoverStyle,
            connectorHoverStyle: connectorHoverStyle,
            dragOptions: {},
            overlays: [
                [ "Label", {
                    location: [0.5, 1.5],
                    label: "Drag",
                    cssClass: "endpointSourceLabel",
                    visible:false
                } ]
            ]
        },
    // the definition of target endpoints (will appear when the user drags a connection)
        targetEndpoint = {
            endpoint: "Dot",
            paintStyle: { fill: "#7AB02C", radius: 7 },
            hoverPaintStyle: endpointHoverStyle,
            maxConnections: -1,
            dropOptions: { hoverClass: "hover", activeClass: "active" },
            isTarget: true,
            overlays: [
                [ "Label", { location: [0.5, -0.5], label: "Drop", cssClass: "endpointTargetLabel", visible:false } ]
            ]
        },
        init = function (connection) {
            //connection.getOverlay("label").setLabel(connection.sourceId.substring(15) + "-" + connection.targetId.substring(15));
        };

    var _addEndpoints = function (toId, sourceAnchors, targetAnchors) {
        for (var i = 0; i < sourceAnchors.length; i++) {
            var sourceUUID = toId + sourceAnchors[i];
            instance.addEndpoint("flowchart" + toId, sourceEndpoint, {
                anchor: sourceAnchors[i], uuid: sourceUUID
            });
        }
        for (var j = 0; j < targetAnchors.length; j++) {
            var targetUUID = toId + targetAnchors[j];
            instance.addEndpoint("flowchart" + toId, targetEndpoint, { anchor: targetAnchors[j], uuid: targetUUID });
        }
    };
	
	
	var addConnectionEvent=function(){
		instance.bind("connection", function (info) {
			//填写next
			
			var connection=info.connection;
			console.log(connection)
			
			
			if(connection.source&&connection.target){
				var connections1=instance.getConnections({"source":connection.source,"target":connection.target});
				
				if(connections1.length>1){
					showlog("已经存在这个执行路线了");
					
					instance.detach(connection);
				}else{
					if(!connection.next&&connection.source&&connection.target){
						showSubPanel("new-next",connection.id);
					}else if(connection.next){
						redirectNext(connection.next,getParsedBlockId(connection.sourceId),getParsedBlockId(connection.targetId));
					}
				}
			}else{
				
			}
			
			
        });
		
		
	}
	
	var removeConnectionEvent=function(){
		instance.unbind("connection");
	}
	

    // suspend drawing and initialise.
    instance.batch(function () {
		
        // listen for new connections; initialise them the same way we initialise the connections at startup.
        instance.bind("connection", function (connInfo, originalEvent) {
            init(connInfo.connection);
			var connection=connInfo.connection;
			connection.bind("mouseover", function(conn) {
				$(connection.canvas).css("z-index","5");
				$(connection.getOverlay("label").canvas).css("z-index","22").css("opacity","1");;
			}); 

			connection.bind("mouseout", function(conn) {
				$(connection.canvas).css("z-index","4");
				$(connection.getOverlay("label").canvas).css("z-index","21").css("opacity","0.5");
			});
			
			
        });
		
		 instance.bind("connectionDetached", function (connInfo, originalEvent) {
			 
			 console.log("connectionDetached");
			 console.log(connInfo.connection)
			 if(connInfo.connection.next){
				 console.log("delete next")
				deleteNext(connInfo.connection.next);
			}
		 })
		
		
	
        // make all the window divs draggable
        instance.draggable(jsPlumb.getSelector(".flowchart-demo .window"), { grid: [20, 20] });
        // THIS DEMO ONLY USES getSelector FOR CONVENIENCE. Use your library's appropriate selector
        // method, or document.querySelectorAll:
        //jsPlumb.draggable(document.querySelectorAll(".window"), { grid: [20, 20] });
		
        //
        // listen for clicks on connections, and offer to delete connections on click.
        //
        instance.bind("click", function (conn, originalEvent) {
           // if (confirm("Delete connection from " + conn.sourceId + " to " + conn.targetId + "?"))
             //   instance.detach(conn);
            conn.toggleType("basic");
        });

        instance.bind("beforeDetach", function (connection) {
            console.log("beforeDetach");
			
			if(connection.next){
				//deleteNext(connection.next);
			}
			
			return true;
        });
		
		getProcess();
		
    });

	
	
    jsPlumb.fire("jsPlumbDemoLoaded", instance);
	
});

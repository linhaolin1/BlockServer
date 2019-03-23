Date.prototype.format = function(fmt) 
{ //author: meizz 
  var o = { 
    "M+" : this.getMonth()+1,                 //月份 
    "d+" : this.getDate(),                    //日 
    "h+" : this.getHours(),                   //小时 
    "m+" : this.getMinutes(),                 //分 
    "s+" : this.getSeconds(),                 //秒 
    "q+" : Math.floor((this.getMonth()+3)/3), //季度 
    "S"  : this.getMilliseconds()             //毫秒 
  }; 
  if(/(y+)/.test(fmt)) 
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
  for(var k in o) 
    if(new RegExp("("+ k +")").test(fmt)) 
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length))); 
  return fmt; 
}
function formatTime(){
	return new Date().format("yyyy-MM-dd hh:mm:ss"); 
}


function count(val){
	if(val&&val.length!=undefined){
		return val.length;
	}else{
		return 0;
	}
}

function sum(val,param){
	if(val[param])
	
	return 1;
}

function val(val,index){
	if(val&&val.length!=undefined&&val.length>=index){
		return val[index-1];
	}else{
		return val;
	}
}



function getTime(){
	return new Date().getTime().toFixed();
}



function arrayValue(array){
	if(array==undefined||array.length==0){
		return '';
	}
	var object={};
	
	for(var i=0;i<array.length;i++){
		var single=array[i];
		for(var key in single){
			if(object[key] instanceof Array){
				
			}else{
				object[key]=[];
			}
			object[key].push(single[key]);
		}
	}
	
	return object;
}

function fixed(val,num){
	return parseFloat(val).toFixed(num);
}

function lookvup(array,head,value){
	
}

//全部数值转化和计算交给JS（dataloader换JS）

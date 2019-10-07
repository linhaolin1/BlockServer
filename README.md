# BlockServer 积木
让业务构成回归流程图，让代码转为技术积累

## 简介

积木是一套将后台服务端业务与技术区分开进行构成与开发的解决方案，目标为解决服务端的开发过程中遇到的一些问题
1. 即使业务只需要一点小的变更或者顺序调换，也可能导致服务端需要重新编译和部署项目，导致不必要的时间和人力
2. 相比客户端的可视化，服务端的内容只能通过阅读代码了解整体流程，无论是维护还是二次开发，都有很高的复杂性
3. 服务端完成的内容难以积累，生产出的服务端模块以业务为个体，每次开发都需要造许多重复的轮子（比如账号验证）


使用积木来构建业务系统，只需要用少量代码编写需要的技术组件，再于流程图上适时的调用各个组件并配上组件所需的输入内容并获得组件的输出，就能完成整套业务流程  
1. 整套业务流程以流程图的方式展示，能够更加方便地让使用者理解业务流向  
2. 积木的业务流程变更为即时起效，因此不需要额外的编译/测试/部署  
3. 积木的技术组件可生成为单独的文件，并且能直接在流程图中调用，能够更好的进行重用

<div align="center"><img src="http://106.52.110.245/images/process.png"/></div>

## 构成
积木的构成主要包含业务和技术组件2部分

### 业务
在积木中，业务被抽象为几个部分，包括
1. 流程描述  （流程名称，概述，输入内容，输出内容）
2. 功能块与连接功能块之间的条件线路
3. 单个功能块之下的多个执行块
4. 执行块所使用的技术组件及对应的组件输入输出

在调用业务流程时，将
```
1.根据流程输入，从流程启动的参数里读取相应的输入内容，然后从流程预设好的流程启动块开始执行  
2.顺序执行完该功能块下所属的执行块之后，寻找起点为该功能块的条件线路，根据当前流程的参数检查符合条件的线路，然后找到线路所对应的下一个功能块并执行，  
3.重复第2部分，直到无法找到符合条件的下一个条件线路或没有以该功能块为起点的条件线路  
4.根据流程输出参数，设置输出内容
```

参考：[创建支付订单流程](http://106.52.110.245/management/flowchart.html?processId=12)


####测试流程
1. 在[management/list.html](http://148.70.22.79/management/list.html)中创建一个流程，并输入流程名，点击确定按钮
2. 在流程输入参数中填写需要的参数名，在流程输出参数中填写需要输出的参数名
3. 点击`新的流程分块` 输入名称，点击确定按钮，创建一个新的功能块
4. 拖动新的功能块（新创建的功能块在该区域左上角）到需要的位置，点击新功能块中间的名称，点击下拉菜单中的`+`，选择添加执行块以及执行块所对应的技术组件
5. 再次点击该功能块中间的名称，在下拉菜单中选择新添加的执行块，再右边工具栏中配置对应的输入输出参数  
	5.1 在输入中要使用引用的参数，用{name} 对应 name参数的值  
	5.2 要把输出的内容保存到参数中，直接写名称，比如输出中result,之后即可通过{result}获取该输出内容
6. 从流程start的左/下/右方拖出条件线路 拉到新的功能块上方，配置该线路的名称与条件，可使用{name}获取流程中的参数值
7. 通过http接口调用该接口 进行测试


调用方法：  
http post请求 ： http://106.52.110.245/block-server/jsonRequest    
json化body内容
```json
 {"processId":12,"object":{"货物表":[],"用户token":"XX","名称":"lin","电话":"186XXXXXXXX","地址":"广东省广州市白云区XXXX"}}
```
或者  
http post请求 ： http://106.52.110.245/block-server/dynamic/12   
json化body内容 :
```json
{"货物表":[],"用户token":"XX","名称":"lin","电话":"186XXXXXXXX","地址":"广东省广州市白云区XXXX"}
```
或者 xml化body内容
```xml
<xml>
	<货物表></货物表>
	<用户token></用户token>
	<名称></名称>
	...
</xml> 
```
（不建议使用中文参数名，参数可为空）


### 技术组件
积木中的组件为配置了积木SDK的注解并打包后的jar包   
sdk参考[blockSdk](https://github.com/linhaolin1/BlockServer/tree/master/sdk/blockSdk)  
demo组件参考[plugins](https://github.com/linhaolin1/BlockServer/tree/master/demo/plugins)

## 案例
流程设计展示：http://148.70.22.79/management/list.html  
业务模板展示：http://148.70.22.79/template/index.html , http://template-admin.pinhuomao.xyz/

## 系统本身
系统本身使用Netty+spring+mybatis完成基本内容  
使用Netty的原因是请求url为dynamic时，需要根据请求头进行对应的格式参数解析

## 部署
1. 将demo/sql中的备份sql导入数据库
2. 下载主项目源码 并修改src/main/resource/database.properties中的数据库连接
3. 下载demo/plugin代码 并使用maven install打包生成jar
4. 修改framework数据库 plugin表中的fileName位置（依据上一步生成的jar包位置修改）
5. 启动主服务 src/main/java/com/lin/NettyServer.java
6. 将src/main/resource/management文件夹放入http容器，并配置将 /block-server 反向代理转发到Netty服务（默认8080端口）
7. 访问management/list.html


## License
MIT License

Copyright (c) 2019 linhaolin1

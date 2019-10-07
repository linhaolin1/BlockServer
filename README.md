# BlockServer 积木
让业务构成回归流程图，让代码转为技术积累

## 简介

积木是一套将后台服务端业务与技术区分开进行构成与开发的解决方案，目标为解决服务端的开发过程中遇到的一些问题

1.即使业务只需要一点小的变更或者顺序调换，也可能导致服务端需要重新编译和部署项目，导致不必要的时间和人力

2.相比客户端的可视化，服务端的内容只能通过阅读代码了解整体流程，无论是维护还是二次开发，都有很高的复杂性

3.服务端完成的内容难以积累，生产出的服务端模块以业务为个体，每次开发都需要造许多重复的轮子（比如账号验证）

使用积木来构建业务系统，只需要用少量代码编写需要的技术组件，再于流程图上适时的调用各个组件并配上组件所需的输入内容并获得组件的输出，就能完成整套业务流程

<div align="center"><img src="http://106.52.110.245/images/process.png"/></div>

## 构成

### 业务
在积木中，业务被抽象为几个部分，包括
流程描述  （流程名称，概述，输入内容，输出内容）
功能块与连接功能块之间的条件线路
单个功能块之下的多个执行块
执行块所使用的技术组件及对应的组件输入输出

在调用业务流程时，将
```
1.根据流程输入，从流程启动的参数里读取相应的输入内容，然后从流程预设好的流程启动块开始执行

2.顺序执行完该功能块下所属的执行块之后，寻找起点为该功能块的条件线路，根据当前流程的参数检查符合条件的线路，然后找到线路所对应的下一个功能块并执行，

3.重复第2部分，直到无法找到符合条件的下一个条件线路或没有以该功能块为起点的条件线路

4.根据流程输出参数，设置输出内容
```

参考：[创建支付订单流程](http://106.52.110.245/management/flowchart.html?processId=12)

调用方法：

http post请求 ： http://106.52.110.245/block-server/jsonRequest  

json化body内容
```json
 {'processId':12,object:{'货物表':[],'用户token':'XX','名称':'lin','电话':'186XXXXXXXX','地址':'广东省广州市白云区XXXX'}}
```
或者
http post请求 ： http://106.52.110.245/block-server/dynamic/12 

json化body内容 :
```json
{'货物表':[],'用户token':'XX','名称':'lin','电话':'186XXXXXXXX','地址':'广东省广州市白云区XXXX'}
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


### 系统本身



技术内容包含:
定义标准模块编写方式，通过注解配置模块的输入与输出，之后通过反射调用模块内容完成调用模块

业务内容包含
以可视化流程图定义和编辑流程的输入与输出，将输入内容通过调用不同的模块生成所需要的数据，再由输出获得内容

流程设计展示：http://148.70.22.79/management/list.html
业务模板展示：http://148.70.22.79/template/index.html  http://148.70.22.79/mobile/index.html
模板业务不需要编写业务代码

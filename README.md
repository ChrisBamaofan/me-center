#如何配置该项目
##配置maven
``推荐 http://wiki.jikexueyuan.com/project/maven/environment-setup.html
或者 https://www.cnblogs.com/liuhongfeng/p/5057827.html 本地安装完maven之后，
需要为ideaj也配置maven``
##配置数据库
``使用MySQL数据库，根据自己本地或者虚拟机里的ip更改application.properties文件中的username/password然后跑一下单元测试DBConnectionTest
来测试连接是否正常。``
##配置lombok
``ctrl+alt+s 打开setting->install plugins from repository ->搜 lombok``
###建表
``见表语句保存在userInfo.sql文件中``

##运行项目
找到Application.java然后运行即可。

##后续添加的功能
`mybatis多数据源配置模块`
`日志`
`可能演变成大数据系统的一部分`

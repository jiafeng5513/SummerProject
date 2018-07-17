使用IEDA创建SpringMVC的HelloWorld项目
======

### 软件版本:<br>
Windows 10 Home
java10
Tomcat 9
Idea 2018

### 步骤
1. 创建SpringMVC项目
![image](https://github.com/AngelaViVi/Summer/blob/master/Doc/shot/001-创建SpringMVC项目.png)
2. 取好项目名称,点击完成
![image](https://github.com/AngelaViVi/Summer/blob/master/Doc/shot/002-项目命名.png)
3. 等待下载完毕
4. 创建好的工程目录是这样的,注意,这个目录是自动生成的,并没有经过修改
![image](https://github.com/AngelaViVi/Summer/blob/master/Doc/shot/003-工程目录.png)
5. 在src目录下新建java包,在包下新建一个java类,命名为HelloWorldController
6. 编写刚刚创建的Java类,代码如下:
    ```java
    package com.anna.demo;

    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;

    @Controller
    public class HelloWorldController {
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String index() {
            return "index";
        }
    }
    ```
7. 打开WEB-INF下的web.xml,原始的状态是这样的,我们不需要更改这个文件,需要注意的点已经在注释中标出:
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee     http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
             version="4.0">
        <context-param>
            <param-name>contextConfigLocation</param-name>
            <!-- 这是应用程序上下文配置文件的所在路径 -->
            <param-value>/WEB-INF/applicationContext.xml</param-value>
        </context-param>
        <listener>
            <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
        </listener>
        <servlet>
            <!-- 这是Spring的DispatcherServlet,注意他的名字.-->
            <!-- 在web.xml的旁边有一个XXX-servlet.xml,其中的XXX就是DispatcherServlet的名字 -->
            <servlet-name>dispatcher</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
            <load-on-startup>1</load-on-startup>
        </servlet>
        <servlet-mapping>
            <!-- 这是DispatcherServlet的请求映射,所有以form为结尾的请求都会由名为dispatcher的servlet处理-->
            <servlet-name>dispatcher</servlet-name>
            <url-pattern>*.form</url-pattern>
        </servlet-mapping>
    </web-app>
    ```
8. 打开dispatcher-servlet.xml,这是配置DispatcherServlet的文件,我们要在这里告诉这个servlet,当请求到来的时候,他到哪里去找所需的bean,又要到哪里去找用来显示的页面<br>
![image](https://github.com/AngelaViVi/Summer/blob/master/Doc/shot/004-dispatcher-servlet.png)
>在beans属性中加入如下两条:<br>
    ```xml
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:mvc="http://www.springframework.org/schema/mvc"
    ```
>在beans标签中加入如下的子项目:<br>
```xml
    <!--指明 controller 所在包，并扫描其中的注解,注意这个包名要按照实际情况书写,IDEA会提供智能感知-->
    <context:component-scan base-package="com.anna.demo"/>
    <!-- 静态资源(js、image等)的访问 -->
    <mvc:default-servlet-handler/>
    <!-- 开启注解 -->
    <mvc:annotation-driven/>

    <!--用于支持Servlet、JSP视图解析-->
    <bean id="jspViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
        <!-- 这里是页面的查找位置,指明的是页面所在目录和页面文件的扩展名 -->
        <property name="prefix" value="./"/>
        <property name="suffix" value=".jsp"/>
    </bean>
```
>完整的dispatcher-servlet.xml如下:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <context:component-scan base-package="com.anna.demo"/>
    <mvc:default-servlet-handler/>
    <mvc:annotation-driven/>

    <bean id="jspViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
        <property name="prefix" value="./"/>
        <property name="suffix" value=".jsp"/>
    </bean>
</beans>
```
9. 打开index.jsp,编辑成如下状态:<br>
```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC Demo 首页</title>  
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">  
</head>
<body>
    <h1>这里是SpringMVC Demo首页</h1>
    <h3>出现此页面，说明配置成功。</h3>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
```
10. 编辑运行配置选项:
![image](https://github.com/AngelaViVi/Summer/blob/master/Doc/shot/005-新建运行配置选项.png)
1.  新建Local Tomcat Server:
![image](https://github.com/AngelaViVi/Summer/blob/master/Doc/shot/006-新建本地server配置.png)
12. 点击Config,选择本机上安装的Tomcat目录,注意到下面有可能会出现一个"Fix"字样,那代表我们还没有设置好关于部署的相关内容:
![image](https://github.com/AngelaViVi/Summer/blob/master/Doc/shot/007-选择Tomcat路径.png)
13. 点击出现的"Fix",或者在选项卡中选择第二项"Deployment",点击加号,选择项目的输出目标,如果选择exploded,可以实现热部署:
![image](https://github.com/AngelaViVi/Summer/blob/master/Doc/shot/008-部署.png)
14. File->Project Structure,左侧选中"Artifacts",右侧选项卡选中Output Layout,展开下面的文件夹,查看有没有把依赖项全都打包进去,如果没有的话,在其中新建"lib"文件夹,选中右侧的依赖,右键,把他们添加到lib文件夹中:
![image](https://github.com/AngelaViVi/Summer/blob/master/Doc/shot/009-依赖部署.png)
15. 运行,如果一切正常,浏览器会被自动打开,并显示我们的页面:
![image](https://github.com/AngelaViVi/Summer/blob/master/Doc/shot/010-运行结果.png)
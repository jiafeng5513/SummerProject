Windows下Java和Tomcat的环境变量
============================

### java环境变量
1. 新建变量:`CLASSPATH`<br>
`.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar; `

2. 新建变量:`JAVA_HOME`<br>
`C:\Program Files\Java\jdk-10.0.1`

3. 在Path中添加:<br>
`%JAVA_HOME%\bin`
`%JAVA_HOME%\jre\bin`

### Tomcat环境变量
1. 新建变量:`CATALINA_BASE`<br>
`C:\Program Files\Apache Software Foundation\Tomcat 9.0`

2. 新建变量:`CATALINA_HOME`<br>
`C:\Program Files\Apache Software Foundation\Tomcat 9.0`

3. 在Path中添加:<br>
`%CATALINA_HOME%\lib`
`%CATALINA_HOME%\bin`

4. Tomcat的启停:<br>
`catalina.bat stop`
`catalina.bat start`

5. 如果安装时选择了"Configure Tomcat",会安装一个用于配置和控制Tomcat的UI程序<br>

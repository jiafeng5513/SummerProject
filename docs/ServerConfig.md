服务器配置脚本
=====

### 服务器情况
Ubuntu 16.04<br>
### 修改密码:
1. `passwd`<br>
### 安装:mysql并设置远程访问 

1. `sudo apt install mysql-server`<br>
    期间要设置mysql的root账号密码,我设置为0000<br>
1. `apt install mysql-client`<br>
2. `apt install libmysqlclient-dev`<br>
3. `sudo netstat -tap | grep mysql`<br>
    输出结果是:`tcp 0 0 localhost:mysql *:* LISTEN 30146/mysqld`<br>
4. 编辑mysql配置文件，把其中bind-address = 127.0.0.1注释了<br>
    使用VI编辑:`vi /etc/mysql/mysql.conf.d/mysqld.cnf `<br>
    或者直接找到文件进行编辑并保存<br>
5. 使用root进入mysql命令行，执行如下2个命令，示例中mysql的root账号密码：0000<br>
    先进入MySQL命令模式:<br>
    `mysql -u root -p`<br>
        要输入mysql的root密码(0000)<br>
    `grant all on *.* to root@'%' identified by '0000' with grant option;`<br>
     `flush privileges;`<br>
6. 重启mysql<br>
        `/etc/init.d/mysql restart`<br>
### 安装java环境
 1. `java -version`
 如果输出是这样的,证明没安装过java:
 ```
 The program ‘java’ can be found in the following packages:
 *default-jre
 * gcj-4.6-jre-headless
 * openjdk-6-jre-headless
 * gcj-4.5-jre-headless
 * openjdk-7-jre-headless
 Try: sudo apt-get install
 ```
 1. `sudo apt-get install default-jre`
 2. `sudo apt-get install default-jdk`
 3. `sudo add-apt-repository ppa:webupd8team/java`
 4. `sudo apt-get update`
 5. `sudo apt-get install oracle-java8-installer`
 6. `sudo apt-get install oracle-java8-set-default`
 7. `JAVA_HOME=/usr/lib/jvm/java-8-oracle`
 8. `JRE_HOME=$JAVA_HOME/jre`
 9. `JAVA_BIN=$JAVA_HOME/bin`
 10. `CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JRE_HOME/lib`
 11. `PATH=$PATH:$JAVA_HOME/bin:$JRE_HOME/bin`
 12. `export JAVA_HOME JRE_HOME PATH CLASSPATH`
 13. `source ~/.bashrc`
 14. `java -version`
 如果输出是这样,证明安装成功:
 ```bash 
 Java(TM) SE Runtime Environment (build 1.8.0_171-b11)
 Java HotSpot(TM) 64-Bit Server VM (build 25.171-b11, mixed mode)
 ```

### 安装Tomcat<br>
1. 从[这里](https://mirrors.tuna.tsinghua.edu.cn/apache/tomcat/tomcat-9/v9.0.10/bin/)下载apache-tomcat-9.0.10.tar.gz,上传到root目录下<br>
2. 解压:`tar zxvf apache-tomcat-9.0.10.tar.gz`
3. 文件夹改名:`mv apache-tomcat-9.0.10 tomcat9`
4. 转移目录:`sudo mv tomcat9 /usr/local/`
5. 编辑文件:"/etc/profile"
6. 在文件末尾添加:
```bash
    #set tomcat environment
    CATALINA_HOME=/usr/local/tomcat9
    export CATALINA_HOME
```
7. 编辑:/usr/local/tomcat9/bin/catalina.sh
```bash
    CATALINA_HOME=/usr/local/tomcat9
    JAVA_HOME=/usr/lib/jvm/java-8-oracle
```
8. 启动:
```bash
# 直接启动
/usr/local/tomcat9/bin/startup.sh
# 启动且将输出定向到回收站
/usr/local/tomcat9/bin/catalina.sh run > /dev/null 2>&1 &
```
### 服务器环境自动启动
1. 找到`/etc/rc.local`文件<br>、
2. 在其中添加启动脚本如下：
```bash
/etc/init.d/mysql start
/usr/local/tomcat9/bin/catalina.sh run > /dev/null 2>&1 &
```

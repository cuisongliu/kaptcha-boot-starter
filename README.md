[![license](https://img.shields.io/badge/gradle-3.3-brightgreen.svg)](https://gradle.org)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://opensource.org/licenses/mit-license.php)

#  [Kaptcha](https://github.com/penggle/kaptcha)  integration  with beetl

Kaptcha-Spring-Boot-Starter 帮助你集成通用 [Kaptcha](https://github.com/javamonkey/beetl2.0) 到 Spring Boot。

Kaptcha-Spring-Boot-Starter will help you use [Kaptcha](https://github.com/javamonkey/beetl2.0) with Spring Boot.

## How to use

### maven

在pom.xml加入nexus资源库（解决中国访问慢的问题,已经加入中央仓库）

Add the following nexus repository(fix china access slow problem,already append to central nexus.)  to your pom.xml:

    <repositories>
        <repository>
            <id>nexus</id>
            <name>nexus</name>
            <url>http://maven.cuisongliu.com/content/groups/public</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>

在pom.xml加入依赖

Add the following dependency to your pom.xml:
    
    <dependency>
       <groupId>com.cuisongliu</groupId>
       <artifactId>kaptcha-spring-boot-starter</artifactId>
       <version>1.0</version>
     </dependency>

### gradle

在build.gradle加入nexus资源库（解决中国访问慢的问题,已经加入中央仓库）

Add the following nexus repository(fix china access slow problem,already append to central nexus.)  to your build.gradle:

    allprojects {
        repositories {
            mavenLocal()
            maven { url "http://maven.cuisongliu.com/content/groups/public" }
            mavenCentral()
            jcenter()
        }
    }
    
在build.gradle加入依赖

Add the following dependency to your build.gradle:
    
    compile "com.cuisongliu:kaptcha-spring-boot-starter:1+"
    
## Example

    kaptcha:
        enable: true
        properties:
          kaptcha.border: no
          kaptcha.border.color: 105,179,90
          kaptcha.textproducer.font.color: blue
          kaptcha.image.width: "125"
          kaptcha.image.height: "45"
          kaptcha.textproducer.font.size: "45"
          kaptcha.session.key: KAPTCHA_SESSION_KEY
          kaptcha.textproducer.char.length: "4"
          kaptcha.textproducer.font.names: 宋体,楷体,微软雅黑
        suffix: suffix
## Warning

    KaptchaController already define. You can't new the controller that names is KaptchaController.

## Acknowledgments

 [Kaptcha](http://code.google.com/p/kaptcha/).
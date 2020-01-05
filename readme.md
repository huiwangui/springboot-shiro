1、springboot项目一般打成jar包
2、页面采用thymeleaf,导入thymeleaf依赖
  2.1引入thymeleaf依赖
        <!--导入thymeleaf依赖-->
  		<dependency>
  			<groupId>org.springframework.boot</groupId>
  			<artifactId>spring-boot-starter-thymeleaf</artifactId>
  		</dependency>
  		
springboot整合shiro：  
  分析shiro 的核心API
  Subject:用户主体（把操作交给SecurityManager）
  SecurityManager:安全管理器（关联Realm）
  Realm：shiro连接数据的桥梁
整合步骤：		
1、导入shiro与spring整合依赖
  		<!-- shiro与spring整合依赖-->
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-spring</artifactId>
            <version>1.4.0</version>
        </dependency>
2、自定义Realm类  
      
      
thymeleaf和shiro标签整合使用
1、导入thymeleaf扩展坐标  
2、配置ShiroDialect    


Quartz: 任务调度：实现某些功能定时执行


Quartz相关视频地址：https://www.bilibili.com/video/av55637917?p=1
springboot整合shiro、mybatis视频地址： 
https://www.bilibili.com/video/av33332282/?spm_id_from=333.788.videocard.6
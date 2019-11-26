## update
    because of current web project almost is the separation of front-end and back-end project.
    I hava abandoned the old version that use spring boot integration with spring security and thymeleaf simple demo.
    now this project use oauth2 and toke authorized login and permissions control.  
    It's still being optimized.
    please wait....
    please reference my sql file named study_db.sql build yourself database.
    and reference my pom dependencies,Even if the your project use gradle, please reference these dependencies and version.
    in the class named OAuth2AuthenticationProvider will creat token by user info and permission.
    when access api will validation permission,This needs to be open @EnableGlobalMethodSecurity(prePostEnabled = true) at OAuth2SecurityConfig class and add @PreAuthorize("hasAuthority('ADMIN')") at controller method.
    the 'ADMIN' permission will build in token.
    I am also practicing and learning,if you have any question please link me with zhaishuo325@163.com.maybe we can to discuss togater
## old version
    # spring-boot-security
    spring boot integration with spring security and thymeleaf simple  demo
    
    use the thymeleaf form submit not a separation of front-end and back-end project
    
    I hope I can help you.
    
    # pom dependencies
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        
        <!--thymeleaf-extras-springsecurity5 for integration with Spring Security 5.x -->
        <dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-springsecurity5</artifactId>
            <version>3.0.4.RELEASE</version>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.security.oauth</groupId>
            <artifactId>spring-security-oauth2</artifactId>
            <version>2.4.0.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.1</version>
        </dependency>
        
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
            <scope>runtime</scope>
        </dependency>
    # db sql
        resources -> config -> db -> study_db.sql
        impor this file to your local db(mine is mysql named study_db)
        next you only need update application.propreties set your db config
        the project can work now!
        
    # mybatis generator tool
        it is already define in pom.xml, you can update generatorConfig.xml
        and datasource.properties to use it.
        
    # notice
        if you want ignore web static resource, 
        add the configure method at the security config class
        @Override
        public void configure(WebSecurity web) throws Exception {
            //解决静态资源被拦截的问题
            web.ignoring().antMatchers("/css/**");
        }
        
        about thymeleaf-extras-springsecurity and
        
        spring security:
        
        thymeleaf-extras-springsecurity3 for integration with Spring Security 3.x
        thymeleaf-extras-springsecurity4 for integration with Spring Security 4.x
        thymeleaf-extras-springsecurity5 for integration with Spring Security 5.x
        Current versions:
        
        Version 3.0.4.RELEASE - for Thymeleaf 3.0 (requires Thymeleaf 3.0.10+)
        Version 2.1.3.RELEASE - for Thymeleaf 2.1 (requires Thymeleaf 2.1.2+)
        
        For example,use thymeleaf-extras-springsecurity4 and spring security 5
        the thymeleaf sec:authorize="hasRole('ROLE_ADMIN')" will not work
        
        sec:authorize="hasRole('ROLE_ADMIN')" equals sec:authorize="hasRole('ADMIN')"
        the Prefix 'ROLE_' will auto completion,but backend must add role as "ROLE_ADMIN".
        and spring security 5 don't allow the cleartext passwords,
        so need config PasswordEncoder.
    

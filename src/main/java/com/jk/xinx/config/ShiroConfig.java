package com.jk.xinx.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，因为在初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {


        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        shiroFilterFactoryBean.setLoginUrl("/page/toLogin");
        shiroFilterFactoryBean.setUnauthorizedUrl("/page/to403");

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        filterChainDefinitionMap.put("/page/toIndex", "anon");
        filterChainDefinitionMap.put("/login/*", "anon");
        filterChainDefinitionMap.put("/js/*", "anon"); //匿名访问静态资源
        filterChainDefinitionMap.put("/*/*", "authc");



        //拦截到/login/logout 请求，自动进行登出操作
        filterChainDefinitionMap.put("/login/logout", "logout");
       // filterChainDefinitionMap.put("/page/user/add","perms[user:add]");

        //filterChainDefinitionMap.put("/page/self/*", "roles[vip]");
       // filterChainDefinitionMap.put("/page/user/*", "roles[vip]");
        //filterChainDefinitionMap.put("/page/client/*", "roles[VIP]");
        //filterChainDefinitionMap.put("/page/log/*", "roles[user]");


        // 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    /**
     * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
     * @return
     */
    @Bean(name = "userRealm")
    public UserRealm getUserRealm() {
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }


    /**
     * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了 ）
     *
     * @return
     */
  /*  @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(1);// 散列的次数，比如散列两次，相当于md5(md5(""));

        return hashedCredentialsMatcher;
    }*/



    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }


}

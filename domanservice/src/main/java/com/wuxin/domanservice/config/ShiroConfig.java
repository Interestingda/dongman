package com.wuxin.domanservice.config;

import com.wuxin.domanservice.utils.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;


import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.SessionManager;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Atothor:aa
 * data:2022/10/16
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 拦截器。匹配原则是最上面的最优先匹配
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置不会被拦截的链接
        filterChainDefinitionMap.put("/apis/auth/login","anon");
        filterChainDefinitionMap.put("/apis/vod_list", "anon");
        filterChainDefinitionMap.put("/apis/auth/register","anon");
      filterChainDefinitionMap.put("/apis/vod_detail","anon");
//      filterChainDefinitionMap.put("/apis/show/comment/**","anon");
              // 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/Logout", "logout");

        // 剩余请求需要身份认证
        filterChainDefinitionMap.put("/**", "authc");
        // 如果不设置默认会根目录下的"/login"页面
        shiroFilterFactoryBean.setLoginUrl("/apis/auth/login");

        // 未授权界面;
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
    //创建realm对象
    @Bean(name = "myShiroRealm")
    public ShiroRealm myShiroRealm(HashedCredentialsMatcher matcher) {
        ShiroRealm myShiroRealm = new ShiroRealm();
        myShiroRealm.setCredentialsMatcher(matcher);
       myShiroRealm.setCacheManager(new EhCacheManager());
       myShiroRealm.setCachingEnabled(true);//开启缓存
       myShiroRealm.setAuthenticationCachingEnabled(true);//开启认证缓存
       myShiroRealm.setAuthenticationCacheName("authentication");
       return myShiroRealm;
    }

    /**
     * ‘进行安全管器的创建并把realm交给管理器
     *
     *
     *
     */
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher,
                                                     CookieRememberMeManager rememberMeManager,
                                                     SessionManager sessionManager){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm(matcher));
        //设置缓存
        securityManager.setCacheManager(new EhCacheManager());
        // 设置会话
        securityManager.setSessionManager(sessionManager);
        // 使用记住我
        //将cookeis注入管理器
        securityManager.setRememberMeManager(rememberMeManager);
        return securityManager;
    }



    /**
     * 密码匹配凭证管理器
     *  根据这个进行密码的比较
     *
     */
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 采用MD5方式加密
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        // 设置加密次数
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    /**
     * 设置缓存
     *
     */
    @Bean
    public EhCacheManager cacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return cacheManager;
    }

    @Bean("sessionManager")
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //设置session过期时间
        sessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
        //定期验证session
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdCookieEnabled(true);
        //删除无效session
        sessionManager.setDeleteInvalidSessions(true);

        return sessionManager;
    }

    /**
     * rememberMe管理器, cipherKey生成见{@code Base64Test.java}
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(SimpleCookie rememberMeCookie) {

        CookieRememberMeManager manager = new CookieRememberMeManager();
//       设置加密的key.参数类型byte[]
        manager.setCipherKey(Base64.decode("Z3VucwAAAAAAAAAAAAAAAA=="));
        manager.setCookie(rememberMeCookie);
        return manager;
    }


    /**
     * 记住密码Cookie
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //设置cookies生效时间为 2天
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(2 * 24 * 60 * 60);//2天
        return simpleCookie;
    }



}

# springbootstudy
study springboot project

#过滤器、拦截器、监听器

##springboot中如何实现过滤器的呢？

实现javax.servlet.Filter接口

添加@WebFilter注解

在springboot启动类上增加@ServletComponentScan注解

```java
@WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    @Autowired
    private One one;

    /**只会在初始化的时候执行一次**/
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        one.print();
        System.out.println("go into init filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("go into do filter");
        one.print();
        chain.doFilter(request, response);
    }
    /**在过滤器销毁的时候执行**/
    @Override
    public void destroy() {
        System.out.println("go into destroy filter");
    }
}
```

springboot底层是怎么利用过滤器的呢？

init操作：

tomcat在启动容器的时候，会初始化web应用，过程中org.apache.catalina.core.StandardContext在调用filterstart的时候，org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext
会调用selfInitialize方法将之前扫描到bean管理中的filter加入到org.apache.catalina.core.StandardContext的filterDef中，在org.apache.catalina.core.ApplicationFilterConfig中，
由过滤器本身完成自己的初始化操作

filter操作：
初始化的时候，filter已加入都context之中，在请求到达容器之后，在org.apache.catalina.core.StandardContext
中组装filter，过滤请求

destroy操作：
当容器终止的时候StandardContext会调用stopInternal方法，再取到各个filter后，由filter自身调用
自身的终止方法

##拦截器
依赖于springmvc，细化的请求

实现org.springframework.web.servlet.HandlerInterceptor接口
增加WebConfig配置类实现WebMvcConfiguration接口，重写addInterceptors方法，
在类上增加@Configuration注解，使配置生效
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistry = registry.addInterceptor(new AdminInterceptor());
        interceptorRegistry.addPathPatterns("/*");
        interceptorRegistry.excludePathPatterns("*.html", "*.js");
    }
}
```
什么时候初试化？

当初始化bean "requestMappingHandlerMapping"=>org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
的时候，会调用<code>mapping.setInterceptors(getInterceptors(conversionService, resourceUrlProvider));</code>

##监听器

实现相应的监听接口，添加@Weblistener注解，在启动类上增加@ServletComponentScan
监听器是事件机制的，触发的时机是当事件发生的时候
```java
@WebListener
public class UserHttpSessionListener implements HttpSessionListener {

    private static final Logger logger = LoggerFactory.getLogger(UserHttpSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("session created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("session destroy");
    }
}
```

##spring中bean加载的过程

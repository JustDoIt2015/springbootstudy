package s.l.q.m.kkk.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import s.l.q.m.kkk.aspect.BrokerAspect;
import s.l.q.m.kkk.bean.One;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * springMVC 拦截器和过滤器的区别
 * 过滤器依赖与servlet
 *
 * 过滤器包裹拦截器
 * 执行范围：过滤器针对所有请求， 拦截器只针对action请求
 *
 */
@WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(BrokerAspect.class);

    @Autowired
    private One one;

    @Override
    public void init(FilterConfig filterConfig) {
        one.print();
        logger.info("go into init filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("go into do filter");
        one.print();
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("go into destroy filter");
    }
}

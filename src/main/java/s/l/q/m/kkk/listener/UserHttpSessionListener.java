package s.l.q.m.kkk.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

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

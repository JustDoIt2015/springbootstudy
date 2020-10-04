package s.l.q.m.kkk.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {
    
    private static final Logger logger = LoggerFactory.getLogger(ApplicationContextListener.class);

    public ApplicationContextListener() {
        logger.info("i am init");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("go listener");
    }
}

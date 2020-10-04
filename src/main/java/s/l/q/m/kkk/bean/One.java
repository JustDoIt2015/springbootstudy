package s.l.q.m.kkk.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
public class One implements BeanPostProcessor {

	private static final Logger logger = LoggerFactory.getLogger(One.class);

	public One() {
		logger.info("i am init");
	}

	private void init() {
		logger.info("init beans");
	}

	public void print() {
		logger.info("this is one print");
	}
	
}

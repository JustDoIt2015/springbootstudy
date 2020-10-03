package s.l.q.m.kkk.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class One {

	private static final Logger logger = LoggerFactory.getLogger(One.class);

	private void init() {
		logger.info("init beans");
	}

	public void print() {
		logger.info("this is one print");
	}
	
}

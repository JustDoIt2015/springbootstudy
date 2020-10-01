package s.l.q.m.kkk.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class One {

	private void init() {
		System.out.println("init beans");
	}

	public void print() {
		System.out.println("this is one print");
	}
	
}

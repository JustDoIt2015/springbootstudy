package s.l.q.m.kkk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */
@RestController
@EnableAutoConfiguration
@SpringBootApplication
@EnableWebMvc
@ServletComponentScan("s.l.q.m.kkk.filter")
public class App 
{
	
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
    public static void main( String[] args ) throws Exception
    {
    	SpringApplication.run(App.class, args);
    }
}

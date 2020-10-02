package s.l.q.m.kkk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import s.l.q.m.kkk.bean.User;

import javax.servlet.http.HttpSession;

@RestController
public class HelloWordController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @ResponseBody
    @RequestMapping("/getUser")
    User getUser(HttpSession session) {
        User u = new User();
        u.setAge(1);
        u.setSex(1);
        u.setName("xiao ming");
        session.setAttribute("user", "xiao ming");
        return u;
    }

    @RequestMapping("/destroySession")
    String destroySession(HttpSession session) {
        session.invalidate();
        return "session destroy";
    }
}

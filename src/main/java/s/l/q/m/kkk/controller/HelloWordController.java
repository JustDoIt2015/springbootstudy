package s.l.q.m.kkk.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import s.l.q.m.kkk.bean.User;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api")
@Api("HelloWordController相关的API")
public class HelloWordController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @ResponseBody
    @GetMapping(value = "/getUser")
    @ApiOperation(value = "获取用户信息", notes = "将获取到的用户信息加入到session之中")
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

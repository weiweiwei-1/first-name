package Informal.mybatis.AjaxTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@Controller
@RequestMapping(value="/AjaxAll",method={RequestMethod.GET,RequestMethod.POST},produces = "text/html;charset=UTF-8")
public class AjaxFirst{
    @RequestMapping("/enter")
    public String enter(){
        return "ajax/ajax2";
    }
    @RequestMapping(value="/doPost",method={RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody void doPost(HttpServletResponse response) throws IOException {
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().print("????ajax");
        System.out.println("??ajax");
    }

    @ResponseBody
    @RequestMapping(value="/doget",method={RequestMethod.GET,RequestMethod.POST})
    public String doget(HttpServletResponse response,HttpServletRequest request) throws Exception{
        response.setContentType("text/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("inpu");
        name=URLDecoder.decode(name,"UTF-8");
        System.out.println(name);
        return name;
}
}

package Informal.mybatis.AjaxTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value="/AServlet",method={RequestMethod.POST,RequestMethod.GET},produces = "text/html;charset=UTF-8")
public class AServlet{
    @RequestMapping(value="/doget")
    public @ResponseBody void doget(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        response.setContentType("text/json;charset=utf-8");
        System.out.println("开始ajax");
        response.getWriter().println("开始ajax");

    }

}

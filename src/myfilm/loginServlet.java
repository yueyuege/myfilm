package myfilm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet",urlPatterns = "/toLogindo")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        //2.判断用户输入的内容是否有效
        //字符串判断用equals
        if ("root".equals(uname) && "1234".equals(pwd)) {
            System.out.println("登录成功");
            //可以使用请求转发继续跳转页面
            //使用重定向，返回主页

            response.sendRedirect("/index.do");
        } else {
            System.out.println("登录失败");
            //发到request界面
            request.setAttribute("msg", "用户名或密码不对！");
            //转发到登录失败的页面

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
    }
}

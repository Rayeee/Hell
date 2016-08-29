package winter.hell.framework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Rayee on 16/8/28.
 */
@WebServlet(name = "Servlet")
public class MyServlet extends HttpServlet {

    @Override
    public void init(){
        System.out.println("init start");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response){
        System.out.println("service");
        String method = request.getMethod();
        System.out.println(method);
        try {
            doGet(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        System.out.println("post");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MyFirstServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet MyFirstServlet at " + request.getContextPath() + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }finally {
            out.close();
        }

    }


}

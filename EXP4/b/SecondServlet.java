import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class SecondServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        out.println("<h2>Welcome " + name + "</h2>");
    }
}
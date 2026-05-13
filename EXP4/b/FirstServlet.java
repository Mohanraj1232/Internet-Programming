import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class FirstServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        out.println("<form action='SecondServlet' method='post'>");

        // Hidden Field
        out.println("<input type='hidden' name='username' value='" + name + "'>");

        out.println("<input type='submit' value='Show Name'>");

        out.println("</form>");
    }
}
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HitCountServlet extends HttpServlet {

    int count = 0;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        count++;

        out.println("<h2>Visitor Count : " + count + "</h2>");
    }
}
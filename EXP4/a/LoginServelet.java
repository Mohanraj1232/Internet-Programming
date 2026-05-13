import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet
{
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws ServletException, IOException
    {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String uname = request.getParameter("username");
        String pass = request.getParameter("password");

        out.println("<html><body>");

        out.println("<h2>Welcome " + uname + "</h2>");

        if(pass.equals("admin"))
        {
            out.println("<h3>Login Successful</h3>");
        }
        else
        {
            out.println("<h3>Invalid Password</h3>");
        }

        out.println("</body></html>");
    }
}
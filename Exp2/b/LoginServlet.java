import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
                       throws IOException
    {
        String u = req.getParameter("user");
        String p = req.getParameter("pass");

        if(u.equals("admin") && p.equals("123"))
        {
            Cookie c = new Cookie("user", u);
            res.addCookie(c);

            res.sendRedirect("products.html");
        }
        else
        {
            res.getWriter().println("Wrong Login");
        }
    }
}
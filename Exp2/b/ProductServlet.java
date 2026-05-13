import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProductServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
                       throws IOException
    {
        String items[] = req.getParameterValues("item");

        for(String s : items)
        {
            Cookie c = new Cookie("cart", s);
            res.addCookie(c);
        }

        res.sendRedirect("cart.jsp");
    }
}
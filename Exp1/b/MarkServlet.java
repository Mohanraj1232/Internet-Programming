import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class MarkServlet extends HttpServlet
{
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws ServletException, IOException
    {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String regno = request.getParameter("regno");

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/onlineexam",
                "root",
                "root"
            );

            PreparedStatement ps = con.prepareStatement(
                "select * from student where regno=?"
            );

            ps.setString(1, regno);

            ResultSet rs = ps.executeQuery();

            out.println("<html><body>");

            if(rs.next())
            {
                int m1 = rs.getInt("mark1");
                int m2 = rs.getInt("mark2");
                int m3 = rs.getInt("mark3");

                int total = m1 + m2 + m3;

                double avg = total / 3.0;

                out.println("<h2>Student Mark List</h2>");

                out.println("Register No : " + rs.getString("regno"));
                out.println("<br>");

                out.println("Name : " + rs.getString("name"));
                out.println("<br>");

                out.println("Department : " + rs.getString("department"));
                out.println("<br><br>");

                out.println("Mark 1 : " + m1);
                out.println("<br>");

                out.println("Mark 2 : " + m2);
                out.println("<br>");

                out.println("Mark 3 : " + m3);
                out.println("<br><br>");

                out.println("Total : " + total);
                out.println("<br>");

                out.println("Average : " + avg);
            }
            else
            {
                out.println("<h3>Student Record Not Found</h3>");
            }

            out.println("</body></html>");

            con.close();
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}
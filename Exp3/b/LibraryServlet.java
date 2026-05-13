import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LibraryServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/librarydb",
                "root",
                "root"
            );

            // Check User
            PreparedStatement ps = con.prepareStatement(
                "select * from users where username=? and password=?"
            );

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                out.println("<h2>Welcome " + username + "</h2>");
                out.println("<h3>Book Catalogue</h3>");

                // Load Books Dynamically
                Statement st = con.createStatement();

                ResultSet books = st.executeQuery(
                    "select * from books"
                );

                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<th>Book ID</th>");
                out.println("<th>Book Name</th>");
                out.println("<th>Author</th>");
                out.println("</tr>");

                while(books.next()) {

                    out.println("<tr>");

                    out.println("<td>" +
                        books.getInt("id") +
                        "</td>");

                    out.println("<td>" +
                        books.getString("bookname") +
                        "</td>");

                    out.println("<td>" +
                        books.getString("author") +
                        "</td>");

                    out.println("</tr>");
                }

                out.println("</table>");

            } else {

                out.println("<h3>Invalid User</h3>");
            }

            con.close();

        } catch(Exception e) {

            out.println(e);
        }
    }
}
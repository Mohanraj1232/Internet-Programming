# Session Tracking using URL Rewriting

## Login Page (login.html)

```html id="uh0ml8"
<html>
<body>

<form action="LoginServlet" method="get">

Name:
<input type="text" name="uname">

<input type="submit" value="Login">

</form>

</body>
</html>
```

---

# Servlet Program (LoginServlet.java)

```java id="flvzh7"
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    public void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        String name = req.getParameter("uname");

        out.println("<h2>Welcome " + name + "</h2>");

        out.println(
            "<a href='NextServlet?user="
            + name +
            "'>Next Page</a>"
        );
    }
}
```

---

# Next Servlet (NextServlet.java)

```java id="mpywt4"
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class NextServlet extends HttpServlet {

    public void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
            throws IOException {

        PrintWriter out = res.getWriter();

        String user = req.getParameter("user");

        out.println("<h2>User Name: " + user + "</h2>");
    }
}
```

---

# web.xml

```xml id="if6h5j"
<web-app>

    <servlet>
        <servlet-name>login</servlet-name>
        <servlet-class>LoginServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>login</servlet-name>
        <url-pattern>/LoginServlet</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>next</servlet-name>
        <servlet-class>NextServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>next</servlet-name>
        <url-pattern>/NextServlet</url-pattern>
    </servlet-mapping>

</web-app>
```

---

# Output

## First Page

```text id="n8kb3m"
Enter Name: Mohan
```

## After Login

```text id="sm6k17"
Welcome Mohan
Next Page
```

## Next Page

```text id="e9n62q"
User Name: Mohan
```

---

# Simple Explanation

## URL Rewriting

Data is passed through URL.

Example:

```text id="d6ml6n"
NextServlet?user=Mohan
```

Here:

* `user` → variable
* `Mohan` → value

This helps track the session between pages.

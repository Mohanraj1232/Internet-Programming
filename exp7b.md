# 1. Web Service

```java
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class OpinionService {

    @WebMethod
    public String getOpinion() {

        return "500 People Opinion:\n"
                + "Liked Product = 350\n"
                + "Disliked Product = 150";
    }
}
```

---

# 2. Publish Service

```java
import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String[] args) {

        Endpoint.publish(
                "http://localhost:8080/opinion",
                new OpinionService()
        );

        System.out.println("Service Started");
    }
}
```

---

# 3. Client Servlet

```java
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ClientServlet extends HttpServlet {

    public void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
            throws IOException {

        PrintWriter out = res.getWriter();

        URL url =
                new URL("http://localhost:8080/opinion");

        InputStream is = url.openStream();

        String data = "";

        int ch;

        while ((ch = is.read()) != -1) {

            data = data + (char) ch;
        }

        out.println(data);

        is.close();
    }
}
```

---

# 4. web.xml

```xml
<web-app>

    <servlet>
        <servlet-name>client</servlet-name>
        <servlet-class>ClientServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>client</servlet-name>
        <url-pattern>/client</url-pattern>
    </servlet-mapping>

</web-app>
```

---

# Output

```text
500 People Opinion:
Liked Product = 350
Disliked Product = 150
```

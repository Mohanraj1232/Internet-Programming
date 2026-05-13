Yes. You can run Servlets in **NetBeans** easily, and for Java Web projects many students find it simpler than Eclipse.

---

# How to Run Servlet Program in NetBeans

## Step 1: Install Required Software

Install:

* Java JDK
* NetBeans IDE
* Apache Tomcat

Downloads:

* [NetBeans IDE](https://netbeans.apache.org/download/index.html?utm_source=chatgpt.com)
* [Apache Tomcat](https://tomcat.apache.org/download-90.cgi?utm_source=chatgpt.com)

---

# Step 2: Configure Tomcat in NetBeans

1. Open NetBeans
2. Go to:

```text id="7wbxsh"
Tools → Servers
```

3. Click:

```text id="mp9m24"
Add Server
```

4. Select:

```text id="i7hljw"
Apache Tomcat
```

5. Browse Tomcat installation folder
6. Finish

---

# Step 3: Create Web Application

1. Click:

```text id="h32o1l"
File → New Project
```

2. Select:

```text id="ivb6sq"
Java with Ant → Web Application
```

(or Jakarta EE/Web Application depending on version)

3. Project Name:

```text id="mlr87v"
ServletDemo
```

4. Choose Tomcat Server
5. Finish

---

# Step 4: Create HTML File

Inside:

```text id="0fux0z"
Web Pages
```

Create:

```text id="b5l9ef"
index.html
```

Paste HTML code.

---

# Step 5: Create Servlet

1. Right click:

```text id="zt8n2h"
Source Packages
```

2. New → Servlet

3. Servlet Name:

```text id="9g12nv"
LoginServlet
```

4. Finish

NetBeans automatically creates servlet structure.

Replace generated code with your servlet code.

---

# Step 6: Run Project

Click:

```text id="bjg8n8"
Run Project
```

or press:

```text id="wivfd8"
F6
```

NetBeans starts Tomcat automatically.

---

# Step 7: Open Browser

Usually NetBeans opens browser automatically.

Otherwise open:

```text id="ck5vkq"
http://localhost:8080/ServletDemo/index.html
```

---

# Important Note

In newer NetBeans/Tomcat versions:

* `javax.servlet.*` may become:

```java id="i4jvwl"
jakarta.servlet.*
```

If errors occur, use:

```java id="2q4jj8"
import jakarta.servlet.*;
import jakarta.servlet.http.*;
```

instead of:

```java id="a4p6g7"
import javax.servlet.*;
import javax.servlet.http.*;
```

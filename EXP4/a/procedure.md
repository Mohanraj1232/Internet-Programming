# How to Run Servlet Program in Eclipse with Tomcat

## Step 1: Install Required Software

* Install Java JDK
* Install Eclipse IDE for Enterprise Java
* Install Apache Tomcat Server

Official sites:

* [Java JDK](https://www.oracle.com/java/technologies/downloads/?utm_source=chatgpt.com)
* [Eclipse IDE](https://www.eclipse.org/downloads/?utm_source=chatgpt.com)
* [Apache Tomcat](https://tomcat.apache.org/download-90.cgi?utm_source=chatgpt.com)

---

# Step 2: Create Dynamic Web Project

1. Open Eclipse
2. Click:

```text id="e8cv8h"
File → New → Dynamic Web Project
```

3. Enter Project Name
   Example:

```text id="m1vwyf"
ServletDemo
```

4. Click **Finish**

---

# Step 3: Create HTML File

Inside:

```text id="6jlwm4"
WebContent
```

or

```text id="o1h5c2"
src/main/webapp
```

Create:

```text id="c1r0ww"
index.html
```

Paste the HTML code.

---

# Step 4: Create Servlet Class

1. Right click `src`
2. New → Class
3. Name:

```text id="glkm30"
LoginServlet
```

Paste servlet code.

---

# Step 5: Add Servlet Library (Important)

If red errors appear for:

```java id="rvv7rk"
javax.servlet.*
```

Add Tomcat server runtime:

### Steps:

1. Right click project
2. Properties
3. Java Build Path
4. Libraries
5. Add Library
6. Server Runtime
7. Select Apache Tomcat
8. Finish

---

# Step 6: Configure `web.xml`

Open:

```text id="ag19yv"
WEB-INF/web.xml
```

Paste:

```xml id="z1k5gt"
<web-app>

    <servlet>
        <servlet-name>LoginServlet</servlet-name>
        <servlet-class>LoginServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>LoginServlet</servlet-name>
        <url-pattern>/LoginServlet</url-pattern>
    </servlet-mapping>

</web-app>
```

---

# Step 7: Configure Tomcat Server

1. Bottom panel → Servers
2. Right click → New → Server
3. Select Apache Tomcat
4. Browse Tomcat folder
5. Finish

---

# Step 8: Run Project

Right click project → Run As → Run on Server

Choose Tomcat.

---

# Step 9: Open Browser

Run:

```text id="rq8fca"
http://localhost:8080/ServletDemo/index.html
```

---

# Expected Output

* Form page opens
* Enter username and password
* If password = `admin`
  → Login Successful
* Otherwise
  → Invalid Password

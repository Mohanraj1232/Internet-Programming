<%@ page import="javax.servlet.http.*" %>

<html>
<body>

<h2>Cart</h2>

<%
Cookie c[] = request.getCookies();

for(Cookie x : c)
{
    if(x.getName().equals("cart"))
    {
        out.println(x.getValue()+"<br>");
    }
}
%>

</body>
</html>
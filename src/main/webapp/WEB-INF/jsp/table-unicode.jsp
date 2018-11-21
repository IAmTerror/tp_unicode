<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Unicode</title>
</head>
<body>
<h1>Les caractères Ascii de 33 à 255</h1>
<p/>
<hr width="100%"/>

<table border="1">
    <c:forEach var="index" items="${indexAscii}">
        <td>
            <div class="code" style="background-color:lightblue">${index}</div>
            <div class="caractere" style="background-color:greenyellow">&#${index};</div>
            <c:if test = "${index%32==0}">
                <tr></tr>
            </c:if>
        </td>
    </c:forEach>
</table>

<%--<table>--%>
    <%--<c:forEach var="index" items="${indexAscii}">--%>
    <%--<tbody>--%>
    <%--<tr> <td><div>64</div> <div>&#64;</div> </td>--%>
        <%--<td><div>65</div> <div>&#65;</div></td>--%>
        <%--<td><div>66</div> <div>&#66;</div></td>--%>
    <%--</tr>--%>
    <%--</tbody>--%>
<%--</table>--%>
<%--</body>--%>
<%--</c:forEach>--%>

</html>

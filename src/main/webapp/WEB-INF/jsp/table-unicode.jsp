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
            <div>${index}</div>
            <div>&#${index};</div>
            <c:if test = "${index%32==0}">
                <tr></tr>
            </c:if>
        </td>
    </c:forEach>
</table>

</body>
</html>

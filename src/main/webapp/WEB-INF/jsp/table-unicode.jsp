<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="style.css" />
    <title>Unicode</title>
</head>
<body>
<h1>Les caractères Ascii de 33 à 255 : </h1>

<table>
    <c:forEach var="code" items="${codeAscii}">
        <td>
            <div class="code">${code}</div>
            <div class="caractere">&#${code};</div>
            <c:if test = "${code%32==0}">
                <tr></tr>
            </c:if>
        </td>
    </c:forEach>
</table>

</body>
</html>

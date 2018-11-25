<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="style.css" />
    <title>Unicode</title>
</head>
<body>

<c:choose>
    <c:when test="${not empty titre}">
        <h1>${titre}</h1>
    </c:when>
    <c:otherwise>
        <h1>Les caractères Unicode de 33 à 255 : </h1>
    </c:otherwise>
</c:choose>

<table>
    <c:forEach var="code" items="${codes}">
        <td>
            <div class="code">${code.key}</div>
            <div class="caractere">&#${code.value};</div>
            <c:if test = "${code.value%32==0}">
                <tr></tr>
            </c:if>
        </td>
    </c:forEach>
</table>

</body>
</html>

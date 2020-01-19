<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<body>
    <h1>Hello Swayer!</h1>
    <h2>${greeting}</h2>
    <form:form action="/save" modelAttribute="sway" method="post">
        <h3>Channel name: ${sway.channel}</h3>
        <form:hidden path="channel"/>
        <form:input path="text"/>
        <input type="submit" value="Sway!"/>
    </form:form>
    <c:forEach var="sway" items="${listOfSways}">
        <c:out value="${sway.id}"/>
        <c:out value="${sway.text}"/>
        <br/>
    </c:forEach>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
    <h1>Hello Swayer!</h1>
    <h2>${greeting}</h2>
    <h3>Channel name: ${channel}</h3>
    <form:form action="/save" modelAttribute="sway" method="post">
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

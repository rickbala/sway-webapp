<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
    <h1>Hello Swayer!</h1>
    <h2>${greeting}</h2>
    <form:form action="/save" modelAttribute="sway" method="POST">
        <form:input path="text" />
        <input type="submit" value="Sway!" />
    </form:form>
</body>
</html>
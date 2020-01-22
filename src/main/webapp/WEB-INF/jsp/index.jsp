<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="favicon.ico">
    <title>Hello Swayer!</title>
</head>
<body>
    <h1>Hello Swayer!</h1>
    <h2>${greeting}</h2>
    <form:form action="/save" modelAttribute="sway" method="post">
        <h3>Channel name: ${sway.channel}</h3>
        <h4><a href="${randomChannel}">Create Random</a></h4>
        <form:hidden path="channel"/>
        <form:input path="text"/>
        <input type="submit" value="Sway!"/>
        <br/><input type="checkbox" id="autoUpdate" onclick="setAutoUpdate(this.checked)"/> Autoupdate
    </form:form>
    <c:forEach var="sway" items="${listOfSways}">
        <c:out value="${sway.text}"/>
        <br/>
    </c:forEach>
</body>
<script>
    function setAutoUpdate(checked){
        checked ? localStorage.setItem("autoUpdate", "true") : localStorage.setItem("autoUpdate", "false");
    }
    var autoUpdate = localStorage.getItem("autoUpdate");
    if (autoUpdate == "true")
        document.getElementById('autoUpdate').checked = true;
    setTimeout(function(){
        if (document.getElementById('autoUpdate').checked){
            window.location.reload(1);
        }
    }, 5000);
</script>
</html>

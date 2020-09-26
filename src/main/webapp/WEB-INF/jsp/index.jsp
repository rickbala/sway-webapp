<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="favicon.ico">
    <title>Hello Swayer!</title>
    <style>
        #linkPrevious{text-decoration: none; position: absolute; top: 1px; right: 12px;margin: auto;}
        #linkNext{text-decoration: none; position: absolute; top: 1px; right: 1px;margin: auto;}
    </style>
</head>
<body>
    <a id="linkPrevious" href="http://communication-webapp.herokuapp.com"><</a>
    <a id="linkNext" href="https://stream2me-webapp.herokuapp.com">></a>
    <h1>Hello <span onclick="window.location.href='/'">Swayer!</span></h1>
    <h2>${greeting}</h2>
    <form:form action="/save" modelAttribute="sway" method="post">
        <span onclick="changeChannel()"><h3>Channel name: ${sway.channel}</h3></span>
        <h4><a href="${randomChannel}">Create Random</a></h4>
        <form:hidden path="channel"/>
        <form:input path="text" id="swayInput"/>
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
    function changeChannel(){
        var channel = prompt("Enter channel name:");
        if (channel != null) {
            window.location.href = "/" + channel;
        }
    }
    document.addEventListener("DOMContentLoaded", function(event) { //dom is ready
        document.getElementById("swayInput").focus();
    });
</script>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Create accident</title>
</head>
<body>
<div class="container pt-3">
    <div style="text-align: right">
        <h3 style="float: left">Create accident</h3>
        <a class="btn btn-info" style="padding: 5px" href="<c:url value='/'/>">Home</a>
    </div>
    <br>

    <form action="<c:url value='/save'/>" method="post">

        <div class="mb-3">
            <label for="name">Name</label>
            <input type="text" class="form-control" name="name" id="name">
        </div>

        <div class="mb-3">
            <label for="text">Description</label>
            <textarea class="form-control" name="text" id="text"></textarea>
        </div>

        <div class="mb-3">
            <label for="address">Address</label>
            <input type="text" class="form-control" name="address" id="address">
        </div>

        <div class="mb-3">
            <label>Type: </label>
            <select name="type.id">
                <c:forEach var="type" items="${types}">
                    <option value="${type.id}">${type.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label>Rule: </label>
            <select name="rIds" multiple>
                <c:forEach var="rule" items="${rules}">
                    <option value="${rule.id}">${rule.name}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-success">Create</button>
    </form>
</div>
</body>
</html>
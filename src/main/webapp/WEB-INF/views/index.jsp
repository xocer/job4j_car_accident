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


    <title>Accident</title>
</head>
<body>
<div class="container pt-3">

    <div style="text-align: right">
        <h3 style="float: left">Accidents list</h3>
        <strong>${user.username} | </strong>
        <a class="btn btn-outline-danger btn-sm" style="padding: 1px" href="<c:url value='/logout'/>">sign out</a>
    </div>
    <br>

    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Type</th>
            <th>Description</th>
            <th>Address</th>
            <th>Rule</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${accidents}" var="accident">
            <tr>
                <td>
                    <c:out value="${accident.id}"/>
                </td>
                <td>
                    <c:out value="${accident.name}"/>
                </td>
                <td>
                    <c:out value="${accident.type.name}"/>
                </td>
                <td>
                    <c:out value="${accident.text}"/>
                </td>
                <td>
                    <c:out value="${accident.address}"/>
                </td>
                <td>
                    <c:forEach items="${accident.rules}" var="rule">
                        <c:out value="${rule.name}"/><br>
                    </c:forEach>
                </td>
                <td class="text-center">
                    <a href="<c:url value='/edit?id=${accident.id}'/>">
                        <i class="fa fa-edit mr-3"></i>
                    </a>
                    <a href="<c:url value='/delete?id=${accident.id}'/>">
                        <i class="fa fa-minus-circle mr-3"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value='/create'/>">Add accident</a>
</div>
</body>
</html>
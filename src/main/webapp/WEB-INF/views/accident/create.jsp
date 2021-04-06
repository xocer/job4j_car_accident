<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Bootstrap CSS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"
            type="text/javascript"></script>

    <title>Добавить</title>
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <form action="<c:url value='/save'/>" method="post">

                <div class="form-group">
                    <label for="name">Название</label>
                    <input type="text" class="form-control" name="name" id="name">
                </div>

                <div class="form-group">
                    <label for="text">Описание</label>
                    <input type="text" class="form-control" name="text" id="text">
                </div>

                <div class="form-group">
                    <label for="address">Адрес</label>
                    <input type="text" class="form-control" name="address" id="address">
                </div>

                <div class="form-group">
                    <label>Тип:</label>
                    <select name="type.id">
                        <c:forEach var="type" items="${types}" >
                            <option value="${type.id}">${type.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Создать</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
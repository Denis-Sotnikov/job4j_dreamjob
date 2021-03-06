<%@ page import="ru.job4j.dream.model.User" %>
<%@ page import="ru.job4j.dream.model.Candidate" %>
<%@ page import="ru.job4j.dream.store.PsqlStore" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <title>Работа мечты</title>
    <script>
        function validate() {
            valid = true;
            if ($('#name').val() === '') {
                alert("Input name");
                valid = false;
            }
            if ($('#CitySelect').val() === '') {
                alert("Input city");
                valid = false;
            }
            return valid;
        }
        $(document).ready(function() {
            var load = true;
            $("#CitySelect").click(function () {
                if (load === true) {
                    $.ajax({
                        type: "GET",
                        url: "http://localhost:8080/dreamjob/city"
                    }).done(function(data) {
                        var cityList = $("#CitySelect");
                        $.each(data, function (key, value) {
                            cityList.append("<option value=" + key + ">" + value + "</option>");
                        });
                    }).fail(function() {
                        alert("Could not load data")
                    });
                    load = false;
                }
            });
        });
    </script>
</head>
<body>

<%
    User userMain = new User();
    HttpSession sc = request.getSession();
    if (sc.getAttribute("user") != null) {
        userMain = (User) sc.getAttribute("user");
    }
    String id = request.getParameter("id");
    Candidate candidate = new Candidate(0, "");
    if (id != null) {
        candidate = PsqlStore.instOf().findCandidateById(Integer.valueOf(id));
    }
%>

<div class="container pt-3">
    <div class="row">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp"> <c:out value="<%=userMain.getName()%>"/> | Выйти</a>
            </li>
        </ul>
    </div>
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <% if (id == null) { %>
                Новый кандидат.
                <% } else { %>
                Редактирование кандидата.
                <% } %>
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/candidates.do?id=<%=candidate.getId()%>" method="post">
                    <div class="form-group">
                        <label>Имя</label>
                        <input type="text" class="form-control" name="name" value="<%=candidate.getName()%>" id="name">
                    </div>
                    <div class="form-group">
                        <label for="CitySelect">Город</label>
                        <select class="browser-default custom-select"  name="cityId"
                                id="CitySelect">
                            <option value="" hidden>Выберите город</option>
                        </select>
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary" onclick="return validate();">Сохранить</button>
                </form>
                <br>
                <b>Загрузить фотографию</b>
                <form action="<c:url value='/upload'/>" method="post" enctype="multipart/form-data">
                    <div class="checkbox">
                        <input type="file" name="file">
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary">Загрузить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
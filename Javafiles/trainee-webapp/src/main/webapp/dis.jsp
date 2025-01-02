<%@ page import="traineeapp.model.Trainee" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trainee Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2>Trainee Details</h2>

        <%
            Trainee trainee = (Trainee) request.getAttribute("trainee");
            if (trainee != null) {
        %>
            <ul class="list-group mt-3">
                <li class="list-group-item">ID: <%= trainee.getId() %></li>
                <li class="list-group-item">Name: <%= trainee.getName() %></li>
                <li class="list-group-item">Location: <%= trainee.getLocation() %></li>
                <li class="list-group-item">Joined Date: <%= trainee.getJoinedDate() %></li>
            </ul>
        <%
            } else {
        %>
            <p class="text-danger">No trainee found with the provided ID</p>
        <%
            }
        %>
         <a href="trainees/get" class="btn btn-secondary mt-3">Back to Trainee List</a>
    </div>
</body>
</html>










<%--

<%@ page import="traineeapp.model.Trainee" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trainee Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-4">
        <h2>Trainee Details</h2>

        <c:choose>
            <c:when test="${not empty trainee}">
                <ul class="list-group mt-3">
                    <li class="list-group-item">ID: ${trainee.id}</li>
                    <li class="list-group-item">Name: ${trainee.name}</li>
                    <li class="list-group-item">Location: ${trainee.location}</li>
                    <li class="list-group-item">Joined Date: ${trainee.joinedDate}</li>
                </ul>
            </c:when>
            <c:otherwise>
                <p class="text-danger">No trainee found with the provided ID</p>
            </c:otherwise>
        </c:choose>

        <a href="trainees/get" class="btn btn-secondary mt-3">Back to Trainee List</a>
    </div>
</body>
</html>
--%>
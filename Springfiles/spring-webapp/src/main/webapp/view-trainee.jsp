<%@page isELIgnored="false"%>
<%@ page import="com.ust.webapp.model.Trainee" isELIgnored="false" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <title>view-trainee</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<header>
<nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
  <div class="container-fluid">
      <a class="navbar-brand text-white" href="/trainee.jsp">Trainee Management System</a>
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link text-white" href="/trainee.jsp">Add Trainee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/view-trainee">View Trainees</a>
            </li>
            <li class="nav-item">
                <form class="d-flex" action="/get-trainee" method="get">
                    <input class="form-control me-2" type="text" name="id" placeholder="Enter Trainee ID" aria-label="Search"  style="height: 40px; width: 150px;">
                    <button class="btn btn-outline-light" type="submit">Get Trainee</button>
               </form>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/delete-trainee">Delete Trainee</a>
            </li>
        </ul>
    </div>
</nav>
</header>

 <h1 class="text-center">Trainee Details</h1>

 <%
     List<Trainee> trainees = (List<Trainee>) request.getAttribute("trainees");
 %>
 <div class="container mt-4">
     <div class="row">
         <% for (Trainee trainee : trainees) { %>
             <div class="col-md-4">
                 <div class="card mb-4">
                     <div class="card-body">
                         <h5 class="card-title">Trainee Id: <%= trainee.id() %></h5>
                         <h6 class="card-subtitle mb-2 text-muted">Trainee Name: <%= trainee.name() %></h6>
                         <p class="card-text">Trainee Location: <%= trainee.location() %></p>
                         <form action="/delete-trainee" >
                         <button class="btn btn-danger" name=id value=<%= trainee.id() %>>Delete</button>
                         </form>
                     </div>
                 </div>
             </div>
         <% } %>
     </div>
 </div>

</body>
</html>

<%@page isELIgnored="false"%>
<%@ page import="com.TaskManagement.dto.TaskDto" isELIgnored="false" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tasks</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        html,body{
            height: 100%;
        }
        body {
            display: flex;
            flex-direction: column;
            background-color: aliceblue;
        }
        footer {
            margin-top: auto;
        }
    </style>
</head>
<body >
    <header >
        <nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
            <div class="container-fluid">
                 <h4 class="text-white">Task Management</h4>
                  <ul class="nav">
                    <li class="nav-item">
                        <a class="nav-link text-white" href="index.jsp"><h5>Home</h5></a>
                    </li>
                      <li class="nav-item">
                          <a class="nav-link text-white" href="/view-task"><h5>Tasks</h5></a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link text-white" href="index.jsp"><h5>About</h5></a>
                      </li>
                  </ul>
              </div>
          </nav>
    </header>

    <main>

    <h1 class="text-center;">Task List</h1>

 <%
     List<TaskDto> tasks = (List<TaskDto>) request.getAttribute("tasks");
 %>
 <div class="container mt-4">
     <div class="row">
         <% for (TaskDto task : tasks) { %>
             <div class="col-md-4">
                 <div class="card mb-4">
                     <div class="card-body">
                         <h5 class="card-title">Task Id: <%= task.id() %></h5>
                         <h6 class="card-subtitle mb-2 text-muted">Task Name: <%= task.name() %></h6>
                         <p class="card-text">Task Description: <%= task.description() %></p>
                         <p class="card-text">Task DueDate: <%= task.dueDate() %></p>
                         <p class="card-text">Task completed: <%= task.completed() %></p>
                       <div class="d-flex">
                         <form action="/delete-task" class="me-2" method="post">
                            <button type="submit" class="btn btn-danger" name="id" value="<%= task.id() %>">Delete</button>
                         </form>
                         <form action="/update-task" method="post">
                            <button type="submit" class="btn btn-dark" name="id" value="<%= task.id() %>">Update</button>
                         </form>
                        </div>
                     </div>
                 </div>
             </div>
         <% } %>
     </div>
 </div>
    </main>

    <footer>
        <div style="background-color: #343a40;color: white;text-align:center;padding: 10px 0;">
             <p>&copy;Task Management web app. All rights reserved.</p>
        </div>
    </footer>

</body>
</html>

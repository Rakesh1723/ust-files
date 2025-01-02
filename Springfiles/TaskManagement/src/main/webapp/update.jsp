<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>
    <header>
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

    <main style="height:83vh;background-color: aliceblue;">
          <form action="/update-task" >
            <div class="mb-3">
              <label class="form-label">ID</label>
              <input type="number" class="form-control" name="id" placeholder="Enter task id" required >
            </div>
            <div class="mb-3">
              <label class="form-label">Name</label>
              <input type="text" class="form-control" name="name" placeholder="Enter task name" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Description</label>
                <input type="text" class="form-control" name="description" placeholder="Enter task description" required>
            </div>
            <div class="mb-3">
                <label  class="form-label">DueDate</label>
                <input type="date" class="form-control" name="dueDate" placeholder="Enter task dueDate" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Completed</label>
                <select name="completed" class="form-control mt-2" required>
                    <option value="" disabled selected>Select Status</option>
                    <option value="true">true</option>
                    <option value="false">false</option>
                </select>
            </div>
            <button type="submit" onclick="alertFun()" class="btn btn-primary" >Save</button>
          </form>
    </main>


    <footer>
        <div style=" background-color: #343a40;color: white;text-align:center;padding: 10px 0;">
             <p>&copy;Task Management web app. All rights reserved.</p>
        </div>
    </footer>

    <script>
         function alertFun(){
            alert("Task updated Successfully!");
            }
    </script>

</body>
</html>


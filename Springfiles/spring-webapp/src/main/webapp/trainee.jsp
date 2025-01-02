<!doctype html>
<html lang="en">
<head>
    <title>trainee</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
       <style>
             .form-container {
                 max-width: 500px;
                 margin: 50px auto;
                 padding: 20px;
                 border: 1px solid #ced4da;
                 border-radius: 0.25rem;
                 background-color: #ffffff;
                 box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
             }
         </style>
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
  <h1 class="text-center" style="margin-top:10px;">Trainee Registration</h1>

    <div class="container">
         <div class="form-container">
             <h2 class="text-center mb-4">Enroll Trainee</h2>
             <form action="/add-trainee" method="post">
                 <div class="mb-3">
                     <label class="form-label">Id</label>
                     <input type="number" name="id" placeholder="Please enter your id" class="form-control" required>
                 </div>
                 <div class="mb-3">
                     <label class="form-label">Name</label>
                     <input type="text" name="name" placeholder="Please enter your name" class="form-control" required>
                 </div>
                 <div class="mb-3">
                     <label class="form-label">Location</label>
                     <input type="text" name="location" placeholder="Please enter your location" class="form-control" required>
                 </div>
                 <button type="submit" class="btn btn-dark" onclick="return alertFun()">Submit</button>
             </form>
         </div>
     </div>

  <script>
     function alertFun(){
      alert("Trainee added Successfully!");
       return true;
      }
  </script>

 </body>
</html>

<html>
<head>
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
<jsp:include page="header.jsp" />
<h2>Employee Details</h2>
<%--form action="add-trainees" method="post"--%>
<p><a href="trainees/get">View Trainees</a></p>
<form action="trainees/add" method="post">
<input type="number" name="id" id="id" placeholder="Input your id">
<input type="text" name="username" placeholder="Enter your name">
<input type="text" name="location" id="location" placeholder="Input your location">
<input type="date" name="joindate" id="joinDate" placeholder="Input your joinDate">
<button type="submit">Enter</button>
</form>
</body>
</html>

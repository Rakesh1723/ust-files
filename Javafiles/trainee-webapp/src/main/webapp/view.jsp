<%@ page import="traineeapp.model.Trainee" isELIgnored="false" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>View</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
<jsp:include page="header.jsp" />
   <%
   List<Trainee> trainees = (List<Trainee>) request.getAttribute("trainees");
    out.println("<table class='table table-light'><tr><th>ID</th><th>Name</th><th>Location</th><th>Joined Date</th><th>Delete Trainee</th></tr>");
    for(Trainee trainee : trainees){
        out.println("<tr><td>" + trainee.getId() + "</td><td>" + trainee.getName() + "</td><td>" + trainee.getLocation() + "</td><td>" + trainee.getJoinedDate() + "</td>"
        +"<td><button><a href=trainees/delete?id="+trainee.getId()+">Delete</a></button></td></tr>");
    }
    out.println("</table>");
   %>
 </div>
</body>
</html>



<%--
<!DOCTYPE html>
<html>
<head>
<title>view jsp</title>
</head>
<body>
<%! <!inside class>
  public void show(){
   out.println("<html>");
   out.println("<head>");
   out.println("<title>view jsp</title>");
   out.println("</head>");
   out.println("<body>");
  }
%>
<h2>hello <%= request.getParameter("username")%>!</h2>
<%
 Trainee trainee =(Trainee) request.getAttribute("trainee");  <!script , inside method>
%>
<h2>Hello <%= trainee.getName() %>!</h2>  <!expression inside print>
</body>
</html>

import
class View{
    service(){
        out.println("<html>");
        out.println("<head>");
        .....
        Trainee trainee = (Trainee) request.getAttribute("trainee");
        out.println("<h2>Hello " + trainee.getName() + "!</h2>");
--%>







package traineeapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import traineeapp.model.Trainee;
import traineeapp.repository.TraineeRepository;
import traineeapp.repository.TraineeRepositoryImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/add-trainees")
@WebServlet("/trainees/*")
public class TraineeController extends HttpServlet {
    TraineeRepository traineeRepository;

    public void init() throws ServletException {
        traineeRepository = new TraineeRepositoryImpl();
    }

    protected void addTrainee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("username");
        String location = req.getParameter("location");
        LocalDate date = LocalDate.parse(req.getParameter("joindate"));
        Trainee trainee = new Trainee(id, name, location, date);
        traineeRepository.save(trainee);
        List<Trainee> trainees = traineeRepository.getAllTrainees();
        req.setAttribute("trainees", trainees);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getRequestURI();
        System.out.println(path);
        if (path.contains("/add")) {
            addTrainee(req, resp);
        } else if (path.contains("/getById")) {
            getByIdTrainee(req, resp);
        } else if (path.contains("/get")) {
            getAllTrainee(req, resp);
        } else if (path.contains("/delete")) {
            deleteTrainee(req, resp);
        }
    }

    private void getAllTrainee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view.jsp");
        List<Trainee> trainees = traineeRepository.getAllTrainees();
        req.setAttribute("trainees", trainees);
        requestDispatcher.forward(req, resp);

    }

    private void getByIdTrainee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id =Integer.parseInt(req.getParameter("id"));
        Trainee trainee=traineeRepository.getTrainee(id);
        System.out.println(trainee);
        req.setAttribute("trainee", trainee);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dis.jsp");
        requestDispatcher.forward(req, resp);

    }

    private void deleteTrainee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        traineeRepository.deleteTrainee(id);
        List<Trainee> trainees = traineeRepository.getAllTrainees();
        req.setAttribute("trainees", trainees);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view.jsp");
        requestDispatcher.forward(req, resp);

    }
}






//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id=Integer.parseInt(req.getParameter("id"));
//        String name = req.getParameter("username");
//        String location = req.getParameter("location");
//        String date = req.getParameter("joindate");
//        Trainee trainee = new Trainee(id, name, location, LocalDate.parse(date));
//        traineeRepository.save(trainee);
//        List<Trainee> trainees = traineeRepository.getAllTrainees();
//        req.setAttribute("trainees", trainees);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view.jsp");
//
//        requestDispatcher.forward(req,resp);
//    }


   /* TraineeRepositoryImpl traineeRepository=new TraineeRepositoryImpl();
     //doPost is only for posting and service is for both post and get
     protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id=Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("username");
        String location = req.getParameter("location");
        String date = req.getParameter("joindate");


        traineeRepository.save(new Trainee(id,name,location,LocalDate.parse(date)));
        List<Trainee> al=traineeRepository.getAllTrainees();
         al.stream().forEach(System.out::println);
        PrintWriter out = resp.getWriter();            //html inside java
            out.println("""
                        <html>
                            <head>
                                <title>Hello World</title>
                            </head>
                            <body>
                                 <table>
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Location</th>
                                                <th>Join Date</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                       """);
                          for(Trainee i:al) { out.println("""
                                             <td>%d</td>
                                             <td>%s</td>
                                             <td>%s</td>
                                             <td>%s</td>
                                        </tbody>
                                    </table>
                             </body>
                          </html>
                    """.formatted(i.getId(),i.getName(),i.getLocation(),i.getJoinedDate()));
        }
    } */


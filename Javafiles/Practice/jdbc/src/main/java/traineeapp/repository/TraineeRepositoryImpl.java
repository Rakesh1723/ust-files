package traineeapp.repository;



import traineeapp.model.Trainee;
import traineeapp.util.JdbcConnectionUtil;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TraineeRepositoryImpl implements TraineeRepository {


    public Trainee save(Trainee trainee) {

        Connection connection = JdbcConnectionUtil.createConnction();

        String sql = "insert into trainee(name,location,date_joined) values(?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,trainee.name());
            statement.setString(2,trainee.location());
            statement.setDate(3, Date.valueOf(trainee.joinedDate()));
          //  statement.setString(3,trainee.joinedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            int rowCount = statement.executeUpdate();
            System.out.println(rowCount+" rows inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        String sql = """
//                insert into trainee(name,location,date_joined)
//                values('%s','%s','%s')
//                """.formatted(trainee.name(),
//                trainee.location(),
//                trainee.joinedDate().toString());
//
//        try {
//            Statement statement = connection.createStatement();
//            int rowCount = statement.executeUpdate(sql);
//            System.out.println(rowCount + " rows inserted");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        return trainee;
    }

    public Trainee getTrainee(int id) {
        Connection connection = JdbcConnectionUtil.createConnction();
        String sql = """
                select * from trainee where id = ?
                """;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                LocalDate joinedDate = resultSet.getDate("date_joined").toLocalDate();
                Trainee trainee = new Trainee(id1, name, location, joinedDate);
                return trainee;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Trainee> getAllTrainees() {
        Connection connection = JdbcConnectionUtil.createConnction();
        String sql = """
                select * from trainee
                """;
        List<Trainee> trainees = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                LocalDate joinedDate = resultSet.getDate("date_joined").toLocalDate();
                Trainee trainee = new Trainee(id, name, location, joinedDate);
                trainees.add(trainee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trainees;
    }

    public void deleteTrainee(int id) {
        Connection connection = JdbcConnectionUtil.createConnction();
        String sql = """
                delete from trainee where id = ?
                """;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int rowCount  = ps.executeUpdate();
            if(rowCount != 0)
                System.out.println(rowCount + " rows inserted");
            else
                System.out.println("id not found");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  Trainee getTraineeFromResultSet(ResultSet resultSet){
        Trainee trainee =null;
        try{
            if(resultSet.next())
            {    int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                LocalDate joinedDate = resultSet.getDate("date_joined").toLocalDate();
                 trainee = new Trainee(id, name, location, joinedDate);
            }
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return trainee;
    }

}

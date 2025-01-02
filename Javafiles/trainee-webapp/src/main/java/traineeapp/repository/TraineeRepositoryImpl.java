package traineeapp.repository;

import traineeapp.model.Trainee;
import traineeapp.util.JdbcConnectionUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TraineeRepositoryImpl implements TraineeRepository {


    public Trainee save(Trainee trainee) {

        Connection connection = JdbcConnectionUtil.createConnction();

        String sql = "insert into trainee(name,location,date_joined) values(?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,trainee.getName());
            statement.setString(2,trainee.getLocation());
            statement.setDate(3, Date.valueOf(trainee.getJoinedDate()));
            int rowCount = statement.executeUpdate();
            System.out.println(rowCount+" rows inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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


}


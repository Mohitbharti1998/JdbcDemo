package org.spring.dao;

import org.spring.model.Circle;

import java.sql.*;

public class JdbcDaoImpl {
    public Circle getCircle(int circleId){

        Connection connection = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "Mohit@123");


            PreparedStatement ps = connection.prepareStatement("Select * from circle where id = ?");

            ps.setInt(1, circleId);

            Circle circle = null;

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                circle = new Circle(circleId, rs.getString("name"));
            }

            rs.close();
            ps.close();

            return circle;
        }catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return null;

    }
}

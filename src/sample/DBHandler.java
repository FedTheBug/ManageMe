package sample;

import java.sql.*;

public class DBHandler extends Config{
    Connection dbConnection;

    public Connection getDbConnection(){
        String connectionString = "jdbc:mysql://"+ dbHost+":" + dbPort + "/" + dbName;
        try {
            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dbConnection;
    }
    public void SignUpUser(User user){
        String insert = "INSERT INTO " + Const.USERS_TABLE + "(" + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + ","+
                Const.USERS_USERNAME+","+Const.USERS_PASSWORD +","+Const.USERS_LOCATION +","+ Const.USERS_GENDER+")"+ "VALUES(?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert)) {
            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getUserName());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setString(5,user.getLocation());
            preparedStatement.setString(6,user.getGender());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ResultSet getUser(User user) throws SQLException {
        ResultSet resultSet = null;
        if(!user.getUserName().equals("") || !user.getPassword().equals("")){
            String query = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " + Const.USERS_USERNAME + "=?" + " AND " + Const.USERS_PASSWORD +
                    "=?";
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassword());

            resultSet = preparedStatement.executeQuery();

        }
        else{
            System.out.println("Please enter valid credentials");
        }
        return resultSet;

    }

}
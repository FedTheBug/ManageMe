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
    public void InsertTask(Task task){
        String insert = "INSERT INTO " + Const.TASKS_TABLE + "(" + Const.TASKS_TASK + ","+ Const.USERS_ID +","  + Const.TASKS_DATE + ","+
                Const.TASKS_DESCRIPTION +")"+ "VALUES(?,?,?,?)";

        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert)) {
            preparedStatement.setString(1,task.getTask());
            preparedStatement.setInt(2, task.getUserID());
            preparedStatement.setTimestamp(3,task.getDateCreated());
            preparedStatement.setString(4,task.getDescription());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public int GetAllTask(int UserID) throws SQLException {
        String query = "SELECT COUNT(*) FROM " + Const.TASKS_TABLE + " WHERE " + Const.USERS_ID + "=?";

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        preparedStatement.setInt(1, UserID);
        ResultSet resultSet = preparedStatement.executeQuery();
        while ((resultSet.next())){
            return resultSet.getInt(1);
        }
        return resultSet.getInt(1);
    }

}
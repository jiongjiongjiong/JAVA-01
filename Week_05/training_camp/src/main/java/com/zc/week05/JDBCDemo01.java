package com.zc.week05;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: zhangc
 * @date: 2021/2/20
 * @desc:
 */
public class JDBCDemo01 {
    private static  String url;
    private static  String username;
    private static  String password;
    static {
        url = "127.0.0.1:3306";
        username = "root";
        password = "root";

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void doClose(Connection connection) {
        try{
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        String querySql = "select * from t_school";
        ResultSet resultSet = connection.createStatement().executeQuery(querySql);
        while (resultSet.next()){
            System.out.println(resultSet.getMetaData().getColumnName(1));
        }
        doClose(connection);
    }



}

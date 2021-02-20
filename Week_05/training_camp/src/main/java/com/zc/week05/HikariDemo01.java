package com.zc.week05;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: zhangc
 * @date: 2021/2/20
 * @desc:
 */
public class HikariDemo01 {


    private static  String url;
    private static  String username;
    private static  String password;
    private static HikariDataSource dataSource;
    static {
        url = "127.0.0.1:3306";
        username = "root";
        password = "root";
        HikariConfig hikariConfig  = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        dataSource = new HikariDataSource(hikariConfig);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }



    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        String querySql = "select * from t_school";
        ResultSet resultSet = connection.prepareStatement(querySql).executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getMetaData().getColumnName(1));
        }
    }

}

package cn.qjq.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 自建JDBC接口，将前面的程序进行封装
 * Created by qjq on 2020/1/17 20:28
 */
public class JDBCUtil {
    static Properties properties = null;//可以帮助配置资源文件中的信息
    static {//加载JDBCUtil类时调用
        properties = new Properties();
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("db.properties").getPath();
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static Connection getMysqlConn(){

        try {
            //加载驱动类
            Class.forName(properties.getProperty("mysqlDriver"));
            //建立连接
            return DriverManager.getConnection(properties.getProperty("mysqlURL"),
                    properties.getProperty("mysqlUser"),properties.getProperty("mysqlPwd"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    //关闭资源
    public static void close(ResultSet rs, PreparedStatement ps,Connection connection){
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement ps,Connection connection){

        try {
            if(ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection connection){

        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

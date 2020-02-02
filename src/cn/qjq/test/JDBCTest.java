package cn.qjq.test;

import cn.qjq.jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by qjq on 2020/2/2 12:53
 */
public class JDBCTest {
    public static void jdbcConnectionTest(){
        Connection conn = JDBCUtil.getMysqlConn();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from emp where id = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("id")+"--"+rs.getString("empname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询完毕");
    }

    public static void main(String[] args) {
        jdbcConnectionTest();
    }
}

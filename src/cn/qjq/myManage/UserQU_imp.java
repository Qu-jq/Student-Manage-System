package cn.qjq.myManage;

import cn.qjq.bean.User;
import cn.qjq.jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by qjq on 2020/2/2 19:14
 */
public class UserQU_imp implements UserQu {
    @Override
    public int login(User user) {
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int type = -1;
        try {
            ps = conn.prepareStatement("select type from user where uname = ? and upass = ?");
            ps.setString(1,user.getUname());//设置第一个问号的值
            ps.setString(2,user.getUpass());//设置第二个问号的值
            rs = ps.executeQuery();

            while(rs.next()){
                type = rs.getInt("type");
            }
            return type;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }
        return -1;//登录失败
    }

    @Override
    public boolean insert(User user) {
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        try {
            //数据库中已经将type的默认值设置为2，所以这里不需要设置type的值
            ps = conn.prepareStatement("insert into user(uname,upass) values (?,?)");
            ps.setString(1,user.getUname());//设置第一个问号的值
            ps.setString(2,user.getUpass());//设置第二个问号的值
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(ps,conn);
        }
        return false;
    }

    @Override
    public boolean delete(String uname) {
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from user where uname = ?");
            ps.setString(1,uname);//设置第一个问号的值
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(ps,conn);
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update user set upass = ? where uname = ?");
            ps.setString(1,user.getUpass());//设置第一个问号的值
            ps.setString(2,user.getUname());//设置第二个问号的值
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(ps,conn);
        }
        return false;
    }

    @Override
    public User select(String uname) {
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String upass = null;
        try {
            ps = conn.prepareStatement("select upass,type from user where uname = ?");
            ps.setString(1,uname);//设置第一个问号的值
            rs = ps.executeQuery();
            while(rs.next()){
                upass = rs.getString("upass");
            }
            return new User(uname,upass);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }
        return null;//查询失败返回null
    }
}

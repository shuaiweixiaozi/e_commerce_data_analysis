package com.youfan.utils;

import com.youfan.dapan.OrderDapan;
import com.youfan.gaofufei.OrderGaoFuFei;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class MysqlUtils {

    private static final String URL="jdbc:mysql://192.168.159.142:8066/testschema";
    private static final String  USER="mycat";
    private static final String  PASSWORD="123456";
    private static Connection connection=null;

    static{
        //1、加载驱动程序（反射的方法）
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2、连接数据库
        try {
            connection=(Connection) DriverManager.
                    getConnection(URL, USER,PASSWORD);//地址，用户名，密码
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }

    public static void insertDapanInfo(OrderDapan orderDapan){
        String [] sharding_ids = new String[]{"10000","10010"};
        Random random = new Random();
        String sharding_id = sharding_ids[random.nextInt(sharding_ids.length)];
        String sql="insert into dapanorderinfo (userId, productTypeid, productTypeName, payType, payTime,sharding_id,payAmount) values(?, ?, ?, ?, ?,?,?)";

        java.sql.PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setString(1, orderDapan.getUserId());
            ptmt.setString(2,orderDapan.getProductTypeid());
            ptmt.setString(3, orderDapan.getProductTypeName());
            ptmt.setString(4, orderDapan.getPayType());
            ptmt.setString(5, orderDapan.getPayTime());
            ptmt.setString(6, sharding_id);
            ptmt.setDouble(7, orderDapan.getPayAmount());
            ptmt.execute();//执行给定的SQL语句，该语句可能返回多个结果

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean exitsDapanInfo(OrderDapan orderDapan){

        int size = 0;
        String sql="select * from dapanorderinfo where userId = ? and productTypeid = ? and payType = ? and  payTime = ?";

        java.sql.PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setString(1, orderDapan.getUserId());
            ptmt.setString(2,orderDapan.getProductTypeid());
            ptmt.setString(3, orderDapan.getPayType());
            ptmt.setString(4, orderDapan.getPayTime());
            ResultSet resultSet = ptmt.executeQuery();//执行给定的SQL语句，该语句可能返回多个结果
            size = resultSet.getFetchSize();

        } catch (SQLException e) {
            size = 0;
            e.printStackTrace();
        }
        return size>0?true:false;
    }


    public static void updateDapanInfo(OrderDapan orderDapan){
        String sql="update dapanorderinfo set payAmount =  payAmount + ? where userId = ? and productTypeid = ? and payType = ? and  payTime = ? ";

        java.sql.PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setDouble(1, orderDapan.getPayAmount());
            ptmt.setString(2, orderDapan.getUserId());
            ptmt.setString(3,orderDapan.getProductTypeid());
            ptmt.setString(4, orderDapan.getPayType());
            ptmt.setString(5, orderDapan.getPayTime());
            ptmt.execute();//执行给定的SQL语句，该语句可能返回多个结果

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }







    public static void insertGaoFuFeiInfo(OrderGaoFuFei orderGaoFuFei){
        String [] sharding_ids = new String[]{"10000","10010"};
        Random random = new Random();
        String sharding_id = sharding_ids[random.nextInt(sharding_ids.length)];
        String sql="insert into gaofufeiorderinfo (userId, productTypeid, productTypeName, payType, payTime,sharding_id,payAmount,paycount) values(?, ?, ?, ?, ?,?,?,?)";

        java.sql.PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setString(1, orderGaoFuFei.getUserId());
            ptmt.setString(2,orderGaoFuFei.getProductTypeid());
            ptmt.setString(3, orderGaoFuFei.getProductTypeName());
            ptmt.setString(4, orderGaoFuFei.getPayType());
            ptmt.setString(5, orderGaoFuFei.getPayTime());
            ptmt.setString(6, sharding_id);
            ptmt.setDouble(6, orderGaoFuFei.getPayAmount());
            ptmt.setDouble(7, orderGaoFuFei.getPaycount());
            ptmt.execute();//执行给定的SQL语句，该语句可能返回多个结果

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean exitsGaoFuFei(OrderGaoFuFei orderGaoFuFei){

        int size = 0;
        String sql="select * from gaofufeiorderinfo where userId = ? and productTypeid = ? and payType = ? and  payTime = ?";

        java.sql.PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setString(1, orderGaoFuFei.getUserId());
            ptmt.setString(2,orderGaoFuFei.getProductTypeid());
            ptmt.setString(3, orderGaoFuFei.getPayType());
            ptmt.setString(4, orderGaoFuFei.getPayTime());
            ResultSet resultSet = ptmt.executeQuery();//执行给定的SQL语句，该语句可能返回多个结果
            size = resultSet.getFetchSize();

        } catch (SQLException e) {
            size = 0;
            e.printStackTrace();
        }
        return size>0?true:false;
    }


    public static void updateGaoFuFeiInfo(OrderGaoFuFei orderGaoFuFei){
        String sql="update dapanorderinfo set payAmount =  payAmount + ?,paycount = paycount + ? where userId = ? and productTypeid = ? and payType = ? and  payTime = ? ";

        java.sql.PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setDouble(1, orderGaoFuFei.getPaycount());
            ptmt.setDouble(2, orderGaoFuFei.getPayAmount());
            ptmt.setString(3, orderGaoFuFei.getUserId());
            ptmt.setString(4,orderGaoFuFei.getProductTypeid());
            ptmt.setString(5, orderGaoFuFei.getPayType());
            ptmt.setString(6, orderGaoFuFei.getPayTime());
            ptmt.execute();//执行给定的SQL语句，该语句可能返回多个结果

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}




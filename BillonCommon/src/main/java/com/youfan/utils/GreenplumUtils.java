package com.youfan.utils;

import com.youfan.jiaoyi.Orderinfo;
import com.youfan.product.Product;
import com.youfan.product.Producttype;
import com.youfan.product.Shopinfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreenplumUtils {

    private static final String URL="jdbc:postgresql://192.168.159.142:5432/postgres";
    private static final String  USER="gpadmin";
    private static final String  PASSWORD="gpadmin";
    private static Connection connection=null;

    static{
        //1、加载驱动程序（反射的方法）
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2、连接数据库
        try {
            connection= DriverManager.
                    getConnection(URL, USER,PASSWORD);//地址，用户名，密码
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }

    public static void insertOrderInfo(Orderinfo orderinfo){
        String sql="insert into orderinfo (id,userId,productId,shopId,orderAmount,payAmount,createTime,payType,payTime,hongbaoId,conpusId,huodongId,miaoshaId,tuangouId) values(?, ?, ?, ?, ?,?,?,?, ?, ?, ?, ?,?,?)";

        PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setInt(1, orderinfo.getId());
            ptmt.setInt(2, orderinfo.getUserId());
            ptmt.setInt(3,orderinfo.getProductId());
            ptmt.setInt(4, orderinfo.getShopId());
            ptmt.setDouble(5, orderinfo.getOrderAmount());
            ptmt.setDouble(6, orderinfo.getPayAmount());
            ptmt.setString(7, orderinfo.getCreateTime());
            ptmt.setInt(8, orderinfo.getPayType());
            ptmt.setString(9, orderinfo.getPayTime());
            ptmt.setInt(10, orderinfo.getHongbaoId());
            ptmt.setInt(11, orderinfo.getConpusId());
            ptmt.setInt(12, orderinfo.getHuodongId());
            ptmt.setInt(13, orderinfo.getMiaoshaId());
            ptmt.setInt(14, orderinfo.getTuangouId());
            ptmt.execute();//执行给定的SQL语句，该语句可能返回多个结果

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertShopinfo(Shopinfo shopinfo){
        String sql="insert into shopinfo (id,shopname,merchartId,shopdesrc) values(?, ?, ?, ?)";

        PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setInt(1, shopinfo.getId());
            ptmt.setString(2, shopinfo.getShopname());
            ptmt.setInt(3,shopinfo.getMerchartId());
            ptmt.setString(4, shopinfo.getShopdesrc());
            ptmt.execute();//执行给定的SQL语句，该语句可能返回多个结果
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void insertProductInfo(Product product){
        String sql="insert into product (id,productName,productTypeid,originalPrice,huodongPrice,shopid) values(?, ?, ?, ?,?,?)";

        PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setInt(1, product.getId());
            ptmt.setString(2, product.getProductName());
            ptmt.setInt(2, product.getProductTypeid());
            ptmt.setDouble(3,product.getOriginalPrice());
            ptmt.setDouble(4, product.getHuodongPrice());
            ptmt.setInt(5, product.getShopid());
            ptmt.execute();//执行给定的SQL语句，该语句可能返回多个结果
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertProductType(Producttype producttype){

        String sql="insert into producttypeinfo (id,productTypeName,productTypeleave,parentId) values(?, ?, ?, ?)";

        PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setInt(1, producttype.getId());
            ptmt.setString(2, producttype.getProductTypeName());
            ptmt.setString(3,producttype.getProductTypeleave());
            ptmt.setInt(4, producttype.getParentId());
            ptmt.execute();//执行给定的SQL语句，该语句可能返回多个结果
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String,String>> getShopByHongBaoAnaly(String starttime, String endtime){
        List<Map<String,String>> resultList = new ArrayList<Map<String,String>>();
        String sql="select a.shopId,b.shopname,hongbaonubmer from (select shopId,count(1) hongbaonumber from orderinfo where hongbaoId is not null and hongbaoId != 0 and createTime >= ? and createTime <= ? group by shopId ) a join shopinfo b on a.shopId = b.id order by hongbaonubmer desc;";
        PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setString(1, starttime);
            ptmt.setString(2, endtime);
            ResultSet resultSet = ptmt.executeQuery();

            while(resultSet.next()){
                int shopid = resultSet.getInt(1);
                String shopname = resultSet.getString(2);
                int hongbaonubmer = resultSet.getInt(3);
                Map<String,String> map = new HashMap<String,String>();
                map.put("shopid",shopid+"");
                map.put("shopname",shopname);
                map.put("hongbaonubmer",hongbaonubmer+"");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;


    }


    public static List<Map<String,String>> getShopByTuangouAnaly(String starttime, String endtime){
        List<Map<String,String>> resultList = new ArrayList<Map<String,String>>();
        String sql="select a.shopId,b.shopname,tuangounumber from (select shopId,count(1) tuangounumber from orderinfo where tuangouId is not null and tuangouId != 0 and createTime >= ? and createTime <= ? group by shopId ) a join shopinfo b on a.shopId = b.id order by tuangounumber desc;";
        PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setString(1, starttime);
            ptmt.setString(2, endtime);
            ResultSet resultSet = ptmt.executeQuery();

            while(resultSet.next()){
                int shopid = resultSet.getInt(1);
                String shopname = resultSet.getString(2);
                int tuangounumber = resultSet.getInt(3);
                Map<String,String> map = new HashMap<String,String>();
                map.put("shopid",shopid+"");
                map.put("shopname",shopname);
                map.put("tuangounumber",tuangounumber+"");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;


    }


    public static List<Map<String,String>> getShopByCJAnaly(String starttime, String endtime){
        List<Map<String,String>> resultList = new ArrayList<Map<String,String>>();
        String sql="select a.shopId,b.shopname,paynumber from (select shopId,count(1) paynumber from orderinfo where payTime is not null and payTime != \"\" and createTime >= ? and createTime <= ? group by shopId ) a join shopinfo b on a.shopId = b.id order by paynumber desc;";
        PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setString(1, starttime);
            ptmt.setString(2, endtime);
            ResultSet resultSet = ptmt.executeQuery();

            while(resultSet.next()){
                int shopid = resultSet.getInt(1);
                String shopname = resultSet.getString(2);
                int paynumber = resultSet.getInt(3);
                Map<String,String> map = new HashMap<String,String>();
                map.put("shopid",shopid+"");
                map.put("shopname",shopname);
                map.put("paynumber",paynumber+"");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;


    }


    public static List<Map<String,String>> getShopByUserAnaly(String starttime, String endtime){
        List<Map<String,String>> resultList = new ArrayList<Map<String,String>>();
        String sql="select a.shopId,b.shopname,usernumber from (select shopId,count(1) paynumber from orderinfo where userId is not null and userId != 0 and createTime >= ? and createTime <= ? group by shopId ) a join shopinfo b on a.shopId = b.id order by usernumber desc;";
        PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setString(1, starttime);
            ptmt.setString(2, endtime);
            ResultSet resultSet = ptmt.executeQuery();

            while(resultSet.next()){
                int shopid = resultSet.getInt(1);
                String shopname = resultSet.getString(2);
                int usernumber = resultSet.getInt(3);
                Map<String,String> map = new HashMap<String,String>();
                map.put("shopid",shopid+"");
                map.put("shopname",shopname);
                map.put("usernumber",usernumber+"");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;


    }


    public static List<Map<String,String>> getShopByProductTypeAnaly(String starttime, String endtime){
        List<Map<String,String>> resultList = new ArrayList<Map<String,String>>();
        String sql="select d.shopId,e.shopname,d.producttypeNum from (select shopId,count(1) producttypeNum from (select a.shopId,b.productTypeid from (select shopId,productId from orderinfo where  createTime >= ? and createTime <= ? group by shopId,productId ) a join product b on a.productId = b.id  group by a.shopId,b.productTypeid ) c group by shopId) d join shopinfo e on d.shopId = e.id order by d.producttypeNum desc";
        PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setString(1, starttime);
            ptmt.setString(2, endtime);
            ResultSet resultSet = ptmt.executeQuery();

            while(resultSet.next()){
                int shopid = resultSet.getInt(1);
                String shopname = resultSet.getString(2);
                int producttypeNum = resultSet.getInt(3);
                Map<String,String> map = new HashMap<String,String>();
                map.put("shopid",shopid+"");
                map.put("shopname",shopname);
                map.put("producttypeNum",producttypeNum+"");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;


    }

    public static void main(String[] args) throws Exception {
        // URL
        String url = "jdbc:postgresql://192.168.159.142:5432/postgres";
// 数据库用户名
        String username = "gpadmin";
// 数据库密码
        String password = "gpadmin";
        Class.forName("org.postgresql.Driver");
// 获取连接
        Connection conn = DriverManager.getConnection(url, username, password);
        String sqlssss = "select * from youfan001 ;";
        PreparedStatement pre = conn.prepareStatement(sqlssss);
        ResultSet rs = pre.executeQuery();
        while(rs.next()){
            System.out.println("===============》"+rs.getString(1));
        }

    }
}

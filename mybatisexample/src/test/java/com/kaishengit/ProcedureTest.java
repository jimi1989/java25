package com.kaishengit;

import org.junit.Test;

import java.sql.*;

public class ProcedureTest {

    @Test
    public void testTransaction() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///kaishengit_db","root","rootroot");

            conn.setAutoCommit(false);

            String sql = "delete from t_stu where id = ?";
            PreparedStatement pstat = conn.prepareStatement(sql);

            pstat.setInt(1,3);
            pstat.executeUpdate();

            // 设置保留点
            Savepoint savepoint = conn.setSavepoint("s1");

            String sql1 = "delete from t_stu where id = ?";
            PreparedStatement pstat1 = conn.prepareStatement(sql1);

            pstat1.setInt(1,4);
            pstat1.executeUpdate();
//            conn.commit();
//            conn.rollback();
            conn.rollback(savepoint);
            conn.commit();
            pstat.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///kaishengit_db","root","rootroot");

            String sql = "select * from products where prod_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,"ANV02");
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()) {
                System.out.println(rs.getString("prod_name"));
            }

            rs.close();
            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Test
    public void testPro1() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///kaishengit_db","root","rootroot");

            String sql = "{call p_1()}";
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet resultSet= callableStatement.executeQuery();
            while(resultSet.next()) {
                System.out.println(resultSet.getString("prod_name"));
            }

            resultSet.close();
            callableStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testPro2() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///kaishengit_db","root","rootroot");

            String sql = "{call p_2(?,?)}";
            CallableStatement callableStatement = conn.prepareCall(sql);

            callableStatement.registerOutParameter(1, Types.DECIMAL);
            callableStatement.registerOutParameter(2, Types.DECIMAL);

            callableStatement.executeUpdate();

            float max = callableStatement.getFloat(1);
            float min = callableStatement.getFloat(2);

            System.out.println(max);
            System.out.println(min);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testPro4() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///kaishengit_db","root","rootroot");

            String sql = "{call p_4(?,?)}";
            CallableStatement callableStatement = conn.prepareCall(sql);

            callableStatement.setString(1,"ANV02");
            callableStatement.registerOutParameter(2, Types.DECIMAL);

            callableStatement.executeUpdate();

            float price = callableStatement.getFloat(2);

            System.out.println(price);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package connection;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Properties;
//
///**
// *
// * @author chouaib
// */
//public class testConnection {
//    
//    public static void main(String[] args) {
// 
//        // creates three different Connection objects
//        Connection conn1 = null;
////        Connection conn2 = null;
////        Connection conn3 = null;
// 
//        try {
//            // connect way #1
//            String url1 = "jdbc:mysql://localhost:3306/soap_webservice_tp";
//            String user = "root";
//            String password = "sidi1212";
// 
//            conn1 = DriverManager.getConnection(url1, user, password);
//            if (conn1 != null) {
//                //create a statement
//                Statement myStmt = conn1.createStatement();
//                //Execute SQL Query
//                ResultSet myRs= myStmt.executeQuery("select * from Etudiant");
//                //Process the result set
//                while(myRs.next()) {
//                    System.out.print(myRs+"\n"); 
//                    //you can write any query to fetch using SELECT statement 
//                    //in this loop we fetched name column fron javacon table
//                    int id = myRs.getInt("id");
//                    String nom = myRs.getString("nom");
//                    String prenom = myRs.getString("prenom");
//                    int age = myRs.getInt("age");
//                    String specialite = myRs.getString("specialite");
//                    String numero = myRs.getString("numero");
//                    System.out.println("id :"+id+"\n"+" nom :"+nom+"\n "+"prenom :"+prenom+"\n"+"\n "+"specialite :"+specialite+"\n "+"numero :"+numero);
////                    System.out.println("id :"+id+"\n"+" nom :"+nom+"\n "+"prenom :"+prenom+"\n"+" age :"+age"\n "+"specialite :"+specialite+"\n "+"numero :"+numero);
//                }
//                
//                System.out.println("Connected to the database soap_webservice_tp");
//            }
// 
////            // connect way #2
////            String url2 = "jdbc:mysql://localhost:3306/test2?user=root&password=secret";
////            conn2 = DriverManager.getConnection(url2);
////            if (conn2 != null) {
////                System.out.println("Connected to the database test2");
////            }
//// 
////            // connect way #3
////            String url3 = "jdbc:mysql://localhost:3306/test3";
////            Properties info = new Properties();
////            info.put("user", "root");
////            info.put("password", "secret");
//// 
////            conn3 = DriverManager.getConnection(url3, info);
////            if (conn3 != null) {
////                System.out.println("Connected to the database test3");
////            }
//        } catch (SQLException ex) {
//            System.out.println("An error occurred. Maybe user/password is invalid");
//            ex.printStackTrace();
//        }
//    }
//}
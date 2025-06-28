/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dtkn.quizapp;

import com.dtkn.pojo.Category;
import com.dtkn.utils.JdbcConnector;
import java.io.Console;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {

    @FXML private ComboBox<Category> cbCates;
    @FXML private ComboBox<Level> cbLevels;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
//            //B1: Nạp drive
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //B2: Mở kết nối
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quizdb", "root", "root");
//            //B3: Xử lí truy vấn
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery("SELECT * FROM Category");
//            List<Category> cates = new ArrayList<>();
//            while(rs.next())
//            {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                Category cate = new Category(id, name);
//                cates.add(cate);
//                //System.out.printf("%s /n", name);
//            }
//            //B4: Ngắt kết nối
//            conn.close();
               JdbcConnector.getInstance().connect();
               
//            this.cbCates.setItems(FXCollections.observableArrayList(cates));
//            this.cbCates.setItems(FXCollections.observableArrayList(levels));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dtkn.quizapp;

import com.dtkn.pojo.Category;
import com.dtkn.pojo.Level;
import com.dtkn.pojo.Question;
import com.dtkn.services.QuestionServices;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class PracticeController implements Initializable {
    @FXML private Text txtContent;
    @FXML private VBox vboxChoices;
    
    private List<Question> questions;
    private int currentQuestion = 0;
    private static final QuestionServices questionServices = new QuestionServices();

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}

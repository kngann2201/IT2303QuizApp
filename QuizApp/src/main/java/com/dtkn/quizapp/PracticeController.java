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
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    @FXML private TextField txtNum;
    @FXML private Text txtResult;
    
    private List<Question> questions;
    private int currentQuestion = 0;
    private static final QuestionServices questionServices = new QuestionServices();
    
    public void handleStart(ActionEvent event)
    {

        try {
            this.questions = questionServices.getQuestion(Integer.parseInt(this.txtNum.getText()));
            this.loadQuestion();

        } catch (SQLException ex) {
            System.getLogger(PracticeController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public void handleNext(ActionEvent event)
    {
        if(this.currentQuestion < this.questions.size() -1)
        {
            this.currentQuestion++;
            this.loadQuestion();
        }
    }
    
    public void handleCheck(ActionEvent event)
    {
        Question q = this.questions.get(this.currentQuestion);
        for (int i =0; i < q.getChoices().size(); i++)
        {
            if(q.getChoices().get(i).isCorrect())
            {
                RadioButton r = (RadioButton) this.vboxChoices.getChildren().get(i);
                if(r.isSelected())
                {
                    this.txtResult.setText("Bạn làm đúng rồi!");
//                    this.txtResult.getStyleClass().add("correct");
                }
                else 
                {
                    this.txtResult.setText("Bạn làm sai rồi!");
//                    this.txtResult.getStyleClass().add("wrong");
                }   
                break;
            }
  
        }
    }
    
    private void loadQuestion()
    {
        Question q = this.questions.get(this.currentQuestion);
        this.txtContent.setText(q.getContent());   
        ToggleGroup g = new ToggleGroup();
        vboxChoices.getChildren().clear();
        txtResult.setText("...");
        for (var c: q.getChoices())
        {
            RadioButton r = new RadioButton(c.getContent());
            r.setToggleGroup(g);
            vboxChoices.getChildren().add(r);
        }
        
    }
       @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
}

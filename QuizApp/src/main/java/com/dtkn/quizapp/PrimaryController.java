package com.dtkn.quizapp;

import com.dtkn.utils.MyAlert;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrimaryController {
     public void handleQuestion(ActionEvent event) throws IOException
    {
        Scene scene = new Scene(new FXMLLoader(App.class.getResource("Questions.fxml")).load());
        Stage stage = new Stage();
        stage.setTitle("Quiz App");
        stage.setScene(scene);
        stage.show();

    }
    public void handlePractice(ActionEvent event)
    {
        MyAlert .getInstance().showMessage("Tính năng sẽ sớm được ra mắt!");

    }
    public void handleExam(ActionEvent event)
    {
        MyAlert .getInstance().showMessage("Tính năng sẽ sớm được ra mắt!");
    }
    public void handleRegister(ActionEvent event)
    {
        MyAlert .getInstance().showMessage("Tính năng sẽ sớm được ra mắt!");
    }
    public void handleLogin(ActionEvent event)
    {
        MyAlert .getInstance().showMessage("Tính năng sẽ sớm được ra mắt!");

    }
    
}

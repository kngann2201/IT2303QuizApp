package com.dtkn.quizapp;

import com.dtkn.pojo.Category;
import com.dtkn.utils.MyAlert;
import com.dtkn.utils.MyStage;
import com.dtkn.utils.theme.DefaultThemeFactory;
import com.dtkn.utils.theme.Theme;
import com.dtkn.utils.theme.ThemeManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;

public class PrimaryController implements Initializable {
    @FXML private ComboBox<Theme> cbThemes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbThemes.setItems(FXCollections.observableArrayList(Theme.values()));
    }
    
    public void changeTheme(ActionEvent event)
    {
        this.cbThemes.getSelectionModel().getSelectedItem().updateTheme(this.cbThemes.getScene());
        System.out.print(this.cbThemes.getSelectionModel().getSelectedItem());
    }
    
     public void handleQuestion(ActionEvent event) throws IOException
    {
        Scene scene = new Scene(new FXMLLoader(App.class.getResource("Questions.fxml")).load());
        MyStage.getInstance().showScene("Questions.fxml");

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

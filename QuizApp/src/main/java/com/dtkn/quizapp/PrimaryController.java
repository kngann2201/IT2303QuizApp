package com.dtkn.quizapp;

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
import javafx.stage.Stage;


public class PrimaryController implements Initializable {
    @FXML private ComboBox<Theme> cbThemes;
    
    public void changeTheme(ActionEvent event) {
        this.cbThemes.getSelectionModel().getSelectedItem().updateTheme(this.cbThemes.getScene());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbThemes.setItems(FXCollections.observableArrayList(Theme.values()));
    }
    
    public void handleQuestionManagement(ActionEvent event) throws IOException {
        MyStage.getInstance().showStage("questions.fxml");
    }
    
    public void handlePractice(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }
    
    public void handleExam(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }
    
    public void handleRegister(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }
    
    public void handleLogin(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }

    
}

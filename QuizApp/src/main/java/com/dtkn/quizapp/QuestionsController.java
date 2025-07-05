/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dtkn.quizapp;

import com.dtkn.pojo.Category;
import com.dtkn.pojo.Choice;
import com.dtkn.pojo.Level;
import com.dtkn.pojo.Question;
import com.dtkn.services.CategoryServices;
import com.dtkn.services.LevelServices;
import com.dtkn.services.QuestionServices;
import com.dtkn.utils.JdbcConnector;
import com.dtkn.utils.MyAlert;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {
    @FXML private ComboBox<Category> cbCates;
    @FXML private ComboBox<Level> cbLevels;
    @FXML private TextArea txtContent;
    @FXML private VBox vboxChoices;
    @FXML private ToggleGroup toggleChoice;
    
    @FXML private TextField textSearch;
    @FXML private TableView<Question> tbQuestions;
    
    private static final CategoryServices cateServices = new CategoryServices();
    private static final LevelServices levelServices = new LevelServices();
    private static final QuestionServices questionServices = new QuestionServices();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.cbCates.setItems(FXCollections.observableList(cateServices.getCates()));
            this.cbLevels.setItems(FXCollections.observableList(levelServices.getLevels()));
            
            this.loadColumns();
            this.loadQuestions(QuestionServices.getQuestion());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        this.textSearch.textProperty().addListener((e) -> {
            try {
                this.loadQuestions(QuestionServices.getQuestion(this.textSearch.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(QuestionsController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        });
    }   
    
    public void addChoice(ActionEvent event) {
        HBox h = new HBox();
        h.getStyleClass().add("Main");
        
        RadioButton r = new RadioButton();
        r.setToggleGroup(toggleChoice);
        
        TextField txt = new TextField();
        txt.getStyleClass().add("Input");
        
        h.getChildren().addAll(r, txt);
        
        this.vboxChoices.getChildren().add(h);
    }
    
    public void addQuestion(ActionEvent event) {
        try {
            Question.Builder b = new Question.Builder(this.txtContent.getText(),
                    this.cbCates.getSelectionModel().getSelectedItem(),
                    this.cbLevels.getSelectionModel().getSelectedItem());
            
            for (var c: vboxChoices.getChildren()) {
                HBox h = (HBox) c;
                Choice choice = new Choice(((TextField)h.getChildren().get(1)).getText(), 
                        ((RadioButton)h.getChildren().get(0)).isSelected());
                b.addChoice(choice);
            }
            
            questionServices.addQuestion(b.build());
            
            MyAlert.getInstance().showMsg("Thêm câu hỏi thành công!");
        } catch (SQLException ex) {
            MyAlert.getInstance().showMsg("Thêm câu hỏi thất bại, lý do: " + ex.getMessage());
        } catch (Exception ex) {
            MyAlert.getInstance().showMsg("Dữ liệu có lỗi!");
            
        }
    }
    private void loadQuestions(List<Question> questions)
    {
        this.tbQuestions.setItems(FXCollections.observableList(questions));
    }
    private void loadColumns()
    {
        TableColumn colId = new TableColumn("Id");
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colId.setPrefWidth(80);
        
        TableColumn colContent = new TableColumn("Nội dung câu hỏi");
        colContent.setCellValueFactory(new PropertyValueFactory("content"));
        colContent.setPrefWidth(300);
        
        TableColumn colAction = new TableColumn();
        colAction.setCellFactory(e -> {
            TableCell cell = new TableCell();
            Button btn = new Button("Xóa");
            btn.setOnAction(event ->{
                Optional<ButtonType> t = MyAlert.getInstance().showMsg("Bạn có chắc chắn muốn xóa? Lưu ý rắng các lựa chọn cũng sẽ bị xóa theo!!!", AlertType.CONFIRMATION);
                if(t.isPresent() && t.get().equals(ButtonType.OK))
                {
                    Question q = (Question)cell.getTableRow().getItem();
                    try {
                        if (questionServices.deleteQuestion(q.getId()) == true)
                        {
                            MyAlert.getInstance().showMsg("Xóa thành công!");
                            this.tbQuestions.getItems().remove(q);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(QuestionsController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }
                
            });
            cell.setGraphic(btn);
            return cell;
        });
        colAction.setPrefWidth(300);
        
        this.tbQuestions.getColumns().addAll(colId, colContent, colAction);
    }

}

module com.dtkn.quizapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.dtkn.quizapp to javafx.fxml;
    exports com.dtkn.quizapp;
    exports com.dtkn.pojo;

}

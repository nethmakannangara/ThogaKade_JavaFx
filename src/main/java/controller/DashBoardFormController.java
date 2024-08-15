package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {

    Stage stageAddCustomer;

    @FXML
    void btnAddCustomerOnAction(ActionEvent event) {
        if (null == stageAddCustomer) {
            stageAddCustomer = new Stage();
            try {
                stageAddCustomer.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/add_customer_form.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        stageAddCustomer.show();
    }

    @FXML
    void btnDeleteCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateCustomerOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/update_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

}

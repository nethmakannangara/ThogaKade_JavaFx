package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {

    Stage stageAddCustomer;
    Stage stageDeleteCustomer;
    Stage stageUpdateCustomer;
    Stage stageSearchCustomer;


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
        if (null == stageDeleteCustomer) {
            stageDeleteCustomer = new Stage();
            try {
                stageDeleteCustomer.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/delete_customer _form.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        stageDeleteCustomer.show();
    }

    @FXML
    void btnSearchCustomerOnAction(ActionEvent event) {
        if(null==stageSearchCustomer){
            stageSearchCustomer=new Stage();
            try {
                stageSearchCustomer.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/search_customer_form.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        stageSearchCustomer.show();
    }

    @FXML
    void btnUpdateCustomerOnAction(ActionEvent event) {
        if(null==stageUpdateCustomer) {
            stageUpdateCustomer=new Stage();
            try {
                stageUpdateCustomer.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/update_customer_form.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        stageUpdateCustomer.show();
    }

}

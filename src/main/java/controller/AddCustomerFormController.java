package controller;

import bd.DBConnection;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import model.Customer;
import service.CustomerService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    @FXML
    private ComboBox<String> cmbTitle;

    @FXML
    private DatePicker dateDoB;

    @FXML
    private Label lblID;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContactNO;

    @FXML
    private JFXTextField txtName;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        List<Customer> customerList = DBConnection.getInstance().getCustomerList();

        if (!CustomerService.checkCustomerID(lblID.getText())) {
            if (!CustomerService.checkCustomerContactNO(txtContactNO.getText())) {
                if (CustomerService.isNotNull(cmbTitle.getValue(), txtName.getText(), txtAddress.getText(), txtContactNO.getText())) {
                    customerList.add(new Customer(lblID.getText(), cmbTitle.getValue(), txtName.getText(), txtAddress.getText(), txtContactNO.getText(), dateDoB.getValue()));
                    updateLblID();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Alert");
                    alert.setContentText("Please fill all details");
                    alert.setHeaderText("Information Alert");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("WARNING");
                alert.setContentText("This Phone Number already added...");
                alert.setHeaderText("Invalid PhoneNumber");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("This CustomerID already Exist...");
            alert.setHeaderText("Duplicate CustomerID");
            alert.showAndWait();
        }
        clearTextFiled();
    }

    private void clearTextFiled() {
        cmbTitle.setValue(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtContactNO.setText(null);
        dateDoB.setValue(null);
    }

    public void updateLblID() {
        lblID.setText(CustomerService.generateID());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> title = FXCollections.observableArrayList();
        title.add("Mr .");
        title.add("Miss .");
        title.add("Mrs .");

        cmbTitle.setItems(title);
        updateLblID();
    }
}

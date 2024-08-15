package controller;

import bd.DBConnection;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

        if (!CustomerService.checkCustomerID(lblID.getText()) && !CustomerService.checkCustomerContactNO(txtContactNO.getText())) {
            customerList.add(new Customer(lblID.getText(), cmbTitle.getValue(), txtName.getText(), txtAddress.getText(), txtContactNO.getText(), dateDoB.getValue()));
            updateLblID();

        }

    }

    public void updateLblID() {
        lblID.setText(CustomerService.generateID());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateLblID();
    }
}

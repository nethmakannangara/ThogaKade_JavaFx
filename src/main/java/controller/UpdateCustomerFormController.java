package controller;

import bd.DBConnection;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.Customer;
import service.CustomerService;

import java.util.List;

public class UpdateCustomerFormController {


    public ComboBox<String> cmbTitle;

    public DatePicker dateDoB;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContactNo;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSearch;

    List<Customer> customerList= DBConnection.getInstance().getCustomerList();
    int index;
    @FXML
    void btnSearchOnAction(ActionEvent event) {
        txtSearch.setDisable(true);
        index = CustomerService.searchCustomer(txtSearch.getText());
        txtName.setText(customerList.get(index).getName());
        txtAddress.setText(customerList.get(index).getAddress());
        txtContactNo.setText(customerList.get(index).getNumber());
        dateDoB.setValue(customerList.get(index).getDob());
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        customerList.set(index,new Customer(txtSearch.getText(),cmbTitle.getValue(),txtName.getText(),txtAddress.getText(),txtContactNo.getText(),dateDoB.getValue()));
        clearTextFiled();
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        txtSearch.setDisable(false);
        clearTextFiled();
    }

    private void clearTextFiled() {
        txtSearch.setDisable(false);
        txtSearch.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtContactNo.setText(null);
        cmbTitle.setValue(null);
        dateDoB.setValue(null);
    }
}

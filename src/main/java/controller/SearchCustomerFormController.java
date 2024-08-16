package controller;

import bd.DBConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Customer;
import service.CustomerService;

import java.util.List;

public class SearchCustomerFormController {

    @FXML
    private JFXButton btnCancel;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblContactNo;

    @FXML
    private Label lblDoB;

    @FXML
    private Label lblName;

    @FXML
    private Label lblTitle;

    @FXML
    private JFXTextField txtSearch;

    List<Customer> customerList= DBConnection.getInstance().getCustomerList();
    int index;
    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        index=CustomerService.searchCustomer(txtSearch.getText());

        lblTitle.setText(customerList.get(index).getTitle());
        lblName.setText(customerList.get(index).getName());
        lblAddress.setText(customerList.get(index).getAddress());
        lblContactNo.setText(customerList.get(index).getNumber());
        lblDoB.setText(String.valueOf(customerList.get(index).getDob()));
    }

}

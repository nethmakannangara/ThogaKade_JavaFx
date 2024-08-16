package controller;

import bd.DBConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import model.Customer;
import service.CustomerService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteCustomerFormController implements Initializable {

    public JFXButton btnDelete;
    public JFXButton btnCancel;
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

    List<Customer> customerList = DBConnection.getInstance().getCustomerList();
    int index;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        clearTextFiled();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        customerList.remove(index);

        try {
            Thread.sleep(600);
        } catch (Exception ex) {
            clearTextFiled();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        index = CustomerService.searchCustomer(txtSearch.getText());

        if (index != -1) {
            lblTitle.setText(customerList.get(index).getTitle());
            lblName.setText(customerList.get(index).getName());
            lblAddress.setText(customerList.get(index).getAddress());
            lblContactNo.setText(customerList.get(index).getNumber());
            lblDoB.setText(String.valueOf(customerList.get(index).getDob()));

            btnDelete.setDisable(false);
            clearTextFiled();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Invalid CustomerID...");
            alert.showAndWait();
        }

    }

    private void clearTextFiled() {
        txtSearch.setText(null);
        lblTitle.setText(null);
        lblName.setText(null);
        lblAddress.setText(null);
        lblContactNo.setText(null);
        lblDoB.setText(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnDelete.setDisable(true);
    }
}

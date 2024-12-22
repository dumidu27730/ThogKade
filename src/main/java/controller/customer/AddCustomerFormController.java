package controller.customer;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Customer;

import java.util.List;

public class AddCustomerFormController {

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXPasswordField txtPassword;


    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String password = txtPassword.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();

        Customer customer = new Customer(id, name, email, password,address);
        System.out.println(customer);

        List<Customer> customerList =  DBConnection.getInstance().getConnection1();
        customerList.add(customer);


    }

}

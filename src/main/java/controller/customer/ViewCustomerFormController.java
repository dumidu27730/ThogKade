package controller.customer;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewCustomerFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPassword;

    @FXML
    private TableView<Customer> tblCustomers;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            tblCustomers.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) ->{
                setTextToValues(newValue);

            }
            ));
    }
    private void setTextToValues(Customer newValue){
       // txtId.setText(newValue.getId());
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        List<Customer> customerList = DBConnection.getInstance().getConnection1();
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
        customerList.forEach(obj->{
            customerObservableList.add(obj);
        });

        tblCustomers.setItems(customerObservableList);
    }


}

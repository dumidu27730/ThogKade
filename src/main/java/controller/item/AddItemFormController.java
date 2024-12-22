package controller.item;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Customer;
import model.Item;

import java.util.List;

public class AddItemFormController {

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtQty;

    @FXML
    void btnAddItemOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        Integer qty = Integer.parseInt(txtQty.getText());
        Double price = Double.parseDouble(txtPrice.getText());
        String description = txtDescription.getText();

        Item item = new Item(id, name, qty, price, description);
        System.out.println(item);

        List<Item> itemList =  DBConnection.getInstance().getConnection2();
        itemList.add(item);
    }

}

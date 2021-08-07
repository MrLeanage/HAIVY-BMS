package view.InventoryManagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.ItemStock;
import model.Supplier;
import util.audio.Audio;
import util.authenticate.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemStockController implements Initializable {
    Audio play = new Audio();
    private static Supplier supplier;
    private static ItemStock existingItemStockModel;

    @FXML
    private TableView<ItemStock> ItemStockTable;

    @FXML
    private TableColumn<ItemStock, String> IIDColumn;

    @FXML
    private TableColumn<ItemStock, String> INameColumn;

    @FXML
    private TableColumn<ItemStock, String> ISIIDColumn;

    @FXML
    private TableColumn<ItemStock, String> ISISupplierNameColumn;

    @FXML
    private TableColumn<ItemStock, Integer> IUnitsPerBlockColumn;

    @FXML
    private TableColumn<ItemStock, Integer> IBlocksColumn;

    @FXML
    private TableColumn<ItemStock, Float> IWeightPerUnitColumn;

    @FXML
    private TableColumn<ItemStock, Float> IBuyingPriceColumn;

    @FXML
    private TableColumn<ItemStock, String> IExpireDateColumn;

    @FXML
    private TableColumn<ItemStock, String> IAddedDateColumn;

    @FXML
    private TableColumn<ItemStock, Integer> IMinQuantityColumn;

    @FXML
    private TableColumn<ItemStock, Integer> IAvailableQuantityColumn;

    @FXML
    private TableColumn<ItemStock, String> IStatusColumn;

    @FXML
    private TextField SearchTextBox;

    @FXML
    private TextField INameTextField;

    @FXML
    private TextField IUnitsPerBlockTextField;

    @FXML
    private TextField IBlocksTextField;

    @FXML
    private TextField IWeightPerUnitTextField;

    @FXML
    private TextField IBuyingPriceTextField;

    @FXML
    private DatePicker IExpireDateDatePicker;

    @FXML
    private TextField ISupplierNameTextField;


    @FXML
    private Label INameLabel;

    @FXML
    private Label IBlocksLabel;

    @FXML
    private Label IUnitsPerBlockLabel;

    @FXML
    private Label IWeightPerUnitLabel;

    @FXML
    private Label IExpireDateLabel;

    @FXML
    private Label ISupplierNameLabel;

    @FXML
    private Label IBuyingPriceLabel;

    @FXML
    private TextField ISupplierIDTextField;

    @FXML
    private TextField IMinQuantityLimitTextField;

    @FXML
    private Label IMinQuantityLimitLabel;

    @FXML
    private MenuButton OptionMenuButton;

    @FXML
    private Label sessionUser;

    /**
     * Initializes the services class.
     * @param url
     * @param rb
     */

    @FXML
    private AnchorPane rootpane;
    private AdminManagementHandler adminManagementHandler = new AdminManagementHandler();
    private CashierHandler cashierHandler = new CashierHandler();
    private SupervisorHandler supervisorHandler = new SupervisorHandler();
    private InventoryHandler inventoryHandler = new InventoryHandler();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setGeneralizationInfo();
    }
    private void setGeneralizationInfo(){
        sessionUser.setText(UserAuthentication.getAuthenticatedSession().getuName());
    }
    @FXML
    private void logoutSession(ActionEvent event){
        UserAuthentication userAuthentication = new UserAuthentication();
        userAuthentication.endAuthenticatedSession(OptionMenuButton);
    }
    @FXML
    private void adminPanel(ActionEvent event){
        UserAuthentication userAuthentication = new UserAuthentication();
        userAuthentication.getAdminMenu(OptionMenuButton);
    }
    @FXML
    private void cashierPanel(ActionEvent event){
        UserAuthentication userAuthentication = new UserAuthentication();
        userAuthentication.getCashierMenu(OptionMenuButton);
    }
    @FXML
    private void supervisorPanel(ActionEvent event){
        UserAuthentication userAuthentication = new UserAuthentication();
        userAuthentication.getSupervisorMenu(OptionMenuButton);
    }
}

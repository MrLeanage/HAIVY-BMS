package view.InventoryManagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.ItemStock;
import model.ItemWithdraw;
import util.authenticate.SupervisorHandler;
import util.authenticate.UserAuthentication;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ItemWithdrawController implements Initializable {
    @FXML
    private TableView<ItemWithdraw> WithdrawTable;

    @FXML
    private TableColumn<ItemWithdraw, String> WIDColumn;

    @FXML
    private TableColumn<ItemWithdraw, String> WNameColumn;

    @FXML
    private TableColumn<ItemWithdraw, String> WDescriptionColumn;

    @FXML
    private TableColumn<ItemWithdraw, Integer> WQuantityColumn;

    @FXML
    private TableColumn<ItemWithdraw, Float> WWeightColumn;

    @FXML
    private TableColumn<ItemWithdraw, String> WActionColumn;

    @FXML
    private TextField SearchTextBox;

    @FXML
    private TextArea IWDescriptionTextArea;

    @FXML
    private TextField IWeightTextBox;

    @FXML
    private TextField INameTextBox;

    @FXML
    private TextField IIDTextBox;

    @FXML
    private TableView<ItemStock> ItemTable;

    @FXML
    private TableColumn<ItemStock, String> IIDColumn;

    @FXML
    private TableColumn<ItemStock, String> INameColumn;

    @FXML
    private TableColumn<ItemStock, Float> IWeightColumn;

    @FXML
    private TableColumn<ItemStock, Integer> IQuantityColumn;

    @FXML
    private TableColumn<ItemStock, String> IStatusColumn;

    @FXML
    private Spinner<Integer> IQuantitySpinner;

    @FXML
    private Label IQuantityLabel;

    @FXML
    private Label IDescriptionLabel;

    @FXML
    private MenuItem AdminPanelMenuItem;

    @FXML
    private MenuItem CashierPanelMenuItem;

    @FXML
    private MenuItem SupervisorPanelMenuItem;

    @FXML
    private  MenuButton OptionMenuButton;

    @FXML
    private Label sessionUser;

    @FXML
    private AnchorPane rootpane;
    private LinkedList<ItemWithdraw> itemWithdrawsList = new LinkedList<ItemWithdraw>();
    private LinkedList<ItemStock> itemStocksList = new LinkedList<ItemStock>();

    private static ItemStock existingItemStockData;


    private SupervisorHandler supervisorHandler = new SupervisorHandler();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setGeneralizationInfo();
    }
    private void setGeneralizationInfo(){
        sessionUser.setText(UserAuthentication.getAuthenticatedSession().getuName());
        if(UserAuthentication.getCurrentAdminType().equals("default")){
            AdminPanelMenuItem.setVisible(false);
            CashierPanelMenuItem.setVisible(false);
            SupervisorPanelMenuItem.setVisible(false);
        }else{
            AdminPanelMenuItem.setVisible(true);
            CashierPanelMenuItem.setVisible(true);
            SupervisorPanelMenuItem.setVisible(true);
        }
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

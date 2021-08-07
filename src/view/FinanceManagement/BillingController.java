package view.FinanceManagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.SalesItem;
import util.authenticate.CashierHandler;
import util.authenticate.UserAuthentication;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class BillingController implements Initializable {
    @FXML
    private TableView<SalesItem> BillTable;

    @FXML
    private TableColumn<SalesItem, String> BIDColumn;

    @FXML
    private TableColumn<SalesItem, String> BNameColumn;

    @FXML
    private TableColumn<SalesItem, String> BWeightColumn;

    @FXML
    private TableColumn<SalesItem, Float> BPriceColumn;

    @FXML
    private TableColumn<SalesItem, Integer> BQuantityColumn;

    @FXML
    private TableColumn<SalesItem, Double> BTotalColumn;

    @FXML
    private TableColumn<SalesItem, String> BActionColumn;

    @FXML
    private TableView<SalesItem> ProductsTable;

    @FXML
    private TableColumn<SalesItem, String> PIDColumn;

    @FXML
    private TableColumn<SalesItem, String> PNameColumn;

    @FXML
    private TableColumn<SalesItem, String> PWeightPerUnitColumn;

    @FXML
    private TableColumn<SalesItem, Float> PPriceColumn;

    @FXML
    private TextField SearchTextBox;

    @FXML
    private Spinner<Integer> PQuantitySpinner;

    @FXML
    private TextField PNameTextbox;

    @FXML
    private TextField PIDTextbox;

    @FXML
    private TextField PWeightTextbox;

    @FXML
    private TextField PPriceTextbox;

    @FXML
    private TextField PTotalPriceTextbox;

    @FXML
    private Label TotalItemLabel;

    @FXML
    private Label DateLabel;

    @FXML
    private Label TotalAmountLabel;

    @FXML
    private Label PQuantityLabel;

    @FXML
    private Label OrderPaymentLabel;

    private static SalesItem existingSalesItemData;

    private LinkedList<SalesItem> salesItemLinkedList = new LinkedList<>();

    @FXML
    private MenuItem AdminPanelMenuItem;

    @FXML
    private MenuItem CashierPanelMenuItem;

    @FXML
    private MenuItem SupervisorPanelMenuItem;

    @FXML
    private MenuButton OptionMenuButton;

    @FXML
    private AnchorPane rootpane;

    @FXML
    private Label sessionUser;

    private CashierHandler cashierHandler = new CashierHandler();
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

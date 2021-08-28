package view.AppHome;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import util.authenticate.CashierHandler;
import util.authenticate.UserAuthentication;
import util.utility.UtilityMethod;

import java.net.URL;
import java.util.ResourceBundle;

public class CashierBaseController implements Initializable {

    @FXML
    private MenuButton OptionMenuButton;

    @FXML
    private MenuItem AdminPanelMenuItem;

    @FXML
    private MenuItem CashierPanelMenuItem;

    @FXML
    private MenuItem SupervisorPanelMenuItem;

    @FXML
    private Label sessionUser;

    @FXML
    private Label systemDateLabel;

    @FXML
    private Label systemTimeLabel;

    @FXML
    private AnchorPane rootpane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setGeneralizationInfo();
    }

    private void setGeneralizationInfo(){
        sessionUser.setText(UserAuthentication.getAuthenticatedSession().getuName());
        CashierHandler cashierHandler = new CashierHandler();
        cashierHandler.loadBilling(rootpane);
        UtilityMethod.getClock(systemTimeLabel);
        UtilityMethod.getCalendar(systemDateLabel);

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

    @FXML
    private void loadBilling(ActionEvent event){
        CashierHandler cashierHandler = new CashierHandler();
        cashierHandler.loadBilling(rootpane);
    }
    @FXML
    private void loadNewOrder(ActionEvent event){
        CashierHandler cashierHandler = new CashierHandler();
        cashierHandler.loadNewOrder(rootpane);
    }
    @FXML
    private void loadOrderMenu(ActionEvent event){
        CashierHandler cashierHandler = new CashierHandler();
        cashierHandler.loadOrderMenu(rootpane);
    }
    @FXML
    private void loadOrderStatus(ActionEvent event){
        CashierHandler cashierHandler = new CashierHandler();
        cashierHandler.loadOrderStatus(rootpane);
    }
    @FXML
    private void loadSalesInfo(ActionEvent event){
        CashierHandler cashierHandler = new CashierHandler();
        cashierHandler.loadSalesInfo(rootpane);
    }
    @FXML
    private void loadProducts(ActionEvent event){
        CashierHandler cashierHandler = new CashierHandler();
        cashierHandler.loadProducts(rootpane);
    }
}

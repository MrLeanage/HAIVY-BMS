package view.AppHome;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import util.authenticate.*;
import util.utility.UtilityMethod;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminBaseController implements Initializable {

    @FXML
    private MenuButton OptionMenuButton;

    @FXML
    private Label sessionUser;

    @FXML
    private Label systemDateLabel;

    @FXML
    private Label systemTimeLabel;


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
        AdminManagementHandler adminManagementHandler = new AdminManagementHandler();
        adminManagementHandler.loadStockItems(rootpane);
        UtilityMethod.getClock(systemTimeLabel);
        UtilityMethod.getCalendar(systemDateLabel);
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

    /**
     * Inventory Navigation Functions
     */
    @FXML
    void loadAgencyProducts(ActionEvent event) {
        AdminManagementHandler adminManagementHandler = new AdminManagementHandler();
        adminManagementHandler.loadAgencyProduct(rootpane);
    }

    @FXML
    void loadBakeryProducts(ActionEvent event) {
        AdminManagementHandler adminManagementHandler = new AdminManagementHandler();
        adminManagementHandler.loadBakeryProducts(rootpane);
    }

    @FXML
    void loadItemStocks(ActionEvent event) {
        AdminManagementHandler adminManagementHandler = new AdminManagementHandler();
        adminManagementHandler.loadStockItems(rootpane);
    }
    /**
     * Suppluier Navigation Functions
     */
    @FXML
    void loadSuppliers(ActionEvent event) {
        AdminManagementHandler adminManagementHandler = new AdminManagementHandler();
        adminManagementHandler.loadSupplier(rootpane);
    }
    /**
     * User Navigation Functions
     */
    @FXML
    void loadSystemUsers(ActionEvent event) {
        System.out.println("called");
        AdminManagementHandler adminManagementHandler = new AdminManagementHandler();
        adminManagementHandler.loadSystemUsers(rootpane);
    }
    /**
     * Employee Navigation Functions
     */
    @FXML
    void loadEmployeeAccount(ActionEvent event) {
        AdminManagementHandler adminManagementHandler = new AdminManagementHandler();
        adminManagementHandler.loadEmployeeAccount(rootpane);
    }
    @FXML
    void loadSalaryScheme(ActionEvent event) {
        AdminManagementHandler adminManagementHandler = new AdminManagementHandler();
        adminManagementHandler.loadSalaryScheme(rootpane);
    }
    @FXML
    void loadAllowance(ActionEvent event) {
        AdminManagementHandler adminManagementHandler = new AdminManagementHandler();
        adminManagementHandler.loadAllowance(rootpane);
    }
    /**
     * Employee Navigation Functions
     */
    @FXML
    void loadOrderMenu(ActionEvent event) {
        AdminManagementHandler adminManagementHandler = new AdminManagementHandler();
        adminManagementHandler.loadOrderMenu(rootpane);
    }
    @FXML
    void loadOrderStatus(ActionEvent event) {
        AdminManagementHandler adminManagementHandler = new AdminManagementHandler();
        adminManagementHandler.loadOrderStatus(rootpane);
    }
}

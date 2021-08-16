package view.AppHome;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import util.authenticate.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminBaseController implements Initializable {

    @FXML
    private MenuButton OptionMenuButton;

    @FXML
    private Label sessionUser;

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
}

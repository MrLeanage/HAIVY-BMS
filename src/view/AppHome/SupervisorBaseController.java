package view.AppHome;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import util.authenticate.SupervisorHandler;
import util.authenticate.UserAuthentication;
import util.loader.Loader;
import util.utility.UtilityMethod;

import java.net.URL;
import java.util.ResourceBundle;

public class SupervisorBaseController implements Initializable {

    @FXML
    private Circle Circle1;

    @FXML
    private Circle Circle2;

    @FXML
    private Circle Circle3;

    @FXML
    private Circle Circle4;

    @FXML
    private Circle Circle5;

    @FXML
    private Circle Circle6;

    @FXML
    private Circle Circle7;

    @FXML
    private Circle Circle8;

    @FXML
    private AnchorPane LoadingAnchorPane;

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
        try{
            Loader loader = new Loader();
            loader.startUpAnimation(Circle1, Circle2, Circle3, Circle4, Circle5, Circle6, Circle7, Circle8, LoadingAnchorPane);
        }catch(Exception exception){
            exception.printStackTrace();
        }
        sessionUser.setText(UserAuthentication.getAuthenticatedSession().getuName());
        SupervisorHandler supervisorHandler = new SupervisorHandler();
        supervisorHandler.loadItemWithdraw(rootpane);
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
    private void loadItemWithdraw(ActionEvent event){
        SupervisorHandler supervisorHandler = new SupervisorHandler();
        supervisorHandler.loadItemWithdraw(rootpane);
    }
    @FXML
    private void loadWithdrawedItems(ActionEvent event){
        SupervisorHandler supervisorHandler = new SupervisorHandler();
        supervisorHandler.loadWithdrawedItems(rootpane);
    }
    @FXML
    private void loadNewOrders(ActionEvent event){
        SupervisorHandler supervisorHandler = new SupervisorHandler();
        supervisorHandler.loadNewOrders(rootpane);
    }
    @FXML
    private void loadOnGoingOrders(ActionEvent event){
        SupervisorHandler supervisorHandler = new SupervisorHandler();
        supervisorHandler.loadOnGoingOrders(rootpane);
    }
    @FXML
    private void loadCompletedOrders(ActionEvent event){
        SupervisorHandler supervisorHandler = new SupervisorHandler();
        supervisorHandler.loadCompletedOrders(rootpane);
    }
    @FXML
    private void loadCancelledOrders(ActionEvent event){
        SupervisorHandler supervisorHandler = new SupervisorHandler();
        supervisorHandler.loadCancelledOrders(rootpane);
    }
    @FXML
    private void loadOrderMenu(ActionEvent event){
        SupervisorHandler supervisorHandler = new SupervisorHandler();
        supervisorHandler.loadOrderMenu(rootpane);
    }
}

package view.InventoryManagement;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.ItemWithdraw;
import service.ItemWithdrawServices;
import util.authenticate.UserAuthentication;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class WithdrawedItemsController implements Initializable {

    @FXML
    private TableView<ItemWithdraw> WithdrawTable;

    @FXML
    private TableColumn<ItemWithdraw, String> WIDColumn;

    @FXML
    private TableColumn<ItemWithdraw, String> WIIDColumn;

    @FXML
    private TableColumn<ItemWithdraw, String> WNameColumn;

    @FXML
    private TableColumn<ItemWithdraw, String> WDescriptionColumn;

    @FXML
    private TableColumn<ItemWithdraw, String> WWeightColumn;

    @FXML
    private TableColumn<ItemWithdraw, Integer> WQuantityColumn;

    @FXML
    private TableColumn<ItemWithdraw, String> WDateColumn;

    @FXML
    private TableColumn<ItemWithdraw, String> WTimeColumn;

    @FXML
    AnchorPane rootpane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //load data to View table
    private void loadData() throws SQLException {
        //getting data from main LoginController
        ItemWithdrawServices itemWithdrawServices = new ItemWithdrawServices();

        ObservableList<ItemWithdraw> itemWithdrawsData;
        itemWithdrawsData = itemWithdrawServices.loadSpecificUserData(UserAuthentication.getAuthenticatedSession().getuID());

        //Setting cell value factory to table view
        WIDColumn.setCellValueFactory(new PropertyValueFactory<>("iWID"));
        WIIDColumn.setCellValueFactory(new PropertyValueFactory<>("iWIID"));
        WNameColumn.setCellValueFactory(new PropertyValueFactory<>("iWIName"));
        WDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("iWDescription"));
        WWeightColumn.setCellValueFactory(new PropertyValueFactory<>("iWWeight"));
        WQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("iWQuantity"));
        WDateColumn.setCellValueFactory(new PropertyValueFactory<>("iWDate"));
        WTimeColumn.setCellValueFactory(new PropertyValueFactory<>("iWTime"));


        WithdrawTable.setItems(null);
        WithdrawTable.setItems(itemWithdrawsData);

    }


}

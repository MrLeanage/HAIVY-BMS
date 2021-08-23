
package view.OrderManagement;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import model.Order;
import service.OrderServices;
import util.authenticate.SupervisorHandler;
import util.utility.PrintReport;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class NewOrdersController implements Initializable {

    @FXML
    private TableView<Order> OrderTable;

    @FXML
    private TableColumn<Order, String> OIDColumn;

    @FXML
    private TableColumn<Order, String> OMNameColumn;

    @FXML
    private TableColumn<Order, String> OTypeColumn;

    @FXML
    private TableColumn<Order, String> ODetailsColumn;

    @FXML
    private TableColumn<Order, String> ODeliveryDateColumn;

    @FXML
    private TableColumn<Order, String> ODeliveryTimeColumn;

    @FXML
    private TableColumn<Order, String> OTakenDateColumn;

    @FXML
    private TableColumn<Order, String> OTakenTimeColumn;

    @FXML
    private TableColumn<Order, String> OProcessingStatusColumn;

    @FXML
    private TableColumn<Order, String> OActionColumn;

    @FXML
    private TextField SearchTextBox;
    private ObservableList<String> orderTypeChoiceboxList = FXCollections.observableArrayList("Menu Item","Customized");

    @FXML
    AnchorPane rootpane;
    SupervisorHandler supervisorHandler = new SupervisorHandler();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadData();
            searchTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //load data from Main LoginController to View table
    private void loadData() throws SQLException {
        //getting data from main LoginController
        OrderServices orderServices = new OrderServices();
        ObservableList<Order> ordersData;
        ordersData = orderServices.loadData("Process Pending", "Payment Pending");

        //Setting cell value factory to table view
        OIDColumn.setCellValueFactory(new PropertyValueFactory<>("oID"));
        OMNameColumn.setCellValueFactory(new PropertyValueFactory<>("oOMName"));
        OTypeColumn.setCellValueFactory(new PropertyValueFactory<>("oType"));
        ODetailsColumn.setCellValueFactory(new PropertyValueFactory<>("oDetails"));
        ODeliveryDateColumn.setCellValueFactory(new PropertyValueFactory<>("oDeliveryDate"));
        ODeliveryTimeColumn.setCellValueFactory(new PropertyValueFactory<>("oDeliveryTime"));
        OTakenDateColumn.setCellValueFactory(new PropertyValueFactory<>("oTakenDate"));
        OTakenTimeColumn.setCellValueFactory(new PropertyValueFactory<>("oTakenTime"));
        OActionColumn.setCellValueFactory(new PropertyValueFactory<>("Dummy"));
        OProcessingStatusColumn.setCellValueFactory(new PropertyValueFactory<>("oProcessingStatus"));
        Callback<TableColumn<Order, String>, TableCell<Order, String>> parentCellFactory
                =
                new Callback<TableColumn<Order, String>, TableCell<Order, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Order, String> param) {
                        final TableCell<Order, String> cell = new TableCell<Order, String>() {

                            final Button btn = new Button("Process Order");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnMouseClicked(event -> {
                                        // student = StudentTable.getSelectionModel().getSelectedItem();
                                        //String sID = student.getsID();
                                    });
                                    btn.setOnAction(event -> {
                                        //pdf generate and status Update method here
                                        Order order = getTableView().getItems().get(getIndex());
                                        OrderServices orderServices = new OrderServices();

                                        Alert action = new Alert(Alert.AlertType.CONFIRMATION);
                                        action.setTitle("Select Your Action");
                                        action.setHeaderText("You Selected a Request with");
                                        action.setContentText(order.getoType()+" item of "+order.getoOMName());


                                        ButtonType onProcessBtn = new ButtonType("On Process");
                                        ButtonType cancelBtn = new ButtonType("Cancel");

                                        action.getButtonTypes().setAll(onProcessBtn, cancelBtn);
                                        Optional<ButtonType> clickAction = action.showAndWait();

                                        if(clickAction.isPresent() && clickAction.get() == onProcessBtn){
                                            try {
                                                orderServices.updateOrderStatus(order.getoID(),"On Process");
                                                PrintReport printReport = new PrintReport();
                                                printReport.printNewOrderInfo(order.getoID());
                                                loadData();
                                            } catch ( Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        OActionColumn.setCellFactory(parentCellFactory);
        OrderTable.setItems(null);
        OrderTable.setItems(ordersData);

    }

    public void searchTable() throws SQLException {

        OrderServices orderServices = new OrderServices();
        //Retrieving sorted data from Main LoginController
        SortedList<Order> sortedData = orderServices.searchTable(SearchTextBox, "Process Pending", "Payment Pending");

        //binding the SortedList to TableView
        sortedData.comparatorProperty().bind(OrderTable.comparatorProperty());
        //adding sorted and filtered data to the table
        OrderTable.setItems(sortedData);
    }
}

package util.authenticate;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.systemAlerts.AlertPopUp;

import java.io.IOException;

public class AdminManagementHandler {
    public AdminManagementHandler() {
    }
    public void loadStockItems(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/InventoryManagement/ItemStock.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            AlertPopUp.generalError(ex);
        }
    }

    public void loadBakeryProducts(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/InventoryManagement/BakeryProducts.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            System.out.println(ex);
            AlertPopUp.generalError(ex);
        }
    }
    public void loadAgencyProduct(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/InventoryManagement/AgencyProduct.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            AlertPopUp.generalError(ex);
        }
    }
    public void loadSupplier(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/SupplierManagement/Supplier.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            AlertPopUp.generalError(ex);
        }
    }
    public void loadSystemUsers(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/UserManagement/SystemUsers.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            AlertPopUp.generalError(ex);
        }
    }
    public void loadEmployeeAccount(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/EmployeeManagement/Employee.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            AlertPopUp.generalError(ex);
            System.out.println(ex);
        }
    }
    public void loadSalaryScheme(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/EmployeeManagement/SalarySchemes.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            AlertPopUp.generalError(ex);
        }
    }
    public void loadAllowance(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/EmployeeManagement/Allowances.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            System.out.println(ex);
            AlertPopUp.generalError(ex);
        }
    }
    /**
     * Admin Order Management
     */
    public void loadOrderMenu(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/OrderManagement/OrdersMenuAdmin.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            System.out.println(ex);
            AlertPopUp.generalError(ex);
        }
    }
    public void loadOrderStatus(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/OrderManagement/OrdersStatusAdmin.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            System.out.println(ex);
            AlertPopUp.generalError(ex);
        }
    }

    /**
     * Admin Finance Management
     */
    public void loadSalesCounter(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/FinanceManagement/SalesCounterAdmin.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            AlertPopUp.generalError(ex);
        }
    }
    public void loadSalesReport(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/FinanceManagement/SalesReportAdmin.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            System.out.println(ex);
            AlertPopUp.generalError(ex);
        }
    }
    public void loadPurchases(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/FinanceManagement/PurchasesReportAdmin.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            System.out.println(ex);
            AlertPopUp.generalError(ex);
        }
    }
    public void loadPaySheet(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/FinanceManagement/PaySheetAdmin.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            System.out.println(ex);
            AlertPopUp.generalError(ex);
        }
    }
    public void loadPayroll(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/FinanceManagement/PayRollAdmin.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            System.out.println(ex);
            AlertPopUp.generalError(ex);
        }
    }
    public void loadOtherExpense(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/FinanceManagement/OtherExpensesAdmin.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            System.out.println(ex);
            AlertPopUp.generalError(ex);
        }
    }
    public void loadIncomeStatement(AnchorPane rootpane){
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/FinanceManagement/IncomeStatementAdmin.fxml"));
            rootpane.getChildren().setAll(pane);
        }catch(IOException ex){
            System.out.println(ex);
            AlertPopUp.generalError(ex);
        }
    }
}

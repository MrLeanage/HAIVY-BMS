package service;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TextField;
import model.Allowance;
import util.dbConnect.DBConnection;
import util.query.AllowanceQueries;
import util.systemAlerts.AlertPopUp;
import util.utility.UtilityMethod;

import java.sql.*;

public class AllowanceServices {



    private ObservableList<Allowance> allowancesData;

    public  ObservableList<Allowance> loadData(){
        try {
            Connection conn = DBConnection.getDBConnection();
            allowancesData = FXCollections.observableArrayList();
            ResultSet rsLoadBakeryProduct = conn.createStatement().executeQuery(AllowanceQueries.LOAD_ALLOWANCE_DATA_QUERY);

            while (rsLoadBakeryProduct.next()) {
                allowancesData.add(new Allowance(rsLoadBakeryProduct.getString(1), rsLoadBakeryProduct.getString(2), rsLoadBakeryProduct.getString(3), rsLoadBakeryProduct.getString(4), rsLoadBakeryProduct.getFloat(5)));
            }
        } catch (SQLException ex) {
            AlertPopUp.sqlQueryError(ex);
        }
        return allowancesData;
    }
    public Allowance loadSpecificData(String id){
        Allowance allowance = null;
        try {
            Connection conn = DBConnection.getDBConnection();
            PreparedStatement psLoadAllowance = conn.prepareStatement(AllowanceQueries.LOAD_SPECIFIC_ALLOWANCE_DATA_QUERY);
            psLoadAllowance.setInt(1, UtilityMethod.seperateID(id));
            ResultSet rsLoadBakeryProduct = psLoadAllowance.executeQuery();
            while (rsLoadBakeryProduct.next()) {
                allowance.setaID(rsLoadBakeryProduct.getString(1));
                allowance.setaTitle(rsLoadBakeryProduct.getString(2));
                allowance.setaDescription(rsLoadBakeryProduct.getString(3));
                allowance.setaType(rsLoadBakeryProduct.getString(4));
                allowance.setaValue(rsLoadBakeryProduct.getFloat(5));
            }
        } catch (SQLException ex) {
            AlertPopUp.sqlQueryError(ex);
        }
        return allowance;
    }

    public boolean insertData(Allowance allowance) throws  Exception{
        PreparedStatement psAllowance = null;
        boolean resultval = false;
        try {
            Connection conn = DBConnection.getDBConnection();
            psAllowance = conn.prepareStatement(AllowanceQueries.INSERT_ALLOWANCE_DATA_QUERY);

            psAllowance.setString(1,allowance.getaTitle());
            psAllowance.setString(2,allowance.getaDescription());
            psAllowance.setString(3, allowance.getaType());
            psAllowance.setFloat(4, allowance.getaValue());
            psAllowance.execute();
            AlertPopUp.insertSuccessfully("Allowance Scheme");
            resultval = true;

        } catch (SQLException ex) {
            AlertPopUp.insertionFailed(ex, "Allowance Scheme");
        }
        return resultval;
    }

    public boolean updateData(Allowance allowance) throws Exception {
        PreparedStatement psAllowance = null;

        boolean resultVal = false;
        try {
            Connection conn = DBConnection.getDBConnection();
            psAllowance = conn.prepareStatement(AllowanceQueries.UPDATE_ALLOWANCE_DATA_QUERY);
            psAllowance.setString(1,allowance.getaTitle());
            psAllowance.setString(2,allowance.getaDescription());
            psAllowance.setString(3, allowance.getaType());
            psAllowance.setFloat(4, allowance.getaValue());
            psAllowance.setInt(5, UtilityMethod.seperateID(allowance.getaID()));
            psAllowance.execute();
            AlertPopUp.updateSuccesfully("Allowance Scheme");
            resultVal = true;

        } catch (SQLException ex) {
            AlertPopUp.updateFailed(ex, "Allowance Scheme");

        }
        return resultVal;
    }
    public Boolean deleteData(int itemID ) throws SQLException {
        PreparedStatement psAllowance = null;
        Boolean resultVal = false;
        Connection conn = DBConnection.getDBConnection();
        try{
            psAllowance = conn.prepareStatement(AllowanceQueries.DELETE_ALLOWANCE_DATA_QUERY);
            psAllowance.setInt(1, itemID);
            psAllowance.executeUpdate();
            AlertPopUp.deleteSuccessful("Allowance Scheme");
            resultVal = true;

        }catch (SQLException ex) {
            AlertPopUp.deleteFailed(ex, "Allowance Scheme");
        }
        return resultVal;
    }

    public SortedList<Allowance> searchTable(TextField searchTextField){
        //Retreiving all data from database
        ObservableList<Allowance> allowancesData = null;

        try {
            Connection conn = DBConnection.getDBConnection();
            allowancesData = FXCollections.observableArrayList();
            ResultSet rsLoadBakeryProduct = conn.createStatement().executeQuery(AllowanceQueries.LOAD_ALLOWANCE_DATA_QUERY);

            while (rsLoadBakeryProduct.next()) {
                allowancesData.add(new Allowance(rsLoadBakeryProduct.getString(1), rsLoadBakeryProduct.getString(2), rsLoadBakeryProduct.getString(3), rsLoadBakeryProduct.getString(4), rsLoadBakeryProduct.getFloat(5)));
            }
        } catch (SQLException ex) {
            AlertPopUp.sqlQueryError(ex);
        }
        //Wrap the ObservableList in a filtered List (initially display all data)
        FilteredList<Allowance> filteredData = new FilteredList<>(allowancesData, b -> true);

        searchTextField.textProperty().addListener((observable,oldValue,newValue) ->{
            filteredData.setPredicate(allowance -> {
                //if filter text is empty display all data
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                //comparing search text with table columns one by one
                String lowerCaseFilter = newValue.toLowerCase();

                if(allowance.getaID().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    //return if filter matches data
                    return true;
                }else if(allowance.getaTitle().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    //return if filter matches data
                    return true;
                }else if(allowance.getaDescription().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    //return if filter matches data
                    return true;
                }else if(allowance.getaType().toLowerCase().indexOf(lowerCaseFilter) !=-1){
                    //return if filter matches data
                    return true;
                }else if(String.valueOf(allowance.getaValue()).toLowerCase().indexOf(lowerCaseFilter) !=-1){
                    //return if filter matches data
                    return true;
                }else{
                    //have no matchings
                    return false;
                }
            });
        });
        //wrapping the FilteredList in a SortedList
        SortedList<Allowance> sortedData = new SortedList<>(filteredData);
        return sortedData;
    }

}

package view.AppHome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.UserServices;
import util.authenticate.UserAuthentication;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(new AnchorPane());
        UserAuthentication userAuthentication = new UserAuthentication(scene);
        UserServices userServices = new UserServices();
        Boolean resultVal = userServices.addDefaultAdminUser();
        //Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        if(resultVal){
            userAuthentication.showLoginScreen();
            //primaryStage.setScene(new Scene(root, 1355, 730));
            primaryStage.setTitle("BAKERY MANAGEMENT SYSTEM - HAIVY PASTRY SHOP");
            primaryStage.getIcons().add(new Image("/lib/img/haivy-icon.png"));
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.sizeToScene();
            primaryStage.show();
        }


    }


    public static void main(String[] args) {
        launch(args);
    }
}

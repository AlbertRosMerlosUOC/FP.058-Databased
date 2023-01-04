package databased;

import databased.modelo.Datos;
import databased.vistasJavafx.ArticulosVistaController;
import databased.vistasJavafx.ClientesVistaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    Datos datos;
    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Online Store");

        this.datos = new Datos();

        initRootLayout();
        showArticulosVista();
        //showClientesVista();
    }
    private void initRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("vistasJavafx/PrincipalVista.fxml"));
        rootLayout = (BorderPane) loader.load();

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    private void showClientesVista() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("vistasJavafx/ClientesVista.fxml"));
        AnchorPane clientesVista = (AnchorPane) loader.load();
        //Reclamamos el controlador que se ha creado automáticamente a partir del FXML
        ClientesVistaController clientesVistaController = loader.getController();
        //Pasamos el acceso al modelo al controlador
        clientesVistaController.setDatos(datos);
        //Cargamos los datos en la tabla
        clientesVistaController.refreshClientesList();
        rootLayout.setCenter(clientesVista);
    }

    private void showArticulosVista() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("vistasJavafx/ArticulosVista.fxml"));
        AnchorPane articulosVista = (AnchorPane) loader.load();
        //Reclamamos el controlador que se ha creado automáticamente a partir del FXML
       ArticulosVistaController articulosVistaController = loader.getController();
        //Pasamos el acceso al modelo al controlador
        articulosVistaController.setDatos(datos);
        //Cargamos los datos en la tabla
        articulosVistaController.refreshArticulosList();
        rootLayout.setCenter(articulosVista);
    }


    public static void main(String[] args) {

        launch(args);
    }
}

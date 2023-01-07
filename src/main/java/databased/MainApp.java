package databased;

import databased.modelo.Datos;
import databased.vistasJavafx.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private Datos datos;
    private Stage primaryStage;
    private BorderPane rootLayout;
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    public Datos getDatos() {
        return datos;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Online Store");

        this.datos = new Datos();

        initRootLayout();
        showClientesVista();
    }
    private void initRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("vistasJavafx/PrincipalVista.fxml"));
        rootLayout = (BorderPane) loader.load();
        PrincipalVistaController principalVistaController = loader.getController();
        //Pasamos el acceso al modelo al controlador
        principalVistaController.setMainApp(this);
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void showClientesVista() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("vistasJavafx/ClientesVista.fxml"));
        AnchorPane clientesVista = (AnchorPane) loader.load();
        //Reclamamos el controlador que se ha creado automáticamente a partir del FXML
        ClientesVistaController clientesVistaController = loader.getController();
        //Pasamos el acceso al modelo al controlador
        clientesVistaController.setMainApp(this);
        //Cargamos los datos en la tabla
        clientesVistaController.refreshClientesList();
        rootLayout.setCenter(clientesVista);
    }
    public void showArticulosVista() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("vistasJavafx/ArticulosVista.fxml"));
        AnchorPane articulosVista = (AnchorPane) loader.load();
        //Reclamamos el controlador que se ha creado automáticamente a partir del FXML
        ArticulosVistaController articulosVistaController = loader.getController();
        //Pasamos el acceso al modelo al controlador
        articulosVistaController.setMainApp(this);
        //Cargamos los datos en la tabla
        articulosVistaController.refreshArticulosList();
        rootLayout.setCenter(articulosVista);
    }
    public void showPedidosVista() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("vistasJavafx/PedidosVista.fxml"));
        AnchorPane clientesVista = (AnchorPane) loader.load();
        //Reclamamos el controlador que se ha creado automáticamente a partir del FXML
        PedidosVistaController pedidosVistaController= loader.getController();
        //Pasamos el acceso al modelo al controlador
        pedidosVistaController.setMainApp(this);
        //Cargamos los datos en la tabla
        pedidosVistaController.refreshPedidosList();
        rootLayout.setCenter(clientesVista);
    }
    public void showAddArticuloDialog() throws IOException {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("vistasJavafx/AddArticuloDialogVista.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Añadir Articulo");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        AddArticuloDialogVistaController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setMainApp(this);

        dialogStage.showAndWait();

    }
    public void showAddClienteDialog() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("vistasJavafx/AddClienteDialogVista.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Añadir Cliente");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        AddClienteDialogVistaController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setMainApp(this);

        dialogStage.showAndWait();
    }
    public void showAddPedidoDialog() throws IOException {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("vistasJavafx/AddPedidoDialogVista.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Crear Pedido");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        AddPedidoDialogVistaController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setMainApp(this);
        controller.initSelectArticulo();

        dialogStage.showAndWait();

    }

    public static void main(String[] args) {
        launch(args);
    }

}

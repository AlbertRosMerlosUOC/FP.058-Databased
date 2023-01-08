package databased.vistasControllerJavafx;

import databased.MainApp;
import databased.modelo.Articulo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;


public class PrincipalVistaController {
    @FXML
    private Button showClientesVista;
    @FXML
    private Button showArticulosVista;
    @FXML
    private Button showPedidosVista;

    private MainApp mainApp;

    public void setMainApp(MainApp app) {
        this.mainApp = app;
    }

    @FXML
    public void showGestionClientes() throws IOException {
        this.mainApp.showClientesVista();
    }
    @FXML
    public void showGestionArticulos() throws IOException {
        this.mainApp.showArticulosVista();

    }
    @FXML
    public void showGestionPedidos() throws IOException {
        this.mainApp.showPedidosVista();
    }
    @FXML
    public void showPrincipalAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("About");
        alert.setHeaderText("Online Store");
        alert.setContentText("Online Store es un producto del grupo Databased.");
        alert.showAndWait();
    }
    @FXML
    public void showPrincipalClose() {
        System.exit(0);
    }

}

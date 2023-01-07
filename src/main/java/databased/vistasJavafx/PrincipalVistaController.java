package databased.vistasJavafx;

import databased.MainApp;
import javafx.fxml.FXML;
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


}

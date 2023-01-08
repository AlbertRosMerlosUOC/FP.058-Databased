package databased.vistasControllerJavafx;

import databased.MainApp;
import databased.modelo.Articulo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddArticuloDialogVistaController {

    @FXML
    private TextField tCodigo;
    @FXML
    private TextField tDescripcion;
    @FXML
    private TextField tPrecioVenta;
    @FXML
    private TextField tGastosEnvio;
    @FXML
    private TextField tTiempoPreparacion;

    @FXML
    private Button btnAddArticulo;
    @FXML
    private Button btnCancelAddArticulo;

    private MainApp mainApp;
    private Stage dialogStage;
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void addArticulo() {
       try {
           Articulo articulo = new Articulo(   tCodigo.getText(),
                                               tDescripcion.getText(),
                                               Double.parseDouble(tPrecioVenta.getText()),
                                               Double.parseDouble(tGastosEnvio.getText()),
                                               Integer.parseInt(tTiempoPreparacion.getText()) );

           if (mainApp.getDatos().addArticulo(articulo)) {
               dialogStage.close();
           } else {
               Alert alert = new Alert(Alert.AlertType.WARNING);
               alert.initOwner(mainApp.getPrimaryStage());
               alert.setTitle("Articulo");
               alert.setHeaderText("El articulo " + articulo.getCodigo() + " ya existe");
               alert.setContentText("Escribe otro código");
               alert.showAndWait();
           }
       } catch (NullPointerException | NumberFormatException ex) {
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.initOwner(mainApp.getPrimaryStage());
           alert.setTitle("Artículo");
           alert.setHeaderText("Revisa los datos del formulario");
           alert.setContentText("Los campos no pueden estar vacíos y los campos numéricos deben ser correctos");
           alert.showAndWait();
       }
    }

    @FXML
    public void cancelAddArticulo(){
        dialogStage.close();
    }

}

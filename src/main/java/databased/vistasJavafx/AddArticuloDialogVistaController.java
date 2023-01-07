package databased.vistasJavafx;

import databased.MainApp;
import databased.modelo.Articulo;
import javafx.fxml.FXML;
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
    private Button btnAdArticulo;
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
    public void addArticulo(){
        if(!tCodigo.getText().equals("")) {
            Articulo articulo = new Articulo(tCodigo.getText(),
                    tDescripcion.getText(),
                    Double.parseDouble(tPrecioVenta.getText()),
                    Double.parseDouble(tGastosEnvio.getText()),
                    Integer.parseInt(tTiempoPreparacion.getText()));

            mainApp.getDatos().addArticulo(articulo);
            dialogStage.close();
        }
    }

    @FXML
    public void cancelAddArticulo(){
        dialogStage.close();
    }

    //TODO Validación del formulario antes de enviar los datos


}

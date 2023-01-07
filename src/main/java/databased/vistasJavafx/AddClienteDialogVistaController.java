package databased.vistasJavafx;

import databased.MainApp;
import databased.modelo.Articulo;
import databased.modelo.Cliente;
import databased.modelo.ClientePremium;
import databased.modelo.ClienteStandard;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddClienteDialogVistaController {
    @FXML
    private TextField tNombre;
    @FXML
    private TextField tEmail;
    @FXML
    private TextField tNif;
    @FXML
    private TextField tDomicilio;
    @FXML
    private CheckBox ckIsPremium;
    @FXML
    private Button btnAddCliente;
    @FXML
    private Button btnCancelAddCliente;

    private MainApp mainApp;
    private Stage dialogStage;
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void addCliente(){
        if(tEmail.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Cliente");
            alert.setHeaderText("El email no puede estar vacio");
            alert.setContentText("Escribe otro email");
            alert.showAndWait();
        } else{
            Cliente cliente;
            if (ckIsPremium.isSelected()) {
                cliente = new ClientePremium(tEmail.getText(),
                        tNif.getText(),
                        tNombre.getText(),
                        tDomicilio.getText());
            } else {
                cliente = new ClienteStandard(tEmail.getText(),
                        tNif.getText(),
                        tNombre.getText(),
                        tDomicilio.getText());
            }
            if (mainApp.getDatos().addCliente(cliente)) {
                dialogStage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Cliente");
                alert.setHeaderText("El cliente " + cliente.getEmail() + " ya existe");
                alert.setContentText("Escribe otro email");
                alert.showAndWait();
            }
        }
    }
    @FXML
    public void cancelAddCliente(){
        dialogStage.close();
    }
}

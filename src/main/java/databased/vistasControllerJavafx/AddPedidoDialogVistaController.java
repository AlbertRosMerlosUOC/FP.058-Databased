package databased.vistasControllerJavafx;

import com.sun.javafx.charts.Legend;
import databased.MainApp;
import databased.modelo.Articulo;
import databased.modelo.Cliente;
import databased.modelo.Pedido;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AddPedidoDialogVistaController {
    @FXML
    private ChoiceBox<String> selArticulo;
    @FXML
    private ChoiceBox<String> selCliente;
    @FXML
    private Button btnShowAddCliente;
    @FXML
    private TextField tCantidad;
    private MainApp mainApp;
    private Stage dialogStage;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    public void addPedido(ActionEvent actionEvent) {
        //TODO tratar error cliente no existe y validar isempty
        if(selCliente.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Pedido ");
            alert.setHeaderText("Selecciona un Cliente exixtente o crea uno nuevo");
            alert.showAndWait();
        }else if(selArticulo.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Pedido");
            alert.setHeaderText("Selecciona un articulo");
            alert.showAndWait();
        } else if (Integer.parseInt(tCantidad.getText()) < 1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Pedido");
            alert.setHeaderText("Ingresa una cantidad");
            alert.showAndWait();
        } else{
            Cliente cl = mainApp.getDatos().getClienteByEmail(selCliente.getValue());
            Articulo ar = mainApp.getDatos().getArticuloByCodigo(selArticulo.getValue());
            Pedido pe = new Pedido(cl, ar, Integer.parseInt(tCantidad.getText()), LocalDateTime.now());
            mainApp.getDatos().addPedido(pe);
            dialogStage.close();
        }

    }
    @FXML
    public void cancelAddPedido(ActionEvent actionEvent) {
        dialogStage.close();
    }

    @FXML
    public void initSelectArticulo(){
        List<Articulo> ars = mainApp.getDatos().getArticulos();
        ObservableList<String> codigos = FXCollections.observableArrayList();
        for(Articulo a : ars){
           codigos.add(a.getCodigo());
        }

        selArticulo.setItems(codigos);
    }
    @FXML
    public void initSelectCliente(){
        List<Cliente> cls = mainApp.getDatos().getClientes();
        ObservableList<String> emails = FXCollections.observableArrayList();
        for(Cliente cl : cls){
            emails.add(cl.getEmail());
        }

        selCliente.setItems(emails);
    }
    @FXML
    public void showAddCliente() throws IOException {
        Cliente cliente = mainApp.showAddClienteDialog();
        initSelectCliente();
        if(cliente != null)
            selCliente.setValue(cliente.getEmail());
    }

    @FXML
    public void initialize(){
        tCantidad.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(
                    ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    tCantidad.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}

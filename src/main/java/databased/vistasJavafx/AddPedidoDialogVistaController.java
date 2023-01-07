package databased.vistasJavafx;

import com.sun.javafx.charts.Legend;
import databased.MainApp;
import databased.modelo.Articulo;
import databased.modelo.Cliente;
import databased.modelo.Pedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AddPedidoDialogVistaController {
    @FXML
    private ChoiceBox<String> selArticulo;
    @FXML
    private TextField tEmailCliente;
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
        Cliente cl = mainApp.getDatos().getClienteByEmail(tEmailCliente.getText());
        Articulo ar = mainApp.getDatos().getArticuloByCodigo(selArticulo.getValue());
        Pedido pe = new Pedido(cl, ar, Integer.parseInt(tCantidad.getText()), LocalDateTime.now());
        mainApp.getDatos().addPedido(pe);
        dialogStage.close();
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
}

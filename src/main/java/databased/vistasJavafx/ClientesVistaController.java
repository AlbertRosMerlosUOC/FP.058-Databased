package databased.vistasJavafx;

import databased.MainApp;
import databased.modelo.Cliente;
import databased.modelo.Datos;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ClientesVistaController {

    @FXML
    private TableView<Cliente> clientesTable;
    @FXML
    private TableColumn<Cliente, String> clienteNombre;

   private MainApp mainApp;

    public void refreshClientesList() {
        //clienteNombre.seTcellFactoryProperty()
        ObservableList<Cliente> clientes = FXCollections.observableArrayList(mainApp.getDatos().getClientes());
        clienteNombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        clientesTable.setItems(clientes);
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}

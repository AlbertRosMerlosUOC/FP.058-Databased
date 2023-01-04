package databased.vistasJavafx;

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
    private Datos datos;
    @FXML
    private TableView<Cliente> clientesTable;
    @FXML
    private TableColumn<Cliente, String> clienteNombre;

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    public void refreshClientesList() {
        //clienteNombre.seTcellFactoryProperty()
        ObservableList<Cliente> clientes = FXCollections.observableArrayList(datos.getClientes());
        clienteNombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        clientesTable.setItems(clientes);
    }
}

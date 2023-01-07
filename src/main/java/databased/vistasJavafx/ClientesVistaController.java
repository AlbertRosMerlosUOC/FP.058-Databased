package databased.vistasJavafx;

import databased.MainApp;
import databased.modelo.Cliente;
import databased.modelo.ClientePremium;
import databased.modelo.ClienteStandard;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;


public class ClientesVistaController {

    @FXML
    private TableView<Cliente> clientesTable;
    @FXML
    private TableColumn<Cliente, String> clNombre;
    @FXML
    private TableColumn<Cliente, String> clEmail;
    @FXML
    private TableColumn<Cliente, String> clNif;
    @FXML
    private TableColumn<Cliente, String> clDomicilio;
    @FXML
    private TableColumn<Cliente, String> clTipo;
    @FXML
    private TableColumn<ClientePremium, Integer> clCuota;
    @FXML
    private TableColumn<ClientePremium, Integer> clDescuento;
    @FXML
    private Button showAddCliente;
    @FXML
    private CheckBox chkFiltroTipoCliente;
    @FXML
    private RadioButton rClientePremium;
    @FXML
    private RadioButton rClienteStandard;
   private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    public void refreshClientesList() {
        System.out.println(mainApp.getDatos().getClientes());
        ObservableList<Cliente> clientes = FXCollections.observableArrayList(mainApp.getDatos().getClientes());
        clNombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        clEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
        clNif.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nif"));
        clDomicilio.setCellValueFactory(new PropertyValueFactory<Cliente, String>("domicilio"));

        clTipo.setCellValueFactory(cellData -> {
            Cliente cl = cellData.getValue();
            return  new SimpleStringProperty(cl.tipoCliente());
        });
        clCuota.setCellValueFactory(cellData -> {
            Cliente cl = cellData.getValue();
            if(cl instanceof ClientePremium){
                return new SimpleIntegerProperty(((ClientePremium) cl).getCuota()).asObject();
            }
            return null;

        });
        clDescuento.setCellValueFactory(cellData -> {
            Cliente cl = cellData.getValue();
            if(cl instanceof ClientePremium) {
                return new SimpleIntegerProperty(((ClientePremium) cl).getDescuento()).asObject();
            }
            return null;
        });
        clientesTable.setItems(clientes);
    }
    public void refreshClientesListByTipo(boolean isPremium) {

        System.out.println(mainApp.getDatos().getClientes());
        ObservableList<Cliente> clientes;
        if(isPremium) {
            clientes = FXCollections.observableArrayList(mainApp.getDatos().getClientes("ClientePremium"));
        }else{
            clientes = FXCollections.observableArrayList(mainApp.getDatos().getClientes("ClienteStandard"));
        }
        clNombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        clEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
        clNif.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nif"));
        clDomicilio.setCellValueFactory(new PropertyValueFactory<Cliente, String>("domicilio"));

        clTipo.setCellValueFactory(cellData -> {
            Cliente cl = cellData.getValue();
            return  new SimpleStringProperty(cl.tipoCliente());
        });
        clCuota.setCellValueFactory(cellData -> {
            Cliente cl = cellData.getValue();
            if(cl instanceof ClientePremium){
                return new SimpleIntegerProperty(((ClientePremium) cl).getCuota()).asObject();
            }
            return null;

        });
        clDescuento.setCellValueFactory(cellData -> {
            Cliente cl = cellData.getValue();
            if(cl instanceof ClientePremium) {
                return new SimpleIntegerProperty(((ClientePremium) cl).getDescuento()).asObject();
            }
            return null;
        });
        clientesTable.setItems(clientes);
    }

    @FXML
    public void showAddCliente() throws IOException {
        mainApp.showAddClienteDialog();
        refreshClientesList();
    }

    @FXML
    public void filtrarPorTipoCliente(){
        if(chkFiltroTipoCliente.isSelected()){
            rClientePremium.setDisable(false);
            rClienteStandard.setDisable(false);
            refreshClientesListByTipo(rClientePremium.isSelected());
        }else{
            rClientePremium.setDisable(true);
            rClienteStandard.setDisable(true);
            refreshClientesList();
        }

    }

}

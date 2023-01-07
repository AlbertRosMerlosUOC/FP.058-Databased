package databased.vistasJavafx;

import databased.MainApp;
import databased.modelo.Articulo;
import databased.modelo.Cliente;
import databased.modelo.Pedido;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

public class PedidosVistaController {
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private TableView<Pedido> tblPedidos;
    @FXML
    private TableColumn<Pedido, Integer> numPedido;
    @FXML
    private TableColumn<Pedido, LocalDateTime> fechaPedido;
    @FXML
    private TableColumn<Pedido, String> nif;
    @FXML
    private TableColumn<Pedido, String> nombre;
    @FXML
    private TableColumn<Pedido, String> codArticulo;
    @FXML
    private TableColumn<Pedido, String> descripcion;
    @FXML
    private TableColumn<Pedido, Double> precioUnidad;
    @FXML
    private TableColumn<Pedido, Integer> cantidad;
    @FXML
    private TableColumn<Pedido, Double> precioEnvio;
    @FXML
    private TableColumn<Pedido, Double> precioTotal;
    @FXML
    private TableColumn<Pedido, String> enviado;

    @FXML
    public void refreshPedidosList() {
        ObservableList<Pedido> pedidos = FXCollections.observableArrayList(mainApp.getDatos().getPedidos());
        System.out.println(pedidos);
        numPedido.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("numPedido"));
        fechaPedido.setCellValueFactory(new PropertyValueFactory<Pedido, LocalDateTime>("fechaPedido"));
        nif.setCellValueFactory(cellData -> {
            Pedido p = cellData.getValue();
            return  new SimpleStringProperty(p.getCliente().getNif());
        });
        nombre.setCellValueFactory(cellData -> {
            Pedido p = cellData.getValue();
            return  new SimpleStringProperty(p.getCliente().getNombre());
        });
        codArticulo.setCellValueFactory(cellData -> {
            Pedido p = cellData.getValue();
            return  new SimpleStringProperty(p.getArticulo().getCodigo());
        });
        descripcion.setCellValueFactory(cellData -> {
            Pedido p = cellData.getValue();
            return  new SimpleStringProperty(p.getArticulo().getDescripcion());
        });
        precioUnidad.setCellValueFactory(cellData -> {
            Pedido p = cellData.getValue();
            return  new SimpleDoubleProperty(p.getArticulo().getPrecioVenta()).asObject();
        });
        cantidad.setCellValueFactory(cellData -> {
            Pedido p = cellData.getValue();
            return  new SimpleIntegerProperty(p.getCantidad()).asObject();
        });
        precioEnvio.setCellValueFactory(cellData -> {
            Pedido p = cellData.getValue();
            return  new SimpleDoubleProperty(p.getArticulo().getGastosEnvio()).asObject();
        });
        precioTotal.setCellValueFactory(cellData -> {
            Pedido p = cellData.getValue();
            return  new SimpleDoubleProperty(p.precioEnvio()).asObject();
        });
        enviado.setCellValueFactory(cellData -> {
            Pedido p = cellData.getValue();
            String enviado = "No";
            if(p.pedidoEnviado())
                enviado = "Sí";

            return  new SimpleStringProperty(enviado);
        });
        tblPedidos.setItems(pedidos);
    }

    public void showAddPedido() throws IOException {
        mainApp.showAddPedidoDialog();
        refreshPedidosList();
    }

    public void showDelPedido(ActionEvent event) throws IOException {
        Pedido pedido = tblPedidos.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("Confirmación de eliminación");
        alert.setHeaderText("Eliminar pedido número " + pedido.getNumPedido());
        alert.setContentText("Está a punto de eliminar el pedido con número " + pedido.getNumPedido() + ". ¿Desea continuar?");

        ButtonType siBtn = new ButtonType("Sí");
        ButtonType noBtn = new ButtonType("No");
        alert.getButtonTypes().setAll(siBtn, noBtn);

        Optional<ButtonType> clicked = alert.showAndWait();

        if (clicked.isPresent() && clicked.get() == siBtn) {
            int resultado = mainApp.getDatos().deletePedido(pedido.getNumPedido());
            Alert alertRes = null;
            switch (resultado) {
                // Este caso no debería darse nunca
                case -1:
                    alertRes = new Alert(Alert.AlertType.ERROR);
                    alertRes.setTitle("Error en la eliminación");
                    alertRes.setHeaderText("Eliminar pedido número " + pedido.getNumPedido());
                    alertRes.setContentText("Está a punto de eliminar el pedido con número " + pedido.getNumPedido() + ". ¿Desea continuar?");
                    alertRes.showAndWait();
                    break;
                case 0:
                    alertRes = new Alert(Alert.AlertType.WARNING);
                    alertRes.setTitle("Error en la eliminación");
                    alertRes.setHeaderText("No se ha podido eliminar el pedido número " + pedido.getNumPedido());
                    alertRes.setContentText("El pedido ya ha sido enviado y no se ha podido eliminar.");
                    alertRes.showAndWait();
                    break;
                case 1:
                    alertRes = new Alert(Alert.AlertType.CONFIRMATION);
                    alertRes.setTitle("Éxito en la eliminación");
                    alertRes.setHeaderText("Pedido número " + pedido.getNumPedido() + " eliminado correctamente");
                    alertRes.setContentText("El pedido se ha eliminado correctamente.");
                    alertRes.showAndWait();
                    refreshPedidosList();
                    break;
                default:
                    break;
            }
        }

    }


}

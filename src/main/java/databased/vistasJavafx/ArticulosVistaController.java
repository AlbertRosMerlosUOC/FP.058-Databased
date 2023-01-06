package databased.vistasJavafx;

import databased.MainApp;
import databased.modelo.Articulo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;


public class ArticulosVistaController {

    @FXML
    private TableView<Articulo> tblArticulos;
    @FXML
    private TableColumn<Articulo, String> clCodigo;
    @FXML
    private TableColumn<Articulo, String> clDescripcion;
    @FXML
    private TableColumn<Articulo, Double> clPrecioVenta;
    @FXML
    private TableColumn<Articulo, Double> clGastosEnvio;
    @FXML
    private TableColumn<Articulo, Integer> clTiempoPreparacion;

    @FXML
    private Button showAddArticulo;
    private MainApp mainApp;
    @FXML
    public void refreshArticulosList() {

        ObservableList<Articulo> articulos = FXCollections.observableArrayList(mainApp.getDatos().getArticulos());
        System.out.println(articulos);
        clCodigo.setCellValueFactory(new PropertyValueFactory<Articulo, String>("codigo"));
        clDescripcion.setCellValueFactory(new PropertyValueFactory<Articulo, String>("descripcion"));
        clPrecioVenta.setCellValueFactory(new PropertyValueFactory<Articulo, Double>("precioVenta"));
        clGastosEnvio.setCellValueFactory(new PropertyValueFactory<Articulo, Double>("gastosEnvio"));
        clTiempoPreparacion.setCellValueFactory(new PropertyValueFactory<Articulo, Integer>("tiempoPreparacion"));
        tblArticulos.setItems(articulos);
    }

    public void showAddArticulo() throws IOException {
        mainApp.showAddArticuloDialog();
        refreshArticulosList();
    }

    public void setMainController(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}

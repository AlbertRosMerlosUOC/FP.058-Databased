package databased.vistasJavafx;

import databased.modelo.Articulo;
import databased.modelo.Cliente;
import databased.modelo.Datos;
import jakarta.persistence.Column;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;


public class ArticulosVistaController {
    private Datos datos;
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
    private Button btnNuevo;
    @FXML
    private Button btnEliminar;



    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    @FXML
    public void refreshArticulosList() {

        ObservableList<Articulo> articulos = FXCollections.observableArrayList(datos.getArticulos());
        System.out.println(articulos);
        clCodigo.setCellValueFactory(new PropertyValueFactory<Articulo, String>("codigo"));
        clDescripcion.setCellValueFactory(new PropertyValueFactory<Articulo, String>("descripcion"));
        clPrecioVenta.setCellValueFactory(new PropertyValueFactory<Articulo, Double>("precioVenta"));
        clGastosEnvio.setCellValueFactory(new PropertyValueFactory<Articulo, Double>("gastosEnvio"));
        clTiempoPreparacion.setCellValueFactory(new PropertyValueFactory<Articulo, Integer>("tiempoPreparacion"));
        tblArticulos.setItems(articulos);
    }

    public void nuevoArticulo(){
        if(!tCodigo.getText().equals("")) {
            Articulo articulo = new Articulo(tCodigo.getText(),
                    tDescripcion.getText(),
                    Double.parseDouble(tPrecioVenta.getText()),
                    Double.parseDouble(tGastosEnvio.getText()),
                    Integer.parseInt(tTiempoPreparacion.getText()));

            datos.addArticulo(articulo);
        }
        refreshArticulosList();
    }
}

package sample;

import java.net.URL;
import java.util.ResourceBundle;
import java.text.DecimalFormat;

import com.amazon.ion.Timestamp;
import com.sun.javafx.scene.control.IntegerField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.pojo.Stroka;

public class Controller {
    ObservableList<Stroka> strokaData= FXCollections.observableArrayList();
    private double[][] a = new double[5][5];
    private double min, max;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button zapolnit;

    @FXML
    private Button vipolnit;

    @FXML
    private Label max_el;

    @FXML
    private Label min_el;

    @FXML
    private TableView<Stroka> Massiv;

    @FXML
    private TableColumn<Stroka, Double> c1;

    @FXML
    private TableColumn<Stroka, Double> c2;

    @FXML
    private TableColumn<Stroka, Double> c3;

    @FXML
    private TableColumn<Stroka, Double> c4;

    @FXML
    private TableColumn<Stroka, Double> c5;

    @FXML
    void rez(ActionEvent event) {
        DecimalFormat df = new DecimalFormat("###.#");
        Massiv.setItems(strokaData);
        double s = Math.pow(10,1);
        min=a[0][0];
        max=a[0][0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++){
                if (a[i][j]<min) min=a[i][j];
                if (a[i][j]>max) max=a[i][j];
            }
        }
        max_el.setText("Максимальный элемент="+df.format(max));min_el.setText("Минимальный элемент="+df.format(min));
        if (max==10*min) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    if (a[i][j] == 0) a[i][j]=1;
                    if (a[i][j] < 0) a[i][j]=Math.abs(a[i][j]);
                    a[i][j]=Math.round(a[i][j] * s)/s;
                }
                strokaData.addAll(new Stroka(a[i][0],a[i][1],a[i][2], a[i][3], a[i][4]));
            }
        }
    }


    @FXML
    void vvod_data(ActionEvent event) {
        DecimalFormat df = new DecimalFormat("###.#");
        Massiv.setItems(strokaData);
        double s = Math.pow(10,1);
       //заполняем массив и таблицу случайным образом
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++){
                a[i][j] = (double) (Math.random()*200 - 100);
                a[i][j]=Math.round(a[i][j] * s)/s;
            }
            strokaData.addAll(new Stroka(a[i][0],a[i][1],a[i][2], a[i][3], a[i][4]));
        }
       }
    @FXML
    void initialize() {

        assert zapolnit != null : "fx:id=\"zapolnit\" was not injected: check your FXML file 'sample.fxml'.";
        assert vipolnit != null : "fx:id=\"vipolnit\" was not injected: check your FXML file 'sample.fxml'.";
        assert max_el != null : "fx:id=\"max_el\" was not injected: check your FXML file 'sample.fxml'.";
        assert min_el != null : "fx:id=\"min_el\" was not injected: check your FXML file 'sample.fxml'.";
        assert Massiv != null : "fx:id=\"Massiv\" was not injected: check your FXML file 'sample.fxml'.";
        c1.setCellValueFactory(new PropertyValueFactory<Stroka, Double>("c1"));
        c2.setCellValueFactory(new PropertyValueFactory<Stroka, Double>("c2"));
        c3.setCellValueFactory(new PropertyValueFactory<Stroka, Double>("c3"));
        c4.setCellValueFactory(new PropertyValueFactory<Stroka, Double>("c4"));
        c5.setCellValueFactory(new PropertyValueFactory<Stroka, Double>("c5"));

        Massiv.setItems(strokaData);


    }
}

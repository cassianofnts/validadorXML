package application;

import java.io.IOException;
import java.util.List;

import arquivos.GerenciaMunicipio;
import arquivos.Municipio;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ValidadorXMLController {
	@FXML
	MenuItem menuImportar;
	@FXML
	TableView<Municipio> tblMunicipio;
	@FXML
	TableColumn<Municipio, String> colEstabelecimento;
	@FXML
	TableColumn<Municipio, Integer> colQtd;

	public void impMunicipio() {
		try {
			List<Municipio> lista = GerenciaMunicipio.carregaMunicipios();
			if (lista.isEmpty()) {
				System.out.println("Nenhum Municipio");
			} else {
				colEstabelecimento.setCellValueFactory(new PropertyValueFactory<Municipio, String>("nome"));
				colQtd.setCellValueFactory(new PropertyValueFactory<Municipio, Integer>("qtd"));
				for(Municipio x : lista) {
					tblMunicipio.getItems().add(x);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void limpaLista() {
		
	}
}

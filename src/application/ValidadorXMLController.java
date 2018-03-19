package application;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import arquivos.GerenciaMunicipio;
import arquivos.Municipio;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ValidadorXMLController {

	@FXML
	TableView<Municipio> tblMunicipio;
	@FXML
	TableColumn<Municipio, String> colEstab;
	@FXML
	TableColumn<Municipio, Integer> colQtd;
	@FXML
	TextField txtData;
	@FXML
	MenuItem mDiretorio;

	public void impMunicipio() {
		try {
			limpaTabela();
			List<Municipio> lista = GerenciaMunicipio.carregaMunicipios();
			if (!lista.isEmpty()) {
				colEstab.setCellValueFactory(new PropertyValueFactory<Municipio, String>("nome"));
				colQtd.setCellValueFactory(new PropertyValueFactory<Municipio, Integer>("qtd"));
				for (Municipio x : lista) {
					tblMunicipio.getItems().add(x);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void limpaTabela() {
		List<Municipio> listaRemover = tblMunicipio.getItems();
		tblMunicipio.getItems().removeAll(listaRemover);
		GerenciaMunicipio.getListaMunicipios().clear();
	}

	public void executa() {
		if (!GerenciaMunicipio.getListaMunicipios().isEmpty()) {
			if (!txtData.getText().isEmpty()) {
				Principal p = new Principal(txtData.getText());
				p.executar(GerenciaMunicipio.getListaMunicipios());
			} else {
				JOptionPane.showMessageDialog(null, "Digite a data!");

			}
		} else {
			JOptionPane.showMessageDialog(null, "Cadastre os municipios");
		}
	}

	public void configDiretorios() {
		try {
			Stage dirStage = new Stage();
			Pane root1 = (Pane) FXMLLoader.load(getClass().getResource("/fxml/configDiretorios.fxml"));
			Scene dirScene = new Scene(root1);
			dirStage.setScene(dirScene);
			dirStage.setTitle("Configurar Stage");
			dirStage.show();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

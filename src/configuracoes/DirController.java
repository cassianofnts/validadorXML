package configuracoes;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class DirController {

	@FXML
	TextField txtModelo;
	@FXML
	TextField txtExportacao;
	@FXML
	Button btnOk;
	@FXML
	Button btnModelo;
	@FXML
	Button btnExportacao;

	Diretorios d;

	@FXML
	public void initialize() {
		d = new Diretorios();
		txtModelo.setText(d.getDirModelo());
		txtExportacao.setText(d.getDirExport());
	}

	public void okClicked() {
		Stage stage = (Stage) btnOk.getScene().getWindow();
		stage.close();
	}

	public void btnModeloClicked() {
		String diretorio = this.getDiretorio();
		if (!diretorio.isEmpty()) {
			d.setModeloDir(diretorio);
			txtModelo.setText(diretorio);
		} else {
			System.out.println("nada selecionado");
			d.setModeloDir(d.getDirModelo());
			txtModelo.setText(d.getDirModelo());
		}
	}

	public void btnExportacaoClicked() {
		String diretorio = this.getDiretorio();
		if (!diretorio.isEmpty()) {
			d.setExportDir(diretorio);
			txtExportacao.setText(diretorio);
		} else {
			System.out.println("nada selecionado");
			d.setExportDir(d.getDirExport());
			txtExportacao.setText(d.getDirExport());
		}
	}

	public String getDiretorio() {
		JFileChooser chooser = new JFileChooser();
		String diretorio;
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int resposta = chooser.showOpenDialog(new JDialog());
		if (resposta == JFileChooser.APPROVE_OPTION) {
			diretorio = chooser.getSelectedFile().getAbsolutePath();
		} else {
			diretorio = "";
		}

		return diretorio;
	}

}

package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class GerenciaMunicipio {

	List<Municipio> listaMunicipios;

	public List<Municipio> carregaMunicipios() throws IOException {

		String caminhoArquivo = this.caminhoArquivo();
		if (!(caminhoArquivo == null)) {
			listaMunicipios = new ArrayList<Municipio>();
			try {
				FileInputStream arquivo = new FileInputStream(new File(caminhoArquivo));
				HSSFWorkbook workbook = new HSSFWorkbook(arquivo);
				HSSFSheet sheetTeste = workbook.getSheetAt(0);
				for (int i = 1; i <= sheetTeste.getLastRowNum(); i++) {
					Row row = sheetTeste.getRow(i);
					if (row.getCell(3).getStringCellValue().equalsIgnoreCase("s")) {
						String nome = row.getCell(4).getStringCellValue();
						int qtd = (int) row.getCell(13).getNumericCellValue();
						Municipio m = new Municipio(nome, qtd);
						listaMunicipios.add(m);
					}
				}
				workbook.close();
				arquivo.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("Arquivo Excel não encontrado!");
			}
		} else {
			listaMunicipios = null;
		}
		return listaMunicipios;
	}

	public List<Municipio> getListaMunicipios() {
		return listaMunicipios;
	}

	public String caminhoArquivo() {
		JFileChooser chooser = new JFileChooser();
		String arquivo;
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.xls,  *.xlsx", "xls", "xlsx");
		chooser.setFileFilter(filtro);
		int resposta = chooser.showOpenDialog(new JDialog());
		if (resposta == JFileChooser.APPROVE_OPTION) {
			arquivo = chooser.getSelectedFile().getAbsolutePath();
		} else {
			arquivo = null;
		}
		return arquivo;
	}

}

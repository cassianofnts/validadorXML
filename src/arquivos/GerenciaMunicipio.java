package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class GerenciaMunicipio {

	public static List<Municipio> carregaMunicipios() throws IOException {
		List<Municipio> listaMunicipios = new ArrayList<Municipio>();

		try {
			FileInputStream arquivo = new FileInputStream(new File(GerenciaMunicipio.caminhoArquivo()));
			HSSFWorkbook workbook = new HSSFWorkbook(arquivo);
			HSSFSheet sheetTeste = workbook.getSheetAt(0);
			for (int i = 1; i <= sheetTeste.getLastRowNum(); i++) {
				Row row = sheetTeste.getRow(i);
				if (row.getCell(0).getStringCellValue().equalsIgnoreCase("s")) {
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

		return listaMunicipios;
	}

	public static String caminhoArquivo() {
		JFileChooser chooser = new JFileChooser();
		int escolha = chooser.showOpenDialog(chooser.getParent());
		String arquivo = chooser.getSelectedFile().getAbsolutePath();
		return arquivo;
	}

}

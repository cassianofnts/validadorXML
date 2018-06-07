package configuracoes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Diretorios {

	public Properties getPropertyFile() throws IOException {
		InputStream inputStream;
		Properties prop = new Properties();
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("Arquivo Properties não encontrado");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return prop;
	}

	public String getDirExport() {
		String diretorio = "";
		try {
			Properties prop = this.getPropertyFile();
			diretorio = prop.getProperty("exportDir");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return diretorio;
	}

	public String getDirModelo() {
		String diretorio = "";
		try {
			Properties prop = this.getPropertyFile();
			diretorio = prop.getProperty("modeloDir");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return diretorio;
	}

	public void setExportDir(String path) {
		try {
			Properties prop = this.getPropertyFile();
			prop.setProperty("exportDir", path);
			prop.store(new FileOutputStream("resources\\config.properties"), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setModeloDir(String path) {
		try {
			Properties prop = this.getPropertyFile();
			prop.setProperty("modeloDir", path);
			;
			prop.store(new FileOutputStream("resources\\config.properties"), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package configuracoes;

import javafx.stage.Stage;

public class ConfigController {
	
	Stage configStage;
	
	public ConfigController(Stage configStage){
		this.configStage = configStage;
	}
	public void okClicked(){
		this.configStage.close();
	}
}


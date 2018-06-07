package tasks;

//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import appobject.CadastroAppObject;

public class CadastroTask {
	private CadastroAppObject cadastroAppObject;
	
	public CadastroTask(WebDriver driver) {
		this.cadastroAppObject = new CadastroAppObject(driver);
	}
	
	public void PreencherCadastro(String Email, String Password, String ConfirmPassword) {
		this.cadastroAppObject.getEmailTextField().sendKeys(Email);    
		this.cadastroAppObject.getSenhaTextField().sendKeys(Password);
		this.cadastroAppObject.getConfirmaSenhaTextField().sendKeys(ConfirmPassword);
	}
	
	public void EnviarFormulario() {
		this.cadastroAppObject.getCadastroButton().click();
	}
}
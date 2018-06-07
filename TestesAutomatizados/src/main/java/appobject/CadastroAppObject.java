package appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroAppObject {
	private WebDriver driver;
	
	public CadastroAppObject(WebDriver driver) 			//mapear o Register do site
	{
		this.driver = driver;
	}
	
	public WebElement getEmailTextField() 
	{
		return this.driver.findElement(By.id("Email"));			//mapeando email
	}
	
	public WebElement getSenhaTextField() 
	{
		return this.driver.findElement(By.id("Password"));		//mapeando senha
	}
	
	public WebElement getConfirmaSenhaTextField() 
	{
		return this.driver.findElement(By.id("ConfirmPassword"));		//mapeando confirma senha
	}
	
	public WebElement getCadastroButton() {
		//return this.driver.findElement(By.className("btn btn-default"));		
		//return this.driver.findElement(By.cssSelector("#cadastrar > fieldset > div:nth-child(8) > div > input"));
		return this.driver.findElement(By.xpath("//*[@id=\"default\"]/form/div[5]/div/input"));
	}
	
}
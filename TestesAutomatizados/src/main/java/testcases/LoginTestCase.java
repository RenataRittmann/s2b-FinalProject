package testcases;

//import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import verificationpoints.LoginVerificationPoint;

public class LoginTestCase {

	private WebDriver driver;
	private LoginVerificationPoint verificationPoint;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("http://ec2-18-231-195-92.sa-east-1.compute.amazonaws.com:8008/Home");
		
		this.verificationPoint = new LoginVerificationPoint(driver);
	}
	
	@Test
	public void testMain() {
		WebElement emailTextField = this.driver.findElement(By.xpath("//*[@id=\"Email\"]"));  
		WebElement passwordTextField = this.driver.findElement(By.xpath("//*[@id=\"Password\"]"));
		WebElement loginButton = this.driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[4]/div/input")); //Mapear botão
		
		
		emailTextField.sendKeys("teste@teste.com"); 	//Inserir texto "demo" no campo texto
		passwordTextField.sendKeys("Teste*123");  //Inserir texto "demo" no campo de texto
		loginButton.click();
		
		this.verificationPoint.checkHelloMessage();
		
	}
	
	@After
	public void tearDown() {
		//this.driver.quit();
	}
	
}

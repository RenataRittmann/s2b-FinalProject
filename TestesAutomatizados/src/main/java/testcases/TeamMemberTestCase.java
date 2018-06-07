package testcases;

//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import verificationpoints.LoginVerificationPoint;

public class TeamMemberTestCase {
	
	private WebDriver driver;
	private LoginVerificationPoint verificationPoint;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("http://ec2-18-231-195-92.sa-east-1.compute.amazonaws.com:8008/TeamMember/Create");
		this.verificationPoint = new LoginVerificationPoint(driver);
	}
	
	@Test
	public void testMain() {
		WebElement emailTextField = this.driver.findElement(By.xpath("//*[@id=\"Email\"]"));  
		WebElement passwordTextField = this.driver.findElement(By.xpath("//*[@id=\"Password\"]"));
		WebElement loginButton = this.driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[4]/div/input")); 
		
		
		emailTextField.sendKeys("teste@teste.com"); 
		passwordTextField.sendKeys("Teste*123");  
		loginButton.click();
		
		//repetição do código do login para que ele entre na conta para fazer o cadastro do novo membro
		
		WebElement nameTextField = this.driver.findElement(By.xpath("//*[@id=\"Name\"]"));
		WebElement initialsTextField = this.driver.findElement(By.xpath("//*[@id=\"Initials\"]"));  
		WebElement roleTextField = this.driver.findElement(By.xpath("//*[@id=\"Role\"]"));
		WebElement placeTextField = this.driver.findElement(By.xpath("//*[@id=\"Place\"]"));
		WebElement createButton = this.driver.findElement(By.xpath("//*[@id=\"default\"]/div[1]/form/div/div/div[5]/div/input"));
		
		nameTextField.sendKeys("José Francisco");
		initialsTextField.sendKeys("JF"); 	
		roleTextField.sendKeys("***função***");  
		placeTextField.sendKeys("***local***");
		createButton.click();
		
		this.verificationPoint.checkHelloMessage();
		
	}
	
	@After
	public void tearDown() {
		//this.driver.quit();
	}
	
}

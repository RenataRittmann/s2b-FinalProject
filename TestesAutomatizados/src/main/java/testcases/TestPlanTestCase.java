package testcases;

//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import verificationpoints.LoginVerificationPoint;


public class TestPlanTestCase {

	private WebDriver driver;
	private LoginVerificationPoint verificationPoint;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("http://ec2-18-231-195-92.sa-east-1.compute.amazonaws.com:8008/TestPlan/Create");
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
		
		//repetição do código do login para que ele entre na conta para fazer o cadastro do plano de teste
		
		WebElement identifierTextField = this.driver.findElement(By.xpath("//*[@id=\"TestPlanId\"]"));
		WebElement nameTextField = this.driver.findElement(By.xpath("//*[@id=\"Name\"]"));
		WebElement startingdateTextField = this.driver.findElement(By.xpath("//*[@id=\"BeginDate\"]"));  
		WebElement finaldateTextField = this.driver.findElement(By.xpath("//*[@id=\"FinalDate\"]"));
		WebElement goalTextField = this.driver.findElement(By.xpath("//*[@id=\"Goal\"]"));
		WebElement featuresTextField = this.driver.findElement(By.xpath("//*[@id=\"Features\"]"));
		WebElement linkTextField = this.driver.findElement(By.xpath("//*[@id=\"Link\"]"));
		WebElement environmentTextField = this.driver.findElement(By.xpath("//*[@id=\"Environment\"]"));
		WebElement equipmentsTextField = this.driver.findElement(By.xpath("//*[@id=\"Equipments\"]"));
		WebElement observationsTextField = this.driver.findElement(By.xpath("//*[@id=\"Observations\"]"));
		WebElement statusComboBox = this.driver.findElement(By.xpath("//*[@id=\"Status\"]"));
		WebElement memberComboBox = this.driver.findElement(By.xpath("//*[@id=\"field\"]"));
		WebElement createButton = this.driver.findElement(By.xpath("//*[@id=\"create\"]/div/input"));
		
		identifierTextField.sendKeys("002");
		nameTextField.sendKeys("Plano 002");
		startingdateTextField.sendKeys("23042018"); 	
		finaldateTextField.sendKeys("07062018");  
		goalTextField.sendKeys("***objetivo***");
		featuresTextField.sendKeys("***características***");
		linkTextField.sendKeys("http://ec2-18-231-195-92.sa-east-1.compute.amazonaws.com:8008/TestPlan/Create");
		environmentTextField.sendKeys("***meio ambiente***");
		equipmentsTextField.sendKeys("***equipamentos***");
		observationsTextField.sendKeys("***observações***");
		statusComboBox.sendKeys(Keys.ARROW_DOWN);
		statusComboBox.sendKeys(Keys.ENTER);
		memberComboBox.sendKeys(Keys.ARROW_DOWN);
		memberComboBox.sendKeys(Keys.ENTER);
		createButton.click();
		
		this.verificationPoint.checkHelloMessage();
		
	}
	
	@After
	public void tearDown() {
		//this.driver.quit();
	}

}

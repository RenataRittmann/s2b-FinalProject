package testcases;

//import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import verificationpoints.LoginVerificationPoint;


public class BugsTestCase {

	private WebDriver driver;
	private LoginVerificationPoint verificationPoint;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("http://ec2-18-231-195-92.sa-east-1.compute.amazonaws.com:8008/Bug/Create");
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
		
		
		WebElement titleTextField = this.driver.findElement(By.xpath("//*[@id=\"Title\"]"));
		titleTextField.sendKeys("Segundo bug encontrado");
		
		WebElement idTextField = this.driver.findElement(By.xpath("//*[@id=\"BugId\"]"));
		idTextField.sendKeys("02");
		
		WebElement abstractTextField = this.driver.findElement(By.xpath("//*[@id=\"Abstract\"]"));
		abstractTextField.sendKeys("***abstract***");
		
		WebElement descripitionTextField = this.driver.findElement(By.xpath("//*[@id=\"Description\"]")); 
		descripitionTextField.sendKeys("Descrição sobre o segundo bug encontrado"); 
		
		WebElement testPlanComboBox = this.driver.findElement(By.xpath("//*[@id=\"TestPlanId\"]"));
		testPlanComboBox.sendKeys(Keys.ARROW_DOWN);
		testPlanComboBox.sendKeys(Keys.ENTER);
		
		WebElement testCaseComboBox = this.driver.findElement(By.xpath("//*[@id=\"TestCaseId\"]"));		
		testCaseComboBox.sendKeys(Keys.ARROW_DOWN);
		testCaseComboBox.sendKeys(Keys.ENTER);
		
		WebElement stepsTextField = this.driver.findElement(By.xpath("//*[@id=\"Steps\"]"));
		stepsTextField.sendKeys("***Passos para encontrar o bug"); 		
		
		WebElement stateComboBox = this.driver.findElement(By.xpath("//*[@id=\"State\"]"));
		stateComboBox.sendKeys(Keys.ARROW_DOWN);
		stateComboBox.sendKeys(Keys.ARROW_DOWN);
		stateComboBox.sendKeys(Keys.ARROW_DOWN);
		stateComboBox.sendKeys(Keys.ENTER);
		
		WebElement frequencyComboBox = this.driver.findElement(By.xpath("//*[@id=\"Frequency\"]"));
		frequencyComboBox.sendKeys(Keys.ARROW_DOWN);
		frequencyComboBox.sendKeys(Keys.ENTER);	
		
		WebElement gravityComboBox = this.driver.findElement(By.xpath("//*[@id=\"Gravity\"]"));
		gravityComboBox.sendKeys(Keys.ARROW_DOWN);
		gravityComboBox.sendKeys(Keys.ARROW_DOWN);
		gravityComboBox.sendKeys(Keys.ENTER);
		
		WebElement priorityComboBox = this.driver.findElement(By.xpath("//*[@id=\"Priority\"]"));
		priorityComboBox.sendKeys(Keys.ARROW_DOWN);
		priorityComboBox.sendKeys(Keys.ARROW_DOWN);
		priorityComboBox.sendKeys(Keys.ARROW_DOWN);
		priorityComboBox.sendKeys(Keys.ENTER);
		
		WebElement responsibleComboBox = this.driver.findElement(By.xpath("//*[@id=\"dropTM\"]"));
		responsibleComboBox.sendKeys(Keys.ARROW_DOWN);
		responsibleComboBox.sendKeys(Keys.ENTER);
		
		WebElement createButton = this.driver.findElement(By.xpath("//*[@id=\"create\"]/div/input"));		
		createButton.click();
		
		this.verificationPoint.checkHelloMessage();
		
	}
	
	@After
	public void tearDown() {
		//this.driver.quit();
	}

}

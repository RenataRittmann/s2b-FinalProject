package testcases;

//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import verificationpoints.LoginVerificationPoint;

public class TestCaseTestCase {

	private WebDriver driver;
	private LoginVerificationPoint verificationPoint;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("http://ec2-18-231-195-92.sa-east-1.compute.amazonaws.com:8008/TestCase/Create");
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
		
		WebElement idTextField = this.driver.findElement(By.xpath("//*[@id=\"TestCaseId\"]"));
		idTextField.sendKeys("Caso 02");
		
		WebElement titleTextField = this.driver.findElement(By.xpath("//*[@id=\"Title\"]"));
		titleTextField.sendKeys("Segundo caso de teste");
		
		WebElement testPlanComboBox = this.driver.findElement(By.xpath("//*[@id=\"TestPlanId\"]"));
		testPlanComboBox.sendKeys(Keys.ARROW_DOWN);
		testPlanComboBox.sendKeys(Keys.ENTER);
		
		WebElement responsibleComboBox = this.driver.findElement(By.xpath("//*[@id=\"dropTM\"]"));
		responsibleComboBox.sendKeys(Keys.ARROW_DOWN);
		responsibleComboBox.sendKeys(Keys.ENTER);
		
		WebElement descripitionTextField = this.driver.findElement(By.xpath("//*[@id=\"Description\"]")); 
		descripitionTextField.sendKeys("Descrição sobre o segundo caso de teste"); 
		
		WebElement statusComboBox = this.driver.findElement(By.xpath("//*[@id=\"CaseStatus\"]"));
		statusComboBox.sendKeys(Keys.ARROW_DOWN);
		statusComboBox.sendKeys(Keys.ARROW_DOWN);
		statusComboBox.sendKeys(Keys.ARROW_DOWN);
		statusComboBox.sendKeys(Keys.ENTER);
		
		WebElement importanceComboBox = this.driver.findElement(By.xpath("//*[@id=\"Importance\"]"));		
		importanceComboBox.sendKeys(Keys.ARROW_DOWN);
		importanceComboBox.sendKeys(Keys.ARROW_DOWN);	//descer um só é medium importance e duas é low
		importanceComboBox.sendKeys(Keys.ENTER);
		
		WebElement executationComboBox = this.driver.findElement(By.xpath("//*[@id=\"ExecutionType\"]"));
		executationComboBox.sendKeys(Keys.ARROW_DOWN);
		executationComboBox.sendKeys(Keys.ENTER);
		
		WebElement obsTextField = this.driver.findElement(By.xpath("//*[@id=\"Observations\"]"));
		obsTextField.sendKeys("Observações sobre o segundo caso de teste"); 
		
		WebElement actionTextField = this.driver.findElement(By.xpath("//*[@id=\"fields\"]/div[1]/div/div/input"));
		actionTextField.sendKeys("Clicar no botão +");
		
		WebElement resultTextField = this.driver.findElement(By.xpath("//*[@id=\"fields\"]/div[2]/div/div/input"));
		resultTextField.sendKeys("Apareecer mais um campo de Action e mais um de Expected Result");
		
		WebElement plusButton = this.driver.findElement(By.xpath("//*[@id=\"btnAddField\"]"));
		plusButton.click();
		
		WebElement action2TextField = this.driver.findElement(By.xpath("//*[@id=\"fields\"]/div[4]/div/div/input"));
		action2TextField.sendKeys("Clicar no botão -");
		
		WebElement result2TextField = this.driver.findElement(By.xpath("//*[@id=\"fields\"]/div[5]/div/div/input"));
		result2TextField.sendKeys("Desaparecer os campos criados");
		
		WebElement plus2Button = this.driver.findElement(By.xpath("//*[@id=\"btnAddField\"]/span"));
		plus2Button.click();
		
		WebElement minusButton = this.driver.findElement(By.xpath("//*[@id=\"btnRemoveField\"]/span"));
		minusButton.click();
		
		
		WebElement createButton = this.driver.findElement(By.xpath("//*[@id=\"btn-action\"]"));		
		createButton.click();
		
		this.verificationPoint.checkHelloMessage();
		
	}
	
	@After
	public void tearDown() {
		//this.driver.quit();
	}
	
}

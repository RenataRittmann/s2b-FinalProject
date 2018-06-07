package testcases;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import tasks.CadastroTask;

public class CadastroTestCase {
	
	private WebDriver driver;
	private CadastroTask cadastro;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();  //WebDriverManager.firefoxdriver().setup();
		this.driver = new ChromeDriver(); //FirefoxDriver();
		this.driver.get("http://ec2-18-231-195-92.sa-east-1.compute.amazonaws.com:8008/Account/Register");
		this.driver.manage().window().maximize();
		this.cadastro = new CadastroTask(driver);
	}
	
	@Test
	public void testMain() {
		this.cadastro.PreencherCadastro("joana@teste.com", "Teste*123", "Teste*123");
		this.cadastro.EnviarFormulario();
	}
	
	@After
	public void tearDown() throws Exception {
		//driver.quit();   COMENTANDO ESTA PARTE, FAZ O BROWNSER PARAR PARA VERIFICARMOS
	}	
}
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
	WebDriver driver = new ChromeDriver();
String[] allname= {"Hermoine Granger","Harry Potter","Ron Weasly","Albus Dumbledore","Neville Longbottom"};
String[] FirstNmae= {"batool ","hikmat ","abed ","jadoo ","lamar "};
String[] LastNmae= {" hussin"," zaid"," sawan"," bana"," lana"};
String[] Post= {"0000","1111","2222","4444","5555"};
String[] curancy= {"Dollar","Pound","Rupee"};

	@BeforeTest
	public void sutup() {
	driver.get("https://globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
	
//	https://globalsqa.com/angularJs-protractor/BankingProject/#/login
//		1- go to this website and press on customer login 
//		2- select any random customer from the list 
//		3- add one Deposit process let the amount to be randomly entered use java concepts 
//		4- then withdraw the amount you add 
//		5- create one assertion that the balance is correct 
	
	@Test(enabled = false)
	public void customerlogin  () throws InterruptedException {
		WebElement farm=driver.findElement(By.cssSelector(".borderM.box.padT20"));
		WebElement Customer=driver.findElement(By.cssSelector("button[ng-click=\"customer()\"]"));
		Customer.click();
      WebElement customers=driver.findElement(By.cssSelector("#userSelect"));
customers.click();
Random rand = new Random();
int Randomen=rand.nextInt(allname.length);
WebElement customers1=driver.findElement(By.cssSelector("#userSelect"));
customers1.sendKeys(allname[Randomen]);
customers1.click();
WebElement login=driver.findElement(By.cssSelector("button[type=\"submit\"]"));
login.click();
//WebElement Name=driver.findElement(By.cssSelector(".fontBig.ng-binding"));
//String nametext=Name.getText();		
//String axpected="welcom"+" "+nametext+" !!";
//WebElement acual=driver.findElement(By.cssSelector("div[class=\"borderM box padT20 ng-scope\"] div:nth-child(1) strong:nth-child(1)"));
//String acualtext=acual.getText();		
//Assert.assertEquals(acualtext, axpected);	
WebElement fram=driver.findElement(By.cssSelector(".borderM.box.padT20.ng-scope"));
WebElement butons=driver.findElement(By.cssSelector("div[class=\"ng-scope\"] div:nth-child(3)"));
WebElement Deposit =driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]"));
Deposit.click();
//WebElement AMOUNT=driver.findElement(By.cssSelector("input[placeholder=\"amount\"]"));
//WebElement deposit=driver.findElement(By.cssSelector("button[type=\"submit\"]"));

Random random = new Random();
int depositAmount = 100 + random.nextInt(900);

WebElement amountInput = driver.findElement(By.cssSelector("input[placeholder=\"amount\"]"));
amountInput.sendKeys(String.valueOf(depositAmount));
amountInput.click();
WebElement des=driver.findElement(By.cssSelector("button[type=\"submit\"]"));
Thread.sleep(2000);



des.click();

WebElement withdraw=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]"));
withdraw.click();
WebElement amountInput2 = driver.findElement(By.cssSelector("input[placeholder=\"amount\"]"));
amountInput2.sendKeys(String.valueOf(depositAmount));
amountInput2.click();
String TextamountInput2=amountInput2.getText();
Thread.sleep(3000);
WebElement with=driver.findElement(By.cssSelector("button[type=\"submit\"]"));
//with.click();
WebElement fram1=driver.findElement(By.cssSelector(".borderM.box.padT20.ng-scope"));
WebElement INFORMATION=driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3)"));

WebElement balance=driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(2)"));
int TextamountInputtwith= Integer.parseInt(amountInput.getText());
int TextamountInputDep = Integer.parseInt(amountInput2.getText());
int total=TextamountInputtwith-TextamountInputDep;
int acual=Integer.parseInt(balance.getText());
Assert.assertEquals(total = acual, true);
}
@Test()
public void bankManagerLogin () throws InterruptedException{
	WebElement farm=driver.findElement(By.cssSelector(".borderM.box.padT20"));
	WebElement bankManger=driver.findElement(By.cssSelector("button[ng-click=\"manager()\"]"));
	bankManger.click();
	WebElement fram=driver.findElement(By.cssSelector(".border.box.padT20.ng-scope"));
//	WebElement allbutoon=driver.findElement(By.cssSelector(".center"));
//	Thread.sleep(3000);
	WebElement AddCustomer=driver.findElement(By.cssSelector(".btn.btn-lg.tab[ng-class=\"btnClass1\"]"));
	AddCustomer.click();
	WebElement firstname=driver.findElement(By.cssSelector("input[placeholder=\"First Name\"]"));
	Random random = new Random();
		String randomFirstNmae = FirstNmae[random.nextInt(FirstNmae.length)];
		firstname.sendKeys(randomFirstNmae);//randomFirstNmae
		WebElement lastname=driver.findElement(By.cssSelector("input[placeholder=\"Last Name\"]"));
			String randomlastname = LastNmae[random.nextInt(LastNmae.length)];
			lastname.sendKeys(randomlastname);
			WebElement post=driver.findElement(By.cssSelector("input[placeholder=\"Post Code\"]"));
				String randompost = Post[random.nextInt(Post.length)];
				post.sendKeys(randompost);
				WebElement add=driver.findElement(By.cssSelector("button[type=\"submit\"]"));
add.click();

Alert alert = driver.switchTo().alert();
// Get the text of the alert
String alertText = alert.getText();
System.out.println("Alert text: " + alertText);
// Accept the alert
alert.accept();
System.out.println("Alert accepted successfully.");

driver.get("https://globalsqa.com/angularJs-protractor/BankingProject/#/manager/openAccount");
Thread.sleep(3000);
WebElement name=driver.findElement(By.cssSelector("#userSelect"));
name.sendKeys(randomFirstNmae);
name.sendKeys(randomlastname);
WebElement CURANCY=driver.findElement(By.cssSelector("#currency"));
String randomcurancy = curancy[random.nextInt(curancy.length)];
CURANCY.sendKeys(randomcurancy);

WebElement process=driver.findElement(By.cssSelector("button[type=\"submit\"]"));
process.click();
Alert alert1 = driver.switchTo().alert();
//Get the text of the alert
String alertText1 = alert.getText();
System.out.println("Alert text: " + alertText1);
//Accept the alert
alert.accept();
System.out.println("Alert accepted successfully.");
driver.get("https://globalsqa.com/angularJs-protractor/BankingProject/#/manager/list");
WebElement search=driver.findElement(By.cssSelector("input[placeholder=\"Search Customer\"]"));
search.sendKeys(randomFirstNmae);
Thread.sleep(2000);
WebElement delet=driver.findElement(By.cssSelector("button[ng-click=\"deleteCust(cust)\"]"));
delet.click();
}
	
	@AfterTest
	public void enftest() {
	}
}
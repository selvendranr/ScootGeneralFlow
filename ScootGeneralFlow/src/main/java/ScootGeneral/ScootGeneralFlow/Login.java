package ScootGeneral.ScootGeneralFlow;

import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pack.base.LogInCredential;
import pack.base.ReadCredential;
import pack.base.ReadRootPath;
import pack.base.TestBaseSetup;

public class Login extends TestBaseSetup{
protected WebDriver driver;

String filePath="LoginCredential";
String fileName="\\Credential.xls";
String userNameV;

	
	
	String emailTextBox = "input[id=loginUserName]";
	String passwordTextBox = "input[id=loginUserPassword]";
	String loginBtn = "input[id=login]";
	String welcomeUser="p[class=welcome]";
	String secutityTimeOut="a[class='link']";
	
	String uNameTravel,pWordTravel,uNameAdmin,pWordAdmin;
	
	WebElement webEle;
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	public void doLogin(int loginIndex)
	{
		  ReadRootPath readRoot=new ReadRootPath();
		  String rootPath=readRoot.getPath();

		ReadCredential cred=new ReadCredential(driver);
		List<LogInCredential> s=cred.readExcelData(rootPath+filePath+fileName);
		uNameTravel=s.get(loginIndex).getName().trim();
		pWordTravel=s.get(loginIndex).getPassword().trim();
		try{
			waitExplicitlyByLocator(driver,emailTextBox,"cssselector",60);
		}catch(TimeoutException e){
			System.out.println("Logged out ");
			findEle(driver,secutityTimeOut,"cssselector").click();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		findEle(driver,emailTextBox,"cssselector").clear();
		findEle(driver,passwordTextBox,"cssselector").clear();
		findEle(driver,emailTextBox,"cssselector").sendKeys(uNameTravel);
		findEle(driver,passwordTextBox,"cssselector").sendKeys(pWordTravel);
		findEle(driver,loginBtn,"cssselector").click();
		
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitExplicitlyByLocator(driver,welcomeUser,"cssselector",30);	
	
		webEle=findEle(driver,welcomeUser,"cssselector");
		if(webEle.isDisplayed())
		{	 userNameV=webEle.getText();
		System.out.println(userNameV);
		userNameV=userNameV.substring(userNameV.lastIndexOf(" "));
			System.out.println("User Name "+userNameV+" is Successfully verified");
		}
		else
		{
			System.out.println("Not able to verify welcome screen");
		}
		
		
		
			
	}

}

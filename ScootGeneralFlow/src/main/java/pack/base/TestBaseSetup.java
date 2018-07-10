package pack.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.google.common.base.Function;



public class TestBaseSetup {
	private WebDriver driver;
	static String scrnPath = "ScreenShotIfAny\\";
	static String driverPath ="DriverBackupFiles\\";
	String filePath="LoginCredential";
	String fileName="\\Credential.xls";	
	static ReadRootPath readRoot=new ReadRootPath();
	static String rootPath=readRoot.getPath();

	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String appURL) {
		
		browserType=browserType.toUpperCase();
		switch (browserType) {
		case "CHROME":
			driver = initChromeDriver(appURL);
			break;
			
		case "IE":
			driver = initIEDriver(appURL);
			break;
		case "FIREFOX":
			driver = initFirefoxDriver(appURL);
			break;
			
		case "HTMLUNIT":			 
			driver = initHtmlUnitDriver(appURL);
			break;	
	  
		case "PHANTOMJS":	//PhantomJS		 
			driver = initPhantomJSDriver(appURL);
			break;	

			
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

	
	
	
	
	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", rootPath+driverPath+"chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}
	
	private static WebDriver initIEDriver(String appURL) {
		System.out.println("Launching Internet Explorer with new profile..");
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		capabilities.setCapability("allow-blocked-content", true);
		capabilities.setCapability("allowBlockedContent", true);
		capabilities.setCapability("ie.ensureCleanSession", true);
		File file = new File(rootPath+driverPath+"IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		
		
		//System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer\\IEDriverServer32\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver(capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.get(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver", rootPath+driverPath+"geckodriver.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);
		//driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}
	
	private static WebDriver initHtmlUnitDriver(String appURL) {
		System.out.println("Launching HTML UNIT Driver with new profile..");
	 
		 Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
		 Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

		WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(appURL);
		return driver;
	}
	
	
	private static WebDriver initPhantomJSDriver(String appURL) {
		System.out.println("Launching PhantomJS Driver with new profile..");
	 
		File file = new File(rootPath+driverPath+"PhantomJSDriver\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");  
	 	System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
		WebDriver driver = new PhantomJSDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(appURL);
		return driver;
	}
	//Reusable Code For Input Text
	


	
	//Reusable Code for Finding Element   
	
			public WebElement findEle(WebDriver driver,String locator,String ltype) {
				 
				WebElement webele = null;	
				 
				 ltype = ltype.toUpperCase();
				 
				 switch (ltype) {
					 
				 case "ID": 
						
					 webele=driver.findElement(By.id(locator));
					
						break;
						
						
					case "NAME": 
						
						webele=driver.findElement(By.name(locator));
						break;
						
					case "CSSSELECTOR": 
						
						webele=driver.findElement(By.cssSelector(locator));
						break;
						
					case "XPATH": 
						
						webele=driver.findElement(By.xpath(locator));
						break;
					
					case "CLASSNAME": 
						
						webele=driver.findElement(By.className(locator));
						break;
						
					case "LINKTEXT": 
						
						webele=driver.findElement(By.linkText(locator));
						break;
						
					
					case "PARTIALLINK": 
						
						webele=driver.findElement(By.partialLinkText(locator));
						break;
					
					case "TAGNAME": 
						
						webele=driver.findElement(By.tagName(locator));
						break;
						
					
						default:
							System.out.println("unknown Locator" );
							break;
					 }
				 return webele;
					 
				 }
	
			
			
			
					
			



public WebElement waitForWebElementFluently(WebDriver driver, final WebElement locator, int timeoutSeconds) {
    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeoutSeconds, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return locator;
                }
            }
        );
        return foo;
}

public void waitExplicitlyByLocator(WebDriver driver,String locator,String locatorType,int timeout) {
	    
	
	WebDriverWait wait = null;
	locatorType = locatorType.toUpperCase();
	    
	    switch (locatorType) {
		 
		   case "CSSSELECTOR":
			   wait=new WebDriverWait(driver, timeout);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
	          break;
	          
	      case "XPATH":
	    	  
	    	 wait=new WebDriverWait(driver, timeout);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	    	  
	      break;
	      
	      case "LINKTEXT":	
	    	  wait=new WebDriverWait(driver, timeout);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
		break;

	      case "ID":	
	    	 wait=new WebDriverWait(driver, timeout);
	    	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
	    	  break; 
	      
	      	   
	      case "CLASSNAME":	
		    	 wait=new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
			break; 
		      		   
			
			case "PARTIALLINKTEXT": 
				
				 wait=new WebDriverWait(driver, timeout);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
					break; 
				      		
			
			case "TAGNAME": 
				
				 wait=new WebDriverWait(driver, timeout);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator)));
					break; 
					  
	      
	      default:
					System.out.println("unknown Locator" );
					break;
	      
		 } 
	   
	}


public void waitExplicitlyNotByLocator(WebDriver driver,String locator,String locatorType,int timeout) {
	    
	
	WebDriverWait wait = null;
	locatorType = locatorType.toUpperCase();
	    
	    switch (locatorType) {
		 
		   case "CSSSELECTOR":
			   wait=new WebDriverWait(driver, timeout);
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(locator)));
	          break;
	          
	      case "XPATH":
	    	  
	    	 wait=new WebDriverWait(driver, timeout);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	    	  
	      break;
	      
	      case "LINKTEXT":	
	    	  wait=new WebDriverWait(driver, timeout);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(locator)));
		break;

	      case "ID":	
	    	 wait=new WebDriverWait(driver, timeout);
	    	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(locator)));
		break; 
	      
	      	   
	      case "CLASSNAME":	
		    	 wait=new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(locator)));
			break; 
		      		   
			
			case "PARTIALLINKTEXT": 
				
				 wait=new WebDriverWait(driver, timeout);
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.partialLinkText(locator)));
					break; 
				      		
			
			case "TAGNAME": 
				
				 wait=new WebDriverWait(driver, timeout);
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName(locator)));
					break; 
					  
	      
	      default:
					System.out.println("unknown Locator" );
					break;
	      
		 } 
	   
	}

public void waitUntilAlertPresent(WebDriver driver,int timeout) {
	WebDriverWait wait =new WebDriverWait(driver,timeout);
    wait.until(ExpectedConditions.alertIsPresent());
    
}
	
//Reusable code for Select Drop down by simply using id locator
	


	

public void implicitWait(WebDriver driver){
	
	try {
		
	
driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}
	catch(Exception e) {
		
		System.out.println(e.getMessage());
	}
}
//Generate Random String 


private static final String ALPHA_NUM ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";   
    
  public String getAlphaNumeric(int len) {   
     StringBuffer sb = new StringBuffer(len);   
     for (int i=0;  i<len;  i++) {   
        int ndx = (int)(Math.random()*ALPHA_NUM.length());   
        sb.append(ALPHA_NUM.charAt(ndx));   
     }   
     return sb.toString();   
  }   

  
  
  
  //Get Random Name 
  
  private static String[] firstName = { "Ada", "Albert", "Alexandra", "Alfredo", "Allen", "Andre", "Angelica",
      "Anna", "Anthony", "Antonio", "Ashley", "Audrey", "Beatrice",
      "Benjamin", "Billy", "Bobby", "Bradley", "Bryant", "Candace",
      "Carole", "Carrie", "Claire", "Clifford", "Clint", "Clyde", "Cory",
      "Dale", "Danielle", "Daryl", "Delia", "Devin", "Douglas", "Eddie",
      "Ella", "Erica", "Erika", "Eva", "Frank", "Gayle", "George", "Georgia",
      "Geraldine", "Gina", "Gwen", "Hector", "Homer", "Irene", "James",
      "Jamie", "Jeremiah", "Joann", "Josefina", "Juan", "Karen", "Kenneth",
      "Laurie", "Lee", "Leland", "Leroy", "Levi", "Lewis", "Lillian",
      "Lillie", "Lorenzo", "Louise", "Lucas", "Lynn", "Marc", "Marcella",
      "Marlon", "Marvin", "Micheal", "Miranda", "Miriam", "Misty", "Naomi",
      "Natasha", "Nelson", "Oliver", "Pete", "Rafael", "Randall", "Raul",
      "Rebecca", "Reginald", "Roger", "Ruby", "Rufus", "Sabrina", "Sean",
      "Steven", "Stuart", "Terence", "Terry", "Van", "Velma", "Vincent",
      "Wanda", "Willard", "Winifred" };
 private static String[] lastName = {  "Adkins", "Aguilar", "Anderson", "Armstrong", "Arnold", "Bailey",
      "Banks", "Barrett", "Bates", "Bennett", "Bowers", "Bradley", "Brown",
      "Bryant", "Buchanan", "Bush", "Butler", "Cain", "Carlson", "Carroll",
      "Cummings", "Diaz", "Doyle", "Duncan", "Dunn", "Fernandez", "Foster",
      "Fowler", "Fox", "Francis", "French", "Garrett", "Gill", "Glover",
      "Goodwin", "Gordon", "Grant", "Griffin", "Gross", "Guerrero", "Hale",
      "Harvey", "Holland", "Ingram", "Jacobs", "James", "Lamb", "Lowe",
      "Lucas", "Mann", "Marshall", "Martin", "Martinez", "May", "Mcdaniel",
      "Mendoza", "Meyer", "Moody", "Moreno", "Nelson", "Nichols", "Norton",
      "Obrien", "Osborne", "Padilla", "Page", "Parks", "Parsons", "Payne",
      "Pearson", "Powell", "Reese", "Reeves", "Reyes", "Reynolds",
      "Richardson", "Rios", "Ross", "Russell", "Saunders", "Sharp", "Simon",
      "Smith", "Steele", "Stephens", "Stokes", "Summers", "Thomas",
      "Thompson", "Tyler", "Wagner", "Ward", "Washington", "Watkins",
      "Watson", "Weber", "West", "Willis", "Young", "Zimmerman" };
 
 private static Random rand = new Random();

 public String generateFirstName() {

    
	return firstName[rand.nextInt(firstName.length)] ;

 
 
 
 }
 public String generateLastName() {

	      
		return  lastName[rand.nextInt(lastName.length)] ;

	   
	   
	   
	   }
 
 //Randow Travel Agent 


 

 //To Write file
 
 public void toWriteFile(String FileAbsolutePath,String contentToWrite){
	 
	 
	  BufferedWriter writer = null;
      try {
          //create a temporary file
         
          File logFile = new File(FileAbsolutePath);



          writer = new BufferedWriter(new FileWriter(logFile));
          writer.write(contentToWrite);
          System.out.println("File Written Successfully");
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          try {
              // Close the writer regardless of what happens...
              writer.close();
          } catch (Exception e) {
          }
      }
      
	 
 }
 
 
 public String toReadFile(String FileAbsolutePath){
	 String fileContent = null,readLocal = null;
	 BufferedReader br = null;

		try {

			

			br = new BufferedReader(new FileReader(FileAbsolutePath));

			while ((readLocal = br.readLine()) != null) {
				System.out.println(readLocal);
				fileContent=readLocal;
				
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return fileContent;
 }
 
 

//TAKE SCREENSHOT
String cDate;
		public void getscreenshot(WebDriver driver,String folder,String name)  {
			
			
			try {
			
			
			cDate = GetTimeStampValue();
			
			try {
				
				
				driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
					}
					catch(Exception e) {
						
						System.out.println(e.getMessage());
					}
	        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        
	          FileUtils.copyFile(scrFile, new File(rootPath+scrnPath+folder+cDate+"  "+name+".png"));
			}
			
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
	      }
		
		public  String GetTimeStampValue()throws IOException{

	        Calendar cal = Calendar.getInstance();       
	         Date time=cal.getTime();
	         String timestamp=time.toString();
	            System.out.println(timestamp);
	            String systime=timestamp.replace(":", "-");
	            System.out.println(systime);
	        return systime;

		}

//Get random number for Calendar date 		
		public int getRandomNumber(int min,int max) {
			
			Random r = new Random();
			int rno = r.nextInt(max-min) + min;
			return rno;
			
		}
		
		public char randomCharacter(){


			Random r = new Random();
			char ramdomLetter= (char)(r.nextInt(26) + 'A');
			  return ramdomLetter;
			



		}
		

		



	//@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void initializeTestBaseSetup() {
		
	
		String browserType;
		String appURL;
		ReadCredential cred=new ReadCredential(driver);
		List<LogInCredential> s=cred.readExcelData(rootPath+filePath+fileName);
		appURL=s.get(11).getName().trim();
		browserType=s.get(11).getPassword().trim();
	 		try {
			setDriver(browserType, appURL);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}

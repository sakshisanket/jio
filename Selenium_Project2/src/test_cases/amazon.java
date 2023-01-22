package test_cases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import common_methods.drop_down;
import common_methods.exp_wait;
import common_methods.quitting_driver;
import common_methods.scroll_down;
import common_methods.web_driver;

public class amazon {

	public static WebDriver driver;
	
	@BeforeMethod()
	public static void url() {
		//web_driver.drivers("Chrome", "C:\\Users\\Preethi\\OneDrive\\Desktop\\Notes\\Automation\\Web browser\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String url= driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.amazon.in/");
	}
	
	@Test(priority = 1)
	public static void  signin() throws InterruptedException {
		exp_wait.exp_wait(driver, 5, "//span[text()=\"Hello, sign in\"]").click();
	/*	String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid."
				+ "return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fcss%2Fhomepage.html%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid."
				+ "net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs."
				+ "openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");*/
		exp_wait.exp_wait(driver, 5, "//input[@name=\"email\"]").sendKeys("preethiadhimoolam2311@gmail.com");
		exp_wait.exp_wait(driver, 5, "//input[@id=\"continue\"]").click();
		String url2=driver.getCurrentUrl();
		Assert.assertEquals(url2, "https://www.amazon.in/ap/signin");
		exp_wait.exp_wait(driver, 5, "//input[@type=\"password\"]").sendKeys("Preethi@23");
		exp_wait.exp_wait(driver, 5, "//input[@id=\"signInSubmit\"]").click();
		Thread.sleep(5000);
		String url3=driver.getCurrentUrl();
		Assert.assertEquals(url3, "https://www.amazon.in/?ref_=nav_ya_signin");
		
	}
	
	@Test(priority = 2)
	public static void signin_email_negative(){
		exp_wait.exp_wait(driver, 5, "//span[text()=\"Hello, sign in\"]").click();
		String url=driver.getCurrentUrl();
		/*Assert.assertEquals(url, "https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid."
				+ "return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fcss%2Fhomepage.html%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid."
				+ "net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs."
				+ "openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");*/
		exp_wait.exp_wait(driver, 5, "//input[@name=\"email\"]").sendKeys("abcccc");
		exp_wait.exp_wait(driver, 5, "//input[@id=\"continue\"]").click();
		}
	
	@Test(priority = 3)
	public static void sigin_email_positive() {
		exp_wait.exp_wait(driver, 5, "//span[text()=\"Hello, sign in\"]").click();
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid."
				+ "return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fcss%2Fhomepage.html%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid."
				+ "net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs."
				+ "openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		exp_wait.exp_wait(driver, 5, "//input[@name=\"email\"]").sendKeys("preethiadhimoolam2311@gmail.com");
		exp_wait.exp_wait(driver, 5, "//input[@id=\"continue\"]").click();
		boolean alert =driver.findElement(By.xpath("//h4[text()=\"There was a problem\"]")).isDisplayed();
		Assert.assertTrue(alert);
		}
	
	@Test(priority = 4)
	public static void sigin_password_positive(){
		amazon.sigin_email_positive();
		exp_wait.exp_wait(driver, 5, "//input[@type=\"password\"]").sendKeys("Preethi@23");
		exp_wait.exp_wait(driver, 5, "//input[@id=\"signInSubmit\"]").click();
		String url3=driver.getCurrentUrl();
		Assert.assertEquals(url3, "https://www.amazon.in/?ref_=nav_ya_signin");
	}
	
	@Test(priority = 5)
	public static void sigin_password_negative() {
		amazon.sigin_email_positive();
		exp_wait.exp_wait(driver, 5, "//input[@type=\"password\"]").sendKeys("abc");
		exp_wait.exp_wait(driver, 5, "//input[@id=\"signInSubmit\"]").click();
		Boolean alert= driver.findElement(By.xpath("//h4[text()=\"There was a problem\"]")).isDisplayed();
		Assert.assertTrue(alert);
		String url3=driver.getCurrentUrl();
		Assert.assertNotEquals(url3, "https://www.amazon.in/?ref_=nav_ya_signin");
	}
	
	@Test(priority = 6)
	public static void search() throws InterruptedException {
		amazon.signin();
		exp_wait.exp_wait(driver, 7, "//input[@id=\"twotabsearchtextbox\"]").sendKeys("mobile back case");
		drop_down.drop_down(driver, exp_wait.exp_list(driver, 7, "//div[@class=\"autocomplete-results-container\"]/div/div/div"), 
				exp_wait.exp_list(driver, 7, "//div[@class=\"autocomplete-results-container\"]/div/div"), "mobile back case for girls");
		String new_url=driver.getCurrentUrl();
		Assert.assertEquals(new_url, "https://www.amazon.in/s?k=mobile+back+case+for+girls&crid=WPS68XAIQ753&sprefix=mobile+back+case%2Caps%2C563&ref=nb_sb_ss_ts-doa-p_8_16");
	}
	
	@Test(priority = 7)
	public static void product_selection() throws InterruptedException {
		amazon.search();
		scroll_down.scroll(driver, exp_wait.exp_wait(driver, 5, "//img[@src=\"https://m.media-amazon.com/images/I/71j13yLxNrL._AC_UY218_.jpg\"]"));
		exp_wait.exp_wait(driver, 7, "//img[@src=\"https://m.media-amazon.com/images/I/71j13yLxNrL._AC_UY218_.jpg\"]").click();
		String url_new=driver.getCurrentUrl();
		Assert.assertEquals(url_new, "https://www.amazon.in/Fashionury-Printed-Silicone-Designer-Mobile/dp/B08KZWCBXR/ref=sr_1_7?crid=WPS68XAIQ753&keywords=mobile+back+case+for+girls&qid=1674355542&sprefix=mobile+back+case%2Caps%2C563&sr=8-7");
	}
	
	@Test(priority = 8)
	public static void add_to_cart() throws InterruptedException {
		amazon.product_selection();
		exp_wait.exp_wait(driver, 7, "//input[@id=\"add-to-cart-button\"]").click();
		Boolean confirmation= exp_wait.exp_wait(driver, 7, "//span[contains(text(),\"Added to Cart\")]").isDisplayed();
		Assert.assertTrue(confirmation);
	}
	
	@Test(priority = 9)
	public static void buy() throws InterruptedException {
		amazon.add_to_cart();
		exp_wait.exp_wait(driver, 7, "//input[@name=\"proceedToRetailCheckout\"]").click();
		String url_buy=driver.getCurrentUrl();
		Assert.assertEquals(url_buy, "https://www.amazon.in/gp/buy/addressselect/handlers/display.html?hasWorkingJavascript=1");
		}
	
	@Test(priority = 10)
	public static void address() throws InterruptedException {
		amazon.buy();
	//	exp_wait.exp_wait(driver, 8, "//a[@id=\"add-new-address-popover-link\"]").click();
		drop_down.drop_down(driver, exp_wait.exp_list(driver, 7, "(//ul[@aria-multiselectable=\"false\"])[3]/li/a"),
				exp_wait.exp_list(driver, 7, "(//ul[@aria-multiselectable=\"false\"])[3]/li/a"), 
				"India");
		exp_wait.exp_wait(driver, 6, "//input[@id=\"address-ui-widgets-enterAddressFullName\"]").sendKeys("Preethi Adhimoolam");
		exp_wait.exp_wait(driver, 8, "//input[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]").sendKeys("8072941951");
		exp_wait.exp_wait(driver, 7, "//input[@placeholder=\"6 digits [0-9] PIN code\"]").sendKeys("636906");
		exp_wait.exp_wait(driver, 7, "//input[@id=\"address-ui-widgets-enterAddressLine1\"]").sendKeys("4/1186");
		exp_wait.exp_wait(driver, 6, "//input[@id=\"address-ui-widgets-enterAddressLine2\"]").sendKeys("Theerthamalai");
		exp_wait.exp_wait(driver, 6, "//input[@id=\"address-ui-widgets-landmark\"]").sendKeys("Opposite to Bharat Petroleum");
		exp_wait.exp_wait(driver, 5, "//input[@id=\"address-ui-widgets-enterAddressCity\"]").sendKeys("HArur, Dharmapuri");
		exp_wait.exp_wait(driver, 5, "(//span[@data-action=\"a-dropdown-button\"])[3]").click();
		drop_down.drop_down(driver, exp_wait.exp_list(driver, 5, "(//ul[@class=\"a-nostyle a-list-link\"])[4]/li/a"), 
				exp_wait.exp_list(driver, 6, "(//ul[@class=\"a-nostyle a-list-link\"])[4]/li"), "Tamil Nadu");
		exp_wait.exp_wait(driver, 8, "(//span[@data-action=\"a-dropdown-button\"])[4]").click();
		drop_down.drop_down(driver, exp_wait.exp_list(driver, 5, "(//ul[@role=\"listbox\"])[5]/li/a"), 
				exp_wait.exp_list(driver, 5, "(//ul[@role=\"listbox\"])[5]/li"), "Home");
		exp_wait.exp_wait(driver, 5, "//input[@fdprocessedid=\"ajcy6a\"]").click();
		String get_url=driver.getCurrentUrl();
		Assert.assertEquals(get_url, "https://www.amazon.in/gp/buy/payselect/handlers/display.html?hasWorkingJavascript=1");
		
	}
	
	@Test(priority = 11)
	public static void payment_method() throws InterruptedException {
		amazon.address();
		/*exp_wait.exp_wait(driver, 5, "(//h3[@class=\"a-color-base clickable-heading expand-collapsed-panel-trigger\"])[1]").click();
		String pay_select=driver.getCurrentUrl();
		Assert.assertEquals(pay_select, "https://www.amazon.in/gp/buy/payselect/handlers/display.html?hasWorkingJavascript=1");*/
		exp_wait.exp_wait(driver, 5, "//input[@id=\"pp-1EPPqU-126\"]").click();
		exp_wait.exp_wait(driver, 7, "//input[@data-pmts-component-id=\"pp-1EPPqU-5\"]").click();
	}
	
	@AfterMethod
	public static void quit() {
		quitting_driver.quit(driver);
	}
}


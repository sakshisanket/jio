package common_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class web_driver {

	public static void drivers(String web_driver, String driver_path) {
		if(web_driver.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", driver_path);
			WebDriver driver=new ChromeDriver();
		}
		else if (web_driver.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", driver_path);
				WebDriver driver=new ChromeDriver();
		}
			else if (web_driver.equalsIgnoreCase("Edge")) {
					System.setProperty("webdriver.edge.driver", driver_path);
					WebDriver driver=new ChromeDriver();
			}
			else {
				System.out.println("The driver cannot be found");
			}
	}
}

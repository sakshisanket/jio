package common_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class frames {

	public static void child_frames(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
		
	}
	public static void parent_frames(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
}

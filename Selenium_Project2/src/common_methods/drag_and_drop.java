package common_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class drag_and_drop {

	public static void drag_drop(WebDriver driver, WebElement source, WebElement destination) {
		Actions act=new Actions(driver);
		act.dragAndDrop(source, destination).build().perform();
	}
}

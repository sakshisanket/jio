package common_methods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class mouse_keyboard_actions {

	public static void mouse_actions_click(WebDriver driver, WebElement element ) {
		Actions act=new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}
	public static void mouse_actions_send_keys(WebDriver driver, WebElement element, String input) {
		Actions act=new Actions(driver);
		act.moveToElement(element).sendKeys(input).build().perform();
	}
	public static void mouse_actions_double_click(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).doubleClick().build().perform();
	}
	public static void mouse_actions_right_click(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).contextClick().build().perform();
	}
	public static void keyboard_action_enter(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).click().keyDown(Keys.ENTER).build().perform();		
	}
	public static void keyboard_action_upper_case(WebDriver driver, WebElement element, String input) {
		Actions act=new Actions(driver);
		act.moveToElement(element).click().keyDown(Keys.SHIFT).sendKeys(input).build().perform();
	}
}

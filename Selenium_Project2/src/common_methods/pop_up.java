package common_methods;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pop_up {

	public static void pop_up(WebElement pop_up_element, WebElement closing_element) {
		try {
			WebElement s=pop_up_element ;
			closing_element.click();
			}
		catch (NoSuchElementException e) {
			System.out.println("The pop-up not avaialable");
		}
		
	}
}

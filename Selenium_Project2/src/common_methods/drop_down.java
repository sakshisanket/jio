package common_methods;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class drop_down {

	public static void drop_down(WebDriver driver, List<WebElement> element_1, List<WebElement> element_2, String option) {
		List<WebElement> text_element=element_1;
		List<WebElement> click_element=element_2;
		
		int count=text_element.size();
		
		for(int i=0; i<count; i++) {
			String text_values=text_element.get(i).getText();
			
			if(text_values.equalsIgnoreCase(option)) {
				click_element.get(i).click();
				break;
			}
		}
	}
}

package common_methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class static_drop_down {

	public static void drop_down(WebElement element, String string_value) {
		WebElement e=element;
		Select s=new Select(e);
		s.selectByVisibleText(string_value);
	}
}

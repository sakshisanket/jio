package common_methods;

import java.util.List;
import org.openqa.selenium.WebElement;

public class calendar {

	public static void month(WebElement element, WebElement month, String month_value) {
		element.click();
		while(true) {
			String cal_month=month.getText();
			if(cal_month.equalsIgnoreCase(month_value)) {
				break;
			}
			else {
				System.out.println("The desired value not found, hence retrying");
			}
		}
	}
	public static void date(List<WebElement> date, String date_value) {
		int a=date.size();
		for(int i=0; i<a; i++) {
			String cal_date=date.get(i).getText();
			if(cal_date.contains(date_value)) {
				date.get(i).click();
				break;
			}
			else {
				System.out.println("The desired value not found, hence retrying");
			}
		}
	}
	
}

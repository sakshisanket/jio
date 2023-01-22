package common_methods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exp_wait {

	public static WebElement exp_wait(WebDriver driver, int time, String xpath) {
		WebDriverWait exp_wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		WebElement a=exp_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
		return a;
	}
	
	public static List<WebElement> exp_list(WebDriver driver, int time, String xpath){
		WebDriverWait exp_wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		List<WebElement> element=exp_wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(xpath))));
		return element;
	}
}

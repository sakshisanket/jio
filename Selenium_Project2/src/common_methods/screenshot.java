package common_methods;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class screenshot {

	public static void screenshot(WebDriver driver, String file_path) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File file_name=new File(file_path);
		
		if(file_name.exists()) {
			System.out.println("The screenshot already available");
			file_name.delete();
			Files.copy(src, file_name);
			System.out.println("The file with the name as "+file_name.getName()+"is copied into the directory");
		}
		else {
			System.out.println("The screenshot doesnot available");
			Files.copy(src, file_name);
			System.out.println("The file with the name as"+file_name.getName()+"is copied");
		}

	}
}

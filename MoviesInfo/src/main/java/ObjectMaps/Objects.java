
package ObjectMaps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Objects {

	public static WebDriver driver;
	@FindBy(xpath="(//li/a[contains(text(),'Top Rated Movies')])[2]")
	public WebElement TopRatedMovies;
	
	@FindBy(xpath="//tbody[@class='lister-list']/tr/td[2]/a")
	public List <WebElement> li;
	
	@FindBy(xpath="//tbody[@class='lister-list']/tr/td[2]/span")
	public List <WebElement> li1;
	
	@FindBy(xpath="//tbody[@class='lister-list']/tr/td[3]/strong")
	public List <WebElement> li2;
	
	public Objects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
}

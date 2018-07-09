package mainpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mainPage {
	public mainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(linkText = "Order" )
	public WebElement orderButton;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct" )
	public WebElement SelectProduct;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity" )
	public WebElement quantity;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice" )
	public WebElement perUnitPrice;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount" )
	public WebElement discount;
	
	@FindBy(className = "btn_dark" )
	public WebElement calculateButton;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtName" )
	public WebElement customerName;

	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2" )
	public WebElement streetName;

	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3" )
	public WebElement cityName;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4" )
	public WebElement stateName;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5" )
	public WebElement zipCode;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0" )
	public WebElement visaCard;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6" )
	public WebElement CardNo;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1" )
	public WebElement expireDate;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton" )
	public WebElement processButton;
	
	@FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]")
	public WebElement newName;
	
	
	
	
	
	

}

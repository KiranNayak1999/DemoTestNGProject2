package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.HandleDropDown;
import utility.ReadData;

public class InventoryPage extends TestBase
{
	@FindBy(xpath="//span[@class='title']") private WebElement productLable;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement productSortDropDown;
	@FindBy(xpath="//li[@class='social_twitter']//a") private WebElement twitterLogo;
	@FindBy(xpath="//li[@class='social_facebook']//a") private WebElement fbLogo;
	@FindBy(xpath="//li[@class='social_linkedin']//a") private WebElement linkedinLogo;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpackProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltBlackTShirt;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement jacketProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement boltedTShirtProduct;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement redTShirtProduct;
	//@FindBy(xpath="//div[@id='shopping_cart_container']") private WebElement cartCount;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	
	//xpath for remove of all elements
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removebackpackProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement removebikeLightProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeboltBlackTShirt;
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removejacketProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement removeboltedTShirtProduct;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeredTShirtProduct;
	
	
	public InventoryPage()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyProductLable()
	{
		return productLable.getText();
	}

	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	
	public boolean verifyFbLogo()
	{
		return fbLogo.isDisplayed();
	}
	
	public boolean verifyLinkedinLogo()
	{
		return linkedinLogo.isDisplayed();
	}
	
	public String add6Product() throws EncryptedDocumentException, IOException
	{
		//Select s=new Select(productSortDropDown);
		//s.selectByVisibleText("Price (low to high)");
		//HandleDropDown.handleSelectClass(productSortDropDown, "Price (low to high)");
		HandleDropDown.handleSelectClass(productSortDropDown,ReadData.readExcel(0, 0));
		backpackProduct.click();
		bikeLightProduct.click();
		boltBlackTShirt.click();
		jacketProduct.click();
		boltedTShirtProduct.click();
		redTShirtProduct.click();
		return cartCount.getText();
	}
	
	public String remove2Product() throws InterruptedException, EncryptedDocumentException, IOException
	{
		add6Product();
		Thread.sleep(2000);
		removebackpackProduct.click();
		removebikeLightProduct.click();
		return cartCount.getText();
	}
	
	public void ClickcartCount()
	{
		cartCount.click();
	}

}

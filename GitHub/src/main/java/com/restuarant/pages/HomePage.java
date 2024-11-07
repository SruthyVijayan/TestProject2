package com.restuarant.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.restuarant.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//img[@class='img-circle topbar-userpic hidden-xs']")
	WebElement admin;
	
	@FindBy(xpath = "//a[@aria-expanded='true']")
	WebElement lang;

	@FindBy(xpath = "//a[@href='https://qalegend.com/restaurant/dashboard/change/english'][1]")
	WebElement English;

	@FindBy(xpath = "//a[@href='https://qalegend.com/restaurant/dashboard/change/greek']")
	WebElement Greek;
	
	@FindBy(xpath="//span[text()='Product'][1]")
	WebElement products;

	
	@FindBy(xpath="//span[contains(text(),'Categories ')]")
	WebElement Categories;
	
	public String categories()
	{
		return Categories.getText();
	}
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean admin() {
		return admin.isDisplayed();
	}
	public String getText()
	{
		return English.getText();
	}

	public void drpdwn() {
		lang.click();

	}

	public void english() {
		English.click();

	}
	public WebElement lang()
	{
		return lang;
	}

	public void Greek() {
		Greek.click();

	}
	
	public ProductsPage product()
	{
		products.click();
		return new ProductsPage(driver);
	}
}

package com.restuarant.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.restuarant.base.BaseClass;
import com.restuarant.utilities.GeneralUtility;

public class ProductsPage extends BaseClass {
	GeneralUtility gu = new GeneralUtility();

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//Select[@name='Table_length']")
	WebElement show;

	@FindAll(@FindBy(xpath = "//tr[@role='row']"))
	List<WebElement> numberofrows;

	@FindBy(id = "Supplier")
	public WebElement supplier;

	@FindBy(xpath = "//button[text() ='Apply Filter']")
	WebElement applyFilter;

	@FindBy(xpath = "//div[contains(text(),'Showing ')]")
	WebElement showingResults;
	@FindBy(xpath = "//tbody//tr[1]//td[7]//div[1]//a[2]//i[1]")
	WebElement viewProduct;

	@FindBy(xpath = "//div[@id=\"viewSectionProduct\"]//div[1]//div[2]/h1[@class='media-heading']")
	WebElement titleFromViewProduct;
	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Close')][@data-dismiss='modal'][@xpath='1']")
	WebElement CloseViewProduct;

	@FindBy(xpath = "//td[contains(text(),'Brinjal')]")
	WebElement textOfRetriedProduct;

	@FindBy(xpath = "//a[@href='products/delete/322']")
	WebElement delete;
 
	@FindBy(xpath="//i[@class='fa fa-pencil']")
	WebElement edit;
	@FindBy(xpath="//input[@id='ProductCode']")
	WebElement code;
	
	@FindBy(xpath="//button[@class='btn btn-green col-md-6 flat-box-btn waves-effect waves-button']")
	WebElement submit;
	
	public void editMethod() throws InterruptedException {
		edit.click();	
		code.sendKeys("1235");
		gu.scrollBy(0, 250);
		submit.click();
		}
	
	public WebElement elementProductSearched() {
		return textOfRetriedProduct;
	}

	public void deleteMethod() {
		delete.click();
	}

	public WebElement showDropdown() {
		return show;

	}

	public int totalRows() {
		List<WebElement> r = numberofrows;
		int i = 0;
		for (WebElement a : numberofrows) {
			i++;
		}
		return i;
	}

	public StoresPage str() {
		WebElement sh = showDropdown();
		gu.SelectByvalueMethod(sh, "25");
		return new StoresPage();
	}

	public void Supplier(String name) {
		WebElement splier = supplier;
		gu.SelectByVisibleTextmethod(splier, name);
	}

	public void ApplyFilter() {
		applyFilter.click();
	}

	public boolean Results() {
		return showingResults.isDisplayed();
	}

	public void ProductView() {
		viewProduct.click();
	}

	public String getTextOfProduct() {
		String s= titleFromViewProduct.getText();
		return s;
	}

	/*
	 * public void CloseProductView() { CloseViewProduct.click(); }
	 */
	public String getTextOfProductToBeSearched() {
		return textOfRetriedProduct.getText();
	}

	public StoresPage CloseProductView() {
		CloseViewProduct.click();
		return new StoresPage();
	}

}

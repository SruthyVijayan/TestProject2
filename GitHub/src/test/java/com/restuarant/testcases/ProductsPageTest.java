package com.restuarant.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.restuarant.base.BaseClass;
import com.restuarant.pages.ProductsPage;
import com.restuarant.pages.StoresPage;
import com.restuarant.utilities.GeneralUtility;
import com.restuarant.utilities.WaitUtility;

public class ProductsPageTest {

	ProductsPage pg;
	public static WebDriver driver;
	StoresPage sp;
	WaitUtility wt = new WaitUtility(driver);

	@Test(priority = 0)
	public void ShowDropDown() throws InterruptedException {
		driver = BaseClass.getDriver();
		pg = new ProductsPage(driver);
		sp = pg.str();
		wt.sleep(4000);
		int i = pg.totalRows();
		Assert.assertEquals(i, 26);
	}

	@Test(priority = 1, enabled = true)
	public void SelectSupplier() {
		driver = BaseClass.getDriver();
		pg = new ProductsPage(driver);
		pg.Supplier("Anujith");
		pg.ApplyFilter();
		wt.sleep(3000);
		Assert.assertTrue(pg.Results());
	}
	@Test(priority = 2, enabled = true)
	public void ViewProduct() {
		wt.sleep(3000);
		pg.ProductView();
		Assert.assertEquals(pg.getTextOfProduct(), pg.getTextOfProductToBeSearched());
		pg.CloseProductView();
	}
	
	
	@Test(priority = 3, enabled = true)
	public void SelectAllSupplier() {
		wt.waitForElementTobeVisible(driver, pg.supplier, Duration.ofSeconds(20));
		pg.Supplier("All");
		pg.ApplyFilter();
		Assert.assertTrue(pg.Results());
	}

}

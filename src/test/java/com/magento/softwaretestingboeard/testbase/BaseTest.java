package com.magento.softwaretestingboeard.testbase;

import com.magento.softwaretestingboeard.propertyreader.PropertyReader;
import com.magento.softwaretestingboeard.utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp(){
        selectBrowser(browser);

    }
    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }
}

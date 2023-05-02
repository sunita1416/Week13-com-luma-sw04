package com.magento.softwaretestingboeard.pages;

import com.magento.softwaretestingboeard.utilities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    By womenTab = By.xpath("//span[contains(text(),'Women')]");
    By topsInWomenDropdown = By.xpath("//li[contains(@class,'nav-2-1 ')]/child::a");
    By jacketsInTops = By.xpath("//li[contains(@class,'nav-2-1 ')]/child::ul/child::li[1]/child::a");
    By mensTab = By.xpath("//span[normalize-space()='Men']");
    By bottomsInMensDropdown = By.xpath("//a[@id='ui-id-18']");
    By pantsInBottoms = By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]");
    By gearTab = By.xpath("//span[normalize-space()='Gear']");
    By bagsInGear = By.xpath("//span[normalize-space()='Bags']");

    public void mouseHoverOnWomenTab(){
        waitUntilVisibilityOfElementLocated(womenTab, 5);
        mouseHoverToElement(womenTab);
    }
    public void mouseHoverOnTopsInWomenTab(){
        mouseHoverToElement(topsInWomenDropdown);
    }
    public void mouseHoverAndClickOnJacketsInWomen(){
        mouseHoverToElementAndClick(jacketsInTops);
    }
    public void mouseHoverOnMensTab(){
        mouseHoverToElement(mensTab);
    }
    public void mouseHoverOnBottomsInMensTab(){
        mouseHoverToElement(bottomsInMensDropdown);
    }
    public void mouseHoverAndClickOnPantsInBottoms(){
        mouseHoverToElementAndClick(pantsInBottoms);
    }
    public void mouseHoverOnGearTab(){
        mouseHoverToElement(gearTab);
    }
    public void mouseHoverAndClickOnBagsInGear(){
        mouseHoverToElementAndClick(bagsInGear);
    }





}

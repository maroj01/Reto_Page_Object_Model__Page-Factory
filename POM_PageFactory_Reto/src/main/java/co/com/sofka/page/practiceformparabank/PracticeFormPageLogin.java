package co.com.sofka.page.practiceformparabank;

import co.com.sofka.page.common.CommonActionOnPagesParabank;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPageLogin extends CommonActionOnPagesParabank {


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Accounts Overview')]")
    private WebElement lblAccountsOverview;


    public PracticeFormPageLogin(WebDriver driver) {
        super(driver);
        pageFactoryInitElement(driver, this);
    }

    //Funcionalidades del Page.
    public String getMassage() {
        String mesagecount;
        mesagecount = getText(lblAccountsOverview).trim();
        return mesagecount;
    }


}

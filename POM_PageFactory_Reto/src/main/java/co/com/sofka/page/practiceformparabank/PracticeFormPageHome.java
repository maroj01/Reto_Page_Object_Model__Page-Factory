package co.com.sofka.page.practiceformparabank;

import co.com.sofka.model.bank.UserModel;
import co.com.sofka.page.common.CommonActionOnPagesParabank;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPageHome extends CommonActionOnPagesParabank {
    private UserModel userModel;


    @CacheLookup
    @FindBy(name = "username")
    private WebElement txtName;

    @CacheLookup
    @FindBy(name = "password")
    private WebElement txtPassword;

    @CacheLookup
    @FindBy(xpath = "//input[@class='button']")
    private WebElement btnLogin;

    @CacheLookup
    @FindBy(xpath = "//p[@class='error']")
    private WebElement lblError;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    private WebElement lblRegister;

    @CacheLookup
    @FindBy(linkText = "Contact Us")
    private WebElement lblContactUs;


    public PracticeFormPageHome(WebDriver driver, UserModel userModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.userModel = userModel;
    }

    public PracticeFormPageHome(WebDriver driver) {
        super(driver);
        pageFactoryInitElement(driver, this);
    }

    //Funcionalidades del Page.
    public void fillLogin() {
        scrollOn(txtName);
        clearOn(txtName);
        clickOn(txtName);
        typeOn(txtName, userModel.getUsername());
        scrollOn(txtPassword);
        clearOn(txtPassword);
        typeOn(txtPassword, userModel.getPassword());
    }

    public void doLogin() {
        doSubmit(btnLogin);
    }

    public void goRegister() {
        clickOn(lblRegister);
    }

    public void goContactUs() {
        clickOn(lblContactUs);
    }

    public String LoginError() {
        String mesageError;
        mesageError = getText(lblError).trim();
        return mesageError;
    }

}

package co.com.sofka.page.practiceformparabank;

import co.com.sofka.model.bank.UserModel;
import co.com.sofka.page.common.CommonActionOnPagesParabank;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPageContactUs extends CommonActionOnPagesParabank {
    private UserModel userModel;


    @CacheLookup
    @FindBy(id = "name")
    private WebElement txtName;

    @CacheLookup
    @FindBy(id = "email")
    private WebElement txtEmailContact;

    @CacheLookup
    @FindBy(id = "phone")
    private WebElement txtPhoneContact;

    @CacheLookup
    @FindBy(id = "message")
    private WebElement txtMessageContact;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Send to Customer Care']")
    private WebElement btnSendCustomerCare;

    @CacheLookup
    @FindBy(xpath = "//p[contains(text(),'A Customer Care Representative will be contacting ')]")
    private WebElement lblCustomerCare;

    @CacheLookup
    @FindBy(xpath = "//p[contains(text(),'Email support is available by filling out the foll')]")
    private WebElement lblCustomerError;


    public PracticeFormPageContactUs(WebDriver driver, UserModel userModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.userModel = userModel;
    }

    public PracticeFormPageContactUs(WebDriver driver) {
        super(driver);
        pageFactoryInitElement(driver, this);
    }

    //Funcionalidades del Page.
    public void fillContactUs() {

        scrollOn(txtName);
        clearOn(txtName);
        typeOn(txtName, userModel.getFirstName() + " " + userModel.getLastName());

        scrollOn(txtEmailContact);
        clearOn(txtEmailContact);
        typeOn(txtEmailContact, userModel.getEmail());

        scrollOn(txtPhoneContact);
        clearOn(txtPhoneContact);
        typeOn(txtPhoneContact, userModel.getPhone());

        scrollOn(txtMessageContact);
        clearOn(txtMessageContact);
        typeOn(txtMessageContact, userModel.getMassage());

    }

    public void doContact() {
        doSubmit(btnSendCustomerCare);
    }

    public String getMassageContact() {
        String mesageContact = getText(lblCustomerCare).trim();
        return mesageContact;
    }

    public String getMassageError() {
        String mesageError;
        mesageError = getText(lblCustomerError).trim();
        return mesageError;
    }
}

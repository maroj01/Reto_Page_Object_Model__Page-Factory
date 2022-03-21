package co.com.sofka.page.practiceformparabank;

import co.com.sofka.model.bank.UserModel;
import co.com.sofka.page.common.CommonActionOnPagesParabank;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPageRegister extends CommonActionOnPagesParabank {
    private static final Logger LOGGER = Logger.getLogger(PracticeFormPageLogin.class);
    private UserModel userModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    @CacheLookup
    @FindBy(xpath = "//input[@id='customer.firstName']")
    private WebElement txtCustomerFirstName;

    @CacheLookup
    @FindBy(id = "customer.lastName")
    private WebElement txtCustomerLastName;

    @CacheLookup
    @FindBy(id = "customer.address.street")
    private WebElement txtCustomerAddressAtreet;

    @CacheLookup
    @FindBy(id = "customer.address.city")
    private WebElement txtCustomerAddressCity;

    @CacheLookup
    @FindBy(id = "customer.address.state")
    private WebElement txtCustomerAddressState;

    @CacheLookup
    @FindBy(id = "customer.address.zipCode")
    private WebElement txtCustomerAddressZipCode;

    @CacheLookup
    @FindBy(id = "customer.phoneNumber")
    private WebElement txtCustomerPhoneNumber;

    @CacheLookup
    @FindBy(id = "customer.ssn")
    private WebElement txtCustomerSsn;

    @CacheLookup
    @FindBy(id = "customer.username")
    private WebElement txtCustomerUsername;

    @CacheLookup
    @FindBy(id = "customer.password")
    private WebElement txtCustomerPassword;

    @CacheLookup
    @FindBy(id = "repeatedPassword")
    private WebElement txtRepeatedPassword;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Register']")
    private WebElement btnRegister;

    @CacheLookup
    @FindBy(xpath = "//p[contains(text(),'Your account was created successfully. You are now')]")
    private WebElement lblWelcome;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Signing up is easy!')]")
    private WebElement lblSigningUp;


    public PracticeFormPageRegister(WebDriver driver, UserModel userModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.userModel = userModel;
    }

    public void fillRegister() {

        scrollOn(txtCustomerFirstName);
        clearOn(txtCustomerFirstName);
        typeOn(txtCustomerFirstName, userModel.getFirstName());

        scrollOn(txtCustomerLastName);
        clearOn(txtCustomerLastName);
        typeOn(txtCustomerLastName, userModel.getLastName());

        scrollOn(txtCustomerAddressAtreet);
        clearOn(txtCustomerAddressAtreet);
        typeOn(txtCustomerAddressAtreet, userModel.getAddress());

        scrollOn(txtCustomerAddressCity);
        clearOn(txtCustomerAddressCity);
        typeOn(txtCustomerAddressCity, userModel.getCity());

        scrollOn(txtCustomerAddressState);
        clearOn(txtCustomerAddressState);
        typeOn(txtCustomerAddressState, userModel.getState());

        scrollOn(txtCustomerAddressZipCode);
        clearOn(txtCustomerAddressZipCode);
        typeOn(txtCustomerAddressZipCode, userModel.getZipCode());

        scrollOn(txtCustomerPhoneNumber);
        clearOn(txtCustomerPhoneNumber);
        typeOn(txtCustomerPhoneNumber, userModel.getPhone());

        scrollOn(txtCustomerSsn);
        clearOn(txtCustomerSsn);
        typeOn(txtCustomerSsn, userModel.getSsn());

        scrollOn(txtCustomerUsername);
        clearOn(txtCustomerUsername);
        typeOn(txtCustomerUsername, userModel.getUsername());

        scrollOn(txtCustomerPassword);
        clearOn(txtCustomerPassword);
        typeOn(txtCustomerPassword, userModel.getPassword());

        scrollOn(txtRepeatedPassword);
        clearOn(txtRepeatedPassword);
        typeOn(txtRepeatedPassword, userModel.getRepeatedPassword());

    }

    public void doRegister() {
        doSubmit(btnRegister);
    }

    public String Register() {
        String successfulResgistration;
        successfulResgistration = getText(lblWelcome).trim();
        return successfulResgistration;
    }

    public boolean isPresent() {
        return elementDisplayed(lblSigningUp);
    }
}

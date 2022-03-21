package co.com.sofka.stepdefinitions.parabank;

import co.com.sofka.model.bank.UserModel;
import co.com.sofka.page.practiceformparabank.PracticeFormPageHome;
import co.com.sofka.page.practiceformparabank.PracticeFormPageLogin;
import co.com.sofka.stepdefinitions.parabank.setup.WebUi;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LoginStepDefinition extends WebUi {
    private static final Logger LOGGER = Logger.getLogger(LoginStepDefinition.class);

    private UserModel userModel;
    private PracticeFormPageHome practiceFormPageParabank;
    private PracticeFormPageLogin practiceFormPageLogin;
    private final String RESUMEN_CUENTA = "Accounts Overview";
    private final String ERROR_ESPERADO = "Please enter a username and password.";

    @Dado("que se ingreso al home de ParaBank")
    public void ingresarSitioWebParaBank() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            userModel = new UserModel();
            userModel.setUsername("mroja");
            userModel.setPassword("1234");

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
            quiteDriver();
        }

    }


    @Cuando("me autentico con el username y password")
    public void autenticarUsernamePassword() {

        try {

            practiceFormPageParabank = new PracticeFormPageHome(driver, userModel);
            practiceFormPageParabank.fillLogin();
            practiceFormPageParabank.doLogin();

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
            quiteDriver();
        }
    }

    @Entonces("se mostrara el resumen de la cuenta")
    public void mostrarResumenCuenta() {
        practiceFormPageLogin = new PracticeFormPageLogin(driver);
        Assertions.assertEquals(RESUMEN_CUENTA, practiceFormPageLogin.getMassage());
        quiteDriver();
    }

    @Dado("que necesito ingresar a mi cuenta de ParaBank")
    public void ingresarCuentaParaBank() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
            quiteDriver();
        }

    }

    @Cuando("me autentico con username {string} y password {string} faltantes")
    public void autenticarUsernamePasswordErroneos(String userName, String password) {
        try {
            userModel = new UserModel();
            userModel.setUsername(userName);
            userModel.setPassword(password);

            practiceFormPageParabank = new PracticeFormPageHome(driver, userModel);
            practiceFormPageParabank.fillLogin();
            practiceFormPageParabank.doLogin();

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
            quiteDriver();
        }

    }

    @Entonces("se mostrara el mensaje de advertencia")
    public void mostrarMensajeError() {
        practiceFormPageParabank = new PracticeFormPageHome(driver, userModel);
        Assertions.assertEquals(ERROR_ESPERADO, practiceFormPageParabank.LoginError());
        quiteDriver();
    }
}


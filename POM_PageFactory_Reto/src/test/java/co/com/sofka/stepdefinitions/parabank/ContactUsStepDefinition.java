package co.com.sofka.stepdefinitions.parabank;

import co.com.sofka.page.practiceformparabank.PracticeFormPageContactUs;
import co.com.sofka.page.practiceformparabank.PracticeFormPageHome;
import co.com.sofka.stepdefinitions.parabank.setup.WebUi;
import co.com.sofka.model.bank.UserModel;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ContactUsStepDefinition extends WebUi {
    private static final Logger LOGGER = Logger.getLogger(ContactUsStepDefinition.class);

    private UserModel userModel;
    private PracticeFormPageHome practiceFormPageHome;
    private PracticeFormPageContactUs practiceFormPageContactUs;
    private final String CUSTOMER = "A Customer Care Representative will be contacting you.";
    private final String CUSTOMER_ERROR = "Email support is available by filling out the following form.";

    @Dado("que deseo obtener informacion de los productos")
    public void ingresarSitioWebParaBank() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            userModel = new UserModel();
            userModel.setFirstName("Adri");
            userModel.setLastName("Rodas");
            userModel.setEmail("mroja@gmail.com");
            userModel.setPhone("302242890");
            userModel.setMassage("Solicito información sobre mi cuenta  de ahorros, ya que registra bloqueada");

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
            quiteDriver();
        }
    }

    @Cuando("me contacto ingresando toda la informacion solicitada")
    public void meContactoIngresandoTodaLaInformacionSolicitada() {
        try {

            practiceFormPageContactUs = new PracticeFormPageContactUs(driver, userModel);
            practiceFormPageHome = new PracticeFormPageHome(driver);
            practiceFormPageHome.goContactUs();
            practiceFormPageContactUs.fillContactUs();
            practiceFormPageContactUs.doContact();

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
            quiteDriver();
        }
    }

    @Entonces("se mostrara mensaje de confirmacion")
    public void mostraraMensajeConfirmacion() {

        practiceFormPageContactUs = new PracticeFormPageContactUs(driver);
        Assertions.assertEquals(CUSTOMER, practiceFormPageContactUs.getMassageContact());
        quiteDriver();
    }

    @Dado("que requiero solicitar atencion de una asesor")
    public void ingresarSitioParaBank() {

        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            userModel = new UserModel();
            userModel.setFirstName("Adri");
            userModel.setLastName("Rodas");
            userModel.setEmail("mroja@gmail.com");
            userModel.setPhone("1245");
            userModel.setMassage("");

        }  catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
            quiteDriver();
        }
    }


    @Cuando("me contacto sin ingresar toda la informacion solicitada")
    public void meContactoSinIngresarTodaLaInformacionSolicitada() {
        try {

            practiceFormPageContactUs = new PracticeFormPageContactUs(driver, userModel);
            practiceFormPageHome = new PracticeFormPageHome(driver);
            practiceFormPageHome.goContactUs();
            practiceFormPageContactUs.fillContactUs();
            practiceFormPageContactUs.doContact();

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
            quiteDriver();
        }
    }

    @Entonces("se mostrara el mensaje de error")
    public void mostrarMensajeError() {

        practiceFormPageContactUs = new PracticeFormPageContactUs(driver);
        Assertions.assertEquals(CUSTOMER_ERROR, practiceFormPageContactUs.getMassageError());
        quiteDriver();
    }
}

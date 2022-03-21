package co.com.sofka.stepdefinitions.parabank;


import co.com.sofka.page.practiceformparabank.PracticeFormPageHome;
import co.com.sofka.page.practiceformparabank.PracticeFormPageRegister;
import co.com.sofka.model.bank.UserModel;

import co.com.sofka.stepdefinitions.parabank.setup.WebUi;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class RegisterStepDefinition extends WebUi {
    private static final Logger LOGGER = Logger.getLogger(RegisterStepDefinition.class);


    private PracticeFormPageHome practiceFormPageHome;
    private UserModel userModel;
    private PracticeFormPageRegister practiceFormPageRegister;

    private final String REGISTRO_EXITOSO = "Your account was created successfully. You are now logged in.";

    @Dado("que se ingreso al formulario de usuario nuevo")
    public void queSeIngresoAlRegistroDeUsuarios() {

        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            userModel = new UserModel();
            userModel.setFirstName("Adriana");
            userModel.setLastName("Rojas");
            userModel.setAddress("cll 55#53-102");
            userModel.setCity("Medellín");
            userModel.setState("Antioquia");
            userModel.setZipCode("5212");
            userModel.setPhone("3022242810");
            userModel.setSsn("Sofka");
            userModel.setUsername("sisazi484848");
            userModel.setPassword("1234");
            userModel.setRepeatedPassword("1234");


        }  catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
            quiteDriver();
        }

    }

    @Cuando("me registro con los datos solicitados")
    public void meRegistroConLosDatosSolicitados() {

        try {

            practiceFormPageRegister = new PracticeFormPageRegister(driver, userModel);
            practiceFormPageHome = new PracticeFormPageHome(driver);
            practiceFormPageHome.goRegister();
            practiceFormPageRegister.fillRegister();

            practiceFormPageRegister.doRegister();

        }  catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
            quiteDriver();
        }

    }

    @Entonces("se creara el registro exitoso")
    public void seCrearaElRegistroExitoso() {

        Assertions.assertEquals(REGISTRO_EXITOSO, practiceFormPageRegister.Register());
        quiteDriver();

    }

    @Dado("que deseo obtener una cuenta en el sitio web de ParaBank")
    public void queDeseoRegistarme() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            userModel = new UserModel();
            userModel.setFirstName("Adriana");
            userModel.setLastName("");
            userModel.setAddress("cll 55#53-102");
            userModel.setCity("Medellín");
            userModel.setState("Antioquia");
            userModel.setZipCode("5212");
            userModel.setPhone("");
            userModel.setSsn("Sofka");
            userModel.setUsername("");
            userModel.setPassword("1234");
            userModel.setRepeatedPassword("1234");


        }  catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
            quiteDriver();
        }
    }

    @Cuando("me registro con algunos datos solicitados")
    public void meRegistroConAlgunosDatosSolicitados() {
        try {

            practiceFormPageRegister = new PracticeFormPageRegister(driver, userModel);
            practiceFormPageHome = new PracticeFormPageHome(driver);
            practiceFormPageHome.goRegister();
            practiceFormPageRegister.fillRegister();

            practiceFormPageRegister.doRegister();

        }  catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            Assertions.fail(e.getMessage());
            quiteDriver();
        }

    }

    @Entonces("se mostrara el mensaje del error")
    public void seMostraraElMensajeDeAdvertencia() {
        Assertions.assertTrue(practiceFormPageRegister.isPresent());
        quiteDriver();
    }
}

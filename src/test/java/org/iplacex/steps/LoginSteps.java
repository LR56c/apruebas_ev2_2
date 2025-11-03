package org.iplacex.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.iplacex.Login;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {
    private Login loginService = new Login();
    private String username;
    private String password;
    private String resultMessage;

    @Given("un usuario registrado con usuario {string} y contrasena {string}")
    public void un_usuario_registrado_con_usuario_y_contrasena(String user, String pass) {
        this.username = user;
        this.password = pass;
    }

    @When("el usuario ingresa sus credenciales")
    public void el_usuario_ingresa_sus_credenciales() {
        this.resultMessage = loginService.execute(this.username, this.password);
    }

    @Then("debe ver el mensaje de bienvenida {string}")
    public void debe_ver_el_mensaje_de_bienvenida(String expectedMessage) {
        assertEquals(expectedMessage, this.resultMessage);
    }

    @Given("un usuario no autenticado")
    public void un_usuario_no_autenticado() {
        // No se requiere estado inicial
    }

    @When("el usuario intenta iniciar sesion con {string} y {string}")
    public void el_usuario_intenta_iniciar_sesion_con_y(String user, String pass) {
        this.resultMessage = loginService.execute(user, pass);
    }

    @Then("debe ver el mensaje de error {string}")
    public void debe_ver_el_mensaje_de_error(String expectedError) {
        assertEquals(expectedError, this.resultMessage);
    }
}

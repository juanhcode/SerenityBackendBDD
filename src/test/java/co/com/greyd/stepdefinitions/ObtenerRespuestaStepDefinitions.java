package co.com.greyd.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ObtenerRespuestaStepDefinitions {

    public final static String ACTOR = "actor";

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^yo cuando envio una peticion al servicio$")
    public void yoCuandoEnvioUnaPeticionAlServicio() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Recibo la respuesta del servicio$")
    public void reciboLaRespuestaDelServicio() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^podre validar que el estado es correcto$")
    public void podreValidarQueElEstadoEsCorrecto() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}

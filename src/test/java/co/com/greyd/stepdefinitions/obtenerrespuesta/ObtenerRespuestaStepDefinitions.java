package co.com.greyd.stepdefinitions.obtenerrespuesta;


import co.com.greyd.models.Servicio;
import co.com.greyd.questions.TheStatusCode;
import co.com.greyd.tasks.EnviarPeticion;
import co.com.greyd.tasks.RecibirRespuesta;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ObtenerRespuestaStepDefinitions {

    public final static String ACTOR = "actor";
    public final static Servicio service = new Servicio(0,"","");

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^yo cuando envio una peticion al servicio$")
    public void yoCuandoEnvioUnaPeticionAlServicio() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(EnviarPeticion.alApi());
    }

    @When("^Recibo la respuesta del servicio$")
    public void reciboLaRespuestaDelServicio() {
        theActorInTheSpotlight().attemptsTo(RecibirRespuesta.de(service));
    }

    @Then("^podre validar que el estado es correcto$")
    public void podreValidarQueElEstadoEsCorrecto() {
        OnStage.theActorInTheSpotlight().should(seeThat(TheStatusCode.esCorrectoCon(service)));
    }
}

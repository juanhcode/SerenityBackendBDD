package co.com.greyd.stepdefinitions.realizarregistro;

import co.com.greyd.models.Peticion;
import co.com.greyd.models.Servicio;
import co.com.greyd.questions.ElMensajeError;
import co.com.greyd.questions.ElToken;
import co.com.greyd.tasks.EnviarPeticionPOST;
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

import java.util.List;

public class RealizarRegistroStepDefinitions {

    public final static String ACTOR = "actor";
    public final static Servicio service = new Servicio(0,"","");

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^Envio la peticion POST$")
    public void envioLaPeticionPOST(List<String> lista) {
        Peticion peticion = new Peticion(lista.get(0),lista.get(1));
        theActorCalled(ACTOR).wasAbleTo(EnviarPeticionPOST.conInfo(peticion));

    }

    @When("^Recibo la respuesta del servicio$")
    public void reciboLaRespuestaDelServicio() {
        theActorInTheSpotlight().attemptsTo(RecibirRespuesta.de(service));
    }

    @Then("^podre recibir el token$")
    public void podreRecibirElToken() {
        String token = service.getBody().substring(29,46);
        // System.out.println(token);
        theActorInTheSpotlight().should(seeThat(ElToken.esElMismo(token)));
    }

    @Then("^podre ver el mensaje de error$")
    public void podreVerElMensajeDeError() {
        String msjError = service.getBody().substring(16,32);
        System.out.println(msjError);
        theActorInTheSpotlight().should(seeThat(ElMensajeError.esVisible(msjError)));
    }
}

package co.com.greyd.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/realizar_registro.feature",
        glue = "co.com.greyd.stepdefinitions.realizarregistro",
        snippets = SnippetType.CAMELCASE
)
public class RealizarRegistro {
}

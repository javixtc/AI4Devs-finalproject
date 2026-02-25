package com.hexagonal.identity.bdd.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Step definitions for US1 – Acceso a Meditation Builder mediante cuenta de Google.
 *
 * <p><strong>Phase 1 (BDD-First):</strong> All steps throw {@link PendingException}
 * intentionally. They will be implemented in Phase 6 (Controllers) once the full
 * hexagonal stack (Domain → Application → Infrastructure → Controllers) is in place.</p>
 *
 * <p>Architecture constraint: no business logic here, no Spring injection until Phase 6.</p>
 */
public class GoogleOAuthSteps {

    // ─────────────────────────────────────────────────────────────────────────
    // GIVEN — context setup
    // ─────────────────────────────────────────────────────────────────────────

    @Given("un visitante que nunca ha accedido a la aplicacion")
    public void unVisitanteNuevo() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @Given("un usuario que ya inicio sesion anteriormente")
    public void unUsuarioRecurrente() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @Given("un visitante que no ha iniciado sesion")
    public void unVisitanteSinSesion() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @Given("un usuario con sesion activa")
    public void unUsuarioConSesionActiva() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @Given("un visitante en la pantalla de inicio de sesion")
    public void unVisitanteEnPantallaLogin() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    // ─────────────────────────────────────────────────────────────────────────
    // WHEN / AND — actions
    // ─────────────────────────────────────────────────────────────────────────

    @When("hace clic en Iniciar sesion con Google")
    public void haceClicEnIniciarSesion() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @And("selecciona su cuenta de Gmail y autoriza el acceso")
    public void seleccionaCuentaYAutoriza() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @When("vuelve a hacer clic en Iniciar sesion con Google")
    public void vuelveAHacerClicEnIniciarSesion() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @And("selecciona la misma cuenta de Gmail")
    public void seleccionaMismaCuenta() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @When("intenta acceder a la biblioteca de meditaciones o a la creacion de una nueva meditacion")
    public void intentaAccederSinSesion() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @When("hace clic en Cerrar sesion")
    public void haceClicEnCerrarSesion() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @And("cancela la pantalla de autorizacion de Google sin seleccionar una cuenta")
    public void cancelaPantallaGoogle() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    // ─────────────────────────────────────────────────────────────────────────
    // THEN / AND — assertions
    // ─────────────────────────────────────────────────────────────────────────

    @Then("ve la pantalla principal de la aplicacion con su nombre y foto de perfil")
    public void vePantallaConPerfil() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @And("su biblioteca de meditaciones aparece vacia")
    public void bibliotecaVacia() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @Then("la aplicacion le da la bienvenida y muestra directamente su biblioteca con sus meditaciones anteriores")
    public void bibliotecaConMeditacionesAnteriores() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @Then("la aplicacion le redirige a la pantalla de inicio de sesion")
    public void redirigePantallaLogin() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @And("le muestra el boton Iniciar sesion con Google")
    public void muestraBotonGoogle() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @Then("la aplicacion le desconecta y le redirige a la pantalla de inicio de sesion")
    public void desconectaYRedirige() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @And("al volver a la aplicacion ve la pantalla de acceso sin datos de sesion anteriores")
    public void sinDatosDeSesionAnteriores() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }

    @Then("regresa a la pantalla de inicio de sesion sin ningun mensaje de error bloqueante")
    public void regresaSinErrorBloqueante() {
        throw new PendingException("Pending until Phase 6: Controllers");
    }
}

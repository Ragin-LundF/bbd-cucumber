package com.ragin.bdd.cucumber.glue;

import com.ragin.bdd.cucumber.core.ScenarioStateContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import java.io.IOException;
import org.springframework.http.HttpMethod;

/**
 * This class contains the <code>When</code> execution of REST POST request related steps.
 */
public class WhenRESTExecutionPOSTGlue extends BaseRESTExecutionGlue {
    /**
     * Execute a POST call with previously given URI and body
     */
    @When("executing a POST call with previously given URI and body")
    public void whenExecutingPOSTCall() {
        executeRequest(HttpMethod.POST, false);
    }

    /**
     * Execute an authorized POST call with previously given URI and body
     */
    @When("executing an authorized POST call with previously given URI and body")
    public void whenExecutingPOSTCallAuthorized() {
        executeRequest(HttpMethod.POST, true);
    }

    /**
     * Execute a POST call to an URL with previously given body
     */
    @When("executing a POST call to {string} with previously given body")
    public void whenExecutingPOSTCallToWithGivenBody(String path) {
        ScenarioStateContext.current().setUriPath(path);

        executeRequest(HttpMethod.POST, false);
    }

    /**
     * Execute an authorized POST call to an URL with previously given body
     */
    @When("executing an authorized POST call to {string} with previously given body")
    public void whenExecutingPOSTCallToWithGivenBodyAuthorized(String path) {
        ScenarioStateContext.current().setUriPath(path);

        executeRequest(HttpMethod.POST, true);
    }

    /**
     * Execute a POST call to the defined URL with body from file
     */
    @When("executing a POST call to {string} with the body from file {string}")
    public void whenExecutingPOSTCallToPathWithBodyFromFile(String path, String pathToFile) throws IOException {
        ScenarioStateContext.current().setUriPath(path);
        String body = readFile(pathToFile);
        ScenarioStateContext.current().setEditableBody(body);

        executeRequest(HttpMethod.POST, false);
    }

    /**
     * Execute an authorized POST call to the defined URL with body from file
     */
    @When("executing an authorized POST call to {string} with the body from file {string}")
    public void whenExecutingPOSTCallToPathWithBodyFromFileAuthorized(String path, String pathToFile) throws IOException {
        ScenarioStateContext.current().setUriPath(path);
        String body = readFile(pathToFile);
        ScenarioStateContext.current().setEditableBody(body);

        executeRequest(HttpMethod.POST, true);
    }

    /**
     * Execute a POST call without authentication to the defined URL with body from file and dynamic URL elements.
     * <p>For better separation use the database initializer and use static values instead of transporting them between scenarios!</p>
     * <br>
     * <p>
     *     DataTable looks like:
     *     <pre>
     *     | URI Elements  | URI Values |
     *     | resourceId    | abc-def-gh |
     *     | subResourceId | zyx-wvu-ts |
     *     </pre>
     * <p>
     * <p>Structure:</p>
     * <ul>
     *     <li>First line is the header.</li>
     *     <li>'URI Elements' is the element name of the dynamic URI path without {}.</li>
     *     <li>'URI Values' will be evaluated first from the scenario context.
     *     If context var was not found use value directly</li>
     * </ul>
     * <p>!!!ATTENTION!!! This is an Anti-Pattern if you reuse previously stored elements, but sometimes it can be necessary if Cucumber should work as Test-Suite.</p>
     */
    @When("executing a POST call with previously given API path, body and these dynamic 'URI Elements' replaced with the 'URI Values'")
    public void whenExecutingPOSTCallToPathWithBodyAndDynamicURLElement(DataTable dataTable) {
        executeRequest(dataTable, HttpMethod.POST, false);
    }

    /**
     * Execute an authorized POST call to the defined URL with body from file and dynamic URL elements.
     * <p>For better separation use the database initializer and use static values instead of transporting them between scenarios!</p>
     * <br>
     * <p>
     *     DataTable looks like:
     *     <pre>
     *     | URI Elements  | URI Values |
     *     | resourceId    | abc-def-gh |
     *     | subResourceId | zyx-wvu-ts |
     *     </pre>
     * <p>
     * <p>Structure:</p>
     * <ul>
     *     <li>First line is the header.</li>
     *     <li>'URI Elements' is the element name of the dynamic URI path without {}.</li>
     *     <li>'URI Values' will be evaluated first from the scenario context.
     *     If context var was not found use value directly</li>
     * </ul>
     * <p>!!!ATTENTION!!! This is an Anti-Pattern if you reuse previously stored elements, but sometimes it can be necessary if Cucumber should work as Test-Suite.</p>
     */
    @When("executing an authorized POST call with previously given API path, body and these dynamic 'URI Elements' replaced with the 'URI Values'")
    public void whenExecutingPOSTCallToPathWithBodyAndDynamicURLElementAuthorized(DataTable dataTable) {
        executeRequest(dataTable, HttpMethod.POST, true);
    }
}
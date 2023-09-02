package simulations;


import common.EndPoints;
import common.GatlingUtils;
import io.gatling.javaapi.core.PopulationBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class UpdateAuthorsById extends Simulation {



    private final ScenarioBuilder scn = scenario("Update Author by ID API")
            .exec(http("Update Author")
                    .put("/4444") // Use the dynamic author ID from the session
                    .body(StringBody("{\"id\":\"4444\",\"firstName\":\"UpdatedFirstName\",\"lastName\":\"UpdatedLastName\"}"))
                    .header("Content-Type", "application/json")
                    .check(status().is(200)));
    public UpdateAuthorsById(){
        HttpProtocolBuilder httpProtocol = http.baseUrl(EndPoints.BaseURL);
//        PopulationBuilder populationBuilder2 = GatlingUtils.setUpSimulation(scnGet, 1, 5, httpProtocol );
        PopulationBuilder populationBuilder = GatlingUtils.setUpSimulation(scn, 1, 5, httpProtocol );
        setUp(populationBuilder);
    }
}



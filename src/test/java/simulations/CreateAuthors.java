package simulations;


import common.EndPoints;
import common.GatlingUtils;
import io.gatling.javaapi.core.PopulationBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class CreateAuthors extends Simulation {

    private static final ScenarioBuilder scn = scenario("Create Authors")
            .exec(http("Create Author")
                    .post("/Authors")
                    .body(StringBody("{\"id\":0,\"idBook\":0,\"firstName\":\"string\",\"lastName\":\"string\"}"))
                    .header("Content-Type", "application/json")
                    .check(status().is(200)));
    public CreateAuthors(){
        HttpProtocolBuilder httpProtocol = http.baseUrl(EndPoints.BaseURL);
        PopulationBuilder populationBuilder = GatlingUtils.setUpSimulation(scn, 50, 5, httpProtocol );
        setUp(populationBuilder);
    }
}



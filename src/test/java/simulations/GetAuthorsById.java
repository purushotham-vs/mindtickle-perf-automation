package simulations;


import common.EndPoints;
import common.GatlingUtils;
import io.gatling.javaapi.core.PopulationBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class GetAuthorsById extends Simulation {

    private static final ScenarioBuilder scn = scenario("Get Authors By Id API")
                    .exec(http(EndPoints.Authors)
                    .get("/10")
                    .check(status().is(200)));

    public GetAuthorsById(){
        HttpProtocolBuilder httpProtocol = http.baseUrl(EndPoints.BaseURL);
        PopulationBuilder populationBuilder = GatlingUtils.setUpSimulation(scn, 50, 5, httpProtocol );
        setUp(populationBuilder);
    }

}



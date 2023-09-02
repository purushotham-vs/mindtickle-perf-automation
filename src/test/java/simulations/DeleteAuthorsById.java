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

public class DeleteAuthorsById extends Simulation {



//    private final ScenarioBuilder scnGet = scenario("GET Author by ID")
//            .exec(session -> {
//                // Generate a random author ID and store it in the session
//                String randomAuthorId = generateRandomAuthorId();
//                session.set("randomAuthorId", randomAuthorId);
//                return session;
//            })
//            .exec(http("Get Author")
//                    .get("/${randomAuthorId}") // Use the dynamic author ID from the session
//                    .check(status().is(200)));
    private static final ScenarioBuilder scn = scenario("Delete Authors By Id API")
                    .exec(http(EndPoints.Authors)
                    .delete("/10")
                    .check(status().is(404)));

    public DeleteAuthorsById(){
        HttpProtocolBuilder httpProtocol = http.baseUrl(EndPoints.BaseURL);
//        PopulationBuilder populationBuilder2 = GatlingUtils.setUpSimulation(scnGet, 1, 1, httpProtocol );
        PopulationBuilder populationBuilder = GatlingUtils.setUpSimulation(scn, 1, 1, httpProtocol );
        setUp(populationBuilder);
    }

}



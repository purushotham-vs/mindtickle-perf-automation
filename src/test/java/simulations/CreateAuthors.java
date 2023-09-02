package simulations;


import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class CreateAuthors extends Simulation {

    private static final ScenarioBuilder scn = scenario("My Test Scenario")
            .exec(http("Create Author")
                    .post("/Authors")
                    .body(StringBody("{\"id\":0,\"idBook\":0,\"firstName\":\"string\",\"lastName\":\"string\"}"))
                    .header("Content-Type", "application/json")
                    .check(status().is(200)));
    public CreateAuthors(){
        String baseUrl = "https://fakerestapi.azurewebsites.net/api/v1";
        HttpProtocolBuilder httpProtocol = http.baseUrl(baseUrl);
        this.setUp(scn.injectOpen(constantUsersPerSec(50).during(2))
                .protocols(httpProtocol));
    }

}



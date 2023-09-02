package simulations;


import common.EndPoints;
import common.GatlingUtils;
import io.gatling.javaapi.core.PopulationBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import scala.concurrent.duration.Duration;

import javax.annotation.Nonnull;

import java.util.concurrent.TimeUnit;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;
import static io.gatling.recorder.internal.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration.seconds;

public class GetAuthors extends Simulation {

    private static final ScenarioBuilder scn = scenario("Get Authors API")
                    .exec(http(EndPoints.Authors)
                    .get("/")
                    .check(status().is(200)));

    public GetAuthors(){
        HttpProtocolBuilder httpProtocol = http.baseUrl(EndPoints.BaseURL);
        PopulationBuilder populationBuilder = GatlingUtils.setUpSimulation(scn, 50, 5, httpProtocol );
        setUp(populationBuilder);
    }

}



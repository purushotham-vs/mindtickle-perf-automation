package common;

import io.gatling.javaapi.core.PopulationBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;

public class GatlingUtils {

    public static PopulationBuilder setUpSimulation(ScenarioBuilder scn, int userCount, int durationInSeconds, HttpProtocolBuilder httpProtocol) {
       return scn.injectOpen(constantUsersPerSec(userCount).during(durationInSeconds)).protocols(httpProtocol);
    }
}

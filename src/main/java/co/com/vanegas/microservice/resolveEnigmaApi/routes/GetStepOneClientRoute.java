package co.com.vanegas.microservice.resolveEnigmaApi.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class GetStepOneClientRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:get-step-one")
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .setBody(simple("{ \r\n  \"data\":[ \r\n { \r\n }}"))
                .log("Request microservice step one ${body}")
                .to("http4://localhost:8090/EnigmaSteps/getStep")
                .log("Response microservice step one ${body}");
    }
}

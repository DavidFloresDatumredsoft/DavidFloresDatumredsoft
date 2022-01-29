package com.datum.confia.cps;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import org.apache.camel.Exchange;

/**
 * A simple Camel REST DSL route that implements the greetings service.
 * 
 */
@Component
public class CamelRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		// @formatter:off
        restConfiguration()
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "CPS REST API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                //.apiProperty("base.path", "camel/")
                //.apiProperty("api.path", "/")
                .apiProperty("host", "")
                .producerComponent("http")
                .apiContextRouteId("doc-api")
            .component("servlet")
            .bindingMode(RestBindingMode.json);
        /*JsonParseException.class,*/
        onException( Exception.class)
        .handled(true)
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
        .setHeader(Exchange.CONTENT_TYPE, constant("text/plain"))
        //.setBody().constant("Invalid json data");
        .setBody().simple("${exception.stacktrace}");


        rest("/hi").get("")
					 .produces("application/json")
					 .route()
					 .setBody(simple("Hello word"))
					 .endRest(); 
        
        // @formatter:on

	}

}
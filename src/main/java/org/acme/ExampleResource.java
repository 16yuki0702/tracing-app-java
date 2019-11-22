package org.acme;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ExampleResource {

    @Inject
    @RestClient
    TracingService tracingService;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/todest1")
    @Produces(MediaType.TEXT_PLAIN)
    public String todest1(@HeaderParam("x-request-id") String requestId,
            @HeaderParam("x-b3-traceid") String traceId,
            @HeaderParam("x-b3-spanid") String spanId,
            @HeaderParam("x-b3-sampled") String sampled,
            @HeaderParam("x-b3-flags") String flags,
            @HeaderParam("user-agent") String userAgent
            ) {
        return tracingService.getResponse(requestId, traceId, spanId, sampled, flags, userAgent);
    }

    @GET
    @Path("/dest1")
    @Produces(MediaType.TEXT_PLAIN)
    public String dest1() {
        return "dest1";
    }
}
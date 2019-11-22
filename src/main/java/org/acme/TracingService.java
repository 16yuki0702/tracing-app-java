package org.acme;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
@RegisterRestClient
public interface TracingService {

    @GET
    @Path("/dest1")
    @Produces("text/plain")
    String getResponse(@HeaderParam("x-request-id") String requestId,
            @HeaderParam("x-b3-traceid") String traceId,
            @HeaderParam("x-b3-spanid") String spanId,
            @HeaderParam("x-b3-sampled") String sampled,
            @HeaderParam("x-b3-flags") String flags,
            @HeaderParam("user-agent") String userAgent
        );
}

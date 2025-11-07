/*
 * Copyright (c) 2025, Focus-5 Consortium Members
 */

package org.datasheild.focus5.invoker;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestHeader;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

@Path("ws")
public class WSResource
{
    @Inject
    public Logger logger;

    @GET
    @Path("system/subject-profile/{profile}")
    public RestResponse<String> getSubjectProfile(@RestPath String profile, @RestHeader("Host") String host, @RestHeader("User-Agent") String userAgent, @RestHeader("Accept-Encoding") String acceptEncoding, @RestHeader("Accept") String accept)
    {
        logger.infof("Call: ws/system/select-profile/%s", profile);
        logger.infof("          host           = %s", host);
        logger.infof("          userAgent      = %s", userAgent);
        logger.infof("          acceptEncoding = %s", acceptEncoding);
        logger.infof("          accept         = %s", accept);

        Client client = ClientBuilder.newBuilder()
//                                     .target("https://focus5:8443/")
//                                     .remoteTarget.path()
//                                     .request().get()
                                     .build();

        WebTarget target = client.target("https://localhost:8443");

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        logger.info("Response");
        logger.infof("              response = %s", response);

        client.close();

        return ResponseBuilder.ok("", MediaType.APPLICATION_JSON)
                              .header("x-opal-version", "5.3.2")
                              .build();
    }

    @GET
    @Path("datasource/{datasource}/table/{table}")
    public RestResponse<String> selectTable(@RestPath String datasource, @RestPath String table)
    {
        logger.infof("Call: ws/datasource/%s/table/%s", datasource, table);

        return ResponseBuilder.ok("", MediaType.APPLICATION_JSON)
                              .build();
    }
}

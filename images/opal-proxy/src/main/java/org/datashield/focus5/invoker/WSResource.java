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
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.Invocation.Builder;

@Path("ws")
public class WSResource
{
    @Inject
    public Logger logger;

    @GET
    @Path("system/subject-profile/{profile}")
    public RestResponse<String> getSubjectProfile(@RestPath String profile, @RestHeader("Host") String host, @RestHeader("User-Agent") String userAgent, @RestHeader("Accept-Encoding") String acceptEncoding, @RestHeader("Accept") String accept)
    {
        try
        {
            logger.infof("Call: ws/system/select-profile/%s", profile);
            logger.infof("          host           = %s", host);
            logger.infof("          userAgent      = %s", userAgent);
            logger.infof("          acceptEncoding = %s", acceptEncoding);
            logger.infof("          accept         = %s", accept);

            logger.info("1)------------------");

            logger.info("Create client");
            Client opalClient = ClientBuilder.newBuilder()
                                             .build();

            logger.info("2)------------------");

            logger.info("Create webtarget");
            WebTarget opalTarget = opalClient.target("https://localhost:8443");

            logger.info("3)------------------");

            Invocation.Builder opalRequest = opalTarget.request(MediaType.APPLICATION_JSON)
                                                       .header("User-Agent", userAgent)
                                                       .header("Accept-Encoding", acceptEncoding)
                                                       .header("Accept", accept);

            String opalResponse = opalRequest.get(String.class);

            logger.info("4)------------------");

            logger.info("OpalResponse");
            logger.infof("              opalResponse = %s", opalResponse);

            opalClient.close();

            logger.info("5)------------------");

            return ResponseBuilder.ok("", MediaType.APPLICATION_JSON)
                                  .header("x-opal-version", "5.3.2")
                                  .build();
        }
        catch (Error error)
        {
            logger.error("==== In getSubjectProfile: ", error);
            throw error;
        }
        catch (Exception exception)
        {
            logger.error("==== In getSubjectProfile: ", exception);
            throw exception;
        }
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

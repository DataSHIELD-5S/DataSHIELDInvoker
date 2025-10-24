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

@Path("ws")
public class WSResource
{
    @Inject
    public Logger logger;

    @GET
    @Path("system/subject-profile/{profile}")
    public RestResponse<String> getSubjectProfile(@RestPath String profile, @RestHeader("Host") String host, @RestHeader("User-Agent") String userAgent, @RestHeader("Accept-Encoding") String acceptEncoding, @RestHeader("Content-Type") String contentType, @RestHeader("Content-Length") String contentLength)
    {
        logger.infof("Call: ws/system/select-profile/%s", profile);
        logger.infof("          host           = %s", host);
        logger.infof("          userAgent      = %s", userAgent);
        logger.infof("          acceptEncoding = %s", acceptEncoding);
        logger.infof("          contentType    = %s", contentType);
        logger.infof("          contentLength  = %s", contentLength);

        return ResponseBuilder.ok("", MediaType.APPLICATION_JSON /* MediaType.TEXT_PLAIN */)
                              .header("x-opal-version", "5.2.1")
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

    @GET
    public String getRoot()
    {
        logger.info("Get Root");

        return "Get Root";
    }

    @GET
    @Path("/{path}")
    public String getPath(String path)
    {
        logger.info("Get Path \"" + path + "\"");

        return "Get Path \"" + path + "\"";
    }

    @GET
    @Path("/{p1}/{p2}")
    public String getCall2(String p1, String p2)
    {
        logger.info("Call-2: 'Get' " + p1 + " " + p2);

        return "Call-2: 'Get' " + p1 + " " + p2;
    }

    @GET
    @Path("/{p1}/{p2}/{p3}")
    public String getCall3(String p1, String p2, String p3)
    {
        logger.info("Call-3: 'Get' " + p1 + " " + p2 + " " + p3);

        return "Call-3: 'Get' " + p1 + " " + p2 + " " + p3;
    }

    @GET
    @Path("/{p1}/{p2}/{p3}/{p4}")
    public String getCall4(String p1, String p2, String p3, String p4)
    {
        logger.info("Call-4: 'Get' " + p1 + " " + p2 + " " + p3 + " " + p4);

        return "Call-4: 'Get' " + p1 + " " + p2 + " " + p3 + " " + p4;
    }

    @GET
    @Path("/{p1}/{p2}/{p3}/{p4}/{p5}")
    public String getCall5(String p1, String p2, String p3, String p4, String p5)
    {
        logger.info("Call-5: 'Get' " + p1 + " " + p2 + " " + p3 + " " + p4 + " " + p5);

        return "Call-5: 'Get' " + p1 + " " + p2 + " " + p3 + " " + p4 + " " + p5;
    }

    @GET
    @Path("/{p1}/{p2}/{p3}/{p4}/{p5}/{p6}")
    public String getCall6(String p1, String p2, String p3, String p4, String p5, String p6)
    {
        logger.info("Call-6: 'Get' " + p1 + " " + p2 + " " + p3 + " " + p4 + " " + p5 + " " + p6);

        return "Call-6: 'Get' " + p1 + " " + p2 + " " + p3 + " " + p4 + " " + p5 + " " + p6;
    }

    @POST
    public String postRoot()
    {
        logger.info("Post Root");

        return "Post Root";
    }

    @POST
    @Path("/{path}")
    public String postPath(String path)
    {
        logger.info("Post Path \"" + path + "\"");

        return "Post Path \"" + path + "\"";
    }
}

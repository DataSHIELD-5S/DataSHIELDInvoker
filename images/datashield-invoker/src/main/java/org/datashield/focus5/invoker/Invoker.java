package org.datasheild.focus5.invoker;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/")
public class Invoker
{
    @Inject
    public Logger logger;

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

    @GET
    @Path("/{p1}/{p2}")
    public String getCall2(String p1, String p2)
    {
        logger.info("Call-2: 'Get' " + p1 + " " + p2);

        return "Call-2: 'Get' " + p1 + " " + p2;
    }

    @GET
    @Path("/invoker/ws/system/subject-profile/_current")
    public String getCurrent()
    {
        logger.info("Call: 'Current'");

        return "Call: 'Current'";
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
}

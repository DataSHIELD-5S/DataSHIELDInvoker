package org.datasheild.focus5.invoker;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/invoker")
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
}

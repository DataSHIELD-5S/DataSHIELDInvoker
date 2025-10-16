/*
 * Copyright (c) 2025, Focus-5 Consortium Members
 */

package org.datasheild.focus5.proxy;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import java.io.IOException;

@WebServlet("/")
public class Proxy extends HttpServlet
{
    @Inject
    public Logger logger;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        logger.info("Proxy doGet:  getRequestURI  = " + request.getRequestURI());
        logger.info("              getPathInfo    = " + request.getPathInfo());
        logger.info("              getContextPath = " + request.getContextPath());

        Client client = ClientBuilder.newClient();
        WebTarget remoteTarget   = client.target("https://focus5:8443/");
        WebTarget remotePath     = remoteTarget.path(request.getRequestURI());
        Response  remoteResponse = remotePath.request().get();

        logger.info("              response = " + remoteResponse);

        client.close();
    };

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        logger.info("Proxy doPost: getRequestURI  = " + request.getRequestURI());
        logger.info("              getPathInfo    = " + request.getPathInfo());
        logger.info("              getContextPath = " + request.getContextPath());
    };
}

package main;

import servlets.*;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        AllRequestsServlet myServlet = new AllRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(myServlet), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();

        System.out.println("Server started");

        server.join();
    }
}

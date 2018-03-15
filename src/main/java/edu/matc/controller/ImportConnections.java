package edu.matc.controller;

import edu.matc.util.PropertiesLoaderInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
        name = "importConnections",
        urlPatterns = {"/importConnections"}
)

public class ImportConnections extends HttpServlet implements PropertiesLoaderInterface {

    Properties properties;

    public void init() throws ServletException {
        properties = loadProperties("/resources/clientKey.properties");
    }

    /**
     *  doGet takes data from the properties object and outputs it to the page
     *
     *@param  request               the HttpServletRequest object
     *@param  response              the HttpServletResponse response
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an I/O failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("props3", properties);
        response.setContentType("text/html");
        // set the response type before sending data



        String url = "/importConnections.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);


        //log("The logged count is " + counter);
    }

}

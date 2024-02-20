package context;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import model.Model;

/**
 * This class is responsible for creating an instance of the Model class and
 * storing it as an attribute in the ServletContext. It gets invoked when the
 * application starts.
 * 
 * @author Adam Kuraczyński
 * @version 1.0
 */
public class Context implements ServletContextListener {

    private Model model;

    /**
     * Called when the ServletContext is initialized.
     * Initializes the Model instance and stores it as an attribute in the
     * ServletContext.
     * @param servletContextEvent the event triggered when the ServletContext is initialized
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        model = new Model();
        servletContextEvent.getServletContext().setAttribute("modelContext", model);
    }
}
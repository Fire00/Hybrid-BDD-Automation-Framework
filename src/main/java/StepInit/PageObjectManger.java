package StepInit;

import BaseTestSession.BaseTestSession;
import io.cucumber.java.Scenario;
import pageObjects.NoBroker;

public class PageObjectManger {
    /**
     * This class is used to inialize all the PageObjects at the start of the scenarios
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */


    private BaseTestSession session;
    private Scenario scenario;

    private NoBroker noBroker=null;

    /**
     * Constructor to inlialize PageObjectManger
     * Here  session,scenario objects are Initialized
     *
     * @param session object of BaseTestSession class
     * @param scenario Takes cucumber scenario object
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    protected PageObjectManger(BaseTestSession session, Scenario scenario)
    {
        this.session=session;
        this.scenario=scenario;
    }

    /**
     * Here  PageObjects are Initialized
     *
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    protected void initPageObjects()
    {
        noBroker=new NoBroker(session);
    }

    /**
     * Getter method for pageObjects.
     *
     * @return returns object of PageObject classes
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public NoBroker getNoBroker(){return noBroker;}



}

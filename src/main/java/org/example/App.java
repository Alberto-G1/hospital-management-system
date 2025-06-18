package org.example;

import org.example.controller.HospitalController;
import org.example.views.HospitalView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HospitalController controller = new HospitalController();
        HospitalView view = new HospitalView(controller);
        view.displayMenu();
    }
}

package sdmd;

import com.googlecode.objectify.ObjectifyService;
import sdmd.contact.Contact;
import sdmd.highscore.Highscore;
import sdmd.note.Note;
import sdmd.student.Student;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ObjectifyWebListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ivo");
        // Initialize Objectify Service
        ObjectifyService.init();
        ObjectifyService.register(Contact.class);
        ObjectifyService.register(Note.class);
        ObjectifyService.register(Student.class);
        ObjectifyService.register(Highscore.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Cleanup, if necessary
    }
}
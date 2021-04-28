import interfaces.Mentor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {
        //BeanFactory container = new ClassPathXmlApplicationContext("config.xml");
        //we can also try with ApplicationContext
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

       // Mentor mentor = new FullTimeMentor(); //We dont want to use new keyword
        Mentor mentor = (Mentor) container.getBean("fullTimeMentor");

        mentor.createAccount();

        //Mentor mentor1 = (Mentor) container.getBean("partTimeMentor");
        //We have also another way to do it
        Mentor mentor1 = container.getBean("fullTimeMentor", Mentor.class); // no need to down cast in this way

        mentor1.createAccount();

        Mentor mentor2 = (Mentor) container.getBean("partTimeMentor");

        mentor2.createAccount();
    }
}

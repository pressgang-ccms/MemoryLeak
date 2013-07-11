import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to consume all the memory in the JVM.
 */
@Singleton
public class MemoryLeak {
    private static final List references = new ArrayList();

    @Schedule(second = "0", minute = "0/5", hour = "*")
    private void startup() {

        try {
            while (true) {
                final byte[] array = new byte[1048576];
                references.add(array);
            }
        } catch (final Exception ex) {

        }
    }
}

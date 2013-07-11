import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to consume all the memory in the JVM.
 */
@Singleton
@Startup
public class MemoryLeak {
    private static final List references = new ArrayList();

    @PostConstruct
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

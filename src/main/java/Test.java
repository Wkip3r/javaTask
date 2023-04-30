import org.example.App;
import org.example.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        App app = context.getBean("app", App.class);
        app.startAnalysisFile();
    }
}

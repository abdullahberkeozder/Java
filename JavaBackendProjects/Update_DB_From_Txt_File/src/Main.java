import java.io.IOException;

public class Main {
    public static void main(String [] Args) throws IOException {
        /*
        DbConnect app = new DbConnect();
        app.connect();

         */

        DbUpdate app = new DbUpdate();
        app.connect();
    }
}
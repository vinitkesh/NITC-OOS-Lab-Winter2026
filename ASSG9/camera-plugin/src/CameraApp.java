import java.util.ServiceLoader;

public class CameraApp {

    public static void main(String[] args) {

        ServiceLoader<CameraPlugin> loader =
                ServiceLoader.load(CameraPlugin.class);

        for (CameraPlugin plugin : loader) {
            System.out.println("Loaded Camera Mode: " + plugin.getModeName());
            plugin.capture();
        }
    }
}

public class VideoMode implements CameraPlugin {

    public String getModeName() {
        return "Video Mode";
    }

    public void capture() {
        System.out.println("Recording video...");
    }
}

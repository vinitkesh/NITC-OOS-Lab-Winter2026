public class PhotoMode implements CameraPlugin {

    public String getModeName() {
        return "Photo Mode";
    }

    public void capture() {
        System.out.println("Taking a photo...");
    }
}


import java.io.File;

// Imagine you are building a Notification Engine for a modern app like Uber or Ola. The
// system needs to send alerts to users, but the information available depends entirely on
// the channel the user has opted for (SMS, Email, or In-App Push). Instead of creating
// separate methods like sendEmail() or sendSMS(), you want a single, unified send()
// method that adapts based on the contact details provided.
// In-App Alert: The simplest form. It only needs the userId and the message string.
// SMS Notification: Needs the phoneNumber (as a long or String), the message, and a
// boolean flag to indicate if it’s an "Emergency" alert (which bypasses "Do Not Disturb"
// settings).
// Marketing Email: Needs the emailAddress, the subjectLine, the messageBody, and an
// array of File objects for attachments (like coupons or brochures).

class NotificationEngine {
    public void send(String userId, String message) {
        System.out.println("In-App Alert sent to userId: " + userId + " with message: " + message);
    }

    public void send(long phoneNumber, String message, boolean isEmergency) {
        String alertType = isEmergency ? "Emergency SMS" : "Regular SMS";
        System.out.println(alertType + " sent to phone number: " + "\n  " +  phoneNumber + " with message: " + message + "\n");
    }

    public void send(String emailAddress, String subjectLine, String messageBody, File[] attachments) {
        System.out.println("Marketing Email sent to: " + emailAddress);
        System.out.println("  Subject: " + subjectLine );
        System.out.println("  Message: " + messageBody );
        if (attachments != null && attachments.length > 0) {
            System.out.println("Attachments:");
            for (File attachment : attachments) {
                System.out.println("- " + attachment.getName());
            }
        } else {
            System.out.println("No attachments.");
        }
    }
}

public class Q3 {
    public static void main(String[] args) {
        NotificationEngine engine = new NotificationEngine();

        // Test In-App Alert
        engine.send("user123", "Your ride is arriving soon!");

        // Test SMS Notification
        engine.send(9876543210L, "Your ride is arriving soon!", false);

        // Test Marketing Email
        File[] attachments = { new File("coupon.pdf"), new File("brochure.pdf") };
        engine.send("user@example.com", "Special Offer!", "Check out our latest deals!", attachments);
    }
}

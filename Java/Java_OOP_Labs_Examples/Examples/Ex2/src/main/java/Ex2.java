/*
 ============================================================================
 Name        : Ex2
 Description : MobileApplication class with attributes, setters, and getters
 ============================================================================
 */

class MobileApplication {
    // Attributes
    private String appName;
    private String developer;
    private double version;
    private int downloads;

    // Constructor
    public MobileApplication(String name, String dev, double ver, int dls) {
        appName = name;
        developer = dev;
        version = ver;
        downloads = dls;
    }

    // Setters
    public void setAppName(String name) {
        appName = name;
    }

    public void setDeveloper(String dev) {
        developer = dev;
    }

    public void setVersion(double ver) {
        version = ver;
    }

    public void setDownloads(int dls) {
        downloads = dls;
    }

    // Getters
    public String getAppName() {
        return appName;
    }

    public String getDeveloper() {
        return developer;
    }

    public double getVersion() {
        return version;
    }

    public int getDownloads() {
        return downloads;
    }

    // Display application info
    public void displayInfo() {
        System.out.println("App Name: " + appName);
        System.out.println("Developer: " + developer);
        System.out.println("Version: " + version);
        System.out.println("Downloads: " + downloads);
    }
}

// Main class
public class Ex2 {
    public static void main(String[] args) {
        // Create MobileApplication object
        MobileApplication app = new MobileApplication("ChatApp", "TechCorp", 1.5, 10000);

        // Display initial values
        app.displayInfo();

        System.out.println("\nUpdating values...\n");

        // Update attributes using setters
        app.setAppName("ChatMaster");
        app.setDeveloper("NextGenTech");
        app.setVersion(2.0);
        app.setDownloads(50000);

        // Display updated values using getters
        System.out.println("App Name: " + app.getAppName());
        System.out.println("Developer: " + app.getDeveloper());
        System.out.println("Version: " + app.getVersion());
        System.out.println("Downloads: " + app.getDownloads());
    }
}

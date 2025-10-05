import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;

class User
{
    public String username;
    public String password;
}

public class HelperClass {
    private static final String TestPrjRoot = "src/test/java/";
    private static final String TestDataFolder = "TestingData/";
    
    public static String ReadFromFile(String fileName, String Key) throws FileNotFoundException
    {
        FileReader reader = new FileReader(TestPrjRoot+TestDataFolder+fileName);
        JsonElement e1 = JsonParser.parseReader(reader);
        return e1.getAsJsonObject().get(Key).getAsString();
    }

    /**
     *
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public static User[] ReadUsers (String fileName) throws FileNotFoundException
    {
        FileReader reader = new FileReader(TestPrjRoot+TestDataFolder+fileName);
        User[] ListOfCredentials = new Gson().fromJson(reader, User[].class);
        return ListOfCredentials;
    }
}

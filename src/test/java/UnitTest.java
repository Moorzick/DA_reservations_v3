import com.test.tools.Tools;
import com.test.tools.XPObject;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class UnitTest {
    public static void main(String[] args) throws IOException, ParseException {
        String randomA = new XPObject("a")
                .withProperties()
                .containsText("link text")
                .and()
                .containsProperty("href","google.com")
                .closeProps()
                .fSibling(new XPObject("span").getString())
                .skipTo()
                .div()
                .getString();
        System.out.println(randomA);
    }
}

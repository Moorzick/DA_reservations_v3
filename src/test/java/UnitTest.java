import com.test.tools.Tools;
import com.test.tools.XPObject;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UnitTest {
    public static void main(String[] args) throws IOException, ParseException {
        String directory = "C:\\Users\\user\\Desktop\\ICSData\\";
        String file = "test.json";

        String value1 = "Value01";
        String value2 = "Value02";

        JSONObject jsonStrict = new JSONObject();
        jsonStrict.put("property1", value1).put("property2", value2);

        FileWriter fw = new FileWriter(directory+file);
        String jsonText = jsonStrict.toString();
        System.out.println(jsonText);
        fw.write(jsonText.toCharArray());
        fw.close();

        String json = new String(Files.readAllBytes(Paths.get(directory+file)));
        System.out.println(json);


    }
}
/*        String jsonSource = "C:\\Users\\user\\Desktop\\ICEDescriptions.json";
        String jsonTarget = "C:\\Users\\user\\Desktop\\ICSdata\\ICEDescriptionsMerged.json";


        JSONArray json1 = (org.json.simple.JSONArray) new JSONParser().parse(new FileReader(jsonSource));
        JSONArray json2 = (JSONArray) new JSONParser().parse(new FileReader(jsonTarget));

        for (int i=0; i<json1.size(); i++){
            JSONObject group = (JSONObject) json1.get(i);
            String groupName = group.get("groupName").toString();
            JSONObject existingGroup = checkGroupExist(groupName, json2);
            if(existingGroup==null){
                json2.add(group);
            }
            else {
                JSONArray nodesSource = (JSONArray) group.get("nodes");
                JSONArray nodesTarget = (JSONArray) existingGroup.get("nodes");
                for (int j=0; j<nodesSource.size(); j++){
                    JSONObject nodeSource = (JSONObject) nodesSource.get(j);
                    String nodeSourceName = nodeSource.get("name").toString();
                    String nodeSourceSubgroup = nodeSource.get("subGroup").toString();
                    if (!checkNodeExist(nodeSourceName, nodeSourceSubgroup, nodesTarget)){
                        nodesTarget.add(nodeSource);
                    }
                }
            }
        }
        System.out.println(json2.toJSONString());

    }

    public static JSONObject checkGroupExist(String groupname, JSONArray jsonArray){
        JSONObject jsonToReturn=null;
        for (int i=0; i<jsonArray.size(); i++){
            JSONObject subject = (JSONObject) jsonArray.get(i);
            String subjectGroup=subject.get("groupName").toString();
            if (subjectGroup.equals(groupname)){
                i=jsonArray.size();
                jsonToReturn=subject;
            }
        }
        return jsonToReturn;
    }

    public static boolean checkNodeExist (String nodeName, String nodeSubgroup, JSONArray nodesTarget){
        boolean exist = false;
        for (int i=0; i<nodesTarget.size(); i++){
            JSONObject node = (JSONObject) nodesTarget.get(i);
            if (node.get("name").equals(nodeName) && node.get("subGroup").equals(nodeSubgroup)){
                exist=true;
                i= nodesTarget.size();
            }
        }
        return exist;*/


/*        String json = "C:\\Users\\user\\edison_go\\json\\view_types.json";

        JSONArray views = (JSONArray) new JSONParser().parse(new FileReader(json));

        JSONObject view1 = (JSONObject) views.get(0);
        JSONObject view2 = (JSONObject) views.get(1);

        JSONArray controls1 = getControls(view1);
        JSONArray controls2 = getControls(view2);

        for (int i=0; i<controls1.size(); i++){
            System.out.println(getID((JSONObject) controls1.get(i)));
        }
        System.out.println("==================");

        for (int i=0; i<controls2.size(); i++){
            System.out.println(getID((JSONObject) controls2.get(i)));
        }

    }

    private  static  JSONArray getControls (JSONObject view){
        JSONArray controls = (JSONArray) view.get("controls");
        return controls;
    }

    private static String getID (JSONObject control){
        String id = control.get("id").toString();
        return id;
    }*/





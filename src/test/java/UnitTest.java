import com.test.tools.Tools;
import com.test.tools.XPObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class UnitTest {
    public static void main(String[] args) throws IOException, ParseException {
        String jsonSource = "C:\\Users\\user\\Desktop\\ICEDescriptions.json";
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
        return exist;
    }

}

package FileIO;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/28
 * @description
 */
public class ReadPathFile {
    public List<String> readPathFile(Map<String, Object> params) {
        List<String> result = new ArrayList<>();
        if (params.get("strInputPath") == null) {
            return null;
        }
        File[] allFiles = (new File((String) params.get("strInputPath"))).listFiles();
        for (File oneFile : allFiles) {
            if (oneFile.isFile()) {
                System.out.println(oneFile.getName());
                result.add(oneFile.getName());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ReadPathFile rp=new ReadPathFile();
        Map<String,Object> map=new HashMap<>();
        map.put("strInputPath","/Users/magicjaychen/Documents/Documents/idea_workspace/linehelper/data/input/");
//        map.put("strOutputPath"," /Users/magicjaychen/Documents/Documents/idea_workspace/linehelper/data/output/combine.sql");
        rp.readPathFile(map);
    }
}

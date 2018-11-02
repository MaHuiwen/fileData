
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;

public class WordUtil {

    public void createWord(HashMap<String, Object> map, String srcPath, String desPath) throws Exception {
        Configuration config = MyFreeMarker.getConfiguration();
        Template template = config.getTemplate(srcPath);

        File outFile = new File(desPath);
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));

        template.process(map, out);
        out.flush();
    }

    public static void main(String[] args) throws Exception{
        WordUtil w = new WordUtil();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("department", "java");
        map.put("name", "mhw");
        map.put("reason", "测试测试测试测试测试测试<w:p></w:p>" +
                "测试测试测试测试测试测试<w:p></w:p>" +
                "测试测试测试测试测试测试<w:p></w:p>" +
                "测试测试测试测试测试测试<w:p></w:p>");
        map.put("time", "5");
        String srcPath = "test.docx";
        String desPth = "F:\\project\\fileData\\test_file\\out.docx";

        w.createWord(map, srcPath, desPth);

        System.out.println("文件输出成功！");
    }

}

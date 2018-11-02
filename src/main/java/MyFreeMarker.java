import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;

import java.io.File;
import java.io.IOException;

public class MyFreeMarker {
    private static Configuration config = null;

    private MyFreeMarker() {

    }

    public static Configuration getConfiguration() {
        if(config == null) {
            config = new Configuration();
        }

        try {
            //设置模板的根目录
            config.setDirectoryForTemplateLoading(new File("F:\\project\\fileData\\test_file"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //指定模板数据模型
        config.setObjectWrapper(new DefaultObjectWrapper());

        return config;
    }
}

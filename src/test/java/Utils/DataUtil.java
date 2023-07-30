package Utils;

import Base.BaseTest;
import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class DataUtil extends BaseTest {

    @DataProvider
    public static Object [][] dataProvider1() {
        return readYaml("src/main/resources/data.yaml" , "data1");
    }

    @DataProvider
    public static Object [][] dataProvider2() {
        return readYaml("src/main/resources/data.yaml", "data2");
    }

    @DataProvider
    public static Object [][] dataProvider3() {
        return readYaml("src/main/resources/data.yaml", "data3");
    }

    @DataProvider
    public static Object [][] dataProvider4() {
        return readYaml("src/main/resources/data.yaml", "data4");
    }

    @DataProvider
    public static Object [][] dataProvider5() {
        return readYaml("src/main/resources/data.yaml", "data5");
    }

    @DataProvider
    public static Object [][] dataProvider6() {
        return readYaml("src/main/resources/data.yaml", "data6");
    }
    @DataProvider
    public static Object [][] dataProvider7() {
        return readYaml("src/main/resources/data.yaml", "data7");
    }
    @DataProvider
    public static Object [][] dataProvider8() {
        return readYaml("src/main/resources/data.yaml", "data8");
    }

    @DataProvider
    public static Object [][] dataProvider9() {
        return readYaml("src/main/resources/data.yaml", "data9");
    }

    private static Object [][] readYaml(String filePath, String yamlObject) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(inputStream);
        Object[][] testData = new Object[1][1];
        testData[0][0] = data.get(yamlObject);
        return testData;
    }


}

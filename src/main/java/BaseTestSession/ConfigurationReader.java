package BaseTestSession;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * This class is used for reading the data from Yaml files i.e Config.yml
 * Information such as Browser, Url are fetched here
 *
 * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
 */


public class ConfigurationReader {
    public HashMap<String,String> config=null;


    /**
     * Constructor to initialize ConfigurationReader
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public ConfigurationReader() {

        this.config=getConfigFileDetails();
    }

    /**
     * This function is used to Read a YAML file.
     *
     * @param file File Object
     * @return Hashmap with string=object(key,value) pair
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public  static HashMap<String,Object> readYML(File file)
    {
        HashMap<String,Object> config= new LinkedHashMap<>();
        try{
            InputStream configstream = new FileInputStream(file);
            Yaml yaml=new Yaml();
            config=yaml.load(configstream);
        }
        catch (Exception e)
        {
            System.out.println("Exception is :"+e.getLocalizedMessage());
        }
        return config;
    }

    /**
     * This function is used to Read data from config.yml file.
     *
     * Details such as browser name, Url is fetched here.
     * @return Hashmap in string,string(key,value) format
     *
     * @author Siddhartha Pandey (pandeysiddhartha007@gmail.com)
     */
    public static HashMap<String,String> getConfigFileDetails()
    {
        HashMap<String,String> config=(HashMap<String, String>) (readYML(new File(System.getProperty("user.dir")
                                                                        +"//src//main//resources//configInit//config.yml")).get("TestRun"));

        HashMap<String,String> config_details=new LinkedHashMap<>();
        config_details.put("Browser",config.get("browser"));
        config_details.put("url",config.get("url"));

        return config_details;
    }

}

package com.qq.regist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesConfigHelper {
	 //使�??��?�??
    private final static Logger logger = Logger.getLogger(PropertiesConfigHelper.class);
    //设置?????
    private final static String EXT = ".properties";
    //�????roperties对象
    private static Properties configProperties = null;

    /**
     * ??��properties??��
     *
     * @param filepaths properties??���??
     */
    public static void load(String... filepaths) {
        logger.debug("�??读�?properties??�� �???��?" + System.currentTimeMillis());
        if(configProperties==null){
            configProperties = new Properties();
        }
        //??��??���??
        String configFilePath;
        InputStream inputStream = null;
        //???filepathke?��?
        for (int i = 0; i < filepaths.length; i++) {
            configFilePath = filepaths[i];
            //读�?�????��?????��.properties
            try {
                if (configFilePath.toLowerCase().endsWith(EXT)) {
                    inputStream = PropertiesConfigHelper.class.getClassLoader().getResourceAsStream(configFilePath);
                    configProperties.load(inputStream);
                } else {
                    throw new RuntimeException("???读�?该�?�? " + configFilePath);
                }
                logger.debug("??�� \"" + configFilePath + "\" 读�? ???! ?��?�?" + System.currentTimeMillis());
            } catch (Exception e) {
                logger.debug("??�� \"" + configFilePath + "\" 读�? 失败, 失败�?��信�?:\\n" + e.getMessage());
                throw new RuntimeException("??�� \"" + configFilePath + "\" ??��失败", e);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        logger.debug("?????��??��读�?�??,�?????�?ileInputStream?��?�?��信�? :\\n" + e.getMessage());
                    }
                }
            }

        }

    }

    /**
     * ?��? int 类�????�???��?value
     *
     * @param key          ??���????ey
     * @param defaultValue �????
     * @return 对�????�????alue�?????�???��?value�?��short类�????�??对�????�???��??????defaultValue
     */
    public static Short getShortValue(String key, Short defaultValue) {
        try {
            return getShortValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * ?��? short 类�????�???��?value
     *
     * @param key ??���????ey
     * @return 对�????�????alue
     */
    public static Short getShortValue(String key) {
        return Short.parseShort(configProperties.getProperty(key));
    }

    /**
     * ?��? int 类�????�???��?value
     *
     * @param key          ??���????ey
     * @param defaultValue �????
     * @return 对�????�????alue�?????�???��?value�?��int类�????�??对�????�???��??????defaultValue
     */
    public static int getIntegerValue(String key, Integer defaultValue) {
        try {
            return getIntegerValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * ?��? int 类�????�???��?value
     *
     * @param key ??���????ey
     * @return 对�????�????alue
     */
    public static Integer getIntegerValue(String key) {
        return Integer.parseInt(configProperties.getProperty(key));
    }


    /**
     * ?��? float 类�????�???��?value
     *
     * @param key          ??���????ey
     * @param defaultValue �????
     * @return 对�????�????alue�?????�???��?value�?��float类�????�??对�????�???��??????defaultValue
     */
    public static Float getFloatValue(String key, float defaultValue) {
        try {
            return getFloatValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * ?��? float 类�????�???��?value
     *
     * @param key ??���????ey
     * @return 对�????�????alue
     */
    public static Float getFloatValue(String key) {
        return Float.parseFloat(configProperties.getProperty(key));
    }

    /**
     * ?��? double 类�????�???��?value
     *
     * @param key ??���????ey
     * @param defaultValue �????
     * @return 对�????�????alue�?????�???��?value�?��double类�????�??对�????�???��??????defaultValue
     */
    public static Double getDoubleValue(String key, double defaultValue) {
        try {
            return getDoubleValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    /**
     * ?��? Double 类�????�???��?value
     *
     * @param key ??���????ey
     * @return 对�????�????alue
     */
    public static Double getDoubleValue(String key) {
        return Double.parseDouble(configProperties.getProperty(key));
    }



    /**
     * ?��? long 类�????�???��?value
     *
     * @param key ??���????ey
     * @param defaultValue �????
     * @return 对�????�????alue�?????�???��?value�?��long类�????�??对�????�???��??????defaultValue
     */
    public static Long getLongValue(String key, long defaultValue) {
        try {
            return getLongValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    /**
     * ?��? Long 类�????�???��?value
     *
     * @param key ??���????ey
     * @return 对�????�????alue
     */
    public static Long getLongValue(String key) {
        return Long.parseLong(configProperties.getProperty(key));
    }



    /**
     * ?��? String 类�????�???��?value
     *
     * @param key ??���????ey
     * @param defaultValue �????
     * @return 对�????�????alue�?????�???��?value�?"???�??对�????�???��??????defaultValue
     */
    public static String getStringValue(String key, String defaultValue) {
        String value = configProperties.getProperty(key);
        return (value == null) ? defaultValue : getStringValue(key);
    }
    /**
     * ?��? String 类�????�???��?value
     *
     * @param key ??���????ey
     * @return 对�????�????alue
     */
    public static String getStringValue(String key) {
        return configProperties.getProperty(key);
    }

    /**
     * ?��? boolean 类�????�???��?value
     *
     * @param key ??���????ey
     * @param defaultValue �????
     * @return �???��?�??件中没�?�??此�??��??????defaultValue;
     *         �?? value �???n??es ??rue ??? 0 ?��?(????��?大�??? ?????true, ???�?? false
     */
    public static boolean getBooleanValue(String key, Boolean defaultValue) {
        String value = configProperties.getProperty(key);
        return (value == null) ? defaultValue : getBooleanValue(key);
    }
    /**
     * ?��? boolean 类�????�???��?value
     *
     * @param key ??���????ey
     * @return 对�????�????alue
     */
    public static Boolean getBooleanValue(String key) {
        String value = configProperties.getProperty(key);
        return ("y".equalsIgnoreCase(value)) || ("on".equalsIgnoreCase(value)) || ("yes".equalsIgnoreCase(value))
                || ("true".equalsIgnoreCase(value)) || (getIntegerValue(key, 0) != 0);
    }
    /**
     * ??��properties??��
     *
     * @param filepath properties??���??
     */
    public static void write(String key, String value,String filepath){
        if(configProperties==null){
            configProperties = new Properties();
        }

        OutputStream outputStream = null;
        try{
            String base = PropertiesConfigHelper.class.getResource("/"+filepath).getPath();
            System.out.println(base);
            java.net.URL url = PropertiesConfigHelper.class.getResource("/"+filepath);
            System.out.println(url.toURI());
            File file = new File(url.toURI());
            //?��???��???�??
            if(!file.exists()){
                file.createNewFile();
            }

            load(filepath);//??��??��

            outputStream = new FileOutputStream(file);

            configProperties.setProperty(key,value);

            configProperties.store(outputStream,"email:hanpang8983@foxmail.com");


        }catch (Exception e){
            throw new RuntimeException("??�� \"" + filepath + "\" ??��失败", e);
        }finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    logger.debug("?????��??���??�??,FileOutputStream�?��信�? :\\n" + e.getMessage());
                }
            }
        }

    }



}

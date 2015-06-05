package com.qq.regist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesConfigHelper {
	 //ä½¿ç??¥å?è¾??
    private final static Logger logger = Logger.getLogger(PropertiesConfigHelper.class);
    //è®¾ç½®?????
    private final static String EXT = ".properties";
    //å®????ropertieså¯¹è±¡
    private static Properties configProperties = null;

    /**
     * ??½½properties??»¶
     *
     * @param filepaths properties??»¶è·??
     */
    public static void load(String... filepaths) {
        logger.debug("å¼??è¯»å?properties??»¶ å¼???¶é?" + System.currentTimeMillis());
        if(configProperties==null){
            configProperties = new Properties();
        }
        //??½®??»¶è·??
        String configFilePath;
        InputStream inputStream = null;
        //???filepathke?°ç?
        for (int i = 0; i < filepaths.length; i++) {
            configFilePath = filepaths[i];
            //è¯»å?å±????»¶?????¸º.properties
            try {
                if (configFilePath.toLowerCase().endsWith(EXT)) {
                    inputStream = PropertiesConfigHelper.class.getClassLoader().getResourceAsStream(configFilePath);
                    configProperties.load(inputStream);
                } else {
                    throw new RuntimeException("???è¯»å?è¯¥æ?ä»? " + configFilePath);
                }
                logger.debug("??»¶ \"" + configFilePath + "\" è¯»å? ???! ?¶é?ä¸?" + System.currentTimeMillis());
            } catch (Exception e) {
                logger.debug("??»¶ \"" + configFilePath + "\" è¯»å? å¤±è´¥, å¤±è´¥å¼?¸¸ä¿¡æ?:\\n" + e.getMessage());
                throw new RuntimeException("??»¶ \"" + configFilePath + "\" ??½½å¤±è´¥", e);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        logger.debug("?????½®??»¶è¯»å?å®??,å½?????ä»?ileInputStream?¶ï?å¼?¸¸ä¿¡æ? :\\n" + e.getMessage());
                    }
                }
            }

        }

    }

    /**
     * ?·å? int ç±»å????ç½???§ç?value
     *
     * @param key          ??½®å±????ey
     * @param defaultValue é»????
     * @return å¯¹å????ç½????alueï¼?????ç½???§ç?valueä¸?¸ºshortç±»å????å­??å¯¹å????ç½???§ï??????defaultValue
     */
    public static Short getShortValue(String key, Short defaultValue) {
        try {
            return getShortValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * ?·å? short ç±»å????ç½???§ç?value
     *
     * @param key ??½®å±????ey
     * @return å¯¹å????ç½????alue
     */
    public static Short getShortValue(String key) {
        return Short.parseShort(configProperties.getProperty(key));
    }

    /**
     * ?·å? int ç±»å????ç½???§ç?value
     *
     * @param key          ??½®å±????ey
     * @param defaultValue é»????
     * @return å¯¹å????ç½????alueï¼?????ç½???§ç?valueä¸?¸ºintç±»å????å­??å¯¹å????ç½???§ï??????defaultValue
     */
    public static int getIntegerValue(String key, Integer defaultValue) {
        try {
            return getIntegerValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * ?·å? int ç±»å????ç½???§ç?value
     *
     * @param key ??½®å±????ey
     * @return å¯¹å????ç½????alue
     */
    public static Integer getIntegerValue(String key) {
        return Integer.parseInt(configProperties.getProperty(key));
    }


    /**
     * ?·å? float ç±»å????ç½???§ç?value
     *
     * @param key          ??½®å±????ey
     * @param defaultValue é»????
     * @return å¯¹å????ç½????alueï¼?????ç½???§ç?valueä¸?¸ºfloatç±»å????å­??å¯¹å????ç½???§ï??????defaultValue
     */
    public static Float getFloatValue(String key, float defaultValue) {
        try {
            return getFloatValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * ?·å? float ç±»å????ç½???§ç?value
     *
     * @param key ??½®å±????ey
     * @return å¯¹å????ç½????alue
     */
    public static Float getFloatValue(String key) {
        return Float.parseFloat(configProperties.getProperty(key));
    }

    /**
     * ?·å? double ç±»å????ç½???§ç?value
     *
     * @param key ??½®å±????ey
     * @param defaultValue é»????
     * @return å¯¹å????ç½????alueï¼?????ç½???§ç?valueä¸?¸ºdoubleç±»å????å­??å¯¹å????ç½???§ï??????defaultValue
     */
    public static Double getDoubleValue(String key, double defaultValue) {
        try {
            return getDoubleValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    /**
     * ?·å? Double ç±»å????ç½???§ç?value
     *
     * @param key ??½®å±????ey
     * @return å¯¹å????ç½????alue
     */
    public static Double getDoubleValue(String key) {
        return Double.parseDouble(configProperties.getProperty(key));
    }



    /**
     * ?·å? long ç±»å????ç½???§ç?value
     *
     * @param key ??½®å±????ey
     * @param defaultValue é»????
     * @return å¯¹å????ç½????alueï¼?????ç½???§ç?valueä¸?¸ºlongç±»å????å­??å¯¹å????ç½???§ï??????defaultValue
     */
    public static Long getLongValue(String key, long defaultValue) {
        try {
            return getLongValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    /**
     * ?·å? Long ç±»å????ç½???§ç?value
     *
     * @param key ??½®å±????ey
     * @return å¯¹å????ç½????alue
     */
    public static Long getLongValue(String key) {
        return Long.parseLong(configProperties.getProperty(key));
    }



    /**
     * ?·å? String ç±»å????ç½???§ç?value
     *
     * @param key ??½®å±????ey
     * @param defaultValue é»????
     * @return å¯¹å????ç½????alueï¼?????ç½???§ç?valueä¸?"???å­??å¯¹å????ç½???§ï??????defaultValue
     */
    public static String getStringValue(String key, String defaultValue) {
        String value = configProperties.getProperty(key);
        return (value == null) ? defaultValue : getStringValue(key);
    }
    /**
     * ?·å? String ç±»å????ç½???§ç?value
     *
     * @param key ??½®å±????ey
     * @return å¯¹å????ç½????alue
     */
    public static String getStringValue(String key) {
        return configProperties.getProperty(key);
    }

    /**
     * ?·å? boolean ç±»å????ç½???§ç?value
     *
     * @param key ??½®å±????ey
     * @param defaultValue é»????
     * @return å¦???¨é?ç½??ä»¶ä¸­æ²¡æ?å®??æ­¤å??§ï??????defaultValue;
     *         å¦?? value ä¸???n??es ??rue ??? 0 ?°å?(????ºå?å¤§å??? ?????true, ???è¿?? false
     */
    public static boolean getBooleanValue(String key, Boolean defaultValue) {
        String value = configProperties.getProperty(key);
        return (value == null) ? defaultValue : getBooleanValue(key);
    }
    /**
     * ?·å? boolean ç±»å????ç½???§ç?value
     *
     * @param key ??½®å±????ey
     * @return å¯¹å????ç½????alue
     */
    public static Boolean getBooleanValue(String key) {
        String value = configProperties.getProperty(key);
        return ("y".equalsIgnoreCase(value)) || ("on".equalsIgnoreCase(value)) || ("yes".equalsIgnoreCase(value))
                || ("true".equalsIgnoreCase(value)) || (getIntegerValue(key, 0) != 0);
    }
    /**
     * ??½½properties??»¶
     *
     * @param filepath properties??»¶è·??
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
            //?¤æ???»¶???å­??
            if(!file.exists()){
                file.createNewFile();
            }

            load(filepath);//??½½??»¶

            outputStream = new FileOutputStream(file);

            configProperties.setProperty(key,value);

            configProperties.store(outputStream,"email:hanpang8983@foxmail.com");


        }catch (Exception e){
            throw new RuntimeException("??»¶ \"" + filepath + "\" ??½½å¤±è´¥", e);
        }finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    logger.debug("?????½®??»¶ä¿??å®??,FileOutputStreamå¼?¸¸ä¿¡æ? :\\n" + e.getMessage());
                }
            }
        }

    }



}

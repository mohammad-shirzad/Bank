package com.common.utils.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final String CONFIG_PATH;
    private static Properties configFile;
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigReader.class);

    static {
        CONFIG_PATH = System.getenv("BANK_CONFIG");
        fillConfigMap();
    }

    private static void fillConfigMap() {
        try (FileInputStream fileInputStream = new FileInputStream(CONFIG_PATH)) {
            configFile = new Properties();
            configFile.load(fileInputStream);
        } catch (IOException e) {
            LOGGER.error("unable to read config");
        }
    }

    public static Properties getConfigFile() {
        return configFile;
    }
}

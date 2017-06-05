package org.example.utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Kuzmin Evgeny on 30.05.2017.
 * Синглтон. Читает константные данные из xml файла.
 */
public class Utils {

    private static final Utils instance = new Utils();
    private Utils(){
        readXmlFile();
    }
    public static Utils getInstance(){
        return instance;
    }

    private String errorNameExist;
    private String errorInputLogin;
    private String errorInputData;
    private String xmlPath = "D:/MyJavaProjects/work/test_task_sber/src/main/resources/information.xml";

    private void readXmlFile(){
        try {

            File file = new File(xmlPath);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            errorNameExist = document.getElementsByTagName("error_name_exist").item(0).getTextContent();
            errorInputLogin = document.getElementsByTagName("error_input_login").item(0).getTextContent();
            errorInputData = document.getElementsByTagName("error_input_data").item(0).getTextContent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getErrorNameExist() {
        return errorNameExist;
    }

    public String getErrorInputLogin() {
        return errorInputLogin;
    }


    public String getErrorInputData() {
        return errorInputData;
    }

}

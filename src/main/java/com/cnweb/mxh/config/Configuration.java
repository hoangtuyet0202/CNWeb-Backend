package com.cnweb.mxh.config;

public class Configuration {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL_DATABASE = "jdbc:mysql://localhost:3306/cn-web-db";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "CnWeb2020$";

    // Write file in server path for get file resources
    // Write file in app path for deployment -> don't need when we deployed
    public static final String APP_PATH = "/home/minhduc2kvp/Documents/Hust/backend-cn-web/src/main/webapp/resources/images";
    public static final String SERVER_PATH = "/home/minhduc2kvp/Documents/Server/apache-tomcat-9.0.35/webapps/cnweb/resources/images";

    public static final String URL_API = "/api/v1";
}

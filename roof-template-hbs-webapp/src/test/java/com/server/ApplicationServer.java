package com.server;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * 内置Jetty服务器启动
 *
 */
public class ApplicationServer {

    public static String context = "";

    public static String PATH = "";

    static {
        //if(StringUtils.equals(System.getProperty("webapp.path"), "Y")){
//        PATH = "../rtp_pc_server/rtp-api/";
        //}
    }

    public static String webAppPath = PATH+"src/main/webapp";

    public static String defaultsDescriptor = PATH+"src/test/resources/webdefault.xml";

    public static int port = 8080;

    public static void main(String[] args) {
        try {
            if (checkPort(port)) {
                throw new BindException("The port:: [" + port + "]  " + "is already in Use...");

            }
            Server server = new Server(port);
            WebAppContext webContext = new WebAppContext(webAppPath, context);

            webContext.setDefaultsDescriptor(defaultsDescriptor);

            webContext.setClassLoader(Thread.currentThread().getContextClassLoader());

            server.setHandler(webContext);

            server.setStopAtShutdown(true);

            server.start();

        } catch (Exception e) {
            System.err.print(e.toString());
        }

    }

    private static boolean checkPort(int port) {
        try {
            ServerSocket ss = new ServerSocket(port);
            ss.close();
            return false;
        } catch (IOException e) {
            return true;
        }
    }

}


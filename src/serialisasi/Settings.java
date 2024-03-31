/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serialisasi;
import java.io.*;
/**
 *
 * @author User
 */
public class Settings implements Serializable {
    private transient String username; 
    private static int maxConnections; 
    private final String serverAddress; 

    public Settings(String username, int maxConnections, String serverAddress) {
        this.username = username;
        Settings.maxConnections = maxConnections;
        this.serverAddress = serverAddress;
    }

    public String getUsername() {
        return username;
    }

    public static int getMaxConnections() {
        return maxConnections;
    }

    public String getServerAddress() {
        return serverAddress;
    }
}


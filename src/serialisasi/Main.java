/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serialisasi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        // Membuat objek
        Settings settings = new Settings("Agus123", 10, "192.168.0.1");

        // Serialisasi
        serializeSettings(settings, "settings.ser");

        // Deserialisasi
        Settings deserializedSettings = deserializeSettings("settings.ser");

        // Menampilkan pengaturan yang sudah di deserilisasi
        System.out.println("Username: " + deserializedSettings.getUsername());
        System.out.println("Max Connections: " + Settings.getMaxConnections());
        System.out.println("Server Address: " + deserializedSettings.getServerAddress());
    }

    private static void serializeSettings(Settings settings, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(settings);
            System.out.println("Pengaturan berhasil disimpan ke dalam file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Settings deserializeSettings(String filename) {
        Settings settings = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            settings = (Settings) in.readObject();
            System.out.println("Pengaturan berhasil dibaca dari file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return settings;
    }
}


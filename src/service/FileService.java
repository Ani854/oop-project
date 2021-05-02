package service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileService {
    public static void createFolder(String path) {
        File file = new File(path);
        file.mkdir();
    }

    public static void createFile(String path, String name) {
        File file = new File(path + File.separator + name);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String path, String text) {
        try {
            Files.write(Paths.get(path), text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(String path) {
        String result = "";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            result = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String[] readLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path)).toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{};
    }
}

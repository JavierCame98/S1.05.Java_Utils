package org.example._5_Serialize_Java_Object;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class SerlializeMethods {

    public void serializeObject(Object obj, Path filePath) throws IOException {
        Objects.requireNonNull(obj, "Object can't be null");
        Objects.requireNonNull(filePath, "Path can't be null");

        if (!(obj instanceof Serializable)) {
            throw new IllegalArgumentException("The object has to be an instance of Serializable.");
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath.toFile());
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(obj);
            System.out.println("Serialized object is in: " + filePath.getFileName());

        }
    }

}

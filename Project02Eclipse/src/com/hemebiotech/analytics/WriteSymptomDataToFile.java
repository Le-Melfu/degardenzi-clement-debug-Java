package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteSymptomDataToFile implements ISymptomWriter {
    private final String filepath;
    private final Logger logger = Logger.getLogger(WriteSymptomDataToFile.class.getName());
    /**
     *
     * @param filepath a full or partial path to file to write symptoms(strings) and count(integer) in it, one per line
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (filepath != null) {
            try (FileWriter writer = new FileWriter(filepath)) {
                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    writer.write(entry.getKey().toUpperCase(Locale.ROOT) + ": " + entry.getValue() + "\n");
                }
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Error writing the file", e);
            }
        }
    }

}

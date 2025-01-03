package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Method to read the symptoms from a file
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
     * Method to count the number of iterations for each symptom
     */
    public Map<String, Integer> countSymptoms(List<String> symptomsList) {
        Map<String, Integer> symptomsCounts = new HashMap<>();
        for (String symptoms : symptomsList) {
            symptomsCounts.put(symptoms, symptomsCounts.getOrDefault(symptoms, 0) + 1);
        }
        return symptomsCounts;
    }

    /**
     * Method to write the count result to a file
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }

    /**
     * Method to Sort the symptoms alphabetically
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }
}

package com.hemebiotech.analytics;

import java.util.Map;

/**
 * This will write symptoms data from a Map of String and Integer
 * to a specified filepath
 */
public interface ISymptomWriter {
    void writeSymptoms(Map<String, Integer> symptoms);
}

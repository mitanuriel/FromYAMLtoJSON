package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlToJsonConverter {

    public static void main(String[] args) {

        String yamlInput = "persons:\n - anna\n - bent\n";

        String JsonOutput = convertYamlToJson(yamlInput);

        System.out.println(JsonOutput);
    }

    public static String convertYamlToJson(String yaml) {
        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());

        ObjectMapper jsonWriter = new ObjectMapper();

        try {
            JsonNode node = yamlReader.readTree(yaml);

            return jsonWriter.writerWithDefaultPrettyPrinter().writeValueAsString(node);

        } catch (JsonProcessingException e) {
        e.printStackTrace();
        return null;
        }
    }
}







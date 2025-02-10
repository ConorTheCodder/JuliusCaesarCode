package org.example;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Parsing {
    @SneakyThrows
    public void parse() {
        ConsoleHelper.writeMessage("Введите адрес для расшифровки");
        String src = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Предоставьте файл для набора статистики");
        String sampleText = ConsoleHelper.readString();
        Path path = ConsoleHelper.buildFileName(src, "_parse");
        Map<Character, Integer> mapSource = getMapStats(src);
        Map<Character, Integer> mapSample = getMapStats(sampleText);
        List<Map.Entry<Character, Integer>> sortedSourceList = getSortedList(mapSource);
        List<Map.Entry<Character, Integer>> sortedSampleList = getSortedList(mapSample);

        Map<Character, Character> decryptedMap = new HashMap<>();
        if (sortedSourceList.size() <= sortedSampleList.size()) {

            for (int i = 0; i < sortedSourceList.size(); i++) {
                decryptedMap.put(sortedSourceList.get(i).getKey(), sortedSampleList.get(i).getKey());
            }

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
                 BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
                while (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();
                    StringBuilder builderLine = new StringBuilder();
                    char[] charsArray = line.toCharArray();
                    for (char aChar : charsArray) {
                        char decryptedChar = decryptedMap.get(aChar);
                        builderLine.append(decryptedChar);
                    }
                    bufferedWriter.write(builderLine.toString());
                    bufferedWriter.newLine();
                }
            }


        } else
            ConsoleHelper.writeMessage("Требуется текст большего размера для сбора статистики.");
    }

    private List<Map.Entry<Character, Integer>> getSortedList(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());


        Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {

                return o2.getValue() - o1.getValue();
            }
        };
        list.sort(comparator);
        return list;

    }

    private Map<Character, Integer> getMapStats(String sourcePath) throws IOException {
        HashMap<Character, Integer> map = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourcePath))) {
            StringBuilder text = new StringBuilder();
            while (bufferedReader.ready()) {
                text.append(bufferedReader.readLine());
            }
            char[] charArray = text.toString().toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (!map.containsKey(charArray[i])) {
                    map.put(charArray[i], 1);
                } else {
                    int value = map.get(charArray[i]);
                    map.put(charArray[i], ++value);
                }
            }
        }
        return map;
    }
}

package com.hashcode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Photo {
    int id = 0;
    char orientation = ' ';
    Set<String> tags = new HashSet<>();
    Photo(String line, int id) {
        this.id = id;
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                orientation = words[i].charAt(0);
                continue;
            }
            if (i == 1) {
                continue;
            }
            tags.add(words[i]);
        }
    }
}

public class Problem {

    public static List<String> readFileInList(String fileName){ 
    
        List<String> lines = Collections.emptyList(); 
        try { 
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
        } 
    
        catch (IOException e){ 
            e.printStackTrace(); 
        } 
        return lines; 
    } 

    public static void main(String[] args) throws IOException {
        List<String> l = readFileInList("testcase");
        List<Photo> photos = new ArrayList<>();
        int i = -1;
        for (String line: l) {
            if (i == -1) {
                i++;
                continue;
            }
            photos.add(new Photo(line, i));
            i++;
            
        }
    }
}
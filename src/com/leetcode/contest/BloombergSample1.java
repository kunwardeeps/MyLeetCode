package com.leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class BloombergSample1 {

    public static void main(String[] args)
    {
        String[] array = new String[] {"3", 
        "NY DC 50 3 560 665 850",
        "NY Orlando 120 4 310 560 785 1225",
        "NY Chicago 120 3 520 750 1035",
        "NY DC 270"}; 
        
        getFlight(array);
    }

    public static class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }
        @Override
        public boolean equals(Object obj) {
            Vertex vertex = (Vertex) obj;
            return vertex.label == label;
        }
        @Override
        public int hashCode() {
            return label.hashCode();
        }
        @Override
        public String toString() {
            return label;
        }
    }

    public class Graph {
        private Map<Vertex, List<Vertex>> adjVertices;
    
        Graph() {
            this.adjVertices = new HashMap<Vertex, List<Vertex>>();
        }
    
        void addVertex(String label) {
            adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
        }
    
        void removeVertex(String label) {
            Vertex v = new Vertex(label);
            adjVertices.values().stream().map(e -> e.remove(v)).collect(Collectors.toList());
            adjVertices.remove(new Vertex(label));
        }
    
        void addEdge(String label1, String label2) {
            Vertex v1 = new Vertex(label1);
            Vertex v2 = new Vertex(label2);
            adjVertices.get(v1).add(v2);
            adjVertices.get(v2).add(v1);
        }
    
        void removeEdge(String label1, String label2) {
            Vertex v1 = new Vertex(label1);
            Vertex v2 = new Vertex(label2);
            List<Vertex> eV1 = adjVertices.get(v1);
            List<Vertex> eV2 = adjVertices.get(v2);
            if (eV1 != null)
                eV1.remove(v2);
            if (eV2 != null)
                eV2.remove(v1);
        }
    
        List<Vertex> getAdjVertices(String label) {
            return adjVertices.get(new Vertex(label));
        }
        
        String printGraph() {
            StringBuffer sb = new StringBuffer();
            for(Vertex v : adjVertices.keySet()) {
                sb.append(v);
                sb.append(adjVertices.get(v));
            }
            return sb.toString();
        }

    public static class FlightInfo {
        String from;
      
        String to;
      
        int duration;

        int departure;
      
        boolean skip; // used in backtracking
      
        FlightInfo(String f, String t, int dur, int dep) {
          from = f;
          to = t;
          duration = dur;
          departure = dep;
          skip = false;
        }
    }

    static String getFlight(String[] arr){
        List<FlightInfo> flights = new ArrayList<>();
        int n = Integer.parseInt(arr[0]);
        Set<String> nodes = new HashSet<>();
        Graph g = new Graph();
       for (int i=1; i<=n; i++){
           String str[] = arr[i].split(" ");
           String from = str[0];
           String to = str[1];
           int duration = Integer.parseInt(str[2]);
           int N = Integer.parseInt(str[3]);
           g.addVertex(from);
           g.addVertex(to);
           for (int j=4; j<4+N; j++){
                int departure = Integer.parseInt(str[j]);
                g.addEdge(from, to);
           }
       }
       return "";
    }

    // Determine if there is a route between from and to.
  void isflight(String from, String to) {
    int dist;
    FlightInfo f;

    // See if at destination.
    dist = match(from, to);
    if (dist != 0) {
      btStack.push(new FlightInfo(from, to, dist));
      return;
    }

    // Try another connection.
    f = find(from);
    if (f != null) {
      btStack.push(new FlightInfo(from, to, f.distance));
      isflight(f.to, to);
    } else if (btStack.size() > 0) {
      // Backtrack and try another connection.
      f = (FlightInfo) btStack.pop();
      isflight(f.from, f.to);
    }
  }

    static int getMaxLength(String line) 
    { 

        int n = line.length();
          
        int count = 0; //intitialize count 
        int result = 0; //initialize max 
      
        for (int i = 0; i < n; i++) 
        { 
              
            // Reset count when 0 is found 
            if (line.charAt(i) == '0') 
                count = 0; 
      
            // If 1 is found, increment count 
            // and update result if count becomes 
            // more. 
            else
            { 
                count++;//increase count 
                result = Math.max(result, count); 
            } 
        } 
      
        return result; 
    } 

    static String maxOnesIndex(String line) 
    { 
        int n = line.length();
        int max_count = 0;  // for maximum number of 1 around a zero 
        int max_index=0;  // for storing result 
        int prev_zero = -1;  // index of previous zero 
        int prev_prev_zero = -1; // index of previous to previous zero 
   
        // Traverse the input array 
        for (int curr=0; curr<n; ++curr) 
        { 
            // If current element is 0, then calculate the difference 
            // between curr and prev_prev_zero 
            if (line.charAt(curr) == '0') 
            { 
                // Update result if count of 1s around prev_zero is more 
                if (curr - prev_prev_zero > max_count) 
                { 
                    max_count = curr - prev_prev_zero; 
                    max_index = prev_zero; 
                } 
   
                // Update for next iteration 
                prev_prev_zero = prev_zero; 
                prev_zero = curr; 
            } 
        } 
   
        // Check for the last encountered zero 
        if (n-prev_prev_zero > max_count) 
        {
            max_count--;
            max_index = prev_zero; 
        }
        StringBuilder sb = new StringBuilder(line);
        sb.setCharAt(max_index, '1');
   
        return sb.toString();
    }

    public static void problem2(){
        Scanner stdin = new Scanner(System.in);
        String num = "", line = "";
        while(stdin.hasNextLine()) 
        {
            num = stdin.nextLine();
            line = stdin.nextLine();
        }
        int n1 = Integer.parseInt(num);
    }

    public static void problem1(){
        Scanner stdin = new Scanner(System.in);
        String num = "", line = "";
        while(stdin.hasNextLine()) 
        {
            num = stdin.nextLine();
            line = stdin.nextLine();
        }
        int n1 = Integer.parseInt(num);
        if (n1 < 2){
            System.out.println("NO");
            stdin.close();
            return;
        }
        String[] str_arr = line.split(" ");
        int even = 0;
        for (String s: str_arr){
            int n = Integer.parseInt(s);
            if (n%2 == 0){
                even++;
            }
        }
        if (even >= 2){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

        stdin.close();
    }


}
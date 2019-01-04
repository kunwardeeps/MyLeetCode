package com.leetcode.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem963MinAreaRect
 */
public class Problem963MinAreaRect {

    public static void main(String[] args) {
        
    }

    public static double minAreaFreeRect(int[][] points) {

        double area = Double.MAX_VALUE;

        for (int i = 0; i < points.length; i++){
            for (int j = i+1; j < points.length; j++){
                for (int k = j+1; k < points.length; k++){
                    for (int l = k+1; l < points.length; l++){
                        if (isRectangle(points[i], points[j], points[k], points[l])){
                            area = Math.min(area, getArea(points[i], points[j], points[k], points[l]));
                        }
                    }
                }
            }
        }

        if (area == Double.MAX_VALUE){
            return 0;
        }
        else {
            return area;
        }
        
    }

    private static double getArea(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<Double> list = new ArrayList<>();
        list.add(getDistance(p1[0], p1[1], p2));
        list.add(getDistance(p1[0], p1[1], p3));
        list.add(getDistance(p1[0], p1[1], p4));
        Collections.sort(list);
        return list.get(0) * list.get(1);
    }

    public static boolean isRectangle(int[] point1, int[] point2, int[] point3, int[] point4) {
        double cx = (point1[0] + point2[0] + point3[0] + point4[0])/4.0;
        double cy = (point1[1] + point2[1] + point3[1] + point4[1])/4.0;
        return getDistance(cx, cy, point1) == getDistance(cx, cy, point2) &&
            getDistance(cx, cy, point2) == getDistance(cx, cy, point3) &&
            getDistance(cx, cy, point3) == getDistance(cx, cy, point4) &&
            getDistance(cx, cy, point4) == getDistance(cx, cy, point1);
    }

    public static double getDistance(double x, double y, int[] point) {
        return Math.sqrt(Math.pow(x - point[0], 2) + Math.pow(y - point[1], 2));
    }
}
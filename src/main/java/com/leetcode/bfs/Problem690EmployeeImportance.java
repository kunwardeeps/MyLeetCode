package com.leetcode.bfs;

import java.util.List;

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}

/**
 * Problem690EmployeeImportance
 */
public class Problem690EmployeeImportance {

    public static void main(String[] args) {
    }

    public static int getImportance(List<Employee> employees, int id) {
        int importance = 0;
        for (Employee e: employees) {
            if (e.id == id) {
                importance += e.importance;
                for (Integer subId: e.subordinates) {
                    importance += getImportance(employees, subId);
                }
            }
        }
        return importance;
    }

}
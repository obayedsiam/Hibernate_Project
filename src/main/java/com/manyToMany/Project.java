package com.manyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {

    @Id
    private int pid;
    private String name;

    @ManyToMany(mappedBy = "projectList")
    private List<Employee> employeeList;

    public Project() {
    }

    public Project(int pid, String name, List<Employee> employeeList) {
        this.pid = pid;
        this.name = name;
        this.employeeList = employeeList;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}

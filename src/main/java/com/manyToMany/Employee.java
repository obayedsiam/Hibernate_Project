package com.manyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {

    @Id
    private int eid;
    private String name;

    @ManyToMany
    @JoinTable(name = "Pr_Em",
            joinColumns = {@JoinColumn(name = "eid")}, inverseJoinColumns = {@JoinColumn(name = "pid")})

    private List<Project> projectList;

    public Employee(int eid, String name, List<Project> projectList) {
        this.eid = eid;
        this.name = name;
        this.projectList = projectList;
    }

    public Employee() {
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}

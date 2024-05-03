package com.assignment.java.week8;

import java.io.Serializable;

public class ProjectDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	String projectCode;
    String projectName;
    int projectStrength;

    public ProjectDetails(String projectCode, String projectName, int projectStrength) {
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.projectStrength = projectStrength;
    }

    @Override
    public String toString() {
        return "Project [projectCode=" + projectCode + ", projectName=" + projectName + ", projectStrength=" + projectStrength + "]";
    }

}

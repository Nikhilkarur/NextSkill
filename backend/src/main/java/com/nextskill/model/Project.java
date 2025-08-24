package com.nextskill.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name")
    private String projectName;
    
    // NEW FIELD
    @Column(name = "date_range")
    private String dateRange;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    @ToString.Exclude
    private Resume resume;

    // Manual setters and getters for Lombok compatibility
    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public String getDateRange() {
        return this.dateRange;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
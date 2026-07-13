package com.axsos.studentroster.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required.")
    @Size(
            min = 2,
            max = 50,
            message = "First name must be between 2 and 50 characters."
    )
    @Pattern(
            regexp = "^[A-Za-z]+(?:[ '-][A-Za-z]+)*$",
            message = "First name may contain letters, spaces, apostrophes, and hyphens."
    )
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is required.")
    @Size(
            min = 2,
            max = 50,
            message = "Last name must be between 2 and 50 characters."
    )
    @Pattern(
            regexp = "^[A-Za-z]+(?:[ '-][A-Za-z]+)*$",
            message = "Last name may contain letters, spaces, apostrophes, and hyphens."
    )
    @Column(nullable = false)
    private String lastName;

    @Min(value = 10, message = "Age must be at least 10.")
    @Max(value = 100, message = "Age cannot be greater than 100.")
    @Column(nullable = false)
    private Integer age;

    // Many students can belong to one dorm.
    // nullable = true allows a student to be temporarily unassigned.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dorm_id", nullable = true)
    private Dorm dorm;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Student() {
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Dorm getDorm() {
        return dorm;
    }

    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

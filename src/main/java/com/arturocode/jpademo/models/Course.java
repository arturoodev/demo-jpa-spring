package com.arturocode.jpademo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String name;
        private String description;

        @ManyToMany
        @JoinTable(name = "courses_authors", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = {
                        @JoinColumn(name = "author_id") })
        private List<Author> authors;

        @OneToMany(mappedBy = "course")
        private List<Section> sections;
}

package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "attachments")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long attachId;

    private String attachTitle;

    @Column(nullable = false, updatable = false)
    private LocalDate uploadDate;

    private String extension;

    private String downloadLink;

}
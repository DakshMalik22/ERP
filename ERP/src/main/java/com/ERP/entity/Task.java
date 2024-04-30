package com.ERP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "task_table", uniqueConstraints = @UniqueConstraint(
        name = "task_id_unique",
        columnNames = "task_id"
))
public class Task {
    @Id
    @SequenceGenerator(
            name = "task_sequence", // Specify the name of sequence generator
            sequenceName = "task_sequence_name", // Specify the name of your sequence in the db
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private int taskId;

    private String name;
    private String description;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime startDate;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate;

    private String status;
    private int projectId;
    private int employeeId;
}
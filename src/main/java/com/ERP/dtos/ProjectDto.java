package com.ERP.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDto
{
    @JsonIgnore
    private long projectId;
    @NotNull(message = "Name of Project cannot be null")
    @Size(min=3,max = 20,message = "min characters are 3 and maximum characters can be upto 20")
    @Pattern(regexp = "^[^\\s].*$", message = "Name of project must atleast one character")
    private String name;
    @NotNull(message = "Description cannot be empty")
    @Size(min=3,max = 20,message = "min characters are 3 and maximum characters can be upto 100")
    @Pattern(regexp = "^[^\\s].*$", message = "Description of project must atleast one character")
    private String description;
    @NotNull(message = "start Date cannot be empty")
    private Date startDate;
    @NotNull(message = "end Date cannot be empty")
    private Date endDate;
    @NotNull(message = "status Date cannot be empty")
    @Size(min=3,max = 10,message = "min characters are 3 and maximum characters can be upto 20")
    @Pattern(regexp = "^[^\\s].*$", message = "Status of project must atleast one character")
    private String status;
}

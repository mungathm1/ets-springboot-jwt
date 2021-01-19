package com.midhun.employeetracking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "ets", name = "user_details")
@Getter @Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    @JsonIgnore
    private String role;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("createdDate")
    private Date createdt;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("updatedDate")
    private Date updatedt;
}

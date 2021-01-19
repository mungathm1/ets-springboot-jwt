package com.midhun.employeetracking.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class UserInfoDto {
    private String username;
    private String password;
    private String role;
    private Date createdt;
    private Date updatedt;
}

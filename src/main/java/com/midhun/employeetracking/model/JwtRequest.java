package com.midhun.employeetracking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = -7858869558953243875L;
    private String username;
    private String password;

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

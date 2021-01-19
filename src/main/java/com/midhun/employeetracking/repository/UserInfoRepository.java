package com.midhun.employeetracking.repository;

import com.midhun.employeetracking.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {
    UserInfo findByUsername(String username);
}

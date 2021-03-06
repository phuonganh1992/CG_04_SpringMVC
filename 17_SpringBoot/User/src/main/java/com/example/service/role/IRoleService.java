package com.example.service.role;

import com.example.model.Role;
import com.example.service.IGeneralService;

import java.util.Optional;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}

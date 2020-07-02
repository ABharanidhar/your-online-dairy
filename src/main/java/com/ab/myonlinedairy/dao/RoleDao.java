package com.ab.myonlinedairy.dao;

import com.ab.myonlinedairy.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}

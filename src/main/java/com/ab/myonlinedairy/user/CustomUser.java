package com.ab.myonlinedairy.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3048127094991164381L;
	
	private final int userID;

    public CustomUser(String username, String password,
                      Collection<? extends GrantedAuthority> authorities, int userID) {
        super(username, password, authorities);
        this.userID = userID;
    }

	public int getUserID() {
		return userID;
	}
    
    
}
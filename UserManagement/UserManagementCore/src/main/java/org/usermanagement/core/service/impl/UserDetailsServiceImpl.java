package org.usermanagement.core.service.impl;

import org.model.usermanagement.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.usermanagement.core.component.UserManager;
import org.usermanagement.core.exception.ApplicationException;
import org.usermanagement.core.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 26/9/18
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserManager userManager;

    public UserDetailsServiceImpl() {
    }

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        org.model.usermanagement.User user = null;
        System.out.println("\n\n\n\nLOAD USER BY USERNAME \n" + username);
        try {
            user = this.userManager.getUserByUserName(username);
        } catch (BusinessException b) {
            throw new UsernameNotFoundException(b.getMessage(), b);
        } catch (ApplicationException a) {
            throw new UsernameNotFoundException(a.getMessage(), a);
        }
        if (user == null) {
            System.out.println("NO USER FOUND");
            throw new UsernameNotFoundException("Username not found");
        }
        System.out.println(user);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(org.model.usermanagement.User user) {
        List<GrantedAuthority> authorities = new ArrayList();
        Role role = user.getRole();
        if (role != null) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
}

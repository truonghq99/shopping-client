package com;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import com.model.Staff;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class CustomStaffDetails implements UserDetails {

    private static final long serialVersionUID = 1369212895087214777L;

    Staff staff;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(staff.getPosition());
        System.out.println("day la: "+staff.getPosition());
        System.out.println("authority la: "+authority);
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return staff.getPassword();
    }

    @Override
    public String getUsername() {
        return staff.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

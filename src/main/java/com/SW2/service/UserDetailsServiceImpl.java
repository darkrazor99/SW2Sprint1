package com.SW2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.SW2.enteties.RoleEntity;
import com.SW2.enteties.Userentinty;
import com.SW2.models.Repository;
import com.SW2.models.RoleRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {

	@Autowired
    private Repository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void saveUser(Userentinty user, String role) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RoleEntity userRole = roleRepository.findByName(role);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
	public Userentinty findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	public List<Userentinty> listUsers(){
		return userRepository.findAll();
	}
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userentinty user = userRepository.findByUsername(username);  
        if(user != null) {
            List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }
	 private List<GrantedAuthority> getUserAuthority(Set<RoleEntity> userRoles) {
	        Set<GrantedAuthority> roles = new HashSet<>();
	        userRoles.forEach((role) -> {
	            roles.add(new SimpleGrantedAuthority(role.getName()));
	        });

	        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
	        return grantedAuthorities;
	    }
	 private UserDetails buildUserForAuthentication(Userentinty user, List<GrantedAuthority> authorities) {
	        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
	    }
}

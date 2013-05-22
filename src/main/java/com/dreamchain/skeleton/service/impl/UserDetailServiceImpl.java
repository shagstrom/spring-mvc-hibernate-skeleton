package com.dreamchain.skeleton.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreamchain.skeleton.dao.UserDao;

@Service("userDetailsService") 
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.dreamchain.skeleton.model.User user = userDao.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Not able to find user");
		}
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
		List<GrantedAuthority> grantedAuthorities = Arrays.asList(grantedAuthority);
		return new User(user.getName(), user.getPassword(), grantedAuthorities);
	}
	
}
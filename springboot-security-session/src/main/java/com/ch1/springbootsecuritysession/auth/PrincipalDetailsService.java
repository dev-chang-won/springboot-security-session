package com.ch1.springbootsecuritysession.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ch1.springbootsecuritysession.model.UserSchema;
import com.ch1.springbootsecuritysession.repository.UserRepository;

/*
 * login 요청시 UserDetailsService 타입으로 IoC 된 loadByUsername 함수 호출 ( 기본 ) 
 * */
@Service
public class PrincipalDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	
	/*
	 * 세션의 구조 :: security Session ( Authentication( PricipaDetails impl UserDetails ) ) 
	 * */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserSchema user = userRepository.findByUsername(username);
		if( null != user ) {
			return new PrincipalDetails(user);
		} else {
			return null;
		}
	}
}

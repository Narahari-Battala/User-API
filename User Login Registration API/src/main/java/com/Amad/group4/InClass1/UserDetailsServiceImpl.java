package com.Amad.group4.InClass1;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private UserRepository applicationUserRepository;

    public UserDetailsServiceImpl(UserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByuserId(username);
        if (applicationUser == null) {
            throw new UserNotFoundException(username);
        }
        return new User(applicationUser.getUserId(), applicationUser.getPassword(), emptyList());
    }
}

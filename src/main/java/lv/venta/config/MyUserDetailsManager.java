package lv.venta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import lv.venta.model.MyUser;
import lv.venta.repo.IMyUserRepo;

@Service
public class MyUserDetailsManager implements UserDetailsManager{

	@Autowired
	private IMyUserRepo myUserRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MyUser userFromDataBase = myUserRepo.findByUsername(username);
		
		if(userFromDataBase == null) {
			throw new UsernameNotFoundException(username + " was not found!");
		}
		else {
			MyUserDetails user = new MyUserDetails(userFromDataBase);
			return user;
		}
	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	

}

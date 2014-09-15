package com.vstar.dao.process;

import org.hibernate.HibernateException;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

/**
 * PropUsersDaoProcess
 * 
 */
public class PropUsersDaoProcess
{

	private JdbcUserDetailsManager userDetailsManager;
	private SaltSource saltSource = null;
	private PasswordEncoder passwordEncoder = null;
 
	private UserDetails user;
 
	private boolean accountNonExpired;
	private boolean credentialsNonExpired;
	private boolean accountNonLocked;
 
	public void createUser( String userName,String password, boolean enabled , String userRole)
	{
		
		Object salt = null; 
 
		user = new User( userName, 
						 password, 
						 enabled, 
						 accountNonExpired, 
						 credentialsNonExpired, 
						 accountNonLocked, 
						 AuthorityUtils.createAuthorityList(userRole) );
 
		if( this.saltSource != null )
		{
			salt = this.saltSource.getSalt( user );
		}
 
		// calculate what hashedPassword would be in this configuration
		String hashedPassword = passwordEncoder.encodePassword( user.getPassword(), salt );
 
		// create a new user with the hashed password 
		UserDetails userHashedPassword = new User( userName, 
													 hashedPassword, 
                                    				 enabled, 
                                    				 accountNonExpired, 
                                    				 credentialsNonExpired, 
                                    				 accountNonLocked, 
                                    				 AuthorityUtils.createAuthorityList(userRole)  );
 
		// if the user extists, delete it 
		if( !userDetailsManager.userExists( userHashedPassword.getUsername() ) )
		{
			// Creating user
			userDetailsManager.createUser( userHashedPassword );
			// adding role to created user
			userDetailsManager.addUserToGroup(userName, userRole);
			
		}
 
		
 
	}


  /**
   * 
   * @param PropUsersDaoid
   * @throws HibernateException
   */
  public void deletePropUsersDao(String usersId) throws HibernateException
  {
	  userDetailsManager.deleteUser(usersId);
  }


  /**
   * @param PropUsersDaoid
   * @return
   */
  public UserDetails getPropUsersDaoById(String usersId) throws HibernateException
  {
	  UserDetails userDetails =  userDetailsManager.loadUserByUsername(usersId);
    return userDetails;
  }

  
  public JdbcUserDetailsManager getUserDetailsManager()
  {
  	return userDetailsManager;
  }

	public void setUserDetailsManager(JdbcUserDetailsManager userDetailsManager)
  {
  	this.userDetailsManager = userDetailsManager;
  }

	public SaltSource getSaltSource()
  {
  	return saltSource;
  }

	public void setSaltSource(SaltSource saltSource)
  {
  	this.saltSource = saltSource;
  }

	public PasswordEncoder getPasswordEncoder()
  {
  	return passwordEncoder;
  }

	public void setPasswordEncoder(PasswordEncoder passwordEncoder)
  {
  	this.passwordEncoder = passwordEncoder;
  }

	public boolean isAccountNonExpired()
  {
  	return accountNonExpired;
  }

	public void setAccountNonExpired(boolean accountNonExpired)
  {
  	this.accountNonExpired = accountNonExpired;
  }

	public boolean isCredentialsNonExpired()
  {
  	return credentialsNonExpired;
  }

	public void setCredentialsNonExpired(boolean credentialsNonExpired)
  {
  	this.credentialsNonExpired = credentialsNonExpired;
  }

	public boolean isAccountNonLocked()
  {
  	return accountNonLocked;
  }

	public void setAccountNonLocked(boolean accountNonLocked)
  {
  	this.accountNonLocked = accountNonLocked;
  }


}

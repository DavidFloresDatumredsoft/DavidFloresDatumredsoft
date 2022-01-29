package com.confia.cps.log.view.config;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity*/
public class SecurityConfig /*extends WebSecurityConfigurerAdapter */{
	

	private static final String	LOGIN	= "/login";
	private static final String	INDEX	= "/log/view";
	private static final String	LOGOUT	= "/logout";

	
	/*
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .authorizeRequests()
	      	.antMatchers("/resource/**").permitAll() 
	        .anyRequest().fullyAuthenticated()
	        .and()
	      .formLogin()
	      	.loginPage("/login")
	      	.defaultSuccessUrl("/log/list")
	      	.failureUrl("/login?error=true")
	      	.permitAll()
	      	.and()
	      .logout()
	      	.logoutUrl("/logout")
	      	.logoutSuccessUrl("/login")
	      .permitAll()
	      	;
	  }
/*
	  @Override
	  public void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	      .ldapAuthentication()
	        .userDnPatterns("uid={0},ou=people")
	        .groupSearchBase("ou=groups")
	        .contextSource()
	          .url("ldaps://cofsppdc010.confia.com.sv:636/dc=dflores,dc=com,dc=sv")
	          .and()
	        .passwordCompare()
	          .passwordEncoder(new BCryptPasswordEncoder())
	         .passwordAttribute("Agosto2021.");
	  }

	*/
	
	/*
	 * 
	 * ldaps://cofsppdc010.confia.com.sv:636
		dc=confia,dc=com,dc=sv
		(&(objectCategory=person)(|(memberOf=CN=CMS_Liferay,OU=Jefatura de Tecnologia,OU=Direccion de Operaciones y Tecnologia,DC=confia,DC=com,DC=sv)( memberOf=CN=ISA group,CN=USers,DC=confia,DC=com,DC=sv))(sAMAccountName=@screen_name@))
		(&(objectclass=user)(|(memberOf=CN=CMS_Liferay,OU=Jefatura de Tecnologia,OU=Direccion de Operaciones y Tecnologia,DC=confia,DC=com,DC=sv)(memberOf=CN=ISA group,CN=USers,DC=confia,DC=com,DC=sv)))
	 */
	
	
	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
      	.antMatchers("/resource/**",LOGIN,"/",LOGOUT).permitAll() 
        //.anyRequest().fullyAuthenticated()
        .and()
				//.anyRequest().fullyAuthenticated()
				//.and()
			.formLogin()
			.loginPage(LOGIN)
			.loginProcessingUrl("/appLogin")
			.permitAll()
			.defaultSuccessUrl(INDEX)
			.failureUrl("/login?error=true");
		
		http.logout()
		.logoutRequestMatcher( new AntPathRequestMatcher(LOGOUT))
		.permitAll()
		.logoutSuccessUrl(LOGIN)
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
	.and()
    .rememberMe().key("AFPConfia-CPS")
	.and()
	.sessionManagement()
		.invalidSessionUrl(LOGIN)
		.maximumSessions(1) // se configura el numero de sessiones maxiamas
		.expiredUrl("/login?session=expired");
	}*/
/*
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.ldapAuthentication()
				.userDnPatterns("uid={0},OU=Jefatura de Tecnologia,OU=Direccion de Operaciones y Tecnologia,ou=people")
				.groupSearchBase("ou=groups,CN=USers")
				.contextSource()
					.url("ldaps://cofsppdc010.confia.com.sv:636/dc=confia,dc=com,dc=sv");
				/*	.and()
				.passwordCompare()
					//.passwordEncoder(new BCryptPasswordEncoder())
					.passwordAttribute("userPassword");*/
	//}
	
	/*
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .authorizeRequests()
	        .anyRequest().fullyAuthenticated()
	        .and()
	      .formLogin()
	      	.loginPage( LOGIN )
	        .loginProcessingUrl("/appLogin")
	        .defaultSuccessUrl(INDEX)
	      .and()
	      .logout()
	      	.logoutUrl("/logout") 
	      	.logoutSuccessUrl( LOGIN )
		  .and()
		    .exceptionHandling();
	  }
*//*
	  @Override
	  public void configure(AuthenticationManagerBuilder auth) throws Exception {
		  System.out.println(auth.getDefaultUserDetailsService());
	    auth
	      .ldapAuthentication()
	        .userDnPatterns("uid={0},ou=people")
	        .groupSearchBase("ou=groups")
	        .contextSource()
	          //.url("ldap://localhost:8389/dc=springframework,dc=org")
	          .url("ldaps://cofsppdc010.confia.com.sv:636/dc=confia,dc=com,dc=sv")
	          .and()
	        .passwordCompare()
	          //.passwordEncoder(new BCryptPasswordEncoder())
	          .passwordAttribute("userPassword");
	    
	    
	  }
*/

	
}

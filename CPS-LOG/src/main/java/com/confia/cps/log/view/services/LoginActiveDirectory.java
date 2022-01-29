package com.confia.cps.log.view.services;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginActiveDirectory {
	
	@Value("${cps.ldap.uri}")
	private String LDAP_URI;
	@Value("${cps.dominio.defecto}") private String dominioParametrizado;
	public boolean loginValidate(String username,String password){
		
		//System.out.println(username+" "+password);
		//System.out.println(dominioParametrizado+"\\"+ username.toLowerCase());
		   Hashtable<String, String> env = new Hashtable<String, String>();
		   env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		   env.put(Context.PROVIDER_URL, LDAP_URI);
		   env.put(Context.SECURITY_AUTHENTICATION, "simple");
		   env.put(Context.SECURITY_PRINCIPAL, dominioParametrizado+"\\"+ username.toLowerCase());
		   env.put(Context.SECURITY_CREDENTIALS, password);
		   env.put(Context.REFERRAL, "follow");
		   DirContext ctx = null;
		   try {
		       ctx = new InitialDirContext(env);
		       ctx.getEnvironment();
		   } catch (javax.naming.AuthenticationException e) {
		    System.out.println("AuthenticationException >>>>>> "+e.getMessage());
		       //e.printStackTrace();
		   } catch (javax.naming.NamingException e) {
		       //e.printStackTrace();
		    System.out.println("NamingException >>>>> "+e.getMessage());
		   }
		   /*if (ctx != null) {
		       System.out.println("Username and Password matches in AD.");
		   }*/
		   return ctx != null;
		}
}

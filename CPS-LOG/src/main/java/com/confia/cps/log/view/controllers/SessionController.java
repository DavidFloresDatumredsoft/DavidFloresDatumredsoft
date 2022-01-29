package com.confia.cps.log.view.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.confia.cps.log.view.commands.LoginForm;
import com.confia.cps.log.view.domain.PermisoRol;
import com.confia.cps.log.view.domain.type.EEstadoPermisoRol;
import com.confia.cps.log.view.services.LoginActiveDirectory;
import com.confia.cps.log.view.services.PermisoRolService;


@Controller
public class SessionController {
	
	@Autowired private LoginActiveDirectory ads;
	@Autowired private PermisoRolService permisoRolService;
	@Value("${cps.rol.root.nombre}") private String rootRolApp;
	
	
    @GetMapping( path = { "/","/login"})
    public String login(Model model){
    	model.addAttribute("form", new LoginForm());
        return "/login";
    }

    @PostMapping( path = { "/login"})
    public String index(HttpSession session, 
    					Model model, @ModelAttribute LoginForm loginForm) {
    	
    	if(loginForm == null ) {
    		return "/login";
    	}
    	
    	boolean usuarioValido =ads.loginValidate(loginForm.getUsuario(), loginForm.getPassword());
    	String mensaje = null;
    	
    	if( usuarioValido ) {
    		
    		session.setAttribute("userSession", loginForm.getUsuario());
    			
    		//String usuario = loginForm.getUsuario();
    		
    		PermisoRol permisoRol = permisoRolService.findUserAd(loginForm.getUsuario().toLowerCase());
    		if( permisoRol == null ) {
    			mensaje = "Usuario no existe en cassandra";
    		}else {
    			
    			if(permisoRol.getEstado().equals(EEstadoPermisoRol.ACTIVO.toString())) {
	    			session.setAttribute("rol", permisoRol.getNombreRol());
	        		session.setAttribute("userRol", loginForm.getUsuario());
	        		return "redirect:/log/view";
	    		}else {
	    			mensaje = "Usuario no esta activo en cassandra.";
	    		}
    			
    		}
	    		
    	}else {
    		mensaje = "Usuario no es valido.";
    	}
    	
        return "redirect:/login?error="+mensaje;
    }

    @RequestMapping( path = { "/logout"})
    public String logout(HttpSession session, Model model) {
    	session.invalidate();
    	return "redirect:/login";
    }
    

    @ModelAttribute("rootRolApp")
    public String getRootRolApp(){
    	return this.rootRolApp;
    }
}

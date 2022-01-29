package com.confia.cps.log.view.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.confia.cps.log.view.commands.PermisoRolForm;
import com.confia.cps.log.view.converters.PermisoRolToPermisoRolForm;
import com.confia.cps.log.view.domain.PermisoRol;
import com.confia.cps.log.view.domain.Rol;
import com.confia.cps.log.view.services.PermisoRolService;
import com.confia.cps.log.view.services.RolService;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

@Controller
@RequestMapping("permiso-rol")
public class PermisoRolController {
	
    private PermisoRolService service;
    
    @Autowired private RolService rolService; 
    @Value("${cps.rol.root.nombre}")
    private String rootRolApp;
    
    private PermisoRolToPermisoRolForm permisoRolToPermisoRolForm;

    @Autowired
    public void setLogToLogForm(PermisoRolToPermisoRolForm permisoRolToPermisoRolForm) {
        this.permisoRolToPermisoRolForm = permisoRolToPermisoRolForm;
    }

    @Autowired
    public void setLogService(PermisoRolService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/permiso-rol/list";
    }

    @RequestMapping({"/list", "/rol"})
    public String listPermisosRoles(Model model){
        model.addAttribute("permisos", service.listAll());
        return "permiso-rol/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable UUID id, Model model){
    	PermisoRol rol = service.getById(id);
    	PermisoRolForm form = permisoRolToPermisoRolForm.convert(rol);

        model.addAttribute("permisoRolForm", form);
        return "permiso-rol/form";
    }

    @RequestMapping("/new")
    public String newRol(Model model){
        model.addAttribute("permisoRolForm", new PermisoRolForm());
        return "permiso-rol/form";
    }

    @PostMapping(value = "/permiso-rol")
    public String saveOrUpdateRol(@Valid PermisoRolForm form, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "permiso-rol/form";
        }

        PermisoRol saved = null;
        
	        if( form.getId() == null ) {
	        	form.setId(UUID.randomUUID());
	        	
	        	saved = service.findUserAd(form.getUsuarioAD().toLowerCase());
	        	
	        	if( saved != null ) {  
	        		model.addAttribute("permisoRolForm", new PermisoRolForm());
	            	return "redirect:/permiso-rol/new?error=Usuario ya existe";
	            }
	        }
	      
	        saved = service.saveOrUpdatePermisoRolForm(form);
    
        return "redirect:/permiso-rol/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable UUID id){
    	service.delete(id);
        return "redirect:/permiso-rol/list";
    }
    
    @ModelAttribute("rolesDisponibles")
    public List<Rol> roles(){
    	
    	return rolService.listAll();
    }
    
    @ModelAttribute("rootRolApp")
    public String getRootRolApp(){
    	return this.rootRolApp;
    }    
}

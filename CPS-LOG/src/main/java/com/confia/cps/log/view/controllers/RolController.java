package com.confia.cps.log.view.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.confia.cps.log.view.commands.RolForm;
import com.confia.cps.log.view.converters.RolToRolForm;
import com.confia.cps.log.view.domain.Rol;
import com.confia.cps.log.view.services.RolService;

import java.util.UUID;

import javax.validation.Valid;

@Controller
@RequestMapping("rol")
public class RolController {
    private RolService service;

    private RolToRolForm rolToRolForm;
    @Value("${cps.rol.root.nombre}")
    private String rootRolApp;

    private static final String URI_FORM="rol/form";
    
    
    @Autowired
    public void setLogToLogForm(RolToRolForm rolToRolForm) {
        this.rolToRolForm = rolToRolForm;
    }

    @Autowired
    public void setLogService(RolService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String redirToList(){
        return "redirect:/rol/list";
    }

    @GetMapping({"/list", "/rol"})
    public String listRoles(Model model){
        model.addAttribute("roles", service.listAll());
        return "rol/list";
    }

    @GetMapping("/show/{id}")
    public String getRol(@PathVariable UUID id, Model model){
        model.addAttribute("rol", service.getById(id));
        return "rol/show";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable UUID id, Model model){
        Rol rol = service.getById(id);
        RolForm form = rolToRolForm.convert(rol);

        model.addAttribute("rolform", form);
        return URI_FORM;
    }

    @RequestMapping("/new")
    public String newRol(Model model){
        model.addAttribute("rolform", new RolForm());
        return URI_FORM;
    }

    @PostMapping(value = "/rol")
    public String saveOrUpdateRol(@Valid RolForm form, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return URI_FORM;
        }

        if( form.getCodigoRol() == null ) {
        	form.setCodigoRol(UUID.randomUUID());
        }
        
        Rol saved = service.saveOrUpdateRolForm(form);

        //return "redirect:/rol/show/" + saved.getCodigoRol();
        return "redirect:/rol/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable UUID id){
    	service.delete(id);
        return "redirect:/rol/list";
    }
    
    @ModelAttribute("rootRolApp")
    public String getRootRolApp(){
    	return this.rootRolApp;
    }
}

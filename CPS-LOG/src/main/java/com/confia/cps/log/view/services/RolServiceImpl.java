package com.confia.cps.log.view.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.confia.cps.log.view.commands.RolForm;
import com.confia.cps.log.view.converters.RolFormToRol;
import com.confia.cps.log.view.domain.Rol;
import com.confia.cps.log.view.repositories.RolRepository;

@Service
public class RolServiceImpl implements RolService{

	 private RolRepository repo;
	    private RolFormToRol rolFormToRol;

	    @Autowired
	    public RolServiceImpl(RolRepository repo, RolFormToRol rolFormToRol) {
	        this.repo = repo;
	        this.rolFormToRol = rolFormToRol;
	    }


	    @Override
	    public List<Rol> listAll() {
	        List<Rol> logs = new ArrayList<>();
	        repo.findAll().forEach(logs::add);
	        return logs;
	    }

	    @Override
	    public Rol getById(UUID id) {
	        return repo.findById(id).orElse(null);
	    }

	    @Override
	    public Rol saveOrUpdate(Rol entity) {
	    	
	        repo.save(entity);
	        return entity;
	    }

	    @Override
	    public void delete(UUID id) {
	        repo.deleteById(id);

	    }

	    @Override
	    public Rol saveOrUpdateRolForm(RolForm form) {
	    	
	    	
	        Rol savedEntity = saveOrUpdate(rolFormToRol.convert(form));

	        System.out.println("Saved Product Id: " + savedEntity.getCodigoRol());
	        return savedEntity;
	    }
}

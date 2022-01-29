package com.confia.cps.log.view.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import com.confia.cps.log.view.commands.PermisoRolForm;
import com.confia.cps.log.view.converters.PermisoRolFormToPermisoRol;
import com.confia.cps.log.view.domain.PermisoRol;
import com.confia.cps.log.view.repositories.PermisoRolRepository;

@Service
public class PermisoRolServiceImpl implements PermisoRolService {

	private PermisoRolRepository repo;
    private PermisoRolFormToPermisoRol permisoRolFormToPermisoRol;
    @Autowired private CassandraOperations cassandraTemplate; 
    @Autowired
    public PermisoRolServiceImpl(PermisoRolRepository repo, PermisoRolFormToPermisoRol permisoRolFormToPermisoRol) {
        this.repo = repo;
        this.permisoRolFormToPermisoRol = permisoRolFormToPermisoRol;
    }


    @Override
    public List<PermisoRol> listAll() {
        List<PermisoRol> logs = new ArrayList<>();
        repo.findAll().forEach(logs::add);
        return logs;
    }

    @Override
    public PermisoRol getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public PermisoRol saveOrUpdate(PermisoRol entity) {
        repo.save(entity);
        return entity;
    }

    @Override
    public void delete(UUID id) {
        repo.deleteById(id);

    }

    @Override
    public PermisoRol saveOrUpdatePermisoRolForm(PermisoRolForm form) {
    	PermisoRol entity = saveOrUpdate(permisoRolFormToPermisoRol.convert(form));
    	 entity.setUsuarioAD(entity.getUsuarioAD().toLowerCase());
    	 entity = saveOrUpdate( entity );
        return entity;
    }


	@Override
	public PermisoRol findUserAd(String usuarioAD) {
		
		String query = "SELECT * FROM permisos_roles_aud_ad WHERE usuarioad='"+usuarioAD.toLowerCase()+"' allow filtering";
		PermisoRol  rol = cassandraTemplate.selectOne( query, PermisoRol.class );
        
		return rol; 
	}

}

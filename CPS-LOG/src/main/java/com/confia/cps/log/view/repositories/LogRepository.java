package com.confia.cps.log.view.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.confia.cps.log.view.domain.LogView;

public interface LogRepository extends CrudRepository<LogView, UUID> {
	
	
	
}

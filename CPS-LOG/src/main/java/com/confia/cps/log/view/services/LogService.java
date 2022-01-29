package com.confia.cps.log.view.services;

import java.util.List;
import java.util.UUID;

import com.confia.cps.log.view.commands.LogForm;
import com.confia.cps.log.view.domain.LogView;

public interface LogService extends BasicService<LogView, UUID> {
	LogView saveOrUpdateLogForm(LogForm logForm);
	List<LogView> findIdentificacionFordocumentoIdAndTipoDocumentoId(String documentoId,String tipoDocumentoId);
}

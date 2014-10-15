package com.proint1.udea.actividad.ngc;

import java.io.Serializable;
import java.util.List;

import com.proint1.udea.actividad.dao.OperacionesSumaryGruposDAO;
import com.proint1.udea.actividad.dao.RegistrarActividadDTO;
import com.proint1.udea.actividad.entidades.TipoActividad;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;

/**
 * Sumario de grupos
 * @author Juan Cardona
 * @since 23/06/2014
 */
public class ActDocenteGrupoNgc implements OperacionesSumaryGruposInterfaceDAO,Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1083490161411151301L;
	
	OperacionesSumaryGruposDAO operacionesSumaryGruposDAO;
	
	@Override
	public List<SumaryGruposDTO> getSumariGrupoDTOPorDocenteIdn(long idnDocente) {
		return operacionesSumaryGruposDAO.getSumariGrupoDTOPorDocenteIdn(idnDocente);
	}
	

	@Override
	public List<RegistrarActividadDTO> getActividadesList(long idnDOG) {
		return operacionesSumaryGruposDAO.getActividadesList(idnDOG);
	}

	/**
	 * @return the operacionesSumaryGruposDAO
	 */
	public OperacionesSumaryGruposDAO getOperacionesSumaryGruposDAO() {
		return operacionesSumaryGruposDAO;
	}

	/**
	 * @param operacionesSumaryGruposDAO the operacionesSumaryGruposDAO to set
	 */
	public void setOperacionesSumaryGruposDAO(
			OperacionesSumaryGruposDAO operacionesSumaryGruposDAO) {
		this.operacionesSumaryGruposDAO = operacionesSumaryGruposDAO;
	}


	@Override
	public List<TipoActividad> getTipoActividadesList() {
		return operacionesSumaryGruposDAO.getTipoActividadesList();
	}


	@Override
	public void guardarActividad(RegistrarActividadDTO dto) {
		operacionesSumaryGruposDAO.guardarActividad(dto);
		
	}


	@Override
	public void actualizarActividad(RegistrarActividadDTO registrarActividadDTO) {
		operacionesSumaryGruposDAO.actualizarActividad(registrarActividadDTO);
	}


	@Override
	public void eliminarActividad(long idn) {
		operacionesSumaryGruposDAO.eliminarActividad(idn);
	}

}

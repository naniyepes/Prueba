package com.proint1.udea.actividad.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.actividad.entidades.DocenteGrupo;
import com.proint1.udea.actividad.entidades.ReporteActividad;
import com.proint1.udea.actividad.ngc.OperacionesSumaryGruposInterfaceDAO;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;

/**
 * DAO de persistencia para la entyidad {@link OperacionesSumaryGruposDAO}
 * @author Juan Cardona
 * @since 16/05/2014
 */
public class OperacionesSumaryGruposDAO extends HibernateDaoSupport implements OperacionesSumaryGruposInterfaceDAO{

	
	
	@Override
	public List<SumaryGruposDTO> getSumariGrupoDTOPorDocenteIdn(long idnDocente) {
		
		ArrayList<SumaryGruposDTO> sumaryGruposDTOList = new ArrayList<SumaryGruposDTO>();
		
		String hql = "Select dog from DocenteGrupo dog where docenteIdn=:parDocenteIdn";
		Query query = getSession().createQuery(hql);
		query.setParameter("parDocenteIdn", idnDocente);
		
		List<DocenteGrupo> docenteGrupoList = (ArrayList<DocenteGrupo>) query.list();
		
		for (DocenteGrupo docenteGrupo : docenteGrupoList) {
			SumaryGruposDTO sumaryGruposDTO = new SumaryGruposDTO();
			sumaryGruposDTO.setIdn(docenteGrupo.getIdn());
			sumaryGruposDTO.setNombreDependencia(docenteGrupo.getGrupo().getSemestreCurso().getSemestre().getDependenciaAcademica().getNombre());
			sumaryGruposDTO.setSemestre(docenteGrupo.getGrupo().getSemestreCurso().getSemestre().getAgno() + "-" + docenteGrupo.getGrupo().getSemestreCurso().getSemestre().getPeriodo());
			sumaryGruposDTO.setCodigoCurso(docenteGrupo.getGrupo().getSemestreCurso().getCurso().getIdCurso());
			sumaryGruposDTO.setNombreCurso(docenteGrupo.getGrupo().getSemestreCurso().getCurso().getNombre());
			sumaryGruposDTO.setModalidadCurso(docenteGrupo.getGrupo().getSemestreCurso().getModalidadCurso().getDescripcion());
			sumaryGruposDTO.setGrupoNumero(docenteGrupo.getGrupo().getNumeroGrupo());
			sumaryGruposDTO.setHorario(docenteGrupo.getGrupo().getHorario());
			sumaryGruposDTOList.add(sumaryGruposDTO);
		}
		
		return sumaryGruposDTOList;
	}

	@Override
	public List<RegistrarActividadDTO> getRegistrarActividadDTO(long idnDOG) {

		ArrayList<RegistrarActividadDTO> regActividadDTOList = new ArrayList<RegistrarActividadDTO>();
		
		String hql = "Select dog from ReporteActividad dog where docenteGrupoIdn=:parIdnDOG";
		Query query = getSession().createQuery(hql);
		query.setParameter("parIdnDOG", idnDOG);
		
		List<ReporteActividad> reporteActividadList = (ArrayList<ReporteActividad>) query.list();
		
		for (ReporteActividad reporteActividad : reporteActividadList) {
			RegistrarActividadDTO regActividadDTO = new RegistrarActividadDTO();
			regActividadDTO.setIdnDOG(reporteActividad.getDocenteGrupoIdn());
			regActividadDTO.setNombreTipo(reporteActividad.getTipoActividad().getNombre());
			regActividadDTO.setFecha(reporteActividad.getFechaRegistro());
			regActividadDTO.setDescripcion(reporteActividad.getDescripcionActividad());
			regActividadDTOList.add(regActividadDTO);
		}
		
		return regActividadDTOList;
	}
}
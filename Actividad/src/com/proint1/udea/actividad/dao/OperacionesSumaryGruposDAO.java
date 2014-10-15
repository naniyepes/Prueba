package com.proint1.udea.actividad.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.actividad.entidades.DocenteGrupo;
import com.proint1.udea.actividad.entidades.ReporteActividad;
import com.proint1.udea.actividad.entidades.TipoActividad;
import com.proint1.udea.actividad.ngc.OperacionesSumaryGruposInterfaceDAO;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;

/**
 * DAO de persistencia para la entyidad {@link OperacionesSumaryGruposDAO}
 * @author Juan Cardona
 * @since 16/05/2014
 */
public class OperacionesSumaryGruposDAO extends HibernateDaoSupport implements OperacionesSumaryGruposInterfaceDAO{

	
	/**Dao para operaciones de reporte de actividades**/
	private ReporteActividadDAO reporteActividadDAO;
	
	
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
	public List<RegistrarActividadDTO> getActividadesList(long idnDOG) {

		ArrayList<RegistrarActividadDTO> regActividadDTOList = new ArrayList<RegistrarActividadDTO>();
		String hql = "Select dog from ReporteActividad dog where docenteGrupoIdn=:parIdnDOG";
		Query query = getSession().createQuery(hql);
		query.setParameter("parIdnDOG", idnDOG);
		
		List<ReporteActividad> reporteActividadList = (ArrayList<ReporteActividad>) query.list();
		for (ReporteActividad reporteActividad : reporteActividadList) {
			RegistrarActividadDTO regActividadDTO = new RegistrarActividadDTO();
			regActividadDTO.setIdn(reporteActividad.getIdn());
			regActividadDTO.setIdnDOG(reporteActividad.getDocenteGrupoIdn());
			regActividadDTO.setNombreTipo(reporteActividad.getTipoActividad().getNombre());
			regActividadDTO.setFecha(reporteActividad.getFechaRegistro());
			regActividadDTO.setDescripcion(reporteActividad.getDescripcionActividad());
			regActividadDTOList.add(regActividadDTO);
		}
		return regActividadDTOList;
	}

	@Override
	public List<TipoActividad> getTipoActividadesList() {
		String hql = "Select ta from TipoActividad ta";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	@Override
	public void guardarActividad(RegistrarActividadDTO registrarActividadDTO) {
		ReporteActividad reporteActividad = new ReporteActividad();
		reporteActividad.setDocenteGrupoIdn(registrarActividadDTO.getIdnDOG());
		reporteActividad.setFechaRegistro(registrarActividadDTO.getFecha());
		reporteActividad.setTipoActividad(registrarActividadDTO.getTipoActividad());
		reporteActividad.setTipoActividadIdn(registrarActividadDTO.getTipoActividad().getNbTacIdn());
		reporteActividad.setDescripcionActividad(registrarActividadDTO.getDescripcion());
		reporteActividad.setTiempo(0);
		getReporteActividadDAO().crearReporteActividad(reporteActividad);
	}

	@Override
	public void actualizarActividad(RegistrarActividadDTO registrarActividadDTO) {
		ReporteActividad reporteActividad = getReporteActividadDAO().buscarPorIdn(registrarActividadDTO.getIdn());
		reporteActividad.setFechaRegistro(registrarActividadDTO.getFecha());
		reporteActividad.setTipoActividad(registrarActividadDTO.getTipoActividad());
		reporteActividad.setTipoActividadIdn(registrarActividadDTO.getTipoActividad().getNbTacIdn());
		reporteActividad.setDescripcionActividad(registrarActividadDTO.getDescripcion());
		reporteActividad.setTiempo(0);
		getReporteActividadDAO().actualizarReporteActividad(reporteActividad);
	}

	
	public ReporteActividadDAO getReporteActividadDAO() {
		return reporteActividadDAO;
	}

	public void setReporteActividadDAO(ReporteActividadDAO reporteActividadDAO) {
		this.reporteActividadDAO = reporteActividadDAO;
	}

	@Override
	public void eliminarActividad(long idn) {
		String hql = "Delete from ReporteActividad where idn=:idn";
		Query query = getSession().createQuery(hql);
		query.setParameter("idn", idn);
		query.executeUpdate();
	}

}

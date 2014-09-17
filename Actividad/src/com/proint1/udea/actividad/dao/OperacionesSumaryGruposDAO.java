package com.proint1.udea.actividad.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.actividad.entidades.DocenteGrupo;
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
			sumaryGruposDTO.setNombreDependencia(docenteGrupo.getGrupo().getSemestreCurso().getSemestre().getDependenciaAcademica().getNombre());
			sumaryGruposDTO.setSemestre(docenteGrupo.getGrupo().getSemestreCurso().getSemestre().getAgno() + "-" + docenteGrupo.getGrupo().getSemestreCurso().getSemestre().getPeriodo());
			sumaryGruposDTO.setCodigoCurso(docenteGrupo.getGrupo().getSemestreCurso().getCurso().getIdCurso());
			sumaryGruposDTO.setNombreCurso(docenteGrupo.getGrupo().getSemestreCurso().getCurso().getNombre());
			sumaryGruposDTO.setModalidadCurso(docenteGrupo.getGrupo().getSemestreCurso().getModalidadCurso().getDescripcion());
			sumaryGruposDTO.setGrupoNumero(docenteGrupo.getGrupo().getNumeroGrupo());
			sumaryGruposDTO.setHorario(docenteGrupo.getGrupo().getHorario());
			sumaryGruposDTO.setTotalTiempoHoras(docenteGrupo.getTiempoTotal());
			sumaryGruposDTOList.add(sumaryGruposDTO);
		}
		
		return sumaryGruposDTOList;
	}
	
	
	@Override
	public List<SumaryGruposDTO> getSumariGrupoDTOPorDocenteIdnNativo(long idnDocente) {

		ArrayList<SumaryGruposDTO> sumaryGruposDTOList = new ArrayList<SumaryGruposDTO>();

		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		sql.append("PER.VR_PER_NOMBRECOMPLETO AS DOCENTE, ");
		sql.append("DEA.VR_DEP_NOMBRE AS DEPENDENCIA, ");
		sql.append("SEM.NB_SEM_AGNO AS AGNO, ");
		sql.append("SEM.NB_SEM_PERIODO AS SEMESTRE, ");
		sql.append("CURSO.VR_CUR_ID AS CODIGO_CURSO, ");
		sql.append("CURSO.VR_CUR_NOMBRE AS NOMBRE_CURSO, ");
		sql.append("MOC.VR_MCU_DESCRIPCION AS MODALIDAD_CURSO, ");
		sql.append("GR.VR_GPO_NUMERO AS GRUPO_NUMERO, ");
		sql.append("GR.VR_GPO_HORARIO AS HORARIO, ");
		sql.append("DG.NB_DOG_TIEMPOTOTAL AS TOTAL_TIEMPO ");
		sql.append("FROM TB_ACT_DOCENTEXGRUPO DG ");
		sql.append("INNER JOIN TB_ADM_GRUPO GR ON DG.NB_GPO_IDN = GR.NB_GPO_IDN "); 
		sql.append("INNER JOIN TB_ADM_SEMESTREXCURSO SEC ON SEC.NB_SCU_IDN = GR.NB_SCU_IDN ");
		sql.append("INNER JOIN TB_ADM_MODALIDAD_CURSO MOC ON MOC.VR_MCU_IDN = SEC.VR_MCU_IDN ");
		sql.append("INNER JOIN TB_ADM_CURSO CURSO ON CURSO.NB_CUR_IDN = SEC.NB_CUR_IDN ");
		sql.append("INNER JOIN TB_ADM_SEMESTRE SEM ON SEM.NB_SEM_IDN = SEC.NB_SCU_IDN ");
		sql.append("INNER JOIN TB_ADM_ESTADO_SEMESTRE ESTS ON ESTS.VR_ESM_CODIGO = SEM.VR_ESM_CODIGO ");
		sql.append("INNER JOIN TB_ADM_DEPENDENCIA_ACADEMICA DEA ON DEA.NB_DEP_IDN = SEM.NB_DEP_IDN ");
		sql.append("INNER JOIN TB_ADM_DOCENTE DOC ON DG.NB_DOC_IDN = DOC.NB_DOC_IDN ");
		sql.append("INNER JOIN TB_ADM_PERSONA PER ON DOC.NB_DOC_IDN = PER.NB_PER_IDN ");
		sql.append(" where DOC.NB_DOC_IDN =" + idnDocente);
		Query query = getSession().createSQLQuery(sql.toString());

		List<Object[]> docenteGrupoList = query.list();

		for (Object[] registro : docenteGrupoList) {
		
			SumaryGruposDTO sumaryGruposDTO = new SumaryGruposDTO();
			sumaryGruposDTO.setNombreDependencia(registro[1].toString());
			sumaryGruposDTO.setSemestre(registro[2].toString());
			sumaryGruposDTO.setCodigoCurso(registro[3].toString());
			sumaryGruposDTO.setNombreCurso(registro[4].toString());
			sumaryGruposDTO.setModalidadCurso(registro[5].toString());
			sumaryGruposDTO.setGrupoNumero(registro[6].toString());
			sumaryGruposDTO.setHorario(registro[7].toString());
			sumaryGruposDTO.setTotalTiempoHoras((Double) registro[8]);
			sumaryGruposDTOList.add(sumaryGruposDTO);
		}

		return sumaryGruposDTOList;
	}
	

}

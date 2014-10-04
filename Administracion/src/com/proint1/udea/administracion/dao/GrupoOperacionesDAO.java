package com.proint1.udea.administracion.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.proint1.udea.administracion.dao.GrupoDTO;
import com.proint1.udea.actividad.entidades.DocenteGrupo;
import com.proint1.udea.administracion.ngc.CursoIntDAO;
import com.proint1.udea.administracion.ngc.CursoOperacionesIntDAO;
import com.proint1.udea.administracion.ngc.GrupoOperacionesIntDAO;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.academico.Grupo;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;

/**
 * DAO de persistencia para la entidad AdmGrupo
 * @author Daniela Yepes -  Danilo Mejía
 * @since 19/09/2014
 */

public class GrupoOperacionesDAO extends HibernateDaoSupport implements GrupoOperacionesIntDAO {

	@Override
	public List<GrupoDTO> getGrupoList() {

		//		String hql = "Select Curso.idCurso, Curso.nombre, DependenciaAcademica.nombre from Curso cr, DependenciaAcademica dep  where Curso.dependenciaAcademicaIDN = DependenciaAcademica.idn";
		String hql = "Select gru from Grupo gru";
		Query query = getSession().createQuery(hql);
		List<Grupo> response = (ArrayList<Grupo>) query.list();

		List <GrupoDTO> grupoListDTO = new ArrayList<GrupoDTO>();
		for (Grupo grupo : response) {
			GrupoDTO dto = new GrupoDTO();
			dto.setAgno(grupo.getSemestreCurso().getSemestre().getAgno());
			dto.setPeriodo(grupo.getSemestreCurso().getSemestre().getPeriodo());
			dto.setIdCurso(grupo.getSemestreCurso().getCurso().getIdCurso());
			dto.setNombre(grupo.getSemestreCurso().getCurso().getNombre());
			dto.setNumeroGrupo(grupo.getNumeroGrupo());
			dto.setHorario(grupo.getHorario());
			grupoListDTO.add(dto);
		}		
		return grupoListDTO;
	}

	
	@Override
	public String almacenarGrupo(GrupoDTO grupoDTO){

		Curso curso = new Curso();		
		//curso.setDependenciaAcademicaIDN(grupoDTO.getIdnDependencia());
		curso.setIdCurso(grupoDTO.getIdCurso());
		curso.setNombre(grupoDTO.getNombre());			
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(curso);			
			tx.commit();
			return "OK";
		}catch(HibernateException e){
			tx.rollback();
			throw e;
		}
	}

	@Override
	public List<GrupoDTO> buscarGrupo(String idGrupo){

		ArrayList<Curso> cursosList = new ArrayList<Curso>();

		String hql = "Select dog from Curso dog where idCurso=:parCursoIdn";
		Query query = getSession().createQuery(hql);
		query.setParameter("parCursoIdn", idGrupo);

		List<GrupoDTO> cursoGrupoList = (ArrayList<GrupoDTO>) query.list();

		return cursoGrupoList;

	}

	@Override
	public void eliminarGrupo(GrupoDTO grupoDTO){
		
		String hql = "delete from Curso where idn=:parCursoIdn";
		Query query = getSession().createQuery(hql);
		query.setParameter("parCursoIdn", grupoDTO.getIdn());
		query.executeUpdate();			

	}

	@Override
	public void editarGrupo(GrupoDTO grupoDTO){
//		
		String hql = "update from Curso set idCurso = ?, nombre = ?, dependenciaAcademicaIDN = ? where idn= ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, grupoDTO.getIdCurso());
		//query.setParameter(1, grupoDTO.getNombreCurso());
		//query.setParameter(2, grupoDTO.getIdnDependencia());
		query.setParameter(3,  grupoDTO.getIdn());
		query.executeUpdate();

	}

/*	@Override
	public List<DependenciaAcademica> getDependenciaList() {

		String hql = "Select dep from DependenciaAcademica dep";
		Query query = getSession().createQuery(hql);
		List<DependenciaAcademica> response = (ArrayList<DependenciaAcademica>) query.list();			
		return response;
	}*/


}

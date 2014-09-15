package com.proint1.udea.administracion.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.proint1.udea.actividad.entidades.DocenteGrupo;
import com.proint1.udea.administracion.ngc.CursoIntDAO;
import com.proint1.udea.administracion.ngc.CursoOperacionesIntDAO;
import com.proint1.udea.administracion.dto.SumaryGruposDTO;
import com.proint1.udea.administracion.entidades.academico.Curso;
import com.proint1.udea.administracion.entidades.dependencias.DependenciaAcademica;

/**
 * DAO de persistencia para la entidad AdmCurso
 * @author Daniela Yepes
 * @since 25/05/2014
 */

public class CursoOperacionesDAO extends HibernateDaoSupport implements CursoOperacionesIntDAO {

	@Override
	public List<CursoDTO> getCursoList() {

		//		String hql = "Select Curso.idCurso, Curso.nombre, DependenciaAcademica.nombre from Curso cr, DependenciaAcademica dep  where Curso.dependenciaAcademicaIDN = DependenciaAcademica.idn";
		String hql = "Select cur from Curso cur";
		Query query = getSession().createQuery(hql);
		List<Curso> response = (ArrayList<Curso>) query.list();

		List <CursoDTO> cursoListDTO = new ArrayList<CursoDTO>();
		for (Curso curso : response) {
			CursoDTO dto = new CursoDTO();
			dto.setNombreDependencia(curso.getDependenciaAcademica().getNombre());
			dto.setIdCurso(curso.getIdCurso());
			dto.setIdn(curso.getIdn());
			dto.setNombreCurso(curso.getNombre());
			cursoListDTO.add(dto);
		}		
		return cursoListDTO;
	}

	@Override
	public List<DependenciaAcademica> getDependenciaList() {

		String hql = "Select dep from DependenciaAcademica dep";
		Query query = getSession().createQuery(hql);
		List<DependenciaAcademica> response = (ArrayList<DependenciaAcademica>) query.list();			
		return response;
	}

	@Override
	public String almacenarCurso(CursoDTO cursoDTO){

		Curso curso = new Curso();		
		curso.setDependenciaAcademicaIDN(cursoDTO.getIdnDependencia());
		curso.setIdCurso(cursoDTO.getIdCurso());
		curso.setNombre(cursoDTO.getNombreCurso());			
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
	public List<CursoDTO> buscarCurso(String idCurso){

		ArrayList<Curso> cursosList = new ArrayList<Curso>();

		String hql = "Select dog from Curso dog where idCurso=:parCursoIdn";
		Query query = getSession().createQuery(hql);
		query.setParameter("parCursoIdn", idCurso);

		List<CursoDTO> cursoGrupoList = (ArrayList<CursoDTO>) query.list();

		return cursoGrupoList;

	}

	@Override
	public void eliminarCurso(CursoDTO cursoDTO){
		
		String hql = "delete from Curso where idn=:parCursoIdn";
		Query query = getSession().createQuery(hql);
		query.setParameter("parCursoIdn", cursoDTO.getIdn());
		query.executeUpdate();			

	}

	@Override
	public void editarCurso(CursoDTO cursoDTO){
//		
		String hql = "update from Curso set idCurso = ?, nombre = ?, dependenciaAcademicaIDN = ? where idn= ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, cursoDTO.getIdCurso());
		query.setParameter(1, cursoDTO.getNombreCurso());
		query.setParameter(2, cursoDTO.getIdnDependencia());
		query.setParameter(3,  cursoDTO.getIdn());
		query.executeUpdate();

	}



}

package com.proint1.udea.actividad.reportes;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import com.proint1.udea.actividad.TbActReporteDcteGralTemp;

public class DataSetDocente implements JRDataSource {

	private List<TbActReporteDcteGralTemp> lista = new ArrayList<TbActReporteDcteGralTemp>();
	private int indicador = -1;

	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		Object resultado = "";
		
		if("vrMcuDescripcion".equals(arg0.getName())){
			resultado = lista.get(indicador).getVrMcuDescripcion();
		}
		
		if("nbVpeIdn".equals(arg0.getName())){
			resultado = lista.get(indicador).getNbVpeIdn();
		}
		
		if("nbSemAgno".equals(arg0.getName())){
			resultado = lista.get(indicador).getNbSemAgno();
		}
		
		if("nbSemPeriodo".equals(arg0.getName())){
			resultado = lista.get(indicador).getNbSemPeriodo();
		}
		
		if("vrCurNombre".equals(arg0.getName())){
			resultado = lista.get(indicador).getVrCurNombre();
		}
		
		if("vrGpoNumero".equals(arg0.getName())){
			resultado = lista.get(indicador).getVrGpoNumero();
		}
		
		if("vrTacNombre".equals(arg0.getName())){
			resultado = lista.get(indicador).getVrTacNombre();
		}
		
		if("dtAdtfecha".equals(arg0.getName())){
			resultado = lista.get(indicador).getDtAdtfecha();
		}
		
		if("vrPerNombres".equals(arg0.getName())){
			resultado = lista.get(indicador).getVrPerNombres();
		}
		
		if("vrPerApellidos".equals(arg0.getName())){
			resultado = lista.get(indicador).getVrPerApellidos();
		}
		
		return resultado;
	}

	public void setLista(List lista) {
		this.lista = lista;
	}

	@Override
	public boolean next() throws JRException {
		indicador++;
		return indicador < lista.size();
	}

}

package com.proint1.udea.actividad.ngc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import com.proint1.udea.actividad.dao.RegistrarActividadDTO;
import com.proint1.udea.actividad.dao.ReportePersonalDAO;

import com.proint1.udea.actividad.reportes.FormatoActividad;
import com.proint1.udea.actividad.reportes.Resumen;

/**
 * @author Jhan  Farley Restrepo
 * @version 1.0.0
 *
 */
public class ReportePersonalNgc implements ReportePersonalInt {
	
	
	ReportePersonalDAO reportePersonalDAO;
	private static Logger logger = Logger.getLogger(ReportePersonalNgc.class);
	
	public ReportePersonalDAO getReportePersonalDAO() {
		return reportePersonalDAO;
	}


	public void setReportePersonalDAO(ReportePersonalDAO reportePersonalDAO) {
		this.reportePersonalDAO = reportePersonalDAO;
	}
	
	
	@Override
	public byte[] generarInforme(ArrayList<FormatoActividad> lista, int a) throws JRException {
		// TODO Auto-generated method stub
	//	System.out.println("hola");
		String path = null;
		
		
		JasperCompileManager.compileReportToFile("C:\\Users\\danilo\\Desktop\\RegistroAct17oct\\Prueba\\Actividad\\src\\com\\proint1\\udea\\actividad\\reportes\\ReporteActividades.jrxml");
		   path = "C:\\Users\\danilo\\Desktop\\RegistroAct17oct\\Prueba\\Actividad\\src\\com\\proint1\\udea\\actividad\\reportes\\ReporteActividades.jasper";
		
		 
	        JasperReport reporte = null;
	        reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
	        Resumen res = new Resumen("catedra1",2);
	        Resumen res2 = new Resumen("catedra2",2);
	        List<Resumen> re1 = new ArrayList<Resumen>();
	        re1.add(res);
	        re1.add(res2);
	        Map parametros = new HashMap();
			parametros.put("tipoActividad",res);
			List li= new ArrayList();
			
			// esta lista es la que mando inicialmente
			// asi construyo el reporte
			//como hago para mandar otra lista, repito el codigo?
			
			
			// entonces voy a crear una lista con objetos resumen y eso los voy a mandar, a listo voy hacerl, gracias, pero vos lo
			//has hecho osea qe por ejemplo
			
			
			//parametros.put("NombresContratista","fulano de tal");
	        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,null, new JRBeanCollectionDataSource(lista)); 
	        
			 
	       // JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\usuario\\Documents\\Reportes\\ProyectoIntegrador2\\simple_report.pdf"); 
	        //JasperExportManager.exportReportToPdfFile(jasperPrint);
	        return JasperExportManager.exportReportToPdf(jasperPrint);
	        
	        /*
2
3
4
5
<button label="Download sun.jpg">
    <attribute name="onClick"><![CDATA[
        Filedownload.save("/widgets/file_handling/file_download/img/sun.jpg", null);
    ]]></attribute>
</button>*/
	}

	
	@Override
	public List listarActividadesMes(List<RegistrarActividadDTO> lista, String mes) {
		String fechaMes;
		List<RegistrarActividadDTO> listaMes = new ArrayList<RegistrarActividadDTO>();
				
		
		for(int i=0; i<lista.size();i++){
			 fechaMes = String.valueOf(lista.get(i).getFecha()).substring(5,7);
			if(fechaMes.equals(mes)){
				listaMes.add(lista.get(i));
			}
		}
					
				
		return listaMes;
	}

	@Override
	public List ordenarActividades(List<RegistrarActividadDTO> lista) {
		RegistrarActividadDTO dtofechaMayor;
		for( int j=0;j<lista.size();j++){
			for(int i=0;i<lista.size()-1;i++){
				if(lista.get(i+1).getFecha().before(lista.get(i).getFecha())){
					dtofechaMayor = lista.get(i);
					lista.set(i, lista.get(i+1));
					lista.set(i+1, dtofechaMayor);				
				}
			}
		}
		
		return lista;
	}
	
	@Override
	public List <Resumen> sumarTipoActividades(List<RegistrarActividadDTO> lista) {
		Map <String, Integer>actividades = new HashMap <String, Integer>();
		List <Resumen> lis = new ArrayList<Resumen>();
		for(int i=0; i<lista.size();i++){
			
			if(!actividades.containsKey(lista.get(i).getNombreTipo())){
				actividades.put(lista.get(i).getNombreTipo(),1);
			}else{
				
				int sumaActividad = actividades.get(lista.get(i).getNombreTipo());
				actividades.put(lista.get(i).getNombreTipo(),sumaActividad +1);
			}
				
			
			
		}
		
		Iterator it = actividades.keySet().iterator();
		
		while(it.hasNext()){
			
			String key = it.next().toString();
			
			Resumen resumen = new Resumen(key,actividades.get(key));
			System.out.println(resumen.getTipoctividad() +" "+ resumen.getTotalActividad());
			lis.add(resumen);
			
		}
		return lis;
	
	}
	public List agruparActividades(List<RegistrarActividadDTO> lista){
		List <RegistrarActividadDTO> listaAgrupada = new ArrayList<RegistrarActividadDTO>();
		System.out.println("primero");
		List <RegistrarActividadDTO> listaAgrupadaSecundaria = new ArrayList <RegistrarActividadDTO>();
		for (int k=0 ; k<lista.size();k++){
			listaAgrupadaSecundaria.add(lista.get(k));
			System.out.println("se inserto"+listaAgrupadaSecundaria.get(k).getNombreTipo());
		}
		RegistrarActividadDTO tipoActividad = new RegistrarActividadDTO() ;
		tipoActividad.setNombreTipo("valor");
		int m=0;
		for(int j=0;j<lista.size();j++){
			
		for (int i=0;i<listaAgrupadaSecundaria.size();i++){
		
			System.out.println(j+" "+i);
			
			//listaAgrupada.add(tipoActividad);
			//System.out.println(lista.get(j).getNombreTipo());
				if(lista.get(j).getNombreTipo().equals(listaAgrupadaSecundaria.get(i).getNombreTipo())){
					System.out.println(lista.get(j).getNombreTipo()+" igual a" +listaAgrupadaSecundaria.get(i).getNombreTipo());
					listaAgrupada.add(listaAgrupadaSecundaria.get(i));
					System.out.println("se adiciona"+listaAgrupadaSecundaria.get(i).getNombreTipo());
					listaAgrupadaSecundaria.set(i, tipoActividad);
					System.out.println("despues de la adicion"+listaAgrupadaSecundaria.get(i).getNombreTipo());
					//System.out.println("se adiciona"+listaAgrupadaSecundaria.get(i).getNombreTipo());
					m = m+1;
					
				}
			
			}		
		}
		
				
		return listaAgrupada;
	}
	
	
		
		
}

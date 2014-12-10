package TareaInvocar;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.proint1.udea.actividad.entidades.DocenteGrupo;
import com.proint1.udea.actividad.ngc.DocGrupoOperacionesIntDAO;

public class HolaMundoJob implements Job {

	
	
	public void execute(JobExecutionContext jobExecutionContext)
			throws JobExecutionException {
		System.out.println("¡Hola, mundo! :D");
	}

}
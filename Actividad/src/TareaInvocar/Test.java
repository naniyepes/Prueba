package TareaInvocar;

import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import com.proint1.udea.actividad.dao.DocGrupoDTO;
import com.proint1.udea.actividad.entidades.DocenteGrupo;
import com.proint1.udea.actividad.ngc.DocGrupoOperacionesIntDAO;
//import org.quartz.helpers.TriggerUtils; 

public class Test {

	public static void main(String[] args) {
		try {
			
			Logger logger=Logger.getLogger(Test.class);
			
			
			
			// Creacion de una instacia de Scheduler
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			System.out.println("Iniciando Scheduler...");
			scheduler.start();
			// Creacion una instacia de JobDetail
			JobDetail jobDetail = new JobDetailImpl("HolaMundoJob", Scheduler.DEFAULT_GROUP, HolaMundoJob.class);

			// Creacion de un Trigger donde indicamos
			// que el Job se
			// ejecutara de inmediato y a partir de ahi en lapsos
			// de 5 segundos por 10 veces mas.

			/*egundos = 0
					minutos = 15
					horas = 10 (formato de 24 horas)
					díaDelMes = * (todos los días)
					mes = * (todos los meses)
					díaaDeLaSemana = ? (no especificado)*/
			
			//Trigger trigger = new SimpleTriggerImpl("HolaMundoTrigger", Scheduler.DEFAULT_GROUP, 10, 5000);
			
			//0 0 12 15 1/1 ? *
			
			CronTrigger trigger = new CronTriggerImpl("HolaMundoTrigger", Scheduler.DEFAULT_GROUP, "2/1 * * * * ?");
			
			// Registro dentro del Scheduler
			
			scheduler.scheduleJob(jobDetail, trigger);
	
			
			// Damos tiempo a que el Trigger registrado
			// termine su periodo
			// de vida dentro del scheduler
			//Thread.sleep(60000);

			// Detenemos la ejecución de la
			// instancia de Scheduler
			//scheduler.shutdown();

		} catch (Exception e) {
			System.out.println("Ocurrió una excepción");
		}
	}

}

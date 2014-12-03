package com.proint1.udea.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import com.proint1.udea.alertas.JobAlertasActividadesDocentesSinRegistrar;



/**
 * Listener para el inicio de la aplicación
 * @author Juan Cardona
 * @since 26/11/2014
 */
public class AplicationContextListenerUdeA implements ServletContextListener {

	/** Variable para identificar el tiempo de actualización de las sessiones activas en el servidor de base de datos dado en milisegundos*/
	public static final long TIME_SESSION_ALIVE = 10000;
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		iniciarServidordeAlertasThread();
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}

	
	public void iniciarAlertar(){
		Thread ta = new Thread(){
			@Override
			public synchronized void start() {
			iniciarServidordeAlertasThread();
			}
		};
		ta.start();
	}
	
	
	
	/** Inicia el hilo de session alive*/
	private void iniciarServidordeAlertasThread() {
	try {
			
			// Creacion de una instacia de Scheduler
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			System.out.println("Iniciando Scheduler...");
			scheduler.start();
			// Creacion una instacia de JobDetail
			JobDetail jobDetail = new JobDetailImpl("HolaMundoJob", Scheduler.DEFAULT_GROUP, JobAlertasActividadesDocentesSinRegistrar.class);

			// Creacion de un Trigger donde indicamos
			// que el Job se
			// ejecutara de inmediato y a partir de ahi en lapsos
			// de 5 segundos por 10 veces mas.
			
			//Trigger trigger = new SimpleTriggerImpl("HolaMundoTrigger", Scheduler.DEFAULT_GROUP, 1, 5000);

		 	CronTrigger trigger = new CronTriggerImpl("HolaMundoTrigger", Scheduler.DEFAULT_GROUP, "1 * * * * ?");
			
			// Registro dentro del Scheduler
			scheduler.scheduleJob(jobDetail, trigger);

			// Damos tiempo a que el Trigger registrado
			// termine su periodo
			// de vida dentro del scheduler
			Thread.sleep(60000);

			// Detenemos la ejecución de la
			// instancia de Scheduler
			//scheduler.shutdown();

		} catch (Exception e) {
			System.out.println("Ocurrió una excepción");
		}
    }
	
	
	
	
	
	

}

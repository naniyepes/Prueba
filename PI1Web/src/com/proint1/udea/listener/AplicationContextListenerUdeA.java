package com.proint1.udea.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;

import com.proint1.udea.alertas.JobAlertasActividadesDocentesSinRegistrar;



/**
 * Listener para el inicio de la aplicación
 * @author Juan Cardona
 * @since 26/11/2014
 */
@WebListener
public class AplicationContextListenerUdeA extends QuartzInitializerListener  {

	/** Variable para identificar el tiempo de actualización de las sessiones activas en el servidor de base de datos dado en milisegundos*/
	public static final long TIME_SESSION_ALIVE = 10000;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		super.contextInitialized(sce);
        ServletContext ctx = sce.getServletContext();
        StdSchedulerFactory factory = (StdSchedulerFactory) ctx.getAttribute(QUARTZ_FACTORY_KEY);
        try {
            Scheduler scheduler = factory.getScheduler();
            JobDetail job = JobBuilder.newJob(JobAlertasActividadesDocentesSinRegistrar.class)
            		.withIdentity("AlertaActividadesDocentes", "group1")
            		.build();
            
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("Triger cada minuto").withSchedule(
                    CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")
            ).startNow().build();
            scheduler.scheduleJob(job, trigger);
            scheduler.start();
        } catch (Exception e) {
           System.out.println("Ocurri\u00f3 un error al calendarizar el trabajo");
        }
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		  super.contextDestroyed(servletContextEvent);
	}
}

package com.proint1.udea.alertas;

import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.proint1.udea.notificaciones.UdeAEmailSenderException;
import com.proint1.udea.notificaciones.UdeaEmailService;



/**
 * 
 * @author yo no fui
 *
 */
public class JobAlertasActividadesDocentesSinRegistrar implements Job {


	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println("¡Hola, mundo! :D");

		try {
			List<String> emailsTo = new ArrayList<>();
			emailsTo.add("danilomejia127@gmail.com");
			emailsTo.add("jkcardona@gmail.com");
			UdeaEmailService.sendEmail("Test Registro Actividades", "Mesanje de prueba", emailsTo, null, null, null);
		} catch (UdeAEmailSenderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
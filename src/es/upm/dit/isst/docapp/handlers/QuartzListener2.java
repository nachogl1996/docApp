package es.upm.dit.isst.docapp.handlers;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static org.quartz.SimpleScheduleBuilder.*;


@WebListener
public class QuartzListener2 implements ServletContextListener {
	Scheduler scheduler = null;

	@Override
	public void contextInitialized(ServletContextEvent servletContext) {
		System.out.println("Context Initialized");

		try {
			//Creacion de un trabajo de la clase CleanDatabaseJob que se encarga de borrar los TFG finalizados de la base de datos
			JobDetail job = newJob(SendEmailJob.class).build();

			//El desencadenante es un ciclo de 24 horas
			Trigger trigger = newTrigger()
					.withSchedule(simpleSchedule()
							.withIntervalInMinutes(1)
							.repeatForever())
					.build();

			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			
			//Se añaden el trabajo y el desencadenante al orquestador
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContext) {
		System.out.println("Context Destroyed");
		try {
			scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}


}

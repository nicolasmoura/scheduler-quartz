package br.com.nicolas.services.scheduler.jobs;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class ScheduleJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        task(jobExecutionContext.getJobDetail().getJobDataMap().getString("taskDescriptor"));
    }

    public void task(String taskDescriptor) {
        log.info(taskDescriptor + " executada - " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
    }
}

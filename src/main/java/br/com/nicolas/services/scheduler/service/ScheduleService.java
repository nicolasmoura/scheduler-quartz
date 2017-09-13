package br.com.nicolas.services.scheduler.service;

import br.com.nicolas.services.scheduler.jobs.ScheduleJob;
import br.com.nicolas.services.scheduler.model.ScheduleRequest;
import br.com.nicolas.services.scheduler.model.ScheduleResponse;
import br.com.nicolas.services.scheduler.model.enums.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

@Slf4j
@Service
public class ScheduleService {
    @Autowired
    Scheduler scheduler;

    public ScheduleResponse schedule(ScheduleRequest scheduleRequest) throws SchedulerException {
        String cron = generateCronExpression(scheduleRequest.getExecutionDate());
        try {
            JobDetail job = newJob(ScheduleJob.class)
                    .withIdentity(scheduleRequest.getTaskName(), "scheduledTasks")
                    .usingJobData("taskDescriptor", scheduleRequest.getTaskDescriptor())
                    .build();
            CronTrigger trigger = newTrigger()
                    .withIdentity(scheduleRequest.getTriggerName(), "scheduledTasks")
                    .withSchedule(cronSchedule(cron))
                    .build();
            scheduler.scheduleJob(job, trigger);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ScheduleResponse(ResponseCode.Erro, scheduleRequest);
        }
        return new ScheduleResponse(ResponseCode.Sucesso, scheduleRequest);

    }

    private String generateCronExpression(LocalDateTime ldt) {
        String cronExpression = String.format("%1$s %2$s %3$s %4$s %5$s %6$s %7$s", ldt.getSecond(), ldt.getMinute(),
                ldt.getHour(), ldt.getDayOfMonth(), ldt.getMonthValue(), "?", ldt.getYear());
        log.info(cronExpression);
        return cronExpression;
    }
}

package br.com.nicolas.services.scheduler.controller;

import br.com.nicolas.services.scheduler.model.ScheduleRequest;
import br.com.nicolas.services.scheduler.model.ScheduleResponse;
import br.com.nicolas.services.scheduler.service.ScheduleService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public ScheduleResponse schedule(@RequestBody ScheduleRequest scheduleRequest) throws SchedulerException {
        return scheduleService.schedule(scheduleRequest);
    }
}

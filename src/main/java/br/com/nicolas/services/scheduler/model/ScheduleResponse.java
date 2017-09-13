package br.com.nicolas.services.scheduler.model;

import br.com.nicolas.services.scheduler.model.enums.ResponseCode;
import lombok.Data;

@Data
public class ScheduleResponse {
    private ResponseCode responseCode;
    private ScheduleRequest scheduleRequest;

    public ScheduleResponse(ResponseCode responseCode, ScheduleRequest scheduleRequest) {
        this.responseCode = responseCode;
        this.scheduleRequest = scheduleRequest;
    }
}

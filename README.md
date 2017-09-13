# scheduler-quartz
Serviço REST criado com Spring Boot para agendamento de tasks usando Quartz.
***
**POST** *localhost:8090/schedule*

+ **body:**
```json
{
  "taskName":"Task",
  "taskDescriptor":"Eu sou uma task!",
  "triggerName":"Trigger",
  "executionDate":"yyyy-MM-dd HH:mm:ss"
}
```
+ **response:**
```json
{
  "responseCode": "Sucesso",
    "scheduleRequest": {
      "taskName":"Task",
        "taskDescriptor":"Eu sou uma task!",
        "triggerName":"Trigger",
        "executionDate":"yyyy-MM-dd HH:mm:ss"
    }
}
```

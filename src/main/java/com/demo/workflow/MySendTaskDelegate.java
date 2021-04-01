package com.demo.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Logger;
@Component
public class MySendTaskDelegate implements JavaDelegate {

    private  final Logger LOGGER = Logger.getLogger(MySendTaskDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Inside execute() of Send Task....."+ MySendTaskDelegate.class.getName());

        delegateExecution.setVariable("Candidate", "Shaheen Anwar");
        delegateExecution.setVariable("name", true);

        /*stackoverflow.com/questions/24278163/how-to-use-camunda-bpmn-send-task-and-receive-task*/
        delegateExecution.getProcessEngineServices()
                .getRuntimeService()
                .createMessageCorrelation("TEST_MESSAGE1")
                .correlate();


        LOGGER.info("\n Date: "+new Date()+"\n Message Sent to: " +delegateExecution.getVariable("name"));
    }
}

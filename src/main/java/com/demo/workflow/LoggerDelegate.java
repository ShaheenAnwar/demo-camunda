package com.demo.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Logger;

@Component
public class LoggerDelegate implements JavaDelegate {

    private  final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        delegateExecution.setVariable("Candidate", "Shaheen Anwar");
        delegateExecution.setVariable("affirmation", true);

        LOGGER.info("Invoked By Id: " +delegateExecution.getProcessInstanceId()
            +", Activity Name: "+ delegateExecution.getCurrentActivityName()
                +"\n Date: "+new Date()+"\n Candidate Name: "
                +delegateExecution.getVariable("Candidate"));


    }
}

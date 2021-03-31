package com.demo.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Date;
import java.util.logging.Logger;

public class LoggerDelegate implements JavaDelegate {

    private  final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        LOGGER.info("Invoked By Id: " +delegateExecution.getProcessInstanceId()
            +", Activity Name: "+ delegateExecution.getCurrentActivityName()
                +"\n Date: "+new Date()+"\n Loan Requester: "
                +delegateExecution.getVariable("Loan Requester"));


    }
}

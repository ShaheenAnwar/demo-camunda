package com.demo.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class SetVariableDelegate implements JavaDelegate {

    private  final Logger LOGGER = Logger.getLogger(SetVariableDelegate.class.getName());

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOGGER.info("Invoked By Id: " +execution.getProcessInstanceId());

        execution.setVariable("varCondEvent", true);
        //execution.setVariable("varCondBoundryEvent", true);

        LOGGER.info("varCondEvent ======" +execution.getVariable("varCondEvent")
            +"\nActivity Name: "+ execution.getCurrentActivityName());
    }
}
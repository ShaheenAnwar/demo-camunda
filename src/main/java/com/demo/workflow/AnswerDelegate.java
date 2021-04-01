package com.demo.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AnswerDelegate implements JavaDelegate {

    private  final Logger LOGGER = Logger.getLogger(SetVariableDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String question = (String)delegateExecution.getVariable("askQuestion");

        delegateExecution
                .getProcessEngineServices()
                .getRuntimeService()
                .createMessageCorrelation("AnswerAskedMessage")
                .setVariable("askQuestion",question)
                .correlate();

        LOGGER.info("Invoked By Id: " +delegateExecution.getProcessInstanceId()
                    +"\tActivity Name: "+ delegateExecution.getCurrentActivityName());
    }
}
/**payload to send with Post request from Postman*/
/*
    {
      "messageName" : "QuestionAsked",
      "businessKey" : "1",
      "processVariables" : {
        "question" : {"value" : "aNewValue", "type": "String"
                     }
      }
    }
* */
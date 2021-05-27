package com.demo.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Random;

public class VerifyLoanDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
       // Random random = new Random();   //for generating random boolean value

        delegateExecution.setVariable("Loan Requester", "Shaheen");
        delegateExecution.setVariable("Affirmation", true);

    }
}

package com.ctw.ffn131330.exceptions;


import org.hibernate.TransactionException;

import javax.transaction.TransactionalException;

public class GenericException{

    public static class UserExceptions extends RuntimeException{
        public UserExceptions(String msg){
            super(msg);
        }
    }


    public static class TestException extends RuntimeException{
        public TestException(String msg){
            super(msg);
        }
    }

    public static class FailedRegistration extends TransactionException {
        public FailedRegistration(String msg) { super(msg);}
    }
}



package com.ctw.ffn131330.exceptions;


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
}



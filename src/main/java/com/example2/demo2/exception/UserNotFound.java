package com.example2.demo2.exception;

public class UserNotFound extends RuntimeException{
     public UserNotFound() {
          super();
      }
     public UserNotFound(Long id){
          super("Could not found the user with id "+ id);
      }
      public UserNotFound(String message, Throwable cause) {
          super(message, cause);
      }
}

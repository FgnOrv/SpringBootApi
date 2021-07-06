/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringFgnDailyCodeBuffer.SpringBootDailyCodeBuffer.error;

import org.springframework.http.HttpStatus;

/**
 *
 * @author fiorucov
 */
public class ErrorMessage {
    
    private HttpStatus status;
    private String message; 

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    } 

    @Override
    public String toString() {
        return "ErrorMessage{" + "status=" + status + ", message=" + message +  '}';
    }

    public ErrorMessage() {
    }

    public ErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    
    
    
}

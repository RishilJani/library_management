package com.project.library_management.DTOs.response_DTOs;

public class ResponseDTO {
    private boolean error;
    private String message;
    private Object data;

    public ResponseDTO(){
        
    }
    public ResponseDTO(boolean error , String message , Object data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseDTO errorResponse(Exception e){
        return new ResponseDTO(true, "Some Error Occurred", e);
    }

    public static ResponseDTO notFoundResponse(String message){
        return new ResponseDTO(true, message, null);
    }
}

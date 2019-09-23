package com.company.imtahan.dto;

/**
 *
 * @author sarkhanrasullu
 */
public class ResponseDTO {
    
    private String errorMessage;
    private int code = 1;
    private String successMessage;
    private Object result;

    public ResponseDTO() {
    }

    public ResponseDTO(Object result) {
        this.result = result;
    }

    public ResponseDTO(String errorMessage, Object result) {
        this.errorMessage = errorMessage;
        this.result = result;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ResponseDTO(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
}

package com.turkcell.crm.customerService.core.crossCuttingConcerns.exceptions.types;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
package com.company.springbootgradledockeraws;

import org.json.JSONObject;

public class EmployeeNotFoundException extends RuntimeException {
    EmployeeNotFoundException(JSONObject jsonObject) {
        super(String.valueOf(jsonObject));
    }
}

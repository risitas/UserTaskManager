package com.smzynm.UserTaskManager.services.impl;

import com.smzynm.UserTaskManager.services.CodeGeneratorService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CodeGeneratorServiceImpl implements CodeGeneratorService {
    @Override
    public String generarCodigo() {
        String code = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "").substring(0, 6);
        return code;
    }
}

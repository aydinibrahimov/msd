package com.msd.msd.logging;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class MSD_Logging {
//    public static void main(String[] args) {
//        saveLog(new MSD_Logging());
//    }

    public void saveLog(Object obj) {
       String className=getClassName(obj);
        log.info( className+ " is saved. . . ");
    }

    private static String getClassName(Object obj){
        String fullClassName=obj.getClass().getName();
        String className=fullClassName.substring(obj.toString().lastIndexOf('.')+1);
        return className;
    }


}

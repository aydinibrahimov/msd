package com.msd.msd.logging;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class MSD_Logging {
    public void saveLog(Object obj) {
        log.info(obj.getClass().getName() + " is working in. . . ");
    }


}

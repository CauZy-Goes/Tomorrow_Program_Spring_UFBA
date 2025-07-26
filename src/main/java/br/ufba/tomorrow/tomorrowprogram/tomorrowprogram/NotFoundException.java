package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.ResponseStatus;


public class NotFoundException extends RuntimeException {

    public NotFoundException (String msg){
        super(msg);
    }

}

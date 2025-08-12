package com.leiber.play.persistence.mapper;

import com.leiber.play.domain.util.Constant;
import org.mapstruct.Named;

public class StateMapper {

    @Named("stringToBoolean")
    public static Boolean stringToBoolean(String estado) {
        return switch (estado.trim().toUpperCase()) {
            case Constant.State.ACTIVE -> Boolean.TRUE;
            case Constant.State.INACTIVE -> Boolean.FALSE;
            default -> null;
        };
    }

    @Named("booleanToString")
    public static String booleanToString(Boolean state) {
        if (state == null) {
            return null;
        }

        return state ? Constant.State.ACTIVE : Constant.State.INACTIVE;
    }

    private StateMapper(){}
}


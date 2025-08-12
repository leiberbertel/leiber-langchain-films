package com.leiber.play.domain.util;

public class Constant {

    private Constant() {
        throw new UnsupportedOperationException("Esta es una clase de utilidad y no puede ser instanciada.");
    }

    public static final class State {
        public static final String ACTIVE = "D";
        public static final String INACTIVE = "N";

        private State() {
            throw new UnsupportedOperationException("Clase de State, no instanciable.");
        }
    }
}


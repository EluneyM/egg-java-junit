package src.models;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    private List<String> errores;
    private String password;

    public PasswordValidator(String password) {
        this.password = password;
        this.errores = new ArrayList<>();
    }

    public PasswordValidator minimoCaracteres(int minimo) {
        if (this.password.length() < minimo) {
            this.errores.add("La contraseña debe tener al menos " + minimo + " caracteres.");
        }

        return this;
    }

    public PasswordValidator incluirMinusculaMayuscula() {
        if (! this.password.matches(".*[a-zA-Z].*")) {
            this.errores.add("La contraseña debe contener al menos una letra mayúscula y una letra minúscula.");
        }

        return this;
    }

    public PasswordValidator incluirNumero() {
        if (! this.password.matches(".*[0-9].*")) {
            this.errores.add("La contraseña debe contener al menos un número.");
        }

        return this;
    }

    public PasswordValidator incluirCaracterEspecial() {
        if (! this.password.matches(".*[^a-zA-Z0-9].*")) {
            this.errores.add("La contraseña debe contener al menos un carácter especial (por ejemplo, !, @, #, $).");
        }

        return this;
    }

    public void validar() {
        if (this.errores.isEmpty()) {
            System.out.println("¡Contraseña segura! Cumple con todos los criterios.");
        }

        for (String error : this.errores) {
            System.out.println("Contraseña no segura. " + error + "\n");
        }
    }
}

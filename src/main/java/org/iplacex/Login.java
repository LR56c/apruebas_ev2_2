package org.iplacex;

public class Login {
    public String execute(String user, String pass) {
        if (user == null || user.isEmpty() || pass == null || pass.isEmpty()) {
            return "Error: Los campos no pueden estar vacios";
        }
        if (user.equals("admin") && pass.equals("admin123")) {
            return "Bienvenido admin";
        }
        return "Error: Usuario o contrasena incorrecta";
    }
}

package com.provee.constantes;

public class Constantes {

    // ADMIN KC
    public static final String URL_TOKEN_KC = "http://127.0.0.1:8080/auth/realms/master/protocol/openid-connect/token";
    public static final String CONTENT_TYPE_KC = "application/x-www-form-urlencoded";
    public static final String USERNAME_KC = "cherso";
    public static final String PASSWORD_KC = "12345678";
    public static final String CLIENT_SECRET_KC = "9a21c9c1-f0f1-4882-acdf-1819268bbc0f";
    public static final String CLIENT_ID_KC = "admin-cli";
    public static final String GRANT_TYPE_KC = "password";

    public static final String LINEA_PUNTEADA = "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ";

    // PROVEEDORES KC
    public static final String CLIENT_SECRET_PROVEEDORES = "a39fe5e6-3ddc-4089-ada8-26f97978b8b0";
    public static final String CLIENT_ID_PROVEEDORES = "proveedores";
    public static final String GRANT_TYPE_PROVEEDORES = "password";
    public static final String CONTENT_TYPE_PROVEEDORES = "application/x-www-form-urlencoded";
    public static final String URL_TOKEN_PROVEEDORES = "http://127.0.0.1:8080/auth/realms/springboot/protocol/openid-connect/token";
    public static final String URL_CERRAR_SESION = "http://127.0.0.1:8080/auth/realms/springboot/protocol/openid-connect/logout";
    public static final String URL_REFRESH_TOKEN = "http://127.0.0.1:8080/auth/realms/springboot/protocol/openid-connect/token";
}


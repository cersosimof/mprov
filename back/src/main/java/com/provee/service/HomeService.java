package com.provee.service;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.provee.bean.BeanKeyClakUserInfo;
import com.provee.bean.BeanKeyCloakAdminToken;
import com.provee.constantes.Constantes;
import com.provee.controller.HomeController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    private static final Logger logger = LogManager.getLogger(HomeService.class);

    public BeanKeyCloakAdminToken getAdminTokenKC() {

        BeanKeyCloakAdminToken beanToken = null;

        try {

            logger.info(Constantes.LINEA_PUNTEADA);
            logger.info("Ingreso Service Consulta Token Admin");
            logger.info(Constantes.LINEA_PUNTEADA);

            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post(Constantes.URL_TOKEN_KC)
                    .header("Content-Type", Constantes.CONTENT_TYPE_KC)
                    .field("username", Constantes.USERNAME_KC)
                    .field("password", Constantes.PASSWORD_KC)
                    .field("client_secret", Constantes.CLIENT_SECRET_KC)
                    .field("client_id", Constantes.CLIENT_ID_KC)
                    .field("grant_type", Constantes.GRANT_TYPE_KC)
                    .asString();

            Gson g = new Gson();
            beanToken = g.fromJson(response.getBody().toString(), BeanKeyCloakAdminToken.class);

            return beanToken;

        } catch (Exception e) {
            logger.error("Error al consultar el admin token: ", e);
            beanToken = new BeanKeyCloakAdminToken();
            beanToken.setError("Error al consultar el admin token");
            return beanToken;
        }
    }

    public BeanKeyCloakAdminToken getUserTokenKC(String user, String pass) {

        BeanKeyCloakAdminToken beanToken = null;

        try {

            logger.info(Constantes.LINEA_PUNTEADA);
            logger.info("Ingreso Service Consulta Token Usuario " + user);
            logger.info(Constantes.LINEA_PUNTEADA);

            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post(Constantes.URL_TOKEN_PROVEEDORES)
                    .header("Content-Type", Constantes.CONTENT_TYPE_PROVEEDORES)
                    .field("username", user)
                    .field("password", pass)
                    .field("client_secret", Constantes.CLIENT_SECRET_PROVEEDORES)
                    .field("client_id", Constantes.CLIENT_ID_PROVEEDORES)
                    .field("grant_type", Constantes.GRANT_TYPE_PROVEEDORES)
                    .asString();

            Gson g = new Gson();
            beanToken = g.fromJson(response.getBody().toString(), BeanKeyCloakAdminToken.class);

            return beanToken;

        } catch (Exception e) {
            logger.error("Error al consultar el admin token: ", e);
            beanToken = new BeanKeyCloakAdminToken();
            beanToken.setError("Error al consultar el admin token");
            return beanToken;
        }
    }

    public BeanKeyClakUserInfo getDatosUsuarioConMail(String token, String mail) {

        BeanKeyClakUserInfo userInfo = null;

        try {

            logger.info(Constantes.LINEA_PUNTEADA);
            logger.info("Ingreso Service busca info por email");
            logger.info(Constantes.LINEA_PUNTEADA);

            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get("http://192.168.0.163:8080/auth/admin/realms/prueba/users?email=" + mail)
                    .header("Authorization", "Bearer " + token + "")
                    .asString();

            String r = filtrarCorchetes(response);

            Gson g = new Gson();
            userInfo = g.fromJson(r, BeanKeyClakUserInfo.class);

            return userInfo;

        } catch (Exception e) {
            logger.error("Error al buscar info del usuario por email", e);
            userInfo = new BeanKeyClakUserInfo();
            userInfo.setError("Error al consultar el admin token");
            return userInfo;
        }
    }

    private String filtrarCorchetes(HttpResponse<String> response) {
        String x = response.getBody();
        String[] y = x.split("");
        y[0] = "";
        y[(x.length()) - 1] = "!!!!!··$$";
        String r = "";
        int i = 0;
        while (y[i] != "!!!!!··$$") {
            r = r.concat(y[i]);
            i++;
        }
        return r;
    }

    public String closeSession(String adminToken, String refreshToken) {
        try {

            logger.info(Constantes.LINEA_PUNTEADA);
            logger.info("Cerrar Session");
            logger.info(Constantes.LINEA_PUNTEADA);

            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post(Constantes.URL_CERRAR_SESION)
                    .header("Authorization", "Bearer " + adminToken + "")
                    .header("Content-Type", Constantes.CONTENT_TYPE_PROVEEDORES)
                    .field("client_id", Constantes.CLIENT_ID_PROVEEDORES)
                    .field("refresh_token", refreshToken)
                    .field("client_secret", Constantes.CLIENT_SECRET_PROVEEDORES)
                    .asString();

            return "Si";

        } catch (Exception e) {
            return "no";
        }
    }

    public String refreshToken(String adminToken, String refreshToken) {
        try {

            logger.info(Constantes.LINEA_PUNTEADA);
            logger.info("REFRESH TOKEN");
            logger.info(Constantes.LINEA_PUNTEADA);

            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post(Constantes.URL_REFRESH_TOKEN)
                    .header("Content-Type", Constantes.CONTENT_TYPE_PROVEEDORES)
                    .field("client_id", Constantes.CLIENT_ID_PROVEEDORES)
                    .field("grant_type", "refresh_token")
                    .field("refresh_token", refreshToken)
                    .field("client_secret", Constantes.CLIENT_SECRET_PROVEEDORES)
                    .asString();

            return response.getBody().toString();

        } catch (Exception e) {
            return "no";
        }
    }

    public String altaNuevoUsuario(String nombre, String apellido, String email, String usuario, String pass, BeanKeyCloakAdminToken adminToken) {
        try {

            logger.info(Constantes.LINEA_PUNTEADA);
            logger.info("NEW USER SERVICE");
            logger.info(Constantes.LINEA_PUNTEADA);

            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post("http://192.168.0.163:8080/auth/admin/realms/prueba/users")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + adminToken.getAccess_token() + "")
                    .body("{\n    \"firstName\": \"" + nombre + "\",\n    \"lastName\": \"" + apellido + "\",\n    \"username\": \"" + usuario + "\",\n    \"email\": \"" + email + "\",\n    \"enabled\": \"true\",\n    \"credentials\": [\n        {\n            \"type\": \"password\",\n            \"value\": \"" + pass + "\",\n            \"temporary\": false\n        }\n    ]\n}")
                    .asString();

            return response.getBody().toString();

        } catch (Exception e) {
            return "no";
        }
    }
}

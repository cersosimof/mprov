package com.provee.controller;

import com.provee.bean.BeanKeyClakUserInfo;
import com.provee.bean.BeanKeyCloakAdminToken;
import com.provee.constantes.Constantes;
import com.provee.service.HomeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @Autowired
    HomeService homeService;

    @CrossOrigin
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public BeanKeyCloakAdminToken getUserMessage(@RequestParam(value = "user") String user, @RequestParam(value = "pass") String pass) {


        BeanKeyCloakAdminToken tokenAdmin = new BeanKeyCloakAdminToken();
        BeanKeyCloakAdminToken tokenUser = new BeanKeyCloakAdminToken();

        logger.info(Constantes.LINEA_PUNTEADA);
        logger.info("Ingreso Controller Home");
        logger.info(Constantes.LINEA_PUNTEADA);

        try{
            tokenUser = homeService.getUserTokenKC(user, pass);
            tokenAdmin = homeService.getAdminTokenKC();
            tokenUser.setInfoUser(homeService.getDatosUsuarioConMail(tokenAdmin.getAccess_token(), user));
        } catch (Exception e) {
            logger.error(e);
            tokenUser.setError("Error al generar token");
        }
        return tokenUser;
    }

    @CrossOrigin
    @RequestMapping(path = "/closeSession", method = RequestMethod.POST)
    public String closeSession(@RequestParam(value = "refreshToken") String refreshToken) {

        BeanKeyCloakAdminToken tokenAdmin = new BeanKeyCloakAdminToken();

        logger.info(Constantes.LINEA_PUNTEADA);
        logger.info("Ingreso a controlador de cierre de sesion");
        logger.info(Constantes.LINEA_PUNTEADA);

        try{
            tokenAdmin = homeService.getAdminTokenKC();
            String respuesta = homeService.closeSession(tokenAdmin.getAccess_token(), refreshToken);
            return respuesta;
        } catch (Exception e) {
            logger.error(e);
            return "error";
        }

    }

    @CrossOrigin
    @RequestMapping(path = "/refreshToken", method = RequestMethod.POST)
    public String refreshToken(@RequestParam(value = "refreshToken") String refreshToken) {

        BeanKeyCloakAdminToken tokenAdmin = new BeanKeyCloakAdminToken();

        logger.info(Constantes.LINEA_PUNTEADA);
        logger.info("Ingreso a controlador de cierre de sesion");
        logger.info(Constantes.LINEA_PUNTEADA);

        try{
            tokenAdmin = homeService.getAdminTokenKC();
            String respuesta = homeService.refreshToken(tokenAdmin.getAccess_token(), refreshToken);
            return respuesta;
        } catch (Exception e) {
            logger.error(e);
            return "error";
        }

    }
}

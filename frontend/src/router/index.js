import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Main from "../views/Main.vue";
import Registrar from "../views/Registrar.vue";
import Listado from "../views/Listado.vue";
import Ayuda from "../views/Ayuda.vue";
import Dashboard from "../views/Dashboard.vue";
import Login from "../views/Login.vue";
import store from "@/store";

function ifAuthenticated(to, from, next) {
    if (Vue.prototype.$session.get("TOKEN") != null) {
            store.state.bloqueado = true;
            const axios = require('axios');
            let qs = require('qs');

            let data = qs.stringify({
                'refreshToken': Vue.prototype.$session.get('REFRESH_TOKEN')
            });

            let config = {
                method: 'post',
                url: 'http://127.0.0.1:8081/refreshToken',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                data: data
            };
            axios(config)
                .then(function (response) {
                    if(response.data.error != null) {
                        alert("Token Vencido, Redireccionando a Inicio")
                        Vue.prototype.$session.set('REFRESH_TOKEN', null)
                        Vue.prototype.$session.set('TOKEN', null)
                        Vue.prototype.$session.set('USERNAME', null)
                        location.reload()
                    } else {
                        Vue.prototype.$session.set('REFRESH_TOKEN', response.data.refresh_token)
                        Vue.prototype.$session.set('TOKEN', response.data.access_token)
                        store.state.bloqueado = false;
                        next();
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });

    } else {
        next("/");
    }
}

Vue.use(VueRouter);


const routes = [
    {
        path: "/",
        name: "Home",
        component: Home,
    },
    {
        path: "/main",
        name: "Main",
        beforeEnter: ifAuthenticated,
        component: Main,
    },
    {
        path: "/ayuda",
        name: "Ayuda",
        component: Ayuda,
    },
    {
        path: "/login",
        name: "login",
        component: Login,
    },
    {
        path: "/registrar",
        name: "Registrar",
        beforeEnter: ifAuthenticated,
        component: Registrar,
    },
    {
        path: "/listado",
        name: "Listado",
        beforeEnter: ifAuthenticated,
        component: Listado,
    },
    {
        path: "/ayuda",
        name: "Ayuda",
        beforeEnter: ifAuthenticated,
        component: Ayuda,
    },
    {
        path: "/dashboard",
        name: "Dashboard",
        beforeEnter: ifAuthenticated,
        component: Dashboard,
    },
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes,
});

export default router;



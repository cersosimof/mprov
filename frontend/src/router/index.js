import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Ayuda from "../views/Ayuda.vue";
import Login from "../views/Login.vue";

Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        name: "Home",
        component: Home,
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
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes,
});

export default router;



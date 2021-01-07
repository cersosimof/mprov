import Vue from 'vue'
import Vuex from 'vuex'
import router from "@/router";


Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        user: '',
        pass: '',
        token: '',
        refresh_token: '',
        bloqueado: false,
    },
    mutations: {
        SET_USER(state, userInput) {
            state.user = userInput;
        },
        SET_PASS(state, passInput) {
            state.pass = passInput;
        },
        SET_TOKEN(state, tokenKC) {
            state.token = tokenKC;
        },
        SET_TOKEN_REFRESH(state, tokenRefreshKC) {
            state.refresh_token = tokenRefreshKC;
        },
        SET_BLOQUEADO(state, dato) {
            state.bloqueado = dato;
        },
    },
    actions: {
        validarLogin({ dispatch, commit }) {
            console.log("ingreso a validarLogin" + dispatch);

            const axios = require('axios');
            let qs = require('qs');
            let data = qs.stringify({
                'user': this.state.user,
                'pass': this.state.pass,
            });

            let config = {
                method: 'post',
                url: 'http://127.0.0.1:8081/login',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                data: data
            };

            axios(config)
                .then(function (response) {
                    if (response.data.error == null) {
                        console.log(response.data)
                        Vue.prototype.$session.set('TOKEN', response.data.access_token);
                        Vue.prototype.$session.set('REFRESH_TOKEN', response.data.refresh_token);
                        Vue.prototype.$session.set('USERNAME', response.data.infoUser.username);
                        router.push({ path: "/main" })
                    } else {
                        alert(response.data.error)
                    }
                    commit("SET_BLOQUEADO", false);
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        cerrarSesion ( { dispatch, commit }) {

            console.log(dispatch)
            console.log(commit)

            console.log("dispara cerra rsesion")
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
                    alert(response.data)
                    Vue.prototype.$session.set('REFRESH_TOKEN', null)
                    Vue.prototype.$session.set('TOKEN', null)
                    Vue.prototype.$session.set('USERNAME', null)
                    location.reload()
                })
                .catch(function (error) {
                    console.log(error);
                });
        },

    }
})
import Vue from 'vue'
import App from './App'
import store from './store/index'
import router from './router/index'

const axios = require('axios');



var config = {
    method: 'get',
    url: 'http://127.0.0.1:8081/user/message',
    headers: { }
};

axios(config)
    .then(function (response) {
        console.log(response);
    })
    .catch(function (error) {
        console.log(error);
    });


Vue.config.productionTip = false

    new Vue({
        render: h => h(App),
        store,
        router
    }).$mount('#app')


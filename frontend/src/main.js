import Vue from 'vue'
import App from './App'
import store from './store/index'
import router from './router/index'
import VueSessionStorage from 'vue-sessionstorage'


Vue.use(VueSessionStorage)

Vue.config.productionTip = false

    new Vue({
        render: h => h(App),
        store,
        router
    }).$mount('#app')


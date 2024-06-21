import { createApp, ref } from 'vue';
import './style.css';
import App from './App.vue';
import { createVuetify } from 'vuetify';
import 'vuetify/styles'
import '@mdi/font/css/materialdesignicons.css';
import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';
import router from './router'
import { createPinia } from 'pinia';

const vuetify = createVuetify ({
    components,
    directives
});

const pinia = createPinia();

const app = createApp(App);
app.use(pinia);
app.use(router);
app.use(vuetify);
app.mount('#app');

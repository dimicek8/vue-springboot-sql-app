import { createRouter, createWebHistory } from "vue-router";
import Layout from './views/Layout.vue'
import Home from './views/Home.vue'
import Allads from './views/Allads.vue'
import About from "./views/About.vue";
import Contact from "./views/Contact.vue";

const routes = [
    {
    path: '/',
    component: Layout,
    children: [
    {path: '/', component: Home},
    {path: '/allads', component: Allads},
    {path: '/about', component: About},
    {path: '/contact', component: Contact}
    ]
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
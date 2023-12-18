import VueRouter from "vue-router";

const routes = [
    {
        path: '/',
        name: 'AppLogin',
        component:()=>import('../components/AppLogin.vue')
    },
    {
        path: '/Index',
        name: 'AppIndex',
        component:()=>import('../components/AppIndex.vue')
    }
]

const router = new VueRouter({
    mode:"history",
    routes
})

export default router;
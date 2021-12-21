import Vue from "vue";
import Router from "vue-router";
import store from "@/store/store";

Vue.use(Router);

Router.beforeEach((to, from, next) => {
    if(to.matched.some(record => record.meta.requiresAuth)) {
        if (localStorage.getItem('jwt') == null) {
            next({
                path: '/login',
                params: { nextUrl: to.fullPath }
            })
        }
    } else if(to.matched.some(record => record.meta.guest)) {
        if(localStorage.getItem('jwt') == null){
            next()
        }
        else{
            next({ name: 'userboard'})
        }
    }else {
        next()
    }
})

export default new Router({
    mode: "history",
    routes: [
        {
            path: "/",
            name: 'main',
            component: () => import("../../main")
        },
        {
            path: '/signup',
            name: 'register',
            component: () => import('../components/Register'),
            meta: {
                quest: true,
            }
        },
        {
            path: '/signin',
            name: 'login',
            component: () => import('../components/Login'),
            meta: {
                quest: true,
            }
        },
        {
            path: "/sessions",
            name: 'sessions',
            component: () => import("../Sessions/components/sessionsPage"),
            meta: {
                requiresAuth: true,
            }
        },
        {
            path: "/cinema",
            name: 'cinema',
            component: () => import("../Cinema/components/CinemaPage")
        },

    ]
});
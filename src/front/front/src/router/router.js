import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        {
          path: "/",
          name: 'main',
          component: () => import("../../main")
        },
        {
            path: "/customer",
            name: "customer",
            component: () => import("../customerWeb/components/Customers")
        },
        {
            path: "/customer/:id",
            name: "customer-details",
            component: () => import("../customerWeb/components/Customer")
        },
        {
            path: "/customer/add",
            name: "add",
            component: () => import("../customerWeb/components/AddCustomer")
        },
        {
            path: "/sessions",
            name: 'sessions',
            component: () => import("../Sessions/components/sessionsPage")
        }
    ]
});
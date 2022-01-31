const { createRouter, createWebHistory } = require("vue-router")
import ChampList from "../components/ChampList.vue"
import LoginPage from "../components/LoginPage.vue"

const routes = [
    {
        path: "/",
        name: "default",
        redirect: "/home"
    },
    {
        path: "/home",
        name: "home",
        component: ChampList
    },
    {
        path: "/login",
        name: "login",
        component: LoginPage
    }
]

const router = createRouter({history: createWebHistory(process.env.BASE_URL), routes})

export default router
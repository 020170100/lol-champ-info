<template>

    <p>Username</p>
    <input type="text" v-model="user.username">

    <p>Password</p>
    <input type="password" v-model="user.password">
    <br>
    <button @click="login">Login</button>
    <button @click="register">Register</button>
</template>

<script>
export default {

    data() {
        return {
            user: {username: "", password: ""}
        }
    },

    methods: {
        async login() {
            const response = await this.sendLoginRequest(this.user)
             if(response.status == 200) {
                console.log("Login successful!")
            }
            else {
                console.log(response.status + " - " +  response.statusText)
            }
        },

        async register() {
            console.log(this.user.username + ", " + this.user.password)
            const response = await this.sendRegisterRequest(this.user)
            if(response.status == 200) {
                console.log("Registered.")
            }
            else {
                console.log(response.status + " - " +  response.statusText)
            }
            
        },

        async sendLoginRequest(user) {
            const result = fetch("http://localhost:8080/user/login", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(user),
            })
            .then((response) => { 
                return response
            })
            .catch((error) => {
                console.log("ERROR: " + error)
            });
            return result
        },

        async sendRegisterRequest(user) {
            const result = fetch("http://localhost:8080/user/register", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(user),
            })
            .then((response) => { 
                return response
            })
            .catch((error) => {
                console.log("ERROR: " + error)
            });
            return result
        }
    }
}
</script>

<style scoped>
button {
    margin-top: 20px;
    padding: 12px;
    margin-left: 4px;
}
input {
    padding: 8px;
    font-size: 20px;
}
</style>
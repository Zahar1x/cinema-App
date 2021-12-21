<template>
  <div>
    <h4>Register</h4>
    <form @submit.prevent="register">
      <label for="name">Name</label>
      <div>
        <input id="name" type="text" v-model="name" required autofocus>
      </div>
      <label for="name">Surname</label>
      <div>
        <input id="surname" type="text" v-model="surname" required autofocus>
      </div>
      <label for="email" >E-Mail Address</label>
      <div>
        <input id="email" type="email" v-model="email" required>
      </div>

      <label for="password">Password</label>
      <div>
        <input id="password" type="password" v-model="password" required>
      </div>

      <div>
        <button type="submit">Register</button>
      </div>
    </form>
  </div>
</template>
<script>
export default {
  data(){
    return {
      name : "",
      surname: "",
      email : "",
      password : "",
      password_confirmation : "",
      is_admin : null
    }
  },
  methods: {
    register: function () {
      let data = {
        name: this.name,
        surname: this.surname,
        email: this.email,
        password: this.password,
        is_admin: this.is_admin
      }
      this.$store.dispatch('register', data)
          .then(() => this.$router.push('/'))
          .catch(err => console.log(err))
    }
  }
}
</script>
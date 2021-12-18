<template>
  <div id="app" class="mt-0">
    <nav-customer/>
    <main-page/>
    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>

<script>
import mainPage from "main"

export default {
  name: 'App',
  components: {
    navCustomer: () => import('navforcustomer'),
    mainPage,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

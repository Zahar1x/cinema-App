<template>
  <div id="app" class="mt-0">
    <menu_main/>
    <div>
      <router-view />
    </div>
  </div>
</template>

<script>
import menu_main from "main"

export default {
  name: 'App',
  components: {
    menu_main,
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

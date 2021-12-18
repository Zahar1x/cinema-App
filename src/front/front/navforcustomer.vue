<template>
  <div id="navForCustomer">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <div class="container justify-content-start">
        <router-link to="/customer" class="navbar-brand">Cinema App</router-link>
        <div class="navbar-nav mr-auto ">
          <li class="nav-item">
            <router-link to="/customer/customer" class="nav-link">Customers</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/customer/add" class="nav-link">Add</router-link>
          </li>
        </div>
      </div>
    </nav>
  </div>
</template>
<script>
export default {}
</script>
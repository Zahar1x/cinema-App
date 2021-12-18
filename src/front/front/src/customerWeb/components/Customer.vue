<template>
  <div v-if="currentCustomer" class="edit-form">
    <h4>Customer</h4>
    <form>
      <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name"
               v-model="currentCustomer.name"
        />
      </div>
      <div class="form-group">
        <label for="surname">Surname</label>
        <input type="text" class="form-control" id="surname"
               v-model="currentCustomer.surname"
        />
      </div>

      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" id="email"
               v-model="currentCustomer.email"
        />
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password"
               v-model="currentCustomer.password"
        />
      </div>
    </form>
    <button class="badge badge-danger mr-2 bg-dark"
            @click="deleteCustomer"
    >
      Delete
    </button>

    <button type="submit" class="badge badge-success bg-dark"
            @click="updateCustomer"
    >
      Update
    </button>
    <p>{{ message }}</p>
  </div>

  <div v-else>
    <br />
    <p>Please click on a Customer...</p>
  </div>
</template>

<script>
import customerService from "@/customerWeb/services/customerService";

export default {
  name: "customer",
  data() {
    return {
      currentCustomer: null,
      message: ''
    };
  },
  methods: {
    getCustomer(id) {
      customerService.get(id)
          .then(response => {
            this.currentCustomer = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },
    updateCustomer() {
      customerService.update(this.currentCustomer.id, this.currentCustomer)
          .then(response => {
            console.log(response.data);
            this.message = 'The customer was updated successfully!';
          })
          .catch(e => {
            console.log(e);
          });
    },

    deleteCustomer() {
      customerService.delete(this.currentCustomer.id)
          .then(response => {
            console.log(response.data);
            this.$router.push({ name: "customer" });
          })
          .catch(e => {
            console.log(e);
          });
    }
  },
  mounted() {
    this.message = '';
    this.getCustomer(this.$route.params.id);
  }
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>
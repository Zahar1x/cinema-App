<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="name">Name</label>
        <input
            type="text"
            class="form-control"
            id="name"
            required
            v-model="customer.name"
            name="name"
        />
      </div>
      <div class="form-group">
        <label for="surname">Surname</label>
        <input
            type="text"
            class="form-control"
            id="surname"
            required
            v-model="customer.surname"
            name="surname"
        />
      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <input
            type="email"
            class="form-control"
            id="email"
            required
            v-model="customer.email"
            name="email"
        />
      </div>

      <div class="form-group">
        <label for="password">Password</label>
        <input
            type="password"
            class="form-control"
            id="password"
            required
            v-model="customer.password"
            name="password"
        />
      </div>
      <button @click="saveCustomer" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newCustomer">Add</button>
    </div>
  </div>
</template>

<script>
import customerService from "@/customerWeb/services/customerService";

export default {
  name: "add-customer",
  data() {
    return {
      customer: {
        id: null,
        name: "",
        surname: "",
        email: '',
        password: '',
      },
      submitted: false
    };
  },
  methods: {
    saveCustomer() {
      let data = {
        name: this.customer.name,
        surname: this.customer.surname,
        email: this.customer.email,
        password: this.customer.password,
      };

      customerService.create(data)
          .then(response => {
            this.customer.id = response.data.id;
            console.log(response.data);
            this.submitted = true;
          })
          .catch(e => {
            console.log(e);
          });
    },

    newCustomer() {
      this.submitted = false;
      this.customer = {};
    }
  }
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>
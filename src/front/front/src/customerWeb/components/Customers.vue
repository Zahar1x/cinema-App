<template>
  <div>
    <div class="col-md-6">
      <h4>Customers List</h4>
      <ul class="list-group">
        <li class="list-group-item"
            :class="{ active: index === currentIndex }"
            v-for="(customer, index) in customers"
            :key="index"
            @click="setActiveCustomer(customer, index)"
        >
          {{ customer.id}}
          {{customer.name}}
        </li>
      </ul>

      <button class="m-3 btn btn-sm btn-danger" @click="removeAllCustomers">
        Remove All
      </button>
    </div>
    <div class="col-md-6">
      <div v-if="currentCustomer">
        <h4>Customer</h4>
        <div>
          <label><strong>Name:</strong></label> {{ currentCustomer.name }}
        </div>
        <div>
          <label><strong>Surname:</strong></label> {{ currentCustomer.surname  }}
        </div>
        <div>
          <label><strong>Email:</strong></label> {{ currentCustomer.email  }}
        </div>
        <a class="badge badge-warning bg-black"
           :href="'/customer/' + currentCustomer.id"
        >
          Edit
        </a>
      </div>
    </div>
  </div>
</template>

<script>
import customerService from "@/customerWeb/services/customerService";

export default {
  name: "customers-list",
  data() {
    return {
      customers: [],
      currentCustomer: null,
      currentIndex: -1,
      title: ""
    };
  },
  methods: {
    retrieveCustomers() {
      customerService.getAll()
          .then(response => {
            this.customers = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },

    refreshList() {
      this.retrieveCustomers();
      this.currentCustomer = null;
      this.currentIndex = -1;
    },

    setActiveCustomer(customer, index) {
      this.currentCustomer = customer;
      this.currentIndex = index;
    },

    removeAllCustomers() {
      customerService.deleteAll()
          .then(response => {
            console.log(response.data);
            this.refreshList();
          })
          .catch(e => {
            console.log(e);
          });
    },
  },
  mounted() {
    this.retrieveCustomers();
  }
};
</script>

<style>

</style>
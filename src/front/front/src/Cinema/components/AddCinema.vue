<template>
  <div class="row">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <a class="navbar-brand">Cinema application</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
                aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <a class="nav-link active" aria-current="page" href="/">Home</a>
            <a class="nav-link" href="/customer">Customers page</a>
            <a class="nav-link" href="/sessions">Sessions</a>
            <a class="nav-link" href="/movies">Movies</a>
            <a class="nav-link" href="/cinema">Cinemas</a>
          </div>
        </div>
      </div>
    </nav>
    <div class="submit-form">
      <div v-if="!submitted">
        <div class="form-group">
          <label for="name">Name</label>
          <input
              type="text"
              class="form-control"
              id="name"
              required
              v-model="cinema.name"
              name="name"
          />
        </div>
        <div class="form-group">
          <label for="address">Address</label>
          <input
              type="text"
              class="form-control"
              id="address"
              required
              v-model="cinema.address"
              name="address"
          />
        </div>
        <button @click="saveCinema" class="btn btn-success mt-2">Submit</button>
      </div>

      <div v-else class="mt-5">
        <h4>You submitted successfully!</h4>
        <button class="btn btn-success" @click="newCinema">Add</button>
      </div>
    </div>
  </div>

</template>

<script>
import CinemaService from "@/Cinema/services/CinemaService";

export default {
  name: "add-cinema",
  data() {
    return {
      cinema: {
        id: null,
        name: "",
        address: "",
      },
      submitted: false,
    };
  },
  methods: {
    saveCinema() {
      let data = {
        name: this.cinema.name,
        surname: this.cinema.address,
      };

      CinemaService.create(data)
          .then(response => {
            this.cinema.id = response.data.id;
            this.submitted = true;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },

    newCinema() {
      this.submitted = false;
      this.cinema = {};
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
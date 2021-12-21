<template>
  <div class="container mt-16">
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
    <h4>Cinemas</h4>
    <ul class="list-group">
      <li class="list-group-item"
          :class="{ active: index === currentIndex }"
          v-for="(cinema, index) in cinemas"
          :key="index"
          @click="setActiveCinema(cinema, index)"
      >
        <div class="row">
          <div class="col-6">
          {{cinema.name}}
          </div>
          <div class="col-6">
            {{cinema.address}}
          </div>
        </div>
      </li>
    </ul>
    <a class="badge badge-warning bg-black" :href="'/cinema/add'">
      Add new cinema
    </a>
    <div class="col-12">
      <div v-if="currentCinema">
        <h4>Customer</h4>
        <div>
          <label><strong>Name:</strong></label> {{ currentCinema.name }}
        </div>
        <div>
          <label><strong>Address:</strong></label> {{ currentCinema.address  }}
        </div>
        <a class="badge badge-warning bg-black"
           :href="'/cinema/' + currentCinema.id"
        >
          Edit
        </a>
      </div>
    </div>
  </div>
</template>
<script>
import CinemaService from "@/Cinema/services/CinemaService"

export default {
  name: "session",
  components: {
  },
  data() {
    return {
      cinemas: [],
      currentCinema: null,
      currentIndex: -1,
      title: ""
    };
  },
  methods: {
    retrieveCinema() {
      CinemaService.getAll()
          .then(response => {
            this.cinemas = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },
    refreshList() {
      this.retrieveCinema();
      this.currentCinema = null;
      this.currentIndex = -1;
    },

    setActiveCinema(cinema, index) {
      this.currentCinema = cinema;
      this.currentIndex = index;
    },
    getCinema(id) {
      CinemaService.get(id)
          .then(response => {
            this.currentCinema = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },
    updateCinema() {
      CinemaService.update(this.currentCinema.id, this.currentCinema)
          .then(response => {
            console.log(response.data);
            this.message = 'The cinema was updated successfully!';
          })
          .catch(e => {
            console.log(e);
          });
    },

    deleteCinema() {
      CinemaService.delete(this.currentCinema.id)
          .then(response => {
            console.log(response.data);
            this.$router.push({ name: "cinema" });
          })
          .catch(e => {
            console.log(e);
          });
    }
  },
  mounted() {
    this.retrieveCinema()
  }
}

</script>
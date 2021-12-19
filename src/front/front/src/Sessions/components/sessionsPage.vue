<template>
  <div class="container mt-16">
    <div class="row">
      <div class="col">
        <h4>Sessions List</h4>
        <ul class="list-group">
          <li class="list-group-item"
              :class="{ active: index === currentIndex }"
              v-for="(session, index) in sessions"
              :key="index"
              @click="setActiveSession(session, index)"
          >
            {{ session.id}}
            {{session.date}}
          </li>
        </ul>
      </div>
      <div class="col">

      </div>
    </div>
  </div>
</template>
<script>
import sessionService from "@/Sessions/services/sessionService";

export default {
  name: "session",
  data() {
    return {
      sessions: [],
      currentSession: null,
      currentIndex: -1,
      title: ""
    };
  },
  methods: {
    retrieveSession() {
      sessionService.getAll()
          .then(response => {
            this.sessions = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },
    refreshList() {
      this.retrieveSession();
      this.currentSession = null;
      this.currentIndex = -1;
    },

    setActiveSession(session, index) {
      this.currentSession = session;
      this.currentIndex = index;
    },
    getSession(id) {
      sessionService.get(id)
          .then(response => {
            this.currentSession = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },
    updateSession() {
      sessionService.update(this.currentSession.id, this.currentSession)
          .then(response => {
            console.log(response.data);
            this.message = 'The customer was updated successfully!';
          })
          .catch(e => {
            console.log(e);
          });
    },

    deleteSession() {
      sessionService.delete(this.currentSession.id)
          .then(response => {
            console.log(response.data);
            this.$router.push({ name: "session" });
          })
          .catch(e => {
            console.log(e);
          });
    }
  },
  mounted() {
    this.retrieveSession()
  }
}

</script>
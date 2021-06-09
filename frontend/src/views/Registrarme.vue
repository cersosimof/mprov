<template>
  <div>
    <Navbar>
      <div class="container" style="width: 30%; height: 70vh">
        <h3 style="color: white; border-bottom: 1px solid white">Credenciales</h3>

        <div class="mb-3">
          <label for="nombreNewUser" class="form-label" style="color: white">Nombre</label>
          <input type="email" class="form-control" id="nombreNewUser" v-model="nombreNewUser">
        </div>

        <div class="mb-3">
          <label for="apellidoNewUser" class="form-label" style="color: white">Apellido</label>
          <input type="text" class="form-control" id="apellidoNewUser" v-model="apellidoNewUser">
        </div>

        <div class="mb-3">
          <label for="emailNewUser" class="form-label" style="color: white">Email</label>
          <input type="email" class="form-control" id="emailNewUser" v-model="emailNewUser">
        </div>

        <div class="mb-3">
          <label for="usernameNewUser" class="form-label" style="color: white">Nombre de Usuario</label>
          <input type="text" class="form-control" id="usernameNewUser" v-model="userNameNewUser">
        </div>

        <div class="mb-3">
          <label for="passNewUser" class="form-label" style="color: white">Contraseña</label>
          <input type="password" class="form-control" id="passNewUser" v-model="passNewUser">
        </div>

        <div class="mb-3">
          <label for="pass2NewUser" class="form-label" style="color: white">Repetir Contraseña</label>
          <input type="password" class="form-control" id="pass2NewUser" v-model="pass2NewUser"
                 v-on:keyup.enter="registrarme">
        </div>

        <button class="btn btn-success" style="width: 100%" v-on:click="registrarme">Ingresar</button>
        <br>
      </div>
    </Navbar>
  </div>

</template>

<script>
import Navbar from "@/views/components/Navbar";

export default {
  name: "Ayuda",
  computed: {
    nombreNewUser: {
      get() {
        return this.$store.state.nombreNewUser;
      },
      set(value) {
        this.$store.commit("SET_NEW_NOMBRE", value);
      },
    },
    apellidoNewUser: {
      get() {
        return this.$store.state.apellidoNewUser;
      },
      set(value) {
        this.$store.commit("SET_NEW_APELLIDO", value);
      },
    },
    emailNewUser: {
      get() {
        return this.$store.state.emailNewUser;
      },
      set(value) {
        this.$store.commit("SET_NEW_EMAIL", value);
      },
    },

    userNameNewUser: {
      get() {
        return this.$store.state.userNameNewUser;
      },
      set(value) {
        this.$store.commit("SET_NEW_USER_NAME", value);
      },
    },
    passNewUser: {
      get() {
        return this.$store.state.passNewUser;
      },
      set(value) {
        this.$store.commit("SET_NEW_PASS", value);
      },
    },
    pass2NewUser: {
      get() {
        return this.$store.state.pass2NewUser;
      },
      set(value) {
        this.$store.commit("SET_NEW_PASS_2", value);
      },
    },
  },
  components: {
    Navbar
  },
  methods: {
    registrarme: function () {
        this.$store.dispatch("ingresarUsuario");
    },
  },

}
</script>
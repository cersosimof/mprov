<template>
  <div>
    <Navbar>
    <div class="container" style="width: 30%; height: 70vh">
      <br><br><br><br>

      <h3 style="color: white; border-bottom: 1px solid white">Credenciales</h3>
        <div class="mb-3">
          <label for="userLogin" class="form-label" style="color: white">Email / Usuario</label>
          <input type="email" class="form-control" id="userLogin" v-model="user">
          <div id="emailHelp" class="form-text">Correo electronico o nombre de usuario.</div>
        </div>
        <div class="mb-3">
          <label for="loginPass" class="form-label" style="color: white">Contraseña</label>
          <input type="password" class="form-control" id="loginPass" v-model="pass" v-on:keyup.enter="ingresar">
        </div>
        <button class="btn btn-success" style="width: 100%" v-on:click="ingresar">Iniciar</button>
      <br>
      <p style="color: white">Sin cuenta?, <span class="registrarseBoton" @click="registrarme()">registrarse.</span></p>
    </div>
    </Navbar>
  </div>

</template>
<style>
.registrarseBoton {
  cursor: pointer;
}

.registrarseBoton:hover {
  text-decoration: underline;
}
</style>
<script>
import Navbar from "@/views/components/Navbar";
import router from "@/router"

export default {
  name: "Login",
  computed: {
    user: {
      get() {
        return this.$store.state.user;
      },
      set(value) {
        this.$store.commit("SET_USER", value);
      },
    },
    pass: {
      get() {
        return this.$store.state.pass;
      },
      set(value) {
        this.$store.commit("SET_PASS", value);
      },
    },
  },
  components: {
    Navbar
  },
  methods: {
    ingresar: function () {
      this.$store.commit("SET_BLOQUEADO", true);
      if(this.user != "" && this.pass != "") {
        this.$store.dispatch("validarLogin");
      } else {
        this.$store.commit('SET_BLOQUEADO',false);
        alert("Usuario o contraseña invalido.")
      }
    },
    registrarme () {
      router.push("/registrarme")
    }
  },

}
</script>
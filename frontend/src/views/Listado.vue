<template>
  <div>
    <Navbar>
    <div class="container" style="width: 30%; height: 70vh">

      <p style="color: white">listado</p>

    </div>
    </Navbar>
  </div>

</template>

<script>
import Navbar from "@/views/components/Navbar";

export default {
  name: "Listado",
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
  },

}
</script>
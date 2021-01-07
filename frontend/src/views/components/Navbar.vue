<template>
  <div>
    <nav class="navbar navbar-dark bg-dark">
      <div class="container-fluid">
        <div class="container" style="display: flex">

          <a class="navbar-brand" href="#">CHERSO</a>

          <ul class="navbar-nav me-auto mb-2 mb-lg-0" style="display: flex; flex-direction: row">
            <li class="nav-item iconNav">
              <a class="nav-link active" aria-current="page" href="/">Home</a>
            </li>
            <li class="nav-item iconNav">
              <a class="nav-link" href="/ayuda">Ayuda</a>
            </li>
          </ul>
          <a v-if="this.$session.get('REFRESH_TOKEN') != null" style="color: white" class="nav-link">Hola {{this.$session.get("USERNAME")}}!, <span @click="cerrarSesion()" class="botonSalir">Salir!</span></a>
          <button class="btn btn-outline-success" v-else @click="irALogin()">Login</button>
        </div>
      </div>
    </nav>
    <br><br>


  <slot></slot>

  <div class="fontColorNavbar container" >
    <br>
    <br>
    <hr>
    <div style="text-align: center">
      FOOTER
    </div>
  </div>
  <Spinner></Spinner>
  </div>
</template>

<style>

.iconNav {
  padding: 0px 10px;
}

.fontColorNavbar {
  color: white;
}
.botonSalir:hover {
  text-decoration: underline;
  cursor: pointer;
}

</style>
<script>
import router from '@/router/index.js'
import Spinner from "@/views/components/Spinner";

export default {
  name: 'Navbar',
  components: {Spinner},
  component: {
    Spinner
  },
  methods: {
    irALogin() {
      router.push({ path: '/login' })
    },
    cerrarSesion() {
      this.$store.dispatch("cerrarSesion");
    },
  }

}
</script>
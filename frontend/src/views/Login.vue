<template>
  <div>
    <Navbar>
    <div class="container" style="width: 30%; height: 70vh">
      <br><br><br><br>

      <h3 style="color: white; border-bottom: 1px solid white">Credenciales</h3>
      <form>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label" style="color: white">Email</label>
          <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
          <div id="emailHelp" class="form-text">Correo electronico con el que se dio de alta. {{ this.$store.state.user }}</div>
        </div>
        <div class="mb-3">
          <label for="exampleInputPassword1" class="form-label" style="color: white">Contraseña</label>
          <input type="password" class="form-control" id="exampleInputPassword1">
        </div>
        <button type="submit" class="btn btn-success" style="width: 100%" >Iniciar</button>
      </form>
    </div>
    </Navbar>
  </div>

</template>

<script>
import Navbar from "@/views/components/Navbar";

export default {
  name: "Login",

  components: {
    Navbar
  },

}
</script>
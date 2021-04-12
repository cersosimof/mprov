<template>
  <div>
    <Navbar>
      <div class="container" style="height: 70vh">

        <h2 style="color: white; border-bottom: 1px solid white; padding-bottom: 10px; margin-bottom: 40px;">OPCIONES</h2>

        <div style="display: flex;flex-flow: row wrap;flex-direction: row;justify-content: space-between; height: 70vh">

          <div class="boxMenu" @click="irARegistrar()">
            <div
                style="height: 45%;padding-top: 10px;background-color: rgb(207, 226, 207);border-radius: 5px;padding-top: 17px;">
              <i class="fas fa-plus-square"
                 style="color: #198754; font-size: 70px; height: 40%;display: flex;justify-content: center;"></i>
            </div>
            <h4 style="border-bottom: 1px solid black; padding-top: 8px">REGISTRAR</h4>
            <p>Registre a su empresa, indicando los tags en los que ofrece servicios.</p>
          </div>

          <div class="boxMenu" @click="irAListado()">
            <div
                style="height: 45%;padding-top: 10px;background-color: rgb(207, 226, 207);border-radius: 5px;padding-top: 17px;">
              <i class="fas fa-th-list"
                 style="color: #198754; font-size: 70px; height: 40%;display: flex;justify-content: center;"></i>
            </div>
            <h4 style="border-bottom: 1px solid black; padding-top: 8px">LISTADO</h4>
            <p>Armar una lista con las empresas del ramo buscado.</p>
          </div>

          <div class="boxMenu" @click="irAAyuda()">
            <div
                style="height: 45%;padding-top: 10px;background-color: rgb(207, 226, 207);border-radius: 5px;padding-top: 17px;">
              <i class="fas fa-question-circle"
                 style="color: #198754; font-size: 70px; height: 40%;display: flex;justify-content: center;"></i>
            </div>
            <h4 style="border-bottom: 1px solid black; padding-top: 8px">AYUDA</h4>
            <p>Informacion acerca de los servicios.</p>
          </div>

          <div class="boxMenu" @click="irADashboard()">
            <div
                style="height: 45%;padding-top: 10px;background-color: rgb(207, 226, 207);border-radius: 5px;padding-top: 17px;">
              <i class="fas fa-tachometer-alt"
                 style="color: #198754; font-size: 70px; height: 40%;display: flex;justify-content: center;"></i>
            </div>
            <h4 style="border-bottom: 1px solid black; padding-top: 8px">DASHBOARD</h4>
            <p>Estadisticas sobre los movimientos de la plataforma.</p>
          </div>


        </div>
      </div>
    </Navbar>
  </div>

</template>

<style>

.boxMenu {
  background-color: whitesmoke;
  border: 1px solid grey;
  width: 22%;
  height: 30vh;
  border-radius: 5px;
  padding: 15px;
  cursor: pointer;
}

.boxMenu:hover {
  background-color: #eaeaea;
}

.fontColor {
  color: white;
}

.styleLeft {
  height: 50%;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: flex-end;
  padding-bottom: 30px;
}

.styleLeft2 {
  height: 50%;
  text-align: center
}

.styleRight {
  width: 50%;
  display: flex;
  flex-direction: row;
  justify-content: center;
}


</style>
<script>
import Navbar from "@/views/components/Navbar";
import router from "@/router/index.js"

export default {
  name: "Main",
  components: {
    Navbar
  },
  methods: {
    irARegistrar() {
      router.push("/registrar")
    },
    irAListado() {
      router.push("/listado")
    },
    irAAyuda() {
      router.push("/ayuda")
    },
    irADashboard() {
      router.push("/dashboard")
    },

  }

}
</script>
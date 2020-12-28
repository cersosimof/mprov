<template>
  <div>
    <Navbar></Navbar>
    <div class="container">
      <h1>ESTE ES EL HOME.VUE</h1>
    </div>
  </div>

</template>

<script>
import Navbar from "@/views/components/Navbar";

export default {
  name: "Home",
  components: {
    Navbar
  },

}
</script>
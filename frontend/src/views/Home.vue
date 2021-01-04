<template>
  <div>
    <Navbar>
    <div class="container">
      <div style="display: flex">
        <div style="width: 50%; padding: 0px 20px;">
          <h1 class="fontColor styleLeft" >ESTE ES EL HOME.VUE</h1>
          <p class="fontColor styleLeft2" >Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto excepturi harum totam. Ducimus esse id illo, illum in ipsa ipsam iure labore mollitia nostrum, nulla perspiciatis quam saepe sit, voluptate.</p>
        </div>
        <div class="styleRight">
          <img src="farol.jpg" alt="" style="height: 70vh; padding: 0px 20px">
        </div>
      </div>



    </div>
    </Navbar>
  </div>

</template>

<style>

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

export default {
  name: "Home",
  components: {
    Navbar
  },

}
</script>
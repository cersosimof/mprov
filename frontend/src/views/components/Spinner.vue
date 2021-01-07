<template>
  <div v-bind:class="{ ocultar: !this.$store.state.bloqueado }" style="position: fixed; z-index: 9999; top: 0px; left: 0px; width: 100%; height: 100%; background: grey; opacity: 0.5;">
    <div class="lds-dual-ring"></div>
  </div>
</template>
<style>
.lds-dual-ring {
  height: 100%;
  display: flex;
  flex-direction: column;
  width: 100%;
  justify-content: center;
  align-items: center;
}
.lds-dual-ring:after {
  content: " ";
  display: block;
  width: 100px;
  height: 100px;
  margin: 8px;
  border-radius: 50%;
  border: 6px solid #033349;
  border-color: #033349 transparent #033349 transparent;
  animation: lds-dual-ring 1.2s linear infinite;
}
@keyframes lds-dual-ring {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}

.ocultar {
  display: none !important;
}
</style>
<script>
export default {
  name: "Spinner",
};
</script>

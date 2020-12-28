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

        </div>
      </div>
    </nav>
    <br><br>
  </div>
</template>

<style>

.iconNav {
  padding: 0px 10px;
}

.fontColorNavbar {
  color: white;
}

</style>
<script>
export default {
  name: 'Navbar',

}
</script>
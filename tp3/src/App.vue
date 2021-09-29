<template>
  <div id="app">
    <ListeResto/>
  </div>
</template>

<script>
import ListeResto from './components/ListeResto.vue'

export default {
  name: 'App',
  components: {
    ListeResto
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

<template>
  <div id="app">
    <HelloWorld/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
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

/*// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyB72GS8x3hLExYtT5Ytn_kUznQCX7-YOJE",
  authDomain: "m1miagetp1-7070f.firebaseapp.com",
  projectId: "m1miagetp1-7070f",
  storageBucket: "m1miagetp1-7070f.appspot.com",
  messagingSenderId: "386482326059",
  appId: "1:386482326059:web:8c640135bb3aa6cb4d386e"
}; */

import Vue from 'vue'
import App from './App.vue'

import {initializeApp} from 'firebase/app'
import {getFirestore} from 'firebase/firestore'

initializeApp({
  apiKey: "AIzaSyB72GS8x3hLExYtT5Ytn_kUznQCX7-YOJE",
  authDomain: "m1miagetp1-7070f.firebaseapp.com",
  projectId: "m1miagetp1-7070f",
  storageBucket: "m1miagetp1-7070f.appspot.com",
  messagingSenderId: "386482326059",
  appId: "1:386482326059:web:8c640135bb3aa6cb4d386e"
});

Vue.prototype.$db = getFirestore();

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')

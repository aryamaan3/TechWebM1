<template>
  <div id="resto">
      <form v-on:submit="ajouterRestaurant">
        <label>
            Nom : <input type="text" required v-model="name">
        </label>
        <label>
            Cuisine : <input type="text" required v-model="cuisine">
        </label>

        <button>Ajouter</button>
    </form>

    <form v-on:submit="search">
        <label>
            Rechercher un restau : <input type="text" required v-model="recherche">
        </label>
        <button>Chercher</button>
    </form>

    <h1>Nombre de restaurants : {{restaurants.length}}</h1>
    <div class="slidecontainer">
        <input v-on:input="slideChanged($event)" type="range" min="5" max="100" value="5" class="slider" id="myRange">
        <p id="valeurSlide">{{range}}</p>
    </div>
    <table>
        <tr>
            <th>Name</th>
            <th>Cuisine </th>
        </tr>
        <tbody>
            <tr v-for="r,index in restaurants" v-bind:key="index" v-on:click="supprimerRestaurant(index)" v-bind:style="{backgroundColor:getColor(index)}"
                v-bind:class="{bordureRouge:(index === 2)}">
                <td>{{r.name}}</td>
                <td> {{r.cuisine}}</td>
            </tr>
        </tbody>
    </table>
    <button :disabled="nbPage===0" v-on:click="getRestaurantsFromServer($event)" value="0">Précédant</button>
    <button v-on:click="getRestaurantsFromServer($event)" value="1">Suivant</button>
  </div>
</template>

<script>

export default {
  name: 'Resto',
  components: {
  }, 
  mounted() {
    this.getRestaurantsFromServer();
  },
  data: function () {
    return({
            restaurants: [],
            name: '',
            cuisine: '', 
            recherche:'',
            nbPage: 0, 
            range: 5, 
            nomSearched: ''
    })},
  methods: {
    supprimerRestaurant(index) {
        this.restaurants.splice(index, 1);
    },
    ajouterRestaurant(event) {
        // eviter le comportement par defaut
        event.preventDefault
        this.restaurants.push(
            {
                name: this.name,
                cuisine: this.cuisine
            }
        );
        this.name = "";
        this.cuisine = "";
    },
    getColor(index) {
        return (index % 2) ? 'lightBlue' : 'pink';
    }, 
    getRestaurantsFromServer(isSuivant) {
        if(isSuivant){
            if(isSuivant.target.value === "1"){
                this.nbPage++;
            }
            else{
                if (this.nbPage > 0) {
                    this.nbPage--;
                }
            }
        }
        fetch('http://localhost:8080/api/restaurants?page='+this.nbPage+"&pagesize="+this.range+"&name="+this.nomSearched, {
            method: 'GET'
        }).then((resto) => {
            resto.json().then((resto) => { //no lo sait
                for (let i = 0; i < resto.data.length; i++) {
                    this.restaurants = resto.data;
                }
                this.longeur = this.restaurants.length;
            });
        }).catch(function(error) {
            console.log(error);
        });
    }, 
    slideChanged(event) {
        if(event.target.value){
            this.range = event.target.value;
        }
        this.getRestaurantsFromServer()
    }, 
    search(event) {
        event.preventDefault();
        this.nomSearched = this.recherche
        this.getRestaurantsFromServer()
    }

  }
}
</script>

<style scoped>
#resto {
    width: 100%;
}
</style>
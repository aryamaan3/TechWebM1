window.onload=init;

function init() {
    new Vue({
        el: "#app",
        mounted() {
            console.log("avant HTML")
            this.getRestaurantsFromServer()
        },
        data: {
            restaurants: [],
            name: '',
            cuisine: '', 
            nbPage: 0
        },
        methods: {
            supprimerRestaurant(index) {
                this.restaurants.splice(index, 1);
            },
            ajouterRestaurant(event) {
                // eviter le comportement par defaut
                event.preventDefault();

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
            getRestaurantsFromServer() {
                fetch('http://localhost:8080/api/restaurants?page=0', {
                    method: 'GET'
                }).then((resto) => {
                    resto.json().then((resto) => { //no lo sait
                        for (let i = 0; i < resto.data.length; i++) {
                            this.restaurants.push(resto.data[i]);
                        }
                        this.longeur = this.restaurants.length;
                    });
                }).catch(function(error) {
                    console.log(error);
                });
            }, 
            getPrecedent() {
                if (this.nbPage > 0) {
                    this.nbPage--;
                }
                fetch('http://localhost:8080/api/restaurants?page='+this.nbPage, {
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

            getSuivant() {
                this.nbPage++;
                fetch('http://localhost:8080/api/restaurants?page='+this.nbPage, {
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
            }

        }
    })
}

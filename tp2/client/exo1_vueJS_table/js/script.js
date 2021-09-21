window.onload=init;

function init() {
    new Vue({
        el: "#app",
        mounted() {
            console.log("avant HTML")
            this.getRestaurantsFromServer()
        },
        data: {
            restaurants: [
                {
                    name: 'café de Paris',
                    cuisine: 'Française'
                },
                {
                    name: 'Sun City Café',
                    cuisine: 'Américaine'
                }
            ],
            name: '',
            cuisine: ''
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
                fetch('http://localhost:8080/api/restaurants', {
                    method: 'GET'
                }).then((resto) => {
                    resto.json().then((resto) => { //no lo sait
                        for (let i = 0; i < resto.data.length; i++) {
                            this.restaurants.push(resto.data[i]);
                        }
                    });
                }).catch(function(error) {
                    console.log(error);
                });
            }
        }
    })
}

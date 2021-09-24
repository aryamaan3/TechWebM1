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
            recherche:'',
            nbPage: 0, 
            range: 5
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
            getRestaurantsFromServer(isSuivant) {
                console.log(this.nbPage)
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
                fetch('http://localhost:8080/api/restaurants?page='+this.nbPage+"&pagesize="+this.range, {
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
                
                console.log(this.recherche)
                fetch('http://localhost:8080/api/restaurants/2', {
                    method: 'GET'
                }).then((resto) => {
                    resto.json().then((resto) => { //no lo sait
                        console.log(resto.data)
                    });
                }).catch(function(error) {
                    console.log(error);
                });
            }

        }
    })
}

loadRestaurants();

function loadRestaurants() {

    fetch("http://localhost:8080/api/restaurants")

    .then(response => {

        if (!response.ok) {
            throw new Error("Failed to fetch restaurants");
        }

        return response.json();

    })

    .then(restaurants => {

        displayRestaurants(restaurants);

    })

    .catch(error => {

        console.log(error);

        alert("Unable to load restaurants.");

    });

}

function searchRestaurant() {

    const name = document.getElementById("searchRestaurant").value;

    fetch("http://localhost:8080/api/restaurants/search?name=" + name)

    .then(response => response.json())

    .then(restaurants => {

        displayRestaurants(restaurants);

    });

}

function filterCuisine(){

    const cuisine=document.getElementById("cuisineFilter").value;

    if(cuisine==""){

        loadRestaurants();

        return;

    }

    fetch("http://localhost:8080/api/restaurants/cuisine/"+cuisine)

    .then(response=>response.json())

    .then(restaurants=>{

        displayRestaurants(restaurants);

    });

}

function displayRestaurants(restaurants) {

    const restaurantList = document.getElementById("restaurantList");

    restaurantList.innerHTML = "";

    if (restaurants.length === 0) {

    restaurantList.innerHTML = `

        <div class="card">

            <h2>No Restaurants Found</h2>

            <p>Try another restaurant name or click <b>Show All</b>.</p>

        </div>

    `;

    return;

}

    restaurants.forEach(restaurant => {

        restaurantList.innerHTML += `

        <div class="card">

            <img src="${restaurant.imageUrl}" alt="${restaurant.restaurantName}">

            <h2>${restaurant.restaurantName}</h2>

            <p>📍 <b>City:</b> ${restaurant.city}</p>

            <p>🍽 <b>Cuisine:</b> ${restaurant.cuisine}</p>

            <p>⭐ <b>Rating:</b> ${restaurant.rating}</p>

            <p>${restaurant.description}</p>

            <p>📞 <b>Contact:</b> ${restaurant.contactNumber}</p>

            <p>📧 <b>Email:</b> ${restaurant.email}</p>

            <a href="restaurant-details.html?id=${restaurant.id}">
                <button>View Details</button>
            </a>

        </div>

        `;

    });

}
console.log("admin.js loaded");

function addHotel() {

    const hotel = {

        hotelName: document.getElementById("hotelName").value,
        city: document.getElementById("city").value,
        address: document.getElementById("address").value,
        description: document.getElementById("description").value,
        contactNumber: document.getElementById("contactNumber").value,
        email: document.getElementById("email").value,
        imageUrl: document.getElementById("imageUrl").value,
        rating: parseFloat(document.getElementById("rating").value),
        category: document.getElementById("category").value

    };

    fetch("http://localhost:8080/api/hotels", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(hotel)
    })

    .then(response => {

        if (!response.ok) {
            throw new Error("Failed to add hotel. Status: " + response.status);
        }

        return response.json();

    })

    .then(data => {

        alert("Hotel Added Successfully");
        window.location.href = "hotels.html";

    })

    .catch(error => {

        alert(error);
        console.log(error);

    });

}

function deleteHotel() {

    const id = document.getElementById("deleteHotelId").value;

    fetch("http://localhost:8080/api/hotels/" + id, {
        method: "DELETE"
    })

    .then(() => {

        alert("Hotel Deleted Successfully");
        location.reload();

    });

}
function updateHotel() {

    const id = document.getElementById("updateId").value;

    const hotel = {

        hotelName: document.getElementById("updateHotelName").value,

        city: document.getElementById("updateCity").value,

        address: document.getElementById("updateAddress").value,

        description: document.getElementById("updateDescription").value,

        contactNumber: document.getElementById("updateContactNumber").value,

        email: document.getElementById("updateEmail").value,

        imageUrl: document.getElementById("updateImageUrl").value,

        rating: parseFloat(document.getElementById("updateRating").value),

        category: document.getElementById("updateCategory").value

    };

    fetch("http://localhost:8080/api/hotels/" + id, {

        method: "PUT",

        headers: {

            "Content-Type": "application/json"

        },

        body: JSON.stringify(hotel)

    })

    .then(response => {

        if (!response.ok) {

            throw new Error("Failed to update hotel");

        }

        return response.json();

    })

    .then(data => {

        alert("Hotel Updated Successfully");

        window.location.href = "hotels.html";

    })

    .catch(error => {

        console.log(error);

        alert(error);

    });

}

function addRestaurant() {

    const restaurant = {

        restaurantName: document.getElementById("restaurantName").value,

        city: document.getElementById("restaurantCity").value,

        address: document.getElementById("restaurantAddress").value,

        description: document.getElementById("restaurantDescription").value,

        contactNumber: document.getElementById("restaurantContactNumber").value,

        email: document.getElementById("restaurantEmail").value,

        imageUrl: document.getElementById("restaurantImageUrl").value,

        cuisine: document.getElementById("restaurantCuisine").value,

        rating: parseFloat(document.getElementById("restaurantRating").value)

    };

    fetch("http://localhost:8080/api/restaurants", {

        method: "POST",

        headers: {

            "Content-Type": "application/json"

        },

        body: JSON.stringify(restaurant)

    })

    .then(response => {

        if (!response.ok) {

            throw new Error("Failed to add restaurant");

        }

        return response.json();

    })

    .then(data => {

        alert("Restaurant Added Successfully");

        window.location.href = "restaurants.html";

    })

    .catch(error => {

        console.log(error);

        alert(error);

    });

}

function deleteRestaurant() {

    const id = document.getElementById("deleteRestaurantId").value;

    fetch("http://localhost:8080/api/restaurants/" + id, {

        method: "DELETE"

    })

    .then(() => {

        alert("Restaurant Deleted Successfully");

        location.reload();

    });

}

function updateRestaurant() {

    const id = document.getElementById("updateRestaurantId").value;

    const restaurant = {

        restaurantName: document.getElementById("updateRestaurantName").value,

        city: document.getElementById("updateRestaurantCity").value,

        address: document.getElementById("updateRestaurantAddress").value,

        description: document.getElementById("updateRestaurantDescription").value,

        contactNumber: document.getElementById("updateRestaurantContactNumber").value,

        email: document.getElementById("updateRestaurantEmail").value,

        imageUrl: document.getElementById("updateRestaurantImageUrl").value,

        cuisine: document.getElementById("updateRestaurantCuisine").value,

        rating: parseFloat(document.getElementById("updateRestaurantRating").value)

    };

    fetch("http://localhost:8080/api/restaurants/" + id, {

        method: "PUT",

        headers: {

            "Content-Type": "application/json"

        },

        body: JSON.stringify(restaurant)

    })

    .then(response => {

        if (!response.ok) {

            throw new Error("Failed to update restaurant");

        }

        return response.json();

    })

    .then(data => {

        alert("Restaurant Updated Successfully");

        window.location.href = "restaurants.html";

    })

    .catch(error => {

        console.log(error);

        alert(error);

    });

}
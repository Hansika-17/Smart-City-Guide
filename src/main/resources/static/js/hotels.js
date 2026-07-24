loadHotels();

function loadHotels() {

    fetch("http://localhost:8080/api/hotels")

    .then(response => {

        if (!response.ok) {
            throw new Error("Failed to fetch hotels");
        }

        return response.json();

    })

    .then(hotels => {

        displayHotels(hotels);

    })

    .catch(error => {

        console.log(error);

        alert("Unable to load hotels.");

    });

}

function searchHotel() {

    const name = document.getElementById("searchHotel").value;

    fetch("http://localhost:8080/api/hotels/search?name=" + name)

    .then(response => response.json())

    .then(hotels => {

        displayHotels(hotels);

    });

}

function filterCategory() {

    const category = document.getElementById("categoryFilter").value;

    if(category==""){

        loadHotels();

        return;

    }

    fetch("http://localhost:8080/api/hotels/category/" + category)

    .then(response => response.json())

    .then(hotels => {

        displayHotels(hotels);

    });

}

function displayHotels(hotels) {

    const hotelList = document.getElementById("hotelList");

    hotelList.innerHTML = "";

    if (hotels.length === 0) {

    hotelList.innerHTML = `

        <div class="card">

            <h2>No Hotels Found</h2>

            <p>Try another hotel name or click <b>Show All</b>.</p>

        </div>

    `;

    return;

}

    hotels.forEach(hotel => {

        hotelList.innerHTML += `

        <div class="card">

            <img src="${hotel.imageUrl}" alt="${hotel.hotelName}">

            <h2>${hotel.hotelName}</h2>

            <p>📍 <b>City:</b> ${hotel.city}</p>

            <p>🏨 <b>Category:</b> ${hotel.category}</p>

            <p>⭐ <b>Rating:</b> ${hotel.rating}</p>

            <p>${hotel.description}</p>

            <p>📞 <b>Contact:</b> ${hotel.contactNumber}</p>

            <p>📧 <b>Email:</b> ${hotel.email}</p>

            <a href="hotel-details.html?id=${hotel.id}">
                <button>View Details</button>
            </a>

        </div>

        `;

    });

}
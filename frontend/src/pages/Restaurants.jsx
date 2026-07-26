import { useEffect, useState } from "react";
import Navbar from "../components/Navbar";
import "../styles/Restaurants.css";
import restaurantPlaceholder from "../assets/restaurant_placeholder.jpg";

function Restaurants() {
	
	const [restaurants, setRestaurants] = useState([]);
	const [search, setSearch] = useState("");
	
	useEffect(() => {
	    fetch("http://localhost:8080/api/restaurants")
	        .then((response) => response.json())
	        .then((data) => setRestaurants(data))
	        .catch((error) => console.error(error));
	}, []);
	
    return (
        <>
            <Navbar />

            <div className="restaurant-page">

                <div className="restaurant-header">
                    <h1>Delicious Food Around Every Corner</h1>

                    <p>
                        Explore cafés, fine dining restaurants,
                        street food, and local favorites.
                    </p>
                </div>

                <div className="restaurant-search">
                    <input
    type="text"
    placeholder="🔍 Search restaurants..."
    value={search}
    onChange={(e) => setSearch(e.target.value)}
/>
                </div>

				<div className="restaurant-grid">
				    {restaurants
    .filter((restaurant) =>
        restaurant.restaurantName.toLowerCase().includes(search.toLowerCase()) ||
        restaurant.city.toLowerCase().includes(search.toLowerCase())
    )
    .map((restaurant) => (
		
				        <div className="restaurant-card" key={restaurant.id}>

				            <div className="restaurant-image">
								<img
									src={restaurant.imageUrl}
									alt={restaurant.restaurantName}
									onError={(e) => {
										e.currentTarget.onerror = null;
										e.currentTarget.src = restaurantPlaceholder;
									}}
								/>
							</div>

				            <h2>{restaurant.restaurantName}</h2>

				            <p>
				                ⭐ {restaurant.rating} • {restaurant.city}
				            </p>

				            <button
				                onClick={() => window.open(restaurant.mapLink, "_blank")}
				            >
				                📍 Get Directions
				            </button>

				        </div>
				    ))}
				</div>

            </div>

        </>
    );
}

export default Restaurants;
import Navbar from "../components/Navbar";
import "../styles/Hotels.css";
import { useEffect, useState } from "react";

function Hotels() {
	
	const [hotels, setHotels] = useState([]);
	
	useEffect(() => {
	    fetch("http://localhost:8080/api/hotels")
	        .then((response) => response.json())
	        .then((data) => setHotels(data))
	        .catch((error) => console.error("Error fetching hotels:", error));
	}, []);
	
    return (
        <>
            <Navbar />

            <div className="hotel-page">

                <div className="hotel-header">
                    <h1>Luxury Stays & Cozy Escapes</h1>
                    <p>
                        Discover premium hotels, budget-friendly stays,
                        and unforgettable hospitality for your next journey.
                    </p>
                </div>

                <div className="hotel-search">
                    <input
                        type="text"
                        placeholder="🔍 Search hotels..."
                    />
                </div>

				{hotels.map((hotel) => (
				    <div className="hotel-card" key={hotel.id}>

				        <div className="hotel-image">
				            <img
				                src={hotel.imageUrl}
				                alt={hotel.hotelName}
				            />
				        </div>

				        <h2>{hotel.hotelName}</h2>

				        <p>
				            ⭐ {hotel.rating} • {hotel.city}
				        </p>

				        <button
				            onClick={() => window.open(hotel.website, "_blank")}
				        >
				            Book Now
				        </button>

				    </div>
				))}

            </div>

        </>
    );
}

export default Hotels;
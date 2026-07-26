import Navbar from "../components/Navbar";
import "../styles/Hotels.css";
import { useEffect, useState } from "react";
import hotelPlaceholder from "../assets/hotel_placeholder.jpg";

function Hotels() {

    const [hotels, setHotels] = useState([]);
    const [search, setSearch] = useState("");
    const [selectedHotel, setSelectedHotel] = useState(null);

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
                        value={search}
                        onChange={(e) => setSearch(e.target.value)}
                    />
                </div>

                <div className="hotel-grid">

                    {hotels
                        .filter((hotel) =>
                            hotel.hotelName.toLowerCase().includes(search.toLowerCase()) ||
                            hotel.city.toLowerCase().includes(search.toLowerCase())
                        )
                        .map((hotel) => (

                            <div
                                className="hotel-card"
                                key={hotel.id}
                                onClick={() => setSelectedHotel(hotel)}
                            >

                                <div className="hotel-image">
                                    <img
                                        src={hotel.imageUrl}
                                        alt={hotel.hotelName}
                                        onError={(e) => {
                                            e.currentTarget.onerror = null;
                                            e.currentTarget.src = hotelPlaceholder;
                                        }}
                                    />
                                </div>

                                <h2>{hotel.hotelName}</h2>

                                <p>
                                    ⭐ {hotel.rating} • {hotel.city}
                                </p>

                                <button
                                    onClick={(e) => {
                                        e.stopPropagation();
                                        window.open(hotel.website, "_blank");
                                    }}
                                >
                                    Book Now
                                </button>

                            </div>

                        ))}

                </div>

                {selectedHotel && (
                    <div className="modal-overlay">

                        <div className="modal-content">

                            <span
                                className="close-btn"
                                onClick={() => setSelectedHotel(null)}
                            >
                                ×
                            </span>

                            <img
                                src={selectedHotel.imageUrl}
                                alt={selectedHotel.hotelName}
                                className="modal-image"
                                onError={(e) => {
                                    e.currentTarget.onerror = null;
                                    e.currentTarget.src = hotelPlaceholder;
                                }}
                            />

                            <h2>{selectedHotel.hotelName}</h2>

							<p><strong>📍 City:</strong> {selectedHotel.city}</p>

							<p><strong>🏨 Address:</strong> {selectedHotel.address}</p>

							<p><strong>⭐ Rating:</strong> {selectedHotel.rating} / 5</p>

							<p><strong>💰 Price Range:</strong> {selectedHotel.priceRange}</p>

							<p><strong>🏷 Category:</strong> {selectedHotel.category}</p>

							<p><strong>🎯 Best For:</strong> {selectedHotel.bestFor}</p>

							<p><strong>✨ Amenities:</strong> {selectedHotel.amenities}</p>

							<p><strong>📞 Contact:</strong> {selectedHotel.contactNumber}</p>

							<p><strong>📧 Email:</strong> {selectedHotel.email}</p>

							<p>{selectedHotel.description}</p>

							<button
								onClick={() =>
									window.open(selectedHotel.website, "_blank")
								}
							>
								Book Now
							</button>
                        </div>

                    </div>
                )}

            </div>

        </>
    );
}

export default Hotels;
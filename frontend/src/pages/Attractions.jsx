import Navbar from "../components/Navbar";
import "../styles/Attractions.css";
import { useState, useEffect } from "react";

function Attractions() {

    const [attractions, setAttractions] = useState([]);
    const [search, setSearch] = useState("");
    const [selectedAttraction, setSelectedAttraction] = useState(null);

    useEffect(() => {
        fetch("http://localhost:8080/api/attractions")
            .then((res) => res.json())
            .then((data) => {
                console.log(data[0]);
                setAttractions(data);
            })
            .catch((err) => console.error(err));
    }, []);

    return (
        <>
            <Navbar />

            <div className="attraction-page">

                <div className="attraction-header">
                    <h1>Discover Iconic Attractions</h1>

                    <p>
                        Explore breathtaking landmarks, hidden gems,
                        museums, parks, and unforgettable experiences.
                    </p>
                </div>

                <div className="attraction-search">
                    <input
                        type="text"
                        placeholder="🔍 Search attractions..."
                        value={search}
                        onChange={(e) => setSearch(e.target.value)}
                    />
                </div>

                <div className="attraction-grid">

                    {attractions
                        .filter((attraction) =>
                            attraction.attractionName.toLowerCase().includes(search.toLowerCase()) ||
                            attraction.city.toLowerCase().includes(search.toLowerCase()) ||
                            attraction.category.toLowerCase().includes(search.toLowerCase())
                        )
                        .map((attraction) => (

                        <div className="attraction-card" key={attraction.id}>

                            <img
                                src={attraction.imageUrl}
                                alt={attraction.attractionName}
                                className="attraction-image"
                            />

                            <h2>{attraction.attractionName}</h2>

                            <p>
                                ⭐ {attraction.rating} • {attraction.city}
                            </p>

                            <button onClick={() => setSelectedAttraction(attraction)}>
                                View Details
                            </button>

                        </div>

                    ))}
                    </div>

{selectedAttraction && (
    <div className="modal-overlay">

        <div className="modal-content">

            <span
                className="close-btn"
                onClick={() => setSelectedAttraction(null)}
            >
                ×
            </span>

            <img
                src={selectedAttraction.imageUrl}
                alt={selectedAttraction.attractionName}
                className="modal-image"
            />

            <h2>{selectedAttraction.attractionName}</h2>

            <p>
                <strong>📍 City:</strong> {selectedAttraction.city}
            </p>

            <p>
                <strong>🏛 Address:</strong> {selectedAttraction.address}
            </p>

            <p>
                <strong>💰 Entry Fee:</strong> {selectedAttraction.entryFee}
            </p>

            <p>
                <strong>⏱ Time Required:</strong> {selectedAttraction.timeRequired}
            </p>

            <p>
                <strong>⭐ Best For:</strong> {selectedAttraction.bestFor}
            </p>

            <p>
                {selectedAttraction.description}
            </p>

        </div>

    </div>
)}
                                </div>
                            </>
                        );
}

export default Attractions;
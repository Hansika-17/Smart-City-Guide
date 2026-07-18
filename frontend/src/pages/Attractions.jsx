import Navbar from "../components/Navbar";
import "../styles/Attractions.css";

function Attractions() {
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
                    />
                </div>

                <div className="attraction-grid">

                    <div className="attraction-card">
                        <div className="attraction-image"></div>

                        <h2>Charminar</h2>

                        <p>⭐ 4.8 • Hyderabad</p>

                        <button>View Details</button>
                    </div>

                    <div className="attraction-card">
                        <div className="attraction-image"></div>

                        <h2>Gateway of India</h2>

                        <p>⭐ 4.7 • Mumbai</p>

                        <button>View Details</button>
                    </div>

                    <div className="attraction-card">
                        <div className="attraction-image"></div>

                        <h2>Mysore Palace</h2>

                        <p>⭐ 4.9 • Mysuru</p>

                        <button>View Details</button>
                    </div>

                </div>

            </div>
        </>
    );
}

export default Attractions;
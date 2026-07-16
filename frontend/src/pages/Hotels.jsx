import Navbar from "../components/Navbar";
import "../styles/Hotels.css";

function Hotels() {
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

                <div className="hotel-grid">

                    <div className="hotel-card">
                        <div className="hotel-image"></div>

                        <h2>Grand Palace Hotel</h2>

                        <p>⭐ 4.8 • Hyderabad</p>

                        <button>View Details</button>
                    </div>

                    <div className="hotel-card">
                        <div className="hotel-image"></div>

                        <h2>Sunset Resort</h2>

                        <p>⭐ 4.7 • Goa</p>

                        <button>View Details</button>
                    </div>

                    <div className="hotel-card">
                        <div className="hotel-image"></div>

                        <h2>Royal Heights</h2>

                        <p>⭐ 4.9 • Jaipur</p>

                        <button>View Details</button>
                    </div>

                </div>

            </div>

        </>
    );
}

export default Hotels;
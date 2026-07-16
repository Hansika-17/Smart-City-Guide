import Navbar from "../components/Navbar";
import "../styles/Restaurants.css";

function Restaurants() {
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
                    />
                </div>

                <div className="restaurant-grid">

                    <div className="restaurant-card">
                        <div className="restaurant-image"></div>

                        <h2>Spice Garden</h2>

                        <p>⭐ 4.7 • Hyderabad</p>

                        <button>View Details</button>
                    </div>

                    <div className="restaurant-card">
                        <div className="restaurant-image"></div>

                        <h2>Olive Bistro</h2>

                        <p>⭐ 4.9 • Bengaluru</p>

                        <button>View Details</button>
                    </div>

                    <div className="restaurant-card">
                        <div className="restaurant-image"></div>

                        <h2>Coastal Kitchen</h2>

                        <p>⭐ 4.8 • Goa</p>

                        <button>View Details</button>
                    </div>

                </div>

            </div>

        </>
    );
}

export default Restaurants;
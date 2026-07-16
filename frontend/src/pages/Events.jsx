import Navbar from "../components/Navbar";
import "../styles/Events.css";

function Events() {
    return (
        <>
            <Navbar />

            <div className="event-page">

                <div className="event-header">
                    <h1>Experience Exciting Events</h1>

                    <p>
                        Discover concerts, festivals, exhibitions,
                        cultural celebrations, and live events happening around you.
                    </p>
                </div>

                <div className="event-search">
                    <input
                        type="text"
                        placeholder="🔍 Search events..."
                    />
                </div>

                <div className="event-grid">

                    <div className="event-card">
                        <div className="event-image"></div>

                        <h2>Music Festival</h2>

                        <p>📅 25 July • Hyderabad</p>

                        <button>View Details</button>
                    </div>

                    <div className="event-card">
                        <div className="event-image"></div>

                        <h2>Food Carnival</h2>

                        <p>📅 2 August • Bengaluru</p>

                        <button>View Details</button>
                    </div>

                    <div className="event-card">
                        <div className="event-image"></div>

                        <h2>Art Exhibition</h2>

                        <p>📅 10 August • Mumbai</p>

                        <button>View Details</button>
                    </div>

                </div>

            </div>
        </>
    );
}

export default Events;
import Navbar from "../components/Navbar";
import "../styles/Events.css";
import { useState, useEffect } from "react";
import eventPlaceholder from "../assets/events_placeholder.jpg";

function Events() {

    const [events, setEvents] = useState([]);
    const [search, setSearch] = useState("");
    const [selectedEvent, setSelectedEvent] = useState(null);

        useEffect(() => {
            console.log("Selected Event Changed:", selectedEvent);
        }, [selectedEvent]);

        useEffect(() => {
            fetch("http://localhost:8080/api/events")
                .then((res) => res.json())
                .then((data) => setEvents(data))
                .catch((err) => console.error(err));
        }, []);

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
                        value={search}
                        onChange={(e) => setSearch(e.target.value)}
                    />
                </div>

                <div className="event-grid">

                    {events
                        .filter((event) =>
                            event.eventName.toLowerCase().includes(search.toLowerCase()) ||
                            event.city.toLowerCase().includes(search.toLowerCase()) ||
                            event.category.toLowerCase().includes(search.toLowerCase())
                        )
                        .map((event) => (

                        <div className="event-card" key={event.id}>

                            <img
                                src={event.imageUrl}
                                alt={event.eventName}
                                className="event-image"
                                onError={(e) => {
                                    e.currentTarget.onerror = null;
                                    e.currentTarget.src = eventPlaceholder;
                                }}
                            />

                            <h2>{event.eventName}</h2>

                            <p>📍 {event.city}</p>

                            <p>📅 {event.timings}</p>

                            <button onClick={() => {
                                console.log("clicked", event);
                                setSelectedEvent(event);
                            }}>
                                View Details
                            </button>

                        </div>
                    ))}

                </div>

            </div>

            {selectedEvent && (
                <div className="modal-overlay">
                    <div className="modal-content">

                        <span
                            className="close-btn"
                            onClick={() => setSelectedEvent(null)}
                        >
                            ×
                        </span>

                        <img
                            src={selectedEvent.imageUrl}
                            alt={selectedEvent.eventName}
                            className="modal-image"
                            onError={(e) => {
                                e.currentTarget.onerror = null;
                                e.currentTarget.src = eventPlaceholder;
                            }}
                        />

                        <h2>{selectedEvent.eventName}</h2>

                        <p><strong>📍 City:</strong> {selectedEvent.city}</p>
                        <p><strong>🏛 Venue:</strong> {selectedEvent.venue}</p>
                        <p><strong>🕒 Timings:</strong> {selectedEvent.timings}</p>
                        <p><strong>🎟 Ticket:</strong> {selectedEvent.ticketPrice}</p>
                        <p><strong>⭐ Best For:</strong> {selectedEvent.bestFor}</p>

                        <p>{selectedEvent.description}</p>

                    </div>
                </div>
            )}

        </>
    );
}

export default Events;
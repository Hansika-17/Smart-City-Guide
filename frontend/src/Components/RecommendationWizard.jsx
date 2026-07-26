import { useState } from "react";
import "../styles/RecommendationWizard.css";

function RecommendationWizard() {

    const [step, setStep] = useState(1);
    const [city, setCity] = useState("");
    const [travelType, setTravelType] = useState("");
    const [memberCount, setMemberCount] = useState(2);
    const [currentMember, setCurrentMember] = useState(1);
    const [members, setMembers] = useState([]);
    const [memberData, setMemberData] = useState({
        nickname: "",
        budget: "",
        persona: "",
        timeAvailable: "",
        transport: ""
    });
    const [groupResult, setGroupResult] = useState(null);
    

    return (
        <div className="wizard-card">

            <div className="wizard-step">
                Step {step} of 6
            </div>

            {step === 1 && (
                <>
                    <h2>Where are you travelling?</h2>

                    <select
                        value={city}
                        onChange={(e) => setCity(e.target.value)}
                    >
                        <option value="">Select a city</option>
                        <option>Hyderabad</option>
                        <option>Bengaluru</option>
                        <option>Chennai</option>
                        <option>Mumbai</option>
                        <option>Delhi</option>
                        <option>Jaipur</option>
                        <option>Kochi</option>
                        <option>Visakhapatnam</option>
                        <option>Vijayawada</option>
                        <option>Panaji</option>
                    </select>

                    <button
                        onClick={() => {
                            if (city === "") {
                                alert("Please select a city.");
                                return;
                            }

                            setStep(2);
                        }}
                    >
                        Next →
                    </button>
                </>
            )}

            {step === 2 && (
                <>
                    <h2>Who are you travelling with?</h2>

                    <div className="travel-options">

                        <div
                            className={`travel-option ${travelType === "solo" ? "selected" : ""}`}
                            onClick={() => {
                                setTravelType("solo");
                                setTimeout(() => {
                                    setStep(3);
                                }, 200);
                            }}
                        >
                            <h3>Solo Explorer</h3>
                            <p>
                                Discover the city at your own pace with personalized recommendations.
                            </p>
                        </div>

                        <div
                            className={`travel-option ${travelType === "group" ? "selected" : ""}`}
                            onClick={() => {
                                setTravelType("group");
                                setTimeout(() => {
                                    setStep(3);
                                }, 200);
                            }}
                        >
                            <h3>Group Adventure</h3>
                            <p>
                                Find places and activities everyone in your group will enjoy.
                            </p>
                        </div>

                    </div>
                </>
            )}

            {step === 3 && (
                <>
                    {travelType === "solo" ? (
                        <>
                            <h2>What's your budget?</h2>

                            <p style={{ color: "#555" }}>
                                Budget options coming next...
                            </p>
                        </>
                    ) : (
                        <>
                            <h2>How many people are travelling?</h2>

                            <select
                                value={memberCount}
                                onChange={(e) => setMemberCount(Number(e.target.value))}
                            >
                                <option value={2}>2</option>
                                <option value={3}>3</option>
                                <option value={4}>4</option>
                                <option value={5}>5</option>
                            </select>

                            <button onClick={() => setStep(4)}>
                                Next →
                            </button>
                        </>
                    )}
                </>
            )}

            {step === 4 && (
                <>
                    <h2 style={{ color: "#2E2433" }}>
                        {memberData.nickname || `Member ${currentMember}`}
                    </h2>

                    <p
                        className="member-subtitle"
                        style={{ color: "#666" }}
                    >
                        Tell us a little about {memberData.nickname || `Member ${currentMember}`}.
                    </p>

                    <input
                        className="wizard-input"
                        type="text"
                        placeholder="Enter a nickname"
                        value={memberData.nickname}
                        onChange={(e) =>
                            setMemberData({
                                ...memberData,
                                nickname: e.target.value
                            })
                        }
                    />

                    <select
                        value={memberData.budget}
                        onChange={(e) =>
                            setMemberData({
                                ...memberData,
                                budget: e.target.value
                            })
                        }
                    >
                        <option value="">Select Budget</option>
                        <option value="budget">Budget</option>
                        <option value="mid-range">Mid Range</option>
                        <option value="luxury">Luxury</option>
                    </select>

                    <select
                        value={memberData.persona}
                        onChange={(e) =>
                            setMemberData({
                                ...memberData,
                                persona: e.target.value
                            })
                        }
                    >
                        <option value="">Select Persona</option>
                        <option value="Student">Student</option>
                        <option value="Foodie">Foodie</option>
                        <option value="Influencer">Influencer</option>
                        <option value="History Lover">History Lover</option>
                        <option value="Nature Explorer">Nature Explorer</option>
                        <option value="Business Traveller">Business Traveller</option>
                    </select>

                    <select
                        value={memberData.timeAvailable}
                        onChange={(e) =>
                            setMemberData({
                                ...memberData,
                                timeAvailable: e.target.value
                            })
                        }
                    >
                        <option value="">Select Time Available</option>
                        <option value="1 hour">1 Hour</option>
                        <option value="1-2 hours">1-2 Hours</option>
                        <option value="2 hours">2 Hours</option>
                        <option value="2-3 hours">2-3 Hours</option>
                        <option value="3 hours">3 Hours</option>
                        <option value="3-4 hours">3-4 Hours</option>
                        <option value="4-5 hours">4-5 Hours</option>
                        <option value="half day">Half Day</option>
                        <option value="full day">Full Day</option>
                    </select>


                    <select
                        value={memberData.transport}
                        onChange={(e) =>
                            setMemberData({
                                ...memberData,
                                transport: e.target.value
                            })
                        }
                    >
                        <option value="">Select Transport</option>
                        <option value="walking">Walking</option>
                        <option value="bike">Bike</option>
                        <option value="car">Car</option>
                    </select>

                    <button
                     onClick={() => {

                        if (
                            memberData.budget === "" ||
                            memberData.persona === "" ||
                            memberData.timeAvailable === "" ||
                            memberData.transport === ""
                        ) {
                            alert("Please complete all preferences before continuing.");
                            return;
                        }

                        const newMember = {
                            nickname: memberData.nickname,
                            budget: memberData.budget,
                            persona: memberData.persona,
                            timeAvailable: memberData.timeAvailable,
                            transport: memberData.transport
                        };

                        const updatedMembers = [...members, newMember];

                        setMembers(updatedMembers);

                        setMemberData({
                            nickname: "",
                            budget: "",
                            persona: "",
                            timeAvailable: "",
                            transport: ""
                        });

                        if (currentMember < memberCount) {

                            setCurrentMember(currentMember + 1);

                        } 
                        
                        else {

                            const groupPayload = {
                                city: city,
                                members: updatedMembers.map(member => ({
                                    priceRange: member.budget,
                                    bestFor: member.persona,
                                    timeAvailable: member.timeAvailable,
                                    transport: member.transport
                                })),
                                surpriseMe: false
                            };

                            fetch("http://localhost:8080/api/group-recommendations", {
                                method: "POST",
                                headers: {
                                    "Content-Type": "application/json"
                                },
                                body: JSON.stringify(groupPayload)
                            })
                            .then(response => response.json())
                            .then(data => {
                                setGroupResult(data);
                                console.log("GROUP RESULT:", JSON.stringify(data, null, 2));
                                setStep(5);
                            })
                            .catch(error => {
                                console.error("Error fetching group recommendations:", error);
                            });

                        }

                    }}

            
                    >
                        Continue →
                    </button>

                </>
            )}

            {step === 5 && groupResult && (
                <div className="compatibility-result">

                    <h2 className="compatibility-title">
                        Your Group Compatibility
                    </h2>

                    <div className="score-circle">
                        {groupResult.compatibilityScore}%
                    </div>


                    <div className="compatibility-card">

                        <h3>
                            Group Summary
                        </h3>

                        <p className="group-explanation">
                            {groupResult.explanation}
                        </p>
                    </div>


                    <div className="preferences-card">

                        <h3>
                            Common Preferences
                        </h3>

                        <div className="preference-item">
                            <strong>Budget</strong>
                            <span>{groupResult.commonBudget}</span>
                        </div>

                        <div className="preference-item">
                            <strong>Persona</strong>
                            <span>{groupResult.commonPersona}</span>
                        </div>

                        <div className="preference-item">
                            <strong>Time</strong>
                            <span>{groupResult.commonTimeAvailable}</span>
                        </div>

                        <div className="preference-item">
                            <strong>Transport</strong>
                            <span>{groupResult.commonTransport}</span>
                        </div>

                    </div>

                    <button
                        className="recommendation-button"
                        onClick={() => setStep(6)}
                    >
                        View Recommendations →
                    </button>

                </div>
            )}

            {step === 6 && groupResult && (
                    <div className="recommendation-result">

                        <h2>Your Group Recommendations</h2>

                        <div className="recommendation-section">

                            <h3> Hotels</h3>

                            {groupResult.hotels.length === 0 ? (
                                <p>No hotels found matching your preferences.</p>
                            ) : (
                                groupResult.hotels.map((hotel) => (
                                    <div className="recommendation-card" key={hotel.id}>

                                        <img
                                            src={hotel.imageUrl}
                                            alt={hotel.hotelName}
                                        />

                                        <h4>{hotel.hotelName}</h4>

                                        <p>
                                            ⭐ {hotel.rating} • {hotel.city}
                                        </p>

                                        <button
                                            onClick={() => window.open(hotel.website, "_blank")}
                                        >
                                            Book Now
                                        </button>

                                    </div>
                                ))
                            )}

                        </div>


                        <div className="recommendation-section">
                            <h3> Restaurants</h3>

                            {groupResult.restaurants.length === 0 ? (
                                <p>No restaurants found matching your preferences.</p>
                            ) : (
                                <p>Restaurant cards coming here...</p>
                            )}
                        </div>


                        <div className="recommendation-section">
                            <h3> Attractions</h3>

                            {groupResult.attractions.length === 0 ? (
                                <p>No attractions found matching your preferences.</p>
                            ) : (
                                <p>Attraction cards coming here...</p>
                            )}
                        </div>


                        <div className="recommendation-section">
                            <h3> Events</h3>

                            {groupResult.events.length === 0 ? (
                                <p>No events found matching your preferences.</p>
                            ) : (
                                <p>Event cards coming here...</p>
                            )}
                        </div>

                    </div>
                )}

        </div>
    );
}

export default RecommendationWizard;
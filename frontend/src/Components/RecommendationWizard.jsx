import { useState } from "react";
import "../styles/RecommendationWizard.css";

function RecommendationWizard() {

    const [step, setStep] = useState(1);
    const [city, setCity] = useState("");
    const [travelType, setTravelType] = useState("");

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
                        <h2>What's your budget?</h2>

                        <p style={{ color: "#555" }}>
                            Budget options coming next...
                        </p>
                    </>
                )}

        </div>
    );
}

export default RecommendationWizard;
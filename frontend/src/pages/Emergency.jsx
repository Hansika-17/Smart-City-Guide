import Navbar from "../components/Navbar";
import "../styles/Emergency.css";

function Emergency() {

	const emergencies = [
	    {
	        id: 1,
	        title: "Medical Emergency",
	        icon: "🚑",
	        phone: "108",
	        description: "Immediate medical assistance.",
	        action: "Stay calm and share your exact location.",
	        map: "https://www.google.com/maps/search/hospital+near+me"
	    },
	    {
	        id: 2,
	        title: "Road Accident",
	        icon: "🚗",
	        phone: "108",
	        description: "Emergency medical response for accidents.",
	        action: "Avoid moving injured people unless necessary.",
	        map: "https://www.google.com/maps/search/trauma+center+near+me"
	    },
	    {
	        id: 3,
	        title: "Fire Emergency",
	        icon: "🔥",
	        phone: "101",
	        description: "Fire or smoke emergency.",
	        action: "Evacuate immediately and call the fire service.",
	        map: "https://www.google.com/maps/search/fire+station+near+me"
	    },
	    {
	        id: 4,
	        title: "Police Assistance",
	        icon: "👮",
	        phone: "112",
	        description: "Crime, theft or public safety.",
	        action: "Move to a safe place before calling.",
	        map: "https://www.google.com/maps/search/police+station+near+me"
	    },
	    {
	        id: 5,
	        title: "Women's Safety",
	        icon: "👩",
	        phone: "1091",
	        description: "Women's emergency helpline.",
	        action: "Share your location with trusted contacts.",
	        map: "https://www.google.com/maps/search/police+station+near+me"
	    },
	    {
	        id: 6,
	        title: "Child Helpline",
	        icon: "🧒",
	        phone: "1098",
	        description: "Emergency support for children.",
	        action: "Report the incident immediately.",
	        map: "https://www.google.com/maps/search/police+station+near+me"
	    },
	    {
	        id: 7,
	        title: "Snake Bite",
	        icon: "🐍",
	        phone: "108",
	        description: "Medical emergency.",
	        action: "Keep the victim calm. Don't cut the wound.",
	        map: "https://www.google.com/maps/search/hospital+near+me"
	    },
	    {
	        id: 8,
	        title: "Dog Bite",
	        icon: "🐕",
	        phone: "108",
	        description: "Seek medical treatment immediately.",
	        action: "Wash the wound with clean water.",
	        map: "https://www.google.com/maps/search/hospital+near+me"
	    },
	    {
	        id: 9,
	        title: "Food Poisoning",
	        icon: "🤢",
	        phone: "108",
	        description: "Serious food poisoning symptoms.",
	        action: "Stay hydrated and seek medical help.",
	        map: "https://www.google.com/maps/search/hospital+near+me"
	    },
	    {
	        id: 10,
	        title: "Lost Passport",
	        icon: "🛂",
	        phone: "112",
	        description: "Report loss and contact your embassy.",
	        action: "File a police complaint first.",
	        map: "https://www.google.com/maps/search/police+station+near+me"
	    },
	    {
	        id: 11,
	        title: "Lost Wallet",
	        icon: "👛",
	        phone: "112",
	        description: "Report theft or loss.",
	        action: "Block cards immediately.",
	        map: "https://www.google.com/maps/search/police+station+near+me"
	    },
	    {
	        id: 12,
	        title: "Lost Mobile",
	        icon: "📱",
	        phone: "112",
	        description: "Report lost phone.",
	        action: "Block your SIM card.",
	        map: "https://www.google.com/maps/search/police+station+near+me"
	    },
	    {
	        id: 13,
	        title: "Gas Leak",
	        icon: "⛽",
	        phone: "1906",
	        description: "Gas leakage emergency.",
	        action: "Turn off the gas and leave the area.",
	        map: "https://www.google.com/maps/search/gas+agency+near+me"
	    },
	    {
	        id: 14,
	        title: "Electric Shock",
	        icon: "⚡",
	        phone: "108",
	        description: "Electrical emergency.",
	        action: "Switch off the power before helping.",
	        map: "https://www.google.com/maps/search/hospital+near+me"
	    },
	    {
	        id: 15,
	        title: "Flood",
	        icon: "🌊",
	        phone: "1070",
	        description: "Flood emergency assistance.",
	        action: "Move to higher ground.",
	        map: "https://www.google.com/maps/search/emergency+shelter+near+me"
	    },
	    {
	        id: 16,
	        title: "Cyclone",
	        icon: "🌪️",
	        phone: "1077",
	        description: "Cyclone emergency.",
	        action: "Stay indoors and follow official advisories.",
	        map: "https://www.google.com/maps/search/emergency+shelter+near+me"
	    },
	    {
	        id: 17,
	        title: "Blood Bank",
	        icon: "🩸",
	        phone: "104",
	        description: "Need blood urgently.",
	        action: "Contact the nearest blood bank.",
	        map: "https://www.google.com/maps/search/blood+bank+near+me"
	    },
	    {
	        id: 18,
	        title: "Mental Health Support",
	        icon: "🧠",
	        phone: "14416",
	        description: "Mental health helpline.",
	        action: "Talk to a trained counsellor.",
	        map: "https://www.google.com/maps/search/hospital+near+me"
	    }
	];

    return (
        <>
            <Navbar />

            <div className="emergency-page">

                <div className="emergency-header">
                    <h1>🚨 Emergency Help Center</h1>

                    <p>
                        Quick access to emergency services, safety guidance,
                        and nearby assistance when you need it most.
                    </p>
                </div>
				
				<div className="emergency-search">
				    <input
				        type="text"
				        placeholder="🔍 Search emergency services..."
				    />
				</div>

                <div className="emergency-grid">
                    {emergencies.map((item) => (
                        <div className="emergency-card" key={item.id}>

                            <h2>
                                {item.icon} {item.title}
                            </h2>

							<p className="phone-number">
							    📞 Emergency Number: <strong>{item.phone}</strong>
							</p>

                            <p>{item.description}</p>

                            <p>
                                <strong>What to do:</strong><br />
                                {item.action}
                            </p>

                            <div className="button-group">

                                <a href={`tel:${item.phone}`}>
                                    <button>📞 Call</button>
                                </a>

                                <button
                                    onClick={() => window.open(item.map, "_blank")}
                                >
                                    📍 Find Nearby
                                </button>

                            </div>

                        </div>
                    ))}
                </div>

            </div>

        </>
    );
}

export default Emergency;
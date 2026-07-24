import Navbar from "../components/Navbar";
import { useNavigate } from "react-router-dom";
import travel1 from "../assets/travel1.jpg";
import travel2 from "../assets/travel2.jpg";
import travel3 from "../assets/travel3.jpg";
import travel4 from "../assets/travel4.jpg";
import travel5 from "../assets/travel5.jpg";
import travel6 from "../assets/travel6.jpg";
import travel7 from "../assets/travel7.jpg";
import travel8 from "../assets/travel8.jpg";
import travel9 from "../assets/travel9.jpg";
import travel10 from "../assets/travel10.jpg";
import hotelIcon from "../assets/hotel.png";
import restaurantIcon from "../assets/restaurants.png";
import attractionIcon from "../assets/attractions.png";
import eventIcon from "../assets/events.png";
import "../styles/Home.css";
import RecommendationWizard from "../components/RecommendationWizard";

function Home() {
	
	const navigate = useNavigate();
    return (
        <>
            <Navbar />

            <section className="hero">

				<div className="hero-left">
					<img src={travel1} alt="" className="side-photo left1" />
					<img src={travel2} alt="" className="side-photo left2" />
					<img src={travel3} alt="" className="side-photo left3" />
					<img src={travel4} alt="" className="side-photo left4" />
					<img src={travel5} alt="" className="side-photo left5" />
				</div>

				<div className="hero-center">

					<h1>Plan Your Perfect Trip</h1>

					<p>
						Discover hidden gems, luxurious stays, delicious restaurants,
						exciting events, and unforgettable attractions—all in one place.
					</p>

					<RecommendationWizard />

				</div>

				<div className="hero-right">
					<div className="hero-right">
						<img src={travel6} alt="" className="side-photo right1" />
						<img src={travel7} alt="" className="side-photo right2" />
						<img src={travel8} alt="" className="side-photo right3" />
						<img src={travel9} alt="" className="side-photo right4" />
						<img src={travel10} alt="" className="side-photo right5" />
					</div>
				</div>
				
            </section>
			
			<div
			    style={{
			        display: "grid",
			        gridTemplateColumns: "repeat(auto-fit, minmax(220px, 1fr))",
			        gap: "20px",
			        padding: "40px"
			    }}
			>

			<div style={cardStyle} onClick={() => navigate("/hotels")}>

			    <img
			        src={hotelIcon}
			        alt="Hotel"
			        style={{
			            width: "70px",
			            height: "70px",
			            objectFit: "contain",
			            marginBottom: "18px"
			        }}
			    />

			    <h2>Hotels</h2>

			    <p>Find the best hotels in your city.</p>

			</div>

			<div style={cardStyle} onClick={() => navigate("/restaurants")}>

			    <img
			        src={restaurantIcon}
			        alt="Restaurant"
			        style={{
			            width: "70px",
			            height: "70px",
			            objectFit: "contain",
			            marginBottom: "18px"
			        }}
			    />

			    <h2>Restaurants</h2>

			    <p>Explore popular restaurants nearby.</p>

			</div>

			<div style={cardStyle} onClick={() => navigate("/attractions")}>

						    <img
						        src={attractionIcon}
						        alt="Attractions"
						        style={{
						            width: "70px",
						            height: "70px",
						            objectFit: "contain",
						            marginBottom: "18px"
						        }}
						    />

						    <h2>Attractions</h2>

						    <p>Discover famous tourist attractions</p>

						</div>

			<div style={cardStyle} onClick={() => navigate("/events")}>

					<img
						src={eventIcon}
						alt="Events"
						style={{
						width: "70px",
						height: "70px",
						objectFit: "contain",
						marginBottom: "18px"
					}}
				/>

				<h2>Events</h2>

				<p>Stay updated with city events.</p>

			  	</div>

			</div>
			
			<div
			    style={{
			        background: "linear-gradient(135deg, #7B5C93 0%, #A98BBF 60%, #D9B86C 100%)",
			        color: "white",
			        margin: "50px 40px",
			        borderRadius: "24px",
			        padding: "50px",
			        textAlign: "center",
			        boxShadow: "0 12px 30px rgba(94,58,114,0.2)"
			    }}
			>
			    <h2
			        style={{
			            fontSize: "36px",
			            marginBottom: "15px"
			        }}
			    >
			        🤖 Smart AI Travel Assistant
			    </h2>

			    <p
			        style={{
			            maxWidth: "650px",
			            margin: "0 auto 30px",
			            lineHeight: "1.8",
			            fontSize: "17px"
			        }}
			    >
			        Planning a trip? Ask our AI for hotel recommendations,
			        restaurants, attractions, events, travel tips and much more.
			    </p>

				<button
				    onClick={() => navigate("/assistant")}
				    style={{
				        padding: "15px 35px",
				        border: "none",
				        borderRadius: "50px",
				        background: "#D9B86C",
				        color: "#2E2433",
				        fontWeight: "700",
				        fontSize: "16px",
				        cursor: "pointer"
				    }}
				>
				    Chat with AI →
				</button>
			</div>
			
        </>
    );
}

const cardStyle = {
    backgroundColor: "#ffffff",
    padding: "35px 25px",
    borderRadius: "18px",
    textAlign: "center",
    boxShadow: "0 8px 20px rgba(0,0,0,0.12)",
    cursor: "pointer",
    transition: "0.3s ease",
    minHeight: "220px",
    display: "flex",
    flexDirection: "column",
    justifyContent: "center",
    alignItems: "center"
};

export default Home;
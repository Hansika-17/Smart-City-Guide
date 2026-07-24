import Navbar from "../components/Navbar";
import { useNavigate } from "react-router-dom";
import signupImage from "../assets/travel11.jpg"; // <-- Change this if your image has a different name
import "../styles/Signup.css";

function Signup() {

    const navigate = useNavigate();

    const handleGoogleSignup = () => {
        alert("Google Signup will be connected to the backend soon.");
    };

    return (
        <>
            <Navbar />

            <div className="signup-page">

                {/* Left Hero Section */}
                <div className="signup-left">

                    <img
                        src={signupImage}
                        alt="Smart City Guide"
                        className="hero-image"
                    />

                    <div className="hero-overlay">

                        <h1>Your Next Adventure Starts Here</h1>

                        <p>
                            Join Smart City Guide and discover hotels,
                            restaurants, attractions, local events,
                            and AI-powered travel assistance.
                        </p>

                    </div>

                </div>

                {/* Right Signup Section */}
                <div className="signup-right">

                    <div className="signup-content">

                        <h2>Create Account ✨</h2>

                        <p className="subtitle">
                            Join Smart City Guide with your Google account.
                        </p>

                        <button
                            className="google-btn"
                            onClick={handleGoogleSignup}
                        >
                            Register with Google
                        </button>

                        <div className="divider">
                            <span>OR</span>
                        </div>

                        <p className="login-text">
                            Already have an account?
                        </p>

                        <button
                            className="login-link"
                            onClick={() => navigate("/login")}
                        >
                            Sign In
                        </button>

                    </div>

                </div>

            </div>

        </>
    );
}

export default Signup;
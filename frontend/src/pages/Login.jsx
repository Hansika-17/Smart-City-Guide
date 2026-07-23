import Navbar from "../components/Navbar";
import { useNavigate } from "react-router-dom";
import "../styles/Login.css";
import loginImage from "../assets/travel11.jpg";

function Login() {

    const navigate = useNavigate();

    const handleGoogleLogin = () => {
        alert("Google Login will be connected in the next step.");
    };

    return (
        <>
            <Navbar />

            <div className="login-page">

                {/* Left Side */}
				<div className="login-left">

				    <img
				        src={loginImage}
				        alt="Smart City Guide"
				        className="hero-image"
				    />

				    <div className="hero-overlay">

				        <h1>Smart City Guide</h1>

				        <p>
				            Explore hotels, restaurants,
				            attractions, events and AI-powered
				            travel assistance—all in one place.
				        </p>

				    </div>

				</div>

                {/* Right Side */}
                <div className="login-right">

                    <div className="login-content">

                        <h2>Welcome Back 👋</h2>

                        <p className="subtitle">
                            Sign in to continue exploring.
                        </p>

						<button
						    onClick={() => {
						        window.location.href = "http://localhost:8080/oauth2/authorization/google";
						    }}
						>
						    Continue with Google
						</button>

                        <div className="divider">
                            <span>OR</span>
                        </div>

                        <p className="register-text">
                            New to Smart City Guide?
                        </p>

                        <button
                            className="register-link"
                            onClick={() => navigate("/signup")}
                        >
                            Register with Google
                        </button>

                        <button
                            className="home-link"
                            onClick={() => navigate("/")}
                        >
                            ← Back to Home
                        </button>

                    </div>

                </div>

            </div>
        </>
    );
}

export default Login;
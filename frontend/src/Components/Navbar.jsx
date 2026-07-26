import { Link } from "react-router-dom";
import { useState, useEffect } from "react";
import logo from "../assets/mainlogo.png";

function Navbar() {

    const [user, setUser] = useState(null);

    useEffect(() => {
        fetch("http://localhost:8080/auth/me", {
            credentials: "include"
        })
            .then(res => res.json())
            .then(data => {
                if (data.authenticated === "true") {
                    setUser(data);
                }
            })
            .catch(err => console.log(err));
    }, []);

    return (
        <nav
            style={{
                background: "linear-gradient(90deg, #5E3A72, #7A4E8C, #A06FB5)",
                padding: "18px 50px",
                display: "flex",
                justifyContent: "space-between",
                alignItems: "center",
                boxShadow: "0 6px 18px rgba(94,58,114,0.25)",
                position: "sticky",
                top: "0",
                zIndex: "1000"
            }}
        >
            <div
                style={{
                    display: "flex",
                    alignItems: "center",
                    gap: "12px"
                }}
            >
                <img
                    src={logo}
                    alt="Logo"
                    style={{
                        width: "42px",
                        height: "42px",
                        objectFit: "contain"
                    }}
                />

                <h2
                    style={{
                        color: "#FFF8F0",
                        margin: 0,
                        fontSize: "28px",
                        fontWeight: "800",
                        letterSpacing: "1px"
                    }}
                >
                    Smart City Guide
                </h2>
            </div>

            <div
                style={{
                    display: "flex",
                    gap: "28px",
                    alignItems: "center"
                }}
            >
                <Link to="/" style={linkStyle}>Home</Link>
                <Link to="/hotels" style={linkStyle}>Hotels</Link>
                <Link to="/restaurants" style={linkStyle}>Restaurants</Link>
                <Link to="/attractions" style={linkStyle}>Attractions</Link>
                <Link to="/events" style={linkStyle}>Events</Link>

                <Link
                    to="/emergency"
                    style={{
                        color: "#E53935",
                        textDecoration: "none",
                        fontWeight: "700",
                        fontSize: "17px"
                    }}
                >
                    🚨 Emergency
                </Link>

                {user ? (
                    <>
                        <span
                            style={{
                                color: "#FFF8F0",
                                fontWeight: "600"
                            }}
                        >
                             {user.name}
                        </span>

                        <a
                            href="http://localhost:8080/logout"
                            style={linkStyle}
                        >
                            Logout
                        </a>
                    </>
                ) : (
                    <>
                        <Link to="/login" style={linkStyle}>Login</Link>
                        <Link to="/signup" style={linkStyle}>Sign Up</Link>
                    </>
                )}
            </div>
        </nav>
    );
}

const linkStyle = {
    color: "#FFF8F0",
    textDecoration: "none",
    fontWeight: "600",
    fontSize: "17px",
    transition: "0.3s"
};

export default Navbar;
import { useState } from "react";
import Navbar from "../components/Navbar";

function Assistant() {
	
	const [message, setMessage] = useState("");

	const [messages, setMessages] = useState([
	    {
	        sender: "ai",
	        text: "👋 Hello! I'm your Smart City AI Assistant. Ask me anything about hotels, restaurants, attractions, events or travel tips."
	    }
	]);
	
	const sendMessage = async () => {

	    if (message.trim() === "") return;

	    const userMessage = message;

	    // Show the user's message immediately
	    setMessages((prev) => [
	        ...prev,
	        {
	            sender: "user",
	            text: userMessage
	        }
	    ]);

	    setMessage("");

	    try {

	        const response = await fetch("http://localhost:8080/api/ai/chat", {

	            method: "POST",

	            headers: {
	                "Content-Type": "application/json"
	            },

	            body: JSON.stringify({
	                message: userMessage
	            })

	        });

	        const aiReply = await response.text();

	        setMessages((prev) => [
	            ...prev,
	            {
	                sender: "ai",
	                text: aiReply
	            }
	        ]);

	    } catch (error) {

	        setMessages((prev) => [
	            ...prev,
	            {
	                sender: "ai",
	                text: "❌ Unable to connect to the AI server."
	            }
	        ]);

	        console.error(error);
	    }
	};
	
    return (
        <>
            <Navbar />

            <div
                style={{
                    minHeight: "100vh",
                    background: "#FBF8FC",
                    padding: "50px 8%"
                }}
            >
                <h1
                    style={{
                        color: "#5E3A72",
                        textAlign: "center",
                        marginBottom: "10px"
                    }}
                >
                    🤖 Smart AI Travel Assistant
                </h1>

                <p
                    style={{
                        textAlign: "center",
                        color: "#6F6275",
                        marginBottom: "40px"
                    }}
                >
                    Ask anything about hotels, restaurants, attractions,
                    events or travel planning.
                </p>

                <div
                    style={{
                        maxWidth: "850px",
                        margin: "auto",
                        background: "white",
                        borderRadius: "24px",
                        boxShadow: "0 12px 30px rgba(94,58,114,.12)",
                        overflow: "hidden"
                    }}
                >

                    {/* Chat Area */}

                    <div
                        style={{
                            padding: "30px",
                            minHeight: "450px",
                            background: "#FDFBFE"
                        }}
                    >

					{messages.map((msg, index) => (

					    <div
					        key={index}
					        style={{
					            display: "flex",
					            justifyContent:
					                msg.sender === "user"
					                    ? "flex-end"
					                    : "flex-start",
					            marginBottom: "20px"
					        }}
					    >

					        <div
					            style={{
					                background:
					                    msg.sender === "user"
					                        ? "#D9B86C"
					                        : "#EADCF5",

					                color:
					                    msg.sender === "user"
					                        ? "#2E2433"
					                        : "#000",

					                padding: "16px 20px",

					                borderRadius: "18px",

					                maxWidth: "70%",

					                whiteSpace: "pre-wrap"
					            }}
					        >
					            {msg.text}
					        </div>

					    </div>

					))}

                    </div>

                    {/* Input Area */}

                    <div
                        style={{
                            display: "flex",
                            padding: "20px",
                            borderTop: "1px solid #eee",
                            gap: "15px"
                        }}
                    >
					<input
					    type="text"
					    placeholder="Ask your question..."
					    value={message}
					    onChange={(e) => setMessage(e.target.value)}
					    style={{
					        flex: 1,
					        padding: "15px",
					        borderRadius: "50px",
					        border: "1px solid #ddd",
					        outline: "none"
					    }}
					/>

					<button
					    onClick={sendMessage}
					    style={{
					        padding: "15px 28px",
					        border: "none",
					        borderRadius: "50px",
					        background: "#5E3A72",
					        color: "white",
					        cursor: "pointer"
					    }}
					>
					    Send
					</button>
                    </div>

                </div>

            </div>
        </>
    );
}

export default Assistant;
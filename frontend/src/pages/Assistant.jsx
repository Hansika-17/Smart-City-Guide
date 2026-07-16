import Navbar from "../components/Navbar";

function Assistant() {
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

                        {/* AI Message */}

                        <div
                            style={{
                                display: "flex",
                                marginBottom: "20px"
                            }}
                        >
                            <div
                                style={{
                                    background: "#EADCF5",
                                    padding: "16px 20px",
                                    borderRadius: "18px",
                                    maxWidth: "70%"
                                }}
                            >
                                👋 Hello! I'm your Smart City AI Assistant.
                                Ask me anything about hotels, restaurants,
                                attractions, events or travel tips.
                            </div>
                        </div>

                        {/* User Message */}

                        <div
                            style={{
                                display: "flex",
                                justifyContent: "flex-end"
                            }}
                        >
                            <div
                                style={{
                                    background: "#D9B86C",
                                    color: "#2E2433",
                                    padding: "16px 20px",
                                    borderRadius: "18px",
                                    maxWidth: "70%"
                                }}
                            >
                                Suggest the best hotels in Hyderabad.
                            </div>
                        </div>

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
                            style={{
                                flex: 1,
                                padding: "15px",
                                borderRadius: "50px",
                                border: "1px solid #ddd",
                                outline: "none"
                            }}
                        />

                        <button
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
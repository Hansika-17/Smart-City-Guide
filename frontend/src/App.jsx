import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "./pages/Home";
import Hotels from "./pages/Hotels";
import Restaurants from "./pages/Restaurants";
import Attractions from "./pages/Attractions";
import Events from "./pages/Events";
import Assistant from "./pages/Assistant";
import Emergency from "./pages/Emergency";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/hotels" element={<Hotels />} />
        <Route path="/restaurants" element={<Restaurants />} />
        <Route path="/attractions" element={<Attractions />} />
        <Route path="/events" element={<Events />} />
		<Route path="/assistant" element={<Assistant />} />
		<Route path="/emergency" element={<Emergency />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
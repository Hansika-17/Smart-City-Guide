import './App.css'

function App() {
  return (
    <div className="app">

      <header className="header">
        <h1>🌆 Smart City Guide</h1>
        <p>Discover Hotels, Restaurants, Attractions & Events</p>
      </header>

      <section className="cards">

        <div className="card">
          <h2>🏨 Hotels</h2>
          <p>Browse hotels available in the city.</p>
          <button>View Hotels</button>
        </div>

        <div className="card">
          <h2>🍽 Restaurants</h2>
          <p>Explore popular restaurants.</p>
          <button>View Restaurants</button>
        </div>

        <div className="card">
          <h2>📍 Tourist Attractions</h2>
          <p>Find famous places to visit.</p>
          <button>View Attractions</button>
        </div>

        <div className="card">
          <h2>🎉 Events</h2>
          <p>See upcoming events around the city.</p>
          <button>View Events</button>
        </div>

      </section>

    </div>
  )
}

export default App
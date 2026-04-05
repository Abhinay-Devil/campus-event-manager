import { useNavigate } from "react-router-dom";

export default function LandingPage() {
  const navigate = useNavigate();

  return (
    <div className="relative min-h-screen bg-[#020617] text-white overflow-hidden">

      {/* Glow Background */}
      <div className="absolute top-[-120px] left-[-120px] w-[500px] h-[500px] bg-purple-600 opacity-30 blur-[140px] rounded-full"></div>
      <div className="absolute bottom-[-120px] right-[-120px] w-[500px] h-[500px] bg-pink-600 opacity-30 blur-[140px] rounded-full"></div>

      {/* NAVBAR */}
      <div className="fixed top-0 w-full z-50 backdrop-blur-xl bg-white/5 border-b border-white/10">
        <div className="max-w-7xl mx-auto flex justify-between items-center px-6 py-4">
          <h1 className="text-xl font-bold text-purple-400">
            Eventify
          </h1>

          <div className="hidden md:flex gap-8 text-gray-300">
            <span className="hover:text-white cursor-pointer">Home</span>
            <span className="hover:text-white cursor-pointer">Features</span>
            <span className="hover:text-white cursor-pointer">Services</span>
            <span className="hover:text-white cursor-pointer">Contact</span>
            <span className="hover:text-white cursor-pointer">About</span>
            <span className="hover:text-white cursor-pointer">Pricing</span>
          </div>

          <button
            onClick={() => navigate("/login")}
            className="px-5 py-2 rounded-full bg-gradient-to-r from-purple-500 to-pink-500 hover:scale-105 transition"
          >
            Get Started
          </button>
        </div>
      </div>

      {/* HERO */}
      <section className="min-h-screen flex flex-col justify-center items-center text-center px-6 pt-24">

        <h1 className="text-5xl md:text-6xl font-bold leading-tight">
          <span className="bg-gradient-to-r from-purple-400 to-pink-500 bg-clip-text text-transparent">
            Campus Event
          </span>
          <br />
          Management
          <br />
          <span className="text-white/80">Made Simple & Smart</span>
        </h1>

        <p className="text-gray-400 mt-6 max-w-xl">
          Discover, create and manage campus events with a modern seamless experience.
        </p>

        <div className="flex gap-4 mt-8 flex-wrap justify-center">
          <button
            onClick={() => navigate("/login")}
            className="px-6 py-3 rounded-xl bg-gradient-to-r from-purple-500 to-pink-500 hover:scale-105 transition"
          >
            Get Started 🚀
          </button>

          <button className="px-6 py-3 rounded-xl border border-white/20 backdrop-blur-md hover:bg-white/10 transition">
            Explore Events
          </button>
        </div>

      </section>

      {/* FEATURES */}
      <section className="py-20 px-6 max-w-7xl mx-auto">

        <h2 className="text-3xl md:text-4xl font-bold text-center mb-12">
          Features 🚀
        </h2>

        <div className="grid md:grid-cols-3 gap-8">

          {[
            {
              title: "Event Creation",
              desc: "Faculty can easily create and manage events."
            },
            {
              title: "Smart Participation",
              desc: "Students can explore and join events."
            },
            {
              title: "Analytics Dashboard",
              desc: "Track event performance with insights."
            },
          ].map((item, i) => (
            <div
              key={i}
              className="bg-white/5 backdrop-blur-xl border border-white/10 rounded-2xl p-6 hover:scale-105 transition-all duration-300"
            >
              <div className="w-12 h-12 bg-gradient-to-r from-purple-500 to-pink-500 rounded-xl mb-4"></div>

              <h3 className="text-xl font-semibold">{item.title}</h3>
              <p className="text-gray-400 mt-2 text-sm">{item.desc}</p>
            </div>
          ))}

        </div>
      </section>

      {/* STATS */}
      <section className="py-20 px-6 max-w-7xl mx-auto">

        <div className="grid grid-cols-2 md:grid-cols-4 gap-6">

          {[
            { value: "10K+", label: "Events" },
            { value: "500K+", label: "Users" },
            { value: "98%", label: "Success" },
            { value: "24/7", label: "Support" },
          ].map((stat, i) => (
            <div
              key={i}
              className="text-center bg-white/5 backdrop-blur-lg rounded-xl p-6 border border-white/10"
            >
              <h2 className="text-3xl font-bold text-purple-400">{stat.value}</h2>
              <p className="text-gray-400 text-sm mt-1">{stat.label}</p>
            </div>
          ))}

        </div>

      </section>

      {/* CTA */}
      <section className="py-20 text-center px-6">

        <h2 className="text-3xl md:text-4xl font-bold">
          Ready to Join Amazing Events?
        </h2>

        <p className="text-gray-400 mt-4">
          Start exploring and managing events today.
        </p>

        <button
          onClick={() => navigate("/login")}
          className="mt-6 px-8 py-3 rounded-xl bg-gradient-to-r from-purple-500 to-pink-500 hover:scale-105 transition"
        >
          Get Started
        </button>

      </section>

      {/* FOOTER */}
      <footer className="py-10 border-t border-white/10 text-center text-gray-500">
        © 2026 Campus.io — All rights reserved
      </footer>

    </div>
  );
}
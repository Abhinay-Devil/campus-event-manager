import { ArrowRightIcon } from "lucide-react";
import { useNavigate } from "react-router-dom";

export default function HomePage() {
  const navigate = useNavigate();

  return (
    <div className="w-full bg-[#0b0f1a] text-white scroll-smooth relative overflow-hidden">

      {/* 🌌 BACKGROUND GLOW */}
      <div className="absolute inset-0 bg-gradient-to-r from-indigo-500/20 to-purple-500/10 blur-3xl"></div>

      {/* 🧊 NAVBAR */}
      <nav className="sticky top-0 z-50 backdrop-blur-lg bg-white/5 border-b border-white/10 flex justify-between items-center px-8 py-5 max-w-7xl mx-auto rounded-b-2xl">
        
        <h1 className="text-xl font-bold tracking-wide">Campus.io</h1>

        <div className="hidden md:flex gap-6 text-gray-300">
          <span className="hover:text-white cursor-pointer transition">Home</span>
          <span className="hover:text-white cursor-pointer transition">Features</span>
          <span className="hover:text-white cursor-pointer transition">FAQ</span>
        </div>

        <button
          onClick={() => navigate("/login")}
          className="bg-gradient-to-r from-indigo-500 to-purple-600 px-5 py-2 rounded-full shadow-lg shadow-indigo-500/30 hover:scale-105 transition"
        >
          Get Started
        </button>
      </nav>

      {/* 🚀 HERO SECTION */}
      <section className="flex flex-col md:flex-row items-center justify-between max-w-7xl mx-auto px-6 py-20 relative z-10">

        {/* LEFT */}
        <div className="max-w-xl">
          <h1 className="text-4xl md:text-6xl font-bold leading-tight">
            Campus Event Management
            <span className="block bg-gradient-to-r from-indigo-400 to-purple-500 bg-clip-text text-transparent">
              Made Simple & Smart
            </span>
          </h1>

          <p className="text-gray-400 mt-6 text-lg">
            Create, manage and participate in college events with a seamless 
            experience for Admins, Faculty and Students.
          </p>

          <div className="flex gap-4 mt-8">
            <button
              onClick={() => navigate("/login")}
              className="flex items-center gap-2 bg-indigo-600 hover:bg-indigo-700 px-6 py-3 rounded-xl shadow-lg shadow-indigo-500/30 hover:scale-105 transition duration-300"
            >
              Get Started
              <ArrowRightIcon className="w-5 h-5" />
            </button>

            <button
              onClick={() => navigate("/events")}
              className="border border-gray-600 px-6 py-3 rounded-xl hover:bg-gray-800 transition duration-300"
            >
              Explore Events
            </button>
          </div>
        </div>

        {/* RIGHT IMAGE */}
        <div className="mt-12 md:mt-0">
          <img
            src="https://images.unsplash.com/photo-1552664730-d307ca884978"
            alt="team"
            className="rounded-2xl w-[450px] shadow-[0_0_60px_rgba(139,92,246,0.4)] hover:scale-105 transition duration-500"
          />
        </div>
      </section>

      {/* ⚡ FEATURES */}
      <section className="py-20 text-center bg-[#0f172a] relative z-10">
        <h2 className="text-3xl font-bold mb-12">Features 🚀</h2>

        <div className="grid md:grid-cols-3 gap-8 max-w-6xl mx-auto px-4">

          <div className="p-6 bg-[#1e293b] rounded-xl hover:scale-105 hover:bg-[#243044] transition duration-300 shadow-lg">
            <h3 className="font-semibold text-lg mb-2">Create Events 🎯</h3>
            <p className="text-gray-400">
              Faculty can easily create and manage events.
            </p>
          </div>

          <div className="p-6 bg-[#1e293b] rounded-xl hover:scale-105 hover:bg-[#243044] transition duration-300 shadow-lg">
            <h3 className="font-semibold text-lg mb-2">User Management 👥</h3>
            <p className="text-gray-400">
              Admin can manage roles and permissions.
            </p>
          </div>

          <div className="p-6 bg-[#1e293b] rounded-xl hover:scale-105 hover:bg-[#243044] transition duration-300 shadow-lg">
            <h3 className="font-semibold text-lg mb-2">Join Events 🎉</h3>
            <p className="text-gray-400">
              Students can explore and join events easily.
            </p>
          </div>

        </div>
      </section>

      {/* 👥 ROLES */}
      <section className="py-20 text-center relative z-10">
        <h2 className="text-3xl font-bold mb-12">Built for Everyone</h2>

        <div className="grid md:grid-cols-3 gap-8 max-w-6xl mx-auto px-4">

          <div className="p-6 border border-gray-700 rounded-xl hover:bg-gradient-to-r hover:from-indigo-500/10 hover:to-purple-500/10 transition duration-300 hover:scale-105">
            <h3 className="font-semibold text-lg">Admin</h3>
            <p className="text-gray-400 mt-2">
              Manage users, roles and system control.
            </p>
          </div>

          <div className="p-6 border border-gray-700 rounded-xl hover:bg-gradient-to-r hover:from-indigo-500/10 hover:to-purple-500/10 transition duration-300 hover:scale-105">
            <h3 className="font-semibold text-lg">Faculty</h3>
            <p className="text-gray-400 mt-2">
              Create and manage campus events.
            </p>
          </div>

          <div className="p-6 border border-gray-700 rounded-xl hover:bg-gradient-to-r hover:from-indigo-500/10 hover:to-purple-500/10 transition duration-300 hover:scale-105">
            <h3 className="font-semibold text-lg">Student</h3>
            <p className="text-gray-400 mt-2">
              Discover and participate in events.
            </p>
          </div>

        </div>
      </section>

      {/* 🔥 CTA */}
      <section className="py-20 text-center bg-gradient-to-r from-indigo-600 to-purple-600 relative overflow-hidden">

        <div className="absolute inset-0 bg-white/10 blur-2xl"></div>

        <h2 className="text-3xl font-bold mb-4 relative z-10">
          Ready to explore campus events?
        </h2>

        <button
          onClick={() => navigate("/login")}
          className="bg-white text-black px-6 py-3 rounded-full font-semibold hover:scale-105 transition relative z-10"
        >
          Login Now 🔐
        </button>
      </section>

      {/* 🌙 FOOTER */}
      <footer className="py-10 text-center bg-black text-gray-400 relative z-10">
        <p>© 2026 Campus Event Manager</p>
      </footer>

    </div>
  );
}
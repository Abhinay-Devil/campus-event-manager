import { ArrowRightIcon } from "lucide-react";
import { useNavigate } from "react-router-dom";

export default function HomePage() {
  const navigate = useNavigate();

  return (
    <div className="w-full">

      {/* 🔥 HERO SECTION */}
      <section className="flex flex-col items-center justify-center relative min-h-screen px-4 py-20 overflow-hidden">

        <h1 className="text-4xl md:text-6xl text-center font-bold max-w-3xl">
          Campus Event Management
          <span className="block bg-gradient-to-r from-indigo-500 to-purple-600 bg-clip-text text-transparent">
            Made Simple & Smart
          </span>
        </h1>

        <p className="text-slate-600 text-center max-w-xl mt-4">
          Create, manage and participate in college events with a seamless experience 
          for Admins, Faculty and Students.
        </p>

        <div className="flex gap-4 mt-8 flex-wrap justify-center">
          <button
            onClick={() => navigate("/login")}
            className="flex items-center gap-2 bg-indigo-600 hover:bg-indigo-700 text-white px-6 py-3 rounded-full"
          >
            Get Started
            <ArrowRightIcon className="w-5 h-5" />
          </button>

          <button
            onClick={() => navigate("/login")}
            className="border border-gray-300 px-6 py-3 rounded-full hover:bg-gray-100"
          >
            Explore Events
          </button>
        </div>
      </section>

      {/* 💎 FEATURES */}
      <section className="py-20 bg-gray-50 text-center">
        <h2 className="text-3xl font-bold mb-12">Features 🚀</h2>

        <div className="grid md:grid-cols-3 gap-8 max-w-6xl mx-auto px-4">

          <div className="p-6 bg-white rounded-xl shadow hover:shadow-lg transition">
            <h3 className="font-semibold text-lg mb-2">Create Events 🎯</h3>
            <p className="text-gray-500">
              Faculty can easily create and manage events.
            </p>
          </div>

          <div className="p-6 bg-white rounded-xl shadow hover:shadow-lg transition">
            <h3 className="font-semibold text-lg mb-2">User Management 👥</h3>
            <p className="text-gray-500">
              Admin can manage roles and permissions.
            </p>
          </div>

          <div className="p-6 bg-white rounded-xl shadow hover:shadow-lg transition">
            <h3 className="font-semibold text-lg mb-2">Join Events 🎉</h3>
            <p className="text-gray-500">
              Students can explore and join events easily.
            </p>
          </div>

        </div>
      </section>

      {/* 👥 ROLES SECTION */}
      <section className="py-20 text-center">
        <h2 className="text-3xl font-bold mb-12">Built for Everyone</h2>

        <div className="grid md:grid-cols-3 gap-8 max-w-6xl mx-auto px-4">

          <div className="p-6 border rounded-xl">
            <h3 className="font-semibold text-lg">Admin</h3>
            <p className="text-gray-500 mt-2">
              Manage users, roles and system control.
            </p>
          </div>

          <div className="p-6 border rounded-xl">
            <h3 className="font-semibold text-lg">Faculty</h3>
            <p className="text-gray-500 mt-2">
              Create and manage campus events.
            </p>
          </div>

          <div className="p-6 border rounded-xl">
            <h3 className="font-semibold text-lg">Student</h3>
            <p className="text-gray-500 mt-2">
              Discover and participate in events.
            </p>
          </div>

        </div>
      </section>

      {/* 🚀 CTA SECTION */}
      <section className="py-20 bg-indigo-600 text-white text-center">
        <h2 className="text-3xl font-bold mb-4">
          Ready to explore campus events?
        </h2>

        <button
          onClick={() => navigate("/login")}
          className="bg-white text-indigo-600 px-6 py-3 rounded-full font-semibold"
        >
          Login Now 🔐
        </button>
      </section>

      {/* 🖤 FOOTER */}
      <footer className="py-10 text-center bg-black text-white">
        <p>© 2026 Campus Event Manager</p>
      </footer>

    </div>
  );
//   Developed BY Abhinay Srivastava 
}
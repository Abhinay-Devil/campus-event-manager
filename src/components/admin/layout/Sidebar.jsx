//sidebar.jsx//


import { Link } from "react-router-dom";
import { useAuth } from "../../../context/AuthContext";

const Sidebar = () => {
  const { user } = useAuth();

  return (
    <div className="w-64 h-screen bg-gray-900 text-white p-4">
      <h2 className="text-xl mb-6">Campus Manager</h2>

      {user?.role === "ADMIN" && (
        <>
          <Link to="/admin" className="block mb-2">Dashboard</Link>
          <Link to="/admin/events" className="block mb-2">Manage Events</Link>
          <Link to="/admin/users" className="block mb-2">Users</Link>
        </>
      )}

      {user?.role === "FACULTY" && (
        <>
          <Link to="/faculty" className="block mb-2">Dashboard</Link>
          <Link to="/faculty/events" className="block mb-2">My Events</Link>
        </>
      )}

      {user?.role === "STUDENT" && (
        <>
          <Link to="/student" className="block mb-2">Dashboard</Link>
          <Link to="/events" className="block mb-2">Browse Events</Link>
          <Link to="/my-registrations" className="block mb-2">My Registrations</Link>
        </>
      )}
    </div>
  );
};

export default Sidebar;
import { Routes, Route } from "react-router-dom";
import RoleRoute from "./RoleRoute";

import HomePage from "../pages/HomePage"; 
import AdminDashboard from "../pages/admin/AdminDashboard";
import FacultyDashboard from "../pages/faculty/FacultyDashboard";
import StudentDashboard from "../pages/student/StudentDashboard";
import Login from "../pages/Login";

const AppRoutes = () => {
  return (
    <Routes>
      {/*  Landing Page */}
      <Route path="/" element={<HomePage />} />

      {/*  Login */}
      <Route path="/login" element={<Login />} />

      {/*  Admin */}
      <Route
        path="/admin"
        element={
          <RoleRoute allowedRoles={["ADMIN"]}>
            <AdminDashboard />
          </RoleRoute>
        }
      />

      {/*  Faculty */}
      <Route
        path="/faculty"
        element={
          <RoleRoute allowedRoles={["FACULTY"]}>
            <FacultyDashboard />
          </RoleRoute>
        }
      />

      {/*  Student */}
      <Route
        path="/student"
        element={
          <RoleRoute allowedRoles={["STUDENT"]}>
            <StudentDashboard />
          </RoleRoute>
        }
      />
    </Routes>
  );
};

export default AppRoutes;
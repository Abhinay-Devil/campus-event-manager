import { Navigate } from "react-router-dom";
import { getUserRole } from "../utils/decodeToken";

const RoleRoute = ({ children, allowedRoles }) => {
  const token = localStorage.getItem("token");

  // ❌ No token
  if (!token) {
    return <Navigate to="/" />;
  }

  // ✅ Get role from token
  const role = getUserRole(token);

  console.log("ROLE CHECK:", role); // 🔍 debug

  // ❌ Role not allowed
  if (!role || !allowedRoles.includes(role)) {
    return <Navigate to="/unauthorized" />;
  }

  // ✅ Allowed
  return children;
};

export default RoleRoute;
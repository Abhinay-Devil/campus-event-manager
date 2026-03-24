import { jwtDecode } from "jwt-decode";

export const getUserRole = (token) => {
  try {
    const decoded = jwtDecode(token);
    console.log("Decoded Token:", decoded);

    let role = decoded.roles?.[0];

    // ✅ If string
    if (typeof role === "string") {
      return role.replace("ROLE_", "");
    }

    // ⚠️ If number → TEMP FIX
    if (typeof role === "number") {
      if (role === 45) return "ADMIN";
      if (role === 101) return "STUDENT";
      if (role === 102) return "FACULTY";
    }

    return null;
  } catch (error) {
    console.error("Token decode error:", error);
    return null;
  }
};
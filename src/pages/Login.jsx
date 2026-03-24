import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import API from "../api/axios";
import { getUserRole } from "../utils/decodeToken";

export default function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [loading, setLoading] = useState(false);

  const navigate = useNavigate();
  const { login } = useAuth();

  const handleLogin = async () => {
    if (!email || !password) {
      alert("Please enter email and password");
      return;
    }

    try {
      setLoading(true);

      const res = await API.post("/auth/login", {
        email,
        password,
      });

      console.log("Login Response:", res.data);

      // ✅ FIX: token is inside data
      const token = res?.data?.data;

      if (!token) {
        throw new Error("Token not received from server");
      }

      // ✅ Save token
      login(token);

      // ✅ Decode role
      const role = getUserRole(token);

      // ✅ Navigate based on role
      if (role === "ADMIN") {
        navigate("/admin");
      } else if (role === "FACULTY") {
        navigate("/faculty");
      } else if (role === "STUDENT") {
        navigate("/student");
      } else {
        alert("Unknown role");
      }

    } catch (error) {
      console.error("Login Error:", error);

      const message =
        error.response?.data?.message ||
        error.message ||
        "Login failed";

      alert(message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div
      style={{
        padding: "20px",
        maxWidth: "400px",
        margin: "80px auto",
        textAlign: "center",
        boxShadow: "0 0 10px rgba(0,0,0,0.1)",
        borderRadius: "8px",
      }}
    >
      <h2>Login</h2>

      <input
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        style={{
          display: "block",
          margin: "10px 0",
          padding: "10px",
          width: "100%",
        }}
      />

      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        style={{
          display: "block",
          margin: "10px 0",
          padding: "10px",
          width: "100%",
        }}
      />

      <button
        onClick={handleLogin}
        disabled={loading}
        style={{
          padding: "10px 20px",
          background: "#1976d2",
          color: "white",
          border: "none",
          cursor: loading ? "not-allowed" : "pointer",
          width: "100%",
        }}
      >
        {loading ? "Logging in..." : "Login"}
      </button>
    </div>
  );
}
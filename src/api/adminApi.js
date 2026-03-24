import axios from "./axios";

export const getDashboardStats = () => {
  return axios.get("/admin/dashboard");
};
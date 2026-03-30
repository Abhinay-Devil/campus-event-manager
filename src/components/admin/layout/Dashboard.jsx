//Dashborad.jsx//

import Sidebar from "./Sidebar";   // (check filename case)
import Navbar from "./Navbar";

const DashboardLayout = ({ children }) => {
  return (
    <div className="flex">
      <Sidebar />
      <div className="flex-1">
        <Navbar />
        <div className="p-4">{children}</div>
      </div>
    </div>
  );
};

export default DashboardLayout;
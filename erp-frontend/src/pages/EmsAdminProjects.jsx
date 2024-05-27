import React from "react";
import EmsAdminSidebar from "../components/EmsAdminSidebar";
import EmsAdminNav from "../components/EmsAdminNav";
import { useState } from "react";

const EmsAdminProjects = () => {
  const [showMenu, setShowMenu] = useState(false);

  const toggleMenu = () => {
    setShowMenu((prevShowMenu) => !prevShowMenu);
  };
  return (
    <div className="min-h-[100vh] bg-[#F6F8FA] w-full">
      <div className="w-full flex">
        <EmsAdminSidebar showMenu={showMenu} />
        <div className="w-full">
          <EmsAdminNav toggleMenu={toggleMenu} />
          <div style={{ textAlign: "center" }}>
            <h1>Under Construction</h1>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EmsAdminProjects;

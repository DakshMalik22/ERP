import React, {  useState } from "react";
import EmsAdminNav from "../components/EmsAdminNav";
import EmsAdminHero from "../components/EmsAdminHero";
import EmsAdminSidebar from "../components/EmsAdminSidebar";

const EmsAdminDashboard = () => {
  const [showMenu, setShowMenu] = useState(false);

  const toggleMenu = () => {
    setShowMenu((prevShowMenu) => !prevShowMenu);
  };

  return (
    <div className="min-h-[100vh] bg-[#F6F8FA] w-full">
    <div className='w-full flex'>
     <EmsAdminSidebar showMenu={showMenu}/>
     <div className="w-full">
        <EmsAdminNav toggleMenu={toggleMenu}/>
        <EmsAdminHero/>
     </div>
    </div>
  </div>
  )
}

export default EmsAdminDashboard
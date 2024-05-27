import React, { Fragment, useState } from "react";

import EmsAdminNav from "../components/EmsAdminNav";
import EmsAdminSidebar from "../components/EmsAdminSidebar";

const EmsCreateAdmin = () => {
  
  const [showMenu, setShowMenu] = useState(false);

  const toggleMenu = () => {
    setShowMenu((prevShowMenu) => !prevShowMenu);
  };

  return (
    
    <div className="min-h-[100vh] bg-[#F6F8FA] w-full">
      <div className='w-full flex'>
         <EmsAdminSidebar  showMenu={showMenu}/>
        <div className="w-full">
             <EmsAdminNav toggleMenu={toggleMenu}/>
             <div style={{textAlign:'center'}}>
       <h1>Under Construction</h1>
    </div>
        </div>
      </div>

    </div>
  )
}

export default EmsCreateAdmin
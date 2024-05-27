import React from 'react'
import EmsEmpNav from '../components/EmsEmpNav';
import EmsEmpSidebar from '../components/EmsEmpSidebar';
import { useState } from 'react';

const EmsEmpLeaveStatus = () => {
    const [showMenu, setShowMenu] = useState(false);

    const toggleMenu = () => {
      setShowMenu((prevShowMenu) => !prevShowMenu);
    };
  return (
    <div className="w-full flex">
        <EmsEmpSidebar showMenu={showMenu} />
        <div className="w-full">
          <EmsEmpNav toggleMenu={toggleMenu} />
          <div style={{ textAlign: "center" }}>
            <h1>Under Construction</h1>
          </div>
        </div>
      </div>
  )
}

export default EmsEmpLeaveStatus
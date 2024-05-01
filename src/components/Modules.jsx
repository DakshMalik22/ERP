import React from "react";
import ems from "../assets/ems.svg";
import crm from "../assets/crm.svg";
import hrm from "../assets/hrm.svg";
import {useSelector } from 'react-redux';
import { useEffect } from "react";

function Modules() {
  const mode = useSelector(state => state.theme.mode);
  
  useEffect(()=>{
    if(mode==='dark'){
       document.documentElement.classList.add('dark');
       document.documentElement.classList.remove('remove')
    }
    else{
       document.documentElement.classList.remove('dark')
       document.documentElement.classList.add('hero');  
    }
  },[mode])

  return (
    <div className="w-[100%] dark:bg-[#02042B]">
      <div className="max-w-[90%] mx-auto flex-col text-center px-30 py-20  text-black  modules dark:text-white">
        <h1 className="font-bold text-4xl">OUR MODULES</h1>
        <p className="text-2xl font-medium py-5 text-[#696466]">
          WP ERP has 3 core modules: HRM, CRM, and Accounting,<br/> which together
          make a complete ERP system for any type of business.
        </p>
        <div className="flex flex-wrap gap-20 mx-10 my-10">
          <div className="bg-[#ffffffa1] shadow-custom text-black rounded-[40px] p-10 flex-1 cursor-pointer hover:invert">
            <img className="mb-[56px] text-left" src={ems} alt="" />
            <h1 className="text-2xl font-bold pt-5 text-left">
              HR <br />
              MANAGEMENT
            </h1>
          </div>
          <div className="bg-[#ffffffa1] shadow-custom  text-black rounded-[40px] p-10 flex-1 cursor-pointer hover:invert">
            <img className="mb-[56px] text-left" src={crm} alt="" />
            <h1 className="text-2xl font-bold pt-5 text-left">
              CRM <br />
              SYSTEM
            </h1>
          </div>
          <div className="bg-[#ffffffa1] shadow-custom text-black rounded-[40px] p-10 flex-1 cursor-pointer hover:invert">
            <img className="mb-[56px] text-left" src={hrm} alt="" />
            <h1 className="text-2xl font-bold pt-5 text-left">
              EMPLOYEE <br />
              MANAGEMENT
            </h1>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Modules;


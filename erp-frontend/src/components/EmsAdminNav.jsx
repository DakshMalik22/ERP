import React from 'react'
import { CiSearch } from "react-icons/ci";
import { useState } from 'react';

const EmsAdminNav = ({toggleMenu}) => {
  
  const showMenuItems = () => {
    toggleMenu();
  };
   
  return (
      <div className='w-full'>
        {/* navbar */}
        <div className="pt-5 pl-8 pr-7 py-5 bg-white flex justify-between">
            <div className="hidden sm:flex max-w-2xl justify-between w-full">
              <div className="flex flex-col">
                <span className="text-base md:text-xl text-[#212B36] font-semibold">
                  Hello Admin!
                </span>
                <span className="text-sm font-normal">
                  Welcome back to dashboard.
                </span>
              </div>
              <div className="lg:max-w-sm w-2/5 lg:w-full border focus-within:border-blue-600 rounded-lg border-[#E7E7E7] py-3 px-4 justify-between items-center max-h-12 hidden md:flex">
                <input
                  type="text"
                  className="outline-none w-9/12"
                  placeholder="Search..."
                />
                <CiSearch className="text-3xl" />
              </div>
            </div>
            <div className="flex gap-2 items-center sm:hidden">
              <span className="text-xl font-semibold ">Admin <br /> dashboard</span>
            </div>
            <div
              className="cursor-pointer sm:hidden border border-[#E7E7E7] group rounded-md flex justify-center items-center"
              onClick={showMenuItems}
            >
              <svg
                className="text-[#637381] w-10 h-10"  
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth="2"
                  d="M4 6h16M4 12h16M4 18h16"
                />
              </svg>
            </div>   
        </div>
      </div>
  )
}

export default EmsAdminNav;
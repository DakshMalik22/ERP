import React, { Fragment, useState } from "react";
import { Listbox, Transition } from "@headlessui/react";
import { MdArrowBackIos } from "react-icons/md";
import { VscGitStashApply } from "react-icons/vsc";
import { MdDashboard } from "react-icons/md";
import { GrStatusUnknown } from "react-icons/gr";
import { FaUser } from "react-icons/fa";
import { MdOutlineLogout } from "react-icons/md";
import EmpDashHero from "../components/EmpDashHero";
import { IoMenu } from "react-icons/io5";
import { CiSearch } from "react-icons/ci";



const navigationList = [
  {
    name: "Dashboard",
    icon: <MdDashboard />
  },
  {
    name: "Apply Leaves",
    icon: <VscGitStashApply />
  },
  {
    name: "Leave status",
    icon: <GrStatusUnknown />
  },
  {
    name: "Profile",
    icon: <FaUser />
  },
];

const Dashbord = () => {
  const [showMenu, setShowMenu] = useState(false);
  const [openSideBar, setOpenSieBar] = useState(true);
  const changeSideBar = () => {
    setOpenSieBar(!openSideBar);
  };
  const showMenuItems = () => {
    setShowMenu(!showMenu);
  };
  return (
    <div className="min-h-[100vh] bg-[#F6F8FA] w-full">
      <div
        className={`w-full flex ${
          showMenu ? "overflow-hidden h-screen" : "sm:overflow-auto"
        }`}
      >
        {/* sidebar */}
          <div
            className={`transition-all duration-1000 ease-in-out z-50 bg-white sm:relative sm:flex sm:flex-col gap-2 sm:gap-16 rounded-br-xl h-screen min-h-[600px] py-6 absolute top-0 sm:left-0 ${
              showMenu
                ? "left-0 h-screen overflow-y-auto px-5"
                : "-left-72 sm:left-0"
            } ${openSideBar ? "w-72 px-5" : "w-72 sm:w-24"} overflow-hidden`}
          >
            <div
              className={`transition-all duration-500 delay-700 ease-in-out flex gap-2 justify-start items-center ${
                openSideBar ? "sm:justify-start" : "sm:justify-center"
              }  cursor-pointer relative z-30`}
            >
              <span
                className={` text-2xl font-semibold ${
                  openSideBar ? " block" : "block sm:hidden"
                } `}
              >
                Employee <br/> Dashboard
              </span>
              <div
                className={`h-10  w-10 rounded-full bg-white absolute top-0  sm:flex justify-center items-center cursor-pointer hidden ${
                  openSideBar ? "rotate-[180deg] -right-3" : "rotate-0 -right-3"
                }`}
                onClick={changeSideBar}
              >
              <MdArrowBackIos />
              </div>
            </div>
            <div className="flex flex-col gap-2.5 sm:justify-between h-full mt-10 sm:mt-0">
              <div className="md:max-w-[234px]">
                {navigationList?.map((data, index) => (
                  <div
                    key={index}
                    className={`flex gap-2.5 items-center cursor-pointer py-2 group hover:bg-[#4F80E1]/[12%] group rounded-md overflow-hidden ${
                      openSideBar
                        ? " pl-5 justify-start flex-row"
                        : "pl-5 sm:pl-0 justify-start sm:justify-center sm:flex-col"
                    } `}
                  >
                    <div>{data?.icon}</div>
                    <span
                      className={`font-medium text-base group-hover:text-[#4F80E1] text-[#637381]  
                      ${
                        openSideBar
                          ? " block"
                          : "block sm:hidden group-hover:block sm:group-hover:text-xs"
                      }`}
                    >
                      {data?.name}
                    </span>
                  </div>
                ))}
              </div>
              {/* logout */}
              <div className="max-w-[234px]">           
              <div
                      className={`flex gap-2.5 items-center cursor-pointer py-2 rounded-md hover:bg-[#4F80E1]/[12%] group ${
                        openSideBar
                          ? " pl-5 justify-start flex-row"
                          : "pl-5 sm:pl-0 justify-start sm:justify-center sm:flex-col"
                      }`}
                    >
                      <MdOutlineLogout />
                      <span
                        className={`font-medium text-base group-hover:text-[#4F80E1] text-[#637381] ${
                          openSideBar
                            ? " block"
                            : "block sm:hidden group-hover:block sm:group-hover:text-xs"
                        }`}
                      >
                      Logout
                      </span>
                    </div>
              </div>
            </div>
          </div>
          
        {/* main content area */}
        <div className="w-full">

          {/* navbar */}
          <div className="pt-5 pl-8 pr-7 py-5 bg-white flex justify-between absolute w-full z-[99]">
              <div className="hidden sm:flex max-w-2xl justify-between w-full">
                <div className="flex flex-col">
                  <span className="text-base md:text-xl text-[#212B36] font-semibold">
                    Hello Employee!
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
                <span className="text-xl font-semibold ">Employee <br /> dashboard</span>
              </div>
              <div
                className="cursor-pointer sm:hidden border border-[#E7E7E7] hover:border-blue-600 group rounded-md flex justify-center items-center"
                onClick={showMenuItems}
              >
                <svg
                  className="group-hover:text-blue-600 text-[#637381] w-10 h-10"
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
             <EmpDashHero/>
      </div>
    </div>
  );
};
export default Dashbord;
import React from 'react'
import { MdOutlinePendingActions } from "react-icons/md";
import { IoMdDoneAll } from "react-icons/io";
import { MdOutlineCelebration } from "react-icons/md";
import { MdFreeCancellation } from "react-icons/md";
import EmpTasks from './EmpTasks';

const EmsEmpDashHero = () => {
    
const cardData = [
    {
      type: "Pending Tasks",
      icon: <MdOutlinePendingActions />,
      value: "2"
    },
    {
      type: "Completed Tasks",
      icon: <IoMdDoneAll />,
      value: "5",
    },
    {
      type: "Leaves",
      icon:<MdOutlineCelebration />,
      value: "10",
    },
    {
      type: "Rejected Leaves",
      icon: <MdFreeCancellation />,
      value: "2",
    },
  ];
  
  return (
     <div className="w-full py-3 pl-7 pr-5 grid xl:grid-cols-12 lg:grid-cols-3 sm:grid-cols-2 grid-cols-1 gap-5 justify-start">
     {/* cards */}
    {cardData?.map((data, key) => (
       <div
         className="p-5 xl:col-span-3 bg-white flex flex-col max-w-xs 2xl:max-w-none w-full rounded-xl gap-2 border border-[#E7E7E7] hover:shadow-xl cursor-pointer"
         key={key}
       >
         <div
           className={`flex justify-between 
             sm:flex-col md:flex-row" 
           }`}
         >
           <span className="text-[#637381] text-sm font-medium">
             {data?.type}
           </span>
          
         </div>
         <div
           className={`flex gap-4  justify-between ${
           "flex-wrap sm:flex-col md:flex-row items-end md:flex-nowrap"
           }`}
         >
           <span className="text-2xl font-bold whitespace-nowrap">
             {data?.value}
           </span>
           <div className="text-3xl">{data?.icon}</div>
         </div>
       </div>
     ))}
    <div className="w-full">
    <EmpTasks/>
    </div>  
   </div>
  )
}

export default EmsEmpDashHero
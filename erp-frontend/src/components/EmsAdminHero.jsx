import React from 'react'
import { MdOutlinePendingActions } from "react-icons/md";
import { IoMdDoneAll } from "react-icons/io";


const cardData = [
    {
      type: "Pending Projects",
      icon: <MdOutlinePendingActions />,
      value: "2"
    },
    {
      type: "Completed Projects",
      icon: <IoMdDoneAll />,
      value: "5",
    },
    {
      type: "Pending Tasks",
      icon:<MdOutlinePendingActions />,
      value: "10",
    },
    {
      type: "Completed Tasks",
      icon: <IoMdDoneAll />,
      value: "2",
    },
];

const TableData = [
        {
          title: "abc",
          description:"complete task a",
          assignedTo:"xyz",
          date: "20/07/2024,01:10",
          status: "pending",
        },
        {
          title: "abc",
          description:"complete task a",
          assignedTo:"xyz",
          date: "20/05/2024,01:10",
          status: "pending",
        },
        {
          title: "abc",
          description:"complete task a",
          assignedTo:"xyz",
          date: "20/05/2024,01:10",
          status: "pending",
        },
        {
          title: "abc",
          description:"complete task a",
          assignedTo:"xyz",
          date: "20/05/2024,01:10",
          status: "pending",
        },
        {
          title: "abc",
          description:"complete task a",
          assignedTo:"xyz",
          date: "20/05/2024,01:10",
          status: "pending",
        },
        {
          title: "abc",
          description:"complete task a",
          assignedTo:"xyz",
          date: "20/05/2024,01:10",
          status: "pending",
        },
      ];

const EmsAdminHero = () => {
  return (
    <div>
        <div className="w-full py-3 pl-7 pr-5 grid xl:grid-cols-12 lg:grid-cols-3 sm:grid-cols-2 grid-cols-1 gap-5 justify-start">
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

      
        </div>  
        <div className="p-3 ml-6 bg-white flex flex-col xl:col-span-9 xl:row-auto lg:row-start-4 lg:col-span-2 rounded-xl border border-[#E7E7E7] w-[80vw]">
              <div className="w-full overflow-x-scroll md:overflow-auto max-w-xl xs:max-w-xl sm:max-w-xl md:max-w-7xl 2xl:max-w-none mt-1">
                <table className="table-auto overflow-scroll md:overflow-auto w-full text-left font-inter border-separate border-spacing-y-1">
                  <thead className="bg-[#222E3A]/[6%] rounded-lg text-base text-white font-semibold w-full">
                    <tr className="">
                      <th className="py-3 pl-3 text-[#212B36] text-sm font-normal whitespace-nowrap rounded-l-lg">
                        Task
                      </th>
                      <th className="py-3 pl-1 text-[#212B36] text-sm font-normal whitespace-nowrap">
                        Description
                      </th>
                      <th className="py-3 text-[#212B36] text-sm font-normal whitespace-nowrap">
                       Assigned To
                      </th>
                      <th className="py-3 text-[#212B36] text-sm font-normal whitespace-nowrap">
                        Expected Time
                      </th>
                      <th className="py-3 text-[#212B36] text-sm font-normal whitespace-nowrap">
                        Status
                      </th>
                      
                    </tr>
                  </thead>
                  <tbody>
                    {TableData.map((data) => (
                      <tr
                        key={data.index}
                        className="bg-[#f6f8fa] hover:cursor-pointer"
                      >
                        <td className="py-4 pl-3 text-sm font-normal text-[#637381] rounded-l-lg">
                          {data.title}
                        </td>
                        <td className="py-4 px-1 text-sm font-normal text-[#637381]">
                          {data.description}
                        </td>
                        <td className="py-4 px-1 text-sm font-normal text-[#637381]">
                          {data.assignedTo}
                       </td> 
                        <td className="py-4 px-1 text-sm font-normal text-[#637381]">
                          {data.date}
                        </td>
                        <td className="py-4 px-1 text-sm font-normal text-[#637381]">
                          {data.status}
                        </td>
                             
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
       </div>     
    </div>
  )
}

export default EmsAdminHero

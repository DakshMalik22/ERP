import React from "react";
import { BsThreeDots } from "react-icons/bs";
import { useState } from "react";

const EmpTasks = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const TableData = [
    {
      title: "abc",
      description: "complete task a",
      date: "20/07/2024,01:10",
      status: "pending",
    },
    {
      title: "abc",
      description: "complete task a",
      date: "20/05/2024,01:10",
      status: "completed",
    },
    {
      title: "abc",
      description: "complete task a",
      date: "20/05/2024,01:10",
      status: "pending",
    },
    {
      title: "abc",
      description: "complete task a",
      date: "20/05/2024,01:10",
      status: "pending",
    },
    {
      title: "abc",
      description: "complete task a",
      date: "20/05/2024,01:10",
      status: "pending",
    },
    {
      title: "abc",
      description: "complete task a",
      date: "20/05/2024,01:10",
      status: "pending",
    },
  ];

  const openModal = () => {
    setIsModalOpen(true);
  };

  const closeModal = ()=>{
     setIsModalOpen(false);
  }

  return (
    <div className="p-3  bg-white flex flex-col xl:col-span-9 xl:row-auto lg:row-start-4 lg:col-span-2 rounded-xl border border-[#E7E7E7] w-[80vw]">
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
                Expected Time
              </th>
              <th className="py-3 text-[#212B36] text-sm font-normal whitespace-nowrap">
                Status
              </th>
              <th className="py-3 text-[#212B36] text-sm font-normal whitespace-nowrap">
                Action
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
                  {data.date}
                </td>
                <td className="py-4 px-1 text-sm font-normal text-[#637381]">
                  {data.status}
                </td>
                <td className="py-4 px-1 text-sm font-normal text-[#637381]">
                  <BsThreeDots onClick={() => openModal()} />
                </td>
                <td
                  className="py-4 px-1 text-sm font-normal text-[#637381]"
                  style={{
                    color: data?.color,
                  }}
                >
                  {data.action}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        {isModalOpen && (
        <div className="fixed inset-0 bg-gray-600 bg-opacity-50 flex justify-center items-center">
          <div className="bg-white p-4 rounded-lg shadow-lg">
            <h2 className="text-lg font-semibold mb-4">Update Task Status</h2>
            <div className="flex gap-4">
              <button
                className="bg-blue-500 text-white px-4 py-2 rounded"
              >
                Pending
              </button>
              <button
                className="bg-green-500 text-white px-4 py-2 rounded"      
              >
                Completed
              </button>
              <button
                className="bg-gray-500 text-white px-4 py-2 rounded"
                onClick={closeModal}
              >
                Cancel
              </button>
            </div>
          </div>
        </div>
      )}
      </div>
      
    </div>
  );
};

export default EmpTasks;

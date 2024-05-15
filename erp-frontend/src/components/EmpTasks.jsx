import React from 'react'

const EmpTasks = () => {

    const TableData = [
        {
          title: "abc",
          description:"complete task a",
          date: "20/07/2024,01:10",
          status: "pending",
        },
        {
          title: "abc",
          description:"complete task a",
          date: "20/05/2024,01:10",
          status: "pending",
        },
        {
          title: "abc",
          description:"complete task a",
          date: "20/05/2024,01:10",
          status: "pending",
        },
        {
          title: "abc",
          description:"complete task a",
          date: "20/05/2024,01:10",
          status: "pending",
        },
        {
          title: "abc",
          description:"complete task a",
          date: "20/05/2024,01:10",
          status: "pending",
        },
        {
          title: "abc",
          description:"complete task a",
          date: "20/05/2024,01:10",
          status: "pending",
        },
      ];

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
                          hehy
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
              </div>
            </div> 
  )
}

export default EmpTasks
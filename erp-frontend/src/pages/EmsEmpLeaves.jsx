import React from "react";
import EmsEmpNav from "../components/EmsEmpNav";
import EmsEmpSidebar from "../components/EmsEmpSidebar";
import { useState } from "react";
import { useEffect } from "react";

const EmsEmpLeaves = () => {
  const [showMenu, setShowMenu] = useState(false);
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [startflag, setstartflag] = useState(false);
  const [endflag, setEndflag] = useState(false);
  const [minstartDate, setMinStartDate] = useState('');

    useEffect(() => {
      const today = new Date().toISOString().split('T')[0];
      setMinStartDate(today);
    }, []);

  const handleStartDateChange = (event) => {
    const selectedStartDate = event.target.value;
    setStartDate(selectedStartDate);
  };

  const handleEndDateChange = (event) => {
    setEndDate(event.target.value);
  }

 const handLeaveSubmit = () =>{
  if (startDate === '') {
    setstartflag(true);
  } else {
    setstartflag(false);
  }
  if (endDate === '') {
    setEndflag(true);
  } else {
    setEndflag(false);
  }
 }

  const toggleMenu = () => {
    setShowMenu((prevShowMenu) => !prevShowMenu);
  };
  return (
    <div className="w-full flex bg-[#F6F8FA]">
      <EmsEmpSidebar showMenu={showMenu} />
      <div className="w-full">
        <EmsEmpNav toggleMenu={toggleMenu} />
        <div className="max-w-screen-md mx-auto p-5">
          <div className="border rounded-xl w-[80%] p-5  bg-white">
            <h2 className="text-2xl text-center mb-10">Leave Application</h2>
            <div className="flex gap-5 w-[100%] mt-5 max-md:flex-col">
              <div className="w-1/2 max-md:w-full cursor-pointer">
                <div>
                  <label
                    className="text-sm text-gray-600 font-semibold block"
                    htmlFor="name"
                  >
                    Start Date
                  </label>
                  <input
                    datepicker
                    datepicker-autohide
                    type="date"
                    className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 "
                    min={minstartDate}
                    onChange={handleStartDateChange}    
                  />
                   {
                   startflag && <p className="text-xs text-red-600">Select start date*</p>
                  }
                </div>
              </div>
              <div className="w-1/2 max-md:w-full">
                <div>
                  <label
                    className="text-sm text-gray-600 font-semibold block"
                    htmlFor="name"
                  >
                    End Date
                  </label>
                  <input
                    datepicker
                    datepicker-autohide
                    min={startDate}
                    onChange={handleEndDateChange}
                    type="date"
                    className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5  dark:bg-gray-700 dark:border-gray-600  dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                  />
                  {
                   endflag && <p className="text-xs text-red-600">Select end date*</p>
                  }
                </div>
              </div>
            </div>
              
            <div className="mt-5">
              <label
                className="text-sm text-gray-600 font-semibold block"
                htmlFor="message"
              >
                Reason
              </label>
              <textarea
                className="mt-2 px-3 py-2 border border-gray-300 focus:outline-none focus:border-indigo-500 block w-full shadow-sm rounded-md sm:text-sm"
                id="message"
                rows="4"
                placeholder="Type your message here"
              ></textarea>
            </div>
            <div className="mt-5">
              <button
                type="submit"
                className="px-4 py-2 bg-indigo-600 hover:bg-indigo-700 focus:bg-indigo-700 text-white font-semibold text-sm rounded-md block w-full shadow-sm sm:w-auto"

                onClick={handLeaveSubmit}
              >
                Submit
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EmsEmpLeaves;

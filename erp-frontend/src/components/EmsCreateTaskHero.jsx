import React, { useState } from "react";

const EmsCreateTaskHero = () => {

  const [title, setTitle] = useState("");
  const [titleFlag, setTitleFlag] = useState(false);

  const [emp, setEmp] = useState("");
  const [empFlag, setempFlag] = useState(false);

  const [date, setDate] = useState('');
  const [dateFlag, setDateFlag] = useState(false);

  const handleTitle = (e) => {
    setTitle(e.target.value);
  };  

  const handleEmp = (e) => {
    setEmp(e.target.value);
  };

  const handleDate = (e) => {
    setDate(e.target.value);
  }

  const handleSubmit = () => {
    if (title === "") {
      setTitleFlag(true);
    } else {
      setTitleFlag(false);
    }
    if (emp === "") {
      setempFlag(true);
    } else {
      setempFlag(false);
    }
    if (date === '') {
      setDateFlag(true);
      valid = false;
    } else {
      setDateFlag(false);
    }
  };

  return (
    <div>
      <div className="max-w-screen-lg mx-auto p-5 ">
        <div className="grid grid-cols-1 md:grid-cols-12 border bg-white rounded-xl">
          <div className="md:col-span-8 p-4 md:p-10">
            <div className="grid grid-cols-1 sm:grid-cols-2 gap-5">
              
              <div className="col-span-1">
                <label
                  className="text-sm text-gray-600 font-semibold block"
                  htmlFor="name"
                >
                  Title
                </label>
                <input
                  className="mt-2 px-3 py-2 border border-gray-300 focus:outline-none focus:border-indigo-500 block w-full shadow-sm rounded-md sm:text-sm"
                  type="text"
                  id="name"
                  placeholder="Title"
                  onChange={(e) => handleTitle(e)}
                />
                {titleFlag && (
                  <p className="text-xs text-red-600">Enter the title*</p>
                )}
              </div>

              <div className="col-span-1">
                <label
                  for="large"
                  class="text-sm text-gray-600 font-semibold block"
                >
                  Assign Employee
                </label>
                <select
                  id="large"
                  className="mt-1 px-3 py-2 border border-gray-300 focus:outline-none focus:border-indigo-500 block w-full shadow-sm rounded-md sm:text-sm cursor-pointer"
                  onChange={(e) => handleEmp(e)}
                >
                  <option value="" selected>
                    Choose an Employee
                  </option>
                  <option value="employee1">Employee 1</option>
                  <option value="employee2">Employee 2</option>
                  <option value="employee3">Employee 3</option>
                  <option value="employee4">Employee 4</option>
                </select>
                {empFlag && (
                  <p className="text-xs text-red-600">Assign employee*</p>
                )}
              </div>

            </div>

            <div className="grid grid-cols-1 sm:grid-cols-2 gap-5 mt-5">
              <div className="col-span-1">
                <div className="relative max-w-sm">
                  <label
                    className="text-sm text-gray-600 font-semibold block"
                    htmlFor="name"
                  >
                    Expected date
                  </label>
                  <input
                    datepicker
                    datepicker-autohide
                    type="date"
                    className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5  dark:bg-gray-700 dark:border-gray-600  dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                    onChange={handleDate}
                    />
                    {dateFlag && <p className="text-xs text-red-600">Select a date*</p>}  
                </div>
              </div>
            </div>
            <div className="mt-5">
              <label
                className="text-sm text-gray-600 font-semibold block"
                htmlFor="message"
              >
                Description
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
                onClick={handleSubmit}
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

export default EmsCreateTaskHero;

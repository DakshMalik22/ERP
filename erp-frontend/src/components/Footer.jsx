import React from 'react';
import { FaLinkedin } from "react-icons/fa";
import { FaFacebook } from "react-icons/fa";
import { Link } from 'react-router-dom';

const Footer = () => {
  return (
    <footer className="bg-white dark:bg-[#02042B] shadow-custom dark:border-t border-[#374151]">
      <div className="mx-auto w-full max-w-screen-xl p-4 py-6 lg:py-8">
        <div className="md:flex md:justify-between">
          <div className="mb-6 md:mb-0">
              <span className="cursor-pointer self-center text-2xl font-semibold whitespace-nowrap dark:text-white"><a href="#">ERP SYSTEM</a></span>
          </div>
          <div className="grid grid-cols-2 gap-8 sm:gap-6 sm:grid-cols-3">
            <div>
              <h2 className="mb-6 text-sm font-semibold text-gray-900 uppercase dark:text-white">Products</h2>
              <ul className="text-gray-500 dark:text-gray-400 font-medium">
                <li className="mb-4">
                  <Link to="/hrmLogin" className="hover:underline">HRM</Link>
                </li>
                <li className='mb-4'>
                  <Link to="/crmLogin" className="hover:underline">CRM</Link>
                </li>
                <li>
                  <Link to="/emsLogin" className="hover:underline">EMS</Link>
                </li>
              </ul>
            </div>
            <div>
              <h2 className="mb-6 text-sm font-semibold text-gray-900 uppercase dark:text-white">Follow us</h2>
              <ul className="text-gray-500 dark:text-gray-400 font-medium">
                <li className="mb-4">
                  <a href="https://www.linkedin.com/company/avi-soft/mycompany/" className="hover:underline ">Linked In</a>
                </li>
                <li>
                  <a href="https://www.facebook.com/avisoftwares/" className="hover:underline">Facebook</a>
                </li>
              </ul>
            </div>
            <div>
              <h2 className="mb-6 text-sm font-semibold text-gray-900 uppercase dark:text-white">Legal</h2>
              <ul className="text-gray-500 dark:text-gray-400 font-medium">
                <li className="mb-4">
                  <a href="#" className="hover:underline">Privacy Policy</a>
                </li>
                <li>
                  <a href="#" className="hover:underline">Terms &amp; Conditions</a>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <hr className="my-6 border-gray-200 sm:mx-auto dark:border-gray-700 lg:my-8" />
        <div className="sm:flex sm:items-center sm:justify-between">
          <span className="text-sm text-gray-500 sm:text-center dark:text-gray-400">
            © 2024 <a href="https://avisoft.io/" className="hover:underline">AviSoft</a>. All Rights Reserved.
          </span>
          <div className="flex mt-4 sm:justify-center sm:mt-0">
            <a href="https://www.facebook.com/avisoftwares/" className="text-gray-500 hover:text-gray-900 dark:hover:text-white">
            <FaFacebook />
            </a>
            <a href="https://www.linkedin.com/company/avi-soft/mycompany/" className="text-gray-500 hover:text-gray-900 dark:hover:text-white ms-5">
             <FaLinkedin/>
            </a>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;

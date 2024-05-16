import React, { useEffect } from "react";
import { FaMobileScreenButton } from "react-icons/fa6";
import { FaUserCheck } from "react-icons/fa";
import { MdAutoGraph } from "react-icons/md";

import AOS from "aos";
import "aos/dist/aos.css"; XMLDocument


const faturesData = [ 
  {
    name: "Mobile Access",
    icon: (
      <FaMobileScreenButton className="text-5xl text-primary"/>
    ),
    link: "#",
    description: "Access and use your system from mobile devices for flexibility and convenience.",
    aosDelay: "0",
  },
  {
    name: "Access Control",
    icon: (
      <FaUserCheck  className="text-5xl text-primary" />
    ),
    link: "#",
    description: "Manage and regulate resource access based on user identity and permissions.",
    aosDelay: "500",
  },
  {
    name: "Scalable",
    icon: (
      <MdAutoGraph className="text-5xl text-primary" />
    ),
    link: "#",
    description: "Expand and accommodate growth or demands without compromising performance.",
    aosDelay: "1000",
  },
];

const Features = () => {
  
  useEffect(() => {
    AOS.init({
      duration: 1000,
      offset: 200,
      delay: 200, 
    });
  }, []);

  return (
    <>
      <span id="about"></span>
      <div className="text-black dark:bg-[#02042B] dark:text-white py-14 sm:min-h-[600px] sm:grid sm:place-items-center">
        <div className="container max-w-[90%] mx-auto">
          <div className="pb-12">
            <h1
              data-aos="fade-up"
              className="text-3xl font-semibold text-center sm:text-4xl"
            >
              Why Choose Us
            </h1>
          </div>
          <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
            {faturesData.map((skill) => (
              <div
                key={skill.name}
                data-aos="fade-up"
                data-aos-delay={skill.aosDelay}
                className="card text-center group space-y-3 sm:space-y-6 p-4 sm:py-16 bg-dark  hover:bg-primary duration-300 dark:text-white rounded-lg"
              >
                <div className="grid place-items-center">{skill.icon}</div>
                <h1 className="text-2xl font-bold">{skill.name}</h1>
                <p>{skill.description}</p>
              </div>
            ))}
          </div>
        </div>
      </div>
    </>
  );
};

export default Features;
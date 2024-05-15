import React, { useState, useEffect } from 'react';
import erp from '../assets/erp.png';
import anotherImage from '../assets/erp2.png';
import { ReactTyped } from "react-typed";
import { useDispatch, useSelector } from 'react-redux';

const Hero = () => {
  const mode = useSelector(state => state.theme.mode);

  
  useEffect(()=>{
    if(mode==='dark'){
       document.documentElement.classList.add('dark');
       document.documentElement.classList.remove('remove')
    }
    else{
       document.documentElement.classList.remove('dark')
       document.documentElement.classList.add('hero');  
    }
  },[mode])

  const [currentImage, setCurrentImage] = useState(erp);
  const [isFadingOut, setIsFadingOut] = useState(false);
  const images = [erp, anotherImage];

  useEffect(() => {
      const intervalId = setInterval(() => {
          setIsFadingOut(true); 
          setTimeout(() => {
              setCurrentImage((prevImage) => (prevImage === images[0] ? images[1] : images[0]));
              setIsFadingOut(false);
          }, 500); 
      }, 2000);  

      return () => clearInterval(intervalId);
  }, []);

  return (
    <div className='flex  w-full max-h-[75%] flex-wrap md:flex-row flex-col-reverse md:justify-center items-center gap-36 py-[120px]  relative -z-10 dark:bg-[#02042B] overflow-hidden'>  
      <div className='w-full md:w-1/3 mb-4 md:mb-0 px-4 h-[220px]'>          
          <p className='text-2xl text-blue-400 font-bold text-center md:text-left'>Empower your business with</p>
          <h1 className='text-3xl font-bold text-black dark:text-white tracking-widest text-center md:text-left'>Enterprise Resource Planning System Software</h1>
          <p className='text-xl md:text-2xl font-bold text-black dark:text-white  text-center md:text-left'>
              ERP has 3 core modules : <ReactTyped className='font-bold text-blue-400' strings={['HRM','CRM','EMS']} typeSpeed={120} backSpeed={140} loop/>
          </p>
      </div>
      <div className='w-full md:w-1/3 h-[220px] overflow-hidden'>  
          <img src={currentImage} alt="ERP System" className={` mx-auto transition-opacity duration-500 ${isFadingOut ? 'opacity-0' : 'opacity-100'}`} />
      </div>
    </div>
  )
}

export default Hero

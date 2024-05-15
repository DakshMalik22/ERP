import React, { useEffect } from 'react'
import { useState } from 'react'
import {AiOutlineClose , AiOutlineMenu} from 'react-icons/ai'
import { FaSun } from "react-icons/fa";
import { FaMoon } from "react-icons/fa";
import { useDispatch, useSelector } from 'react-redux';
import { setMode} from '../store/themeReducer';
import { Link } from 'react-router-dom';

const Navbar = () => {

  const dispatch = useDispatch();
  const mode = useSelector(state => state.theme.mode);

  const [nav,setNav] = useState(true);

  //checking if window theme is dark
  // useEffect(()=>{
  //   if(window.matchMedia('(prefers-color-scheme:dark)').matches){
  //      dispatch(setMode('dark'));
  //   }
  //   else{
  //      dispatch(setMode('light'));
  //   }
  // },[])


  useEffect(()=>{
    if(mode==='dark'){
       document.documentElement.classList.add('dark');
    }
    else{
       document.documentElement.classList.remove('dark')
    }
  },[mode])

  const handleNav = ()=>{
     setNav(!nav)
  }

  const handleMode = ()=>{
    const newMode = mode=='dark'?'light':'dark';
    dispatch(setMode(newMode));
  }

  return ( 
    <div className='flex justify-between items-center max-w-[100vw]  mx-auto px-4  text-black bg-white dark:bg-[#02042B]  dark:text-white shadow-md overflow-hidden sticky top-0 z-[999] shadow-custom'>
      <div className="mx-6 my-3 cursor-pointer">
        <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" viewBox="0 0 458.823 500.824">
        <g id="Group_1496" data-name="Group 1496" transform="translate(-990.042 -37.085)">
            <g id="Group_1" data-name="Group 1" transform="translate(990.042 37.085)">
            <path id="Path_2" data-name="Path 2" d="M314.8-441.806c-104.335,70.813-100.534,155.833,56.066,127.578,162.012-22.946,275.758-109.011,210.191-167.622,119.466,35.084-11.36,179.519-191.177,210.862-256.786,45.257-240.042-86.35-75.08-170.817" transform="translate(-178.542 556.935)"   fill={mode === 'dark' ? 'white' : '#0557A9'}
          fillRule="evenodd"/>
            <path id="Path_3" data-name="Path 3" d="M186.278-292.2c189.479,51.451,355.773-7.44,458.823-139.531-16.989,30.45-40.479,60.9-77.86,91.351l46.577,93.23H540.131L515.1-299.082c-60.282,34.471-122.322,50-186.311,44.427l-.694,9.385H250.93l11.819-19.4a305.575,305.575,0,0,1-76.471-27.53" transform="translate(-186.278 600.671)" fillRule="evenodd" fill={mode === 'dark' ? 'white' : 'black'}/>
            <path id="Path_4" data-name="Path 4" d="M246.018-285.432l75.082-4.38L369.067-393.68l37.54,83.22,57.007-24.4L371.152-521.948Z" transform="translate(-121.58 521.948)" fill={mode === 'dark' ? 'white' : '#0557A9'} fillRule="evenodd"/>
            </g>
            <text id="Avisoft" transform="translate(1424.201 481.909)" fill={mode === 'dark' ? 'white' : 'black'} fontSize="100" fontFamily="Dubai-Bold, Dubai" fontWeight="700" letterSpacing="0.11em"><tspan x="-370.9" y="0" fill={mode === 'dark' ? 'white' : '#0557A9'}>Avisoft</tspan></text>
        </g>
        </svg>
        </div>
        <div className='hidden md:flex'>
            <Link className='p-4 cursor-pointer' to="/"><button>Home</button></Link>
            <Link className='p-4 cursor-pointer' to="/hrmLogin"><button>HRM</button></Link>
            <Link className='p-4 cursor-pointer' to="/crmLogin"><button>CRM</button></Link>
            <Link className='p-4 cursor-pointer' to="/emsLogin"><button>EMS</button></Link>
            <Link onClick={handleMode} className='cursor-pointer p-4 text-2xl'>
              {mode=='dark'?<FaSun />:<FaMoon/>}
            </Link>
        </div>
        <div onClick={handleNav} className='block md:hidden'> 
          {!nav ? <AiOutlineClose size={20}/> : <AiOutlineMenu size={20}/>}  
        </div> 
         <div className={!nav ? 'fixed left-0 top-0 w-[60%] rounded-r border-r-gray-900 h-full bg-white dark:bg-black ease-in-out duration-300': 'fixed left-[-100%]'} >
         <div className="m-8">
         <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" viewBox="0 0 458.823 500.824">
        <g id="Group_1496" data-name="Group 1496" transform="translate(-990.042 -37.085)">
            <g id="Group_1" data-name="Group 1" transform="translate(990.042 37.085)">
            <path id="Path_2" data-name="Path 2" d="M314.8-441.806c-104.335,70.813-100.534,155.833,56.066,127.578,162.012-22.946,275.758-109.011,210.191-167.622,119.466,35.084-11.36,179.519-191.177,210.862-256.786,45.257-240.042-86.35-75.08-170.817" transform="translate(-178.542 556.935)"   fill={mode === 'dark' ? 'white' : '#0557A9'}
          fillRule="evenodd"/>
            <path id="Path_3" data-name="Path 3" d="M186.278-292.2c189.479,51.451,355.773-7.44,458.823-139.531-16.989,30.45-40.479,60.9-77.86,91.351l46.577,93.23H540.131L515.1-299.082c-60.282,34.471-122.322,50-186.311,44.427l-.694,9.385H250.93l11.819-19.4a305.575,305.575,0,0,1-76.471-27.53" transform="translate(-186.278 600.671)" fillRule="evenodd" fill={mode === 'dark' ? 'white' : 'black'}/>
            <path id="Path_4" data-name="Path 4" d="M246.018-285.432l75.082-4.38L369.067-393.68l37.54,83.22,57.007-24.4L371.152-521.948Z" transform="translate(-121.58 521.948)" fill={mode === 'dark' ? 'white' : '#0557A9'} fillRule="evenodd"/>
            </g>
            <text id="Avisoft" transform="translate(1424.201 481.909)" fill={mode === 'dark' ? 'white' : 'black'} fontSize="100" fontFamily="Dubai-Bold, Dubai" fontWeight="700" letterSpacing="0.11em"><tspan x="-370.9" y="0" fill={mode === 'dark' ? 'white' : '#0557A9'}>Avisoft</tspan></text>
        </g>
        </svg>
        </div>
          <div className='uppercase p-4 flex flex-col'>
            <Link className='p-4 border-b border-black  dark:border-gray-100' to="/"><button>Home</button></Link>
            <Link className='p-4 border-b border-black  dark:border-gray-100' to="/hrmLogin"><button>HRM</button></Link>
            <Link className='p-4 border-b border-black  dark:border-gray-100' to="/crmLogin"><button>CRM</button></Link>
            <Link className='p-4 border-b border-black  dark:border-gray-100' to="/emsLogin"><button>EMS</button></Link>
            <Link onClick={handleMode} className='cursor-pointer p-4 text-2xl'>
              {mode=='dark'?<FaSun />:<FaMoon/>}
            </Link>
        </div>
         </div>
      </div>
  )
}

export default Navbar;
